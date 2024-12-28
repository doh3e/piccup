package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Oversea;

public interface OverseaDao {
	
	// 해외경험 조회 (resume 기반)
    public List<Oversea> selectAllOverseas(int resumeId);

    // 해외경험 추가
    public int insertOversea(Oversea oversea);
}
