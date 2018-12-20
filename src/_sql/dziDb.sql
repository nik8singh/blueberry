/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.32-MariaDB : Database - dzi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dzi` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dzi`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_fullname` varchar(255) DEFAULT NULL,
  `address_lineone` varchar(255) DEFAULT NULL,
  `address_linetwo` varchar(255) DEFAULT NULL,
  `address_city` varchar(100) DEFAULT NULL,
  `address_state` varchar(100) DEFAULT NULL,
  `address_zipcode` varchar(20) DEFAULT NULL,
  `address_country` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`address_id`),
  KEY `fk_user_address` (`user_id`),
  CONSTRAINT `fk_user_address` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`address_id`,`address_fullname`,`address_lineone`,`address_linetwo`,`address_city`,`address_state`,`address_zipcode`,`address_country`,`user_id`,`active`,`created_date`,`updated_date`) values (1,'Vegas convention cen','vegas 123','101','vegas','NV','12132','USA',2,'\0','2018-11-12 22:32:50','2018-12-16 17:26:37'),(6,'Gems and Stones Palace','235 Pearl st.','Apt. 312','essex junction','VT','05452','United States',NULL,'','2018-10-18 16:00:56','2018-10-18 16:00:56'),(7,'LA convention','Pike 123 st','building 123','San Fran.','CA','45612','US',NULL,'','2018-10-18 15:44:31','2018-10-18 15:44:31'),(13,'oihoihi','hoi','iohoi','oih','oihoih','4534534','hoihoi',2,'','2018-10-18 16:00:29','2018-12-16 16:22:35'),(16,'New Address for Shop','23rd St','BLD 23','London','London state','110086A','UK',NULL,'','2018-11-12 22:44:55','2018-11-12 22:44:55'),(20,'Nikhil Singh','125th st','apt 345','williston','VT','45689','USA',2,'','2018-12-16 17:15:43','2018-12-16 17:22:27');

/*Table structure for table `cartitem` */

DROP TABLE IF EXISTS `cartitem`;

CREATE TABLE `cartitem` (
  `cartItem_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `product_quantity` bigint(20) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cartItem_id`),
  KEY `fk_cartitem_user` (`user_id`),
  KEY `fk_cartitem_product` (`product_id`),
  CONSTRAINT `fk_cartitem_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_cartitem_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `cartitem` */

insert  into `cartitem`(`cartItem_id`,`product_id`,`user_id`,`product_quantity`,`created_date`,`updated_date`) values (5,7,2,5,'2018-12-16 20:58:05','2018-12-16 20:58:05'),(7,25,3,2,'2018-12-16 20:59:13','2018-12-16 20:59:13'),(8,27,3,3,'2018-12-16 20:59:21','2018-12-16 21:29:52');

/*Table structure for table `coupon` */

DROP TABLE IF EXISTS `coupon`;

