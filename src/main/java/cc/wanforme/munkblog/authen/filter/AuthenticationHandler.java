//package cc.wanforme.munkblog.authen.filter;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import cc.wanforme.munkblog.base.constant.ResCode;
//import cc.wanforme.munkblog.util.JsonUtil;
//import cc.wanforme.munkblog.vo.ResMessage;
//
///**
// * @author wanne
// * 2020年10月24日
// */
//public class AuthenticationHandler implements AuthenticationFailureHandler, AuthenticationSuccessHandler{
//
//	@Override
//	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException exception) throws IOException, ServletException {
//		ResMessage res = ResMessage.newMessage(ResCode.PREMISSION_DENY, ResCode.PREMISSION_DENY.getDescription(), null);
//		
//		response.getWriter().write(JsonUtil.toJsonString(res));
//	}
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		System.out.println(authentication.isAuthenticated());
//	}
//
//	
//}
