package cc.wanforme.munkblog.vo.bookmark;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wanne
 * 2020年11月18日
 */
public class BookmarkVo implements Serializable{

	private static final long serialVersionUID = 1L;

    private Integer id;
//    @ApiModelProperty(value = "书签名")
    private String name;
//    @ApiModelProperty(value = "简短描述")
    private String description;
//    @ApiModelProperty(value = "书签连接")
    private String link;
//    @ApiModelProperty(value = "备注")
    private String remark;
//    @ApiModelProperty(value = "0-失效, 1-生效")
    private String valid;
//    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
//    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updateTime;

    // 书签文件夹id
    private Integer folderId;
    
    // 书签文件夹
    private String folder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
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
	
	public Integer getFolderId() {
		return folderId;
	}
	
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}
	
	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

}
