package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MBlogService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;
import cc.wanforme.munkblog.vo.blog.BlogVo;

/**博文控制器
 * @author wanne
 * 2020年9月20日
 */
@Controller
@RequestMapping("/api/blog")
public class MBlogController {
	
	@Autowired
	private MBlogService blogMunkService;
	
	@PostMapping("/search")
	@ResponseBody
	public ResMessage searchBlogs(@RequestBody BlogSearchVo queryVo) {
		return blogMunkService.searchBlogs(queryVo);
	}
	
	@PostMapping("/get")
	@ResponseBody
	public ResMessage blogInfo(@RequestBody BlogVo blogVo) {
		return blogMunkService.queryBlog(blogVo.getId());
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasAuthority('blog_add')")
	@ResponseBody
	public ResMessage addBlog(@RequestBody BlogVo blogVo) {
		return blogMunkService.addBlog(blogVo);
	}
	
	@PostMapping("/update")
	@PreAuthorize("hasAuthority('blog_update')")
	@ResponseBody
	public ResMessage updateBlog(@RequestBody BlogVo blogVo) {
		return blogMunkService.updateBlog(blogVo);
	}

	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('blog_update')")
	@ResponseBody
	public ResMessage deleteBlog(@RequestBody int blogId) {
		return blogMunkService.deleteBlog(blogId);
	}
	
}
