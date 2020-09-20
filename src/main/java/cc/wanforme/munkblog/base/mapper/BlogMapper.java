package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.Blog;
import cc.wanforme.munkblog.vo.blog.BlogResultRecorder;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 博文 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface BlogMapper extends BaseMapper<Blog> {
	
	
	int qeuryTotoal(BlogSearchVo searchVo);

	List<BlogResultRecorder> queryBlogs(@Param(value = "searchVo") BlogSearchVo searchVo);

} 
