package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Certification;


public interface CertificationService {
	
	// 자격증 전체 조회
    public List<Certification> readCertificationList(int resumeId);

    // 자격증 추가
    public boolean createCertification(Certification certification);

    // 자격증 리스트 추가
    public void createCertificationList(List<Certification> certifications, int resumeId);

    // 자격증 수정
    public boolean updateCertification(Certification certification);

    // 자격증 삭제
    public boolean deleteCertification(int certId);

}
