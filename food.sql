/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.5-10.0.17-MariaDB : Database - onlinefoodservice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlinefoodservice` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `onlinefoodservice`;

/*Table structure for table `addproduct` */

DROP TABLE IF EXISTS `addproduct`;

CREATE TABLE `addproduct` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `price` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `mid` int(200) DEFAULT NULL,
  `Quantity` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  CONSTRAINT `addproduct_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `mainproduct` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

/*Data for the table `addproduct` */

insert  into `addproduct`(`id`,`name`,`price`,`image`,`mid`,`Quantity`) values (22,'Aaloo Matar','300','Aaloo-Matar.jpg',1,'6kg'),(23,'Chicken','500','chickenfry.jpg',2,'2kg'),(25,'Rasmalai','100','rasmalai-sweet.jpg',8,'1kg'),(26,'Gulab Jamun','200','gulabjamun.jpg',8,'5kg'),(27,'Aloo Paratha','20','AlooParatha (1).jpg',1,'2'),(28,'Palak paneer','50','palakpaneer.jpg',1,'3kg'),(29,'Veg Pulav','100','VegetablePulao.jpg',1,'3kg'),(30,'Laddu','200','bkladdu.jpg',8,'5kg'),(31,'Malai Pedhe','300','malai-peda.jpg',8,'4kg'),(32,'Balushahi','100','balushahi.jpg',8,'2kg'),(33,'Kaju katli','500','kajukatli.jpg',8,'5kg'),(34,'Chole','100','chole.jpg',1,'2kg'),(35,'Malai Kofta','150','Malai-Kofta.jpg',1,'3kg'),(36,'Paaneer Makhni','180','paneer_makhani.jpg',1,'kg'),(37,'Aloo matar','250','Aaloo-Matar.jpg',1,'1kg'),(38,'Lassi','20','lassi.jpg',3,'1 lit'),(39,'Chocklate Milkshake','20','chocklatemilkshake.jpg',3,'1 lit'),(40,'coco cola','20','cococola.png',3,'1 lit'),(41,'Fish Fry','100','fish-fry.jpg',2,'2 kg');

/*Table structure for table `addressdetails` */

DROP TABLE IF EXISTS `addressdetails`;

