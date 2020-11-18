package cc.wanforme.munkblog.action.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.entity.Bookmark;
import cc.wanforme.munkblog.base.entity.BookmarkFolder;
import cc.wanforme.munkblog.base.service.IBookmarkFolderService;
import cc.wanforme.munkblog.base.service.IBookmarkService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.SearchVo;
import cc.wanforme.munkblog.vo.bookmark.BookmarkFolderSearchVo;
import cc.wanforme.munkblog.vo.bookmark.BookmarkVo;

/**
 * @author wanne
 * 2020年11月18日
 */
@Service
public class MBookmarkService {

	@Autowired
	private IBookmarkFolderService folderService;
	@Autowired
	private IBookmarkService bookmarkService;
	
	/** 获取书签文件夹*/
	public PageInfo<String> selectAllValidFolders(SearchVo searchVo){
		return folderService.selectAllValidFolders(searchVo);
	}
	
	/** 获取书签*/
	public PageInfo<BookmarkVo> selectBookmars(BookmarkFolderSearchVo searchVo){
		Assert.notNull(searchVo, "缺少参数");
		Assert.hasText(searchVo.getFolder(), "没有书签文件夹");
		
		PageInfo<BookmarkFolder> bfsPageInfo = folderService.selectBookmarkFolders(searchVo);
		List<BookmarkFolder> bfs = bfsPageInfo.getList();
		
		List<BookmarkVo> bms = new ArrayList<>(10);
		if( bfs!=null && !bfs.isEmpty()) {
			for (BookmarkFolder bf : bfs) {
				Bookmark bm = bookmarkService.getById(bf.getBookmarkId());
				if(bm != null) {
					BookmarkVo bmVo = new BookmarkVo();
					BeanUtils.copyProperties(bm, bmVo);
					bmVo.setFolderId(bf.getId());
					bmVo.setFolder(bf.getFolder());
					bms.add(bmVo);
				}
			}
		}
		
		PageInfo<BookmarkVo> re = new PageInfo<BookmarkVo>();
		BeanUtils.copyProperties(bfsPageInfo, re, "list");
		re.setList(bms);
		return re;
	}
	
	/** 更新书签*/
	public ResMessage updateBookmark(BookmarkVo vo) {
		Assert.notNull(vo, "没有数据");
		Assert.notNull(vo.getId(), "缺少更新Id");
		
		Integer id = vo.getId();
		
		Bookmark po = bookmarkService.getById(id);
		if(po == null) {
			return ResMessage.newFailMessage("没有此书签");
		}
		
		BeanUtils.copyProperties(vo, po);
		bookmarkService.updateById(po);
		return ResMessage.newSuccessMessage("更新成功", null);
	}
	
	/** 获取标签*/
	public ResMessage selectBookmark(BookmarkVo vo) {
		if(vo == null || vo.getId() == null) {
			return ResMessage.newFailMessage("缺少信息");
		}
		
		Bookmark po = bookmarkService.getById(vo.getId());
		return ResMessage.newSuccessMessage("查询成功", po);
	}
	
	/** 更新书签文件夹<br>
	 * 根据 BookmarkFolder 的id更新的 文件夹名字和书签的id <br>
	 * 也就是说，可以更新 书签和书签所属文件夹*/
	public ResMessage updateBookmark(List<BookmarkVo> vos){
		if(vos == null || vos.isEmpty()) {
			return ResMessage.newFailMessage("没有数据");
		}
		
		boolean anyNull = vos.parallelStream()
			.anyMatch( e -> e.getId()==null);
		if(anyNull) {
			return ResMessage.newFailMessage("包含不确定的更新对象");
		}
		
		// 更新书签
		int count = 0;
		for (BookmarkVo vo : vos) {
			BookmarkFolder bf = new BookmarkFolder();
			bf.setId(vo.getFolderId());
			bf.setFolder(vo.getFolder());
			bf.setBookmarkId(vo.getId());
			if( folderService.updateById(bf)) {
				count++;
			}
		}
		
		return ResMessage.newSuccessMessage("更新成功："+count+"个", null);
	}
	
}
