package cc.wanforme.munkblog.base.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cc.wanforme.munkblog.base.entity.UserRole;

/**
 * @author wanne
 * 2020年10月23日
 */
public interface UserRoleMapper extends BaseMapper<UserRole>{

	/**获取用户的所有角色
	 * @param userId
	 * @return
	 */
	List<UserRole> selectRoles(int userId);
	
}
