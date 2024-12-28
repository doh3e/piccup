/*
	 데이터 생성
*/ 

-- 유저 테이블 데이터 삽입
INSERT INTO user (email, nickname, password, mobile_phone)
values ('piccup10@example.com', 'testuser10', 'password123', '010-1234-5678');
INSERT INTO user (email, nickname, password, mobile_phone)
VALUES
	('john.doe@example.com', 'JohnDoe', 'password123', '010-1234-5678'),
    ('jane.doe@example.com', 'JaneDoe', 'password456', '010-9876-5432'),
    ('smith.lee@example.com', 'SmithLee', 'password789', '010-5678-1234'),
    ('emma.wang@example.com', 'EmmaW', 'password321', '010-4321-8765'),
    ('piccup@example.com', 'testuser', 'password123', '010-1234-5678'),
    ('piccup1@example.com', 'testuser1', 'password123', '010-2222-3333'),
    ('piccup2@example.com', 'testuser2', 'password123', '010-4444-5555'),
    ('piccup3@example.com', 'testuser3', 'password123', '010-6666-7777'),
    ('piccup4@example.com', 'testuser4', 'password123', '010-4567-8910'),
    ('piccup5@example.com', 'testuser5', 'password123', '010-1112-1314');

-- 이력서 테이블 데이터 삽입
INSERT INTO resume (user_id)
VALUES
    (1),
    (2),
    (3),
    (4),
    (5),
    (6),
    (7),
    (8),
    (9),
    (10);

    
-- 인적사항 테이블 데이터 삽입
INSERT INTO personal_info (resume_id, username, birth_date, gender, email, home_phone, mobile_phone, address, address_detail, postal_code, degree, profile_img_path, profile_img_name, hobby, specialty)
VALUES	(1, 'John Doe', '1990-01-01', '남', 'john.doe@example.com', '02-1234-5678', '010-1234-5678', '서울시 강남구', '101동 202호', 12345, '학사', 'profile_images/default.png', 'default.png', '독서', '소프트웨어 개발'),
		(2, 'Jane Doe', '1992-05-15', '여', 'jane.doe@example.com', '02-9876-5432', '010-9876-5432', '서울시 서초구', '202동 303호', 54321, '석사', 'profile_images/default.png', 'default.png', '여행', '데이터 분석'),
		(3, 'Smith Lee', '1985-09-20', '남', 'smith.lee@example.com', '031-5678-1234', '010-5678-1234', '경기도 성남시', '303동 404호', 34567, '박사', 'profile_images/default.png', 'default.png', '음악 감상', 'AI 연구'),
		(4, 'Emma Wang', '1993-11-11', '여', 'emma.wang@example.com', '031-4321-8765', '010-4321-8765', '서울시 송파구', '404동 505호', 98765, '학사', 'profile_images/default.png', 'default.png', '요리', '그래픽 디자인'),
		(5, 'Chris Park', '1988-04-10', '남', 'chris.park@example.com', '02-2222-4444', '010-2222-4444', '서울시 종로구', '505동 606호', 45678, '학사', 'profile_images/default.png', 'default.png', '등산', '프로젝트 관리'),
		(6, 'Olivia Kim', '1991-12-25', '여', 'olivia.kim@example.com', '031-3333-5555', '010-3333-5555', '경기도 용인시', '606동 707호', 67890, '석사', 'profile_images/default.png', 'default.png', '그림 그리기', '교육 컨설팅'),
		(7, 'Ethan Choi', '1987-07-07', '남', 'ethan.choi@example.com', '031-7777-8888', '010-7777-8888', '서울시 은평구', '707동 808호', 11223, '학사', 'profile_images/default.png', 'default.png', '테니스', '소프트웨어 테스트'),
		(8, 'Sophia Lee', '1994-03-15', '여', 'sophia.lee@example.com', '02-9999-0000', '010-9999-0000', '서울시 마포구', '808동 909호', 22334, '학사', 'profile_images/default.png', 'default.png', '영화 감상', 'UI/UX 디자인'),
		(9, 'Mason Jung', '1995-06-30', '남', 'mason.jung@example.com', '031-8888-7777', '010-8888-7777', '경기도 부천시', '909동 1001호', 33445, '학사', 'profile_images/default.png', 'default.png', '스포츠', '데이터 시각화'),
		(10, 'Liam Han', '1989-01-05', '남', 'liam.han@example.com', '02-1111-2222', '010-1111-2222', '서울시 노원구', '1001동 1101호', 55667, '석사', 'profile_images/default.png', 'default.png', '게임', '네트워크 보안');

