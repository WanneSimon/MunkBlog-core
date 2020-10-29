package cc.wanforme.munkblog.action.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.constant.EditorEnum;
import cc.wanforme.munkblog.base.constant.ObjectTypeEnum;
import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.Game;
import cc.wanforme.munkblog.base.entity.ImageFile;
import cc.wanforme.munkblog.base.service.IEfileService;
import cc.wanforme.munkblog.base.service.IGameService;
import cc.wanforme.munkblog.base.service.IImageFileService;
import cc.wanforme.munkblog.util.MunkBeanUtils;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.game.GameSearchVo;
import cc.wanforme.munkblog.vo.game.GameVo;

/**
 * @author wanne
 * 2020年9月21日
 */
@Service
public class MGameService {
	private static final Logger log = LoggerFactory.getLogger(MGameService.class);

	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IImageFileService imageFileService;
	
	@Autowired
	private IEfileService efileService;
	
	public ResMessage searchGame(GameSearchVo searchVo) {
		PageInfo<Game> data = gameService.selectGames(searchVo);
		
		// 封面
		List<Game> games = data.getList();
		List<GameVo> gameVos = new ArrayList<>(games.size());
		games.forEach( e -> {
			GameVo gameVo = new GameVo();
			BeanUtils.copyProperties(e, gameVos);
			
			List<ImageFile> images = imageFileService.selectByObjectId(ValidEnum.VALID, e.getId());
			if( images!=null && !images.isEmpty()) {
				gameVo.setCover(images.get(0));
			}
		});
		
		
		PageInfo<GameVo> resData = new PageInfo<GameVo>(gameVos);
		BeanUtils.copyProperties(data, resData, "list");
		return ResMessage.newSuccessMessage(data);
	}

	
	/** 添加*/
	@Transactional(rollbackFor = Exception.class)
	public ResMessage addGame(GameVo gameVo) {
		Assert.notNull(gameVo, "没有信息");
		Assert.notNull(gameVo.getName(), "没有书名");
		Assert.notNull(gameVo.getDescription(), "没有描述");
		
		// 书
		Game game = new Game();
		BeanUtils.copyProperties(gameVo, game);
		
		if(game.getEditor() == null) {
			game.setEditor(EditorEnum.DEFAULT.getCode());
		}
		game.setValid(ValidEnum.VALID.getCode());
		
		LocalDateTime now = LocalDateTime.now();
		game.setCreateTime(now);
		game.setUpdateTime(now);
		
		gameService.save(game);
		
		// 图片信息
		ImageFile coverVo = gameVo.getCover();
		if(coverVo != null) {
			Assert.notNull(coverVo.getFileId(), "没有文件id");
			
			ImageFile cover = new ImageFile();
			cover.setObjectId(gameVo.getId());
			cover.setFileId(coverVo.getObjectId());
			cover.setType(ObjectTypeEnum.GAME.getCode());
			cover.setValid(ValidEnum.VALID.getCode());
			
			imageFileService.save(cover);
			
			BeanUtils.copyProperties(cover, coverVo);
		}
		
		return ResMessage.newSuccessMessage(game);
	}
	
	/** 更新*/
	@Transactional(rollbackFor = Exception.class)
	public ResMessage updateGame(GameVo gameVo) {
		Assert.notNull(gameVo, "没有信息");
		Assert.notNull(gameVo.getId(), "没有id");
		StringBuffer resMsg = new StringBuffer();
		
		Game po = gameService.getById(gameVo.getId());
		if( po == null) {
			return ResMessage.newFailMessage("书籍不存在");
		}
		
		gameVo.setCreateTime(null);
		gameVo.setUpdateTime(null);
		
		// 书名和描述可以均为空，表示更新封面
		if(!StringUtils.isAllBlank(gameVo.getName(),
				gameVo.getDescription())) {
			
//			Game game = new Game();
//			BeanUtils.copyProperties(game, gameVo);
//			game.setCreateTime(null);
//			game.setUpdateTime(null);
//			gameService.updateById(game);

			MunkBeanUtils.copyNotNullProperties(gameVo, po);
			gameService.updateById(po);
			
			// 获取返回信息
			BeanUtils.copyProperties(po, gameVo);
			resMsg.append("书信息更新成功 ");
		} else {
			log.info("不需要更新书籍信息: "+ gameVo.getId());
		}
		
		// 更新图片信息
		if( gameVo.getCover() != null ) {
			ImageFile coverVo = gameVo.getCover();
			
			List<ImageFile> imageFiles = imageFileService.selectAllByObjectId(gameVo.getId());
			if(imageFiles == null) {
				// 保存
				Assert.notNull(coverVo.getFileId(), "没有文件id");
				
				ImageFile cover = new ImageFile();
				cover.setObjectId(gameVo.getId());
				cover.setFileId(coverVo.getFileId());
				cover.setType(ObjectTypeEnum.GAME.getCode());
				cover.setValid(ValidEnum.VALID.getCode());
				
				imageFileService.save(cover);
				
				gameVo.setCover(cover);
				resMsg.append("封面保存成功");
			} else {
				// 更新
				Assert.notNull(coverVo.getId(), "没有封面id");
				Assert.notNull(coverVo.getFileId(), "没有封面文件id");
				Optional<ImageFile> opt = imageFiles.stream()
					.filter( e -> coverVo.getId() == e.getId())
					.findAny();
				
				// 没找到
				if(!opt.isPresent()) {
					String errorMsg = "未找到图片文件 { objectId: "+gameVo.getId()+", imageFileId: "+coverVo.getId()+" }";
					log.info(errorMsg);
					return ResMessage.newFailMessage(errorMsg);
				}
				
				// 更新文件id
				ImageFile cover = opt.get();
				cover.setFileId(coverVo.getFileId());
				imageFileService.updateById(cover);
				
				efileService.updateObjectType(coverVo.getFileId(), ObjectTypeEnum.BOOK.getCode());
				
				BeanUtils.copyProperties(cover, coverVo);
				gameVo.setCover(coverVo);
				resMsg.append("封面更新成功");
			}
		}
		
		return ResMessage.newSuccessMessage(resMsg.toString(), gameVo);
	}
	
	/** 删除游戏，只改为失效状态，游戏和图片记录不删除*/
	@Transactional(rollbackFor = Exception.class)
	public ResMessage deleteGame(int gameId) {
		Game game = gameService.getById(gameId);
		game.setValid(ValidEnum.INVALID.getCode());
		gameService.updateById(game);
		
		List<ImageFile> images = imageFileService.selectByObjectId(ValidEnum.VALID, gameId);
		if(images != null) {
			images.forEach( e -> {
				e.setValid(ValidEnum.INVALID.getCode());
				imageFileService.updateById(e);
			});
		}
		
		return ResMessage.newSuccessMessage("删除成功", null);
	}


	/** 获取游戏*/ 
	public ResMessage getGame(int id) {
		Game po = gameService.getById(id);
		
		GameVo vo = new GameVo();
		BeanUtils.copyProperties(po, vo);
		
		return ResMessage.newSuccessMessage("获取成功", vo);
	}
	
}
