package cc.wanforme.munkblog.vo.game;

import cc.wanforme.munkblog.vo.SearchVo;

/**
 * @author wanne
 * 2020年9月21日
 */
public class GameSearchVo extends SearchVo{

	private String name;

	private String valid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
}
