package cc.wanforme.munkblog.authen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.wanforme.munkblog.authen.dto.UserRoleAuth;
import cc.wanforme.munkblog.authen.service.MTokenService;
import cc.wanforme.munkblog.authen.service.UserRoleAuthService;
import cc.wanforme.munkblog.base.entity.AuthToken;

/** 记住我功能 service
 * @author wanne
 * 2020年10月23日
 */

public class MRememberMeFilter implements Filter{
	private static final Logger log = LoggerFactory.getLogger(MRememberMeFilter.class);
	
	private String cookieName;
	private MTokenService tokenService;
	private UserRoleAuthService userRoleAuthService;
	
	public MRememberMeFilter(String cookieName, MTokenService tokenService,
			UserRoleAuthService userRoleAuthService) {
		this.cookieName = cookieName;
		this.tokenService = tokenService;
		this.userRoleAuthService = userRoleAuthService;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String token = null;
		Cookie cookie = this.getCookie(cookieName, req);
		if( cookie != null && !"".equals(cookie.getValue())) {
			token = cookie.getValue();
		}
		
		try {
			// 存在 token，并且未添加验证信息（注意：登录的时候，一定要先清除验证信息）
			if( token != null && !userRoleAuthService.isAuthenticattionAdded()) {
				UserRoleAuth roleAuth = userRoleAuthService.selectAuthenticationsByToken(token);
				String host = req.getRemoteHost();
				
				// 检查 token 登陆地
				AuthToken tokenInfo = tokenService.selectToken(token);
				if( tokenInfo.getHost().equals(host) ) {
					userRoleAuthService.setAuthentications(roleAuth);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			userRoleAuthService.clearLoginAuthentications((HttpServletResponse)response);
		}
		
		chain.doFilter(request, response);
	}
	
	private Cookie getCookie(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
//				System.out.println(cookie.getName()+"\t"+cookie.getValue());
//				System.out.println();
				if(cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	public String getCookieName() {
		return cookieName;
	}
	public MTokenService getTokenService() {
		return tokenService;
	}
	public UserRoleAuthService getUserRoleAuthService() {
		return userRoleAuthService;
	}
}
