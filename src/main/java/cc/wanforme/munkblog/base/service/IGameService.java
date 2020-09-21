package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.Game;
import cc.wanforme.munkblog.vo.game.GameSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IGameService extends IService<Game> {
	
	List<Game> selectGames(GameSearchVo searchVo);
	
}
