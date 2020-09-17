package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.User;
import cc.wanforme.munkblog.base.mapper.UserMapper;
import cc.wanforme.munkblog.base.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表（不实现评论和留言，但是保留） 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
