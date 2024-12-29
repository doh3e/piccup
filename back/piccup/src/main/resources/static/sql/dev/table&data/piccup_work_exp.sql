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
-- Table structure for table `work_exp`
--

DROP TABLE IF EXISTS `work_exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_exp` (
  `exp_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `company` varchar(255) NOT NULL,
  `department` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `is_current` tinyint(1) DEFAULT '0',
  `position` varchar(50) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `description` text,
  `exp_file_name` varchar(255) DEFAULT NULL,
  `exp_file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`exp_id`),
  KEY `exp_resume_fk` (`resume_id`),
  CONSTRAINT `exp_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_exp`
--

LOCK TABLES `work_exp` WRITE;
/*!40000 ALTER TABLE `work_exp` DISABLE KEYS */;
INSERT INTO `work_exp` VALUES (1,1,'TechCorp','Engineering','2018-01-01','2021-10-31',0,'Software Engineer',80000,'Developed enterprise software solutions.','exp_techcorp.pdf','/files/techcorp'),(2,2,'BizSolutions','Sales','2019-05-15','2020-12-31',0,'Sales Manager',70000,'Managed key client accounts.','exp_bizsolutions.pdf','/files/bizsolutions'),(3,3,'GreenIndustries','Operations','2020-06-01','2021-12-31',0,'Operations Manager',85000,'Streamlined operational processes.','exp_green.pdf','/files/green'),(4,4,'GreenIndustries','Operations','2021-01-01',NULL,1,'Operations Manager',90000,'Managed a team of 15.','exp_green_2.pdf','/files/green'),(5,3,'HealthPlus','HR','2017-03-10','2019-02-28',0,'HR Specialist',60000,'Oversaw recruitment and onboarding.','exp_healthplus.pdf','/files/healthplus'),(6,2,'EduSmart','Teaching','2015-08-20','2018-06-30',0,'Teacher',50000,'Taught high school math.','exp_edusmart.pdf','/files/edusmart'),(7,4,'FinanceWorld','Investment','2022-04-15',NULL,1,'Analyst',75000,'Analyzed market trends.','exp_financeworld.pdf','/files/financeworld'),(8,1,'RetailKing','Management','2021-11-01','2023-05-31',0,'Store Manager',65000,'Managed retail store operations.','exp_retailking.pdf','/files/retailking');
/*!40000 ALTER TABLE `work_exp` ENABLE KEYS */;
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
