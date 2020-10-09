package cc.wanforme.munkblog.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/** 分页查询父类
 * @author wanne
 * 2020年9月20日
 */
public class SearchVo {
	// 页码
	protected int page;
	// 大小
	protected int size;
	// 总页数（无用字段）
	@JsonIgnore(false)
	protected int totalPage;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
