package cc.wanforme.munkblog.action.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cc.wanforme.munkblog.authen.dto.UserRoleAuth;
import cc.wanforme.munkblog.authen.service.MTokenService;
import cc.wanforme.munkblog.authen.service.UserRoleAuthService;
import cc.wanforme.munkblog.base.entity.User;
import cc.wanforme.munkblog.base.service.IUserService;
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
	
}
