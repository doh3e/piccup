/*
	더미 데이터 생성
*/ 

-- 유저 더미 데이터
INSERT INTO user (email, nickname, password, mobile_phone)
VALUES
	('kimssafy@example.com', '김싸피', 'password123', '010-1234-5678'),
    ('parkssafy@example.com', '박싸피', 'password456', '010-9876-5432'),
    ('leessafy@example.com', '이싸피', 'password789', '010-5678-1234'),
    ('jungssafy@example.com', '정싸피', 'password321', '010-4321-8765'),
    ('choissafy@example.com', '최싸피', 'password123', '010-1234-5678');
    
-- 이력서 테이블 더미 데이터 삽입
INSERT INTO resume (user_id, updated_at)
VALUES
    (1, '2023-12-01 10:00:00'),
    (2, '2023-12-02 15:30:00'),
    (3, '2023-12-03 08:45:00'),
    (4, '2023-12-04 14:20:00');

-- 인적사항 테이블 더미 데이터 삽입
INSERT INTO personal_info (resume_id, username, birth_date, gender, email, home_phone, mobile_phone, address, address_detail, postal_code, degree, profile_img_path, profile_img_name, hobby, specialty)
VALUES
(1, '김싸피', '1990-01-01', '남', 'kimssafy@example.com', '02-1234-5678', '010-1234-5678', '서울시 강남구', '101동 202호', 12345, '학사', '', '', '독서', '소프트웨어 개발'),
(2, '박싸피', '1992-05-15', '여', 'parkssafy@example.com', '02-9876-5432', '010-9876-5432', '서울시 서초구', '202동 303호', 54321, '석사', '', '', '여행', '데이터 분석'),
(3, '이싸피', '1985-09-20', '남', 'leessafy@example.com', '031-5678-1234', '010-5678-1234', '경기도 성남시', '303동 404호', 34567, '박사', '', '', '음악 감상', 'AI 연구'),
(4, '정싸피', '1993-11-11', '여', 'jungssafy@example.com', '031-4321-8765', '010-4321-8765', '서울시 송파구', '404동 505호', 98765, '학사', '', '', '요리', '그래픽 디자인');

-- 스킬 테이블 더미 데이터 삽입
INSERT INTO skill (resume_id, skill_name, skill_level)
VALUES 	(1, 'Java', '중급'),
		(2, 'Python', '고급'),
        (1, 'SQL', '초급'),
        (1, 'JavaScript', '전문가'),
        (2, 'C++', '미지정');
        
-- 교육 테이블 더미 데이터 삽입
INSERT INTO training (resume_id, training_name, institution, start_date, end_date, description)
VALUES	(1, 'Advanced Java Programming', 'Tech Academy', '2022-01-10', '2022-03-20', 'An intensive training program focusing on advanced Java techniques and Spring framework.'),
		(1, 'Data Science Bootcamp', 'DataCamp', '2021-09-01', '2021-11-30', 'Hands-on bootcamp covering Python, machine learning, and data visualization.'),
		(2, 'AWS Cloud Practitioner', 'Amazon Web Services', '2023-05-15', '2023-06-10', 'Introductory course on cloud computing with AWS services.'),
		(2, 'Web Development with React', 'CodeAcademy', '2022-02-01', '2022-04-15', 'Focused on building dynamic web applications using ReactJS.'),
		(3, 'SQL for Data Analysis', 'Dataquest', '2023-01-10', '2023-02-20', 'Training on writing efficient SQL queries for data extraction and analysis.'),
		(3, 'Mobile App Development', 'App Academy', '2020-08-01', '2020-12-15', 'Learned to develop mobile applications using Flutter and Kotlin.'),
		(4, 'Leadership Training Program', 'Global Management Institute', '2022-07-01', '2022-07-15', 'Focused on developing leadership and project management skills.'),
		(4, 'Cybersecurity Essentials', 'CyberSafe Institute', '2023-03-01', '2023-04-15', 'Introductory course covering the basics of cybersecurity and network safety.');

