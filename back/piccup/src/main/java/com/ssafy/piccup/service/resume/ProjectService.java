package com.ssafy.piccup.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Project;


public interface ProjectService {
	
	// 프로젝트 전체 조회
    public List<Project> readProjectList();

    // 프로젝트 추가
    public boolean createProject(Project oversea);

    // 프로젝트 수정
    public boolean updateProject(Project oversea);

    // 프로젝트 삭제
    public boolean deleteProject(int overseaId);
}
