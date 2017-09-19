package cc.shen0d.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传类
 * @author sihan
 *
 */
@RestController
@RequestMapping("/upload")
public class Upload {

	@RequestMapping("/test")
	public String testUpload(HttpServletRequest request, MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		return extension;
	}
}
