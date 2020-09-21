package cc.wanforme.munkblog.action.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.entity.ComicWords;
import cc.wanforme.munkblog.base.service.IComicWordsService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsSearchVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Service
public class MComicWordsService {

	@Autowired
	private IComicWordsService comicWordsService;
	
	public ResMessage searchCommicWords(ComicWordsSearchVo searchVo) {
		PageInfo<ComicWords> data = comicWordsService.selectCommicWords(searchVo);
		return ResMessage.newSuccessMessage(data);
	}
	
}