-- 스킬 테이블 데이터 삽입
INSERT INTO skill (resume_id, skill_name, skill_level)
VALUES 	(1, 'Java', '중급'),
		(1, 'Python', '고급'),
        (2, 'SQL', '초급'),
        (2, 'JavaScript', '전문가'),
        (3, 'C++', '미지정'),
        (3, 'Java', '중급'),
		(4, 'Python', '고급'),
        (4, 'SQL', '초급'),
        (5, 'JavaScript', '전문가'),
        (5, 'C++', '미지정');
        
-- 교육 테이블 데이터 삽입
INSERT INTO training (resume_id, training_name, institution, start_date, end_date, description)
VALUES	(1, 'Advanced Java Programming', 'Tech Academy', '2022-01-10', '2022-03-20', 'An intensive training program focusing on advanced Java techniques and Spring framework.'),
		(1, 'Data Science Bootcamp', 'DataCamp', '2021-09-01', '2021-11-30', 'Hands-on bootcamp covering Python, machine learning, and data visualization.'),
		(2, 'AWS Cloud Practitioner', 'Amazon Web Services', '2023-05-15', '2023-06-10', 'Introductory course on cloud computing with AWS services.'),
		(2, 'Web Development with React', 'CodeAcademy', '2022-02-01', '2022-04-15', 'Focused on building dynamic web applications using ReactJS.'),
		(3, 'SQL for Data Analysis', 'Dataquest', '2023-01-10', '2023-02-20', 'Training on writing efficient SQL queries for data extraction and analysis.'),
		(3, 'Mobile App Development', 'App Academy', '2020-08-01', '2020-12-15', 'Learned to develop mobile applications using Flutter and Kotlin.'),
		(4, 'Leadership Training Program', 'Global Management Institute', '2022-07-01', '2022-07-15', 'Focused on developing leadership and project management skills.'),
		(4, 'Cybersecurity Essentials', 'CyberSafe Institute', '2023-03-01', '2023-04-15', 'Introductory course covering the basics of cybersecurity and network safety.'),
		(5, 'Leadership Training Program', 'Global Management Institute', '2022-07-01', '2022-07-15', 'Focused on developing leadership and project management skills.'),
		(5, 'Cybersecurity Essentials', 'CyberSafe Institute', '2023-03-01', '2023-04-15', 'Introductory course covering the basics of cybersecurity and network safety.');

-- 자격증 테이블 데이터 삽입
INSERT INTO certification (resume_id, cert_name, publisher, obtained_date, cert_code)
VALUES	(1, '정보처리기사', '한국산업인력공단', '2022-10-15', '12345-IT'),
		(1, '컴퓨터활용능력 1급', '대한상공회의소', '2023-05-20', 'CH123456'),
		(2, '토익 900점', 'ETS', '2021-07-10', 'TOEIC-900'),
		(2, '오픽 IH', 'ACTFL', '2022-03-15', 'OPIc-IH001'),
		(3, 'SQL Developer', 'Oracle', '2020-11-30', 'SQLD-001'),
		(3, 'PMP', 'PMI', '2022-09-01', 'PMP-9876'),
		(4, 'AWS Certified Solutions Architect', 'AWS', '2021-06-20', 'AWS-SA123'),
		(4, '정보보안기사', '한국인터넷진흥원', '2022-12-01', 'KISA-SEC001'),
		(5, 'JLPT N1', '일본국제교육지원협회', '2020-08-10', 'JLPT-N1-2020'),
		(5, '한국사능력검정시험 1급', '국사편찬위원회', '2023-03-05', 'KHK-1234');

