DROP DATABASE IF EXISTS piccup;
CREATE DATABASE piccup DEFAULT CHARACTER SET utf8mb4;

USE piccup;

-- 유저 테이블 생성
DROP TABLE IF EXISTS user;
CREATE TABLE user (
	user_id	INT	NOT NULL AUTO_INCREMENT,
	email VARCHAR(255)	NOT NULL,
	nickname VARCHAR(15) NOT NULL,
	password VARCHAR(255) NOT NULL,
	-- profile_img	VARCHAR(255) DEFAULT 'images/default.jpg',
	mobile_phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (user_id),
    UNIQUE (email),
    UNIQUE (nickname)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 유저테이블에 토큰 column 추가
ALTER TABLE user
ADD COLUMN token VARCHAR(1000) NULL DEFAULT NULL AFTER created_at;
