package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.BookmarkFolder;
import cc.wanforme.munkblog.vo.SearchVo;
import cc.wanforme.munkblog.vo.bookmark.BookmarkFolderSearchVo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 书签文件夹 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-20
 */
public interface IBookmarkFolderService extends IService<BookmarkFolder> {

	/**搜索书签文件夹*/
	PageInfo<BookmarkFolder> searchBookmarkFolders(BookmarkFolderSearchVo searchVo);
	
	/**获取书签文件夹下的书签*/
	PageInfo<BookmarkFolder> selectBookmarkFolders(BookmarkFolderSearchVo searchVo);
	
	/** 获取所有的书签文件夹*/
	PageInfo<String> selectAllValidFolders(SearchVo searchVo);
}
