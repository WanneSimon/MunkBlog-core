package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.Book;
import cc.wanforme.munkblog.vo.book.BookSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 书 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface BookMapper extends BaseMapper<Book> {
	
	List<Book> selectBooks(BookSearchVo searchVo);

}
