package cc.wanforme.munkblog.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cc.wanforme.munkblog.base.entity.AuthToken;

/**
 * @author wanne
 * 2020年10月23日
 */
public interface AuthTokenMapper extends BaseMapper<AuthToken>{

	/** 查询 token的信息
	 * @param token
	 * @return
	 */
	AuthToken selecToken(String token);
	
	/** 获取用户的token*/
	AuthToken selectUserToken(int userId);
}
