package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.Blog;
import cc.wanforme.munkblog.vo.blog.BlogResultRecorder;
import cc.wanforme.munkblog.vo.blog.BlogSearchVo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 博文 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IBlogService extends IService<Blog> {

	// 查询总条数
	int queryTotoal(BlogSearchVo searchVo);
	// 查询当前页信息
	PageInfo<BlogResultRecorder> queryBlogs(BlogSearchVo searchVo);
	
}
