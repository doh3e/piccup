package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Training;

public interface TrainingDao {
	
	// 교육 전체 조회
    public List<Training> selectAllTrainings();

    // 교육 추가
    public int insertTraining(Training training);

    // 교육 수정
    public int updateTraining(Training training);

    // 교육 삭제
    public int deleteTraining(int trainingId);
}
