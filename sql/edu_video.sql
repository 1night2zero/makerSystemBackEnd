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
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '原始文件名称',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `play_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '播放次数',
  `is_free` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT 0 COMMENT '视频时长（秒）',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '视频源文件大小（字节）',
  `version` bigint UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_chapter_id`(`chapter_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程视频' ROW_FORMAT = COMPACT;

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
