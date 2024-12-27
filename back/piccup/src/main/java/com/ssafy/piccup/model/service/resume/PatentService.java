package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Patent;


public interface PatentService {
	
	// 특허 전체 조회 (resume 기반)
    public List<Patent> readPatentList(int resumeId);

    // 특허 추가
    public boolean createPatent(Patent oversea);

    // 특허 리스트 추가
    public void createPatentList(List<Patent> patents, int resumeId);

    // 특허 수정
    public boolean updatePatent(Patent oversea);

    // 특허 삭제
    public boolean deletePatent(int overseaId);

}
