package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MBookService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.book.BookSearchVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Controller
@RequestMapping("/api/book")
public class MBookController {

	@Autowired
	private MBookService bookService;
	
	@RequestMapping
	@PostMapping("/search")
	@ResponseBody
	public ResMessage searchBook(@RequestBody BookSearchVo searchVo) {
		return bookService.searchBook(searchVo);
	}
	
}
