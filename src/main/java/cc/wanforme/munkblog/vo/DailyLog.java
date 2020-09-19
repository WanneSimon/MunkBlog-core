package cc.wanforme.munkblog.vo;

import java.time.LocalDateTime;
import java.util.List;

import cc.wanforme.munkblog.base.entity.ImageFile;

import java.io.Serializable;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public class DailyLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**日志内容*/
    private String content;
    /**编辑器版本 (默认quill3+)*/
    private String editor;
    /**0-失效, 1-生效*/
    private String valid;
    /**创建日期*/
    private LocalDateTime createTime;
    /**最后更新日期*/
    private LocalDateTime updateTime;

    /**书的图片*/
    private List<ImageFile> images;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    
    public List<ImageFile> getImages() {
		return images;
	}

    @Override
    public String toString() {
        return "DailyLogVo{" +
        "id=" + id +
        ", content=" + content +
        ", editor=" + editor +
        ", valid=" + valid +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", images=" + images +
        "}";
    }
}
