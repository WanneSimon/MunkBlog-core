package cc.wanforme.munkblog.base.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 各种对象的标签
 * </p>
 *
 * @author wanne
 * @since 2020-09-17
 */
@ApiModel(value="MunkTag对象", description="各种对象的标签")
public class MunkTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "标签名")
    private String tagName;

    @ApiModelProperty(value = "对象id")
    private Integer objectId;

    @ApiModelProperty(value = "所属对象的类型, 博文-Blog, 日志-DailyLog, 书架-Books, 游戏-Games")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MunkTag{" +
        "id=" + id +
        ", tagName=" + tagName +
        ", objectId=" + objectId +
        ", type=" + type +
        "}";
    }
}
