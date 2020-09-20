package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.BlogQuotation;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 博文引用 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IBlogQuotationService extends IService<BlogQuotation> {
	
	List<BlogQuotation> selectByBlog(int blogId);
	
}
