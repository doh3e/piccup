package com.ssafy.piccup.model.dto.mydata;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 대쉬보드에 들어갈 항목들
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashBoard {

	@NotNull(message = "유저 ID는 필수입니다.")
	private int userId; // 유저 아이디 (외래키)

	// apply에서 가져오는 정보들
	private int applyId;
	private String companyName;
	private String companySize;
	private String job;
	private String industry;

	// applyStatus(테이블명 apply_status)에서 가져오는 정보들
	private boolean isProgressing;
	private String currentStatus;

	// feedback과 coverletter는 따로 가져올 예정

}
