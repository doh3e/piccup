package com.ssafy.piccup.model.service.resume;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.resume.Education;
import com.ssafy.piccup.model.dto.resume.PersonalInfo;


public interface EducationService {
	
	// 학력 전체 조회
    public List<Education> readEducationList(int resumeId);

    // 학력 추가
    public boolean createEducation(Education education, MultipartFile file);

    // 학력 수정
    public boolean updateEducation(Education education, MultipartFile file);

    // 학력 삭제
    public boolean deleteEducation(int eduId);
    
    // 성적증명서 추가
    public boolean uploadFile(Education education, MultipartFile file);
}
