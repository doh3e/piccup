package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Patent;


public interface PatentService {
	
	// 특허 조회 (resume 기반)
    public List<Patent> readPatentList(int resumeId);

    // 특허 리스트 추가
    public void createPatentList(List<Patent> patents, int resumeId);
}
