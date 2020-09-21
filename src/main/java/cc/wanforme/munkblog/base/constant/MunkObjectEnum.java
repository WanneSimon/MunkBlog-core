package cc.wanforme.munkblog.base.constant;

/**
 * @author wanne
 * 2020年9月21日
 */
public enum MunkObjectEnum {
	
	BLOG("Blog", "博文"),
	DAIL_LOG("DailyLog", "日志、动态"),
	BOOK("Book", "书"),
	GAME("Game", "游戏"),
	COMIC_WORDS("ComicWords", "语录"),
	;
	
	private String code;
	
	private String description;
	
	private MunkObjectEnum(String code, String description) {
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
