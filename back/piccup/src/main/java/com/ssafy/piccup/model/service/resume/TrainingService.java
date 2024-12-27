package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Training;


public interface TrainingService {
	
	// 교육 전체 조회
    public List<Training> readTrainingList();

    // 교육 추가
    public boolean createTraining(Training training);

    // 교육 수정
    public boolean updateTraining(Training training);

    // 교육 삭제
    public boolean deleteTraining(int trainingId);
}
