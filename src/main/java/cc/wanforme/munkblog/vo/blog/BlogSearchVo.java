package cc.wanforme.munkblog.vo.blog;

/** 搜索对象
 * @author wanne
 * 2020年9月20日
 */
public class BlogSearchVo {
	
	// 页码
	private int page;
	// 大小
	private int size;
	// 关键字
	private String keyText;
	
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
	public String getKeyText() {
		return keyText;
	}
	public void setKeyText(String keyText) {
		this.keyText = keyText;
	}
	
}
