package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Award;

public interface AwardDao {
	
	// 수상내역 조회 (resume 기반)
    public List<Award> selectAllAwards(int resumeId);

    // 수상내역 추가
    public int insertAward(Award award);
}
