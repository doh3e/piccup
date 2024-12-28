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
-- Table structure for table `paper`
--

DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paper` (
  `paper_id` int NOT NULL AUTO_INCREMENT,
  `resume_id` int NOT NULL,
  `paper_title` varchar(255) NOT NULL,
  `journal` varchar(255) NOT NULL,
  `published_date` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`paper_id`),
  KEY `paper_resume_fk` (`resume_id`),
  CONSTRAINT `paper_resume_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper`
--

LOCK TABLES `paper` WRITE;
/*!40000 ALTER TABLE `paper` DISABLE KEYS */;
INSERT INTO `paper` VALUES (1,1,'Deep Learning for Image Recognition','Journal of Artificial Intelligence','2022-06-15','Explores the use of convolutional neural networks for image classification.'),(2,1,'A Survey on Natural Language Processing','Computational Linguistics Review','2023-01-10','A comprehensive review of recent advancements in NLP techniques.'),(3,2,'Blockchain and Cryptography','Journal of Secure Computing','2021-09-20','Discusses the integration of blockchain technologies with modern cryptographic methods.'),(4,2,'Renewable Energy Systems','Energy and Environment Journal','2020-12-05','Focuses on the design and implementation of renewable energy systems.'),(5,3,'Big Data Analytics in Healthcare','Healthcare Informatics Journal','2022-03-30','Examines the application of big data analytics in improving patient care.'),(6,3,'Cybersecurity Challenges','Journal of Cyber Threat Intelligence','2021-08-12','Highlights key challenges and solutions in modern cybersecurity.'),(7,4,'Quantum Computing Applications','Quantum Journal','2023-05-18','Presents emerging applications of quantum computing in industry.'),(8,4,'Sustainable Urban Development','Journal of Urban Studies','2023-11-01','Discusses strategies for sustainable development in urban areas.');
/*!40000 ALTER TABLE `paper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-27 17:18:42
