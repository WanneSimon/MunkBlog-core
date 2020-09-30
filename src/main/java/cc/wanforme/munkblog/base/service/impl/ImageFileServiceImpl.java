package cc.wanforme.munkblog.base.service.impl;

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
	public List<ImageFile> selectByObjectId(ValidEnum valid, int objectId) {
		return this.baseMapper.selectByObjectId(valid.getCode(), objectId);
	}

	@Override
	public List<ImageFile> selectAllByObjectId(int objectId) {
		return this.baseMapper.selectByObjectId(null, objectId);
	}

	@Override
	public List<ImageFile> selectByTypeWithObjectId(ValidEnum valid, int objectId, String type) {
		return this.baseMapper.selectByTypeWithObjectId(valid.getCode(), objectId, type);
	}

	@Override
	public List<ImageVo> selectObjectImageVos(int objectId) {
		return this.baseMapper.selectObjectImageVos(objectId);
	}

	@Override
	public ImageVo selectImageVoByObjectAndName(int objectId, String name) {
		return this.selectImageVoByObjectAndName(objectId, name);
	}

}
