-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment_2
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `trainers_has_subjects`
--

DROP TABLE IF EXISTS `trainers_has_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers_has_subjects` (
  `ths_trainerKey` int NOT NULL,
  `ths_subjectKey` int NOT NULL,
  KEY `fk_trainers_has_subjects_subjects1_idx` (`ths_subjectKey`),
  KEY `fk_trainers_has_subjects_trainers_idx` (`ths_trainerKey`),
  CONSTRAINT `fk_trainers_has_subjects_subjects1` FOREIGN KEY (`ths_subjectKey`) REFERENCES `subjects` (`subjectKey`),
  CONSTRAINT `fk_trainers_has_subjects_trainers` FOREIGN KEY (`ths_trainerKey`) REFERENCES `trainers` (`trainerKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers_has_subjects`
--

LOCK TABLES `trainers_has_subjects` WRITE;
/*!40000 ALTER TABLE `trainers_has_subjects` DISABLE KEYS */;
INSERT INTO `trainers_has_subjects` VALUES (4002,1),(4002,2),(4002,3),(4002,4),(4003,1),(4003,2),(4003,4),(4004,3),(4004,4),(4005,1),(4005,2),(4005,3),(4006,4),(4007,2),(4007,3),(8004,1),(8004,4),(8023,1),(8023,2),(8023,3),(8023,4),(4009,2),(4009,3),(4008,1),(4008,3);
/*!40000 ALTER TABLE `trainers_has_subjects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-01 15:10:53
