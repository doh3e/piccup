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

import com.ssafy.piccup.model.dao.resume.WorkExpDao;
import com.ssafy.piccup.model.dto.resume.Portfolio;
import com.ssafy.piccup.model.dto.resume.WorkExp;

@Service
public class WorkExpServiceImpl implements WorkExpService {

	private final WorkExpDao workExpDao;
	private final ResourceLoader resourceLoader; // 파일작업
	
	public WorkExpServiceImpl(WorkExpDao WorkExpDao, ResourceLoader resourceLoader) {
		this.workExpDao = WorkExpDao;
		this.resourceLoader = resourceLoader;
	}
	
	// 경력 전체 조회
	@Override
	public List<WorkExp> readWorkExpList() {
		return workExpDao.selectAllWorkExp();
	}

    // 경력 추가
	@Transactional
	@Override
	public boolean createWorkExp(WorkExp workExp, MultipartFile file) {
		int result = workExpDao.insertWorkExp(workExp);
		return result == 1;
	}

    // 경력 수정
	@Transactional
	@Override
	public boolean updateWorkExp(WorkExp workExp, MultipartFile file) {
		int result = workExpDao.updateWorkExp(workExp);
		return result == 1;
	}

    // 경력 삭제
	@Transactional
	@Override
	public boolean deleteWorkExp(int workExpId) {
		int result = workExpDao.deleteWorkExp(workExpId);
		return result == 1;
	}

	// 파일 추가
	@Transactional
	@Override
	public boolean uploadFile(WorkExp workExp, MultipartFile file) {
		// 파일이 존재할 때 처리
		if (file != null && file.getSize() > 0) {
			try {
				// 실제 파일이름 생성
				String expFileName = file.getOriginalFilename(); 
				
				// 확장자 추출
	            String fileExtension = "";
	            if (expFileName != null && expFileName.contains(".")) {
	                fileExtension = expFileName.substring(expFileName.lastIndexOf("."));
	            }
	            // 고유한 파일 이름 생성 (UUID + 확장자)
	            String expFilePath = UUID.randomUUID().toString() + fileExtension;
				
				workExp.setExpFileName(expFileName);
				workExp.setExpFilePath(expFilePath);
				
				Resource resource = resourceLoader.getResource("classpath:/static/portfolio_files");
				file.transferTo(new File(resource.getFile(), expFilePath)); // 파일저장
				
				return true; // 파일변환 성공
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return false;  // 파일 변환 실패
			}
		}
		return true;
	}
}
