package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Patent;

public interface PatentDao {
	
	// 특허 조회 (resume 기반)
    public List<Patent> selectAllPatents(int resumeId);

    // 특허 추가
    public int insertPatent(Patent patent);
}
