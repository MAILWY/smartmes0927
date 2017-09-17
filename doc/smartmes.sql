/*
Navicat MySQL Data Transfer

Source Server         : localhost-root
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : smartmes

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2017-09-17 15:08:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for batterycell
-- ----------------------------
DROP TABLE IF EXISTS `batterycell`;
CREATE TABLE `batterycell` (
  `cell_id` varchar(32) NOT NULL,
  `pedestal_id` varchar(32) DEFAULT NULL,
  `module_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`cell_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batterycell
-- ----------------------------

-- ----------------------------
-- Table structure for defective
-- ----------------------------
DROP TABLE IF EXISTS `defective`;
CREATE TABLE `defective` (
  `defective_date` varchar(32) DEFAULT NULL,
  `defective_rate` double DEFAULT NULL,
  `defective_num` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of defective
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(32) DEFAULT NULL,
  `menu_resource` varchar(255) DEFAULT NULL,
  `menu_flag` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for module_group
-- ----------------------------
DROP TABLE IF EXISTS `module_group`;
CREATE TABLE `module_group` (
  `module_id` varchar(32) DEFAULT NULL,
  `group_id` varchar(32) DEFAULT NULL,
  `box_id` varchar(32) DEFAULT NULL,
  `bms_id` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module_group
-- ----------------------------

-- ----------------------------
-- Table structure for test1
-- ----------------------------
DROP TABLE IF EXISTS `test1`;
CREATE TABLE `test1` (
  `id` int(11) NOT NULL,
  `test_time` varchar(32) DEFAULT NULL,
  `max_ec` double DEFAULT NULL,
  `min_ec` double DEFAULT NULL,
  `max_ev` double DEFAULT NULL,
  `min_ev` double DEFAULT NULL,
  `in_time` int(11) DEFAULT NULL,
  `out_time` int(11) DEFAULT NULL,
  `tester` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test1
-- ----------------------------

-- ----------------------------
-- Table structure for tsa
-- ----------------------------
DROP TABLE IF EXISTS `tsa`;
CREATE TABLE `tsa` (
  `tsa_id` varchar(32) NOT NULL COMMENT '1.1-1.8/2.1-2.8/3.1-3.8',
  `tsa_time` varchar(32) DEFAULT NULL,
  `tsa_useflag` varchar(32) DEFAULT NULL,
  `tsa_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tsa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tsa
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) NOT NULL,
  `user_pwd` varchar(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_sex` varchar(4) DEFAULT NULL,
  `user_birthday` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_menu
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu` (
  `user_id` varchar(32) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for woald1
-- ----------------------------
DROP TABLE IF EXISTS `woald1`;
CREATE TABLE `woald1` (
  `woald_date` varchar(32) NOT NULL,
  `electric_current` double DEFAULT NULL,
  `electric_voltage` double DEFAULT NULL,
  `capacity_factor` double DEFAULT NULL,
  PRIMARY KEY (`woald_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of woald1
-- ----------------------------

-- ----------------------------
-- Table structure for woald2
-- ----------------------------
DROP TABLE IF EXISTS `woald2`;
CREATE TABLE `woald2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `electric_current` double DEFAULT NULL,
  `electric_voltage` double DEFAULT NULL,
  `capacity_factor` double DEFAULT NULL,
  `woald2_time` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of woald2
-- ----------------------------
