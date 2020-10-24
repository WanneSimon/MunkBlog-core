package cc.wanforme.munkblog.authen.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cc.wanforme.munkblog.authen.dto.UserRoleAuth;
import cc.wanforme.munkblog.base.entity.AuthToken;
import cc.wanforme.munkblog.base.entity.RoleAuth;
import cc.wanforme.munkblog.base.entity.User;
import cc.wanforme.munkblog.base.entity.UserRole;
import cc.wanforme.munkblog.base.service.IRoleAuthService;
import cc.wanforme.munkblog.base.service.IUserRoleService;
import cc.wanforme.munkblog.base.service.IUserService;

/** 查询用户的角色和对应的权限
 * @author wanne
 * 2020年10月23日
 */
@Service
public class UserRoleAuthService {

	@Autowired
	private MTokenService mTokenService;
	@Autowired
	private IUserRoleService roleService;
	@Autowired
	private IRoleAuthService authService;
	@Autowired
	private IUserService userService;
	
	/** 获取用户的角色和权限（建议加入缓存）<br>
	 * 注：没有查询 User 信息
	 * @param userId
	 * @return
	 */
//	@Cacheable("useRoleAuth")
	public UserRoleAuth selectAuthenticationsByUser(int userId) {
		UserRoleAuth re = new UserRoleAuth();
		List<UserRole> roles = roleService.selectRoles(userId);
		User user = userService.getById(userId);
		
		Assert.notNull(user, "未查到此用户");
		re.setUser(user);
		
		if(roles==null) {
			return re;
		}
		
		for (UserRole role : roles) {
			List<RoleAuth> auths = authService.selectAuth(role.getRole());
			if(auths == null) {
				auths = new ArrayList<>(0);
			}
			re.getRoleAuth().put(role, auths);
		}
		
		return re;
	}
	
	/** 根据 token 查出对应用户的角色和权限<br> 
	 * token 不存在时，会跑出异常
	 * @param token
	 * @return
	 */
	public UserRoleAuth selectAuthenticationsByToken(String token) {
		AuthToken authToken = mTokenService.selectToken(token);
		Assert.notNull(authToken, "登录信息已过期");
		
		return this.selectAuthenticationsByUser(authToken.getUserId());
	}
	
	/** 添加验证信息*/
	public void setAuthentications(UserRoleAuth roleAuth) {
		Set<SimpleGrantedAuthority> authorities = new TreeSet<>(Comparator.comparing(sga -> sga.getAuthority()));
		
		Iterator<Entry<UserRole, List<RoleAuth>>> iterator = roleAuth.getRoleAuth().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<UserRole, List<RoleAuth>> entry = iterator.next();
			
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
			
			List<SimpleGrantedAuthority> tempAuth = entry.getValue().stream()
					.map(RoleAuth::getPermission)
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
			authorities.addAll(tempAuth);
		}
		
		// 设置授权信息
		UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(roleAuth.getUser().getName(),
				roleAuth.getUser().getPassword(), authorities);
		SecurityContextHolder.getContext().setAuthentication(upat);
	}
	
	/**
	 * 清除验证信息
	 */
	public void clearLoginAuthentications() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}
	
	/** 检查是否已经添加了验证信息
	 * @return
	 */
	public boolean isAuthenticattionAdded(){
		return SecurityContextHolder.getContext().getAuthentication() != null;
	}
	
}
