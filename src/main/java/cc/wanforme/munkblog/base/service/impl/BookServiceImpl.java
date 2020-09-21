package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Book;
import cc.wanforme.munkblog.base.mapper.BookMapper;
import cc.wanforme.munkblog.base.service.IBookService;
import cc.wanforme.munkblog.vo.book.BookSearchVo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 书 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

	@Override
	public PageInfo<Book> selectBooks(BookSearchVo searchVo) {
		PageHelper.startPage(searchVo.getPage(), searchVo.getSize());
		List<Book> data = this.baseMapper.selectBooks(searchVo);
		return new PageInfo<Book>(data);
	}

}
