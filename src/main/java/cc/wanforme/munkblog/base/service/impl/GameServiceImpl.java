package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Game;
import cc.wanforme.munkblog.base.mapper.GameMapper;
import cc.wanforme.munkblog.base.service.IGameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game> implements IGameService {

}
