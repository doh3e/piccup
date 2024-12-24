package com.ssafy.piccup.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Award;


public interface AwardService {
	
	// 수상내역 전체 조회
    public List<Award> readAwardList();

    // 수상내역 추가
    public boolean createAward(Award oversea);

    // 수상내역 수정
    public boolean updateAward(Award oversea);

    // 수상내역 삭제
    public boolean deleteAward(int overseaId);
}
