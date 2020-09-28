package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Game;
import cc.wanforme.munkblog.base.mapper.GameMapper;
import cc.wanforme.munkblog.base.service.IGameService;
import cc.wanforme.munkblog.vo.game.GameSearchVo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

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

	@Override
	public PageInfo<Game> selectGames(GameSearchVo searchVo) {
		PageHelper.startPage(searchVo.getPage(), searchVo.getSize());
		List<Game> data =  this.baseMapper.selectGames(searchVo);
		return new PageInfo<Game>(data);
	}
	
}
