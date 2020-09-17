package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.ImageFile;
import cc.wanforme.munkblog.base.mapper.ImageFileMapper;
import cc.wanforme.munkblog.base.service.IImageFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 各种对象关联的图片 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-17
 */
@Service
public class ImageFileServiceImpl extends ServiceImpl<ImageFileMapper, ImageFile> implements IImageFileService {

}
