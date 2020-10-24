package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表（不实现评论和留言，但是保留） Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface UserMapper extends BaseMapper<User> {

	/** 用户名查询*/
	User selectByUsername(String username);
	
}
