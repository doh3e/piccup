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
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `edu_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `school_type` varchar(20) DEFAULT '선택안함',
  `school_name` varchar(255) NOT NULL,
  `major` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT '선택안함',
  `is_transfer` tinyint(1) DEFAULT '0',
  `gpa` decimal(3,2) DEFAULT NULL,
  `major_gpa` decimal(3,2) DEFAULT NULL,
  `gpa_scale` decimal(3,2) DEFAULT NULL,
  `is_qe` tinyint(1) NOT NULL DEFAULT '0',
  `qe_year` year DEFAULT NULL,
  `transcript_file_name` varchar(255) DEFAULT NULL,
  `transcript_file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`edu_id`),
  KEY `edu_resume_fk` (`resume_id`),
  CONSTRAINT `edu_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE,
  CONSTRAINT `education_chk_1` CHECK ((`school_type` in (_utf8mb4'선택안함',_utf8mb4'고등학교',_utf8mb4'대학(2,3년)',_utf8mb4'대학교(4년)',_utf8mb4'대학원'))),
  CONSTRAINT `education_chk_2` CHECK ((`status` in (_utf8mb4'선택안함',_utf8mb4'졸업',_utf8mb4'졸업예정',_utf8mb4'재학 중',_utf8mb4'중퇴',_utf8mb4'수료',_utf8mb4'휴학')))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,1,'대학교(4년)','서울대학교','컴퓨터공학','2015-03-01','2019-02-28','졸업',0,3.80,3.90,4.30,1,2019,'transcript1.pdf','/documents/transcripts/transcript1.pdf'),(2,2,'대학(2,3년)','부산대학교','전자공학','2016-03-01','2018-02-28','졸업',1,3.50,3.60,4.50,0,NULL,'transcript2.pdf','/documents/transcripts/transcript2.pdf'),(3,3,'고등학교','서울고등학교',NULL,'2012-03-01','2015-02-28','졸업',0,NULL,NULL,NULL,0,NULL,NULL,NULL),(4,4,'대학원','카이스트','기계공학','2020-03-01',NULL,'재학 중',0,3.70,3.80,4.30,1,NULL,'transcript3.pdf','/documents/transcripts/transcript3.pdf');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
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
