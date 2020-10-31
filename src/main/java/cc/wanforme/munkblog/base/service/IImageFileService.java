package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.constant.ObjectTypeEnum;
import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.ImageFile;
import cc.wanforme.munkblog.vo.efile.ImageVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 各种对象关联的图片 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IImageFileService extends IService<ImageFile> {
	
	/**
	 * @param valid 为空即是否有效都要查询
	 * @param objectId
	 * @return
	 */
	List<ImageFile> selectAllByObjectId(ValidEnum valid, int objectId);
	
	/** 查询对象所有的图片文件信息*/
	List<ImageFile> selectByObjectId( int objectId, ObjectTypeEnum type);
	
	List<ImageFile> selectByTypeWithObjectId(ValidEnum valid, int objectId, ObjectTypeEnum type);

	/** 查询对象的所有 imageVo*/
	List<ImageVo> selectObjectImageVos( int objectId, ObjectTypeEnum type);

	/** 查询对象某一个 imageVO*/
	ImageVo selectImageVoByObjectAndName( int objectId, ObjectTypeEnum type , String name);
	
}
