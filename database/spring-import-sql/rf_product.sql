/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.10.66
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 192.168.10.66:3306
 Source Schema         : rosefinch

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/10/2022 09:44:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rf_product
-- ----------------------------
DROP TABLE IF EXISTS `rf_product`;
CREATE TABLE `rf_product`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `category` int(2) NULL DEFAULT NULL COMMENT '分类：1-智慧生产、2-智慧客服、3-智慧管理、4-智慧管网、5-智慧营销',
  `type` bigint(20) NULL DEFAULT NULL COMMENT '类型 （应用ID）',
  `version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '版本号',
  `introduction` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `logo_file_id` bigint(20) NULL DEFAULT NULL COMMENT 'Logo文件ID',
  `auth_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权代码',
  `release_time` date NULL DEFAULT NULL COMMENT '发布时间',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator_id` bigint(20) NULL DEFAULT NULL COMMENT '更新者ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `flag` int(2) NULL DEFAULT NULL COMMENT '标志：0-已删除、1-未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rf_product
-- ----------------------------
INSERT INTO `rf_product` VALUES (1030413919962838016, 'S12营业系统', 2, 402, 'v.1.1.2', '公司产品', '公司产品', 112, NULL, '2020-10-08', NULL, '2022-10-14 09:37:03', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1030413920046724096, 'S15系统', 3, 405, 'v.1.1.2', '公司产品', '公司产品', 112, NULL, '2020-10-11', NULL, '2022-10-14 09:37:03', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1030485857116719104, 'S12营业系统', 2, 402, 'v.1.1.2', '公司产品', '公司产品', 1, NULL, '2020-10-08', NULL, '2022-10-14 14:22:54', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1030485857179633664, 'S15系统', 3, 405, 'v.1.1.2', '公司产品', '公司产品', 112, NULL, '2020-10-11', NULL, '2022-10-14 14:22:54', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1030486120946810880, 'S12营业系统', 2, 402, 'v.1.1.2', '公司产品', '公司产品', 1, NULL, '2020-10-08', NULL, '2022-10-14 14:23:57', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1030486121043279872, 'S15系统', 3, 405, 'v.1.1.2', '公司产品', '公司产品', 112, NULL, '2020-10-11', NULL, '2022-10-14 14:23:57', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1030486208439992320, 'S12营业系统', 2, 402, 'v.1.1.2', '公司产品', '公司产品', 1, NULL, '2020-10-08', NULL, '2022-10-14 14:24:18', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1030486208477741056, 'S15系统', 3, 405, 'v.1.1.2', '公司产品', '公司产品', 112, NULL, '2020-10-11', NULL, '2022-10-14 14:24:18', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1031500140457831424, 'S12营业系统', 2, 402, 'v.1.1.2', '公司产品', '公司产品', 1, NULL, '2020-10-08', NULL, '2022-10-17 09:33:18', NULL, NULL, 1);
INSERT INTO `rf_product` VALUES (1031500140554300416, 'S15系统', 3, 405, 'v.1.1.2', '公司产品', '公司产品', 112, NULL, '2020-10-11', NULL, '2022-10-17 09:33:18', NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
