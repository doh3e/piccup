package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Project;

public interface ProjectDao {
	
	// 프로젝트 전체 조회
    public List<Project> selectAllProjects(int resumeId);

    // 프로젝트 추가
    public int insertProject(Project project);

    // 프로젝트 수정
    public int updateProject(Project project);

    // 프로젝트 삭제
    public int deleteProject(int projectId);
}
