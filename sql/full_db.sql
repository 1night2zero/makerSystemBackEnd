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

 Date: 16/04/2023 21:17:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crm_banner
-- ----------------------------
DROP TABLE IF EXISTS `crm_banner`;
CREATE TABLE `crm_banner`  (
  `id` char(19)  NOT NULL DEFAULT '' COMMENT 'ID',
  `title` varchar(20)  NULL DEFAULT '' COMMENT '标题',
  `image_url` varchar(500)  NOT NULL DEFAULT '' COMMENT '图片地址',
  `link_url` varchar(500)  NULL DEFAULT '' COMMENT '链接地址',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`title`) USING BTREE
) ENGINE = InnoDB  COMMENT = '首页banner表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of crm_banner
-- ----------------------------
INSERT INTO `crm_banner` VALUES ('1194556896025845762', 'test1', 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cms/2019/11/14/297acd3b-b592-4cfb-a446-a28310369675.jpg', '/course', 1, 0, '2019-11-13 18:05:32', '2019-11-18 10:28:22');
INSERT INTO `crm_banner` VALUES ('1194607458461216769', 'test2', 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cms/2019/11/13/8f80790d-d736-4842-a6a4-4dcb0d684d4e.jpg', '/teacher', 2, 0, '2019-11-13 21:26:27', '2019-11-14 09:12:15');

SET FOREIGN_KEY_CHECKS = 1;
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
  `id` char(19)  NOT NULL COMMENT '章节ID',
  `course_id` char(19)  NOT NULL COMMENT '课程ID',
  `title` varchar(50)  NOT NULL COMMENT '章节名称',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '课程' ROW_FORMAT = COMPACT;

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
  `id` char(19)  NOT NULL COMMENT '课程ID',
  `teacher_id` char(19)  NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19)  NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19)  NULL DEFAULT NULL COMMENT '课程专业父级ID',
  `title` varchar(50)  NOT NULL COMMENT '课程标题',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售数量',
  `view_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览数量',
  `version` bigint UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `status` varchar(10)  NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE,
  INDEX `idx_subject_id`(`subject_id`) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '课程' ROW_FORMAT = COMPACT;

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

 Date: 16/04/2023 21:17:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_course_description
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description`  (
  `id` char(19)  NOT NULL COMMENT '课程ID',
  `description` text  NULL COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '课程简介' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1635655686350290946', 'qwe', '2023-03-14 22:54:39', '2023-03-14 22:54:39');
INSERT INTO `edu_course_description` VALUES ('1635657697665859586', 'qwe', '2023-03-14 23:02:39', '2023-03-14 23:02:39');
INSERT INTO `edu_course_description` VALUES ('1635657864062287873', '123', '2023-03-14 23:03:19', '2023-03-14 23:03:19');
INSERT INTO `edu_course_description` VALUES ('1635657970513723394', 'qwe', '2023-03-14 23:03:44', '2023-03-14 23:03:44');
INSERT INTO `edu_course_description` VALUES ('1635658234964504578', 'qwe', '2023-03-14 23:04:47', '2023-03-14 23:04:47');
INSERT INTO `edu_course_description` VALUES ('1635877252904271873', 'test', '2023-03-15 13:35:05', '2023-03-15 13:35:05');
INSERT INTO `edu_course_description` VALUES ('1638191695453597698', '<p><strong>阿瓦撒旦发射点暗示发送</strong></p>', '2023-03-21 22:51:51', '2023-03-21 22:51:51');
INSERT INTO `edu_course_description` VALUES ('1638194352045948929', '<p><img class=\"wscnph\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHAAAAArCAYAAACgqQx/AAACcklEQVR4nO2cMWgTURiAP4MFqSlW6ChYqKEIHUqXOujkoJPQoa7qWh0cOre2Y8ngoF11tkPBSQcnHewiHQoSYqGCg0MGobEIlSL/8edI0rvkUNK+3/99a3LvHd+33N17d2e+19YoyCXgBnALOAdcA0aBo6ID/CWlAc9RZPzRf5zjR5/55fePwC/gLfAe+FZk4LMF/nMZeALcBYaLn3OkjYt9ZFxQz8I94AB4pd6/9jqw1Gfgh8AOcD/GO1GG1fmONsilV8AV4BlQ/r/cmKKsDVbyTjov4B1gybu9gFjSJsfICjgGVD1aCpyqtukgK+AiUPFuK0Aq2qaD7oAzwIJ3UwGzoI1SugM+Bka8WwqYEW2U0h7wCjDn3ZAB5rRVQnvAB/GWwQRlbZXQCngemPduxhDz2iwNeD1eeZqios3SgLe9GzFI0kwCDgE3vdswiDQbkoCTwFXvNgwizSYl4HTBZaVIWEizaQk4G8OYZVYCTni3YJgJCTju3YJhxktZSxQRM4wNesNQZLAclQrsi4mES0niNWIgszQk4J53C4bZk4C73i0YZlcCbnm3YJgtCbgN/PZuwiDSbFsC1oDP3m0YRJrVJOAh8M67DYNIs8PWPeAb7zYMkjRrBfwA1L0bMURdm6UBfwIb3q0YYkObdTxGewE0vZsxQFNbJbQH/AJserdjgE1tldD9IPspsO/dUMDsa6OU7oCfgHXvlgJmXRulZC0lVeMVaZDUs97bzArYyHoPLXLqLGYt/eUt5r4GVmOzYFjVJsfotRq/DDyKtxanSlMbLOedRL/tFM+BKeClfrskcjIcqPMpbZBL/FKT5S81AX8Au99ni1KgImMAAAAASUVORK5CYII=\" /></p>', '2023-03-21 23:02:24', '2023-03-21 23:02:24');
INSERT INTO `edu_course_description` VALUES ('1640326284930244610', '', '2023-03-27 20:13:57', '2023-03-27 20:13:57');
INSERT INTO `edu_course_description` VALUES ('1640326454585647105', '', '2023-03-27 20:14:37', '2023-03-27 20:14:37');
INSERT INTO `edu_course_description` VALUES ('1640327820913733633', '', '2023-03-27 20:20:03', '2023-03-27 20:20:03');
INSERT INTO `edu_course_description` VALUES ('1640344673555902466', '<p>11111test</p>', '2023-03-27 21:27:01', '2023-03-27 21:27:01');
INSERT INTO `edu_course_description` VALUES ('1640345178420080642', '<p>123123123</p>', '2023-03-27 21:29:01', '2023-03-27 21:29:01');
INSERT INTO `edu_course_description` VALUES ('1640347556082950145', '<p>twqerqe</p>', '2023-03-27 21:38:28', '2023-03-27 21:38:28');
INSERT INTO `edu_course_description` VALUES ('1640351718594052098', '<p>tweasfdadws</p>', '2023-03-27 21:55:01', '2023-03-27 21:55:01');
INSERT INTO `edu_course_description` VALUES ('1640351750013583361', '', '2023-03-27 21:55:08', '2023-03-27 21:55:08');
INSERT INTO `edu_course_description` VALUES ('1640360551034929154', '<p>teste</p>', '2023-03-27 22:30:06', '2023-03-27 22:30:06');
INSERT INTO `edu_course_description` VALUES ('1642868814708269057', '<p>qweqwe</p>', '2023-04-03 20:37:03', '2023-04-03 20:37:03');
INSERT INTO `edu_course_description` VALUES ('1642869514309787649', '<p>qweqwe</p>', '2023-04-03 20:39:50', '2023-04-03 20:39:50');
INSERT INTO `edu_course_description` VALUES ('1642871991289569281', '<p>321312</p>', '2023-04-03 20:49:40', '2023-04-03 20:49:52');
INSERT INTO `edu_course_description` VALUES ('1642874184256249857', '', '2023-04-03 20:58:23', '2023-04-03 21:01:53');
INSERT INTO `edu_course_description` VALUES ('1643967823124480001', '<p>111</p>', '2023-04-06 21:24:07', '2023-04-06 21:24:07');
INSERT INTO `edu_course_description` VALUES ('1643969412849520641', '<p>测试2测试2测试2测试2</p>', '2023-04-06 21:30:26', '2023-04-09 11:57:30');
INSERT INTO `edu_course_description` VALUES ('1645070077525082113', '<p>1111</p>', '2023-04-09 22:24:05', '2023-04-09 22:30:12');
INSERT INTO `edu_course_description` VALUES ('1646536599887958017', '<p>强强强强</p>', '2023-04-13 23:31:31', '2023-04-13 23:31:31');
INSERT INTO `edu_course_description` VALUES ('18', 'string1111', '2023-03-12 21:38:19', '2023-03-12 21:38:19');

SET FOREIGN_KEY_CHECKS = 1;
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
  `id` char(19)  NOT NULL COMMENT '课程类别ID',
  `title` varchar(10)  NOT NULL COMMENT '类别名称',
  `parent_id` char(19)  NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '课程科目' ROW_FORMAT = COMPACT;

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
  `id` char(19)  NOT NULL COMMENT '讲师ID',
  `name` varchar(20)  NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500)  NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500)  NULL DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int UNSIGNED NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255)  NULL DEFAULT NULL COMMENT '讲师头像',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB  COMMENT = '讲师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1631203390606364673', 'string11upupqwe', 'string', 'string', 1, 'string', 2, 0, '2023-03-02 16:02:49', '2023-03-04 01:53:04');
