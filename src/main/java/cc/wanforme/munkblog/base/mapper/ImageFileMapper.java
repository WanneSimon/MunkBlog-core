package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.ImageFile;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 各种对象关联的图片 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface ImageFileMapper extends BaseMapper<ImageFile> {
	
	List<ImageFile> selectByObjectId(@Param("valid") String valid, @Param("objectId") int objectId);
	
	List<ImageFile> selectByTypeWithObjectId(@Param("valid")String valid, @Param("objectId") int objectId,
			@Param("type") String type);
	
	
}
