package com.ssafy.piccup.model.service.resume;



import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.resume.PersonalInfo;

public interface PersonalInfoService {
	
	// 인적사항 조회 (resume기반)
    public PersonalInfo readPersonalByResume(int resumeId);

    // 인적사항 생성 - 사진 별도
    public boolean createPersonal(PersonalInfo personalInfo);
    
    // 인적사항 생성 or 수정 - 사진만
    public void uploadFile(int resumeId, MultipartFile file);
    
    // 인적사항 파일조회 
    public File readFile(String fileUuid) throws IOException;

}
