package cc.wanforme.munkblog.base.constant;

/**
 * @author wanne
 * 2020年9月21日
 */
public enum ResCode {
	
	SUCCESS("00", "处理成功"),
	FAIL("01", "处理失败"),
	;
	
	private String code;
	
	private String description;
	
	private ResCode(String code, String description) {
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