-- 해외경험 테이블 데이터 삽입
INSERT INTO oversea (resume_id, country, start_date, end_date, description)
VALUES	(1, 'United States', '2020-01-01', '2020-12-31', 'Studied abroad for a year in the United States.'),
		(1, 'Japan', '2021-03-01', '2021-09-01', 'Participated in a cultural exchange program in Japan.'),
		(2, 'Germany', '2019-06-01', '2019-12-01', 'Worked as an intern at a tech company in Germany.'),
		(2, 'France', '2021-05-01', '2021-11-01', 'Attended a language immersion program in France.'),
		(3, 'Australia', '2018-07-01', '2019-07-01', 'Completed a work holiday program in Australia.'),
		(3, 'Singapore', '2020-01-01', '2020-06-01', 'Participated in a startup accelerator in Singapore.'),
		(4, 'Canada', '2022-01-01', '2022-06-30', 'Studied at a Canadian university for six months.'),
		(4, 'United Kingdom', '2021-09-01', '2022-03-01', 'Interned at a financial firm in London.'),
		(5, 'South Korea', '2019-03-01', '2019-08-31', 'Attended a university exchange program in South Korea.'),
		(5, 'Italy', '2022-04-01', '2022-10-01', 'Completed an art workshop in Florence, Italy.');
        
-- 어학 테이블 데이터 삽입
INSERT INTO language (resume_id, language_name, test_name, score, obtained_date, cert_code)
VALUES	(1, 'English', 'TOEIC', '950', '2022-05-01', 'ENG12345'),
		(1, 'French', 'DELF', 'B2', '2021-08-15', 'FRE56789'),
		(2, 'Japanese', 'JLPT', 'N2', '2020-12-10', 'JPN23456'),
		(2, 'English', 'IELTS', '7.5', '2021-09-25', 'ENG78901'),
		(3, 'Spanish', 'DELE', 'C1', '2023-02-20', 'SPA34567'),
		(3, 'Korean', 'TOPIK', 'Level 6', '2022-06-10', 'KOR56789'),
		(4, 'Chinese', 'HSK', 'Level 5', '2021-11-30', 'CHI45678'),
		(4, 'German', 'TestDaF', 'TDN 4', '2022-08-15', 'GER67890'),
		(5, 'Russian', 'TORFL', 'B2', '2020-05-30', 'RUS89012'),
		(5, 'Italian', 'CELI', 'C1', '2021-07-01', 'ITA90123');

-- 프로젝트 테이블 데이터 삽입
INSERT INTO project (resume_id, project_name, role, start_date, end_date, description)
VALUES	(1, 'E-commerce Website', 'Team Lead', '2023-01-01', '2023-06-30', 'Developed an online shopping platform using Spring and MySQL.'),
		(1, 'Machine Learning Model', 'Data Scientist', '2023-07-01', '2023-12-31', 'Built a recommendation system for a retail company using Python and TensorFlow.'),
		(2, 'Mobile Application', 'Developer', '2022-03-01', '2022-08-30', 'Created a cross-platform mobile app using Flutter and Firebase.'),
		(2, 'ERP System', 'System Analyst', '2022-09-01', '2023-02-28', 'Analyzed and implemented an ERP system for a manufacturing company.'),
		(3, 'Social Media Platform', 'Frontend Developer', '2021-05-01', '2022-04-30', 'Designed and developed UI components using React.js.'),
		(3, 'Blockchain Wallet', 'Blockchain Engineer', '2022-06-01', '2023-01-31', 'Developed a secure blockchain wallet using Solidity and web3.js.'),
		(4, 'AI Chatbot', 'AI Developer', '2023-02-01', '2023-08-31', 'Built an AI-powered chatbot for customer support using NLP techniques.'),
		(4, 'Portfolio Website', 'Designer', '2023-09-01', '2023-12-15', 'Designed and implemented a personal portfolio website using HTML, CSS, and JavaScript.'),
		(5, 'E-learning Platform', 'Backend Developer', '2022-01-01', '2022-06-30', 'Developed a backend system for an e-learning platform using Node.js and MongoDB.'),
		(5, 'IoT Smart Home System', 'Embedded Developer', '2022-07-01', '2023-03-01', 'Created an IoT-based smart home system integrating sensors and automation.');
    
