/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.35-MariaDB : Database - dzi
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
  `active` bit(1) NOT NULL DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`address_id`,`address_fullname`,`address_lineone`,`address_linetwo`,`address_city`,`address_state`,`address_zipcode`,`address_country`,`active`,`created_date`,`updated_date`) values (1,'Vegas convention cen','vegas 123','101','vegas','NV','12132','USA','','2018-11-12 22:32:50','2018-11-12 22:32:50'),(6,'Gems and Stones Palace','235 Pearl st.','Apt. 312','essex junction','VT','05452','United States','','2018-10-18 16:00:56','2018-10-18 16:00:56'),(7,'LA convention','Pike 123 st','building 123','San Fran.','CA','45612','US','','2018-10-18 15:44:31','2018-10-18 15:44:31'),(13,'oihoihi','hoi','iohoi','oih','oihoih','4534534','hoihoi','','2018-10-18 16:00:29','2018-10-31 22:11:41'),(16,'New Address for Shop','23rd St','BLD 23','London','London state','110086A','UK','','2018-11-12 22:44:55','2018-11-12 22:44:55');

/*Table structure for table `cartitems` */

DROP TABLE IF EXISTS `cartitems`;

CREATE TABLE `cartitems` (
  `cartItems_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `product_quantity` bigint(20) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cartItems_id`),
  KEY `fk_cartitems_product` (`user_id`),
  CONSTRAINT `fk_cartitems_product` FOREIGN KEY (`user_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_cartitems_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `cartitems` */

/*Table structure for table `coupon` */

DROP TABLE IF EXISTS `coupon`;

CREATE TABLE `coupon` (
  `coupon_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(255) NOT NULL,
  `coupon_discount_percent` double(20,5) NOT NULL,
  `coupon_start_date` datetime DEFAULT NULL,
  `coupon_end_date` datetime DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `coupon` */

insert  into `coupon`(`coupon_id`,`coupon_name`,`coupon_discount_percent`,`coupon_start_date`,`coupon_end_date`,`created_date`,`updated_date`) values (1,'Diwali',10.00000,'2018-01-01 09:11:33','2018-02-01 09:11:43','2018-10-01 15:28:33','2018-10-02 09:11:51'),(2,'New years',25.00000,'2018-10-01 00:00:00','2019-01-01 00:00:00','2018-10-01 15:30:37','2018-10-18 11:34:01'),(3,'test',10.00000,'2018-08-01 00:00:00','2018-08-29 00:00:00','2018-10-18 15:52:35','2018-10-18 15:52:35'),(4,'2nd test',5.00000,'2018-11-01 00:00:00','2018-11-30 00:00:00','2018-10-18 15:53:06','2018-10-18 15:53:06'),(5,'test add',5.50000,'2018-11-04 19:20:07','2018-11-04 19:20:07','2018-11-04 19:20:07','2018-11-04 19:20:07');

/*Table structure for table `gemstone` */

DROP TABLE IF EXISTS `gemstone`;

CREATE TABLE `gemstone` (
  `gemstone_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gemstone_name` varchar(20) NOT NULL,
  `gemstone_description` varchar(255) NOT NULL DEFAULT 'not available',
  `active` bit(1) NOT NULL DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`gemstone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

/*Data for the table `gemstone` */

insert  into `gemstone`(`gemstone_id`,`gemstone_name`,`gemstone_description`,`active`,`created_date`,`updated_date`) values (24,'emerald','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(25,'rainbow moonlight','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(26,'black onix','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(27,'ruby','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(28,'agate','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(29,'amber','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(30,'amethyst','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(31,'blue sapphire','Blue color stone','','2018-08-30 10:37:12','2018-10-01 14:15:59'),(32,'chalcedony','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(33,'citrine','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(34,'coral','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(35,'druzy','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(36,'labradorite','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(37,'lapis','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(38,'lemon topaz','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(39,'mystic topaz','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(40,'pearl','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(41,'roxk crustal','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(42,'star ruby','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(43,'sunstone','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(44,'turquoise','not available','','2018-08-30 10:37:12','2018-08-30 10:37:12'),(45,'Test active','not available','','2018-11-03 17:00:14','2018-11-03 17:00:22'),(46,'Test inactive','not available','\0','2018-11-03 17:00:19','2018-11-03 17:00:31'),(47,'TestingNewAdd','Testing update to inactive','\0','2018-11-12 15:15:59','2018-11-12 15:21:57');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `gemstone_product` */

insert  into `gemstone_product`(`gemstone_product_id`,`gemstone_id`,`product_id`,`created_date`,`updated_date`) values (7,27,7,'2018-08-30 14:34:20','2018-08-30 14:34:20'),(8,24,7,'2018-08-30 14:34:20','2018-08-30 14:34:20'),(9,27,14,'2018-11-03 16:21:16','2018-11-03 16:21:16');

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
  `image_server_location` varchar(255) NOT NULL,
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
  `tax_percent` bigint(20) DEFAULT NULL,
  `tax_amount` bigint(20) DEFAULT NULL,
  `invoice_amount` bigint(20) DEFAULT NULL,
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
  `jewelry_type_name` varchar(20) NOT NULL,
  `jewelry_type_description` varchar(255) NOT NULL DEFAULT 'not available',
  `active` bit(1) NOT NULL DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`jewelry_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `jewelry_type` */

insert  into `jewelry_type`(`jewelry_type_id`,`jewelry_type_name`,`jewelry_type_description`,`active`,`created_date`,`updated_date`) values (1,'banbles','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(2,'belts','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(3,'bracelets','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(4,'buckles','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(5,'cuff-links','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(6,'cuffs','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(7,'earrings','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(8,'necklaces','not available','','2018-08-30 11:02:07','2018-08-30 14:26:19'),(9,'pendents','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(10,'rings','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(11,'sets','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(12,'specials','not available','','2018-08-30 11:02:07','2018-08-30 11:02:07'),(13,'test','not available','\0','2018-10-30 22:49:50','2018-11-03 17:29:38'),(14,'TestingNewAdd','Testing update to inactive','\0','2018-11-12 16:51:07','2018-11-12 16:52:18');

/*Table structure for table `metal` */

DROP TABLE IF EXISTS `metal`;

CREATE TABLE `metal` (
  `metal_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `metal_name` varchar(20) NOT NULL,
  `metal_description` varchar(255) DEFAULT 'not available',
  `active` bit(1) NOT NULL DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`metal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `metal` */

insert  into `metal`(`metal_id`,`metal_name`,`metal_description`,`active`,`created_date`,`updated_date`) values (1,'gold','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(2,'platinum','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(3,'palladium','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(4,'silver','Testing update','','2018-11-12 15:20:54','2018-11-12 15:20:54'),(5,'cobalt','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(6,'tungsten','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(7,'titanium','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(8,'stainless steel','not available','','2018-08-30 11:05:30','2018-08-30 11:05:30'),(9,'TestingNewAdd','Testing update to inactive','\0','2018-11-12 16:07:50','2018-11-12 16:08:42');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `metal_product` */

insert  into `metal_product`(`metal_product_id`,`product_id`,`metal_id`,`created_date`,`updated_date`) values (2,7,1,'2018-08-30 14:34:20','2018-08-30 14:34:20');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) DEFAULT NULL,
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
  `product_expense` bigint(20) DEFAULT NULL,
  `product_accept_coupon` bit(1) DEFAULT b'1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_sku` (`product_sku`),
  KEY `fk_jewelry_type_product` (`product_jewelry_type`),
  CONSTRAINT `fk_jewelry_type_product` FOREIGN KEY (`product_jewelry_type`) REFERENCES `jewelry_type` (`jewelry_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`product_id`,`product_name`,`product_description`,`product_jewelry_type`,`product_weight`,`weight_unit`,`product_price`,`product_sku`,`price_currency`,`product_quantity`,`product_quantity_type`,`product_onfeatured`,`product_published`,`product_expense`,`product_accept_coupon`,`created_date`,`updated_date`) values (7,'tester many gems','this is a tester product for many gems',8,40,'lbs',150,'2','usd',3,'piece','','',200,'\0','2018-08-30 14:34:20','2018-11-04 22:51:07'),(14,'test delete','niioi',2,0,'kg',0,NULL,NULL,0,'unit','\0','\0',NULL,'','2018-10-30 22:50:15','2018-11-03 17:30:04');

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `purchase_id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_quantity` bigint(20) DEFAULT NULL,
  `invoice_id` bigint(20) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`purchase_id`),
  KEY `fk_invoice_product` (`invoice_id`),
  KEY `fk_product_purchase` (`product_id`),
  CONSTRAINT `fk_invoice_product` FOREIGN KEY (`invoice_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_product_purchase` FOREIGN KEY (`product_id`) REFERENCES `invoice` (`invoice_id`)
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
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_firstname`,`user_lastname`,`user_email`,`user_password`,`auth`,`created_date`,`updated_date`) values (2,'test','testwe','yyfyi@.com','HelloHi','','2018-10-31 22:30:10','2018-10-31 22:30:10');

/*Table structure for table `user_address` */

DROP TABLE IF EXISTS `user_address`;

CREATE TABLE `user_address` (
  `user_address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_address_id`),
  KEY `fk_address_user` (`address_id`),
  KEY `fk_user_address` (`user_id`),
  CONSTRAINT `fk_address_user` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `fk_user_address` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `user_address` */

insert  into `user_address`(`user_address_id`,`user_id`,`address_id`,`created_date`,`updated_date`) values (11,2,7,'2018-11-01 21:50:11','2018-11-01 21:50:11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;