package cc.wanforme.munkblog.base.constant;

/** 通用是否生效的常量
 * @author wanne
 * 2020年9月18日
 */
public enum ValidEnum {
	
	INVALID("0", "失效"),
	VALID("1", "生效"),
	;
	
	private String code;
	
	private String description;
	
	private ValidEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
}
