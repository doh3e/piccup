package com.ssafy.piccup.controller.resume;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.resume.Resume;
import com.ssafy.piccup.model.service.resume.ActivityService;
import com.ssafy.piccup.model.service.resume.AwardService;
import com.ssafy.piccup.model.service.resume.CertificationService;
import com.ssafy.piccup.model.service.resume.EducationService;
import com.ssafy.piccup.model.service.resume.LanguageService;
import com.ssafy.piccup.model.service.resume.OverseaService;
import com.ssafy.piccup.model.service.resume.PaperService;
import com.ssafy.piccup.model.service.resume.PatentService;
import com.ssafy.piccup.model.service.resume.PersonalInfoService;
import com.ssafy.piccup.model.service.resume.PortfolioService;
import com.ssafy.piccup.model.service.resume.PreferenceService;
import com.ssafy.piccup.model.service.resume.ProjectService;
import com.ssafy.piccup.model.service.resume.ResumeService;
import com.ssafy.piccup.model.service.resume.SkillService;
import com.ssafy.piccup.model.service.resume.TrainingService;
import com.ssafy.piccup.model.service.resume.WorkExpService;
import com.ssafy.piccup.util.JwtUtil;

// 이력서 도메인 - 이력서
@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 의존성 주입
	private final ResumeService resumeService;
	private final JwtUtil jwtUtil;
	private final ActivityService activityService;
	private final AwardService awardService;
	private final CertificationService certificationService;
	private final EducationService educationService;
	private final LanguageService languageService;
	private final OverseaService overseaService;
	private final PaperService paperService;
	private final PatentService patentService;
	private final PersonalInfoService personalInfoService;
	private final PortfolioService portfolioService;
	private final PreferenceService preferenceService;
	private final ProjectService projectService;
	private final SkillService skillService;
	private final TrainingService trainingService;
	private final WorkExpService workExpService;
	
	public ResumeController(
			JwtUtil jwtUtil,
			ActivityService activityService,
			AwardService awardService,
			CertificationService certificationService,
			EducationService educationService,
			LanguageService languageService,
			OverseaService overseaService,
			PaperService paperService,
			PatentService patentService,
			PersonalInfoService personalInfoService,
			PortfolioService portfolioService,
			PreferenceService preferenceService,
			ProjectService projectService,
			ResumeService resumeService,
			SkillService skillService,
			TrainingService trainingService,
			WorkExpService workExpService) {
		this.jwtUtil = jwtUtil;
		this.activityService = activityService;
		this.awardService = awardService;
		this.certificationService = certificationService;
		this.educationService = educationService;
		this.languageService = languageService;
		this.overseaService = overseaService;
		this.paperService = paperService;
		this.patentService = patentService;
		this.personalInfoService = personalInfoService;
		this.portfolioService = portfolioService;
		this.preferenceService = preferenceService;
		this.projectService = projectService;
		this.resumeService = resumeService;
		this.skillService = skillService;
		this.trainingService = trainingService;
		this.workExpService = workExpService;
	}
	
	// 이력서 조회
	@GetMapping("")
	public ResponseEntity<?> getResume(){
		// 현재 인증 정보에서 userId 추출 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; 				// 토큰
        int userId = jwtAuth.getUserId();
        
        // 반환데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
	            
        // 이력서 정보 - userId와 연결된 이력서
		try {
			// 데이터 조회
			Resume resume = resumeService.findByUserId(userId);

			if (resume == null) {
				/* 이력서가 없는 경우 */
				status = HttpStatus.NO_CONTENT; // body 없음
			} else {
				/* 이력서가 있는 경우 */
				int resumeId = resume.getResumeId();

				// 데이터 조회
				resultMap.put("resume", resume);
				resultMap.put("activities", activityService.readActivityList(resumeId));
		        resultMap.put("awards", awardService.readAwardList(resumeId));
		        resultMap.put("personalInfo", personalInfoService.readPersonalByResume(resumeId));
		        resultMap.put("certifications", certificationService.readCertificationList(resumeId));
		        resultMap.put("educations", educationService.readEducationList(resumeId));
		        resultMap.put("languages", languageService.readLanguageList(resumeId));
		        resultMap.put("overseas", overseaService.readOverseaList(resumeId));
		        resultMap.put("papers", paperService.readPaperList(resumeId));
		        resultMap.put("patents", patentService.readPatentList(resumeId));
		        resultMap.put("portfolios", portfolioService.readPortList(resumeId));
		        resultMap.put("preference", preferenceService.readPreferenceByResume(resumeId));
		        resultMap.put("projects", projectService.readProjectList(resumeId));
		        resultMap.put("skills", skillService.readSkillList(resumeId));
		        resultMap.put("trainings", trainingService.readTrainingList(resumeId));
		        resultMap.put("workExperiences", workExpService.readWorkExpList(resumeId));
		        
		        // 빈 객체 설정 (null -> {})
		        if (resultMap.get("personalInfo") == null) {
		            resultMap.put("personalInfo", new HashMap<>());
		        }
		        if (resultMap.get("preference") == null) {
		        	resultMap.put("preference", new HashMap<>());
		        }

				// 응답 데이터 구성
				status = HttpStatus.OK;
			}
		} catch (Exception e) {
		    resultMap.clear(); // 초기화
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeResume (@RequestHeader("Authorization") String header) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
	
		if (jwtUtil.checkToken(header)) {
			// 사용가능한 토큰
			try {
				// 사용자 정보 - JWT 토큰에서 userId 추출
	            String token = header.startsWith("Bearer ") ? header.substring(7) : header;
	            int userId = jwtUtil.getUserId(token);
	            System.out.println("결과: "+jwtUtil.getUserId(token));
	            
	            // 이력서 생성
	            Resume resume = new Resume();
	            resume.setUserId(userId);
	            boolean isCreated = resumeService.createResume(resume);
	            
	            if (isCreated) {
	            	resultMap.put("message", "이력서가 등록되었습니다.");
	            	status = HttpStatus.CREATED;
	            }
			} catch (Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}else {
			resultMap.put("message", "인증정보가 유효하지 않습니다.");
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
// 검색 예 - DTO, Service 등 추가 작성 필요
//	@GetMapping("/search")
//	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
//		List<PersonalInfo> list = personalInfoService.search(condition);
//		
//		if(list == null || list.size() == 0) {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<PersonalInfo>>(list, HttpStatus.OK);
//	}
	
}
