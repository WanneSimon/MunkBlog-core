package cc.wanforme.munkblog.action.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cc.wanforme.munkblog.base.constant.FileDownloadEnum;
import cc.wanforme.munkblog.base.entity.Efile;
import cc.wanforme.munkblog.base.entity.ImageFile;
import cc.wanforme.munkblog.base.service.IEfileService;
import cc.wanforme.munkblog.base.service.IImageFileService;
import cc.wanforme.munkblog.util.FileUtil;
import cc.wanforme.munkblog.util.PathResource;

/** 文件统一处理
 * @author wanne
 * 2020年9月21日
 */
public class MFileService {
	private static final Logger log = LoggerFactory.getLogger(MFileService.class);
	
	@Autowired
	private IEfileService efileService;
	
	@Autowired
	private IImageFileService imageFileService;
	
	/** 下载文件
	 * @param fileId
	 * @param request
	 * @param response
	 */
	public void getFile(int fileId, HttpServletRequest request, HttpServletResponse response) {
		// 1.检查数据库
		Efile efile = efileService.getById(fileId);
		if(efile == null) {
			log.error("没有此文件! " + fileId);
			this.writeError("没有此文件！", response);
		}
		 // 2.检查文件
		
		File file = new File(efile.getBase(), efile.getFileName());
//		if(!file.exists()) {
//
//		}
		
		// 3. 下载文件 
//		BufferedInputStream bis;
		try (InputStream fis = PathResource.loadResource(file.getPath())){
			FileUtil.downloadFile2Client(fis, efile.getName(),
					FileDownloadEnum.ONLINE, request, response);
		} catch (IOException e) {
			log.error("文件不存在! " + fileId, e);
			this.writeError("文件不存在！", response);
		}
		
	}
	
	/**
	 * @param imageId
	 * @param request
	 * @param response
	 */
	public void getImage(int imageId, HttpServletRequest request, HttpServletResponse response) {
		ImageFile imageFile = imageFileService.getById(imageId);
		if(imageFile == null) {
			log.error("没有此图片! " + imageId);
			this.writeError("没有此图片！", response);
		}
		
		this.getFile(imageFile.getFileId(), request, response);
	}

	private void writeError(String msg, HttpServletResponse response) {
		try {
			response.getOutputStream().write(msg.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
