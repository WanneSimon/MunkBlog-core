package cc.wanforme.munkblog.base.service.impl;

import cc.wanforme.munkblog.base.entity.Efile;
import cc.wanforme.munkblog.base.mapper.EfileMapper;
import cc.wanforme.munkblog.base.service.IEfileService;
import cc.wanforme.munkblog.vo.efile.EfileSearchVo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 存放所有的文件信息 服务实现类
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@Service
public class EfileServiceImpl extends ServiceImpl<EfileMapper, Efile> implements IEfileService {

	@Override
	public List<Efile> selectEfile(EfileSearchVo searchVo) {
		return this.baseMapper.selectEfiles(searchVo);
	}

	@Override
	public Efile selectByObjectAndName(Integer objectId, String fileName) {
		return this.baseMapper.selectByObjectAndName(objectId, fileName);
	}

}
