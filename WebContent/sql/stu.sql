/*
Navicat MySQL Data Transfer

Source Server         : one
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : stu

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-06-14 09:04:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `oldMoney` varchar(20) DEFAULT NULL,
  `Money` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goodnumber` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goodIntroduction` varchar(255) DEFAULT NULL,
  `sellnumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `images` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('100000002', '三星Galaxy S8 4G+智版（SM-G9508）4GB+64GB', '7000', '6888', '100000002', '【新年货】【春节礼盒版】三星 Galaxy S8（SM-G9500）4GB+64GB 谜夜黑 移动联通电信4G手机 双卡双待', '10', 'http://localhost:8080/ShoppingProject/goods/1.jpg');
INSERT INTO `goods` VALUES ('100000003', 'Apple   iPhone X (A1865)   64GB    深空灰色  标配', '10000', '9888', '100000003', 'Apple iPhone X (A1865) 64GB 深空灰色 移动联通电信4G手机', '8', 'http://localhost:8080/ShoppingProject/goods/2.jpg');
INSERT INTO `goods` VALUES ('100000004', '三星 Galaxy Note8（SM-N9500）6GB+128GB ', '7888', '7388', '100000004', '三星 Galaxy Note8（SM-N9500）6GB+128GB 芭比粉 移动联通电信4G手机 双卡双待', '3', 'http://localhost:8080/ShoppingProject/goods/3.jpg');
INSERT INTO `goods` VALUES ('100000008', '商品标题测试2', '1231231.0', '1213.0', '123123', 'ssdsadasdasdsaddas', '123123', 'http://localhost:8080/ShoppingProject/goods/4.jpg');

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_content
-- ----------------------------
INSERT INTO `tb_content` VALUES ('11', '1234', '哈哈哈');
INSERT INTO `tb_content` VALUES ('12', '2345', '呵呵呵');
INSERT INTO `tb_content` VALUES ('13', '啦啦啦', '流浪了');
INSERT INTO `tb_content` VALUES ('14', '张三', '呵呵哒');
INSERT INTO `tb_content` VALUES ('15', '新增品论', '新增评价内容');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '11111', '11111', '哈哈哈');
INSERT INTO `user` VALUES ('7', '1234', '1234', '1234');
INSERT INTO `user` VALUES ('4', '2222', '2222', '嘎嘎嘎');
INSERT INTO `user` VALUES ('1', 'dddd', 'dddd', '点点滴滴');
INSERT INTO `user` VALUES ('3', '额鹅鹅鹅', 'eeee ', '额鹅鹅鹅');
