package cc.wanforme.munkblog.vo.game;

import cc.wanforme.munkblog.base.entity.ImageFile;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public class GameVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**游戏名*/
    private String name;
    /**描述*/
    private String description;
    /**编辑器版本 (默认quill3+)*/
    private String editor;
    /**创建时间*/
    private LocalDateTime createTime;
    /**最后更新时间*/
    private LocalDateTime updateTime;
    /**0-失效, 1-生效*/
    private String valid;

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

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public ImageFile getCover() {
		return cover;
	}
    
    public void setCover(ImageFile cover) {
		this.cover = cover;
	}
    
    @Override
    public String toString() {
        return "Game{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", editor=" + editor +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", valid=" + valid +
        ", cover=" + cover +
        "}";
    }
}
