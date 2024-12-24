package com.ssafy.piccup.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Patent;


public interface PatentService {
	
	// 특허 전체 조회
    public List<Patent> readPatentList();

    // 특허 추가
    public boolean createPatent(Patent oversea);

    // 특허 수정
    public boolean updatePatent(Patent oversea);

    // 특허 삭제
    public boolean deletePatent(int overseaId);
}
