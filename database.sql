-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: savethislittle
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `economyinfo`
--

DROP TABLE IF EXISTS `economyinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `economyinfo` (
  `id` bigint(20) NOT NULL,
  `currentmoney` double NOT NULL,
  `monthlyearning` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `economyinfo`
--

LOCK TABLES `economyinfo` WRITE;
/*!40000 ALTER TABLE `economyinfo` DISABLE KEYS */;
INSERT INTO `economyinfo` VALUES (1,4026,1130);
/*!40000 ALTER TABLE `economyinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `economyinfo_seq`
--

DROP TABLE IF EXISTS `economyinfo_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `economyinfo_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `economyinfo_seq`
--

LOCK TABLES `economyinfo_seq` WRITE;
/*!40000 ALTER TABLE `economyinfo_seq` DISABLE KEYS */;
INSERT INTO `economyinfo_seq` VALUES (101);
/*!40000 ALTER TABLE `economyinfo_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `expenses` (
  `id` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `category` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `monthdb` varchar(255) NOT NULL,
  `note` varchar(255) NOT NULL,
  `subcategory` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `yeardb` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses`
--

LOCK TABLES `expenses` WRITE;
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` VALUES (1,50,'alcohol','poncho@email.com','february','ladron de manzanas','sider,','one-time expense','2016'),(2,33,'alcohol','poncho@email.com','march','rum alcampo','rum,','one-time expense','2017'),(3,53,'cinema','poncho@email.com','august','los vengadores','entradas,','one-time expense','2013'),(4,21,'cinema','poncho@email.com','january','los increibles','entradas,','one-time expense','2018'),(52,14,'food','poncho@email.com','march','galletas','supermarket,','one-time expense','2018'),(53,10,'food','poncho@email.com','march','pipas','supermarket,','one-time expense','2018'),(54,3,'food','poncho@email.com','march','risketos','supermarket,','one-time expense','2018'),(102,25,'alcohol','poncho@email.com','march','jack daniels','whisky,','one-time expense','2018'),(103,33,'alcohol','poncho@email.com','march','jagger bomb','Jagger,','one-time expense','2018'),(152,47,'vehicle','poncho@email.com','june','gasofa costco','gas,','one-time expense','2018'),(153,41,'vehicle','poncho@email.com','june','gasofa costco','gas,','one-time expense','2018');
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_seq`
--

DROP TABLE IF EXISTS `expenses_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `expenses_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_seq`
--

LOCK TABLES `expenses_seq` WRITE;
/*!40000 ALTER TABLE `expenses_seq` DISABLE KEYS */;
INSERT INTO `expenses_seq` VALUES (251);
/*!40000 ALTER TABLE `expenses_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `expensescategorybymonthandyear`
--

DROP TABLE IF EXISTS `expensescategorybymonthandyear`;
/*!50001 DROP VIEW IF EXISTS `expensescategorybymonthandyear`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `expensescategorybymonthandyear` AS SELECT 
 1 AS `id`,
 1 AS `email`,
 1 AS `category`,
 1 AS `monthdb`,
 1 AS `yeardb`,
 1 AS `sumamount`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `economyinfo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhou85kko4xcpfglr3wm8icbb4` (`economyinfo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'poncho@email.com','123456','poncho',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (101);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `expensescategorybymonthandyear`
--

/*!50001 DROP VIEW IF EXISTS `expensescategorybymonthandyear`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `expensescategorybymonthandyear` AS select `myalias`.`id` AS `id`,`myalias`.`email` AS `email`,`myalias`.`category` AS `category`,`myalias`.`monthdb` AS `monthdb`,`myalias`.`yeardb` AS `yeardb`,`myalias`.`sumamount` AS `sumamount` from (select `expenses`.`id` AS `id`,`expenses`.`email` AS `email`,`expenses`.`category` AS `category`,`expenses`.`monthdb` AS `monthdb`,`expenses`.`yeardb` AS `yeardb`,sum(`expenses`.`amount`) AS `sumamount` from `expenses` group by `expenses`.`monthdb`,`expenses`.`yeardb`,`expenses`.`email`,`expenses`.`category` order by `sumamount` desc) `myalias` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-30 23:59:28
