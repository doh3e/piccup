package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
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
	
	// 해외경험 조회 (resume 기반)
	@Override
	public List<Oversea> readOverseaList(int resumeId) {
		List<Oversea> overseaList = overseaDao.selectAllOverseas(resumeId);
		return overseaList.isEmpty() ? new ArrayList<Oversea>() : overseaList;
	}

	// 해외경험 리스트 추가
	@Transactional
	@Override
	public void createOverseaList(List<Oversea> overseas, int resumeId) {
		int result = 0;
		try {
			for (Oversea oversea : overseas) {
				oversea.setResumeId(resumeId);
				if (overseaDao.insertOversea(oversea) == 1) result += 1;
			}
			if (result != overseas.size()) {
				throw new RuntimeException("create OverseaList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
