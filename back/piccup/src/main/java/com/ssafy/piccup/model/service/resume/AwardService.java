package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Award;


public interface AwardService {
	
	// 로그인 유저의 수상내역 전체 조회
    public List<Award> readAwardList(int resumeId);

    // 수상내역 추가
    public boolean createAward(Award award);
    
    // 수상내역 리스트 추가
    public void createAwardList(List<Award> awards, int resumeId);

    // 수상내역 수정
    public boolean updateAward(Award award);

    // 수상내역 삭제
    public boolean deleteAward(int awardId);

}
