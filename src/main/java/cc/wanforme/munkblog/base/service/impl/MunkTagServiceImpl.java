package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.MunkTag;
import cc.wanforme.munkblog.base.mapper.MunkTagMapper;
import cc.wanforme.munkblog.base.service.IMunkTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 各种对象的标签 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class MunkTagServiceImpl extends ServiceImpl<MunkTagMapper, MunkTag> implements IMunkTagService {

	@Override
	public List<MunkTag> selectTags(String type, int objectId, String valid) {
		return this.baseMapper.selectTags(type, objectId, valid);
	}

}