-- 자격증 테이블 더미 데이터 삽입
INSERT INTO certification (resume_id, cert_name, publisher, obtained_date, cert_code)
VALUES	(1, '정보처리기사', '한국산업인력공단', '2022-10-15', '12345-IT'),
		(1, '컴퓨터활용능력 1급', '대한상공회의소', '2023-05-20', 'CH123456'),
		(2, '토익 900점', 'ETS', '2021-07-10', 'TOEIC-900'),
		(3, 'SQL Developer', 'Oracle', '2020-11-30', 'SQLD-001'),
		(3, 'PMP', 'PMI', '2022-09-01', 'PMP-9876');

-- 해외경험 테이블 데이터 삽입
INSERT INTO oversea (resume_id, country, start_date, end_date, description)
VALUES	(1, 'United States', '2020-01-01', '2020-12-31', 'Studied abroad for a year in the United States.'),
		(1, 'Japan', '2021-03-01', '2021-09-01', 'Participated in a cultural exchange program in Japan.'),
		(2, 'Germany', '2019-06-01', '2019-12-01', 'Worked as an intern at a tech company in Germany.'),
		(3, 'Australia', '2018-07-01', '2019-07-01', 'Completed a work holiday program in Australia.'),
		(4, 'Canada', '2022-01-01', '2022-06-30', 'Studied at a Canadian university for six months.');
        
-- 어학 테이블 더미 데이터 삽입
INSERT INTO language (resume_id, language_name, test_name, score, obtained_date, cert_code)
VALUES  (1, 'English', 'TOEIC', '950', '2022-05-01', 'ENG12345'),
		(1, 'French', 'DELF', 'B2', '2021-08-15', 'FRE56789'),
		(2, 'Japanese', 'JLPT', 'N2', '2020-12-10', 'JPN23456'),
		(3, 'Spanish', 'DELE', 'C1', '2023-02-20', 'SPA34567'),
		(4, 'Chinese', 'HSK', 'Level 5', '2021-11-30', 'CHI45678');

-- 프로젝트 테이블 더미데이터 삽입
INSERT INTO project (resume_id, project_name, role, start_date, end_date, description)
VALUES	(1, 'E-commerce Website', 'Team Lead', '2023-01-01', '2023-06-30', 'Developed an online shopping platform using Spring and MySQL.'),
		(1, 'Machine Learning Model', 'Data Scientist', '2023-07-01', '2023-12-31', 'Built a recommendation system for a retail company using Python and TensorFlow.'),
		(2, 'Mobile Application', 'Developer', '2022-03-01', '2022-08-30', 'Created a cross-platform mobile app using Flutter and Firebase.'),
		(2, 'ERP System', 'System Analyst', '2022-09-01', '2023-02-28', 'Analyzed and implemented an ERP system for a manufacturing company.'),
		(3, 'Social Media Platform', 'Frontend Developer', '2021-05-01', '2022-04-30', 'Designed and developed UI components using React.js.'),
		(3, 'Blockchain Wallet', 'Blockchain Engineer', '2022-06-01', '2023-01-31', 'Developed a secure blockchain wallet using Solidity and web3.js.'),
		(4, 'AI Chatbot', 'AI Developer', '2023-02-01', '2023-08-31', 'Built an AI-powered chatbot for customer support using NLP techniques.'),
		(4, 'Portfolio Website', 'Designer', '2023-09-01', '2023-12-15', 'Designed and implemented a personal portfolio website using HTML, CSS, and JavaScript.');
    
-- 수상내역 테이블 데이터 삽입
INSERT INTO award (resume_id, award_name, award_organization, award_date, description)
VALUES	(1, 'Best Developer Award', 'Google', '2023-01-15', 'Awarded for outstanding contributions to software development.'),
		(1, 'Innovation in AI', 'ACM', '2022-11-20', 'Recognized for developing innovative AI solutions.'),
		(2, 'Top Student Award', 'Harvard University', '2021-06-10', 'Awarded to the top graduating student in Computer Science.'),
		(2, 'Employee of the Year', 'Amazon', '2020-12-15', 'Recognized for exceptional performance and leadership.'),
		(3, 'Excellence in Data Science', 'Kaggle', '2022-07-25', 'Achieved first place in a global data science competition.'),
		(3, 'Community Leadership Award', 'UNICEF', '2023-05-18', 'Recognized for outstanding leadership in community service projects.'),
		(4, 'Best Paper Award', 'IEEE', '2022-09-30', 'Awarded for presenting the best research paper at an international conference.'),
		(4, 'Outstanding Volunteer Award', 'Red Cross', '2023-03-10', 'Acknowledged for significant contributions to humanitarian work.');
        
