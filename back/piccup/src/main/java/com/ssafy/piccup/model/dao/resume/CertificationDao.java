package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Certification;

public interface CertificationDao {
	
	// 자격증 조회 (resume 기반)
    public List<Certification> selectAllCertifications(int resumeId);

    // 자격증 추가
    public int insertCertification(Certification certification);
}