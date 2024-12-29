package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
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
	
	// 프로젝트 조회 (resume 기반)
	@Override
	public List<Project> readProjectList(int resumeId) {
		List<Project> projectList = projectDao.selectAllProjects(resumeId);
		return projectList.isEmpty() ? new ArrayList<Project>() : projectList;
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
}
