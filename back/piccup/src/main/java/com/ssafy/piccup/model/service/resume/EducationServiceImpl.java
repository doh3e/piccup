package com.ssafy.piccup.model.service.resume;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dao.resume.EducationDao;
import com.ssafy.piccup.model.dto.resume.Education;
import com.ssafy.piccup.model.dto.resume.PersonalInfo;

@Service
public class EducationServiceImpl implements EducationService {

	private final EducationDao educationDao;
	private final ResourceLoader resourceLoader;
	
	public EducationServiceImpl(EducationDao EducationDao, ResourceLoader resourceLoader) {
		this.educationDao = EducationDao;
		this.resourceLoader = resourceLoader;
	}
	
	// 학력 전체 조회
	@Override
	public List<Education> readEducationList() {
		return educationDao.selectAllEducation();
	}

    // 학력 추가
	@Transactional
	@Override
	public boolean createEducation(Education education, MultipartFile file) {
		int result = educationDao.insertEducation(education);
		return result == 1;
	}

    // 학력 수정
	@Transactional
	@Override
	public boolean updateEducation(Education education, MultipartFile file) {
		int result = educationDao.updateEducation(education);
		return result == 1;
	}

    // 학력 삭제
	@Transactional
	@Override
	public boolean deleteEducation(int eduId) {
		int result = educationDao.deleteEducation(eduId);
		return result == 1;
	}

	// 성적증명서 추가
	@Transactional
	@Override
	public boolean uploadFile(Education education, MultipartFile file) {
		// 파일이 존재할 때 처리
		if (file != null && file.getSize() > 0) {
			try {
				// 실제 파일이름 생성
				String transcriptFileName = file.getOriginalFilename(); 
				
				// 확장자 추출
	            String fileExtension = "";
	            if (transcriptFileName != null && transcriptFileName.contains(".")) {
	                fileExtension = transcriptFileName.substring(transcriptFileName.lastIndexOf("."));
	            }
	            // 고유한 파일 이름 생성 (UUID + 확장자)
	            String transcriptFilePath = UUID.randomUUID().toString() + fileExtension;
				
				education.setTranscriptFileName(transcriptFileName);
				education.setTranscriptFilePath(transcriptFilePath);
				
				Resource resource = resourceLoader.getResource("classpath:/static/education_files");
				file.transferTo(new File(resource.getFile(), transcriptFilePath)); // 파일저장
				
				return true; // 파일변환 성공
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return false; // 파일 변환 실패
	}
}
