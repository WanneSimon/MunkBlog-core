package cc.wanforme.munkblog.base.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cc.wanforme.munkblog.base.entity.RoleAuth;

/**
 * @author wanne
 * 2020年10月23日
 */
public interface IRoleAuthService extends IService<RoleAuth>{

	/** 查询角色的权限*/
	List<RoleAuth> selectAuth(String role);
	
}
