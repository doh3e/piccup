package com.ssafy.piccup.service.resume;

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
	
	// 수상내역 전체 조회
	@Override
	public List<Award> readAwardList() {
		return awardDao.selectAllAwards();
	}

    // 수상내역 추가
	@Transactional
	@Override
	public boolean createAward(Award award) {
		int result = awardDao.insertAward(award);
		return result == 1;
	}

    // 수상내역 수정
	@Transactional
	@Override
	public boolean updateAward(Award award) {
		int result = awardDao.updateAward(award);
		return result == 1;
	}

    // 수상내역 삭제
	@Transactional
	@Override
	public boolean deleteAward(int awardId) {
		int result = awardDao.deleteAward(awardId);
		return result == 1;
	}

}
