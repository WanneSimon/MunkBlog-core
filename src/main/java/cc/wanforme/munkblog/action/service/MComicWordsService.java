package cc.wanforme.munkblog.action.service;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.ComicWords;
import cc.wanforme.munkblog.base.service.IComicWordsService;
import cc.wanforme.munkblog.util.MunkBeanUtils;
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
	@Transactional(rollbackFor = Exception.class)
	public ResMessage addComicWords(ComicWordsVo comicWordsVo) {
		Assert.notNull(comicWordsVo, "对象为空");
		Assert.hasText(comicWordsVo.getAuthor(), "作者为空");
		Assert.hasText(comicWordsVo.getText(), "内容为空");
		
		ComicWords po = new ComicWords();
		BeanUtils.copyProperties(comicWordsVo, po);
		
		po.setId(null);
		po.setValid(ValidEnum.VALID.getCode());
		LocalDateTime now = LocalDateTime.now();
		po.setCreateTime(now);
		po.setUpdateTime(now);
		
//		ComicWordsSearchVo searchVo = new ComicWordsSearchVo();
//		searchVo.setPage(1);
//		searchVo.setSize(6);
//		searchVo.setValid("1");
//		comicWordsService.selectCommicWords(searchVo);
		
//		comicWordsService.mysave(po);
		comicWordsService.save(po);
		
		BeanUtils.copyProperties(po, comicWordsVo);
		return ResMessage.newSuccessMessage("添加成功", comicWordsVo);
	}
	
	/** 更新*/
	@Transactional(rollbackFor = Exception.class)
	public ResMessage updateComicWords(ComicWordsVo comicWordsVo) {
		Assert.notNull(comicWordsVo, "没有数据");
		Assert.notNull(comicWordsVo.getId(), "没有id");
//		Assert.hasText(comicWordsVo.getAuthor(), "作者为空");
//		Assert.hasText(comicWordsVo.getText(), "内容为空");
		
		if(StringUtils.isAllBlank(comicWordsVo.getAuthor(), 
				comicWordsVo.getText(), comicWordsVo.getValid())) {
			return ResMessage.newFailMessage("不需要更新");
		}
		
		ComicWords po = comicWordsService.getById(comicWordsVo.getId());
		if( po==null ) {
			return ResMessage.newFailMessage("语录不存在");
		}
		
		MunkBeanUtils.copyNotNullProperties(comicWordsVo, po);
		comicWordsService.updateById(po);
		
		return ResMessage.newSuccessMessage("语录更新成功", po);
	}

	public ResMessage getComicWords(int id) {
		ComicWords cw = comicWordsService.getById(id);
		
		ComicWordsVo vo = new ComicWordsVo();
		BeanUtils.copyProperties(cw, vo);
		
		return ResMessage.newSuccessMessage("获取成功", vo);
	}
	
}
