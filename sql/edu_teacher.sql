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

 Date: 16/04/2023 21:17:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int UNSIGNED NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师头像',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '讲师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1631203390606364673', 'string11upupqwe', 'string', 'string', 1, 'string', 2, 0, '2023-03-02 16:02:49', '2023-03-04 01:53:04');
INSERT INTO `edu_teacher` VALUES ('1631687701155602434', 'aaaa', 'qwe', 'qwe', 2, 'blob:http://localhost:9528/9c2c9d13-1ad9-4934-87d1-4d50aeb3ea7d', 0, 1, '2023-03-04 00:07:18', '2023-03-04 00:07:18');
INSERT INTO `edu_teacher` VALUES ('1631715331183558658', 'stringqwe1', 'stringqwe', 'stringqwe', 1, 'stringqwe111', 0, 0, '2023-03-04 01:57:05', '2023-03-04 01:57:05');
INSERT INTO `edu_teacher` VALUES ('1631716314584268801', 'qweqweqweqe', 'qweqwe', 'qweqwe', 1, '', 1, 0, '2023-03-04 02:01:00', '2023-03-04 02:01:00');
INSERT INTO `edu_teacher` VALUES ('1632315396432355330', 'qweasd', 'qweqweqwe', '1111', 2, '2023/03/05/8aa0bf70da6e4ea197b446ea75a74a72file.png', 1, 0, '2023-03-05 17:41:32', '2023-03-06 17:22:06');

SET FOREIGN_KEY_CHECKS = 1;