-- 논문 테이블 데이터 삽입
INSERT INTO paper (resume_id, paper_title, journal, published_date, description)
VALUES	(1, 'Deep Learning for Image Recognition', 'Journal of Artificial Intelligence', '2022-06-15', 'Explores the use of convolutional neural networks for image classification.'),
		(1, 'A Survey on Natural Language Processing', 'Computational Linguistics Review', '2023-01-10', 'A comprehensive review of recent advancements in NLP techniques.'),
		(2, 'Blockchain and Cryptography', 'Journal of Secure Computing', '2021-09-20', 'Discusses the integration of blockchain technologies with modern cryptographic methods.'),
		(2, 'Renewable Energy Systems', 'Energy and Environment Journal', '2020-12-05', 'Focuses on the design and implementation of renewable energy systems.'),
		(3, 'Big Data Analytics in Healthcare', 'Healthcare Informatics Journal', '2022-03-30', 'Examines the application of big data analytics in improving patient care.'),
		(3, 'Cybersecurity Challenges', 'Journal of Cyber Threat Intelligence', '2021-08-12', 'Highlights key challenges and solutions in modern cybersecurity.'),
		(4, 'Quantum Computing Applications', 'Quantum Journal', '2023-05-18', 'Presents emerging applications of quantum computing in industry.'),
		(4, 'Sustainable Urban Development', 'Journal of Urban Studies', '2023-11-01', 'Discusses strategies for sustainable development in urban areas.');

-- 특허 테이블 데이터 삽입
INSERT INTO patent (resume_id, patent_title, inventor, patent_code, description)
VALUES	(1, 'Method for Optimizing AI Models', 'John Doe', 'US1234567A', 'A patented method for improving the efficiency of AI algorithms.'),
		(1, 'Renewable Energy Conversion Device', 'Jane Smith', 'EP7654321B', 'A novel device for converting solar energy to usable electricity.'),
		(2, 'Blockchain-Based Voting System', 'Alice Johnson', 'WO9876543C', 'A secure and transparent voting system using blockchain technology.'),
		(2, 'Wireless Communication Protocol', 'Bob Brown', 'US4567890D', 'An innovative protocol for enhancing wireless communication efficiency.'),
		(3, 'Autonomous Vehicle Navigation System', 'Charlie White', 'JP3456789E', 'A system for enabling autonomous navigation in vehicles.'),
		(3, 'Advanced Data Encryption Algorithm', 'David Black', 'US8765432F', 'A patented encryption method for securing sensitive data.'),
		(4, 'Smart Farming Sensor Network', 'Ella Green', 'KR5678901G', 'A network of sensors for monitoring and optimizing agricultural environments.'),
		(4, 'Real-Time Language Translation Device', 'Fiona Blue', 'CN7654321H', 'A handheld device capable of real-time language translation.');

-- 경력 테이블 데이터 삽입
INSERT INTO work_exp (resume_id, company, department, start_date, end_date, is_current, position, salary, description, exp_file_name, exp_file_path)
VALUES	(1, 'TechCorp', 'Engineering', '2018-01-01', '2021-10-31', FALSE, 'Software Engineer', 80000, 'Developed enterprise software solutions.', 'exp_techcorp.pdf', '/files/techcorp'),
		(2, 'BizSolutions', 'Sales', '2019-05-15', '2020-12-31', FALSE, 'Sales Manager', 70000, 'Managed key client accounts.', 'exp_bizsolutions.pdf', '/files/bizsolutions'),
		(3, 'GreenIndustries', 'Operations', '2020-06-01', '2021-12-31', FALSE, 'Operations Manager', 85000, 'Streamlined operational processes.', 'exp_green.pdf', '/files/green'),
		(4, 'GreenIndustries', 'Operations', '2021-01-01', NULL, TRUE, 'Operations Manager', 90000, 'Managed a team of 15.', 'exp_green_2.pdf', '/files/green'),
		(3, 'HealthPlus', 'HR', '2017-03-10', '2019-02-28', FALSE, 'HR Specialist', 60000, 'Oversaw recruitment and onboarding.', 'exp_healthplus.pdf', '/files/healthplus'),
		(2, 'EduSmart', 'Teaching', '2015-08-20', '2018-06-30', FALSE, 'Teacher', 50000, 'Taught high school math.', 'exp_edusmart.pdf', '/files/edusmart'),
		(4, 'FinanceWorld', 'Investment', '2022-04-15', NULL, TRUE, 'Analyst', 75000, 'Analyzed market trends.', 'exp_financeworld.pdf', '/files/financeworld'),
		(1, 'RetailKing', 'Management', '2021-11-01', '2023-05-31', FALSE, 'Store Manager', 65000, 'Managed retail store operations.', 'exp_retailking.pdf', '/files/retailking');

