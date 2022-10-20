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

 Date: 18/10/2022 09:44:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rf_service
-- ----------------------------
DROP TABLE IF EXISTS `rf_service`;
CREATE TABLE `rf_service`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `category` int(2) NULL DEFAULT NULL COMMENT '分类：1-数据库、2-中间件',
  `type` int(2) NULL DEFAULT NULL COMMENT '类型：1-Mysql、2-Oracle、3-SQL Server、4-CLickhouse、5-InfluxDB、6-PostgreSQL  、7-Redis、8-Kafak，\r\n            9-Nginx、10-Zookeeper、11-Minio、12-kkFileView（在线文件预览服务）、13-seata（分布式事务服务）、14-配置总线\r\n            ',
  `version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '版本号',
  `introduction` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `logo_file_id` bigint(20) NULL DEFAULT NULL COMMENT 'Logo文件ID',
  `auth_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权代码',
  `release_time` date NULL DEFAULT NULL COMMENT '发布时间',
  `image_id` bigint(20) NULL DEFAULT NULL COMMENT '镜像ID',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator_id` bigint(20) NULL DEFAULT NULL COMMENT '更新者ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `flag` int(2) NULL DEFAULT NULL COMMENT '标志：0-已删除、1-未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rf_service
-- ----------------------------
INSERT INTO `rf_service` VALUES (1, '1', 1, 1, '1', '1', '1', 1, '1', '2022-10-10', 1, 1, '2022-10-12 09:30:27', NULL, NULL, 1);
INSERT INTO `rf_service` VALUES (12, '12', 1, 1, '12', '12', '12', 12, '1', '2022-10-10', 1, 1, '2022-10-12 09:30:27', NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