INSERT INTO `edu_teacher` VALUES ('1631687701155602434', 'aaaa', 'qwe', 'qwe', 2, 'blob:http://localhost:9528/9c2c9d13-1ad9-4934-87d1-4d50aeb3ea7d', 0, 1, '2023-03-04 00:07:18', '2023-03-04 00:07:18');
INSERT INTO `edu_teacher` VALUES ('1631715331183558658', 'stringqwe1', 'stringqwe', 'stringqwe', 1, 'stringqwe111', 0, 0, '2023-03-04 01:57:05', '2023-03-04 01:57:05');
INSERT INTO `edu_teacher` VALUES ('1631716314584268801', 'qweqweqweqe', 'qweqwe', 'qweqwe', 1, '', 1, 0, '2023-03-04 02:01:00', '2023-03-04 02:01:00');
INSERT INTO `edu_teacher` VALUES ('1632315396432355330', 'qweasd', 'qweqweqwe', '1111', 2, '2023/03/05/8aa0bf70da6e4ea197b446ea75a74a72file.png', 1, 0, '2023-03-05 17:41:32', '2023-03-06 17:22:06');

SET FOREIGN_KEY_CHECKS = 1;
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

 Date: 16/04/2023 21:17:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_video
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video`  (
  `id` char(19)  NOT NULL COMMENT '视频ID',
  `course_id` char(19)  NOT NULL COMMENT '课程ID',
  `chapter_id` char(19)  NOT NULL COMMENT '章节ID',
  `title` varchar(50)  NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100)  NULL DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100)  NULL DEFAULT NULL COMMENT '原始文件名称',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `play_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '播放次数',
  `is_free` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT 0 COMMENT '视频时长（秒）',
  `status` varchar(20)  NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '视频源文件大小（字节）',
  `version` bigint UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_chapter_id`(`chapter_id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '课程视频' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1182499307429339137', '18', '32', '第一节', '', '', 0, 0, 0, 0, '', 0, 1, '2019-10-11 11:32:59', '2019-10-11 11:57:38');