-- 취업우대 테이블 데이터 삽입
INSERT INTO preference (resume_id, is_veteran, is_protected, is_disabled, dis_level, military, is_agree)
VALUES	(1, TRUE, FALSE, TRUE, '중증', '면제', TRUE),
		(4, FALSE, FALSE, FALSE, '해당없음', '비대상', TRUE),
		(2, FALSE, FALSE, TRUE, '경증', '비대상', TRUE),
		(3, TRUE, TRUE, TRUE, '1급', '군필', TRUE);
        
-- 대내외활동 데이터 삽입
INSERT INTO activity (resume_id, act_type, title, start_date, end_date, description)
VALUES	(1, '아르바이트', '카페 바리스타', '2022-01-01', '2023-01-01', '주말마다 카페에서 바리스타로 근무하며 고객 응대 및 음료 제조를 경험.'),
		(2, '동아리', '영화 제작 동아리', '2021-03-01', '2022-12-01', '학교 동아리 활동으로 단편 영화를 제작하며 팀워크와 기획력을 키움.'),
		(3, '자원봉사', '지역 도서관 봉사', '2020-05-01', '2020-08-01', '지역 도서관에서 아이들을 대상으로 독서 교육 봉사 활동.'),
		(1, '교내활동', '학생회 활동', '2019-03-01', '2020-02-01', '학생회 문화부에서 학교 축제 기획 및 운영에 참여.'),
		(3, '기타', '온라인 콘텐츠 제작', '2022-06-01', '2023-06-01', '개인적으로 유튜브 채널을 운영하며 콘텐츠 기획과 제작 경험.'),
		(2, '아르바이트', '편의점 근무', '2021-04-01', '2021-10-01', '야간 편의점에서 근무하며 물류 관리와 고객 응대 능력 습득.'),
		(1, '동아리', '코딩 동아리 활동', '2021-09-01', '2022-06-01', '코딩 동아리에서 팀 프로젝트를 진행하며 웹 개발 경험.'),
		(3, '자원봉사', '노인 요양원 봉사', '2020-11-01', '2021-01-01', '노인 요양원에서 청소 및 식사 보조 등의 봉사 활동.'),
		(2, '교내활동', '교내 신문 기자', '2018-09-01', '2019-02-01', '교내 신문 기자로 활동하며 기사 작성 및 인터뷰 경험.'),
		(1, '기타', '개인 프로젝트', '2022-01-01', '2022-05-01', '개인적으로 모바일 앱 개발 프로젝트를 진행하며 프로그래밍 능력 향상.');

-- 학력 데이터 삽입
INSERT INTO education (resume_id, school_type, school_name, major, start_date, end_date, status, is_transfer, gpa, major_gpa, gpa_scale, is_qe, qe_year, transcript_file_name, transcript_file_path)
VALUES	(1, '대학교(4년)', '서울대학교', '컴퓨터공학', '2015-03-01', '2019-02-28', '졸업', FALSE, 3.80, 3.90, 4.30, TRUE, 2019, 'transcript1.pdf', '/documents/transcripts/transcript1.pdf'),
		(2, '대학(2,3년)', '부산대학교', '전자공학', '2016-03-01', '2018-02-28', '졸업', TRUE, 3.50, 3.60, 4.50, FALSE, NULL, 'transcript2.pdf', '/documents/transcripts/transcript2.pdf'),
		(3, '고등학교', '서울고등학교', NULL, '2012-03-01', '2015-02-28', '졸업', FALSE, NULL, NULL, NULL, FALSE, NULL, NULL, NULL),
		(4, '대학원', '카이스트', '기계공학', '2020-03-01', NULL, '재학 중', FALSE, 3.70, 3.80, 4.30, TRUE, NULL, 'transcript3.pdf', '/documents/transcripts/transcript3.pdf');