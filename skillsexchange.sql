/*
 Navicat MySQL Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : skillsexchange

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 26/04/2019 15:26:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  `student_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '哈哈哈', '2019-04-26 14:27:35', 1, '张三', '123456', 1);
INSERT INTO `message` VALUES (2, '嘎嘎嘎', '2019-04-26 14:47:33', 1, '张三', '123456', 1);
INSERT INTO `message` VALUES (3, '嘎嘎嘎嘎嘎过过过过', '2019-04-26 15:14:18', 4, '李四', '654321', 1);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, 'ttt', 'ttt通天塔', '2019-04-26 13:53:51');
INSERT INTO `news` VALUES (2, '热热热', '热热热热热热热热热', '2019-04-26 13:55:44');
INSERT INTO `news` VALUES (3, 'test', 'ggggggg', '2019-04-26 15:24:09');

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NULL DEFAULT NULL,
  `student_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ask_for` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES (3, 1, '123456', '张三', '全屋定制装修', '9549ae92417f4c1483e53cde157abb03.webp', 'gggggg', 'rrr', '2019-04-23 20:24:04', 1);
INSERT INTO `skill` VALUES (4, 1, '123456', '张三', '咕噜咕噜咕噜', '1d60003a04914e1997a6ea52d4f723f9.webp', '咕噜咕噜咕噜咕噜咕噜咕噜咕噜咕噜咕噜咕噜咕噜咕噜', '嘎嘎嘎', '2019-04-26 12:07:50', 1);
INSERT INTO `skill` VALUES (5, 4, '654321', '李四', '吃吃吃', '892615708dec4e2f887db49502e09f3b.webp', '吃吃吃吃吃吃吃吃吃', '嘎嘎嘎', '2019-04-26 15:02:13', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_uame` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '123456', '123456');
INSERT INTO `student` VALUES (3, '人刚刚', '20190322009', '123456');
INSERT INTO `student` VALUES (4, '李四', '654321', '654321');

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_student_id` int(11) NULL DEFAULT NULL,
  `from_student_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `from_student_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `from_skill_id` int(11) NULL DEFAULT NULL,
  `from_skill_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_student_id` int(11) NULL DEFAULT NULL,
  `to_student_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_student_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_skill_id` int(11) NULL DEFAULT NULL,
  `to_skill_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `state` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES (11, 1, '张三', '123456', 3, '全屋定制装修', 4, '李四', '654321', 5, '吃吃吃', '2019-04-26 15:02:45', 0);
INSERT INTO `trade` VALUES (12, 1, '张三', '123456', 4, '咕噜咕噜咕噜', 4, '李四', '654321', 5, '吃吃吃', '2019-04-26 15:13:09', 0);

SET FOREIGN_KEY_CHECKS = 1;
