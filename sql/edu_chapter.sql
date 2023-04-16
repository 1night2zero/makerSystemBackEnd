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

 Date: 16/04/2023 21:17:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_chapter
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节名称',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1', '14', '第一章：HTML', 0, '2019-01-01 12:27:40', '2019-01-01 12:55:30');
INSERT INTO `edu_chapter` VALUES ('1181729226915577857', '18', '第七章：I/O流', 70, '2019-10-09 08:32:58', '2019-10-09 08:33:20');
INSERT INTO `edu_chapter` VALUES ('1192252428399751169', '1192252213659774977', '第一章节', 0, '2019-11-07 09:28:25', '2019-11-07 09:28:25');
INSERT INTO `edu_chapter` VALUES ('15', '18', '第一章：Java入门', 0, '2019-01-01 12:27:40', '2019-10-09 09:13:19');
INSERT INTO `edu_chapter` VALUES ('1643969570760839170', '1643969412849520641', '测试3333', 1, '2023-04-06 21:31:04', '2023-04-06 21:49:53');
INSERT INTO `edu_chapter` VALUES ('1643970672151515137', '1643969412849520641', 'dialogChapterFormVisible=true', 10, '2023-04-06 21:35:26', '2023-04-06 21:35:26');
INSERT INTO `edu_chapter` VALUES ('1645070110085464066', '1645070077525082113', '测试1', 1, '2023-04-09 22:24:13', '2023-04-09 22:24:13');
INSERT INTO `edu_chapter` VALUES ('1646536718108610561', '1646536599887958017', '测试熔断器', 1, '2023-04-13 23:31:59', '2023-04-13 23:31:59');
INSERT INTO `edu_chapter` VALUES ('3', '14', '第二章：CSS', 0, '2019-01-01 12:55:35', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('32', '18', '第二章：控制台输入和输出', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('44', '18', '第三章：控制流', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('48', '18', '第四章：类的定义', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('63', '18', '第五章：数组', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('64', '18', '第六章：继承', 61, '2019-01-01 12:27:40', '2019-10-09 08:32:47');

SET FOREIGN_KEY_CHECKS = 1;
