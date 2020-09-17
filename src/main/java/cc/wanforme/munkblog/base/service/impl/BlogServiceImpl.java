package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Blog;
import cc.wanforme.munkblog.base.mapper.BlogMapper;
import cc.wanforme.munkblog.base.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博文 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-17
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
