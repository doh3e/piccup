/*
	스키마 초기세팅
*/

DROP DATABASE IF EXISTS piccup;
CREATE DATABASE piccup DEFAULT CHARACTER SET utf8mb4;

USE piccup;

-- 유저 테이블 생성
DROP TABLE IF EXISTS user;
CREATE TABLE user (
	user_id				INT				NOT NULL AUTO_INCREMENT,
	email 				VARCHAR(255)	NOT NULL UNIQUE,
	nickname 			VARCHAR(15) 	NOT NULL UNIQUE,
	password 			VARCHAR(255) 	NOT NULL,
	profile_img_name	VARCHAR(255) 	DEFAULT 'default.png',
    profile_img_path 	VARCHAR(255) 	DEFAULT 'user_images/default.png',
	mobile_phone 		VARCHAR(20),
    created_at 			TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
    token 				VARCHAR(1000) 	NULL,
    
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 이력서 테이블 생성 (1:1)
DROP TABLE IF EXISTS resume;
CREATE TABLE resume (
	resume_id 	INT 		NOT NULL AUTO_INCREMENT,
	user_id 	INT			NOT NULL UNIQUE,
	updated_at 	TIMESTAMP 	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY (resume_id),
    CONSTRAINT resume_user_fk FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 인적사항 테이블 생성 (1:1)
DROP TABLE IF EXISTS personal_info;
CREATE TABLE personal_info (
	info_id 			INT 			NOT NULL AUTO_INCREMENT,
	resume_id 			INT 			NOT NULL UNIQUE,
	username 			VARCHAR(50),
	birth_date			DATE,
	gender 				VARCHAR(10) 	DEFAULT '미지정' CHECK (gender IN ('남', '여', '미지정')),
	email 				VARCHAR(255),
	home_phone			VARCHAR(20),
	mobile_phone 		VARCHAR(20),
	address 			VARCHAR(255),
	address_detail 		VARCHAR(255),
	postal_code 		INT,
	profile_img_path 	VARCHAR(255) 	DEFAULT 'profile_images/default.png',
    profile_img_name 	VARCHAR(255) 	DEFAULT 'default.png',
	degree 				VARCHAR(10) 	NOT NULL DEFAULT '미지정' CHECK (degree IN('미지정', '중등교육이수', '학사', '석사', '박사')),
	hobby 				VARCHAR(255),
	specialty			VARCHAR(255),
    
	CONSTRAINT personal_resume_fk FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE, 
    PRIMARY KEY (info_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 스킬 테이블 생성 (1:N)
DROP TABLE IF EXISTS skill;
CREATE TABLE skill (
	skill_id INT NOT NULL AUTO_INCREMENT,
	resume_id INT,
	skill_name VARCHAR(100) NOT NULL,
	skill_level VARCHAR(10) NOT NULL DEFAULT '미지정' CHECK (skill_level IN ('미지정', '초급', '중급', '고급', '전문가')),
    
    CONSTRAINT skill_resume_fk FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY (skill_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 교육 테이블 생성 (1:N)
DROP TABLE IF EXISTS training;
CREATE TABLE training (
	training_id 	INT 			NOT NULL AUTO_INCREMENT,
	resume_id 		INT				NOT NULL,
	training_name 	VARCHAR(255) 	NOT NULL,
	institution 	VARCHAR(255) 	NOT NULL,
	start_date 		DATE,
	end_date 		DATE,
	description 	TEXT,
    
    CONSTRAINT training_resume_fk FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY (training_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 자격증 테이블 생성 (1:N)
DROP TABLE IF EXISTS certification;
CREATE TABLE certification (
	cert_id			INT 			NOT NULL AUTO_INCREMENT,
	resume_id 		INT				NOT NULL,
	cert_name 		VARCHAR(255) 	NOT NULL,
	publisher 		VARCHAR(255),
	obtained_date 	DATE,
	cert_code 		VARCHAR(100),
    
    CONSTRAINT cert_resume_fk FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY (cert_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 해외경험 테이블 생성 (1:N)
DROP TABLE IF EXISTS oversea;
CREATE TABLE oversea (
	oversea_id 	INT 			NOT NULL AUTO_INCREMENT,
	resume_id 	INT				NOT NULL,
	country		VARCHAR(100) 	NOT NULL,
	start_date 	DATE,
	end_date 	DATE,
	description TEXT,
    
    CONSTRAINT oversea_resume_fk FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY (oversea_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 어학 테이블 생성 (1:N)
DROP TABLE IF EXISTS language;
CREATE TABLE language (
	language_id		INT				NOT NULL AUTO_INCREMENT,
	resume_id 		INT				NOT NULL,
	language_name 	VARCHAR(100) 	NOT NULL,
	test_name 		VARCHAR(100) 	NOT NULL,
	score 			VARCHAR(50),
	obtained_date 	DATE,
	cert_code 		VARCHAR(100),
    
    CONSTRAINT language_resume_fk FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY (language_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 프로젝트 데이블 생성 (1:N)
DROP TABLE IF EXISTS project;
CREATE TABLE project (
	project_id 		INT 			NOT NULL AUTO_INCREMENT,
	resume_id 		INT				NOT NULL,
	project_name 	VARCHAR(255) 	NOT NULL,
	role 			VARCHAR(255),
	start_date 		DATE,
	end_date 		DATE,
	description		TEXT,
    
    CONSTRAINT project_resume_fk FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY (project_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 수상내역 테이블 생성 (1:N)
DROP TABLE IF EXISTS award;
CREATE TABLE award (
	award_id 			INT 			NOT NULL AUTO_INCREMENT,
	resume_id 			INT,
	award_name 			VARCHAR(255) 	NOT NULL,
	award_organization 	VARCHAR(255) 	NOT NULL,
	award_date 			DATE,
	description			TEXT,
    
    CONSTRAINT award_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY (award_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 논문 테이블 생성 (1:N)
DROP TABLE IF EXISTS paper;
CREATE TABLE paper (
	paper_id 		INT 			NOT NULL AUTO_INCREMENT,
	resume_id 		INT				NOT NULL,
	paper_title		VARCHAR(255) 	NOT NULL,
	journal			VARCHAR(255) 	NOT NULL,
	published_date 	DATE,
	description 	TEXT,
    
    CONSTRAINT paper_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(paper_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 특허 테이블 생성 (1:N)
DROP TABLE IF EXISTS patent;
CREATE TABLE patent (
	patent_id 		INT 			NOT NULL AUTO_INCREMENT,
	resume_id 		INT				NOT NULL,
	patent_title 	VARCHAR(255) 	NOT NULL,
	inventor 		VARCHAR(255) 	NOT NULL,
	patent_code 	VARCHAR(100) 	NOT NULL,
	description 	TEXT,
    
    CONSTRAINT patent_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(patent_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 포트폴리오 테이블 생성 (1:N)
DROP TABLE IF EXISTS portfolio;
CREATE TABLE portfolio (
	port_id			INT				NOT NULL AUTO_INCREMENT,
	resume_id 		INT,
	port_url 		VARCHAR(255),
    
    CONSTRAINT portfolio_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(port_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 경력 테이블 생성 (1:N)
DROP TABLE IF EXISTS work_exp;
CREATE TABLE work_exp (
	exp_id 			INT 			NOT NULL AUTO_INCREMENT,
	resume_id 		INT				NOT NULL,
	company 		VARCHAR(255) 	NOT NULL,
	department 		VARCHAR(100),
	start_date 		DATE,
	end_date 		DATE,
	is_current 		BOOLEAN 		DEFAULT FALSE,
	position 		VARCHAR(50),
	salary 			INT				CHECK (salary >= 0),
	description 	TEXT,
    
    CONSTRAINT exp_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(exp_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 취업우대 테이블 생성 (1:1)
DROP TABLE IF EXISTS preference;
CREATE TABLE preference (
	pre_id 			INT 		NOT NULL AUTO_INCREMENT,
	resume_id 		INT 		NOT NULL UNIQUE,
	is_veteran 		BOOLEAN 	NOT NULL DEFAULT FALSE,
	is_protected 	BOOLEAN 	NOT NULL DEFAULT FALSE,
	is_disabled		BOOLEAN		NOT NULL DEFAULT FALSE,
	dis_level 		VARCHAR(10) DEFAULT '해당없음' CHECK (dis_level IN ('중증', '경증', '1급', '2급', '3급', '4급', '5급', '6급', '해당없음')),
	military 		VARCHAR(10) DEFAULT '해당없음' CHECK (military IN ('군필', '미필', '면제', '비대상', '해당없음')),
	is_agree 		BOOLEAN 	NOT NULL DEFAULT FALSE,
    
    CONSTRAINT pre_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(pre_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 대내외활동 테이블 생성 (1:N)
DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
	act_id 		INT 			NOT NULL AUTO_INCREMENT,
	resume_id 	INT				NOT NULL,
	act_type 	VARCHAR(20) 	DEFAULT '기타' CHECK (act_type IN ('아르바이트', '동아리', '자원봉사', '교내활동', '기타')	),
	title 		VARCHAR(255) 	NOT NULL,
	start_date 	DATE,
	end_date 	DATE,
	description TEXT,
    
    CONSTRAINT act_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(act_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 학력 테이블 생성 (1:N)
DROP TABLE IF EXISTS education;
CREATE TABLE education ( 
	edu_id 					INT 			NOT NULL AUTO_INCREMENT,
	resume_id 				INT				NOT NULL,
	school_type 			VARCHAR(20) 	DEFAULT '선택안함' CHECK (school_type IN ('선택안함', '고등학교', '대학(2,3년)', '대학교(4년)', '대학원')),
	school_name				VARCHAR(255) 	NOT NULL,
	major 					VARCHAR(100),
	start_date 				DATE,
	end_date 				DATE,
	status 					VARCHAR(20) 	DEFAULT '선택안함' CHECK (status IN ('선택안함', '졸업', '졸업예정', '재학 중', '중퇴', '수료', '휴학')),
	is_transfer				BOOLEAN			DEFAULT FALSE,
	gpa						DECIMAL(3,2)	CHECK (gpa >= 0),
	major_gpa 				DECIMAL(3,2)	CHECK (major_gpa >= 0),
	gpa_scale 				DECIMAL(3,2)	CHECK (gpa_scale >= 0),
	is_qe 					BOOLEAN 		NOT NULL DEFAULT FALSE,
	qe_year 				YEAR,
    
    CONSTRAINT edu_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(edu_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 파일 테이블 (1:N)
DROP TABLE IF EXISTS file;
CREATE TABLE file (
	file_id	INT NOT NULL AUTO_INCREMENT,
    resume_id INT NOT NULL,
    edu_file_name VARCHAR(255),
    edu_file_path VARCHAR(255),
	port_file_name 	VARCHAR(255),
    port_file_path 	VARCHAR(255),
	work_file_name 	VARCHAR(255),
    work_file_path 	VARCHAR(255),
	updated_at 	TIMESTAMP 	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT file_resume_fk FOREIGN KEY(resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE,
    PRIMARY KEY(file_id)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
	