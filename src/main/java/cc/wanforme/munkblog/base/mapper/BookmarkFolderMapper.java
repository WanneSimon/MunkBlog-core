package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.BookmarkFolder;
import cc.wanforme.munkblog.vo.bookmark.BookmarkFolderSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 书签文件夹 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-20
 */
public interface BookmarkFolderMapper extends BaseMapper<BookmarkFolder> {

	/**搜索书签文件夹*/
	List<BookmarkFolder> searchBookmarkFolders(BookmarkFolderSearchVo searchVo);

	/**获取书签文件夹下的书签*/
	List<BookmarkFolder> selectBookmarkFolders(BookmarkFolderSearchVo searchVo);
	
	/** 获取所有的书签文件夹*/
	List<String> selectAllValidFolders();
	
}
