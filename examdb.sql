/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : examdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2023-12-25 10:48:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '会员姓名',
  `gender` varchar(10) DEFAULT NULL COMMENT '会员性别',
  `birth` date DEFAULT NULL COMMENT '会员生日',
  `level` varchar(20) DEFAULT NULL COMMENT '会员等级',
  `mobile` char(11) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of members
-- ----------------------------
INSERT INTO `members` VALUES ('1', '张三', '男', '2023-12-20', '金卡', '10086');
INSERT INTO `members` VALUES ('3', 'sdd', '男', '2002-10-19', '金卡', '333');
INSERT INTO `members` VALUES ('9', 'sdd', '男', '2002-10-19', '金卡', '333');
INSERT INTO `members` VALUES ('10', 'sdd', '男', '2002-10-19', '金卡', '333');
INSERT INTO `members` VALUES ('11', 'sdd', '男', '2002-10-19', '金卡', '333');
INSERT INTO `members` VALUES ('12', 'sdd', '男', '2002-10-19', '金卡', '333');
INSERT INTO `members` VALUES ('13', 'sdd', '男', '2002-10-19', '金卡', '333');
INSERT INTO `members` VALUES ('14', 'sdd', '男', '2002-10-19', '金卡', '333');
