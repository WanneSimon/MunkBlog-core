package cc.wanforme.munkblog.base.mapper;

import cc.wanforme.munkblog.base.entity.Efile;
import cc.wanforme.munkblog.vo.efile.EfileSearchVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 存放所有的文件信息 Mapper 接口
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface EfileMapper extends BaseMapper<Efile> {
	List<Efile> selectEfiles(EfileSearchVo searchVo);

	Efile selectByObjectAndName(@Param("objectId") Integer objectId,@Param("name") String name);

}
