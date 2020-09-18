package cc.wanforme.munkblog.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 博文引用
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
@ApiModel(value="BlogQuotation对象", description="博文引用")
public class BlogQuotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "博文id")
    private Integer blogId;

    @ApiModelProperty(value = "引用名")
    private String name;

    @ApiModelProperty(value = "引用连接")
    private String link;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BlogQuotation{" +
        "id=" + id +
        ", blogId=" + blogId +
        ", name=" + name +
        ", link=" + link +
        "}";
    }
}
