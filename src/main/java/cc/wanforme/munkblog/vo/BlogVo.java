package cc.wanforme.munkblog.vo;


import cc.wanforme.munkblog.base.entity.BlogQuotation;
import cc.wanforme.munkblog.base.entity.MunkTag;

import java.time.LocalDateTime;
import java.util.List;
import java.io.Serializable;

/**
 * <p>
 * 博文
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public class BlogVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**标题*/
    private String title;
    /**博文内容*/
    private String content;
    /**归类*/
    private String groupType;
    /**编辑器版本*/
    private String editor;
    /**0-失效, 1-生效*/
    private String valid;
    /**创建时间*/
    private LocalDateTime createTime;
    /**最后编辑时间*/
    private LocalDateTime updateTime;
    
    /**标签*/
    private List<MunkTag> tags;
    /**引用*/
    private List<BlogQuotation> quotations;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
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
    
    public List<MunkTag> getTags() {
		return tags;
	}
    
    public void setTags(List<MunkTag> tags) {
		this.tags = tags;
	}
    
    public List<BlogQuotation> getQuotations() {
		return quotations;
	}
    
    public void setQuotations(List<BlogQuotation> quotations) {
		this.quotations = quotations;
	}
    
    @Override
    public String toString() {
        return "Blog{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", groupType=" + groupType +
        ", editor=" + editor +
        ", valid=" + valid +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", tags=" + tags +
        ", quotations=" + quotations +
        "}";
    }
}
