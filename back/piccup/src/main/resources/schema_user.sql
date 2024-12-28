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