-- 수상내역 테이블 데이터 삽입
INSERT INTO award (resume_id, award_name, award_organization, award_date, description)
VALUES	(1, 'Best Developer Award', 'Google', '2023-01-15', 'Awarded for outstanding contributions to software development.'),
		(1, 'Innovation in AI', 'ACM', '2022-11-20', 'Recognized for developing innovative AI solutions.'),
		(2, 'Top Student Award', 'Harvard University', '2021-06-10', 'Awarded to the top graduating student in Computer Science.'),
		(2, 'Employee of the Year', 'Amazon', '2020-12-15', 'Recognized for exceptional performance and leadership.'),
		(3, 'Excellence in Data Science', 'Kaggle', '2022-07-25', 'Achieved first place in a global data science competition.'),
		(3, 'Community Leadership Award', 'UNICEF', '2023-05-18', 'Recognized for outstanding leadership in community service projects.'),
		(4, 'Best Paper Award', 'IEEE', '2022-09-30', 'Awarded for presenting the best research paper at an international conference.'),
		(4, 'Outstanding Volunteer Award', 'Red Cross', '2023-03-10', 'Acknowledged for significant contributions to humanitarian work.'),
		(5, 'Creative Solution Award', 'Hackathon', '2021-10-05', 'Won first place for innovative solutions in a global hackathon.'),
		(5, 'Leadership Excellence Award', 'Microsoft', '2020-12-01', 'Recognized for exemplary leadership during a team project.');

-- 논문 테이블 데이터 삽입
INSERT INTO paper (resume_id, paper_title, journal, published_date, description)
VALUES	(1, 'Deep Learning for Image Recognition', 'Journal of Artificial Intelligence', '2022-06-15', 'Explores the use of convolutional neural networks for image classification.'),
		(1, 'A Survey on Natural Language Processing', 'Computational Linguistics Review', '2023-01-10', 'A comprehensive review of recent advancements in NLP techniques.'),
		(2, 'Blockchain and Cryptography', 'Journal of Secure Computing', '2021-09-20', 'Discusses the integration of blockchain technologies with modern cryptographic methods.'),
		(2, 'Renewable Energy Systems', 'Energy and Environment Journal', '2020-12-05', 'Focuses on the design and implementation of renewable energy systems.'),
		(3, 'Big Data Analytics in Healthcare', 'Healthcare Informatics Journal', '2022-03-30', 'Examines the application of big data analytics in improving patient care.'),
		(3, 'Cybersecurity Challenges', 'Journal of Cyber Threat Intelligence', '2021-08-12', 'Highlights key challenges and solutions in modern cybersecurity.'),
		(4, 'Quantum Computing Applications', 'Quantum Journal', '2023-05-18', 'Presents emerging applications of quantum computing in industry.'),
		(4, 'Sustainable Urban Development', 'Journal of Urban Studies', '2023-11-01', 'Discusses strategies for sustainable development in urban areas.'),
		(5, 'AI Ethics and Society', 'Journal of Ethics in AI', '2022-10-20', 'Explores ethical challenges in AI applications.'),
		(5, 'Future of IoT', 'IoT Innovations', '2023-04-10', 'Analyzes the future trends in IoT and their implications.');
    
