package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
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
	
	// 교육 조회 (resume 기반)
	@Override
	public List<Training> readTrainingList(int resumeId) {
		List<Training> trainingList = trainingDao.selectAllTrainings(resumeId);
		return trainingList.isEmpty() ? new ArrayList<Training>() : trainingList;
	}

	// 교육 리스트 추가
	@Transactional
	@Override
	public void createTrainingList(List<Training> trainings, int resumeId) {
		int result = 0;
		try {
			for (Training training : trainings) {
				training.setResumeId(resumeId);
				if (trainingDao.insertTraining(training) == 1) result += 1;
			}
			if (result != trainings.size()) {
				throw new RuntimeException("create TrainingList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
