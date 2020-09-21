package cc.wanforme.munkblog.base.constant;

/**富文本类型
 * @author wanne
 * 2020年9月21日
 */
public enum EditorEnum {
	
	DEFAULT("", "无富文本编辑器"),
	QUILL3_Plus("quill3+", "vue-quill 3.0+"),
	;
	
	private String code;
	
	private String description;
	
	private EditorEnum(String code, String description) {
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
