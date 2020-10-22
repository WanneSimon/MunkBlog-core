package cc.wanforme.munkblog.base.constant;

/**
 * @author wanne
 * 2020年9月21日
 */
public enum ObjectTypeEnum {
	
	BLOG("Blog", "博文"),
	DAIL_LOG("DailyLog", "日志、动态"),
	BOOK("Book", "书"),
	GAME("Game", "游戏"),
	COMIC_WORDS("ComicWords", "语录"),
	TEMP_FILE("TEMP", "临时文件"),
	;
	
	private String code;
	
	private String description;
	
	private ObjectTypeEnum(String code, String description) {
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
