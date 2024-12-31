package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Project;

public interface ProjectDao {
	
	// 프로젝트 조회 (resume 기반)
    public List<Project> selectAllProjects(int resumeId);

    // 프로젝트 추가
    public int insertProject(Project project);
}
