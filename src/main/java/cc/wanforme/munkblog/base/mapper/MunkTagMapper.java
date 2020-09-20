package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.MunkTag;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 各种对象的标签 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface MunkTagMapper extends BaseMapper<MunkTag> {

	List<MunkTag> selectTags(@Param("type") String type,
			@Param("objectId")int objectId, @Param("valid")String valid);

}
