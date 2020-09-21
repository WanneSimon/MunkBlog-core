package cc.wanforme.munkblog.action.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.constant.MunkObjectEnum;
import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.Blog;
import cc.wanforme.munkblog.base.entity.BlogQuotation;
import cc.wanforme.munkblog.base.entity.MunkTag;
import cc.wanforme.munkblog.base.service.IBlogQuotationService;
import cc.wanforme.munkblog.base.service.IBlogService;
import cc.wanforme.munkblog.base.service.IMunkTagService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.blog.BlogResultRecorder;
import cc.wanforme.munkblog.vo.blog.BlogResultVo;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;
import cc.wanforme.munkblog.vo.blog.BlogVo;

/**
 * @author wanne
 * 2020年9月20日
 */
@Service
public class MBlogService {
	
	@Autowired
	private IBlogService blogService;
	@Autowired
	private IBlogQuotationService blogQuotationService;
	@Autowired
	private IMunkTagService tagService;
	
	// 分页查询
	public ResMessage searchBlogs(BlogSearchVo searchVo) {
		BlogResultVo resultVo = new BlogResultVo();
		resultVo.setPage(searchVo.getPage());
		resultVo.setSize(searchVo.getSize());
		
		// 总页码
//		int total = blogService.queryTotoal(searchVo);
//		int totalPage = (int) Math.ceil( total*1.0 / searchVo.getSize());
//		resultVo.setTotalPage(totalPage);
		
		// 数据
//		List<BlogResultRecorder> blogsRecorders = blogService.queryBlogs(searchVo);
		PageInfo<BlogResultRecorder> blogs = blogService.queryBlogs(searchVo);
		resultVo.setDatas(blogs.getList());
		
		return ResMessage.newSuccessMessage(resultVo);
	}

	
	// 具体查询某一篇信息
	public ResMessage queryBlog(int blogId) {
		Blog blog = blogService.getById(blogId);
		if(blog==null) {
			return ResMessage.newFailMessage("未查到此文章", null);
		}
		
		// 标签
		List<MunkTag> tags = tagService.selectTags(MunkObjectEnum.BLOG, blogId, ValidEnum.VALID);
		
		// 引用
		List<BlogQuotation> quotations = blogQuotationService.selectByBlog(blogId);
		
		BlogVo bv = new BlogVo();
		BeanUtils.copyProperties(blog, bv);
		bv.setTags(tags);
		bv.setQuotations(quotations);
		
		return ResMessage.newSuccessMessage(bv);
	}
	
	
	// 博文搜索
	
	
}
