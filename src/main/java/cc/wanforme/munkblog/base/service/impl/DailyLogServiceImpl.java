package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.DailyLog;
import cc.wanforme.munkblog.base.mapper.DailyLogMapper;
import cc.wanforme.munkblog.base.service.IDailyLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class DailyLogServiceImpl extends ServiceImpl<DailyLogMapper, DailyLog> implements IDailyLogService {

}