-- 특허 테이블 데이터 삽입
INSERT INTO patent (resume_id, patent_title, inventor, patent_code, description)
VALUES  (1, 'Method for Optimizing AI Models', 'John Doe', 'US1234567A', 'A patented method for improving the efficiency of AI algorithms.'),
		(1, 'Renewable Energy Conversion Device', 'Jane Smith', 'EP7654321B', 'A novel device for converting solar energy to usable electricity.'),
		(2, 'Blockchain-Based Voting System', 'Alice Johnson', 'WO9876543C', 'A secure and transparent voting system using blockchain technology.'),
		(2, 'Wireless Communication Protocol', 'Bob Brown', 'US4567890D', 'An innovative protocol for enhancing wireless communication efficiency.'),
		(3, 'Autonomous Vehicle Navigation System', 'Charlie White', 'JP3456789E', 'A system for enabling autonomous navigation in vehicles.'),
		(3, 'Advanced Data Encryption Algorithm', 'David Black', 'US8765432F', 'A patented encryption method for securing sensitive data.'),
		(4, 'Smart Farming Sensor Network', 'Ella Green', 'KR5678901G', 'A network of sensors for monitoring and optimizing agricultural environments.'),
		(4, 'Real-Time Language Translation Device', 'Fiona Blue', 'CN7654321H', 'A handheld device capable of real-time language translation.'),
		(5, 'Augmented Reality Glasses', 'Henry Black', 'US7654321I', 'A new design for AR glasses with enhanced features.'),
		(5, 'Bio-Sensor Wearable', 'Lisa Gray', 'EU1234567J', 'Wearable technology for real-time health monitoring.');
    
-- 포트폴리오 테이블 데이터 삽입
INSERT INTO portfolio (resume_id, port_url)
VALUES	(1, 'https://github.com/user1/portfolio1'),
		(1, 'https://user1.com/portfolio'),
		(2, 'https://github.com/user2/portfolio'),
		(2, 'https://user2.com/portfolio'),
		(3, 'https://github.com/user3/portfolio'),
		(3, 'https://user3.com/portfolio'),
		(4, 'https://github.com/user4/portfolio'),
		(4, 'https://user4.com/portfolio'),
		(5, 'https://github.com/user5/portfolio'),
		(5, 'https://user5.com/portfolio');
    
-- 경력 테이블 데이터 삽입
INSERT INTO work_exp (resume_id, company, department, start_date, end_date, is_current, position, salary, description)
VALUES	(1, 'TechCorp', 'Engineering', '2018-01-01', '2021-12-31', FALSE, 'Software Engineer', 80000, 'Developed enterprise software solutions.'),
		(1, 'BizSolutions', 'Sales', '2019-05-15', '2020-12-31', FALSE, 'Sales Manager', 70000, 'Managed key client accounts.'),
		(2, 'GreenIndustries', 'Operations', '2020-06-01', '2021-12-31', FALSE, 'Operations Manager', 85000, 'Streamlined operational processes.'),
		(2, 'GreenIndustries', 'Operations', '2021-01-01', NULL, TRUE, 'Operations Manager', 90000, 'Managed a team of 15.'),
		(3, 'HealthPlus', 'HR', '2017-03-10', '2019-02-28', FALSE, 'HR Specialist', 60000, 'Oversaw recruitment and onboarding.'),
		(3, 'EduSmart', 'Teaching', '2015-08-20', '2018-06-30', FALSE, 'Teacher', 50000, 'Taught high school math.'),
		(4, 'EduSmart', 'Teaching', '2019-09-01', NULL, TRUE, 'Head of Department', 65000, 'Led the department to win awards.'),
		(4, 'FinanceWorld', 'Investment', '2022-04-15', NULL, TRUE, 'Analyst', 75000, 'Analyzed market trends.'),
		(5, 'LogiTech', 'Logistics', '2016-07-07', '2019-06-30', FALSE, 'Logistics Coordinator', 55000, 'Coordinated supply chain activities.'),
		(5, 'RetailKing', 'Management', '2021-11-01', '2023-05-31', FALSE, 'Store Manager', 65000, 'Managed retail store operations.');

