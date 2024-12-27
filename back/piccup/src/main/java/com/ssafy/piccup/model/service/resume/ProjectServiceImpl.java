package com.ssafy.piccup.model.service.resume;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.ProjectDao;
import com.ssafy.piccup.model.dto.resume.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectDao projectDao;
	
	public ProjectServiceImpl(ProjectDao ProjectDao) {
		this.projectDao = ProjectDao;
	}
	
	// 프로젝트 전체 조회
	@Override
	public List<Project> readProjectList() {
		return projectDao.selectAllProjects();
	}

    // 프로젝트 추가
	@Transactional
	@Override
	public boolean createProject(Project project) {
		int result = projectDao.insertProject(project);
		return result == 1;
	}

    // 프로젝트 수정
	@Transactional
	@Override
	public boolean updateProject(Project project) {
		int result = projectDao.updateProject(project);
		return result == 1;
	}

    // 프로젝트 삭제
	@Transactional
	@Override
	public boolean deleteProject(int projectId) {
		int result = projectDao.deleteProject(projectId);
		return result == 1;
	}

}
