package com.ssafy.piccup.service.resume;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.resume.WorkExp;


public interface WorkExpService {
	
	// 경력 전체 조회
    public List<WorkExp> readWorkExpList();

    // 경력 추가
    public boolean createWorkExp(WorkExp workExp, MultipartFile file);

    // 경력 수정
    public boolean updateWorkExp(WorkExp workExp, MultipartFile file);

    // 경력 삭제
    public boolean deleteWorkExp(int expId);
    
    // 경력 파일 추가
    public boolean uploadFile(WorkExp workExp, MultipartFile file);
}
