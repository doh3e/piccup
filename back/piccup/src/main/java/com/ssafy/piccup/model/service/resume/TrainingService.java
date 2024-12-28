package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Training;


public interface TrainingService {
	
	// 교육 조회 (resume 기반)
    public List<Training> readTrainingList(int resumeId);
    
    // 교육 리스트 추가
    public void createTrainingList(List<Training> trainings, int resumeId);
}
