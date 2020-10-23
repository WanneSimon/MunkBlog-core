package cc.wanforme.munkblog.base.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cc.wanforme.munkblog.base.entity.AuthToken;

/**
 * @author wanne
 * 2020年10月23日
 */
public interface IAuthTokenService extends IService<AuthToken>{

	/** 查询 token的信息
	 * @param token
	 * @return
	 */
	AuthToken selecToken(String token);
	
	/** 获取用户的token*/
	AuthToken selecUserToken(int userId);
	
}
