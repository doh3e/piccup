package com.ssafy.piccup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.PersonalInfoDao;
import com.ssafy.piccup.model.dto.PersonalInfo;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{
	
    private final PersonalInfoDao personalInfoDAO;

    public PersonalInfoServiceImpl(PersonalInfoDao personalInfoDao) {
    	this.personalInfoDAO = personalInfoDao;
    }

    // 인적사항 전체 조회
	@Override
	public List<PersonalInfo> readPersonalList() {
		return personalInfoDAO.selectAllPersonal();
	}

	// 특정 인적사항 조회
	@Override
	public PersonalInfo readPersonal(int infoId) {
		return personalInfoDAO.selectOnePersonal(infoId);
	}
	
	// 인적사항 추가
	@Transactional
	@Override
	public boolean createPersonal(PersonalInfo personalInfo) {
		int result = personalInfoDAO.insertPersonal(personalInfo);
		return result == 1;
	}

	// 인적사항 수정
	@Transactional
	@Override
	public void updatePersonal(PersonalInfo personalInfo) {
		
		
		personalInfoDAO.updatePersonal(personalInfo);
		return;
	}

	// 인적사항 삭제
	@Transactional
	@Override
	public boolean deletePersonal(int infoId) {
		int result = personalInfoDAO.deletePersonal(infoId);
		return result == 1;
	}
}
