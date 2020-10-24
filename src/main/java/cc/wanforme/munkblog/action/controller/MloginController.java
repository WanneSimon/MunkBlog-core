package cc.wanforme.munkblog.action.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MLoginService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.login.LoginVo;

/**
 * @author wanne
 * 2020年10月24日
 */
@Controller
@RequestMapping("/api/i")
public class MloginController {

	@Autowired
	private MLoginService loginService;
	
	/** 登录*/
	@RequestMapping("/login")
	@ResponseBody
	public ResMessage login(@RequestBody LoginVo vo, HttpServletRequest request,
			HttpServletResponse response) {
		return loginService.login(vo, request, response);
	}

	@RequestMapping("/autoLogin")
	@ResponseBody
	public ResMessage autoLogin(HttpServletRequest request, HttpServletResponse response) {
		LoginVo vo = new LoginVo();
		vo.setUsername("wanne");
		vo.setPassword("test");
		vo.setRememberMe(false);
		return this.login(vo, request, response);
	}
	
	/** 验证测试*/
	@RequestMapping("/authTest")
	@PreAuthorize("hasRole('test')")
	@ResponseBody
	public ResMessage authTest() {
		return ResMessage.newSuccessMessage("authentication1 hasRole passed");
	}
	@RequestMapping("/authTest2")
	@PreAuthorize("hasAuthority('test')")
	@ResponseBody
	public ResMessage authTest2() {
		return ResMessage.newSuccessMessage("authentication2 hasAuthority passed");
	}	
	
	
}
