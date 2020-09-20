package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.DailyLog;
import cc.wanforme.munkblog.vo.dailyLog.DailyLogSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 日志 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface DailyLogMapper extends BaseMapper<DailyLog> {
	
	List<DailyLog> selectDailyLog(DailyLogSearchVo searchVo);
	
}
