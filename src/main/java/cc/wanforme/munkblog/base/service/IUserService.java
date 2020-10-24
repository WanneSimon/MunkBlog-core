package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表（不实现评论和留言，但是保留） 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IUserService extends IService<User> {

	/** 用户名查询*/
	User selectByUsername(String username);
	
}
