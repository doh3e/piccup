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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `act_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `act_type` varchar(20) DEFAULT '기타',
  `title` varchar(255) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`act_id`),
  KEY `act_resume_fk` (`resume_id`),
  CONSTRAINT `act_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE,
  CONSTRAINT `activity_chk_1` CHECK ((`act_type` in (_utf8mb4'아르바이트',_utf8mb4'동아리',_utf8mb4'자원봉사',_utf8mb4'교내활동',_utf8mb4'기타')))
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,1,'아르바이트','카페 바리스타','2022-01-01','2023-01-01','주말마다 카페에서 바리스타로 근무하며 고객 응대 및 음료 제조를 경험.'),(2,2,'동아리','영화 제작 동아리','2021-03-01','2022-12-01','학교 동아리 활동으로 단편 영화를 제작하며 팀워크와 기획력을 키움.'),(3,3,'자원봉사','지역 도서관 봉사','2020-05-01','2020-08-01','지역 도서관에서 아이들을 대상으로 독서 교육 봉사 활동.'),(4,1,'교내활동','학생회 활동','2019-03-01','2020-02-01','학생회 문화부에서 학교 축제 기획 및 운영에 참여.'),(5,3,'기타','온라인 콘텐츠 제작','2022-06-01','2023-06-01','개인적으로 유튜브 채널을 운영하며 콘텐츠 기획과 제작 경험.'),(6,2,'아르바이트','편의점 근무','2021-04-01','2021-10-01','야간 편의점에서 근무하며 물류 관리와 고객 응대 능력 습득.'),(7,1,'동아리','코딩 동아리 활동','2021-09-01','2022-06-01','코딩 동아리에서 팀 프로젝트를 진행하며 웹 개발 경험.'),(8,3,'자원봉사','노인 요양원 봉사','2020-11-01','2021-01-01','노인 요양원에서 청소 및 식사 보조 등의 봉사 활동.'),(9,2,'교내활동','교내 신문 기자','2018-09-01','2019-02-01','교내 신문 기자로 활동하며 기사 작성 및 인터뷰 경험.'),(10,1,'기타','개인 프로젝트','2022-01-01','2022-05-01','개인적으로 모바일 앱 개발 프로젝트를 진행하며 프로그래밍 능력 향상.');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-27 17:18:40
