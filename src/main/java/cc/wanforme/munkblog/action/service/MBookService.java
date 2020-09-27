package cc.wanforme.munkblog.action.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.entity.Book;
import cc.wanforme.munkblog.base.service.IBookService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.book.BookSearchVo;
import cc.wanforme.munkblog.vo.book.BookVo;


/**
 * @author wanne
 * 2020年9月21日
 */
@Service
public class MBookService {
	
	@Autowired
	private IBookService bookService;
	
	public ResMessage searchBook(BookSearchVo searchVo) {
		PageInfo<Book> data = bookService.selectBooks(searchVo);
		return ResMessage.newSuccessMessage(data);
	}
	
	public ResMessage addBook(BookVo bookVo) {
		
		return null;
	}
	
	public ResMessage updateBook(BookVo bookVo) {
		
		return null;
	}
	
	public ResMessage deleteBook(BookVo bookVo) {
		
		return null;
	}
}
