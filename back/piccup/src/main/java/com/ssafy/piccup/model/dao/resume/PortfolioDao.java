package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Portfolio;

public interface PortfolioDao {

	// 포트폴리오 전체 조회
    public List<Portfolio> selectAllPort();

    // 포트폴리오 저장
    public int insertPort(Portfolio portfolio);

    // 포트폴리오 수정
    public int updatePort(Portfolio portfolio);

    // 포트폴리오 삭제
    public int deletePort(int portId); // 실제 테이블에서 건드려지는 개수 반환 (1개 삭제 -> 1 or 0)

    // 포트폴리오 사진 저장
	public void insertFile(Portfolio portfolio);
}
