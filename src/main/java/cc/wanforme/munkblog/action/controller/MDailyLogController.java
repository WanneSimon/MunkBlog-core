package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MDailyLogService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogSearchVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Controller
@RequestMapping("/api/dailLog")
public class MDailyLogController {
	
	@Autowired
	private MDailyLogService dailyLogService;
	
	@RequestMapping("/search")
	@ResponseBody
	public ResMessage searchDailyLog(@RequestBody DailyLogSearchVo searchVo) {
		return dailyLogService.searchDailyLog(searchVo);
	}
	
	
}
