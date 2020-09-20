package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.BlogQuotation;
import cc.wanforme.munkblog.base.mapper.BlogQuotationMapper;
import cc.wanforme.munkblog.base.service.IBlogQuotationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 博文引用 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class BlogQuotationServiceImpl extends ServiceImpl<BlogQuotationMapper, BlogQuotation> implements IBlogQuotationService {

	@Override
	public List<BlogQuotation> selectByBlog(int blogId) {
		return this.baseMapper.selectByBlog(blogId);
	}

}
