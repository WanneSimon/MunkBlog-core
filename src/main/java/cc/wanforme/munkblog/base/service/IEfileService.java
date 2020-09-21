package cc.wanforme.munkblog.base.service;

import cc.wanforme.munkblog.base.entity.Efile;
import cc.wanforme.munkblog.vo.efile.EfileSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 存放所有的文件信息 服务类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public interface IEfileService extends IService<Efile> {

	List<Efile> selectEfile(EfileSearchVo searchVo);
	
}
