package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.TrainingDao;
import com.ssafy.piccup.model.dto.resume.Award;
import com.ssafy.piccup.model.dto.resume.Training;

@Service
public class TrainingServiceImpl implements TrainingService {

	private final TrainingDao trainingDao;
	
	public TrainingServiceImpl(TrainingDao TrainingDao) {
		this.trainingDao = TrainingDao;
	}
	
	// 교육 전체 조회
	@Override
	public List<Training> readTrainingList(int resumeId) {
		List<Training> trainingList = trainingDao.selectAllTrainings(resumeId);
		return trainingList.isEmpty() ? new ArrayList<Training>() : trainingList;
	}

    // 교육 추가
	@Transactional
	@Override
	public boolean createTraining(Training training) {
		int result = trainingDao.insertTraining(training);
		return result == 1;
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
