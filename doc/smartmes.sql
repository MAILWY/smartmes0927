/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.17-log : Database - smartmes
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smartmes` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `smartmes`;

/*Table structure for table `batterycell` */

DROP TABLE IF EXISTS `batterycell`;

CREATE TABLE `batterycell` (
  `pedestal_id` varchar(32) DEFAULT NULL,
  `module_id` varchar(32) DEFAULT NULL,
  `cell_id1` varchar(32) NOT NULL,
  `cell_id2` varchar(32) DEFAULT NULL,
  `cell_id3` varchar(32) DEFAULT NULL,
  `cell_id4` varchar(32) DEFAULT NULL,
  `cell_id5` varchar(32) DEFAULT NULL,
  `cell_id6` varchar(32) DEFAULT NULL,
  `cell_id7` varchar(32) DEFAULT NULL,
  `cell_id8` varchar(32) DEFAULT NULL,
  `cell_id9` varchar(32) DEFAULT NULL,
  `cell_id10` varchar(32) DEFAULT NULL,
  `cell_id11` varchar(32) DEFAULT NULL,
  `cell_id12` varchar(32) DEFAULT NULL,
  `cell_id13` varchar(32) DEFAULT NULL,
  `cell_id14` varchar(32) DEFAULT NULL,
  `cell_id15` varchar(32) DEFAULT NULL,
  `cell_id16` varchar(32) DEFAULT NULL,
  `cell_id17` varchar(32) DEFAULT NULL,
  `cell_id18` varchar(32) DEFAULT NULL,
  `cell_id19` varchar(32) DEFAULT NULL,
  `cell_id20` varchar(32) DEFAULT NULL,
  `cell_id21` varchar(32) DEFAULT NULL,
  `cell_id22` varchar(32) DEFAULT NULL,
  `cell_id23` varchar(32) DEFAULT NULL,
  `cell_id24` varchar(32) DEFAULT NULL,
  `cell_id25` varchar(32) DEFAULT NULL,
  `cell_id26` varchar(32) DEFAULT NULL,
  `cell_id27` varchar(32) DEFAULT NULL,
  `cell_id28` varchar(32) DEFAULT NULL,
  `cell_id29` varchar(32) DEFAULT NULL,
  `cell_id30` varchar(32) DEFAULT NULL,
  `cell_id31` varchar(32) DEFAULT NULL,
  `cell_id32` varchar(32) DEFAULT NULL,
  `cell_id33` varchar(32) DEFAULT NULL,
  `cell_id34` varchar(32) DEFAULT NULL,
  `cell_id35` varchar(32) DEFAULT NULL,
  `cell_id36` varchar(32) DEFAULT NULL,
  `cell_id37` varchar(32) DEFAULT NULL,
  `cell_id38` varchar(32) DEFAULT NULL,
  `cell_id39` varchar(32) DEFAULT NULL,
  `cell_id40` varchar(32) DEFAULT NULL,
  `cell_id41` varchar(32) DEFAULT NULL,
  `cell_id42` varchar(32) DEFAULT NULL,
  `cell_id43` varchar(32) DEFAULT NULL,
  `cell_id44` varchar(32) DEFAULT NULL,
  `cell_id45` varchar(32) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cell_id1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `batterycell` */

insert  into `batterycell`(`pedestal_id`,`module_id`,`cell_id1`,`cell_id2`,`cell_id3`,`cell_id4`,`cell_id5`,`cell_id6`,`cell_id7`,`cell_id8`,`cell_id9`,`cell_id10`,`cell_id11`,`cell_id12`,`cell_id13`,`cell_id14`,`cell_id15`,`cell_id16`,`cell_id17`,`cell_id18`,`cell_id19`,`cell_id20`,`cell_id21`,`cell_id22`,`cell_id23`,`cell_id24`,`cell_id25`,`cell_id26`,`cell_id27`,`cell_id28`,`cell_id29`,`cell_id30`,`cell_id31`,`cell_id32`,`cell_id33`,`cell_id34`,`cell_id35`,`cell_id36`,`cell_id37`,`cell_id38`,`cell_id39`,`cell_id40`,`cell_id41`,`cell_id42`,`cell_id43`,`cell_id44`,`cell_id45`,`insert_time`) values
('444444444444','5555555555555','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2017-10-18 17:27:18'),
('afj1111111','12125555555555121','1','2','3','4','5','6','7','8','111','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34','35','36','37','38','39','40','41','42','43','44','111',NULL),
('afj1111113','afj1111223','11','12','13','14','15','16','17','18','19','110','111','112','113','114','115','116','117','118','119','120','121','122','123','124','125','126','127','128','129','130','131','132','133','134','135','136','137','138','139','140','141','142','143','144','145',NULL);

/*Table structure for table `defective` */

DROP TABLE IF EXISTS `defective`;

CREATE TABLE `defective` (
  `defective_date` varchar(32) DEFAULT NULL,
  `defective_rate` double DEFAULT NULL,
  `defective_num` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `defective` */

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menu_id` varchar(11) NOT NULL,
  `menu_name` varchar(32) DEFAULT NULL,
  `menu_resource` varchar(255) DEFAULT NULL,
  `menu_flag` varchar(2) DEFAULT NULL,
  `date_time` date DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menu_id`,`menu_name`,`menu_resource`,`menu_flag`,`date_time`) values
('1','用户新增','/user/insert/','',NULL),
('2','用户菜单','/usermenu/select','',NULL),
('3','用户删除','/user/delete',NULL,NULL),
('4','模块绑定','/modulegroup/selectbyid',NULL,NULL),
('5','缓存库查询','/tsa/select',NULL,NULL);

/*Table structure for table `mes_charge_info` */

DROP TABLE IF EXISTS `mes_charge_info`;

CREATE TABLE `mes_charge_info` (
  `test_mach` int(11) NOT NULL,
  `channel_num` varchar(8) NOT NULL,
  `channel_state` varchar(8) DEFAULT NULL COMMENT '0闲置，1使用，2故障',
  `channel_dsc` varchar(32) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`test_mach`,`channel_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mes_charge_info` */

insert  into `mes_charge_info`(`test_mach`,`channel_num`,`channel_state`,`channel_dsc`,`date_time`) values
(1,'1','2','0闲置，1使用，2故障','2017-10-18 17:30:56'),
(1,'2','2','0闲置，1使用，2故障','2017-10-18 17:30:56'),
(2,'1','2','0闲置，1使用，2故障','2017-10-18 17:32:22'),
(2,'2','2','0闲置，1使用，2故障','2017-10-18 17:32:22'),
(3,'1','2','0闲置，1使用，2故障','2017-10-18 17:32:26'),
(3,'2','2','0闲置，1使用，2故障','2017-10-18 17:32:26'),
(4,'1','2','0闲置，1使用，2故障','2017-10-18 17:32:31'),
(4,'2','2','0闲置，1使用，2故障','2017-10-18 17:32:31'),
(5,'1','2','0闲置，1使用，2故障','2017-10-18 17:32:39'),
(5,'2','2','0闲置，1使用，2故障','2017-10-18 17:32:39'),
(6,'1','1','0闲置，1使用，2故障','2017-10-18 17:33:06'),
(6,'2','1','0闲置，1使用，2故障','2017-10-18 17:33:06');

/*Table structure for table `mes_prod_test` */

DROP TABLE IF EXISTS `mes_prod_test`;

CREATE TABLE `mes_prod_test` (
  `test_date` varchar(30) NOT NULL,
  `work_order` varchar(30) NOT NULL,
  `prod_num` varchar(30) NOT NULL,
  `test_mach` varchar(30) DEFAULT NULL,
  `adj_id` varchar(30) DEFAULT NULL,
  `appro_id` varchar(30) DEFAULT NULL,
  `charge_height` varchar(30) DEFAULT NULL,
  `charge_low` varchar(30) DEFAULT NULL,
  `charge_diff` varchar(30) DEFAULT NULL,
  `charge_result` varchar(30) DEFAULT NULL,
  `discharge_height` varchar(30) DEFAULT NULL,
  `discharge_low` varchar(30) DEFAULT NULL,
  `discharge_diff` varchar(30) DEFAULT NULL,
  `discharge_result` varchar(30) DEFAULT NULL,
  `discharge_diff_3` varchar(30) DEFAULT NULL,
  `discharge_diff_result` varchar(30) DEFAULT NULL,
  `discharge_tempdiff` varchar(30) DEFAULT NULL,
  `discharge_temp_result` varchar(30) DEFAULT NULL,
  `charge_half_volt` varchar(30) DEFAULT NULL,
  `charge_half_result` varchar(30) DEFAULT NULL,
  `charge_half_soc` varchar(30) DEFAULT NULL,
  `charge_half_soc_r` varchar(30) DEFAULT NULL,
  `last_judgement` varchar(30) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`work_order`,`prod_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mes_prod_test` */

insert  into `mes_prod_test`(`test_date`,`work_order`,`prod_num`,`test_mach`,`adj_id`,`appro_id`,`charge_height`,`charge_low`,`charge_diff`,`charge_result`,`discharge_height`,`discharge_low`,`discharge_diff`,`discharge_result`,`discharge_diff_3`,`discharge_diff_result`,`discharge_tempdiff`,`discharge_temp_result`,`charge_half_volt`,`charge_half_result`,`charge_half_soc`,`charge_half_soc_r`,`last_judgement`,`time`) values
('111','1121','11111','0001','0002','0003','0004','0005','0006','0007','0008','0009','0010','0011','0012','0013','0014','0015','0016','0017','0018','0019','0010',NULL);

/*Table structure for table `module_group` */

DROP TABLE IF EXISTS `module_group`;

CREATE TABLE `module_group` (
  `modulegrooupid` int(11) NOT NULL AUTO_INCREMENT,
  `box_id` varchar(32) DEFAULT NULL,
  `bms_id` varchar(32) DEFAULT NULL,
  `group_id` varchar(32) DEFAULT NULL,
  `module_id1` varchar(32) DEFAULT NULL,
  `module_id2` varchar(32) DEFAULT NULL,
  `module_id3` varchar(32) DEFAULT NULL,
  `module_id4` varchar(32) DEFAULT NULL,
  `module_id5` varchar(32) DEFAULT NULL,
  `module_id6` varchar(32) DEFAULT NULL,
  `module_id7` varchar(32) DEFAULT NULL,
  `module_id8` varchar(32) DEFAULT NULL,
  `module_id9` varchar(32) DEFAULT NULL,
  `module_id10` varchar(32) DEFAULT NULL,
  `module_id11` varchar(32) DEFAULT NULL,
  `module_id12` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`modulegrooupid`),
  KEY `modulegrooupid` (`modulegrooupid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `module_group` */

