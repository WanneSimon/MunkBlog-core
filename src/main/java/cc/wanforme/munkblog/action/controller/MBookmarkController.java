package cc.wanforme.munkblog.action.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MBookmarkService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.SearchVo;
import cc.wanforme.munkblog.vo.bookmark.BookmarkFolderSearchVo;
import cc.wanforme.munkblog.vo.bookmark.BookmarkVo;

/**
 * @author wanne
 * 2020年11月18日
 */
@Controller
@RequestMapping("/api/bookmark")
public class MBookmarkController {

	@Autowired
	private MBookmarkService bookmarkService;
	
	/** 获取书签文件夹*/
	@PostMapping("/folders")
	@ResponseBody
	public ResMessage selectAllValidFolders(@RequestBody SearchVo searchVo){
		return bookmarkService.selectAllValidFolders(searchVo);
	}
	
	/** 获取书签*/
	@PostMapping("/search")
	@ResponseBody
	public ResMessage selectBookmars(@RequestBody BookmarkFolderSearchVo searchVo){
		return bookmarkService.selectBookmars(searchVo);
	}

	/** 添加书签*/
	@PostMapping("/add")
	@ResponseBody
	public ResMessage addBookmark(@RequestBody BookmarkVo vo) {
		return bookmarkService.addBookmark(vo);
	}
	
	/** 更新书签*/
	@PostMapping("/update")
	@ResponseBody
	public ResMessage updateBookmark(@RequestBody BookmarkVo vo) {
		return bookmarkService.updateBookmark(vo);
	}
	
	/** 获取标签*/
	@PostMapping("/get")
	@ResponseBody
	public ResMessage selectBookmark(@RequestBody BookmarkVo vo) {
		return bookmarkService.selectBookmark(vo);
	}
	
	@PostMapping("/updateFolder")
	@ResponseBody
	public ResMessage updateBookmarkFolders(@RequestBody List<BookmarkVo> vos) {
		return bookmarkService.updateBookmarkFolders(vos);
	}
	
}
