/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 16/04/2023 21:17:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_subject
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类别名称',
  `parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程科目' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('100', 'delet', '1633732132994064387', 0, '2023-04-09 15:31:49', '2023-04-09 15:31:56');
INSERT INTO `edu_subject` VALUES ('1633732132742406146', '前端开发', '0', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132805320706', 'javascript', '1633732132742406146', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132805320707', '后端开发', '0', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132868235265', 'springboot', '1633732132805320707', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132868235266', 'REACT', '1633732132742406146', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132931149826', 'VUE', '1633732132742406146', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132931149827', '数据库开发', '0', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132994064386', 'mysql', '1633732132931149827', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732132994064387', '测试', '0', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');
INSERT INTO `edu_subject` VALUES ('1633732133056978945', 'qwe', '0', 0, '2023-03-09 15:31:08', '2023-03-09 15:31:08');

SET FOREIGN_KEY_CHECKS = 1;
