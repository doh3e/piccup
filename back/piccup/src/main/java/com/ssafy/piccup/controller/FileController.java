package com.ssafy.piccup.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;


@Controller
public class FileController {
	// ResourceLoader 인터페이스 : 
	// - 스프링에서 파일, 클래스 등의 리소스를 로드할 때 사용 
	
	// 방식1 
	// - annotation으로 ResourceLoader 객체를 필드에 직접 주입
//	@Autowired
//	private ResourceLoader resourceLoader;
	
	// 방식2
	// - 생성자로 의존성 주입
	// - Spring 컨테이너가 ResourceLoader를 자동으로 주입하여 생성자를 호출
	private ResourceLoader resourceLoader;
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	//----
	
	@GetMapping("/singleFileForm")
	public String singleFileForm () {
		return "singleFileForm";
	}
	
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		// 파일이 있는지 검사 
		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename(); // 파일명 
			
			// src/main/resources/static/img 폴더 가져옴 (resource loader)
			// src 경로 내에 있다 -> 클래스 경로 상에 있다 
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			
			// 로컬 경로에 있는 파일을 가져오고싶은 경우
//			resourceLoader.getResource("file:...");
			
			// pjt 폴더 > target > classes > static > img 폴더 생성 됨 > 이미지 첨부됨 
			file.transferTo(new File(resource.getFile(), fileName));
			
			model.addAttribute("fileName", fileName);
		}
		return "result";
	}
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}
	
}
