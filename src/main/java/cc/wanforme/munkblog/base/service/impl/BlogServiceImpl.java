package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Blog;
import cc.wanforme.munkblog.base.mapper.BlogMapper;
import cc.wanforme.munkblog.base.service.IBlogService;
import cc.wanforme.munkblog.vo.blog.BlogResultRecorder;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 博文 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

	@Override
	public int queryTotoal(BlogSearchVo searchVo) {
		return this.baseMapper.qeuryTotoal(searchVo);
	}

	@Override
	public PageInfo<BlogResultRecorder> queryBlogs(BlogSearchVo searchVo) {
		PageHelper.startPage(searchVo.getPage(), searchVo.getSize());
		
		List<BlogResultRecorder> data =  this.baseMapper.queryBlogs(searchVo);
		return new PageInfo<BlogResultRecorder>(data);
	}

	
}
