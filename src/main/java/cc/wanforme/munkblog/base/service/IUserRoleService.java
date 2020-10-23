package cc.wanforme.munkblog.base.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cc.wanforme.munkblog.base.entity.UserRole;

/**
 * @author wanne
 * 2020年10月23日
 */
public interface IUserRoleService extends IService<UserRole>{

	/**获取用户的所有角色
	 * @param userId
	 * @return
	 */
	List<UserRole> selectRoles(int userId);
	
}
