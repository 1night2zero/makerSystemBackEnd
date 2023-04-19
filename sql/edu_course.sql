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

 Date: 16/04/2023 21:17:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程标题',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售数量',
  `view_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览数量',
  `version` bigint UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE,
  INDEX `idx_subject_id`(`subject_id`) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('1634915384354148354', 'string1', 'string1', NULL, 'string1', 0.00, 0, 'test', 0, 0, 1, 'Draft', 1, '2023-03-12 21:52:58', '2023-03-12 21:52:58');
INSERT INTO `edu_course` VALUES ('1635877252904271873', '1632315396432355330', '1633732132868235266', NULL, 'qwe', 1.00, 6, '2023/03/15/84db7803380242db81fcfee00ad7580cEZSeFDMWkAQ5wat.jpg', 0, 0, 1, 'Draft', 0, '2023-03-15 13:35:05', '2023-03-15 13:35:05');
INSERT INTO `edu_course` VALUES ('1642871991289569281', '1631203390606364673', '1633732132868235265', '1633732132805320707', '测试修改', 321.00, 321, '', 0, 0, 1, 'Draft', 0, '2023-04-03 20:49:40', '2023-04-03 20:49:52');
INSERT INTO `edu_course` VALUES ('1643967823124480001', '1631203390606364673', '1633732132805320706', '1633732132742406146', '12312312', 123.00, 11, '', 0, 0, 1, 'Draft', 0, '2023-04-06 21:24:07', '2023-04-06 21:24:07');
INSERT INTO `edu_course` VALUES ('1643969412849520641', '1631203390606364673', '1633732132868235265', '1633732132805320707', '测试2', 2.00, 22, '2023/04/08/b6ce27f58f4848658e830caf4db3d67eEMsPqASVAAA9tIS.jpg', 0, 0, 1, 'Normal', 0, '2023-04-06 21:30:26', '2023-04-12 23:06:17');
INSERT INTO `edu_course` VALUES ('1645070077525082113', '1632315396432355330', '1633732132868235266', '1633732132742406146', '111', 2.00, 2, '2023/04/09/ae28e44967d54b9280d1482161e39f85ERohgHSXYAAv72N.jpg', 0, 0, 1, 'Draft', 0, '2023-04-09 22:24:05', '2023-04-09 22:30:12');
INSERT INTO `edu_course` VALUES ('1646536599887958017', '1631203390606364673', '1633732132805320706', '1633732132742406146', '测试熔断器', 1.00, 123, '', 0, 0, 1, 'Draft', 0, '2023-04-13 23:31:31', '2023-04-13 23:31:31');
INSERT INTO `edu_course` VALUES ('18', '1631203390606364673', '1633732132994064387', '1633732133056978945', 'test', 11111.00, 11, '2023/04/08/b6ce27f58f4848658e830caf4db3d67eEMsPqASVAAA9tIS.jpg', 0, 0, 1, 'Draft', 0, '2023-04-09 15:53:11', '2023-04-09 15:53:14');

SET FOREIGN_KEY_CHECKS = 1;
