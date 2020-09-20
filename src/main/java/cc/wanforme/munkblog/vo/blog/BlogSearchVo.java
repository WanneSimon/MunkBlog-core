package cc.wanforme.munkblog.vo.blog;

import cc.wanforme.munkblog.vo.SearchVo;

/** 搜索对象
 * @author wanne
 * 2020年9月20日
 */
public class BlogSearchVo extends SearchVo{
	
	// 关键字
	private String keyText;
	
	private String valid;
	
	public String getKeyText() {
		return keyText;
	}
	public void setKeyText(String keyText) {
		this.keyText = keyText;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	
}
