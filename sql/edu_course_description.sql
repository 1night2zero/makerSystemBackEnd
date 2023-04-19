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
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程简介' ROW_FORMAT = Dynamic;

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
