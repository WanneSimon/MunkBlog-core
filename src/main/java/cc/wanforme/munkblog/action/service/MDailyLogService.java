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
import cc.wanforme.munkblog.base.entity.DailyLog;
import cc.wanforme.munkblog.base.service.IDailyLogService;
import cc.wanforme.munkblog.util.MunkBeanUtils;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogSearchVo;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Service
public class MDailyLogService {

	@Autowired
	private IDailyLogService dailyLogService;
	
	public ResMessage searchDailyLog(DailyLogSearchVo searchVo) {
		PageInfo<DailyLog> data = dailyLogService.selectDailyLogs(searchVo);
		return ResMessage.newSuccessMessage(data);
	}

	@Transactional(rollbackFor = Exception.class)
	public ResMessage addDailyLog(DailyLogVo comicWordsVo) {
		Assert.notNull(comicWordsVo, "对象为空");
		Assert.hasText(comicWordsVo.getContent(), "内容为空");
		
		DailyLog po = new DailyLog();
		BeanUtils.copyProperties(comicWordsVo, po);
		
		po.setId(null);
		po.setValid(ValidEnum.VALID.getCode());
		LocalDateTime now = LocalDateTime.now();
		po.setCreateTime(now);
		po.setUpdateTime(now);
		
		dailyLogService.save(po);
		
		BeanUtils.copyProperties(po, comicWordsVo);
		return ResMessage.newSuccessMessage("添加成功", comicWordsVo);
	}

	public ResMessage getDailyLog(Integer id) {
		DailyLog dl = dailyLogService.getById(id);
		
		DailyLogVo vo = new DailyLogVo();
		BeanUtils.copyProperties(dl, vo);
		
		return ResMessage.newSuccessMessage("获取成功", vo);
	}

	@Transactional(rollbackFor = Exception.class)
	public ResMessage updateDailyLog(DailyLogVo vo) {
		Assert.notNull(vo, "没有数据");
		Assert.notNull(vo.getId(), "没有id");
		
		if(StringUtils.isAllBlank(vo.getContent(), vo.getValid())) {
			return ResMessage.newFailMessage("不需要更新");
		}
		
		DailyLog po = dailyLogService.getById(vo.getId());
		if( po==null ) {
			return ResMessage.newFailMessage("语录不存在");
		}
		
		MunkBeanUtils.copyNotNullProperties(vo, po);
		dailyLogService.updateById(po);
		
		return ResMessage.newSuccessMessage("日志动态更新成功", po);
	}
	
	
	
}
