package com.ssafy.piccup.model.dao.resume;


import com.ssafy.piccup.model.dto.resume.PersonalInfo;

public interface PersonalInfoDao {

	// 인적사항 조회 (resume 기반)
    public PersonalInfo selectPersonalByResume(int resumeId);

    // 인적사항 저장 - 사진 별도
    public int insertPersonal(PersonalInfo personalInfo);
    
    // 인적사항 저장 - 사진
    public int updatePersonalFile(PersonalInfo personalInfo);
}