CREATE TABLE `coupon` (
  `coupon_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(255) NOT NULL,
  `coupon_discount_percent` double(20,5) NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `coupon_start_date` datetime DEFAULT NULL,
  `coupon_end_date` datetime DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `coupon` */

insert  into `coupon`(`coupon_id`,`coupon_name`,`coupon_discount_percent`,`active`,`coupon_start_date`,`coupon_end_date`,`created_date`,`updated_date`) values (1,'Diwali',10.00000,'','2018-01-01 09:11:33','2018-02-01 09:11:43','2018-10-01 15:28:33','2018-10-02 09:11:51'),(2,'New years',25.00000,'','2018-10-01 00:00:00','2019-01-01 00:00:00','2018-10-01 15:30:37','2018-10-18 11:34:01'),(3,'test',10.00000,'','2018-08-01 00:00:00','2018-08-29 00:00:00','2018-10-18 15:52:35','2018-10-18 15:52:35'),(4,'2nd test',5.00000,'','2018-11-01 00:00:00','2018-11-30 00:00:00','2018-10-18 15:53:06','2018-10-18 15:53:06'),(5,'test add',0.00000,'\0',NULL,NULL,'2018-11-04 19:20:07','2018-12-20 12:54:11'),(6,'Mid term unit test',5.90000,'','2018-12-01 11:34:33','2019-01-01 11:34:37','2018-12-20 11:08:54','2018-12-20 11:34:42');

/*Table structure for table `gemstone` */

DROP TABLE IF EXISTS `gemstone`;

CREATE TABLE `gemstone` (
  `gemstone_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gemstone_name` varchar(20) DEFAULT NULL,
  `gemstone_description` varchar(255) DEFAULT 'not available',
  `active` bit(1) DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`gemstone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

/*Data for the table `gemstone` */

insert  into `gemstone`(`gemstone_id`,`gemstone_name`,`gemstone_description`,`active`,`created_date`,`updated_date`) values (24,'emerald','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(25,'rainbow moonlight','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(26,'black onix','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(27,'ruby','Red Gemstone','','2018-08-30 10:37:12','2018-12-20 15:18:13'),(28,'agate','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(29,'amber','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(30,'amethyst','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(31,'blue sapphire','Blue color stone','','2018-08-30 10:37:12','2018-10-01 14:15:59'),(32,'chalcedony','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(33,'citrine','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(34,'coral','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(35,'druzy','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(36,'labradorite','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(37,'lapis','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(38,'lemon topaz','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(39,'mystic topaz','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(40,'pearl','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(41,'roxk crustal','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(42,'star ruby','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(43,'sunstone','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(44,'turquoise','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(45,'test','test','\0','2018-12-13 22:01:02','2018-12-13 22:03:04'),(46,'Test inactive','not available','\0','2018-11-03 17:00:19','2018-11-03 17:00:31'),(47,'tester','tester Gemstone','','2018-12-13 22:01:02','2018-12-20 15:19:15');

/*Table structure for table `gemstone_product` */

DROP TABLE IF EXISTS `gemstone_product`;

CREATE TABLE `gemstone_product` (
  `gemstone_product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gemstone_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`gemstone_product_id`),
  KEY `fk_gemstone_product` (`gemstone_id`),
  KEY `fk_product_gemstone` (`product_id`),
  CONSTRAINT `fk_gemstone_product` FOREIGN KEY (`gemstone_id`) REFERENCES `gemstone` (`gemstone_id`),
  CONSTRAINT `fk_product_gemstone` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `gemstone_product` */

insert  into `gemstone_product`(`gemstone_product_id`,`gemstone_id`,`product_id`,`created_date`,`updated_date`) values (8,24,7,'2018-08-30 14:34:20','2018-08-30 14:34:20'),(15,45,24,'2018-12-13 22:07:12','2018-12-13 22:07:12'),(17,45,25,'2018-12-13 22:08:52','2018-12-13 22:08:52'),(19,45,27,'2018-12-13 22:14:28','2018-12-13 22:14:28');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (8),(8),(8);

/*Table structure for table `image` */

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
  `image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_site_location` varchar(255) NOT NULL,
  `image` longblob NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `image_priority` tinyint(3) unsigned DEFAULT '0',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`image_id`),
  KEY `fk_product_image` (`product_id`),
  CONSTRAINT `fk_product_image` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `image` */

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `invoice_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `tax_percent` double DEFAULT '0',
  `tax_amount` double DEFAULT '0',
  `invoice_amount` double DEFAULT '0',
  `shipping_address` bigint(20) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`invoice_id`),
  KEY `fk_user_invoice` (`user_id`),
  KEY `fk_invoice_shipping_address` (`shipping_address`),
  CONSTRAINT `fk_invoice_shipping_address` FOREIGN KEY (`shipping_address`) REFERENCES `address` (`address_id`),
  CONSTRAINT `fk_user_invoice` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `invoice` */

/*Table structure for table `jewelry_type` */

DROP TABLE IF EXISTS `jewelry_type`;

CREATE TABLE `jewelry_type` (
  `jewelry_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jewelry_type_name` varchar(20) DEFAULT NULL,
  `jewelry_type_description` varchar(255) DEFAULT 'not available',
  `active` bit(1) DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`jewelry_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `jewelry_type` */

insert  into `jewelry_type`(`jewelry_type_id`,`jewelry_type_name`,`jewelry_type_description`,`active`,`created_date`,`updated_date`) values (1,'banbles','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(2,'belts','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(3,'bracelets','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(4,'buckles','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(5,'cuff-links','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(6,'cuffs','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(7,'earrings','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(8,'necklaces','not available','','2018-08-30 11:02:07','2018-08-30 14:26:19'),(9,'pendents','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(10,'rings','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(11,'sets','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(12,'specials','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(13,'Test','Test','\0','2018-12-13 22:01:02','2018-12-13 22:01:47'),(14,'TestingNewAdd','Testing update to inactive','\0','2018-11-12 16:51:07','2018-11-12 16:52:18');

/*Table structure for table `metal` */

DROP TABLE IF EXISTS `metal`;

CREATE TABLE `metal` (
  `metal_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `metal_name` varchar(20) DEFAULT NULL,
  `metal_description` varchar(255) DEFAULT 'not available',
  `active` bit(1) DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`metal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `metal` */

insert  into `metal`(`metal_id`,`metal_name`,`metal_description`,`active`,`created_date`,`updated_date`) values (1,'Gold','not available','\0','2018-12-13 22:01:02','2018-12-13 22:03:29'),(2,'platinum','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(3,'palladium','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(4,'Silver','not available','\0','2018-12-13 22:01:02','2018-12-13 22:03:26'),(5,'cobalt','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(6,'tungsten','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(7,'titanium','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(8,'stainless steel','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(9,'TestingNewAdd','Testing update to inactive','\0','2018-11-12 16:07:50','2018-11-12 16:08:42'),(10,'test','not available','','2018-12-13 22:05:47','2018-12-13 22:05:47');

/*Table structure for table `metal_product` */

DROP TABLE IF EXISTS `metal_product`;

CREATE TABLE `metal_product` (
  `metal_product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `metal_id` bigint(20) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`metal_product_id`),
  KEY `fk_product_metal` (`product_id`),
  KEY `fk_metal_product` (`metal_id`),
  CONSTRAINT `fk_metal_product` FOREIGN KEY (`metal_id`) REFERENCES `metal` (`metal_id`),
  CONSTRAINT `fk_product_metal` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `metal_product` */

insert  into `metal_product`(`metal_product_id`,`product_id`,`metal_id`,`created_date`,`updated_date`) values (8,25,10,'2018-12-13 22:08:52','2018-12-13 22:08:52'),(10,24,1,'2018-12-13 22:29:46','2018-12-13 22:29:46'),(11,24,4,'2018-12-13 22:29:46','2018-12-13 22:29:46'),(12,27,1,'2018-12-13 22:30:39','2018-12-13 22:30:39'),(13,27,4,'2018-12-13 22:30:39','2018-12-13 22:30:39');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_jewelry_type` bigint(20) DEFAULT NULL,
  `product_weight` double DEFAULT '0',
  `weight_unit` varchar(50) DEFAULT 'kg',
  `product_price` double DEFAULT '0',
  `product_sku` varchar(255) DEFAULT NULL,
  `price_currency` varchar(50) DEFAULT NULL,
  `product_quantity` bigint(20) DEFAULT '0',
  `product_quantity_type` varchar(50) DEFAULT 'unit',
  `product_onfeatured` bit(1) DEFAULT b'0',
  `product_published` bit(1) DEFAULT b'0',
  `product_expense` double DEFAULT '0',
  `product_accept_coupon` bit(1) DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_sku` (`product_sku`),
  KEY `fk_jewelry_type_product` (`product_jewelry_type`),
  CONSTRAINT `fk_jewelry_type_product` FOREIGN KEY (`product_jewelry_type`) REFERENCES `jewelry_type` (`jewelry_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`product_id`,`product_name`,`product_description`,`product_jewelry_type`,`product_weight`,`weight_unit`,`product_price`,`product_sku`,`price_currency`,`product_quantity`,`product_quantity_type`,`product_onfeatured`,`product_published`,`product_expense`,`product_accept_coupon`,`created_date`,`updated_date`) values (7,'tester many gems','this is a tester product for many gems',8,40,'lbs',150,'2','usd',3,'piece','','',50,'\0','2018-08-30 14:34:20','2018-12-13 22:32:31'),(14,'test delete','niioi',2,0,'kg',0,NULL,NULL,0,'unit','\0','\0',0,'','2018-10-30 22:50:15','2018-12-16 21:05:57'),(24,'Product Junit 1st test','Testing part 1 addition of product using Junit',13,55.55,'Grams',120,'12546598913','USD',6,'pieces','','',30,'\0','2018-12-13 22:29:46','2018-12-13 22:29:46'),(25,'Product Junit 2nd test','Testing part 2 addition of product using Junit',13,20,'Grams',50,'12544913','USD',5,'pieces','','',10,'\0','2018-12-13 22:08:52','2018-12-13 22:08:52'),(27,'Product Junit 3rd test','Testing part 3 addition of product using Junit',13,40.55,'Grams',200,'125465989913','USD',2,'pieces','','',80,'\0','2018-12-13 22:30:39','2018-12-13 22:30:39');

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `purchase_id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_quantity` double DEFAULT '0',
  `invoice_id` bigint(20) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`purchase_id`),
  KEY `fk_invoice_product` (`invoice_id`),
  KEY `fk_product_purchase` (`product_id`),
  CONSTRAINT `FK5n94soa9xj2uema1977txr8j9` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  CONSTRAINT `fk_invoice_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchase` */

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `shop_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) NOT NULL,
  `shop_desrciption` varchar(255) NOT NULL,
  `shop_address` bigint(20) NOT NULL,
  `booth_number` varchar(20) DEFAULT NULL,
  `shop_start_date` date DEFAULT NULL,
  `shop_end_date` date DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`shop_id`),
  KEY `fk_address_show` (`shop_address`),
  CONSTRAINT `fk_address_show` FOREIGN KEY (`shop_address`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `shop` */

insert  into `shop`(`shop_id`,`shop_name`,`shop_desrciption`,`shop_address`,`booth_number`,`shop_start_date`,`shop_end_date`,`created_date`,`updated_date`) values (4,'GDL','Vegas Show testing update',1,'D101','2018-10-01','2018-10-31','2018-11-12 22:32:50','2018-11-12 22:32:50'),(5,'Stones and Gem Show','Alert test',6,'','2018-11-01','2018-11-23','2018-10-18 16:00:56','2018-10-18 16:00:56'),(6,'Jewelry Show','testing show',7,'JW123',NULL,NULL,'2018-10-18 15:44:31','2018-10-18 15:44:31'),(12,'Stones of worlds','show',13,'h','2018-07-01','2018-08-28','2018-10-18 16:00:29','2018-10-18 16:00:29'),(14,'GWL - London','New Show In London',16,'542','2018-11-12','2018-11-12','2018-11-12 22:44:55','2018-11-12 22:44:55');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_firstname` varchar(100) NOT NULL,
  `user_lastname` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `auth` varchar(20) NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_firstname`,`user_lastname`,`user_email`,`user_password`,`auth`,`deleted`,`created_date`,`updated_date`) values (2,'test','testwe','yyfyi@.com','Welcome234','buyer','','2018-10-31 22:30:10','2018-12-16 17:15:43'),(3,'Testing@Update','UnitTest','nik8singh@gmail.com','Welcome1','buyer','\0','2018-12-16 01:53:31','2018-12-16 02:01:57');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
