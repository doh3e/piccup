package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.AwardDao;
import com.ssafy.piccup.model.dto.resume.Award;

@Service
public class AwardServiceImpl implements AwardService {

	private final AwardDao awardDao;
	
	public AwardServiceImpl(AwardDao AwardDao) {
		this.awardDao = AwardDao;
	}
	
	// 수상내역 조회 (resume 기반)
	@Override
	public List<Award> readAwardList(int resumeId) {
		List<Award> awardList = awardDao.selectAllAwards(resumeId);
		return awardList.isEmpty() ? new ArrayList<Award>() : awardList;
	}
	
	// 수상내역 리스트 추가
	@Transactional
	@Override
	public void createAwardList(List<Award> awards, int resumeId) {
		int result = 0;
		try {
			for (Award award : awards) {
				award.setResumeId(resumeId);
				if (awardDao.insertAward(award) == 1) result += 1;
			}
			if (result != awards.size()) {
				throw new RuntimeException("create AwardList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
