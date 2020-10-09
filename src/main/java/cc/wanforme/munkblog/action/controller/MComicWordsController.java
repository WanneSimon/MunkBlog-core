package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MComicWordsService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsSearchVo;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Controller
@RequestMapping("/api/comicWords")
public class MComicWordsController {
	
	@Autowired
	private MComicWordsService mComicWordsService;
	
	@RequestMapping("/search")
	@ResponseBody
	public ResMessage searchComicWords(@RequestBody ComicWordsSearchVo searchVo) {
		return mComicWordsService.searchCommicWords(searchVo);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ResMessage addComicWords(@RequestBody ComicWordsVo comicWordsVo) {
		return mComicWordsService.addComicWords(comicWordsVo);
	}

	@RequestMapping("/get")
	@ResponseBody
	public ResMessage getComicWords(@RequestBody ComicWordsVo vo) {
		return mComicWordsService.getComicWords(vo.getId());
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ResMessage updateComicWords(@RequestBody ComicWordsVo vo) {
		return mComicWordsService.updateComicWords(vo);
	}
	
}
