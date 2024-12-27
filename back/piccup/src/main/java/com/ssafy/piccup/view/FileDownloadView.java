package com.ssafy.piccup.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView{

	// ResourceLoader 인터페이스 : 
	// - 스프링에서 파일, 클래스 등의 리소스를 로드할 때 사용 
	private ResourceLoader resourceLoader;
	
	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// view는 모델 사용 가능 -> model이 Map 형태로 들어옴
		
		// 사전준비
		String fileName = (String) model.get("fileName"); // object -> String 변경
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(), fileName);
		
		// 응답헤더설정 
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1"); // 한글 깨짐 방지
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary"); // 데이터가 바이너리 데이터임을 응답객체에 알림
		
		// 파일 전송
		try(FileInputStream fis = new FileInputStream(file);// 서버로 읽어오는 통로 만들어서 읽음
				OutputStream os = response.getOutputStream();){ 
			FileCopyUtils.copy(fis, os);
		}
	}
	
}
