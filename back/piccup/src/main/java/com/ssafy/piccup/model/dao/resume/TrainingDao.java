package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Training;

public interface TrainingDao {
	
	// 교육 조회 (resume 기반)
    public List<Training> selectAllTrainings(int resumeId);

    // 교육 추가
    public int insertTraining(Training training);
}
