package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Oversea;

public interface OverseaDao {
	
	// 해외경험 전체 조회
    public List<Oversea> selectAllOverseas(int resumeId);

    // 해외경험 추가
    public int insertOversea(Oversea oversea);

    // 해외경험 수정
    public int updateOversea(Oversea oversea);

    // 해외경험 삭제
    public int deleteOversea(int overseaId);
}
