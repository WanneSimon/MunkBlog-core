package cc.wanforme.munkblog.vo.efile;

import java.time.LocalDateTime;

/**
 * @author wanne
 * 2020年9月30日
 */
public class ImageVo {
	// ImageFile 的id
	private Integer imageFileId;
	// 对象id
	private Integer objectId;
	// ImageFile 中的 对象类型
	private String imageFileType;
	// ImageFile 中的生效标志
	private String imageFileValid;
	
	// efile的名字
	private String name;
	// efile的真实存储文件名
	private String realName;
	// efile中的对象类型
	private String efileType;
	// efile中的生效标志
	private String efileValid;
	// efile中的创建时间
	private LocalDateTime efileCreateTime;
	// efile中的最后更新时间
	private LocalDateTime efileUpdateTime;
	
	
	public Integer getImageFileId() {
		return imageFileId;
	}
	public void setImageFileId(Integer imageFileId) {
		this.imageFileId = imageFileId;
	}
	public Integer getObjectId() {
		return objectId;
	}
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}
	public String getImageFileType() {
		return imageFileType;
	}
	public void setImageFileType(String imageFileType) {
		this.imageFileType = imageFileType;
	}
	public String getImageFileValid() {
		return imageFileValid;
	}
	public void setImageFileValid(String imageFileValid) {
		this.imageFileValid = imageFileValid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEfileType() {
		return efileType;
	}
	public void setEfileType(String efileType) {
		this.efileType = efileType;
	}
	public String getEfileValid() {
		return efileValid;
	}
	public void setEfileValid(String efileValid) {
		this.efileValid = efileValid;
	}
	public LocalDateTime getEfileCreateTime() {
		return efileCreateTime;
	}
	public void setEfileCreateTime(LocalDateTime efileCreateTime) {
		this.efileCreateTime = efileCreateTime;
	}
	public LocalDateTime getEfileUpdateTime() {
		return efileUpdateTime;
	}
	public void setEfileUpdateTime(LocalDateTime efileUpdateTime) {
		this.efileUpdateTime = efileUpdateTime;
	}
	
	
}
