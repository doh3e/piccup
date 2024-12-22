package com.ssafy.piccup.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.PersonalInfo;

public interface PersonalInfoService {
	
	// 인적사항 전체 조회
    public List<PersonalInfo> readPersonalList();

    // 특정 인적사항 조회
    public PersonalInfo readPersonal(int infoId);

    // 인적사항 추가
    public boolean createPersonal(PersonalInfo personalInfo, MultipartFile file);

    // 인적사항 수정
    public boolean updatePersonal(PersonalInfo personalInfo);

    // 인적사항 삭제
    public boolean deletePersonal(int infoId);
    
    // 인적사항 사진 추가
    public boolean uploadFile(PersonalInfo personalInfo, MultipartFile file);
}
