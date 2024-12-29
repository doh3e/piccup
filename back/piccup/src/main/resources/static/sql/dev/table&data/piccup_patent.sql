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
-- Table structure for table `patent`
--

DROP TABLE IF EXISTS `patent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patent` (
  `patent_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `patent_title` varchar(255) NOT NULL,
  `inventor` varchar(255) NOT NULL,
  `patent_code` varchar(100) NOT NULL,
  `description` text,
  PRIMARY KEY (`patent_id`),
  KEY `patent_resume_fk` (`resume_id`),
  CONSTRAINT `patent_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patent`
--

LOCK TABLES `patent` WRITE;
/*!40000 ALTER TABLE `patent` DISABLE KEYS */;
INSERT INTO `patent` VALUES (1,1,'Method for Optimizing AI Models','John Doe','US1234567A','A patented method for improving the efficiency of AI algorithms.'),(2,1,'Renewable Energy Conversion Device','Jane Smith','EP7654321B','A novel device for converting solar energy to usable electricity.'),(3,2,'Blockchain-Based Voting System','Alice Johnson','WO9876543C','A secure and transparent voting system using blockchain technology.'),(4,2,'Wireless Communication Protocol','Bob Brown','US4567890D','An innovative protocol for enhancing wireless communication efficiency.'),(5,3,'Autonomous Vehicle Navigation System','Charlie White','JP3456789E','A system for enabling autonomous navigation in vehicles.'),(6,3,'Advanced Data Encryption Algorithm','David Black','US8765432F','A patented encryption method for securing sensitive data.'),(7,4,'Smart Farming Sensor Network','Ella Green','KR5678901G','A network of sensors for monitoring and optimizing agricultural environments.'),(8,4,'Real-Time Language Translation Device','Fiona Blue','CN7654321H','A handheld device capable of real-time language translation.');
/*!40000 ALTER TABLE `patent` ENABLE KEYS */;
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
