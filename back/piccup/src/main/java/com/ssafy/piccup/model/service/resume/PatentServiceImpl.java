package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.PatentDao;
import com.ssafy.piccup.model.dto.resume.Patent;

@Service
public class PatentServiceImpl implements PatentService {

	private final PatentDao patentDao;
	
	public PatentServiceImpl(PatentDao PatentDao) {
		this.patentDao = PatentDao;
	}
	
	// 특허 조회 (resume 기반)
	@Override
	public List<Patent> readPatentList(int resumeId) {
		List<Patent> patentList = patentDao.selectAllPatents(resumeId);
		return patentList.isEmpty() ? new ArrayList<Patent>() : patentList;
	}

	// 특허 리스트 추가
	@Transactional
	@Override
	public void createPatentList(List<Patent> patents, int resumeId) {
		int result = 0;
		try {
			for (Patent patent : patents) {
				patent.setResumeId(resumeId);
				if (patentDao.insertPatent(patent) == 1) result += 1;
			}
			if (result != patents.size()) {
				throw new RuntimeException("create PatentList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
