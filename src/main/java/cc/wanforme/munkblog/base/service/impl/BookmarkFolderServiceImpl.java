package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.BookmarkFolder;
import cc.wanforme.munkblog.base.mapper.BookmarkFolderMapper;
import cc.wanforme.munkblog.base.service.IBookmarkFolderService;
import cc.wanforme.munkblog.vo.SearchVo;
import cc.wanforme.munkblog.vo.bookmark.BookmarkFolderSearchVo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 书签文件夹 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-20
 */
@Service
public class BookmarkFolderServiceImpl extends ServiceImpl<BookmarkFolderMapper, BookmarkFolder> implements IBookmarkFolderService {

	@Override
	public PageInfo<BookmarkFolder> searchBookmarkFolders(BookmarkFolderSearchVo searchVo) {
		PageHelper.startPage(searchVo.getPage(), searchVo.getSize());
		List<BookmarkFolder> data = this.baseMapper.searchBookmarkFolders(searchVo);
		return new PageInfo<BookmarkFolder>(data);
	}

	@Override
	public PageInfo<BookmarkFolder> selectBookmarkFolders(BookmarkFolderSearchVo searchVo) {
		PageHelper.startPage(searchVo.getPage(), searchVo.getSize());
		List<BookmarkFolder> data = this.baseMapper.selectBookmarkFolders(searchVo);
		return new PageInfo<BookmarkFolder>(data);
	}

	@Override
	public PageInfo<String> selectAllValidFolders(SearchVo searchVo) {
		PageHelper.startPage(searchVo.getPage(), searchVo.getSize());
		List<String> data = this.baseMapper.selectAllValidFolders();
		return new PageInfo<String>(data);
	}
	
}
