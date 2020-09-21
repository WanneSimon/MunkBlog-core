package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MBlogService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;

/**博文控制器
 * @author wanne
 * 2020年9月20日
 */
@Controller
@RequestMapping("/blog")
public class MBlogController {
	
	@Autowired
	private MBlogService blogMunkService;
	
	@PostMapping("/search")
	@ResponseBody
	public ResMessage searchBlogs(@RequestParam BlogSearchVo queryVo) {
		return blogMunkService.searchBlogs(queryVo);
	}
	
	@PostMapping("/info")
	@ResponseBody
	public ResMessage blogInfo(@RequestParam int blogId) {
		return blogMunkService.queryBlog(blogId);
	}
	
}