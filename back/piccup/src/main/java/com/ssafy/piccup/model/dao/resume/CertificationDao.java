package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Certification;

public interface CertificationDao {
	
	// 자격증 전체 조회
    public List<Certification> selectAllCertifications();

    // 자격증 추가
    public int insertCertification(Certification certification);

    // 자격증 수정
    public int updateCertification(Certification certification);

    // 자격증 삭제
    public int deleteCertification(int certId);
}
