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
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `training` (
  `training_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `training_name` varchar(255) NOT NULL,
  `institution` varchar(255) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`training_id`),
  KEY `training_resume_fk` (`resume_id`),
  CONSTRAINT `training_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,1,'Advanced Java Programming','Tech Academy','2022-01-10','2022-03-20','An intensive training program focusing on advanced Java techniques and Spring framework.'),(2,1,'Data Science Bootcamp','DataCamp','2021-09-01','2021-11-30','Hands-on bootcamp covering Python, machine learning, and data visualization.'),(3,2,'AWS Cloud Practitioner','Amazon Web Services','2023-05-15','2023-06-10','Introductory course on cloud computing with AWS services.'),(4,2,'Web Development with React','CodeAcademy','2022-02-01','2022-04-15','Focused on building dynamic web applications using ReactJS.'),(5,3,'SQL for Data Analysis','Dataquest','2023-01-10','2023-02-20','Training on writing efficient SQL queries for data extraction and analysis.'),(6,3,'Mobile App Development','App Academy','2020-08-01','2020-12-15','Learned to develop mobile applications using Flutter and Kotlin.'),(7,4,'Leadership Training Program','Global Management Institute','2022-07-01','2022-07-15','Focused on developing leadership and project management skills.'),(8,4,'Cybersecurity Essentials','CyberSafe Institute','2023-03-01','2023-04-15','Introductory course covering the basics of cybersecurity and network safety.');
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-27 17:18:39
