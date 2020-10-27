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

	/** 查询某个对象特定的文件对象<br>
	 * @param objectId 对象id
	 * @param fileName 文件名(非硬盘上的文件明)
	 */
	Efile selectByObjectAndName(Integer objectId, String fileName); 
	
	/** 更新所属对象类型*/
	void updateObjectType(int id, String objectType);
}
