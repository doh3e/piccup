package com.ssafy.piccup.model.service.resume;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.resume.WorkExp;


public interface WorkExpService {
	
	// 경력 조회 (resume 기반)
    public List<WorkExp> readWorkExpList(int resumeId);

    // 경력 추가 - 파일 별도
    public void createWorkExpList(List<WorkExp> workExps, int resumeId);
}
