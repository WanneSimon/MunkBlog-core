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
@ApiModel(value="BookmarkFolder对象", description="书签父子关系文件夹")
public class BookmarkFolder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父书签文件夹")
    private Integer parentId;

    @ApiModelProperty(value = "字书签文件夹")
    private Integer childId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
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
        ", parentId=" + parentId +
        ", childId=" + childId +
        ", createTime=" + createTime +
        "}";
    }
}
