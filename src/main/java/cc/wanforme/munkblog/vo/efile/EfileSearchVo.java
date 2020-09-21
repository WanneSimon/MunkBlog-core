package cc.wanforme.munkblog.vo.efile;

import cc.wanforme.munkblog.vo.SearchVo;

/**
 * @author wanne
 * 2020年9月21日
 */
public class EfileSearchVo extends SearchVo{

	private String valid;
	/**准确*/	
	private String type;
	
	/**(模糊搜索)如果需要使用文件名索引，不要使用 valid和type*/
	private String name;

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
