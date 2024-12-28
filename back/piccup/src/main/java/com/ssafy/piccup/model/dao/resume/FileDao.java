package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.FileDto;

public interface FileDao {

	// 성적증명서
	
	// - 추가
	public int insertEduFile(FileDto fileDto);
	// - 조회
	public FileDto selectEduFile(int resumeId);
	
	// 포트폴리오 파일
	
	// - 추가
	public int insertPortFile(FileDto fileDto);
	// - 조회
	public List<FileDto> selectPortFileList(int resumeId);
	
	// 경력증명서
	
	// - 추가
	public int insertWorkFile(FileDto fileDto);
	// - 조회
	public FileDto selectWorkFile(int resumeId);
}
