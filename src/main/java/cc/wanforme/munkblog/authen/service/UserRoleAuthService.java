package cc.wanforme.munkblog.authen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cc.wanforme.munkblog.authen.dto.UserRoleAuth;
import cc.wanforme.munkblog.base.entity.AuthToken;
import cc.wanforme.munkblog.base.entity.RoleAuth;
import cc.wanforme.munkblog.base.entity.UserRole;
import cc.wanforme.munkblog.base.service.IRoleAuthService;
import cc.wanforme.munkblog.base.service.IUserRoleService;

/** 查询用户的角色和对应的权限
 * @author wanne
 * 2020年10月23日
 */
@Service
public class UserRoleAuthService {

	@Autowired
	private MTokenService tokenBizService;
	@Autowired
	private IUserRoleService roleService;
	@Autowired
	private IRoleAuthService authService;
	
	/** 获取用户的角色和权限（建议加入换成）
	 * @param userId
	 * @return
	 */
//	@Cacheable("useRoleAuth")
	public UserRoleAuth selectAuthenticationsByUser(int userId) {
		UserRoleAuth re = new UserRoleAuth();
		List<UserRole> roles = roleService.selectRoles(userId);
		
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
		AuthToken authToken = tokenBizService.selecToken(token);
		Assert.notNull(authToken, "登录信息已过期");
		
		return this.selectAuthenticationsByUser(authToken.getUserId());
	}
	
}
