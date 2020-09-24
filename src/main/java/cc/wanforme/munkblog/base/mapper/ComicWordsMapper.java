package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.ComicWords;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * <p>
 * 语录 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface ComicWordsMapper extends BaseMapper<ComicWords> {

	List<ComicWords> selectComicWords(ComicWordsSearchVo searchVo);

}
