package cc.wanforme.munkblog.action.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.wanforme.munkblog.base.entity.Game;
import cc.wanforme.munkblog.base.service.IGameService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.game.GameSearchVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Service
public class MGameService {

	@Autowired
	private IGameService gameService;
	
	public ResMessage searchGame(GameSearchVo searchVo) {
		List<Game> data = gameService.selectGames(searchVo);
		return ResMessage.newSuccessMessage(data);
	}
	
}
