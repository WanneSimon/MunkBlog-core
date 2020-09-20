package cc.wanforme.munkblog.vo;

/** 分页查询父类
 * @author wanne
 * 2020年9月20日
 */
public class SearchVo {
	// 页码
	protected int page;
	// 大小
	protected int size;
	
	
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
	
}