-- 취업우대 테이블 데이터 삽입
INSERT INTO preference (resume_id, is_veteran, is_protected, is_disabled, dis_level, military, is_agree)
VALUES	(1, TRUE, FALSE, TRUE, '중증', '군필', TRUE),
		(2, FALSE, FALSE, FALSE, '해당없음', '미필', TRUE),
		(3, FALSE, TRUE, FALSE, '해당없음', '면제', FALSE),
		(4, FALSE, FALSE, TRUE, '경증', '비대상', TRUE),
		(5, TRUE, TRUE, TRUE, '1급', '군필', TRUE),
		(6, FALSE, FALSE, FALSE, '해당없음', '해당없음', FALSE),
		(7, FALSE, TRUE, TRUE, '3급', '면제', TRUE),
		(8, TRUE, FALSE, FALSE, '5급', '군필', TRUE),
		(9, FALSE, FALSE, TRUE, '6급', '미필', FALSE),
		(10, TRUE, TRUE, TRUE, '2급', '비대상', TRUE);
        
-- 대내외활동 테이블 데이터 삽입
INSERT INTO activity (resume_id, act_type, title, start_date, end_date, description)
VALUES	(1, '아르바이트', '카페 바리스타', '2022-01-01', '2023-01-01', '주말마다 카페에서 바리스타로 근무하며 고객 응대 및 음료 제조를 경험.'),
		(1, '동아리', '영화 제작 동아리', '2021-03-01', '2022-12-01', '학교 동아리 활동으로 단편 영화를 제작하며 팀워크와 기획력을 키움.'),
		(2, '자원봉사', '지역 도서관 봉사', '2020-05-01', '2020-08-01', '지역 도서관에서 아이들을 대상으로 독서 교육 봉사 활동.'),
		(2, '교내활동', '학생회 활동', '2019-03-01', '2020-02-01', '학생회 문화부에서 학교 축제 기획 및 운영에 참여.'),
		(3, '기타', '온라인 콘텐츠 제작', '2022-06-01', '2023-06-01', '개인적으로 유튜브 채널을 운영하며 콘텐츠 기획과 제작 경험.'),
		(3, '아르바이트', '편의점 근무', '2021-04-01', '2021-10-01', '야간 편의점에서 근무하며 물류 관리와 고객 응대 능력 습득.'),
		(4, '동아리', '코딩 동아리 활동', '2021-09-01', '2022-06-01', '코딩 동아리에서 팀 프로젝트를 진행하며 웹 개발 경험.'),
		(4, '자원봉사', '노인 요양원 봉사', '2020-11-01', '2021-01-01', '노인 요양원에서 청소 및 식사 보조 등의 봉사 활동.'),
		(5, '교내활동', '교내 신문 기자', '2018-09-01', '2019-02-01', '교내 신문 기자로 활동하며 기사 작성 및 인터뷰 경험.'),
		(5, '기타', '개인 프로젝트', '2022-01-01', '2022-05-01', '개인적으로 모바일 앱 개발 프로젝트를 진행하며 프로그래밍 능력 향상.');

