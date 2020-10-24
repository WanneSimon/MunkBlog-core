package cc.wanforme.munkblog.authen.service;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.wanforme.munkblog.base.entity.AuthToken;
import cc.wanforme.munkblog.base.service.IAuthTokenService;
import cc.wanforme.munkblog.properties.TokenProperty;

/** token 信息
 * @author wanne
 * 2020年10月23日
 */
@Service
public class MTokenService {

	@Autowired
	private IAuthTokenService tokenBaseService;
	
	@Autowired
	private TokenProperty tokenProperties;
	
	
	/** 根据token查询对应的信息
	 * @param token
	 * @return
	 */
	public AuthToken selectToken(String token) {
		return tokenBaseService.selecToken(token);
	}
	
	/** 生成和保存 token，并返回token对象
	 * @param userId
	 * @param request
	 * @return
	 */
	public AuthToken generateAndSaveToken(int userId, HttpServletRequest request, HttpServletResponse response) {
		String token = UUID.randomUUID().toString();
		LocalDateTime createTime = LocalDateTime.now();
		LocalDateTime expiredTime = createTime.plusDays(tokenProperties.getExpireDays());

		AuthToken authToken = new AuthToken();
		authToken.setUserId(userId);
		authToken.setToken(token);
		authToken.setHost(request.getRemoteHost());
		authToken.setCreateTime(createTime);
		authToken.setExpireTime(expiredTime);
		
		AuthToken po = tokenBaseService.selecUserToken(userId);
		if(po == null) {
			tokenBaseService.save(authToken);
		} else {
			authToken.setId(po.getId());
			tokenBaseService.updateById(authToken);
		}
		
		// 设置 cookie
		Cookie cookie = new Cookie(tokenProperties.getName(), token);
		cookie.setMaxAge(tokenProperties.getExpireDays() * 24 *3600);
		response.addCookie(cookie);
		
		return authToken;
	}
	
	/** 检查 token 是否还有效
	 * @param token
	 * @return
	 */
	public boolean isValid(AuthToken token) {
		LocalDateTime now = LocalDateTime.now();
		return token.getExpireTime().isAfter(now);
	}
	
}
