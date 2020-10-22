package cc.wanforme.munkblog.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import cc.wanforme.munkblog.base.constant.FileDownloadEnum;

/** 文件工具类
 * @author wanne
 * 2020年9月21日
 */
public class FileUtil {

	
	/** 检查文件重名并重命名
	 * @param path 相对路径或绝对路径
	 * @return
	 */
	public static String checkAndRenameFile(String path){
		int count = 0;
		String newname = path;
		
		int in = path.lastIndexOf('.');
		String part1 = path;
		String suffix = "";
		if(in > 0 )  {
//			newname =  +"("+count+")" +path.substring(in);
			part1 = path.substring(0, in);
			suffix = path.substring(in);
		}
		
		do {
			File file = new File(newname);
			if( !Files.exists(file.toPath(), LinkOption.NOFOLLOW_LINKS) ) {
				break;
			}
			
			count++;
			newname = part1+"("+count+")" +suffix;
		} while(true);
		
		
		return newname;
	}

	

	public static void downloadFile2Client(InputStream is, String name, String type,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		FileDownloadEnum typeEnum = FileDownloadEnum.valueOf(type);
		downloadFile2Client(is, name, typeEnum, request, response);
	}
	
	/** 下载文件，支持续传
	 * @throws IOException */
	public static void downloadFile2Client(InputStream is, String name, FileDownloadEnum type,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/pdf");
		if( type == FileDownloadEnum.ONLINE ) {
			response.setHeader("Content-Disposition", "inline; filename=\""+name+"\"");
		} else {
			response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
		}
		
		// 续传，偏移指针
		offsetPointer(is, request);
		
		byte[] bs = new byte[1024];
		int len = 0;
		while ( (len = is.read(bs)) != -1 ) {
			response.getOutputStream().write(bs, 0, len);
		}
		
		response.getOutputStream().flush();
	}

	
	/** 检查端点续传，如果是续传，则在输入流中进行偏移
	 * @param request 
	 * @param inputStream
	 * @throws IOException
	 */
	protected static void offsetPointer(InputStream inputStream, HttpServletRequest request) throws IOException {
		long pos=0; //文件读取的位置
		String range = request.getHeader("Range");
		System.out.println("Range: "+range);
		if(range != null) {//断点续载
			/* "Content-Range: bytes x-(y-1)/y" 例如: Content-Range: bytes 16-14385736/14385737*/
			try {
				pos = Long.parseLong(range.replace("bytes=", "").split("-")[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.err.println("Range: "+range+" is not a number!");
			}
		}
		
		inputStream.skip(pos);
	}
	
	/** 上传文件*/
	public static void saveFile(MultipartFile file, File saveFile) throws IOException {
		try (InputStream is = file.getInputStream();
			 FileOutputStream fos = new FileOutputStream(saveFile);) {
			byte[] bs = new byte[10240];
			int len = 0;
			while ( (len = is.read(bs)) != -1) {
				fos.write(bs, 0, len);
			}
		}
	}
	
	
}
