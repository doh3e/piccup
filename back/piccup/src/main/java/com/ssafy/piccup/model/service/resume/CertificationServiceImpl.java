package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.CertificationDao;
import com.ssafy.piccup.model.dto.resume.Certification;

@Service
public class CertificationServiceImpl implements CertificationService {

	private final CertificationDao certificationDao;
	
	public CertificationServiceImpl(CertificationDao CertificationDao) {
		this.certificationDao = CertificationDao;
	}
	
	// 자격증 조회 (resume 기반)
	@Override
	public List<Certification> readCertificationList(int resumeId) {
		List<Certification> certificationList = certificationDao.selectAllCertifications(resumeId);
		return certificationList.isEmpty() ? new ArrayList<Certification>() : certificationList;
	}

	// 자격증 리스트 추가
	@Transactional
	@Override
	public void createCertificationList(List<Certification> certifications, int resumeId) {
		int result = 0;
		try {
			for (Certification certification : certifications) {
				certification.setResumeId(resumeId);
				if (certificationDao.insertCertification(certification) == 1) result += 1;
			}
			if (result != certifications.size()) {
				throw new RuntimeException("create CertificationList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
