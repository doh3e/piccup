package com.ssafy.piccup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.exception.PersonalInfoNotFoundException;
import com.ssafy.piccup.model.dao.PersonalInfoDao;
import com.ssafy.piccup.model.dto.PersonalInfo;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{
	
    private final PersonalInfoDao personalInfoDao;

    public PersonalInfoServiceImpl(PersonalInfoDao personalInfoDao) {
    	this.personalInfoDao = personalInfoDao;
    }

    // 인적사항 전체 조회
	@Override
	public List<PersonalInfo> readPersonalList() {
		return personalInfoDao.selectAllPersonal();
	}

	// 특정 인적사항 조회
	@Override
	public PersonalInfo readPersonal(int infoId) {
		return personalInfoDao.selectOnePersonal(infoId);
	}
	
	// 인적사항 추가
	@Transactional
	@Override
	public boolean createPersonal(PersonalInfo personalInfo) {
		int result = personalInfoDao.insertPersonal(personalInfo);
		return result == 1;
	}

	// 인적사항 수정
	@Transactional
	@Override
	public boolean updatePersonal(PersonalInfo personalInfo) {
		PersonalInfo existingPersonal = personalInfoDao.selectOnePersonal(personalInfo.getInfoId());

	    if (existingPersonal == null) {
	        throw new PersonalInfoNotFoundException("해당 infoId의 인적사항은 없습니다.");
	    }
		
		int result = personalInfoDao.updatePersonal(personalInfo);
		return result == 1;
	}

	// 인적사항 삭제
	@Transactional
	@Override
	public boolean deletePersonal(int infoId) {
		int result = personalInfoDao.deletePersonal(infoId);
		return result == 1;
	}
}
