package com.ssafy.piccup.model.dao.resume;

import com.ssafy.piccup.model.dto.resume.FileDto;

public interface FileDao {

	// 성적증명서
	
	// - 추가
	public int insertEduFile(FileDto fileDto);
	
	// 포트폴리오 파일
	
	// - 추가
	public int insertPortFile(FileDto fileDto);
	
	// 경력증명서
	
	// - 추가
	public int insertWorkFile(FileDto fileDto);
}
