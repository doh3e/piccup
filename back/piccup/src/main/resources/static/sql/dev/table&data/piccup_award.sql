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
-- Table structure for table `award`
--

DROP TABLE IF EXISTS `award`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `award` (
  `award_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `award_name` varchar(255) NOT NULL,
  `award_organization` varchar(255) NOT NULL,
  `award_date` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`award_id`),
  KEY `award_resume_fk` (`resume_id`),
  CONSTRAINT `award_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `award`
--

LOCK TABLES `award` WRITE;
/*!40000 ALTER TABLE `award` DISABLE KEYS */;
INSERT INTO `award` VALUES (1,1,'Best Developer Award','Google','2023-01-15','Awarded for outstanding contributions to software development.'),(2,1,'Innovation in AI','ACM','2022-11-20','Recognized for developing innovative AI solutions.'),(3,2,'Top Student Award','Harvard University','2021-06-10','Awarded to the top graduating student in Computer Science.'),(4,2,'Employee of the Year','Amazon','2020-12-15','Recognized for exceptional performance and leadership.'),(5,3,'Excellence in Data Science','Kaggle','2022-07-25','Achieved first place in a global data science competition.'),(6,3,'Community Leadership Award','UNICEF','2023-05-18','Recognized for outstanding leadership in community service projects.'),(7,4,'Best Paper Award','IEEE','2022-09-30','Awarded for presenting the best research paper at an international conference.'),(8,4,'Outstanding Volunteer Award','Red Cross','2023-03-10','Acknowledged for significant contributions to humanitarian work.');
/*!40000 ALTER TABLE `award` ENABLE KEYS */;
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
