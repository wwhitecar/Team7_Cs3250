/*

SQLyog Community v12.4.3 (64 bit)

MySQL - 5.7.19-log : Database - schedule

*********************************************************************

*/



/*!40101 SET NAMES utf8 */;



/*!40101 SET SQL_MODE=''*/;



/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`schedule` /*!40100 DEFAULT CHARACTER SET utf8 */;



USE `schedule`;



/*Table structure for table `course` */



DROP TABLE IF EXISTS `course`;



CREATE TABLE `course` (

  `course_id` int(11) NOT NULL AUTO_INCREMENT,

  `department` varchar(64) DEFAULT NULL,

  `course_number` int(10) DEFAULT NULL,

  `credits` int(10) DEFAULT NULL,

  `description` text,

  `learning_objective` varchar(64) DEFAULT NULL,

  `prereqs` int(255) DEFAULT NULL,

  `coreqs` int(255) DEFAULT NULL,

  PRIMARY KEY (`course_id`)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



/*Table structure for table `course_prereq` */



DROP TABLE IF EXISTS `course_prereq`;



CREATE TABLE `course_prereq` (

  `course_prereq_id` int(11) NOT NULL AUTO_INCREMENT,

  `course_id` int(11) NOT NULL,

  `prereq_course_id` int(11) NOT NULL,

  `is_coreq` tinyint(1) NOT NULL,

  PRIMARY KEY (`course_prereq_id`),

  KEY `course_id` (`course_id`),

  KEY `prereq_course_id` (`prereq_course_id`),

  CONSTRAINT `course_prereq_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),

  CONSTRAINT `course_prereq_ibfk_2` FOREIGN KEY (`prereq_course_id`) REFERENCES `course` (`course_id`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



/*Table structure for table `professor` */



DROP TABLE IF EXISTS `professor`;



CREATE TABLE `professor` (

  `professor_id` int(11) NOT NULL AUTO_INCREMENT,

  `first_name` varchar(64) DEFAULT NULL,

  `last_name` varchar(64) DEFAULT NULL,

  PRIMARY KEY (`professor_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*Table structure for table `section` */



DROP TABLE IF EXISTS `section`;



CREATE TABLE `section` (

  `section_id` int(10) unsigned NOT NULL AUTO_INCREMENT,

  `course_id` int(11) NOT NULL,

  `professor_id` int(11) NOT NULL,

  PRIMARY KEY (`section_id`),

  KEY `course_id` (`course_id`),

  KEY `professor_id` (`professor_id`),

  CONSTRAINT `section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),

  CONSTRAINT `section_ibfk_2` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`professor_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*Table structure for table `users` */



DROP TABLE IF EXISTS `users`;



CREATE TABLE `users` (

  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,

  `student_id` int(11) NOT NULL,

  `first_name` varchar(64) NOT NULL,

  `last_name` varchar(64) NOT NULL,

  PRIMARY KEY (`user_id`)

) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;

/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
