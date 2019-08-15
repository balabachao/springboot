/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-08-15 15:10:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(255) DEFAULT NULL,
  `goodsname` varchar(255) DEFAULT NULL,
  `goodsnum` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '雪碧', '20');
INSERT INTO `goods` VALUES ('2', '可乐', '30');
INSERT INTO `goods` VALUES ('3', '七夕', '30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `realName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('15', '111', '111', '111');
INSERT INTO `user` VALUES ('16', '111', '111', '111');
INSERT INTO `user` VALUES ('17', 'admin', '0000', 'QQQ');
INSERT INTO `user` VALUES ('18', 'admin', '1111', '1111');
INSERT INTO `user` VALUES ('19', 'admin', '1111', '111');
INSERT INTO `user` VALUES ('20', '666', '666', '666');
