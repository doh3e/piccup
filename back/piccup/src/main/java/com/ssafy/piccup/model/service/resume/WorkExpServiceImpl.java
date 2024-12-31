package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.WorkExpDao;
import com.ssafy.piccup.model.dto.resume.WorkExp;

@Service
public class WorkExpServiceImpl implements WorkExpService {

	private final WorkExpDao workExpDao;
	
	public WorkExpServiceImpl(WorkExpDao WorkExpDao) {
		this.workExpDao = WorkExpDao;
	}
	
	// 경력 전체 조회
	@Override
	public List<WorkExp> readWorkExpList(int resumeId) {
		List<WorkExp> workExpList = workExpDao.selectAllWorkExp(resumeId);
		return workExpList.isEmpty() ? new ArrayList<WorkExp>() : workExpList;
	}

	// 경력 리스트 추가 - 파일 별도
	@Transactional
	@Override
	public void createWorkExpList(List<WorkExp> workExps, int resumeId) {
		int result = 0;
		try {
			for (WorkExp workExp : workExps) {
				workExp.setResumeId(resumeId);
				if (workExpDao.insertWorkExp(workExp) == 1) result += 1;
			}
			if (result != workExps.size()) {
				throw new RuntimeException("create WorkExpList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }		
	}
}
