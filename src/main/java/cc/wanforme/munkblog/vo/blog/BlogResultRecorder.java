package cc.wanforme.munkblog.vo.blog;

import java.time.LocalDateTime;

/** 搜索结果中的记录
 * @author wanne
 * 2020年9月20日
 */
public class BlogResultRecorder {
	
	private int id;
	// 标题
	private String title;
	// 创建时间
	private LocalDateTime createTime;
	// 更新时间
	private LocalDateTime updateTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	
}
