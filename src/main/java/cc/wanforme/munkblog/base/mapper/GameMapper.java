package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.Game;
import cc.wanforme.munkblog.vo.game.GameSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface GameMapper extends BaseMapper<Game> {

	List<Game> selectGames(GameSearchVo searchVo);

}
