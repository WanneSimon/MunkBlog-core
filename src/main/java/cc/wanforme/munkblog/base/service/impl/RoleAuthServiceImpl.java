package cc.wanforme.munkblog.base.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cc.wanforme.munkblog.base.entity.RoleAuth;
import cc.wanforme.munkblog.base.mapper.RoleAuthMapper;
import cc.wanforme.munkblog.base.service.IRoleAuthService;

/**
 * @author wanne
 * 2020年10月23日
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthMapper, RoleAuth> implements IRoleAuthService{

	@Override
	public List<RoleAuth> selectAuth(String role) {
		return this.baseMapper.selectAuth(role);
	}

}
