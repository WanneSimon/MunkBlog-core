package cc.wanforme.munkblog.base.constant;

/**
 * @author wanne
 * 2020年9月27日
 */
public enum FileNameEnum {
	
	BACKGROUND_IMAGE("background_image", "在线"),
	;
	
	private String code;
	
	private String description;
	
	private FileNameEnum(String code, String description) {
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
