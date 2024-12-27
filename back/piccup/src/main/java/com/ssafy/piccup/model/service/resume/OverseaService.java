package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Oversea;


public interface OverseaService {
	
	// 해외경험 전체 조회
    public List<Oversea> readOverseaList(int resumeId);

    // 해외경험 추가
    public boolean createOversea(Oversea oversea);
    
    // 해외경험 리스트 추가
    public void createOverseaList(List<Oversea> overseas, int resumeId);

    // 해외경험 수정
    public boolean updateOversea(Oversea oversea);

    // 해외경험 삭제
    public boolean deleteOversea(int overseaId);

}
