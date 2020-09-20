package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.ComicWords;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsSearchVo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 语录 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IComicWordsService extends IService<ComicWords> {

	PageInfo<ComicWords> select(ComicWordsSearchVo searchVo);
	
}
