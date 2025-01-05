package com.ssafy.piccup.model.dto.mydata;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 내 일정 (자소서에서 관리하는 일정 제외 따로 추가한 일정)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

	private int scheduleId; // 스케줄 고유 아이디

	@NotNull(message = "유저 ID는 필수입니다.")
	private int userId; // 유저 아이디 (외래키)

	@NotBlank(message = "스케줄명은 비어있을 수 없습니다.")
	private String scheduleName; // 스케줄명

	@NotNull(message = "시작 시간은 필수입니다.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startAt; // 일정 시작 시간

	@NotNull(message = "종료 시간은 필수입니다.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endAt; // 일정 종료 시간

	private int importance;

	// 시작시간과 종료시간 검증 메서드
	@JsonIgnore
	public boolean isValidTimeRange() {
		return startAt != null && endAt != null && !startAt.isAfter(endAt);
	}

}
