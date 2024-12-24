package com.ssafy.piccup.model.dao;

import java.util.List;

import com.ssafy.piccup.model.dto.Apply;


public interface ApplyDao {
	public List<Apply> selectAll();
	
	public Apply selectOne(int applyId);
	
	public void insertApply(Apply apply);
	
	public void deleteApply(int applyId);
	
	public int updateApply(Apply apply);
	
	
}
