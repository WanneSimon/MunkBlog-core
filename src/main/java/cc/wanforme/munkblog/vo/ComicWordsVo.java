package cc.wanforme.munkblog.vo;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 语录
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public class ComicWordsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**语录内容*/
    private String text;
    /**语录来源作者*/
    private String author;
    /**0-失效, 1-生效*/
    private String valid;
    /**创建时间*/
    private LocalDateTime createTime;
    /**最后更新时间*/
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "ComicWords{" +
        "id=" + id +
        ", text=" + text +
        ", author=" + author +
        ", valid=" + valid +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
