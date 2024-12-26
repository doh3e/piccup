package com.ssafy.piccup.model.service.resume;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.TrainingDao;
import com.ssafy.piccup.model.dto.resume.Training;

@Service
public class TrainingServiceImpl implements TrainingService {

	private final TrainingDao trainingDao;
	
	public TrainingServiceImpl(TrainingDao TrainingDao) {
		this.trainingDao = TrainingDao;
	}
	
	// 교육 전체 조회
	@Override
	public List<Training> readTrainingList() {
		return trainingDao.selectAllTrainings();
	}

    // 교육 추가
	@Transactional
	@Override
	public boolean createTraining(Training training) {
		int result = trainingDao.insertTraining(training);
		return result == 1;
	}

    // 교육 수정
	@Transactional
	@Override
	public boolean updateTraining(Training training) {
		int result = trainingDao.updateTraining(training);
		return result == 1;
	}

    // 교육 삭제
	@Transactional
	@Override
	public boolean deleteTraining(int trainingId) {
		int result = trainingDao.deleteTraining(trainingId);
		return result == 1;
	}

}
