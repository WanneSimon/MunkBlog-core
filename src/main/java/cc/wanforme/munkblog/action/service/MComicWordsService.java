package cc.wanforme.munkblog.action.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.ComicWords;
import cc.wanforme.munkblog.base.service.IComicWordsService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsSearchVo;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Service
public class MComicWordsService {

	@Autowired
	private IComicWordsService comicWordsService;
	
	/** 搜索*/
	public ResMessage searchCommicWords(ComicWordsSearchVo searchVo) {
		PageInfo<ComicWords> data = comicWordsService.selectCommicWords(searchVo);
		return ResMessage.newSuccessMessage(data);
	}

	/** 添加*/
	public ResMessage addComicWords(ComicWordsVo comicWordsVo) {
		Assert.notNull(comicWordsVo, "对象为空");
		Assert.notNull(comicWordsVo.getAuthor(), "作者为空");
		Assert.notNull(comicWordsVo.getText(), "内容为空");
		
		ComicWords po = new ComicWords();
		BeanUtils.copyProperties(comicWordsVo, po);
		
		po.setId(null);
		po.setValid(ValidEnum.VALID.getCode());
		LocalDateTime now = LocalDateTime.now();
		po.setCreateTime(now);
		po.setUpdateTime(now);
		
		ComicWordsSearchVo searchVo = new ComicWordsSearchVo();
		searchVo.setPage(1);
		searchVo.setSize(6);
		searchVo.setValid("1");
		comicWordsService.selectCommicWords(searchVo);
		
//		comicWordsService.mysave(po);
		comicWordsService.save(po);
		
		return ResMessage.newSuccessMessage(po);
	}
	
}
