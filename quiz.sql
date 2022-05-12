CREATE DATABASE  IF NOT EXISTS `quiz` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quiz`;
-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_id` int DEFAULT NULL,
  `option` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `iscorrect` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_idx` (`question_id`),
  CONSTRAINT `fk_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,1,'a','Erciyes',_binary '\0'),(2,1,'b','Uludag',_binary '\0'),(3,1,'c','Koroglu',_binary '\0'),(4,1,'d','Agri',_binary ''),(5,2,'a','Tuz Golu',_binary '\0'),(6,2,'b','Eymir',_binary '\0'),(7,2,'c','Van',_binary ''),(8,2,'d','Mogan',_binary '\0'),(9,3,'a','Firat',_binary '\0'),(10,3,'b','Nil',_binary ''),(11,3,'c','Amazon',_binary '\0'),(12,3,'d','Tuna',_binary '\0'),(13,4,'a','Caspian Sea',_binary ''),(14,4,'b','Michigan',_binary '\0'),(15,4,'c','Viktoria',_binary '\0'),(16,4,'d','Van',_binary '\0'),(17,5,'a','Joe Biden',_binary ''),(18,5,'b','Hillary Clinton',_binary '\0'),(19,5,'c','Mahmoud Ahmedinejad',_binary '\0'),(20,5,'d','Ronald Reagen',_binary '\0'),(21,6,'a','Asia',_binary '\0'),(22,6,'b','Europe',_binary ''),(23,6,'c','Australia',_binary '\0'),(24,6,'d','America',_binary '\0'),(25,7,'a','Manchester',_binary '\0'),(26,7,'b','Liverpool',_binary '\0'),(27,7,'c','York',_binary '\0'),(28,7,'d','London',_binary ''),(29,8,'a','Tebriz',_binary '\0'),(30,8,'b','Tahran',_binary ''),(31,8,'c','Ankara',_binary '\0'),(32,8,'d','Halep',_binary '\0'),(33,9,'a','1930',_binary '\0'),(34,9,'b','1942',_binary '\0'),(35,9,'c','1946',_binary ''),(36,9,'d','1950',_binary '\0'),(37,10,'a','Eyes',_binary '\0'),(38,10,'b','Hands',_binary '\0'),(39,10,'c','Thounge',_binary '\0'),(40,10,'d','Lungs',_binary '');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Which is the highest mountain in Turkey?'),(2,'Which is the largest lake in Turkey?'),(3,'Which is the longest river on Earth?'),(4,'Which is the largest lake on earth?'),(5,'Who is the president of USA?'),(6,'In which continent does France recide?'),(7,'Which is the capital of UK?'),(8,'Which is the capital of Iran?'),(9,'When did World War I ended?'),(10,'By which organ do we breath?');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-25 10:24:25
