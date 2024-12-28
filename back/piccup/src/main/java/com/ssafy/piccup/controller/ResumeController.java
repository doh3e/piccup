package com.ssafy.piccup.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.resume.PersonalInfo;
import com.ssafy.piccup.model.dto.resume.Preference;
import com.ssafy.piccup.model.dto.resume.Resume;
import com.ssafy.piccup.model.dto.resume.ResumeSimple;
import com.ssafy.piccup.model.service.resume.ActivityService;
import com.ssafy.piccup.model.service.resume.AwardService;
import com.ssafy.piccup.model.service.resume.CertificationService;
import com.ssafy.piccup.model.service.resume.EducationService;
import com.ssafy.piccup.model.service.resume.FileService;
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

import jakarta.validation.Valid;

// 이력서 도메인 - 이력서
@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 의존성 주입
	private final ResumeService resumeService;
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
	private final FileService fileService;
	
	public ResumeController(
			ActivityService activityService,
			AwardService awardService,
			CertificationService certificationService,
			EducationService educationService,
			FileService fileService,
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
		this.activityService = activityService;
		this.awardService = awardService;
		this.certificationService = certificationService;
		this.educationService = educationService;
		this.fileService = fileService;
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
	
	// 조회
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
				ResumeSimple resumeSimple = new ResumeSimple();
				resumeSimple.setResumeId(resumeId);	
				resumeSimple.setUserId(userId);
				resumeSimple.setUpdatedAt(resume.getUpdatedAt());
				
				// 데이터 조회
				resultMap.put("resume", resumeSimple);
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
		        Map<String, Object> fileDetail = new HashMap<>();
		        fileDetail.put("eduFile", fileService.readEduFile(resumeId));
		        fileDetail.put("portFiles", fileService.readPortFileList(resumeId));
		        fileDetail.put("workFile", fileService.readWorkFile(resumeId));
		        // 빈 객체 설정 (null -> {})
		        if (resultMap.get("personalInfo") == null) {
		        	resultMap.put("personalInfo", new HashMap<>());
		        }
		        if (resultMap.get("preference") == null) {
		        	resultMap.put("preference", new HashMap<>());
		        }
		        if (fileDetail.get("eduFile") == null) {
		        	fileDetail.put("eduFile", new HashMap<>());
		        }
		        if (fileDetail.get("workFile") == null ) {
		        	fileDetail.put("workFile", new HashMap<>());
		        }
		        resultMap.put("files", fileDetail);

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
	
	// 생성 (json, 삭제 후 생성)
	@PostMapping("")
	public ResponseEntity<?> writeResume(@Valid @RequestBody Resume resumeRequest, BindingResult bindingResult) {
		// 유효성 검증 오류 처리
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }
//        System.out.println(bindingResult.hasErrors());
		
		// 현재 인증 정보에서 userId 추출 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; 				// 토큰
        int userId = jwtAuth.getUserId();
		        
		// 응답 데이터 구성
		Map<String, Object> resultMap = new HashMap<>();
	    HttpStatus status = HttpStatus.ACCEPTED;

	    try {
	        // Resume 저장
	        Resume resume = new Resume();
	        resume.setUserId(userId);
	        resumeService.createResume(resume);
	        int resumeId = resume.getResumeId();
	        
	        // 다중 데이터 저장
	        // - 데이터 처리 매핑
	        Map<List<?>, Consumer<Integer>> serviceMap = new HashMap<>();
	        // - 각 엔티티 리스트 매핑
	        serviceMap.put(resumeRequest.getActivities(), id -> activityService.createActivityList(resumeRequest.getActivities(), id));
	        serviceMap.put(resumeRequest.getAwards(), id -> awardService.createAwardList(resumeRequest.getAwards(), id));
	        serviceMap.put(resumeRequest.getCertifications(), id -> certificationService.createCertificationList(resumeRequest.getCertifications(), id));
	        serviceMap.put(resumeRequest.getEducations(), id -> educationService.createEducationList(resumeRequest.getEducations(), id));
	        serviceMap.put(resumeRequest.getLanguages(), id -> languageService.createLanguageList(resumeRequest.getLanguages(), id));
	        serviceMap.put(resumeRequest.getOverseas(), id -> overseaService.createOverseaList(resumeRequest.getOverseas(), id));
	        serviceMap.put(resumeRequest.getPapers(), id -> paperService.createPaperList(resumeRequest.getPapers(), id));
	        serviceMap.put(resumeRequest.getPatents(), id -> patentService.createPatentList(resumeRequest.getPatents(), id));
	        serviceMap.put(resumeRequest.getPortfolios(), id -> portfolioService.createPortfolioList(resumeRequest.getPortfolios(), id));
	        serviceMap.put(resumeRequest.getProjects(), id -> projectService.createProjectList(resumeRequest.getProjects(), id));
	        serviceMap.put(resumeRequest.getSkills(), id -> skillService.createSkillList(resumeRequest.getSkills(), id));
	        serviceMap.put(resumeRequest.getTrainings(), id -> trainingService.createTrainingList(resumeRequest.getTrainings(), id));
	        serviceMap.put(resumeRequest.getWorkExperiences(), id -> workExpService.createWorkExpList(resumeRequest.getWorkExperiences(), id));
	        // - 반복문으로 처리
	        for (Map.Entry<List<?>, Consumer<Integer>> entry : serviceMap.entrySet()) {
	            List<?> entityList = entry.getKey();
	            if (entityList != null && !entityList.isEmpty()) {
	                entry.getValue().accept(resumeId);
	            }
	        }
	        
	        // 단일 데이터 저장
	        // - PersonalInfo 저장
	        PersonalInfo personalInfo = resumeRequest.getPersonalInfo();
	        if (personalInfo != null) {
	            personalInfo.setResumeId(resumeId);
	            personalInfoService.createPersonal(personalInfo);
	        }
	        // - Preference 저장
	        Preference preference = resumeRequest.getPreference();
	        if (preference != null) {
	            preference.setResumeId(resumeId);
	            preferenceService.createPreference(preference);
	        }
	        
	        // 응답 데이터
	        resultMap.put("message", "이력서 생성 성공하였습니다.");
	        status = HttpStatus.CREATED;
	        
	    } catch (RuntimeException e) {
	    	resultMap.put("message", e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : ""); // 상세 원인
	        status = HttpStatus.BAD_REQUEST;
	        
        } catch (Exception e) {
	        resultMap.put("message", "Resume 생성 실패: " + e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : "");
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
	    }
	    return new ResponseEntity<>(resultMap, status);
	}
	
	// 생성 (form-data)
	@PostMapping("/files")
	public ResponseEntity<?> writeResumeFile(
			@RequestParam(value = "personalFile", required = false) MultipartFile personalFile,
			@RequestParam(value = "portFile", required = false) MultipartFile portFile,
			@RequestParam(value="eduFile", required = false) MultipartFile eduFile,
			@RequestParam(value="workFile", required = false) MultipartFile workFile) {
		
		// 현재 인증 정보에서 userId 추출 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; 				// 토큰
        int userId = jwtAuth.getUserId();
		        
		// 응답 데이터 구성
		Map<String, Object> resultMap = new HashMap<>();
	    HttpStatus status = HttpStatus.ACCEPTED;

	    try {
	    	
	    	Resume resume = resumeService.findByUserId(userId);
	        int resumeId = resume.getResumeId();
	        
	        // 파일 업로드
        	personalInfoService.uploadFile(resumeId, personalFile); // 프로필 사진
        	fileService.uploadPortFile(resumeId, portFile); 		// 포트폴리오 파일
        	fileService.uploadEduFile(resumeId, eduFile); 			// 성적증명서
        	fileService.uploadWorkFile(resumeId, workFile); 		// 경력증명서
        	
	        // 응답 데이터
	        resultMap.put("message", "이력서 내 파일 저장 성공하였습니다.");
	        status = HttpStatus.CREATED;
	    }
	    catch (RuntimeException e) {
	    	resultMap.put("message", e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : ""); // 상세 원인
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
	        
        } catch (Exception e) {
	        resultMap.put("message", "Resume File 생성 실패: " + e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : "");
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
	    }
	    return new ResponseEntity<>(resultMap, status);
    }
	
	// 삭제
	@DeleteMapping("")
	public ResponseEntity<?> removeResume(){

		// 현재 인증 정보에서 userId 추출 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; 				// 토큰
        int userId = jwtAuth.getUserId();
		        
		// 응답 데이터 구성
		Map<String, Object> resultMap = new HashMap<>();
	    HttpStatus status = HttpStatus.ACCEPTED;
	    
	    try {
		    // 요청한 유저의 이력서 삭제
		    resumeService.deleteResumeByUser(userId);
	        // 응답 데이터
	        resultMap.put("message", "이력서 삭제 성공하였습니다.");
	        status = HttpStatus.CREATED;
	        
	    } catch (RuntimeException e) {
	    	resultMap.put("message", e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : ""); // 상세 원인
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception e) {
	        resultMap.put("message", "Resume File 생성 실패: " + e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : "");
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
	    }
	    return new ResponseEntity<>(resultMap, status);
	}
	
}
