package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Book;
import cc.wanforme.munkblog.base.mapper.BookMapper;
import cc.wanforme.munkblog.base.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-17
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
