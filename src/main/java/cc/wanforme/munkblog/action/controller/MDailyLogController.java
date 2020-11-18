package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MDailyLogService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogSearchVo;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Controller
@RequestMapping("/api/dailyLog")
public class MDailyLogController {
	
	@Autowired
	private MDailyLogService dailyLogService;
	
	@RequestMapping("/search")
	@ResponseBody
	public ResMessage searchDailyLog(@RequestBody DailyLogSearchVo searchVo) {
		return dailyLogService.searchDailyLog(searchVo);
	}
	
	@RequestMapping("/add")
	@PreAuthorize("hasAuthority('dailyLog_add')")
	@ResponseBody
	public ResMessage addDailyLog(@RequestBody DailyLogVo comicWordsVo) {
		return dailyLogService.addDailyLog(comicWordsVo);
	}

	@RequestMapping("/get")
	@ResponseBody
	public ResMessage getDailyLog(@RequestBody DailyLogVo vo) {
		return dailyLogService.getDailyLog(vo.getId());
	}
	
	@RequestMapping("/update")
	@PreAuthorize("hasAuthority('dailyLog_update')")
	@ResponseBody
	public ResMessage updateDailyLog(@RequestBody DailyLogVo vo) {
		return dailyLogService.updateDailyLog(vo);
	}
	
}
