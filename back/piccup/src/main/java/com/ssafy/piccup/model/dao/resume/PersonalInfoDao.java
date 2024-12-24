package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.PersonalInfo;

public interface PersonalInfoDao {

	// 인적사항 전체 조회
    public List<PersonalInfo> selectAllPersonal();

    // 특정 인적사항 조회
    public PersonalInfo selectOnePersonal(int infoId);

    // 인적사항 저장
    public int insertPersonal(PersonalInfo personalInfo);

    // 인적사항 수정
    public int updatePersonal(PersonalInfo personalInfo);

    // 인적사항 삭제
    public int deletePersonal(int infoId); // 실제 테이블에서 건드려지는 개수 반환 (1개 삭제 -> 1 or 0)

    // 인적사항 사진 저장
	public void insertFile(PersonalInfo personalInfo);
}
