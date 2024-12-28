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
-- Table structure for table `job_position`
--

DROP TABLE IF EXISTS `job_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_position` (
  `job_position_id` int NOT NULL AUTO_INCREMENT,
  `job_url` varchar(500) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `company_href` varchar(500) DEFAULT NULL,
  `company_name` varchar(255) NOT NULL,
  `position_title` varchar(255) NOT NULL,
  `industry_code` varchar(50) NOT NULL,
  `industry_name` varchar(255) DEFAULT NULL,
  `location_code` varchar(255) DEFAULT NULL,
  `location_name` varchar(255) DEFAULT NULL,
  `job_type_code` varchar(50) DEFAULT NULL,
  `job_type_name` varchar(100) DEFAULT NULL,
  `job_mid_code` varchar(50) DEFAULT NULL,
  `job_mid_name` varchar(100) DEFAULT NULL,
  `job_code_code` varchar(50) DEFAULT NULL,
  `job_code_name` varchar(100) DEFAULT NULL,
  `experience_level_code` int DEFAULT NULL,
  `experience_level_min` int DEFAULT NULL,
  `experience_level_max` int DEFAULT NULL,
  `experience_level_name` varchar(100) DEFAULT NULL,
  `education_code` varchar(50) DEFAULT NULL,
  `education_name` varchar(100) DEFAULT NULL,
  `job_id` varchar(20) NOT NULL,
  `posting_timestamp` bigint NOT NULL,
  `posting_date` datetime DEFAULT NULL,
  `modification_timestamp` bigint NOT NULL,
  `opening_timestamp` bigint NOT NULL,
  `expiration_timestamp` bigint NOT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `close_type_code` varchar(50) DEFAULT NULL,
  `close_type_name` varchar(100) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `read_count` varchar(50) DEFAULT NULL,
  `apply_count` varchar(50) DEFAULT NULL,
  `salary_code` varchar(50) DEFAULT NULL,
  `salary_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`job_position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_position`
--

LOCK TABLES `job_position` WRITE;
/*!40000 ALTER TABLE `job_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_position` ENABLE KEYS */;
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
