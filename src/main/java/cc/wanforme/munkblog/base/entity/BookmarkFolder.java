package cc.wanforme.munkblog.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 书签父子关系文件夹
 * </p>
 *
 * @author wanne
 * @since 2020-09-20
 */
@ApiModel(value="BookmarkFolder对象", description="书签文件夹")
public class BookmarkFolder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "书签文件夹")
    private String folder;

    @ApiModelProperty(value = "书签")
    private Integer bookmarkId;

    @ApiModelProperty(value = "1-有效,0无效")
    private String valid;
    
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public Integer getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(Integer bookmarkId) {
		this.bookmarkId = bookmarkId;
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

	@Override
    public String toString() {
        return "BookmarkFolder{" +
        "id=" + id +
        ", folder=" + folder +
        ", bookmarkId=" + bookmarkId +
        ", createTime=" + createTime +
        "}";
    }
}
