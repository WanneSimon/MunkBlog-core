package cc.wanforme.munkblog.action.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cc.wanforme.munkblog.authen.dto.UserRoleAuth;
import cc.wanforme.munkblog.authen.service.MTokenService;
import cc.wanforme.munkblog.authen.service.UserRoleAuthService;
import cc.wanforme.munkblog.base.entity.AuthToken;
import cc.wanforme.munkblog.base.entity.User;
import cc.wanforme.munkblog.base.service.IUserService;
import cc.wanforme.munkblog.properties.TokenProperty;
import cc.wanforme.munkblog.util.SealCodeUtil;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.UserVo;
import cc.wanforme.munkblog.vo.login.LoginVo;

/**
 * @author wanne
 * 2020年10月24日
 */
@Service
public class MLoginService {
	@Autowired
	private IUserService userService;
	@Autowired
	private MTokenService mtTokenService;
	@Autowired
	private UserRoleAuthService userRoleAuthService;
	@Autowired
	private TokenProperty tokenProperty;
	
	public ResMessage login(LoginVo vo, HttpServletRequest request, HttpServletResponse response) {
		Assert.notNull(vo.getUsername(), "未输入用户名");
		Assert.notNull(vo.getPassword(), "未输入密码");
		
		User user = userService.selectByUsername(vo.getUsername());
		
		if(user == null || !SealCodeUtil.verifyPassword(vo.getPassword(), user.getPassword())) {
			return ResMessage.newFailMessage("密码或用户名错误");
		}
		
		// 生成并保存 token
//		AuthToken authToken = mtTokenService.generateAndSaveToken(user.getId(), request);
		mtTokenService.generateAndSaveToken(user.getId(), request, response);
		
		// 清除并重新设置验证信息
		userRoleAuthService.clearLoginAuthentications(response);
		UserRoleAuth roleAuth = userRoleAuthService.selectAuthenticationsByUser(user.getId());
		userRoleAuthService.setAuthentications(roleAuth);
		
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		
		return ResMessage.newSuccessMessage("登录成功", userVo);
	}
	
	/** 注销*/
	public ResMessage logout(HttpServletRequest request, HttpServletResponse response) {
		userRoleAuthService.clearLoginAuthentications(response);
		// 未清除数据库
		return ResMessage.newSuccessMessage("退出成功", null);
	}
	
	/** 查询当前登录的所有权限，不会从数据库查
	 * @return
	 */
	public ResMessage currentPermession(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		List<String> list = new ArrayList<>(0);
		if( authorities!=null ) {
			list = authorities.stream().map(GrantedAuthority::getAuthority)
			.collect(Collectors.toList());
		}
		
		if( this.checkGuest(auth) ) {
			return ResMessage.newSuccessMessage("");
		}
		
		String principal = auth.getPrincipal().toString();
		User user = userService.selectByUsername(principal);
		if(user==null) {
			return ResMessage.newFailMessage("信息已过期，请重新登陆！");
		}
		
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		
		Map<String, Object> data = new HashMap<>(2);
		data.put("info", userVo);
		data.put("auth", list);
		return ResMessage.newSuccessMessage("查询成功", data);
	}
	
	private boolean checkGuest(Authentication auth) {
		String principal = auth.getPrincipal().toString(); // anonymousUser
		Object credentials = auth.getCredentials(); // 空字符串
		Collection<? extends GrantedAuthority> authorities2 = auth.getAuthorities(); // [ROLE_ANONYMOUS]
//		System.out.println(principal+credentials);
//		System.out.println(authorities2.toString());
		
		return "anonymousUser[ROLE_ANONYMOUS]".equals(principal+credentials+authorities2.toString());
	}
	
}
