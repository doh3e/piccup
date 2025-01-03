package com.ssafy.piccup.model.dao.coverletter;

import java.util.List;

import com.ssafy.piccup.model.dto.coverletter.Apply;


public interface ApplyDao {
	public List<Apply> selectAll(int userId);
	
	public Apply selectOne(int applyId);
	
	public void insertApply(Apply apply);
	
	public void deleteApply(int applyId);
	
	public int updateApply(Apply apply);
	
	
}
