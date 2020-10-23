package cc.wanforme.munkblog.base.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cc.wanforme.munkblog.base.entity.RoleAuth;

/**
 * @author wanne
 * 2020年10月23日
 */
public interface RoleAuthMapper extends BaseMapper<RoleAuth>{
	
	/** 查询角色的权限*/
	List<RoleAuth> selectAuth(String role);
	
}
