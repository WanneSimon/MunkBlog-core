package cc.wanforme.munkblog.action.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cc.wanforme.munkblog.action.service.MFileService;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.efile.EFIleVo;

/** 文件接口
 * @author wanne
 * 2020年9月21日
 */
@Controller
@RequestMapping("/api/file")
public class MFileController {

	@Autowired
	private MFileService mFileService;
	
	@RequestMapping("/upload")
	@PreAuthorize("hasAuthority('file_upload')")
	@ResponseBody
	public ResMessage uploadFile(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		return mFileService.uploadFile(file, request, response);
	}
	
	@RequestMapping("/update")
	@PreAuthorize("hasAuthority('file_update')")
	@ResponseBody
	public ResMessage updateFile(@RequestBody EFIleVo vo) {
		return mFileService.updateFile(vo);
	}
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public void getFile(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		mFileService.getFile(id, request, response);
	}
}
