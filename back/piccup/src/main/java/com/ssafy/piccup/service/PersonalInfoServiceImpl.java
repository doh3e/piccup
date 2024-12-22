package com.ssafy.piccup.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.exception.PersonalInfoNotFoundException;
import com.ssafy.piccup.model.dao.PersonalInfoDao;
import com.ssafy.piccup.model.dto.PersonalInfo;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{
	
    private final PersonalInfoDao personalInfoDao;
	private final ResourceLoader resourceLoader;

    public PersonalInfoServiceImpl(PersonalInfoDao personalInfoDao, ResourceLoader resourceLoader) {
    	this.personalInfoDao = personalInfoDao;
    	this.resourceLoader = resourceLoader;
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
	public boolean createPersonal(PersonalInfo personalInfo, MultipartFile file) {
		 try {
	            // 파일 저장 디렉토리
	            String uploadDir = "profile_images/";
				Resource resource = resourceLoader.getResource("classpath:/static/img");

	            // 저장 파일명 생성
	            String savedFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	            String savedFilePath = uploadDir + savedFileName;

	            // 파일 저장
	            file.transferTo(new File(savedFilePath));

	            // PersonalInfo 객체에 파일 정보 추가
	            personalInfo.setProfileImgPath(savedFilePath);
	            personalInfo.setProfileImgName(savedFileName);

	            // DB 저장
	            int result = personalInfoDao.insertPersonal(personalInfo);
	            return result == 1;

	        } catch (IOException e) {
	            throw new RuntimeException("파일 업로드 실패", e);
	        }
		 
//		int result = personalInfoDao.insertPersonal(personalInfo);
//		return result == 1;
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
	
	// 인적사항 사진 추가
	@Transactional
	@Override
	public boolean uploadFile(PersonalInfo personalInfo, MultipartFile file) {
		// 파일이 존재할 때 처리
		if (file != null && file.getSize() > 0) {
			try {
				String profileImgName = file.getOriginalFilename(); // 실제 파일이름
				String profileImgPath = UUID.randomUUID().toString(); // 고유한 파일이름 (확장자 없음)
				// 확장자 처리필요------------
				
				personalInfo.setProfileImgName(profileImgName);
				personalInfo.setProfileImgPath(profileImgPath);
				
				Resource resource = resourceLoader.getResource("classpath:/static/profile_images");
				file.transferTo(new File(resource.getFile(), profileImgPath)); // 파일저장
				
				personalInfoDao.insertPersonal(personalInfo);
				personalInfoDao.insertFile(personalInfo);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
}
