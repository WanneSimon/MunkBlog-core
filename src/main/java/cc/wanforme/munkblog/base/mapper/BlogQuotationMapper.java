package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.BlogQuotation;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 博文引用 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface BlogQuotationMapper extends BaseMapper<BlogQuotation> {

	List<BlogQuotation> selectByBlog(int blogId);

}
