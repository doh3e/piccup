package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Oversea;


public interface OverseaService {
	
	// 해외경험 조회 (resume 기반)
    public List<Oversea> readOverseaList(int resumeId);

    // 해외경험 리스트 추가
    public void createOverseaList(List<Oversea> overseas, int resumeId);
}
