package cc.wanforme.munkblog.action.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.munkblog.action.service.MGameService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.game.GameSearchVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Controller
@RequestMapping("/api/game")
public class MGameController {

	@Autowired
	private MGameService gameService;
	
	@RequestMapping
	@PostMapping("/search")
	@ResponseBody
	public ResMessage searchGame(@RequestBody GameSearchVo searchVo) {
		return gameService.searchGame(searchVo);
	}
	
}
