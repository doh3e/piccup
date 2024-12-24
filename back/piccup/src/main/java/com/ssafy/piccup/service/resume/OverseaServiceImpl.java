package com.ssafy.piccup.service.resume;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.OverseaDao;
import com.ssafy.piccup.model.dto.resume.Oversea;

@Service
public class OverseaServiceImpl implements OverseaService {

	private final OverseaDao overseaDao;
	
	public OverseaServiceImpl(OverseaDao OverseaDao) {
		this.overseaDao = OverseaDao;
	}
	
	// 해외경험 전체 조회
	@Override
	public List<Oversea> readOverseaList() {
		return overseaDao.selectAllOverseas();
	}

    // 해외경험 추가
	@Transactional
	@Override
	public boolean createOversea(Oversea oversea) {
		int result = overseaDao.insertOversea(oversea);
		return result == 1;
	}

    // 해외경험 수정
	@Transactional
	@Override
	public boolean updateOversea(Oversea oversea) {
		int result = overseaDao.updateOversea(oversea);
		return result == 1;
	}

    // 해외경험 삭제
	@Transactional
	@Override
	public boolean deleteOversea(int overseaId) {
		int result = overseaDao.deleteOversea(overseaId);
		return result == 1;
	}

}
