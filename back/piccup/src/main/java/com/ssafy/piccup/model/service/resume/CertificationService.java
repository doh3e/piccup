package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Certification;


public interface CertificationService {
	
	// 자격증 조회 (resume 기반)
    public List<Certification> readCertificationList(int resumeId);

    // 자격증 리스트 추가
    public void createCertificationList(List<Certification> certifications, int resumeId);
}
