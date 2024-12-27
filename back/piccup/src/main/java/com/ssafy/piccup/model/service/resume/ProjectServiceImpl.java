package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.ProjectDao;
import com.ssafy.piccup.model.dto.resume.Award;
import com.ssafy.piccup.model.dto.resume.Project;
import com.ssafy.piccup.model.dto.resume.Training;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectDao projectDao;
	
	public ProjectServiceImpl(ProjectDao ProjectDao) {
		this.projectDao = ProjectDao;
	}
	
	// 프로젝트 전체 조회
	@Override
	public List<Project> readProjectList(int resumeId) {
		List<Project> projectList = projectDao.selectAllProjects(resumeId);
		return projectList.isEmpty() ? new ArrayList<Project>() : projectList;
	}

    // 프로젝트 추가
	@Transactional
	@Override
	public boolean createProject(Project project) {
		int result = projectDao.insertProject(project);
		return result == 1;
	}

	// 프로젝트 리스트 추가
	@Transactional
	@Override
	public void createProjectList(List<Project> projects, int resumeId) {
		int result = 0;
		try {
			for (Project project : projects) {
				project.setResumeId(resumeId);
				if (projectDao.insertProject(project) == 1) result += 1;
			}
			if (result != projects.size()) {
				throw new RuntimeException("create ProjectList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }		
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
