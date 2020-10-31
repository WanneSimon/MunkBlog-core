package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.constant.ObjectTypeEnum;
import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.ImageFile;
import cc.wanforme.munkblog.base.mapper.ImageFileMapper;
import cc.wanforme.munkblog.base.service.IImageFileService;
import cc.wanforme.munkblog.vo.efile.ImageVo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 各种对象关联的图片 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class ImageFileServiceImpl extends ServiceImpl<ImageFileMapper, ImageFile> implements IImageFileService {

	@Override
	public List<ImageFile> selectAllByObjectId(ValidEnum valid, int objectId) {
		return this.baseMapper.selectAllByObjectId(valid.getCode(), objectId);
	}

	@Override
	public List<ImageFile> selectByObjectId(int objectId, ObjectTypeEnum type) {
		return this.baseMapper.selectByTypeWithObjectId(null, objectId, type.getCode());
	}

	@Override
	public List<ImageFile> selectByTypeWithObjectId(ValidEnum valid, int objectId, ObjectTypeEnum type) {
		return this.baseMapper.selectByTypeWithObjectId(valid.getCode(), objectId, type.getCode());
	}

	@Override
	public List<ImageVo> selectObjectImageVos(int objectId, ObjectTypeEnum type) {
		return this.baseMapper.selectObjectImageVos(objectId, type.getCode());
	}

	@Override
	public ImageVo selectImageVoByObjectAndName(int objectId, ObjectTypeEnum type, String name) {
		return this.baseMapper.selectImageVoByObjectAndName(objectId, type.getCode(), name);
	}

}
