-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: dbAlert
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.24.04.1

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
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_envoie` datetime(6) DEFAULT NULL,
  `reb` bigint NOT NULL,
  `id_user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmngntsjxgejy7ae2ffn77db29` (`reb`),
  KEY `FK835nf05clqu6d8muc9vfrti7s` (`id_user`),
  CONSTRAINT `FK835nf05clqu6d8muc9vfrti7s` FOREIGN KEY (`id_user`) REFERENCES `user` (`email`),
  CONSTRAINT `FKmngntsjxgejy7ae2ffn77db29` FOREIGN KEY (`reb`) REFERENCES `reb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit`
--

LOCK TABLES `audit` WRITE;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reb`
--

DROP TABLE IF EXISTS `reb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `machine` varchar(255) DEFAULT NULL,
  `manual_reboot_time` datetime(6) DEFAULT NULL,
  `postponed_reboot_time` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `zone_id` varchar(255) DEFAULT NULL,
  `id_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjtr0bpaxku6isv3i7jamw7wwn` (`id_user`),
  CONSTRAINT `FKjtr0bpaxku6isv3i7jamw7wwn` FOREIGN KEY (`id_user`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reb`
--

LOCK TABLES `reb` WRITE;
/*!40000 ALTER TABLE `reb` DISABLE KEYS */;
INSERT INTO `reb` VALUES (1,'apcflex\\fr-oud','2025-04-19 16:38:51.391655','2025-03-09 03:00:14.000000','rebooted','OUD1CKB008:','mahdi@gmail.com'),(2,'apcflex\\fr-tng','2025-04-19 16:39:12.601937','2025-03-09 03:00:18.000000','rebooted','TNG1OPM001:','mahdi@gmail.com'),(3,'apcflex\\AT-CMN',NULL,'2025-03-08 23:00:17.000000','postponed','CMN1CKB060:',NULL),(4,'apcflex\\at-cmn',NULL,'2025-03-08 23:00:16.000000','postponed','CMN1CKB079:',NULL),(5,'apcflex\\at-cmn','2025-04-22 20:37:01.532211','2025-03-08 23:00:20.000000','rebooted','CMN1CKB081:','tech@example.com'),(6,'apcflex\\af-cmn',NULL,'2025-03-09 01:00:16.000000','postponed','CMN2CKB004:',NULL),(7,'apcflex\\pc-cmn','2025-04-22 19:32:47.634288','2025-03-09 01:00:16.000000','rebooted','CMN2CKB017:','tech@example.com'),(8,'apcflex\\alaraki.sa','2025-04-23 01:51:41.089786','2025-03-09 01:00:22.000000','rebooted','CMN2CKB041:','tech2@example.com'),(9,'apcflex\\brs-vil',NULL,'2025-03-08 23:00:18.000000','postponed','VIL1BDM001:',NULL),(10,'apcflex\\brs-esu',NULL,'2025-03-08 23:00:19.000000','postponed','ESU1BDM001:',NULL);
/*!40000 ALTER TABLE `reb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('mahdi@gmail.com','mahdi','123','tech','casa'),('manager@example.com','admin','pass','manager',''),('tech@example.com','technician','pass','techinician','CMN1CKB081:'),('tech2@example.com','ayoub','pass','technician','CMN2CKB041:');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-24 14:53:30
