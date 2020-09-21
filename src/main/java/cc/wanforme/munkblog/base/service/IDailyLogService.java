package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.DailyLog;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 日志 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IDailyLogService extends IService<DailyLog> {

	List<DailyLog> selectDailyLogs(DailyLogSearchVo searchVo);
	
}
