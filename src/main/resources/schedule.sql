CREATE DATABASE  IF NOT EXISTS `schedule` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `schedule`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: schedule
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `building_dto`
--

DROP TABLE IF EXISTS `building_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `building_dto` (
  `db_key` int(11) NOT NULL AUTO_INCREMENT,
  `building_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`db_key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building_dto`
--

LOCK TABLES `building_dto` WRITE;
/*!40000 ALTER TABLE `building_dto` DISABLE KEYS */;
INSERT INTO `building_dto` VALUES (1,'AES Super Awesome Building'),(2,'North Classroom Building'),(3,'test'),(4,'Another Building');
/*!40000 ALTER TABLE `building_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_dto`
--

DROP TABLE IF EXISTS `course_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_dto` (
  `course_number` int(11) NOT NULL,
  `coreqs` int(11) NOT NULL,
  `credits` int(11) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `learning_objectives` varchar(255) DEFAULT NULL,
  `prereqs` int(11) NOT NULL,
  PRIMARY KEY (`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_dto`
--

LOCK TABLES `course_dto` WRITE;
/*!40000 ALTER TABLE `course_dto` DISABLE KEYS */;
INSERT INTO `course_dto` VALUES (991,0,5,'CS','Computer Science and Dev Tools','Learn DEV',0),(3622,0,4,'MTH','Computer Science 1','CS1',0),(7777,0,78,'Super AW Dept','Test','bs course',0);
/*!40000 ALTER TABLE `course_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day_dto`
--

DROP TABLE IF EXISTS `day_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day_dto` (
  `day_db_key` int(11) NOT NULL AUTO_INCREMENT,
  `day_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`day_db_key`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day_dto`
--

LOCK TABLES `day_dto` WRITE;
/*!40000 ALTER TABLE `day_dto` DISABLE KEYS */;
INSERT INTO `day_dto` VALUES (1,'Monday'),(2,'Tuesday'),(3,'Wednesday'),(4,'Thursday'),(5,'Friday'),(6,'Saturday'),(7,'Sunday'),(8,'Monday'),(9,'Tuesday'),(10,'Wednesday'),(11,'Thursday'),(12,'Friday'),(13,'Saturday'),(14,'Sunday');
/*!40000 ALTER TABLE `day_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day_dto_day_map`
--

DROP TABLE IF EXISTS `day_dto_day_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day_dto_day_map` (
  `day_dto_day_db_key` int(11) NOT NULL,
  `day_map` bit(1) DEFAULT NULL,
  `day_map_key` int(11) NOT NULL,
  PRIMARY KEY (`day_dto_day_db_key`,`day_map_key`),
  CONSTRAINT `FKdpygvtlohrke5bd0746nb9iq2` FOREIGN KEY (`day_dto_day_db_key`) REFERENCES `day_dto` (`day_db_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day_dto_day_map`
--

LOCK TABLES `day_dto_day_map` WRITE;
/*!40000 ALTER TABLE `day_dto_day_map` DISABLE KEYS */;
INSERT INTO `day_dto_day_map` VALUES (1,'',800),(1,'',900),(1,'',1000),(1,'',1100),(1,'',1200),(1,'',1300),(1,'',1400),(1,'',1500),(1,'',1600),(1,'',1700),(1,'',1800),(1,'',1900),(1,'',2000),(2,'',800),(2,'',900),(2,'',1000),(2,'',1100),(2,'',1200),(2,'',1300),(2,'',1400),(2,'',1500),(2,'',1600),(2,'',1700),(2,'',1800),(2,'',1900),(2,'',2000),(3,'',800),(3,'',900),(3,'',1000),(3,'',1100),(3,'',1200),(3,'',1300),(3,'',1400),(3,'',1500),(3,'',1600),(3,'',1700),(3,'',1800),(3,'',1900),(3,'',2000),(4,'',800),(4,'',900),(4,'',1000),(4,'',1100),(4,'',1200),(4,'',1300),(4,'',1400),(4,'',1500),(4,'',1600),(4,'',1700),(4,'',1800),(4,'',1900),(4,'',2000),(5,'',800),(5,'',900),(5,'',1000),(5,'',1100),(5,'',1200),(5,'',1300),(5,'',1400),(5,'',1500),(5,'',1600),(5,'',1700),(5,'',1800),(5,'',1900),(5,'',2000),(6,'',800),(6,'',900),(6,'',1000),(6,'',1100),(6,'',1200),(6,'',1300),(6,'',1400),(6,'',1500),(6,'',1600),(6,'',1700),(6,'',1800),(6,'',1900),(6,'',2000),(7,'',800),(7,'',900),(7,'',1000),(7,'',1100),(7,'',1200),(7,'',1300),(7,'',1400),(7,'',1500),(7,'',1600),(7,'',1700),(7,'',1800),(7,'',1900),(7,'',2000),(8,'',800),(8,'',900),(8,'',1000),(8,'',1100),(8,'',1200),(8,'',1300),(8,'',1400),(8,'',1500),(8,'',1600),(8,'',1700),(8,'',1800),(8,'',1900),(8,'',2000),(9,'',800),(9,'',900),(9,'',1000),(9,'',1100),(9,'',1200),(9,'',1300),(9,'',1400),(9,'',1500),(9,'',1600),(9,'',1700),(9,'',1800),(9,'',1900),(9,'',2000),(10,'',800),(10,'',900),(10,'',1000),(10,'',1100),(10,'',1200),(10,'',1300),(10,'',1400),(10,'',1500),(10,'',1600),(10,'',1700),(10,'',1800),(10,'',1900),(10,'',2000),(11,'',800),(11,'',900),(11,'',1000),(11,'',1100),(11,'',1200),(11,'',1300),(11,'',1400),(11,'',1500),(11,'',1600),(11,'',1700),(11,'',1800),(11,'',1900),(11,'',2000),(12,'',800),(12,'',900),(12,'',1000),(12,'',1100),(12,'',1200),(12,'',1300),(12,'',1400),(12,'',1500),(12,'',1600),(12,'',1700),(12,'',1800),(12,'',1900),(12,'',2000),(13,'',800),(13,'',900),(13,'',1000),(13,'',1100),(13,'',1200),(13,'',1300),(13,'',1400),(13,'',1500),(13,'',1600),(13,'',1700),(13,'',1800),(13,'',1900),(13,'',2000),(14,'',800),(14,'',900),(14,'',1000),(14,'',1100),(14,'',1200),(14,'',1300),(14,'',1400),(14,'',1500),(14,'',1600),(14,'',1700),(14,'',1800),(14,'',1900),(14,'',2000);
/*!40000 ALTER TABLE `day_dto_day_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `global_dto`
--

DROP TABLE IF EXISTS `global_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `global_dto` (
  `school_name` varchar(255) NOT NULL,
  `level_by_credit_hour` int(11) NOT NULL,
  PRIMARY KEY (`school_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `global_dto`
--

LOCK TABLES `global_dto` WRITE;
/*!40000 ALTER TABLE `global_dto` DISABLE KEYS */;
/*!40000 ALTER TABLE `global_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_dto`
--

DROP TABLE IF EXISTS `professor_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_dto` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_dto`
--

LOCK TABLES `professor_dto` WRITE;
/*!40000 ALTER TABLE `professor_dto` DISABLE KEYS */;
INSERT INTO `professor_dto` VALUES (38271,'Steve','Beaty'),(73921,'John','Carmack');
/*!40000 ALTER TABLE `professor_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_dto`
--

DROP TABLE IF EXISTS `room_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_dto` (
  `room_number` int(11) NOT NULL,
  `building` varchar(255) DEFAULT NULL,
  `room_capacity` int(11) NOT NULL,
  `week_week_db_key` int(11) DEFAULT NULL,
  PRIMARY KEY (`room_number`),
  KEY `FK5xxxxfrx8p0o38nal1fpcqd29` (`week_week_db_key`),
  CONSTRAINT `FK5xxxxfrx8p0o38nal1fpcqd29` FOREIGN KEY (`week_week_db_key`) REFERENCES `week_dto` (`week_db_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_dto`
--

LOCK TABLES `room_dto` WRITE;
/*!40000 ALTER TABLE `room_dto` DISABLE KEYS */;
INSERT INTO `room_dto` VALUES (432,'North Classroom Building',29,2),(607,'AES Super Awesome Building',29,1);
/*!40000 ALTER TABLE `room_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_dto`
--

DROP TABLE IF EXISTS `schedule_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_dto` (
  `db_key` int(11) NOT NULL AUTO_INCREMENT,
  `section_dto_section_number` int(11) DEFAULT NULL,
  `student_name_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`db_key`),
  KEY `FKhuy1hlp25yy87uvcqmi9diufh` (`section_dto_section_number`),
  KEY `FK2eh169f9nhpxr2jqulh57agsd` (`student_name_id`),
  CONSTRAINT `FK2eh169f9nhpxr2jqulh57agsd` FOREIGN KEY (`student_name_id`) REFERENCES `student_dto` (`id`),
  CONSTRAINT `FKhuy1hlp25yy87uvcqmi9diufh` FOREIGN KEY (`section_dto_section_number`) REFERENCES `section_dto` (`section_number`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_dto`
--

LOCK TABLES `schedule_dto` WRITE;
/*!40000 ALTER TABLE `schedule_dto` DISABLE KEYS */;
INSERT INTO `schedule_dto` VALUES (10,11111,75830),(14,111122333,75830),(15,789236,75830);
/*!40000 ALTER TABLE `schedule_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_dto`
--

DROP TABLE IF EXISTS `section_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_dto` (
  `section_number` int(11) NOT NULL,
  `day` varchar(255) DEFAULT NULL,
  `time` int(11) NOT NULL,
  `course_course_number` int(11) DEFAULT NULL,
  `professor_id` int(11) DEFAULT NULL,
  `room_room_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`section_number`),
  KEY `FKlvj9uuymn4bvmawnq56irtvea` (`course_course_number`),
  KEY `FKkgsa0l7ypkketytoaywuu6v4e` (`professor_id`),
  KEY `FK8ipnoe2gs6jc7ulkpal9idkj3` (`room_room_number`),
  CONSTRAINT `FK8ipnoe2gs6jc7ulkpal9idkj3` FOREIGN KEY (`room_room_number`) REFERENCES `room_dto` (`room_number`),
  CONSTRAINT `FKkgsa0l7ypkketytoaywuu6v4e` FOREIGN KEY (`professor_id`) REFERENCES `professor_dto` (`id`),
  CONSTRAINT `FKlvj9uuymn4bvmawnq56irtvea` FOREIGN KEY (`course_course_number`) REFERENCES `course_dto` (`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_dto`
--

LOCK TABLES `section_dto` WRITE;
/*!40000 ALTER TABLE `section_dto` DISABLE KEYS */;
INSERT INTO `section_dto` VALUES (11111,'Monday',800,991,38271,432),(48999,'Monday',800,3622,73921,607),(456789,'Monday',900,7777,38271,607),(789236,'Monday',1600,7777,38271,432),(111122333,'Monday',900,991,38271,432);
/*!40000 ALTER TABLE `section_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester_dto`
--

DROP TABLE IF EXISTS `semester_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semester_dto` (
  `db_key` int(11) NOT NULL AUTO_INCREMENT,
  `semester_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`db_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester_dto`
--

LOCK TABLES `semester_dto` WRITE;
/*!40000 ALTER TABLE `semester_dto` DISABLE KEYS */;
INSERT INTO `semester_dto` VALUES (1,'Fall 2017');
/*!40000 ALTER TABLE `semester_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester_dto_sections`
--

DROP TABLE IF EXISTS `semester_dto_sections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semester_dto_sections` (
  `semester_dto_db_key` int(11) NOT NULL,
  `sections_section_number` int(11) NOT NULL,
  UNIQUE KEY `UK_au325l83k4lqdkp7s9uljodb8` (`sections_section_number`),
  KEY `FK1l29ra0en2fefqax6jigcgdes` (`semester_dto_db_key`),
  CONSTRAINT `FK1l29ra0en2fefqax6jigcgdes` FOREIGN KEY (`semester_dto_db_key`) REFERENCES `semester_dto` (`db_key`),
  CONSTRAINT `FKn2i28qwpjiq26q0jshlwuq8yq` FOREIGN KEY (`sections_section_number`) REFERENCES `section_dto` (`section_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester_dto_sections`
--

LOCK TABLES `semester_dto_sections` WRITE;
/*!40000 ALTER TABLE `semester_dto_sections` DISABLE KEYS */;
/*!40000 ALTER TABLE `semester_dto_sections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_dto`
--

DROP TABLE IF EXISTS `student_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_dto` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_dto`
--

LOCK TABLES `student_dto` WRITE;
/*!40000 ALTER TABLE `student_dto` DISABLE KEYS */;
INSERT INTO `student_dto` VALUES (75830,'Carla','Lopez'),(475888,'Alex','Whitlatch');
/*!40000 ALTER TABLE `student_dto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `week_dto`
--

DROP TABLE IF EXISTS `week_dto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `week_dto` (
  `week_db_key` int(11) NOT NULL AUTO_INCREMENT,
  `fri_day_db_key` int(11) DEFAULT NULL,
  `mon_day_db_key` int(11) DEFAULT NULL,
  `sat_day_db_key` int(11) DEFAULT NULL,
  `sun_day_db_key` int(11) DEFAULT NULL,
  `thurs_day_db_key` int(11) DEFAULT NULL,
  `tues_day_db_key` int(11) DEFAULT NULL,
  `wed_day_db_key` int(11) DEFAULT NULL,
  `five` int(11) NOT NULL,
  `four` int(11) NOT NULL,
  `six` int(11) NOT NULL,
  `three` int(11) NOT NULL,
  PRIMARY KEY (`week_db_key`),
  KEY `FK50jkeruwinbav5rkoecwe9cju` (`fri_day_db_key`),
  KEY `FKdpfeglt7to1djgx1qpjkloydc` (`mon_day_db_key`),
  KEY `FKt3k7nu782bmk6d1b4bm2fk6vv` (`sat_day_db_key`),
  KEY `FK5qgpcjqk4donvrqop3xpaafwh` (`sun_day_db_key`),
  KEY `FKbkr0gp1qnuj6h5qb4sg5irqo` (`thurs_day_db_key`),
  KEY `FKjds2k1jpbq0jpdrepavnnkry9` (`tues_day_db_key`),
  KEY `FKkgo6aubt37a6vjqwm9ohml2r0` (`wed_day_db_key`),
  CONSTRAINT `FK50jkeruwinbav5rkoecwe9cju` FOREIGN KEY (`fri_day_db_key`) REFERENCES `day_dto` (`day_db_key`),
  CONSTRAINT `FK5qgpcjqk4donvrqop3xpaafwh` FOREIGN KEY (`sun_day_db_key`) REFERENCES `day_dto` (`day_db_key`),
  CONSTRAINT `FKbkr0gp1qnuj6h5qb4sg5irqo` FOREIGN KEY (`thurs_day_db_key`) REFERENCES `day_dto` (`day_db_key`),
  CONSTRAINT `FKdpfeglt7to1djgx1qpjkloydc` FOREIGN KEY (`mon_day_db_key`) REFERENCES `day_dto` (`day_db_key`),
  CONSTRAINT `FKjds2k1jpbq0jpdrepavnnkry9` FOREIGN KEY (`tues_day_db_key`) REFERENCES `day_dto` (`day_db_key`),
  CONSTRAINT `FKkgo6aubt37a6vjqwm9ohml2r0` FOREIGN KEY (`wed_day_db_key`) REFERENCES `day_dto` (`day_db_key`),
  CONSTRAINT `FKt3k7nu782bmk6d1b4bm2fk6vv` FOREIGN KEY (`sat_day_db_key`) REFERENCES `day_dto` (`day_db_key`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `week_dto`
--

LOCK TABLES `week_dto` WRITE;
/*!40000 ALTER TABLE `week_dto` DISABLE KEYS */;
INSERT INTO `week_dto` VALUES (1,5,1,6,7,4,2,3,0,0,0,0),(2,12,8,13,14,11,9,10,0,0,0,0);
/*!40000 ALTER TABLE `week_dto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-06 18:56:11
