package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.coverletter.Apply;

@Service
public interface ApplyService {
	public List<Apply> getApplyListByUserId(int userId);
	
	public Apply viewApply(int id);
	
	public void addApply(Apply apply);
	
	public void removeApply(int applyId);
	
	public boolean updateApply(Apply apply);
}
