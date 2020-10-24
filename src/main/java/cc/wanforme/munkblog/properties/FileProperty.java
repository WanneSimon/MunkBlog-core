package cc.wanforme.munkblog.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wanne 2020年10月22日
 */
@Component
public class FileProperty {

	@Value("${files.uploadDir:file/uploadDir}")
	private String uploadDir;
	@Value("${files.save:file/save}")
	private String saveDir;
	@Value("${files.renameTryTime:10}")
	private int renameTryTime;

	
	public FileProperty() {}
	
	public String getUploadDir() {
		return uploadDir;
	}
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	public String getSaveDir() {
		return saveDir;
	}
	public void setSaveDir(String saveDir) {
		this.saveDir = saveDir;
	}
	public int getRenameTryTime() {
		return renameTryTime;
	}
	public void setRenameTryTime(int renameTryTime) {
		this.renameTryTime = renameTryTime;
	}
}
