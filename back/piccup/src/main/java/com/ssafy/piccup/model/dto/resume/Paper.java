package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Paper {
	private int paperId;
	private int resumeId; // 외래키
	@NotBlank(message = "논문 제목은 필수입니다. (Not Blank)")
	@NotNull(message = "논문 제목은 필수입니다. (Not Null)")
	private String paperTitle;
	@NotBlank(message = "출판지는 필수입니다. (Not Blank)")
	@NotNull(message = "출판지는 필수입니다. (Not Null)")
	private String journal;
	@PastOrPresent(message = "출간일은 미래일 수 없습니다.")
	private LocalDate publishedDate;
	private String description;
	
	public Paper() {
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getPaperTitle() {
		return paperTitle;
	}

	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}