insert  into `module_group`(`modulegrooupid`,`box_id`,`bms_id`,`group_id`,`module_id1`,`module_id2`,`module_id3`,`module_id4`,`module_id5`,`module_id6`,`module_id7`,`module_id8`,`module_id9`,`module_id10`,`module_id11`,`module_id12`,`time`) values
(1,NULL,NULL,'1001','1001','1002','1003','1004','1005','1006','1007','1008','1009','1010','1011','1012',NULL),
(2,NULL,NULL,'1011','1011','1002','1003','1004','1005','1006','1007','1008','1009','1010','1011','1012',NULL),
(3,NULL,NULL,'1011','1011','1002','1003','1004','1005','1006','1007','1008','1009','1010','1011','1012',NULL),
(4,NULL,NULL,'1011','1011','1002','1003','1004','1005','1006','1007','1008','1009','1010','1011','1012',NULL),
(5,NULL,NULL,'1111','1111','1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL),
(6,NULL,NULL,'1111','1111','1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL),
(7,NULL,NULL,'1111','1111','1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL),
(8,NULL,NULL,'1111','1111','1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL),
(9,NULL,NULL,'55as1111','55as1111','sadsdasd1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL),
(10,NULL,NULL,'55as1111','55as1111','sadsdasd1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL),
(11,NULL,NULL,'55as1111','55as1111','sadsdasd1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL),
(12,NULL,NULL,'55as1111','55as1111','sadsdasd1102','1113','1104','1015','1016','1017','1018','1109','1110','1111','1112',NULL);

/*Table structure for table `tsa` */

DROP TABLE IF EXISTS `tsa`;

CREATE TABLE `tsa` (
  `tsa_id` int(8) NOT NULL COMMENT '1.1-1.8/2.1-2.8/3.1-3.8',
  `tsa_line` varchar(5) NOT NULL,
  `tsa_row` varchar(5) NOT NULL,
  `tsa_time` varchar(32) DEFAULT NULL,
  `tsa_useflag` varchar(32) NOT NULL,
  `tsa_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tsa_id`,`tsa_line`,`tsa_row`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tsa` */

insert  into `tsa`(`tsa_id`,`tsa_line`,`tsa_row`,`tsa_time`,`tsa_useflag`,`tsa_desc`) values
(1,'1','1','2017-10-18 17:17:54','2','0 空 1 占位 2 故障'),
(2,'1','2','2017-10-18 17:21:21','2','0 空 1 占位 2 故障'),
(3,'1','3','2017-10-18 17:21:25','2','0 空 1 占位 2 故障'),
(4,'1','4','2017-10-18 17:21:33','2','0 空 1 占位 2 故障'),
(5,'1','5','2017-10-18 17:21:37','2','0 空 1 占位 2 故障'),
(6,'1','6','2017-10-18 17:21:41','2','0 空 1 占位 2 故障'),
(7,'1','7','2017-10-18 17:21:45','2','0 空 1 占位 2 故障'),
(8,'1','8','2017-10-18 17:21:56','2','0 空 1 占位 2 故障'),
(9,'2','1','2017-10-18 17:22:00','2','0 空 1 占位 2 故障'),
(10,'2','2','2017-10-18 17:22:08','2','0 空 1 占位 2 故障'),
(11,'2','3','2017-10-18 17:22:21','2','0 空 1 占位 2 故障'),
(12,'2','4','2017-10-18 17:22:25','2','0 空 1 占位 2 故障'),
(13,'2','5','2017-10-18 17:22:29','2','0 空 1 占位 2 故障'),
(14,'2','6','2017-10-18 17:22:32','2','0 空 1 占位 2 故障'),
(15,'2','7',NULL,'1','0 空 1 占位 2 故障'),
(16,'2','8',NULL,'1','0 空 1 占位 2 故障'),
(17,'3','1',NULL,'1','0 空 1 占位 2 故障'),
(18,'3','2',NULL,'1','0 空 1 占位 2 故障'),
(19,'3','3',NULL,'1','0 空 1 占位 2 故障'),
(20,'3','4',NULL,'1','0 空 1 占位 2 故障'),
(21,'3','5',NULL,'0','0 空 1 占位 2 故障'),
(22,'3','6',NULL,'1','0 空 1 占位 2 故障'),
(23,'3','7',NULL,'0','0 空 1 占位 2 故障'),
(24,'3','8',NULL,'1','0 空 1 占位 2 故障');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(32) NOT NULL,
  `user_pwd` varchar(32) DEFAULT '1',
  `user_name` varchar(32) DEFAULT NULL,
  `user_flag` varchar(2) DEFAULT '0' COMMENT '1:管理员0普通用户',
  `user_sex` varchar(4) DEFAULT NULL,
  `user_birthday` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_pwd`,`user_name`,`user_flag`,`user_sex`,`user_birthday`) values
('111','1','张三','1','',''),
('1213wqetry','1','了；安居房；啦','0',NULL,NULL),
('222','1','李四','1','',''),
('333','333333333','王五','2',NULL,NULL),
('444','1','马六','0',NULL,NULL);

/*Table structure for table `user_menu` */

DROP TABLE IF EXISTS `user_menu`;

CREATE TABLE `user_menu` (
  `user_id` varchar(32) NOT NULL,
  `menu_id` varchar(11) NOT NULL,
  `oper_id` varchar(32) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_menu` */

insert  into `user_menu`(`user_id`,`menu_id`,`oper_id`,`oper_time`) values
('111','1',NULL,NULL),
('111','3',NULL,NULL),
('111','4',NULL,NULL),
('111','5',NULL,NULL),
('1111','1111',NULL,NULL),
('222','1',NULL,NULL),
('222','3',NULL,NULL),
('222','5',NULL,NULL),
('333','3',NULL,NULL);

/*Table structure for table `woald1` */

DROP TABLE IF EXISTS `woald1`;

CREATE TABLE `woald1` (
  `woald_id` int(11) NOT NULL AUTO_INCREMENT,
  `woald_date` varchar(32) NOT NULL,
  `end_date` varchar(32) DEFAULT NULL,
  `electric_current` varchar(32) DEFAULT NULL,
  `electric_voltage` varchar(32) DEFAULT NULL,
  `capacity_factor` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`woald_id`),
  KEY `woald_id` (`woald_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `woald1` */

insert  into `woald1`(`woald_id`,`woald_date`,`end_date`,`electric_current`,`electric_voltage`,`capacity_factor`) values
(1,'1111','13251325123','1111','1111','1111');

/*Table structure for table `woald2` */

DROP TABLE IF EXISTS `woald2`;

CREATE TABLE `woald2` (
  `woald_id` int(11) NOT NULL AUTO_INCREMENT,
  `woald_date` varchar(32) NOT NULL,
  `end_date` varchar(32) DEFAULT NULL,
  `electric_current` varchar(32) DEFAULT NULL,
  `electric_voltage` varchar(32) DEFAULT NULL,
  `capacity_factor` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`woald_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `woald2` */

/* Trigger structure for table `batterycell` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tr_batterycell_change` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tr_batterycell_change` BEFORE INSERT ON `batterycell` FOR EACH ROW BEGIN
        SET new.`insert_time`=NOW() ;
    END */$$


DELIMITER ;

/* Trigger structure for table `mes_charge_info` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tr_mes_charge_info_change` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tr_mes_charge_info_change` BEFORE UPDATE ON `mes_charge_info` FOR EACH ROW BEGIN
        SET new.`date_time`=NOW() ;
    END */$$


DELIMITER ;

/* Trigger structure for table `mes_prod_test` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tr_mes_prod_test_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tr_mes_prod_test_insert` BEFORE INSERT ON `mes_prod_test` FOR EACH ROW BEGIN
         SET new.`time`=NOW() ;
    END */$$


DELIMITER ;

/* Trigger structure for table `module_group` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tr_module_group_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tr_module_group_insert` BEFORE INSERT ON `module_group` FOR EACH ROW BEGIN
        SET new.`time`=NOW() ;
    END */$$


DELIMITER ;

/* Trigger structure for table `tsa` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tr_tsa_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tr_tsa_update` BEFORE UPDATE ON `tsa` FOR EACH ROW BEGIN
        SET new.tsa_time=NOW() ;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
