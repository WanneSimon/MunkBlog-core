package cc.wanforme.munkblog.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.vo.ResMessage;

/** 全局异常处理类
 * @author wanne
 * 2020年9月21日
 */
@ControllerAdvice
//@ControllerAdvice(basePackages = "cc.wanforme.munkblog") //指定包
@ResponseBody
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResMessage invalidArgumentsException(HttpServletRequest request,
			IllegalArgumentException e) {
		log.error(e.getMessage(), e);
		
		return ResMessage.newFailMessage(e.getMessage());
	}
	
	
	
}
