package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Award;

public interface AwardDao {
	
	// 수상내역 전체 조회
    public List<Award> selectAllAwards(int resumeId);

    // 수상내역 추가
    public int insertAward(Award award);

    // 수상내역 수정
    public int updateAward(Award award);

    // 수상내역 삭제
    public int deleteAward(int awardId);
}
