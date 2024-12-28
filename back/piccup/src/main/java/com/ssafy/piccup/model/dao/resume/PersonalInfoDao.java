package com.ssafy.piccup.model.dao.resume;


import com.ssafy.piccup.model.dto.resume.PersonalInfo;

public interface PersonalInfoDao {

	// 인적사항 조회 (resume 기반)
    public PersonalInfo selectPersonalByResume(int resumeId);

    // 특정 인적사항 조회
    public PersonalInfo selectOnePersonal(int infoId);

    // 인적사항 저장 - 사진 별도
    public int insertPersonal(PersonalInfo personalInfo);
    
    // 인적사항 저장 - 사지만
    public int insertPersonalFile(PersonalInfo personalInfo);

    // 인적사항 수정 
    public int updatePersonal(PersonalInfo personalInfo);

    // 인적사항 삭제
    public int deletePersonal(int infoId); // 실제 테이블에서 건드려지는 개수 반환 (1개 삭제 -> 1 or 0)

    // 인적사항 수정 - 사진추가
    public int updatePersonalFile(PersonalInfo personalInfo);
}
