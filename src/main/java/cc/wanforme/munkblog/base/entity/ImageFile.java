package cc.wanforme.munkblog.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 各种对象关联的图片
 * </p>
 *
 * @author wanne
 * @since 2020-09-17
 */
@ApiModel(value="ImageFile对象", description="各种对象关联的图片")
public class ImageFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "对象的id")
    private Integer objectId;

    @ApiModelProperty(value = "文件 (efile) id")
    private Integer fileId;

    @ApiModelProperty(value = "所属对象的类型, 博文-Blog, 日志-DailyLog, 书架-Books, 游戏-Games")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ImageFile{" +
        "id=" + id +
        ", objectId=" + objectId +
        ", fileId=" + fileId +
        ", type=" + type +
        "}";
    }
}
