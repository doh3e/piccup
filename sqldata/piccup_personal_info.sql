-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: piccup
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `personal_info`
--

DROP TABLE IF EXISTS `personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_info` (
  `info_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT '미지정',
  `email` varchar(255) DEFAULT NULL,
  `home_phone` varchar(20) DEFAULT NULL,
  `mobile_phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `profile_img_path` varchar(255) DEFAULT 'profile_images/default.png',
  `profile_img_name` varchar(255) DEFAULT 'default.png',
  `degree` varchar(10) NOT NULL DEFAULT '미지정',
  `hobby` varchar(255) DEFAULT NULL,
  `specialty` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `personal_resume_fk` (`resume_id`),
  CONSTRAINT `personal_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE,
  CONSTRAINT `personal_info_chk_1` CHECK ((`gender` in (_utf8mb4'남',_utf8mb4'여',_utf8mb4'미지정'))),
  CONSTRAINT `personal_info_chk_2` CHECK ((`degree` in (_utf8mb4'미지정',_utf8mb4'중등교육이수',_utf8mb4'학사',_utf8mb4'석사',_utf8mb4'박사')))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_info`
--

LOCK TABLES `personal_info` WRITE;
/*!40000 ALTER TABLE `personal_info` DISABLE KEYS */;
INSERT INTO `personal_info` VALUES (1,1,'김싸피','1990-01-01','남','kimssafy@example.com','02-1234-5678','010-1234-5678','서울시 강남구','101동 202호',12345,'','','학사','독서','소프트웨어 개발'),(2,2,'박싸피','1992-05-15','여','parkssafy@example.com','02-9876-5432','010-9876-5432','서울시 서초구','202동 303호',54321,'','','석사','여행','데이터 분석'),(3,3,'이싸피','1985-09-20','남','leessafy@example.com','031-5678-1234','010-5678-1234','경기도 성남시','303동 404호',34567,'','','박사','음악 감상','AI 연구'),(4,4,'정싸피','1993-11-11','여','jungssafy@example.com','031-4321-8765','010-4321-8765','서울시 송파구','404동 505호',98765,'','','학사','요리','그래픽 디자인');
/*!40000 ALTER TABLE `personal_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-27 17:18:41
