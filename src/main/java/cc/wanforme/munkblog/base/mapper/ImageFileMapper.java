package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.ImageFile;
import cc.wanforme.munkblog.vo.efile.ImageVo;

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
	
//	List<ImageFile> selectAllByObjectId(String valid, int objectId);
	
	/**
	 * @param valid 为空即是否有效都要查询
	 * @param objectId
	 * @return
	 */
	List<ImageFile> selectAllByObjectId(@Param("valid") String valid, @Param("objectId") int objectId);
	
	List<ImageFile> selectByTypeWithObjectId(@Param("valid")String valid, @Param("objectId") int objectId,
			@Param("type") String type);

	/** 查询对象的所有 imageVo*/
	List<ImageVo> selectObjectImageVos(@Param("objectId") int objectId, @Param("type") String type);

	/** 查询对象某一个 imageVO*/
	ImageVo selectImageVoByObjectAndName(@Param("objectId") int objectId, @Param("type") String type,
			@Param("name") String name);

	
}
