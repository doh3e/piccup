package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.PatentDao;
import com.ssafy.piccup.model.dto.resume.Patent;
import com.ssafy.piccup.model.dto.resume.Training;

@Service
public class PatentServiceImpl implements PatentService {

	private final PatentDao patentDao;
	
	public PatentServiceImpl(PatentDao PatentDao) {
		this.patentDao = PatentDao;
	}
	
	// 논문 전체 조회
	@Override
	public List<Patent> readPatentList(int resumeId) {
		List<Patent> patentList = patentDao.selectAllPatents(resumeId);
		return patentList.isEmpty() ? new ArrayList<Patent>() : patentList;
	}

    // 논문 추가
	@Transactional
	@Override
	public boolean createPatent(Patent patent) {
		int result = patentDao.insertPatent(patent);
		return result == 1;
	}

    // 논문 수정
	@Transactional
	@Override
	public boolean updatePatent(Patent patent) {
		int result = patentDao.updatePatent(patent);
		return result == 1;
	}

    // 논문 삭제
	@Transactional
	@Override
	public boolean deletePatent(int patentId) {
		int result = patentDao.deletePatent(patentId);
		return result == 1;
	}

}
