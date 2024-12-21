package com.ssafy.piccup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.PersonalInfoDao;
import com.ssafy.piccup.model.dto.PersonalInfo;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{
	
    private final PersonalInfoDao personalInfoDAO;

    public PersonalInfoServiceImpl(PersonalInfoDao personalInfoDao) {
    	this.personalInfoDAO = personalInfoDao;
    }

	@Override
	public List<PersonalInfo> readPersonalList() {
		return personalInfoDAO.selectAllPersonal();
	}

	@Override
	public PersonalInfo readPersonal(int infoId) {
		return personalInfoDAO.selectOnePersonal(infoId);
	}

	@Override
	public void createPersonal(PersonalInfo personalInfo) {
		personalInfoDAO.insertPersonal(personalInfo);
		return;
	}

	@Override
	public void updatePersonal(PersonalInfo personalInfo) {
		personalInfoDAO.updatePersonal(personalInfo);
		return;
	}

	@Override
	public void deletePersonalInfoById(int infoId) {
		personalInfoDAO.deletePersonal(infoId);
		return;
	}
}
