package cc.wanforme.munkblog.base.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cc.wanforme.munkblog.base.po.User;


/**
 * 用户dao
 * @author wanne
 * 2019年10月02日
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{
	
	/** 获取用户, 通过id*/
	@Deprecated
	User getUser(long id);
	
}
