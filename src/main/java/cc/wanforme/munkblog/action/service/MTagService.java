package cc.wanforme.munkblog.action.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.wanforme.munkblog.base.constant.ObjectTypeEnum;
import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.MunkTag;
import cc.wanforme.munkblog.base.service.IMunkTagService;

/**
 * @author wanne
 * 2020年9月27日
 */
@Service
public class MTagService {
	private static final Logger log = LoggerFactory.getLogger(MTagService.class);
	
	
	@Autowired
	private IMunkTagService tagService;
	
	/** 更新对象的标签，会比对数据库，删除不要的，添加新的，更改需要更新的<br>
	 * 允许移除所有标签，列表置为 空列表即可
	 * @param objectId
	 * @param tagVos
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateTags(int objectId, ObjectTypeEnum type, List<MunkTag> tagVos) {
		if(tagVos == null) {
			log.info("没有需要更新的标签 [objectId: "+objectId+"]");
			return;
		}
		
		List<MunkTag> tags = tagService.selectTags(ObjectTypeEnum.BLOG, objectId, ValidEnum.VALID);
		
		// 考虑原来就没有标签的情况
		if(tags == null) {
			tags = new ArrayList<>(0);
		}
		
		List<MunkTag> tagCopyVos = new ArrayList<>(tagVos);

		// 交集(更新)，相同的 （tagCopyVos已变成需要更新的集合）
//		tagCopyVos.retainAll(tags);
		tagCopyVos = this.retainTags(tagCopyVos, tags);
		tagCopyVos.forEach( e->{ 
			// 只能改名字和生效状态
			tagService.updateTagNameAndValidStatus(e);
		});
		
		// 差集(新增)，源数据库没有，现在更新有了（tagVos已变成需要增加的集合）
//		tagVos.removeAll(tagCopyVos);
		tagVos = this.removeTags(tagVos, tagCopyVos);
		tagVos.forEach( e-> {
			e.setObjectId(objectId);
			e.setType(type.getCode());
			tagService.save(e);
		});
		
		// 差集(删除)，原数据库有的，现在更新没了（tags已变成需要删除的集合）
//		tags.removeAll(tagCopyVos);
		tags = this.removeTags(tags, tagCopyVos);
		tags.forEach( e-> {
			tagService.removeById(e.getId());
		});
	}

	/** 判断是不是同又给标签，依据：*/
	public boolean isSameTag(MunkTag t1, MunkTag t2) {
		return t1.getTagName().equals(t2.getTagName())
				&& t1.getObjectId()==t2.getObjectId() 
				&& t1.getType().equals(t2.getType());
	}

	/** 查询两个集合的交集
	 * @param source
	 * @param another
	 */
	public List<MunkTag> retainTags(List<MunkTag> source, List<MunkTag> another) {
		List<MunkTag> list = source.stream().filter( e-> {
			Optional<MunkTag> findAny = another.parallelStream()
				.filter( ae -> isSameTag(e, ae)).findAny();
			return findAny.isPresent();
//			return another.parallelStream().filter( ae -> isSameTag(e, ae))
//					.findAny().isPresent();
		}).collect(Collectors.toList());
		return list;
	}
	
	/** 从 source 中删除 another中含有的元素
	 * @param source
	 * @param another 需要删除的部分
	 */
	public List<MunkTag> removeTags(List<MunkTag> source, List<MunkTag> another) {
		List<MunkTag> list = source.stream().filter( e-> {
			Optional<MunkTag> findAny = another.parallelStream()
				.filter( ae -> isSameTag(e, ae)).findAny();
			return !findAny.isPresent();
//			return another.parallelStream().filter( ae -> isSameTag(e, ae))
//					.findAny().isPresent();
		}).collect(Collectors.toList());;
		return list;
	}
	
	public static void main(String[] args) {
		// vo 表示更新后的集合
		List<String> vo = new ArrayList<>(3);
		// b 表示旧集合
		List<String> b = new ArrayList<>(3);
		
		vo.add("1");
		vo.add("2");
		vo.add("3");
		b.add("1");
		b.add("b");
		b.add("c");
		
//		List<String> copyVo = new ArrayList<>(vo.size());
//		Collections.copy(copyVo, vo); // copyVo 必须要先塞满3个元素（不是上面的new出来这里的赋值）
//		List<String> copyVo = Collections.nCopies(vo.size(), vo); // 返回不可变对象，不能用
		List<String> copyVo = new ArrayList<>(vo);
		
		System.out.println("更新：");
		copyVo.retainAll(b);
		System.out.println(copyVo);
		System.out.println("新增：");
		vo.removeAll(copyVo);
		System.out.println(vo);
		System.out.println("删除：");
		b.removeAll(copyVo);
		System.out.println(b);
		
	}
	
	
}
