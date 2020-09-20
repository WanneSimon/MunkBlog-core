package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.ComicWords;
import cc.wanforme.munkblog.base.mapper.ComicWordsMapper;
import cc.wanforme.munkblog.base.service.IComicWordsService;
import cc.wanforme.munkblog.vo.comicWords.ComicWordsSearchVo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 语录 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class ComicWordsServiceImpl extends ServiceImpl<ComicWordsMapper, ComicWords> implements IComicWordsService {

	@Override
	public PageInfo<ComicWords> select(ComicWordsSearchVo searchVo) {
		PageHelper.startPage(searchVo.getPage(), searchVo.getSize());
		List<ComicWords> data = this.baseMapper.selectComicWords(searchVo);
		return new PageInfo<ComicWords>(data);
	}

}
