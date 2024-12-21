package com.ssafy.piccup.model.dao;

import java.util.List;

import com.ssafy.piccup.model.dto.PersonalInfo;

public interface PersonalInfoDao {

	// 인적사항 전체 조회
    public List<PersonalInfo> selectAllPersonal();

    // 특정 인적사항 조회
    public PersonalInfo selectOnePersonal(int infoId);

    // 인적사항 저장
    public void insertPersonal(PersonalInfo personalInfo);

    // 인적사항 수정
    public void updatePersonal(PersonalInfo personalInfo);

    // 인적사항 삭제
    public void deletePersonal(int infoId);
}
