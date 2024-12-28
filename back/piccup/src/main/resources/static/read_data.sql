/*
	조회
*/ 

SELECT TABLE_NAME, TABLE_TYPE, ENGINE, CREATE_TIME
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = 'piccup';

SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_KEY
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'piccup';

SELECT * FROM piccup.user;

SELECT * FROM piccup.resume;

SELECT * FROM piccup.personal_info;

SELECT * FROM piccup.skill;

SELECT * FROM piccup.training;

SELECT * FROM piccup.certification;

SELECT * FROM piccup.oversea;

SELECT * FROM piccup.language;

SELECT * FROM piccup.project;

SELECT * FROM piccup.award;

SELECT * FROM piccup.paper;

SELECT * FROM piccup.patent;

SELECT * FROM piccup.portfolio;

SELECT * FROM piccup.work_exp;

SELECT * FROM piccup.preference;

SELECT * FROM piccup.activity;

SELECT * FROM piccup.education;

SELECT * FROM piccup.file;

GRANT ALL PRIVILEGES ON piccup.* TO 'ssafy'@'localhost';
