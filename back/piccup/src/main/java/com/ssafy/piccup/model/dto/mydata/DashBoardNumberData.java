package com.ssafy.piccup.model.dto.mydata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DB에서 계산한 대쉬보드의 수치적 데이터가 들어가는 dto 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashBoardNumberData {
	
	private int allApplies;
	private int progressingApplies;
	private int endApplies;
	
	// 합격률 계산을 위한 수치적 데이터 (서류탈락, 서류합격, 중간합격(인적성, 코딩테스트 등), 최종합격)
	// is_progressing이 false일 경우 계산
	private int seotal;
	private int seohap;
	private int joongdohap;
	private int finalhap;
}
