package cc.wanforme.munkblog.action.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.entity.Blog;
import cc.wanforme.munkblog.base.entity.BlogQuotation;
import cc.wanforme.munkblog.base.service.IBlogQuotationService;
import cc.wanforme.munkblog.base.service.IBlogService;
import cc.wanforme.munkblog.base.service.IMunkTagService;
import cc.wanforme.munkblog.vo.blog.BlogResultRecorder;
import cc.wanforme.munkblog.vo.blog.BlogResultVo;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;
import cc.wanforme.munkblog.vo.blog.BlogVo;

/**
 * @author wanne
 * 2020年9月20日
 */
@Service
public class BlogMunkService {
	
	@Autowired
	private IBlogService blogService;
	@Autowired
	private IBlogQuotationService blogQuotationService;
	@Autowired
	private IMunkTagService tagService;
	
	// 分页查询
	public BlogResultVo searchBlogs(BlogSearchVo searchVo) {
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
		
		return resultVo;
	}

	
	// 具体查询某一篇信息
	public BlogVo queryBlog(int blogId) {
		Blog blog = blogService.getById(blogId);
		if(blog==null) {
			return null;
		}
		
		// 标签
//		tagService.selectTags(type, objectId, valid)
		
		// 引用
		List<BlogQuotation> quotations = blogQuotationService.selectByBlog(blogId);
		
		return null;
	}
	
	
	
	// 博文搜索
	
}
