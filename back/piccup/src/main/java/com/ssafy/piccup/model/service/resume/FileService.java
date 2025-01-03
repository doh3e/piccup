package com.ssafy.piccup.model.service.resume;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.resume.FileDto;


public interface FileService {
	
	// 성적증명서
	
	// - 추가
	public void uploadEduFile(int resumeId, MultipartFile file);
	// - 조회 (1개만 반환)
	public FileDto readEduFile(int resumeId);
	
	// 포트폴리오
    
	// - 추가
    public void uploadPortFile(int resumeId, MultipartFile file);
    // - 조회
    public List<FileDto> readPortFileList(int resumeId);
    
    // 경력증명서
    
    // - 추가
    public void uploadWorkFile(int resumeId, MultipartFile file);
    // - 조회 (1개만 반환)
    public FileDto readWorkFile(int resumeId);

}
