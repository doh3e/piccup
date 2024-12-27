package com.ssafy.piccup.model.service.resume;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.exception.PersonalInfoNotFoundException;
import com.ssafy.piccup.model.dao.resume.PersonalInfoDao;
import com.ssafy.piccup.model.dto.resume.PersonalInfo;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{
	
    private final PersonalInfoDao personalInfoDao;
	private final ResourceLoader resourceLoader; // 파일작업

    public PersonalInfoServiceImpl(PersonalInfoDao personalInfoDao, ResourceLoader resourceLoader) {
    	this.personalInfoDao = personalInfoDao;
    	this.resourceLoader = resourceLoader;
    }

    // 인적사항 조회 (resume 기반)
	@Override
	public PersonalInfo readPersonalByResume(int resumeId) {
	    return personalInfoDao.selectPersonalByResume(resumeId);
	}
	
	// 특정 인적사항 조회
	@Override
	public PersonalInfo readPersonal(int infoId) {
		return personalInfoDao.selectOnePersonal(infoId);
	}
	
	// 인적사항 추가 - 파일 별도
	@Transactional
	@Override
	public boolean createPersonal(PersonalInfo personalInfo) {
		if (!Arrays.asList("남", "여", "미지정").contains(personalInfo.getGender())){
	        personalInfo.setGender("미지정");
	    }
		if (!Arrays.asList("미지정", "중등교육이수", "학사", "석사", "박사").contains(personalInfo.getDegree())) {
			personalInfo.setDegree("미지정");
		}
		int result = personalInfoDao.insertPersonal(personalInfo);
		return result == 1;
	}

	// 인적사항 수정
	@Transactional
	@Override
	public boolean updatePersonal(PersonalInfo personalInfo, MultipartFile file) {
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
	
	// 사진 추가
	@Transactional
	@Override
	public void uploadFile(PersonalInfo personalInfo, MultipartFile file) {
		// 파일이 존재할 때 처리
			try {
				if (file != null && file.getSize() > 0) {
					// 실제 파일이름 생성
					String profileImgName = file.getOriginalFilename(); 
					
					// 확장자 추출
		            String fileExtension = "";
		            if (profileImgName != null && profileImgName.contains(".")) {
		                fileExtension = profileImgName.substring(profileImgName.lastIndexOf("."));
		            }
		            // 고유한 파일 이름 생성 (UUID + 확장자)
		            String profileImgPath = UUID.randomUUID().toString() + fileExtension;
					
					personalInfo.setProfileImgName(profileImgName);
					personalInfo.setProfileImgPath(profileImgPath);
					
					Resource resource = resourceLoader.getResource("classpath:/static/profile_images");
					file.transferTo(new File(resource.getFile(), profileImgPath)); // 파일저장
					
					if (personalInfoDao.updatePersonalFile(personalInfo) != 1) {
						throw new RuntimeException(" upload Profile Image 실패");
					}
				}
			} catch (IOException e) {
		        throw new RuntimeException("파일 처리 중 오류 발생", e);
		    } catch (Exception e) {
		        throw new RuntimeException("프로필 이미지 업로드 중 알 수 없는 오류 발생", e);
			}
	}
}
