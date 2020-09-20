package cc.wanforme.munkblog.vo.book;

import java.time.LocalDateTime;

import cc.wanforme.munkblog.base.entity.ImageFile;

import java.io.Serializable;

/**
 * <p>
 * 书
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public class BookVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**书名*/
    private String name;
    /**介绍*/
    private String description;
    /**编辑器版本 (默认quill3+)*/
    private String editor;
    /**0-失效, 1-生效*/
    private String valid;
    /**创建时间*/
    private LocalDateTime createTime;
    /**更新时间*/
    private LocalDateTime updateTime;

    /**封面*/
    private ImageFile cover;
    
    
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

	public ImageFile getCover() {
		return cover;
	}
	public void setCover(ImageFile cover) {
		this.cover = cover;
	}
    
    @Override
    public String toString() {
        return "Book{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", editor=" + editor +
        ", valid=" + valid +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", cover=" + cover +
        "}";
    }
}