CREATE TABLE `addressdetails` (
  `adid` int(200) NOT NULL AUTO_INCREMENT,
  `fname` varchar(200) DEFAULT NULL,
  `mobileno` varchar(200) DEFAULT NULL,
  `pincode` varchar(200) DEFAULT NULL,
  `apartment` varchar(200) DEFAULT NULL,
  `area` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`adid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Data for the table `addressdetails` */

insert  into `addressdetails`(`adid`,`fname`,`mobileno`,`pincode`,`apartment`,`area`,`city`,`state`) values (25,'AArya','9977885510','411033','flat no. 8, Ganga D','Siddhivinayak nagri,nigdi','Pune','maharashtra'),(26,'Neha','9988776655','411033','flat no 8,siddhivinayak nagri','nigdi','pune','maharashtra'),(27,'Vaibhavi','9922097954','411033','devrai apartmet,near rajyog petrol pump','chinchwad','pune','maharashtra'),(28,'AArya','9977885510','411033','near kk market sailila bulding flat no 2','nigdi','pune','maharashtra');

/*Table structure for table `addtocart` */

DROP TABLE IF EXISTS `addtocart`;

CREATE TABLE `addtocart` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `customer_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `addtocart` */

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `Id` int(200) NOT NULL AUTO_INCREMENT,
  `Username` varchar(200) DEFAULT NULL,
  `Password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`Id`,`Username`,`Password`) values (1,'mrunal@gmail.com','12345');

/*Table structure for table `booktable` */

DROP TABLE IF EXISTS `booktable`;

CREATE TABLE `booktable` (
  `tableid` int(50) NOT NULL AUTO_INCREMENT,
  `id` int(50) DEFAULT NULL,
  `bookingdate` date DEFAULT NULL,
  `fromtime` varchar(200) DEFAULT NULL,
  `tofrom` varchar(200) DEFAULT NULL,
  `tablename` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`tableid`),
  KEY `id` (`id`),
  CONSTRAINT `booktable_ibfk_1` FOREIGN KEY (`id`) REFERENCES `registration` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `booktable` */

insert  into `booktable`(`tableid`,`id`,`bookingdate`,`fromtime`,`tofrom`,`tablename`) values (1,34,'2018-10-13','23:59','01:00','table1'),(2,34,'1111-01-01','01:01','02:02','table1'),(3,34,'1234-01-01','01:00','02:40','table1'),(4,35,'2018-10-31','04:00','05:57','table2'),(5,38,'2018-11-20','01:00','02:00','table1');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `IQuantity` int(50) DEFAULT NULL,
  `Aid` int(50) DEFAULT NULL,
  `rid` int(50) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Aid` (`Aid`),
  KEY `rid` (`rid`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`Aid`) REFERENCES `addproduct` (`id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `registration` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;

/*Data for the table `item` */

insert  into `item`(`id`,`IQuantity`,`Aid`,`rid`,`status`) values (87,1,27,38,'pending'),(88,1,23,38,'pending');

/*Table structure for table `mainproduct` */

DROP TABLE IF EXISTS `mainproduct`;

CREATE TABLE `mainproduct` (
  `mid` int(200) NOT NULL AUTO_INCREMENT,
  `mname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `mainproduct` */

insert  into `mainproduct`(`mid`,`mname`) values (1,'Veg'),(2,'Nonveg'),(3,'drink'),(8,'Sweet'),(11,'breakfast');

/*Table structure for table `offer` */

DROP TABLE IF EXISTS `offer`;

CREATE TABLE `offer` (
  `oid` int(200) NOT NULL AUTO_INCREMENT,
  `oname` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `fromdate` date DEFAULT NULL,
  `todate` date DEFAULT NULL,
  `oprice` varchar(200) DEFAULT NULL,
  `sprice` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `offer` */

insert  into `offer`(`oid`,`oname`,`image`,`fromdate`,`todate`,`oprice`,`sprice`) values (2,'Kaju katli','kajukatli.jpg','2018-10-04','2018-10-30','500','200'),(3,'Palak Paneer','palakpaneer.jpg','2018-10-25','2018-10-30','150','100');

/*Table structure for table `orderstatus` */

DROP TABLE IF EXISTS `orderstatus`;

CREATE TABLE `orderstatus` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `deliverydate` date DEFAULT NULL,
  `total` varchar(200) DEFAULT NULL,
  `type` varchar(200) DEFAULT NULL,
  `rid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  CONSTRAINT `orderstatus_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `registration` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `orderstatus` */

insert  into `orderstatus`(`id`,`deliverydate`,`total`,`type`,`rid`) values (8,'2018-11-21','520','Delivery',38);

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `Id` int(200) NOT NULL AUTO_INCREMENT,
  `fname` varchar(200) DEFAULT NULL,
  `lname` varchar(200) DEFAULT NULL,
  `emailid` varchar(200) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `mobileno` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`Id`,`fname`,`lname`,`emailid`,`username`,`password`,`address`,`mobileno`) values (32,'AArya','Jadhav','aaryaj1@gmail.com','aarya','333','chinchwad','9977885510'),(33,'Neha','Deshpande','vd494956@gmail.com','neha123','5555','kivle','9988776655'),(34,'Vrinda','sawant','vrinda3@gmail.com','vrinda','1111','Akurdi','9988772222'),(35,'Vaibhavi','Jadhav','vaibhavij7@gmail.com','vaibhavi','123','pune','9922097954'),(37,'Akanksha','Lawand','akanksha123@gmail.com','akanksha','99881','pune','9988776655'),(38,'ashwini','mahind','ashu@gmail.com','ashwini','123','pune','8796541230');

/*Table structure for table `specialmenu` */

DROP TABLE IF EXISTS `specialmenu`;

CREATE TABLE `specialmenu` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `sname` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `sprice` varchar(200) DEFAULT NULL,
  `squantity` varchar(200) DEFAULT NULL,
  `mid` int(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  CONSTRAINT `specialmenu_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `mainproduct` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `specialmenu` */

insert  into `specialmenu`(`id`,`sname`,`image`,`sprice`,`squantity`,`mid`) values (6,'Paneer tikka','paneer_makhani.jpg','100','1kg',1),(7,'Pulav','VegetablePulao.jpg','500','5',1),(8,'Mutton Korma','muttonkorma.jpg','150','1kg',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
