package com.ssafy.piccup.model.service.resume;


import org.springframework.web.multipart.MultipartFile;


public interface FileService {
	// 성적증명서
	
	// - 추가
	public void uploadEduFile(int resumeId, MultipartFile file);
	
	// - 조회 (1개만 반환)
	
	
	// 포트폴리오
    
	// - 추가
    public void uploadPortFile(int resumeId, MultipartFile file);
    
    // 경력증명서
    
    // - 추가
    public void uploadWorkFile(int resumeId, MultipartFile file);
    
    // - 조회 (1개만 반환)
    

}
