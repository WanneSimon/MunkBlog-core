package cc.wanforme.munkblog.action.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.wanforme.munkblog.base.entity.BlogQuotation;
import cc.wanforme.munkblog.base.service.IBlogQuotationService;

/**
 * @author wanne
 * 2020年9月27日
 */
@Service
public class MBlogQuotationService {
	private static final Logger log = LoggerFactory.getLogger(MBlogQuotationService.class);

	@Autowired
	private IBlogQuotationService blogQuotationService;
	
	/** 更新对象的引用，会比对数据库，删除不要的，添加新的，更改需要更新的<br>
	 * 允许移除所有引用，列表置为 空列表即可
	 * @param objectId
	 * @param tagVos
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateQuotations(int objectId, List<BlogQuotation> quotationVos) {
		if(quotationVos == null) {
			log.info("没有需要更新的引用 [objectId: "+objectId+"]");
			return;
		}
		
//		List<MunkTag> tags = tagService.selectTags(ObjectTypeEnum.BLOG, objectId, ValidEnum.VALID);
		List<BlogQuotation> quotations = blogQuotationService.selectByBlog(objectId);
		
		// 考虑原来就没有引用的情况
		if(quotations == null) {
			quotations = new ArrayList<>(0);
		}
		
		List<BlogQuotation> quotationCopyVos = new ArrayList<>(quotationVos);

		// 交集(更新)，相同的 （quotationCopyVos已变成需要更新的集合）
		quotationCopyVos.retainAll(quotations);
		quotationCopyVos.forEach( e->{ 
			// 只能改名字和生效状态
			blogQuotationService.updateById(e);
		});
		
		// 差集(新增)，源数据库没有，现在更新有了（quotationVos已变成需要增加的集合）
		quotationVos.removeAll(quotationCopyVos);
		quotationVos.forEach( e-> {
			blogQuotationService.save(e);
		});
		
		// 差集(删除)，原数据库有的，现在更新没了（quotations已变成需要删除的集合）
		quotations.removeAll(quotationCopyVos);
		quotations.forEach( e-> {
			blogQuotationService.removeById(e.getId());
		});
	}
	
	
}
