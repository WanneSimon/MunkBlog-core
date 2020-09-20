package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cc.wanforme.munkblog.action.service.BlogMunkService;
import cc.wanforme.munkblog.vo.blog.BlogResultVo;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;

/**博文控制器
 * @author wanne
 * 2020年9月20日
 */
@Controller
@RequestMapping("/blog")
public class BlogMunkController {
	
	@Autowired
	private BlogMunkService blogMunkService;
	
	@RequestMapping
	@PostMapping("/search")
	public BlogResultVo searchBlogs(@RequestParam BlogSearchVo queryVo) {
		return blogMunkService.searchBlogs(queryVo);
	}
	
}
