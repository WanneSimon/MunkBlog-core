package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.constant.ObjectTypeEnum;
import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.MunkTag;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 各种对象的标签 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IMunkTagService extends IService<MunkTag> {
	
	List<MunkTag> selectTags(ObjectTypeEnum type, int objectId, ValidEnum valid);
	
}
