/*
 Navicat Premium Data Transfer

 Source Server         : HomeWork
 Source Server Type    : MySQL
 Source Server Version : 80100 (8.1.0)
 Source Host           : localhost:3306
 Source Schema         : fruitdb

 Target Server Type    : MySQL
 Target Server Version : 80100 (8.1.0)
 File Encoding         : 65001

 Date: 04/11/2024 11:22:11
*/
DROP DATABASE IF EXISTS `fruitdb`;
CREATE DATABASE fruitdb;
USE fruitdb;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_fruit
-- ----------------------------
DROP TABLE IF EXISTS `t_fruit`;
CREATE TABLE `t_fruit`  (
  `fruitid` int NOT NULL AUTO_INCREMENT COMMENT '水果ID',
  `fruitname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '水果名称',
  `producer` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '产地',
  `price` decimal(10, 2) NOT NULL COMMENT '当前售价',
  `count` int NOT NULL COMMENT '库存数量',
  `imgs` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '水果图片',
  PRIMARY KEY (`fruitid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_fruit
-- ----------------------------
INSERT INTO `t_fruit` VALUES (1, '苹果', '中亚和西亚地区', 10.50, 395, '苹果.png');
INSERT INTO `t_fruit` VALUES (2, '香蕉', '东南亚和南亚地区', 5.78, 242, '香蕉.jpg');
INSERT INTO `t_fruit` VALUES (3, '草莓', '北美洲、欧洲和亚洲地区', 28.00, 406, '草莓.jpg');
INSERT INTO `t_fruit` VALUES (4, '葡萄', '中亚和西亚地区', 9.83, 196, '葡萄.jpg');
INSERT INTO `t_fruit` VALUES (5, '橙子', '东南亚和南亚地区', 6.06, 346, '橙子.jpg');
INSERT INTO `t_fruit` VALUES (6, '芒果 ', '印度和斯里兰卡地区', 11.10, 198, '芒果.jpg ');
INSERT INTO `t_fruit` VALUES (7, '西瓜 ', '非洲和西亚地区', 3.28, 246, '西瓜.jpg ');
INSERT INTO `t_fruit` VALUES (8, '菠萝', '中美洲和南美洲地区', 8.27, 415, '菠萝.jpg');
INSERT INTO `t_fruit` VALUES (9, '猕猴桃', '中国和东南亚地区', 12.39, 876, '猕猴桃.jpg');
INSERT INTO `t_fruit` VALUES (10, '柿子', '亚洲和美洲地区地区', 5.55, 332, '柿子.jpg');
INSERT INTO `t_fruit` VALUES (11, '梨子', '中亚和西亚地区', 4.62, 222, '梨子.jpg');
INSERT INTO `t_fruit` VALUES (12, '蓝莓', '北美、欧洲和亚洲地区', 45.50, 368, '蓝莓.jpg');
INSERT INTO `t_fruit` VALUES (13, '木瓜', '中美洲和南美洲地区', 6.54, 454, '木瓜.jpg');
INSERT INTO `t_fruit` VALUES (14, '水蜜桃', '中国和日本地区', 9.90, 658, '水蜜桃.jpg');
INSERT INTO `t_fruit` VALUES (15, '柠檬', '亚洲、欧洲和非洲地区', 3.65, 257, '柠檬.jpg');
INSERT INTO `t_fruit` VALUES (16, '柚子', '中国、东南亚和南亚地区', 6.15, 309, '柚子.jpg');
INSERT INTO `t_fruit` VALUES (17, '树莓', '西双版纳', 21.20, 600, '0e9ebf3da6994ea9badda414db83f3b8.jpg');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `userid` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户密码',
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名或昵称',
  `phone` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '联系电话',
  `rolecode` int NOT NULL COMMENT '用户类型码',
  `rolename` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户类型名',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('admin', 'admin', '水果店管理员001', '13888888888', 1, '商城管理员');
INSERT INTO `t_user` VALUES ('shanhe', '1234567', '山河', '13999999999', 2, '网站用户');

SET FOREIGN_KEY_CHECKS = 1;
