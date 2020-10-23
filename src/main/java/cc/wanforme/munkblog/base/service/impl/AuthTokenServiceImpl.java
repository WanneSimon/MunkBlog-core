package cc.wanforme.munkblog.base.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cc.wanforme.munkblog.base.entity.AuthToken;
import cc.wanforme.munkblog.base.mapper.AuthTokenMapper;
import cc.wanforme.munkblog.base.service.IAuthTokenService;

/**
 * @author wanne
 * 2020年10月23日
 */
@Service
public class AuthTokenServiceImpl extends ServiceImpl<AuthTokenMapper, AuthToken> implements IAuthTokenService{

	@Override
	public AuthToken selecToken(String token) {
		return this.baseMapper.selecToken(token);
	}

	@Override
	public AuthToken selecUserToken(int userId) {
		return this.baseMapper.selectUserToken(userId);
	}

}
