package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Bookmark;
import cc.wanforme.munkblog.base.mapper.BookmarkMapper;
import cc.wanforme.munkblog.base.service.IBookmarkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书签 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class BookmarkServiceImpl extends ServiceImpl<BookmarkMapper, Bookmark> implements IBookmarkService {

}
