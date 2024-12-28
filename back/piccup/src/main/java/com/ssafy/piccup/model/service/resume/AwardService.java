package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Award;


public interface AwardService {
	
	// 수상내역 조회 (resume 기반)
    public List<Award> readAwardList(int resumeId);

    // 수상내역 리스트 추가
    public void createAwardList(List<Award> awards, int resumeId);
}
