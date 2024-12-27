package com.ssafy.piccup.controller.resume;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.resume.*;
import com.ssafy.piccup.model.service.resume.*;

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
	
	public ResumeController(
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
	
	// 생성 (json)
	// 생성 (form-data)
	@PostMapping("")
	public ResponseEntity<?> writeResume(@RequestBody Resume resumeRequest) {
		// 현재 인증 정보에서 userId 추출 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; 				// 토큰
        int userId = jwtAuth.getUserId();
		        
		// 응답 데이터 구성
		Map<String, Object> resultMap = new HashMap<>();
	    HttpStatus status;

	    try {
	        // Resume 저장
	        Resume resume = new Resume();
	        resume.setUserId(userId);
	        resumeService.createResume(resume);
	        int resumeId = resume.getResumeId();
	        

	        // 데이터 처리 매핑
	        Map<List<?>, Consumer<Integer>> serviceMap = new HashMap<>();

	        // 각 엔티티 리스트 매핑
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
	        serviceMap.put(resumeRequest.getWorkExp(), id -> workExpService.createWorkExpList(resumeRequest.getWorkExp(), id));

	        // 반복문으로 처리
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
//	        
//	        // Activity 저장
//	        List<Activity> activities = resumeRequest.getActivities();
//	        if (activities != null && !activities.isEmpty()) {
//	            activityService.createActivityList(activities, resumeId);
//	        }
//	        
//	        // Award 저장
//	        List<Award> awards = resumeRequest.getAwards();
//	        if (awards != null && !awards.isEmpty()) {
//	        	awardService.createAwardList(awards, resumeId);
//	        }
//
//	        // Certification 저장
//	        List<Certification> certifications = resumeRequest.getCertifications();
//	        if (certifications != null && !certifications.isEmpty()) {
//	            certificationService.createCertificationList(certifications, resumeId);
//	        }
//
//	        // Education 저장 - 파일별도
//	        List<Education> educations = resumeRequest.getEducations();
//	        if (educations != null && !educations.isEmpty()) {
//	            educationService.createEducationList(educations, resumeId);
//	        }
//
//	        // Language 저장
//	        List<Language> languages = resumeRequest.getLanguages();
//	        if (languages != null && !languages.isEmpty()) {
//	            languageService.createLanguageList(languages, resumeId);
//	        }
//
//	        // Oversea 저장
//	        List<Oversea> overseas = resumeRequest.getOverseas();
//	        if (overseas != null && !overseas.isEmpty()) {
//	            overseaService.createOverseaList(overseas, resumeId);
//	        }
//
//	        // Paper 저장
//	        List<Paper> papers = resumeRequest.getPapers();
//	        if (papers != null && !papers.isEmpty()) {
//	            paperService.createPaperList(papers, resumeId);
//	        }
//
//	        // Patent 저장
//	        List<Patent> patents = resumeRequest.getPatents();
//	        if (patents != null && !patents.isEmpty()) {
//	            patentService.createPatentList(patents, resumeId);
//	        }
//	        
//	        // PersonalInfo 저장 - 파일별도
//	        PersonalInfo personalInfo = resumeRequest.getPersonalInfo();
//	        if (personalInfo != null) {
//	        	personalInfo.setResumeId(resumeId);
//	        	personalInfoService.createPersonal(personalInfo);
//	        }
//
//	        // Portfolio 저장 - 파일별도
//	        List<Portfolio> portfolios = resumeRequest.getPortfolios();
//	        if (portfolios != null && !portfolios.isEmpty()) {
//	            portfolioService.createPortfolioList(portfolios, resumeId);
//	        }
//
//	        // Preference 저장
//	        Preference preference = resumeRequest.getPreference();
//	        if (preference != null) {
//	            preference.setResumeId(resumeId);
//	            preferenceService.createPreference(preference);
//	        }
//
//	        // Project 저장
//	        List<Project> projects = resumeRequest.getProjects();
//	        if (projects != null && !projects.isEmpty()) {
//	            projectService.createProjectList(projects, resumeId);
//	        }
//
//	        // Skill 저장
//	        List<Skill> skills = resumeRequest.getSkills();
//	        if (skills != null && !skills.isEmpty()) {
//	            skillService.createSkillList(skills, resumeId);
//	        }
//
//	        // Training 저장
//	        List<Training> trainings = resumeRequest.getTrainings();
//	        if (trainings != null && !trainings.isEmpty()) {
//	            trainingService.createTrainingList(trainings, resumeId);
//	        }
//
//	        // Work Experience 저장 -- 파일별도
//	        List<WorkExp> workExperiences = resumeRequest.getWorkExp();
//	        if (workExperiences != null && !workExperiences.isEmpty()) {
//	            workExpService.createWorkExpList(workExperiences, resumeId);
//	        }

	        resultMap.put("message", "Resume saved successfully");
	        status = HttpStatus.CREATED;
	        
	    } catch (RuntimeException e) {
	    	resultMap.put("message", e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : ""); // 상세 원인
	        status = HttpStatus.BAD_REQUEST;
	        
        } catch (Exception e) {
	        resultMap.put("message", "Resume 생성 중 오류 발생: " + e.getMessage());
	        resultMap.put("detail", e.getCause() != null ? e.getCause().getMessage() : "");
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
	    }
	    return new ResponseEntity<>(resultMap, status);
	}
	
	
	
//	        resultMap.put("message", "Resume 생성에 실패하였습니다." + e.getMessage());
//	        status = HttpStatus.BAD_REQUEST;
//	    }
//
//	    return new ResponseEntity<>(resultMap, status);
//	}
//    List<Entry> entries = resumeRequest.getEntries();
//
//    resumeService.createResume(resume);
//
//    for (Entry entry : entries) {
//        switch (entry.getType()) {
//            case "personalInfo":
//                PersonalInfo personalInfo = objectMapper.convertValue(entry.getData(), PersonalInfo.class);
//                personalInfoService.createPersonal(personalInfo);
//                break;
//            case "project":
//                Project project = objectMapper.convertValue(entry.getData(), Project.class);
//                projectService.createProject(project);
//                break;
//        }
//    }
//
//    return ResponseEntity.status(HttpStatus.CREATED).body("Resume 생성 성공");
//}
//Resume resume = resumeRequest.getResume();
//PersonalInfo personalInfo = resumeRequest.getPersonalInfo();
//List<Project> projects = resumeRequest.getProjects();
//
//resumeService.createResume(resume);
//personalInfoService.createPersonal(personalInfo);
//projectService.createProjects(projects);
//
	
//	@PostMapping("")
//	public ResponseEntity<?> createResume(
//	        @ModelAttribute PersonalInfo personalInfo, // 파일 포함
//	        @RequestParam(value = "file", required = false) MultipartFile file, // 파일 처리
//	        @RequestBody Map<String, Object> resumeData // 나머지 JSON 데이터
//			) {
//	    // 현재 인증 정보에서 userId 추출
//	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
//	    int userId = jwtAuth.getUserId();
//
//	    // 반환 데이터
//	    Map<String, Object> resultMap = new HashMap<>();
//	    HttpStatus status;
//
//	    try {
//	        // Step 1: 이력서 생성
//	        Resume resume = new Resume();
//	        resume.setUserId(userId);
//	        boolean isResumeCreated = resumeService.createResume(resume);
//
//	        if (!isResumeCreated) {
//	            throw new RuntimeException("이력서 생성에 실패했습니다.");
//	        }
//
//	        int resumeId = resume.getResumeId(); // 생성된 Resume ID
//
//	        // Step 2: PersonalInfo 저장
//	        personalInfo.setResumeId(resumeId);
//	        boolean isPersonalInfoCreated = personalInfoService.createPersonal(personalInfo, file);
//
//	        if (!isPersonalInfoCreated) {
//	            throw new RuntimeException("PersonalInfo 생성에 실패했습니다.");
//	        }
//
//	        // Step 3: 나머지 데이터를 저장
////	        saveAdditionalData(resumeId, resumeData);
//
//	        // 성공 메시지 설정
//	        resultMap.put("message", "이력서가 성공적으로 생성되었습니다.");
//	        resultMap.put("resumeId", resumeId);
//	        status = HttpStatus.CREATED;
//
//	    } catch (Exception e) {
//	        resultMap.put("message", e.getMessage());
//	        status = HttpStatus.INTERNAL_SERVER_ERROR;
//	    }
//
//	    return new ResponseEntity<>(resultMap, status);
//	}
	
//	private void saveAdditionalData(int resumeId, Map<String, Object> resumeData) {
//	    // Step 1: Project 저장
//	    List<Map<String, Object>> projects = (List<Map<String, Object>>) resumeData.get("projects");
//	    if (projects != null) {
//	        projects.forEach(project -> {
//	            Project projectEntity = new Project();
//	            projectEntity.setResumeId(resumeId);
//	            projectEntity.setProjectName((String) project.get("projectName"));
//	            projectEntity.setRole((String) project.get("role"));
//	            projectEntity.setStartDate((String) project.get("startDate"));
//	            projectEntity.setEndDate((String) project.get("endDate"));
//	            projectEntity.setDescription((String) project.get("description"));
//	            projectService.createProject(projectEntity);
//	        });
//	    }
//
//	    // Step 2: Language 저장
//	    List<Map<String, Object>> languages = (List<Map<String, Object>>) resumeData.get("languages");
//	    if (languages != null) {
//	        languages.forEach(language -> {
//	            Language languageEntity = new Language();
//	            languageEntity.setResumeId(resumeId);
//	            languageEntity.setLanguageName((String) language.get("languageName"));
//	            languageEntity.setTestName((String) language.get("testName"));
//	            languageEntity.setScore((String) language.get("score"));
//	            languageEntity.setCertCode((String) language.get("certCode"));
//	            languageEntity.setObtainedAt((String) language.get("obtainedAt"));
//	            languageService.createLanguage(languageEntity);
//	        });
//	    }
//
//	    // Step 3: 기타 데이터 저장 (Awards, Skills, Preferences 등)
//	    // 위와 같은 방식으로 각각의 데이터 저장 로직 추가
//	}

	
	
//	
//	@PostMapping("")
//	public ResponseEntity<?> writeResume () {
//		// 현재 인증 정보에서 userId 추출 가져오기
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
//	    JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; 				// 토큰
//	    int userId = jwtAuth.getUserId();
//	    
//	    // 반환데이터
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = HttpStatus.ACCEPTED;
//	            
//	    // 이력서 정보 - userId와 연결된 이력서
//		
//				
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = HttpStatus.ACCEPTED;
//	
//		if (jwtUtil.checkToken(header)) {
//			// 사용가능한 토큰
//			try {
//				// 사용자 정보 - JWT 토큰에서 userId 추출
//	            String token = header.startsWith("Bearer ") ? header.substring(7) : header;
//	            int userId = jwtUtil.getUserId(token);
//	            System.out.println("결과: "+jwtUtil.getUserId(token));
//	            
//	            // 이력서 생성
//	            Resume resume = new Resume();
//	            resume.setUserId(userId);
//	            boolean isCreated = resumeService.createResume(resume);
//	            
//	            if (isCreated) {
//	            	resultMap.put("message", "이력서가 등록되었습니다.");
//	            	status = HttpStatus.CREATED;
//	            }
//			} catch (Exception e) {
//				resultMap.put("message", e.getMessage());
//				status = HttpStatus.INTERNAL_SERVER_ERROR;
//			}
//		}else {
//			resultMap.put("message", "인증정보가 유효하지 않습니다.");
//			status = HttpStatus.UNAUTHORIZED;
//		}
//		
//		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//	}
//	
	
	
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
