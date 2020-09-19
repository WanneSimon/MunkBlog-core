package cc.wanforme.munkblog.vo.blog;

import java.util.List;

/** 搜索结果
 * @author wanne
 * 2020年9月20日
 */
public class BlogResultVo {

	// 当前页码
	private int page;
	// 大小
	private int size;
	// 总页码
	private int totalPage;
	//数据
	private List<BlogResultRecorder> datas;

	
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
	public List<BlogResultRecorder> getDatas() {
		return datas;
	}
	public void setDatas(List<BlogResultRecorder> datas) {
		this.datas = datas;
	}
	
	
}
