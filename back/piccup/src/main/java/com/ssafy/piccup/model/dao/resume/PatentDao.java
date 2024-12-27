package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Patent;

public interface PatentDao {
	
	// 특허 전체 조회
    public List<Patent> selectAllPatents(int resumeId);

    // 특허 추가
    public int insertPatent(Patent patent);

    // 특허 수정
    public int updatePatent(Patent patent);

    // 특허 삭제
    public int deletePatent(int patentId);
}
