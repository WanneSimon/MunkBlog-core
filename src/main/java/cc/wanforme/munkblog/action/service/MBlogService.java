package cc.wanforme.munkblog.action.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.constant.EditorEnum;
import cc.wanforme.munkblog.base.constant.ObjectTypeEnum;
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
		List<MunkTag> tags = tagService.selectTags(ObjectTypeEnum.BLOG, blogId, ValidEnum.VALID);
		
		// 引用
		List<BlogQuotation> quotations = blogQuotationService.selectByBlog(blogId);
		
		BlogVo bv = new BlogVo();
		BeanUtils.copyProperties(blog, bv);
		bv.setTags(tags);
		bv.setQuotations(quotations);
		
		return ResMessage.newSuccessMessage(bv);
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public ResMessage saveBlog(BlogVo blogVo) {
		Assert.notNull(blogVo, "没有数据");
		Assert.notNull(blogVo.getTitle(), "没有标题");
		Assert.notNull(blogVo.getContent(), "没有内容");
		Assert.notNull(blogVo.getContent(), "没有归类");
		
		LocalDateTime now = LocalDateTime.now();
		
		Blog blog = new Blog();
		BeanUtils.copyProperties(blogVo, blog);
		if(blog.getEditor() == null) {
			blog.setEditor(EditorEnum.DEFAULT.getCode());
		}
		blog.setId(null);
		blog.setValid(ValidEnum.VALID.getCode());
		blog.setCreateTime(now);
		blog.setUpdateTime(now);
		
		this.blogService.save(blog);
		
		// 标签
		if(blogVo.getTags()!=null) {
			for (MunkTag tag : blogVo.getTags()) {
				Assert.notNull(tag.getTagName(), "标签名为空");
				tag.setId(null);
				tag.setObjectId(blog.getId());
//				Assert.notNull(tag.getType(), "所属对象类型不能为空");
				tag.setType(ObjectTypeEnum.BLOG.getCode());
				tag.setValid(ValidEnum.VALID.getCode());
				this.tagService.save(tag);
			}
		}
		
		// 引用
		if(blogVo.getQuotations() != null) {
			for (BlogQuotation quotation : blogVo.getQuotations()) {
				Assert.notNull(quotation.getName(), "引用名为空");
				Assert.notNull(quotation.getLink(), "\""+quotation.getName()+"\" 的链接为空");
				quotation.setBlogId(blog.getId());
				this.blogQuotationService.save(quotation);
			}
		}
		
		return ResMessage.newSuccessMessage("保存成功");
	}
	
	
}
