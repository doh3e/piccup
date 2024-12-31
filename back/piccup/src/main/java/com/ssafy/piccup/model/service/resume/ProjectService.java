package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Project;


public interface ProjectService {
	
	// 프로젝트 조회 (resume 기반)
    public List<Project> readProjectList(int resumeId);

    // 프로젝트 리스트 추가
    public void createProjectList(List<Project> projects, int resumeId);
}