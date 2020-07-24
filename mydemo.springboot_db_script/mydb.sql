/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.5.36 : Database - mydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mydb`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`name`) values 
(23,'Book A'),
(25,'Book B'),
(27,'Book C'),
(29,'Java Book');

/*Table structure for table `book_publisher` */

DROP TABLE IF EXISTS `book_publisher`;

CREATE TABLE `book_publisher` (
  `book_id` bigint(20) DEFAULT NULL,
  `publisher_id` bigint(20) DEFAULT NULL,
  KEY `fk_book_cons` (`book_id`),
  KEY `fk_publisher_cons` (`publisher_id`),
  CONSTRAINT `fk_book_cons` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `fk_publisher_cons` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_publisher` */

insert  into `book_publisher`(`book_id`,`publisher_id`) values 
(23,3),
(23,4),
(25,5),
(25,6),
(25,7),
(27,8),
(27,9),
(29,10);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`code`,`description`) values 
(1,'C001','Type A'),
(2,'C002','Type B'),
(3,'C003','Type C');

/*Table structure for table `players` */

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `totalmatches` int(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `Team_Id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_taeam_001` (`Team_Id`),
  CONSTRAINT `fk_taeam_001` FOREIGN KEY (`Team_Id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `players` */

insert  into `players`(`id`,`name`,`dateofbirth`,`totalmatches`,`address`,`Team_Id`) values 
(1,'Kyaw Ko Ko','1990-05-08',100,'Yangon',1),
(2,'Kyi Linn','1992-08-18',95,'Mandalay',1),
(3,'Aung Thu','1994-02-17',95,'Yangon',1),
(4,'Min Thu','1992-01-15',50,'Taunggyi',2),
(8,'Maung Kyaw upd 11 222222 999','1991-07-10',0,'Bago kyaw kyaw',13),
(9,'Aung Win upd 44444 9999','1992-07-10',0,'Bago aung win',13),
(10,'New Player','1992-07-10',0,'new',13);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_fk_001` (`category_id`),
  CONSTRAINT `category_fk_001` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`code`,`description`,`category_id`) values 
(1,'P001','Product A',1),
(2,'P002','Product B',2),
(3,'P003','Product C',3),
(4,'P004','Product D',3);

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `publisher` */

insert  into `publisher`(`id`,`name`) values 
(3,'U Win'),
(4,'U Aung Kyaw'),
(5,'U Maung'),
(6,'U Soe'),
(7,'U San'),
(8,'U Soe'),
(9,'U Maung'),
(10,'New Publisher');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_password` varchar(50) DEFAULT NULL,
  `student_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`student_name`,`student_email`,`student_password`,`student_address`) values 
(1,'အာကာ','arkar@gmail.com',NULL,'ရန္ကုန္ျမိဳ ့'),
(2,'Mark Zuckerberg','zuckerberg.2014@facebook.com',NULL,'New York'),
(3,'Bill Gates','mrbill.ms@msoft.mail.com','11111','Washiton DC'),
(12,'Mr. Kyaw','kyaw.ucsy2019@gmail.com','11111','Yangon'),
(13,'Arkar UPDDD','ak_UPD@gmail.com',NULL,'Taungoo'),
(15,'New Student','new.stu001@gmail.com',NULL,'Yangon');

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teamname` varchar(150) DEFAULT NULL,
  `foundedyear` date DEFAULT NULL,
  `totalmatches` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `team` */

insert  into `team`(`id`,`teamname`,`foundedyear`,`totalmatches`) values 
(1,'Yangon United','2009-01-01',2000),
(2,'Shan United','2010-08-17',1500),
(3,'Team A','2019-08-29',0),
(4,'Team D','2019-08-18',0),
(5,'Team C','2019-08-11',0),
(6,'Team 999','2019-08-19',0),
(13,'Team 999','2019-08-19',0);

/*Table structure for table `user_account` */

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0=''Disabled'', 1=''Active''',
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_createdby_fk001` (`created_by`),
  KEY `user_updatedby_fk001` (`updated_by`),
  CONSTRAINT `user_createdby_fk001` FOREIGN KEY (`created_by`) REFERENCES `user_account` (`id`),
  CONSTRAINT `user_updatedby_fk001` FOREIGN KEY (`updated_by`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_account` */

insert  into `user_account`(`id`,`username`,`email`,`phone`,`password`,`status`,`created_time`,`updated_time`,`created_by`,`updated_by`) values 
(1,'admin','admin@gmail.com','09975666144','123456',1,'2019-08-15 23:53:17','2019-08-15 23:53:19',1,1),
(2,'arkar','arkar@gmail.com','09975777133','123456',1,'2019-08-15 23:53:58','2019-08-15 23:54:00',1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