INSERT INTO `edu_video` VALUES ('1185312444399071234', '14', '1', '12', '', '', 0, 0, 0, 0, 'Empty', 0, 1, '2019-10-19 05:51:23', '2019-10-19 05:51:33');
INSERT INTO `edu_video` VALUES ('1189434737808990210', '18', '44', '测试', '', '', 1, 0, 0, 0, 'Empty', 0, 1, '2019-10-30 14:51:55', '2019-10-30 14:51:55');
INSERT INTO `edu_video` VALUES ('1189471423678939138', '18', '1181729226915577857', 'test', '2b887dc9584d4dc68908780ec57cd3b9', '视频', 1, 0, 0, 0, 'Empty', 0, 1, '2019-10-30 17:17:41', '2019-10-30 17:17:41');
INSERT INTO `edu_video` VALUES ('1189476403626409986', '18', '1181729226915577857', '22', '5155c73dc112475cbbddccf4723f7cef', '视频.mp4', 0, 0, 0, 0, 'Empty', 0, 1, '2019-10-30 17:37:29', '2019-10-30 17:37:29');
INSERT INTO `edu_video` VALUES ('1192252824606289921', '1192252213659774977', '1192252428399751169', '第一课时', '756cf06db9cb4f30be85a9758b19c645', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 0, 0, 'Empty', 0, 1, '2019-11-07 09:29:59', '2019-11-07 09:29:59');
INSERT INTO `edu_video` VALUES ('1192628092797730818', '1192252213659774977', '1192252428399751169', '第二课时', '2a02d726622f4c7089d44cb993c531e1', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 1, 0, 'Empty', 0, 1, '2019-11-08 10:21:10', '2019-11-08 10:21:22');
INSERT INTO `edu_video` VALUES ('1192632495013380097', '1192252213659774977', '1192252428399751169', '第三课时', '4e560c892fdf4fa2b42e0671aa42fa9d', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 1, 0, 'Empty', 0, 1, '2019-11-08 10:38:40', '2019-11-08 10:38:40');
INSERT INTO `edu_video` VALUES ('1194117638832111617', '1192252213659774977', '1192252428399751169', '第四课时', '4e560c892fdf4fa2b42e0671aa42fa9d', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 0, 0, 'Empty', 0, 1, '2019-11-12 13:00:05', '2019-11-12 13:00:05');
INSERT INTO `edu_video` VALUES ('1196263770832023554', '1192252213659774977', '1192252428399751169', '第五课时', '27d21158b0834cb5a8d50710937de330', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 5, 0, 0, 0, 'Empty', 0, 1, '2019-11-18 11:08:03', '2019-11-18 11:08:03');
INSERT INTO `edu_video` VALUES ('1643987440848900098', '1643969412849520641', '1643970672151515137', '第二节', '8c3933b0d7a871edb5a16733a78e0102', 'sn.mp4', 1, 0, 0, 0, 'Empty', 0, 1, '2023-04-06 22:42:04', '2023-04-10 22:04:43');
INSERT INTO `edu_video` VALUES ('1645072169115435009', '1645070077525082113', '1645070110085464066', 'test', NULL, NULL, 1, 0, 1, 0, 'Empty', 0, 1, '2023-04-09 22:32:24', '2023-04-09 22:32:24');
INSERT INTO `edu_video` VALUES ('1645445185318010882', '1643969412849520641', '1643970672151515137', 'qwe', '', '', 1, 0, 1, 0, 'Empty', 0, 1, '2023-04-10 23:14:38', '2023-04-10 23:15:20');
INSERT INTO `edu_video` VALUES ('1646537507573071873', '1646536599887958017', '1646536718108610561', '123', 'c314de10da1071ed80026732b68e0102', '6 - What If I Want to Move Faster.mp4', 1, 0, 1, 0, 'Empty', 0, 1, '2023-04-13 23:35:08', '2023-04-13 23:35:08');
INSERT INTO `edu_video` VALUES ('17', '18', '15', '第一节：Java简介', '196116a6fee742e1ba9f6c18f65bd8c1', '1', 1, 1000, 1, 100, 'Draft', 0, 1, '2019-01-01 13:08:57', '2019-10-11 11:26:39');
INSERT INTO `edu_video` VALUES ('18', '18', '15', '第二节：表达式和赋值语句', '2d99b08ca0214909899910c9ba042d47', '7 - How Do I Find Time for My ', 2, 999, 1, 100, 'Draft', 0, 1, '2019-01-01 13:09:02', '2019-03-08 03:30:27');
INSERT INTO `edu_video` VALUES ('19', '18', '15', '第三节：String类', '51120d59ddfd424cb5ab08b44fc8b23a', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 3, 888, 0, 100, 'Draft', 0, 1, '2019-01-01 13:09:05', '2019-11-12 12:50:45');
INSERT INTO `edu_video` VALUES ('20', '18', '15', '第四节：程序风格', '2a38988892d84df598752226c50f3fa3', '00-day10总结.avi', 4, 666, 0, 100, 'Draft', 0, 1, '2019-01-01 13:09:05', '2019-10-11 09:20:09');

SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE `ucenter_member` (
                                  `id` char(19) NOT NULL COMMENT '用户id',
                                  `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
                                  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
                                  `password` varchar(255) DEFAULT NULL COMMENT '密码',
                                  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
                                  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别 1 女，2 男',
                                  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
                                  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
                                  `sign` varchar(100) DEFAULT NULL COMMENT '用户签名',
                                  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
                                  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
                                  `gmt_create` datetime NOT NULL COMMENT '创建时间',
                                  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';