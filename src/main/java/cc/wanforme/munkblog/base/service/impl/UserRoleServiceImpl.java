package cc.wanforme.munkblog.base.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cc.wanforme.munkblog.base.entity.UserRole;
import cc.wanforme.munkblog.base.mapper.UserRoleMapper;
import cc.wanforme.munkblog.base.service.IUserRoleService;

/**
 * @author wanne
 * 2020年10月23日
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService{

	/**获取用户的所有角色
	 * @param userId
	 * @return
	 */
	@Override
	public List<UserRole> selectRoles(int userId){
		return this.baseMapper.selectRoles(userId);
	}
	
}
