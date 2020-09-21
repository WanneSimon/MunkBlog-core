package cc.wanforme.munkblog.action.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.entity.DailyLog;
import cc.wanforme.munkblog.base.service.IDailyLogService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogSearchVo;

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
	
}
