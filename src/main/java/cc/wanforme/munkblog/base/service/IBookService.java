package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.Book;
import cc.wanforme.munkblog.vo.book.BookSearchVo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 书 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IBookService extends IService<Book> {

	PageInfo<Book> selectBooks(BookSearchVo searchVo);
	
}