-- 학력 테이블 데이터 삽입
INSERT INTO education (resume_id, school_type, school_name, major, start_date, end_date, status, is_transfer, gpa, major_gpa, gpa_scale, is_qe, qe_year)
VALUES	(1, '대학교(4년)', '서울대학교', '컴퓨터공학', '2015-03-01', '2019-02-28', '졸업', FALSE, 3.80, 3.90, 4.30, TRUE, 2019),
		(1, '고등학교', '서울고등학교', NULL, '2012-03-01', '2015-02-28', '졸업', FALSE, NULL, NULL, NULL, FALSE, NULL),
		(2, '고등학교', '부산고등학교', NULL, '2010-03-01', '2013-02-28', '졸업', FALSE, NULL, NULL, NULL, FALSE, NULL),
		(2, '대학(2,3년)', '부산대학교', '전자공학', '2016-03-01', '2018-02-28', '졸업', TRUE, 3.50, 3.60, 4.50, FALSE, NULL),
		(3, '대학원', '카이스트', '기계공학', '2020-03-01', NULL, '재학 중', FALSE, 3.70, 3.80, 4.30, TRUE, NULL),
		(3, '대학교(4년)', '연세대학교', '경영학', '2018-03-01', NULL, '졸업예정', FALSE, 3.20, 3.40, 4.30, FALSE, NULL),
		(4, '대학(2,3년)', '광주과학기술원', '정보통신', '2019-03-01', NULL, '재학 중', FALSE, 3.85, 3.90, 4.50, FALSE, NULL),
		(5, '대학교(4년)', '한국외국어대학교', '국제관계학', '2014-03-01', '2018-02-28', '졸업', FALSE, 3.60, 3.70, 4.50, TRUE, 2018),
		(6, '대학교(4년)', '한양대학교', '건축학', '2017-03-01', NULL, '졸업예정', FALSE, 3.40, 3.50, 4.30, FALSE, NULL),
		(7, '대학원', '포항공과대학교', '화학공학', '2021-09-01', NULL, '재학 중', TRUE, 3.75, 3.80, 4.30, TRUE, NULL),
		(8, '대학교(4년)', '중앙대학교', '에너지시스템공학부', '2018-03-01', '2022-02-28', '졸업', FALSE, 3.80, 3.85, 4.50, TRUE, 2022),
		(9, '대학교(4년)', '중앙대학교', '전기전자공학부', '2019-03-01', NULL, '졸업예정', FALSE, 3.70, 3.75, 4.30, FALSE, NULL),
		(10, '대학원', '중앙대학교', '에너지환경공학', '2021-09-01', NULL, '재학 중', FALSE, 3.85, 3.90, 4.30, TRUE, NULL);

-- 파일 테이블 데이터 삽입
INSERT INTO file (resume_id, port_file_name, port_file_path, edu_file_name, edu_file_path, work_file_name, work_file_path)
VALUES	(1, 'portfolio1.pdf', '/documents/portfolios/portfolio1.pdf', 'transcript1.pdf', '/education/transcript1.pdf', 'exp_techcorp.pdf', '/work_files/techcorp'),
		(1, 'portfolio2.pdf', '/documents/portfolios/portfolio2.pdf', 'transcript2.pdf', '/education/transcript2.pdf', 'exp_bizsolutions.pdf', '/work_files/bizsolutions'),
		(2, 'portfolio3.pdf', '/documents/portfolios/portfolio3.pdf', NULL, NULL, 'exp_green.pdf', '/work_files/green'),
		(2, 'portfolio4.pdf', '/documents/portfolios/portfolio4.pdf', 'transcript4.pdf', '/education/transcript4.pdf', 'exp_green_2.pdf', '/work_files/green'),
		(3, 'portfolio5.pdf', '/documents/portfolios/portfolio5.pdf', 'transcript5.pdf', '/education/transcript5.pdf', 'exp_healthplus.pdf', '/work_files/healthplus'),
		(3, 'portfolio6.pdf', '/documents/portfolios/portfolio6.pdf', 'transcript6.pdf', '/education/transcript6.pdf', 'exp_edusmart_hod.pdf', '/work_files/edusmart'),
		(4, 'portfolio7.pdf', '/documents/portfolios/portfolio7.pdf', 'transcript7.pdf', '/education/transcript7.pdf', 'exp_financeworld.pdf', '/work_files/financeworld'),
		(4, 'portfolio8.pdf', '/documents/portfolios/portfolio8.pdf', 'transcript8.pdf', '/education/transcript8.pdf', 'exp_logitech.pdf', '/work_files/logitech'),
		(5, 'portfolio9.pdf', '/documents/portfolios/portfolio9.pdf', 'transcript9.pdf', '/education/transcript9.pdf', 'exp_retailking.pdf', '/work_files/retailking'),
		(5, 'portfolio10.pdf', '/documents/portfolios/portfolio10.pdf', 'transcript10.pdf', '/education/transcript10.pdf', NULL, NULL);

