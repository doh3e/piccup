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
	
	// 인적사항 추가 - 파일 별도
	@Transactional
	@Override
	public boolean createPersonal(PersonalInfo personalInfo) {
		if (!Arrays.asList("미지정", "중등교육이수", "학사", "석사", "박사").contains(personalInfo.getDegree())) {
			personalInfo.setDegree("미지정");
		}
		int result = personalInfoDao.insertPersonal(personalInfo);
		return result == 1;
	}

	// 사진 추가
	@Transactional
	@Override
	public void uploadFile(int resumeId, MultipartFile file) {
		// 파일이 존재할 때 처리
		try {
			if (file != null && file.getSize() > 0) {
				// 파일변환
				// - 실제 파일이름 생성
				String profileImgName = file.getOriginalFilename(); 
				// - 확장자 추출
	            String fileExtension = "";
	            if (profileImgName != null && profileImgName.contains(".")) {
	                fileExtension = profileImgName.substring(profileImgName.lastIndexOf("."));
	            }
	            // - 고유한 파일 이름 생성 (UUID + 확장자)
	            String profileImgPath = UUID.randomUUID().toString() + fileExtension;

	            // 인적사항 존재하면 수정, 없다면 필수필드 에러 발생
	            PersonalInfo personalInfo = personalInfoDao.selectPersonalByResume(resumeId);
	            if (personalInfo == null) {
	            	throw new RuntimeException("생성된 인적사항이 없습니다. 필수 필드(email, degree)를 포함하여 인적사항을 생성해야 합니다.");
	            }
	            
	            personalInfo.setProfileImgName(profileImgName);
	            personalInfo.setProfileImgPath(profileImgPath);
	            Resource resource = resourceLoader.getResource("classpath:/static/profile_images");
	            file.transferTo(new File(resource.getFile(), profileImgPath)); // 파일저장
	            
	            if (personalInfoDao.updatePersonalFile(personalInfo) != 1) {
	            	throw new RuntimeException(" upload Profile Image 실패 : ");
	            }
			}
		} catch (IOException e) {
			e.printStackTrace();
	        throw new RuntimeException("파일 입출력 오류 발생 : " + e.getMessage(), e);
	    } catch (Exception e) {
	        throw new RuntimeException("프로필 이미지 업로드 실패 : "+ e.getMessage(), e);
		}
	}
}
