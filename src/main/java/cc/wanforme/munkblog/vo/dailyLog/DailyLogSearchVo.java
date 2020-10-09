package cc.wanforme.munkblog.vo.dailyLog;

import cc.wanforme.munkblog.vo.SearchVo;

/**
 * @author wanne
 * 2020年9月20日
 */
public class DailyLogSearchVo extends SearchVo{
	
	private String content;
	private String valid;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getValid() {
		return valid;
	}
	
	public void setValid(String valid) {
		this.valid = valid;
	}
}
