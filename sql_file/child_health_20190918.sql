/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : child_health

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 18/09/2019 12:02:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for allergies_and_intolerances
-- ----------------------------
DROP TABLE IF EXISTS `allergies_and_intolerances`;
CREATE TABLE `allergies_and_intolerances`  (
  `guardian_phone` bigint(20) NOT NULL,
  `inspect_order` int(11) NOT NULL,
  `barley` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `egg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `egg_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lactobiose` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mast` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `milk` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `peanut` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prawn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `soya` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wheat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of allergies_and_intolerances
-- ----------------------------
INSERT INTO `allergies_and_intolerances` VALUES (13657842222, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `allergies_and_intolerances` VALUES (13657842222, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `allergies_and_intolerances` VALUES (17888776677, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `allergies_and_intolerances` VALUES (17888776677, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `allergies_and_intolerances` VALUES (17888776677, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for body_composition_test
-- ----------------------------
DROP TABLE IF EXISTS `body_composition_test`;
CREATE TABLE `body_composition_test`  (
  `guardian_phone` bigint(20) NOT NULL,
  `body_fat_percent` double NULL DEFAULT NULL,
  `check_date` datetime(0) NULL DEFAULT NULL,
  `extracellular_fluid` double NULL DEFAULT NULL,
  `fat` double NULL DEFAULT NULL,
  `fatfree_body_weight` double NULL DEFAULT NULL,
  `height` double NULL DEFAULT NULL,
  `intracellular_fluid` double NULL DEFAULT NULL,
  `metabolic_rate` double NULL DEFAULT NULL,
  `muscle` double NULL DEFAULT NULL,
  `protein` double NULL DEFAULT NULL,
  `sclerotin` double NULL DEFAULT NULL,
  `skeletal_muscle` double NULL DEFAULT NULL,
  `visceral_fat` double NULL DEFAULT NULL,
  `waist_to_hipratio` double NULL DEFAULT NULL,
  `weight` double NULL DEFAULT NULL,
  `weight_indexbmi` double NULL DEFAULT NULL,
  `inspect_order` int(11) NOT NULL,
  `score` double NULL DEFAULT NULL,
  `total_water` double NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of body_composition_test
-- ----------------------------
INSERT INTO `body_composition_test` VALUES (13657842222, 23.9, NULL, NULL, 12.6, 40.1, 160, NULL, 1236.2, NULL, 7.9, NULL, NULL, NULL, NULL, 52.7, NULL, 1, NULL, NULL);
INSERT INTO `body_composition_test` VALUES (17511111111, 1, NULL, 12.8, 1.6, 51.5, 181, 24.3, 1588, 48.4, 11.3, 3.1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `body_composition_test` VALUES (17610256822, 29.4, NULL, NULL, 15.5, 37.2, 155, NULL, 1173.5, 34.5, 7.3, 2.66, 20, 29.3, 0.78, 52.7, 21.9, 1, 70.5, NULL);
INSERT INTO `body_composition_test` VALUES (17888776677, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL);
INSERT INTO `body_composition_test` VALUES (17888776688, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `body_composition_test` VALUES (17888776688, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL);
INSERT INTO `body_composition_test` VALUES (17888776688, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL);

-- ----------------------------
-- Table structure for dietary_guide
-- ----------------------------
DROP TABLE IF EXISTS `dietary_guide`;
CREATE TABLE `dietary_guide`  (
  `kcal` bigint(20) NOT NULL,
  `aquatic_productf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水产份数',
  `aquatic_productg` double NULL DEFAULT NULL,
  `beanf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '豆份数',
  `beang` double NULL DEFAULT NULL,
  `eggf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '蛋份数',
  `eggg` double NULL DEFAULT NULL,
  `fruitsf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水果份数',
  `fruitsg` double NULL DEFAULT NULL,
  `livestockf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '禽畜份数',
  `livestockg` double NULL DEFAULT NULL,
  `milkf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奶份数',
  `milkg` double NULL DEFAULT NULL,
  `nutf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坚果份数',
  `nutg` double NULL DEFAULT NULL,
  `oilf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '油份数',
  `oilg` double NULL DEFAULT NULL,
  `practicalf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际份数',
  `staple_foodf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主食份数',
  `staple_foodg` double NULL DEFAULT NULL,
  `vegetablesf` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '蔬菜份数',
  `vegetablesg` double NULL DEFAULT NULL,
  PRIMARY KEY (`kcal`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dietary_guide
-- ----------------------------
INSERT INTO `dietary_guide` VALUES (1000, '0.4', 20, '0.4', 10, '0.5', 25, '0.8', 160, '0.4', 20, '1', 160, '0.5', 7.5, '1.5', 15, '11', '5', 125, '0.5', 250);
INSERT INTO `dietary_guide` VALUES (1100, '0.5', 25, '0.5', 12.5, '0.5', 25, '1', 200, '0.5', 25, '1.5', 240, '0.5', 7.5, '1.5', 15, '12.5', '5.5', 137.5, '0.5', 250);
INSERT INTO `dietary_guide` VALUES (1200, '0.5', 25, '0.5', 12.5, '0.5', 25, '1', 200, '0.5', 25, '1.5', 240, '0.5', 7.5, '1.5', 15, '13.5', '6.5', 162.5, '0.5', 250);
INSERT INTO `dietary_guide` VALUES (1300, '0.6', 30, '0.5', 12.5, '0.5', 25, '1', 200, '0.7', 35, '1.5', 240, '0.5', 7.5, '1.5', 15, '14.5', '7', 175, '0.7', 350);
INSERT INTO `dietary_guide` VALUES (1400, '0.6', 30, '0.5', 12.5, '0.5', 25, '1', 200, '0.7', 35, '1.5', 240, '0.5', 7.5, '2', 20, '15.5', '7.5', 187.5, '0.7', 350);
INSERT INTO `dietary_guide` VALUES (1500, '0.8', 40, '0.5', 12.5, '0.5', 25, '1', 200, '1', 50, '1.5', 240, '0.5', 7.5, '2', 20, '17', '8.5', 212.5, '0.7', 350);
INSERT INTO `dietary_guide` VALUES (1600, '0.8', 40, '0.5', 12.5, '1', 50, '1', 200, '1', 50, '2', 320, '0.5', 7.5, '2', 20, '18', '8.5', 212.5, '0.7', 350);
INSERT INTO `dietary_guide` VALUES (1700, '0.8', 40, '0.5', 12.5, '1', 50, '1', 200, '1', 50, '2', 320, '1', 15, '2', 20, '19', '9', 225, '0.7', 350);
INSERT INTO `dietary_guide` VALUES (1800, '1', 50, '0.5', 12.5, '1', 50, '1', 200, '1', 50, '2', 320, '1', 15, '2', 20, '20', '9.5', 237.5, '1', 500);
INSERT INTO `dietary_guide` VALUES (1900, '1', 50, '0.5', 12.5, '1', 50, '1', 200, '1', 50, '2', 320, '1', 15, '2', 20, '21', '10.5', 262.5, '1', 500);
INSERT INTO `dietary_guide` VALUES (2000, '1', 50, '0.5', 12.5, '1', 50, '1', 200, '1', 50, '2', 320, '1', 15, '2', 20, '22', '11.5', 287.5, '1', 500);
INSERT INTO `dietary_guide` VALUES (2100, '1.5', 75, '0.5', 12.5, '1', 50, '1.5', 300, '1', 50, '2', 320, '1', 15, '2', 20, '23.5', '12', 300, '1', 500);
INSERT INTO `dietary_guide` VALUES (2200, '1.5', 75, '0.5', 12.5, '1', 50, '1.5', 300, '1.5', 75, '2', 320, '1', 15, '2', 20, '24.5', '12.5', 312.5, '1', 500);
INSERT INTO `dietary_guide` VALUES (2300, '1.5', 75, '1', 25, '1', 50, '1.5', 300, '1.5', 75, '2', 320, '1', 15, '2', 20, '25.5', '13', 325, '1', 500);
INSERT INTO `dietary_guide` VALUES (2400, '1.5', 75, '1', 25, '1', 50, '1.5', 300, '1.5', 75, '2', 320, '1', 15, '2.5', 25, '26.5', '13.5', 337.5, '1', 500);
INSERT INTO `dietary_guide` VALUES (2500, '2', 100, '1', 25, '1', 50, '2', 400, '1.5', 75, '2', 320, '1', 15, '2.5', 25, '28', '14', 350, '1', 500);
INSERT INTO `dietary_guide` VALUES (2600, '2', 100, '1', 25, '1', 50, '2', 400, '1.5', 75, '2', 320, '1', 15, '2.5', 25, '29', '14.5', 362.5, '1.5', 750);
INSERT INTO `dietary_guide` VALUES (2700, '2', 100, '1', 25, '1', 50, '2', 400, '1.5', 75, '2.5', 400, '1', 15, '2.5', 25, '30', '15', 375, '1.5', 750);
INSERT INTO `dietary_guide` VALUES (2800, '2', 100, '1', 25, '1', 50, '2', 400, '1.5', 75, '2.5', 400, '1', 15, '2.5', 25, '31', '16', 400, '1.5', 750);
INSERT INTO `dietary_guide` VALUES (2900, '2', 100, '1', 25, '1', 50, '2.5', 500, '2', 100, '2.5', 400, '1', 15, '2.5', 25, '32', '16', 400, '1.5', 750);
INSERT INTO `dietary_guide` VALUES (3000, '2', 100, '1.5', 37.5, '1', 50, '2.5', 500, '2', 100, '2.5', 400, '1', 15, '2.5', 25, '33', '16.5', 412.5, '1.5', 750);
INSERT INTO `dietary_guide` VALUES (3100, '2.5', 125, '1.5', 37.5, '1', 50, '2.5', 500, '2', 100, '2.5', 400, '1', 15, '2.5', 25, '34.5', '17', 425, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3200, '2.5', 125, '1.5', 37.5, '1', 50, '2.5', 500, '2', 100, '2.5', 400, '1', 15, '2.5', 25, '35.5', '18', 450, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3300, '2.5', 125, '1.5', 37.5, '1', 50, '2.5', 500, '2', 100, '3', 480, '1', 15, '2.5', 25, '36.5', '18.5', 462.5, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3400, '2.5', 125, '1.5', 37.5, '1.5', 75, '2.5', 500, '2', 100, '3', 480, '1', 15, '2.5', 25, '37.5', '19', 475, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3500, '2.5', 125, '1.5', 37.5, '1.5', 75, '2.5', 500, '2.5', 125, '3', 480, '1.5', 22.5, '2.5', 25, '39', '19.5', 487.5, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3600, '3', 150, '1.5', 37.5, '1.5', 75, '2.5', 500, '2.5', 125, '3', 480, '1.5', 22.5, '2.5', 25, '40', '20', 500, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3700, '3', 150, '1.5', 37.5, '1.5', 75, '2.5', 500, '2.5', 125, '3', 480, '1.5', 22.5, '2.5', 25, '41', '21', 525, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3800, '3', 150, '2', 50, '1.5', 75, '2.5', 500, '2.5', 125, '3', 480, '1.5', 22.5, '3', 30, '42.5', '21.5', 537.5, '2', 1000);
INSERT INTO `dietary_guide` VALUES (3900, '3', 150, '2', 50, '1.5', 75, '2.5', 500, '3', 150, '3', 480, '1.5', 22.5, '3', 30, '43.5', '22', 550, '2', 1000);
INSERT INTO `dietary_guide` VALUES (4000, '3.5', 175, '2', 50, '1.5', 75, '2.5', 500, '3', 150, '3', 480, '1.5', 22.5, '3', 30, '44.5', '22.5', 562.5, '2', 1000);

-- ----------------------------
-- Table structure for dietary_survey
-- ----------------------------
DROP TABLE IF EXISTS `dietary_survey`;
CREATE TABLE `dietary_survey`  (
  `guardian_phone` bigint(20) NOT NULL,
  `inspect_order` int(11) NOT NULL,
  `ate_and_played` bit(1) NULL DEFAULT NULL,
  `egg` int(11) NULL DEFAULT NULL,
  `fruits` int(11) NULL DEFAULT NULL,
  `irregular_diet` bit(1) NULL DEFAULT NULL,
  `marine_products` int(11) NULL DEFAULT NULL,
  `milk` int(11) NULL DEFAULT NULL,
  `nut` int(11) NULL DEFAULT NULL,
  `poultry_meat` int(11) NULL DEFAULT NULL,
  `prefersfry` bit(1) NULL DEFAULT NULL,
  `prefers_sodas` bit(1) NULL DEFAULT NULL,
  `prefers_sweet` bit(1) NULL DEFAULT NULL,
  `staple_food` int(11) NULL DEFAULT NULL,
  `vegetables` int(11) NULL DEFAULT NULL,
  `without_breakfast` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dietary_survey
-- ----------------------------
INSERT INTO `dietary_survey` VALUES (17511111111, 1, b'1', 1, 1, b'1', 1, 1, 1, 1, b'1', b'1', b'1', 1, 1, b'1');

-- ----------------------------
-- Table structure for file_path
-- ----------------------------
DROP TABLE IF EXISTS `file_path`;
CREATE TABLE `file_path`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital`  (
  `hospital_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hospital_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hospotial_phone` bigint(20) NULL DEFAULT NULL,
  `office_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`hospital_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('ac675e4ecbee4221b9fd2aa445d77798', '请输入联系人', '请输入邮箱', '请输入医院名', 1111111, '请输入部门名称');
INSERT INTO `hospital` VALUES ('c89b73f67fb4412fbfa7baf4cf2008df', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `guardian_phone` bigint(20) NOT NULL,
  `inspect_order` int(255) NOT NULL,
  `birth` datetime(0) NULL DEFAULT NULL,
  `blood` int(11) NULL DEFAULT NULL,
  `educational_of_parents` int(11) NULL DEFAULT NULL,
  `guardian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `height` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nation` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `adding_food` int(255) NULL DEFAULT NULL,
  `weight` double NULL DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (13657842222, 1, '2008-07-04 16:00:00', NULL, NULL, '', 158, 'test2', NULL, '', 1, '2019-07-02 17:28:05', '2019-08-27 16:28:04', NULL, 40, NULL);
INSERT INTO `information` VALUES (13657842222, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-08-29 11:28:19', '2019-08-29 11:28:19', NULL, NULL, NULL);
INSERT INTO `information` VALUES (13657842222, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-08-29 13:58:59', '2019-08-29 13:58:59', NULL, NULL, NULL);
INSERT INTO `information` VALUES (13657842222, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-09-04 14:48:40', '2019-09-04 14:48:40', NULL, NULL, NULL);
INSERT INTO `information` VALUES (17511111111, 1, '2019-04-05 16:00:00', NULL, NULL, '', 72, 'test1', NULL, '', 1, '2018-12-02 17:24:40', '2019-09-15 20:03:25', NULL, 9, NULL);
INSERT INTO `information` VALUES (17511111111, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-09-12 19:49:16', '2019-09-12 19:49:16', NULL, NULL, NULL);
INSERT INTO `information` VALUES (17610256822, 1, '2005-04-05 16:00:00', NULL, NULL, '', 155, 'test', NULL, '', 0, '2019-07-02 17:20:43', '2019-08-27 16:28:11', NULL, 40, NULL);
INSERT INTO `information` VALUES (17888776666, 1, NULL, NULL, NULL, NULL, NULL, 'testorder', NULL, NULL, NULL, '2019-08-28 10:50:24', '2019-08-28 10:50:24', NULL, NULL, NULL);
INSERT INTO `information` VALUES (17888776677, 1, NULL, NULL, NULL, NULL, NULL, 'testorder修改23333333', NULL, NULL, NULL, '2019-08-28 10:51:37', '2019-08-29 12:34:29', NULL, NULL, NULL);
INSERT INTO `information` VALUES (17888776677, 2, NULL, NULL, NULL, NULL, NULL, 'testorder', NULL, NULL, NULL, '2019-08-28 14:46:34', '2019-08-28 14:46:34', NULL, NULL, NULL);
INSERT INTO `information` VALUES (17888776677, 3, NULL, NULL, NULL, NULL, NULL, 'testorder修改2333333333', NULL, NULL, NULL, '2019-08-29 12:34:04', '2019-08-29 14:21:36', NULL, NULL, NULL);
INSERT INTO `information` VALUES (17888776677, 4, NULL, NULL, NULL, NULL, NULL, 'testorder', NULL, NULL, NULL, '2019-09-02 15:39:34', '2019-09-02 15:39:34', NULL, NULL, NULL);
INSERT INTO `information` VALUES (17888776677, 5, NULL, NULL, NULL, NULL, NULL, 'testorder', NULL, NULL, NULL, '2019-09-02 15:56:12', '2019-09-02 15:56:12', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for laboratory_detection
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_detection`;
CREATE TABLE `laboratory_detection`  (
  `guardian_phone` bigint(20) NOT NULL,
  `fbg` double NULL DEFAULT NULL,
  `glycated_hemoglobin` double NULL DEFAULT NULL,
  `rbg` double NULL DEFAULT NULL,
  `serum_zinc` double NULL DEFAULT NULL,
  `binding_protein` double NULL DEFAULT NULL,
  `blood_fat` double NULL DEFAULT NULL,
  `fattyiverl` double NULL DEFAULT NULL,
  `flavol` double NULL DEFAULT NULL,
  `glucose_tolerance` double NULL DEFAULT NULL,
  `oxyphorase` double NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `serum25` double NULL DEFAULT NULL,
  `inspect_order` int(11) NOT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of laboratory_detection
-- ----------------------------
INSERT INTO `laboratory_detection` VALUES (13657842222, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://192.168.0.1:8082/2.gif', NULL, 1);
INSERT INTO `laboratory_detection` VALUES (13657842222, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `laboratory_detection` VALUES (13657843333, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://192.168.0.1:8082/eat_sleep_code.png', NULL, 1);
INSERT INTO `laboratory_detection` VALUES (13657843333, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://192.168.0.1:8082/2.gif', NULL, 5);
INSERT INTO `laboratory_detection` VALUES (13657843333, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://192.168.0.1:8082/2.gif', NULL, 6);
INSERT INTO `laboratory_detection` VALUES (13657843333, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://192.168.0.1:8082/2.gif', NULL, 7);

-- ----------------------------
-- Table structure for meal_times
-- ----------------------------
DROP TABLE IF EXISTS `meal_times`;
CREATE TABLE `meal_times`  (
  `kcal` bigint(255) NOT NULL,
  `breakfast_cereal_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_breakfast_cereals` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `breakfast_vegetables_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_breakfast_vegetables` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `breakfast_fruits_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_breakfast_fruits` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `breakfast_eggs_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_breakfast_eggs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `breakfast_milk_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_breakfast_milk` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `snacks_fruits_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_snacks_fruits` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lunch_cereal_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_lunch_cereals` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lunch_vegetables_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_lunch_vegetables` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lunch_meat_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_lunch_meat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lunch_oil_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_lunch_oil` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `snacks_milk_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_snacks_milk` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `snacks_nut_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_snacks_nut` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dinner_cereal_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_dinner_cereals` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dinner_vegetables_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_dinner_vegetables` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dinner_fisheries_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_dinner_fisheries` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dinner_soybean_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_dinner_soybean` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dinner_oil_quantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examples_of_dinner_oil` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`kcal`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meal_times
-- ----------------------------
INSERT INTO `meal_times` VALUES (1000, '20', '半个普通大小的馒头；一片较小的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '20.0', '半个体积较小的鸡蛋', '250.0', '两杯左右带包装酸奶或牛奶', '100.0', '一个去核小苹果；一根普通大小的香蕉；5-7颗草莓；5-6颗樱桃番茄', '40.0', '半碗米饭', '100.0', '三分之二碗的绿叶菜', '15.0', '超市买到的鸡胸肉的八分之一大小即可', '15.0', '一+二分之一汤勺', '250.0', '两杯半左右酸奶或牛奶', '5.0', '4-5粒去壳杏仁；1个核桃仁；10粒左右花生仁；3-4粒松子仁；2粒腰果', '25.0', '四分之一碗米饭或半个普通大小的馒头', '50.0', '三分之一碗的绿叶菜', '15.0', '从指根到腕关节部分手掌大小的带鱼段的四分之一大小即可', '5.0', '对应豆浆100毫升左右，大概7汤勺的量；或豆腐脑2汤勺左右', '5.0', '二分之一汤勺');
INSERT INTO `meal_times` VALUES (1100, '20', '半个普通大小馒头；一片较小的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '20.0', '半个体积较小的鸡蛋', '250.0', '两杯左右带包装酸奶或牛奶', '100.0', '一个去核小苹果；一根普通大小的香蕉；5-7颗草莓；5-6颗樱桃番茄', '45.0', '半碗米饭', '120.0', '6颗手中指长度的小油菜或4片大白菜', '20.0', '超市买到的鸡胸肉的六分之一大小即可', '15.0', '一+二分之一汤勺', '250.0', '两杯半左右酸奶或牛奶', '5.0', '4-5粒去壳杏仁；1个核桃仁；10粒左右花生仁；3-4粒松子仁；2粒腰果', '25.0', '四分之一碗米饭或半个普通大小的馒头', '60.0', '三分之一碗的绿叶菜', '15.0', '从指根到腕关节部分手掌大小的带鱼段的四分之一大小即可', '10.0', '对应豆浆200毫升左右，一小瓶或一袋鲜豆浆的量；或豆腐脑4汤勺左右', '5.0', '二分之一汤勺');
INSERT INTO `meal_times` VALUES (1200, '20', '半个普通大小馒头；一片较小的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '25.0', '半个鸡蛋', '250.0', '两杯左右带包装酸奶或牛奶', '100.0', '一个去核小苹果；一根普通大小的香蕉；5-7颗草莓；5-6颗樱桃番茄', '50.0', '三分之二碗米饭', '130.0', '6颗手中指长度的小油菜或4片大白菜', '25.0', '超市买到的鸡胸肉的五分之一大小即可', '15.0', '一+二分之一汤勺', '250.0', '两杯半左右酸奶或牛奶', '5.0', '4-5粒去壳杏仁；1个核桃仁；10粒左右花生仁；3-4粒松子仁；2粒腰果', '30.0', '三分之一碗米饭或半个较大的馒头', '70.0', '半碗绿叶菜', '20.0', '从指根到腕关节部分手掌大小的带鱼段的三分之一大小即可；两只基围虾；两个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '5.0', '二分之一汤勺');
INSERT INTO `meal_times` VALUES (1300, '30', '半个较大的馒头；一片较大的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '25.0', '半个鸡蛋', '250.0', '两杯左右带包装酸奶或牛奶', '100.0', '一个去核小苹果；一根普通大小的香蕉；5-7颗草莓；5-6颗樱桃番茄', '60.0', '三分之二碗米饭', '150.0', '一碗绿叶菜', '30.0', '超市买到的鸡胸肉的四分之一大小即可', '15.0', '一+二分之一汤勺', '250.0', '两杯半左右酸奶或牛奶', '5.0', '4-5粒去壳杏仁；1个核桃仁；10粒左右花生仁；3-4粒松子仁；2粒腰果', '35.0', '三分之一碗米饭或半个较大的馒头', '80.0', '半碗绿叶菜', '30.0', '从指根到腕关节部分手掌大小的带鱼段的二分之一大小即可；两只河虾；三只基围虾；三个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '5.0', '二分之一汤勺');
INSERT INTO `meal_times` VALUES (1400, '30', '半个较大的馒头；一片较大的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '25.0', '半个鸡蛋', '250.0', '两杯左右带包装酸奶或牛奶', '100.0', '一个去核小苹果；一根普通大小的香蕉；5-7颗草莓；5-6颗樱桃番茄', '70.0', '四分之三碗米饭', '150.0', '一碗绿叶菜', '40.0', '超市买到的鸡胸肉的三分之一大小即可', '15.0', '一+二分之一汤勺', '100.0', '一杯左右酸奶或牛奶', '5.0', '4-5粒去壳杏仁；1个核桃仁；10粒左右花生仁；3-4粒松子仁；2粒腰果', '50.0', '三分之二碗米饭或一个普通大小的馒头', '100.0', '三分之二碗的绿叶菜', '40.0', '从指根到腕关节部分手掌大小的带鱼段的三分之二大小即可；三只河虾；四只基围虾；四个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '5.0', '二分之一汤勺');
INSERT INTO `meal_times` VALUES (1500, '35', '半个较大的馒头；一片较大的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '30.0', '半个体积较大的鸡蛋', '250.0', '两杯左右带包装酸奶或牛奶', '130.0', '半个去核的小苹果和半个普通大小的苹果；7-9颗草莓；7颗樱桃番茄；一根大香蕉', '80.0', '四分之三碗米饭', '150.0', '一碗绿叶菜', '40.0', '超市买到的鸡胸肉的三分之一大小即可', '15.0', '一+二分之一汤勺', '100.0', '一杯左右酸奶或牛奶', '5.0', '4-5粒去壳杏仁；1个核桃仁；10粒左右花生仁；3-4粒松子仁；2粒腰果', '60.0', '三分之二碗的米饭或一个较大的馒头', '100.0', '三分之二碗的绿叶菜', '40.0', '从指根到腕关节部分手掌大小的带鱼段的三分之二大小即可；三只河虾；四只基围虾；四个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '5.0', '二分之一汤勺');
INSERT INTO `meal_times` VALUES (1600, '50', '一个普通大小的馒头；两片普通大小的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '40.0', '半个体积较大的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '150.0', '一个普通大小的去核苹果；一根普通大小的香蕉和一根小香蕉；8-11颗草莓；9颗樱桃番茄', '90.0', '一碗米饭', '150.0', '一碗绿叶菜', '40.0', '超市买到的鸡胸肉的三分之一大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '60.0', '三分之二碗的米饭或一个较大的馒头', '100.0', '三分之二碗的绿叶菜', '40.0', '从指根到腕关节部分手掌大小的带鱼段的三分之二大小即可；三只河虾；四只基围虾；四个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '5.0', '二分之一汤勺');
INSERT INTO `meal_times` VALUES (1700, '50', '一个普通大小的馒头；两片普通大小的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '40.0', '半个体积较大的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '150.0', '一个普通大小的去核苹果；一根普通大小的香蕉和一根小香蕉；8-11颗草莓；9颗樱桃番茄', '90.0', '一碗米饭', '180.0', '9颗手中指长度的小油菜或6片大白菜', '45.0', '超市买到的鸡胸肉的三分之一大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '70.0', '四分之三碗米饭或一个较大的馒头', '120.0', '6颗手中指长度的小油菜或4片大白菜', '45.0', '从指根到腕关节部分手掌大小的带鱼段的四分之三大小即可；两只河虾和两个虾仁；五只基围虾', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (1800, '65', '一个较大的馒头；两片较大或三片较小的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '40.0', '半个体积较大的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '150.0', '一个普通大小的去核苹果；一根普通大小的香蕉和一根小香蕉；8-11颗草莓；9颗樱桃番茄', '90.0', '一碗米饭', '200.0', '4颗全手长的油菜或三分之二碟芹菜茎', '50.0', '超市买到的鸡胸肉的五分之二大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '70.0', '四分之三碗米饭或一个较大的馒头', '150.0', '一碗绿叶菜', '50.0', '从指根到腕关节部分手掌大小的带鱼段的五分之四大小即可；四只河虾；两只基围虾和三个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (1900, '65', '一个较大的馒头；两片较大或三片较小的全麦吐司', '50.0', '三分之一碗的绿叶菜', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '45.0', '一个体积较小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '200.0', '两个去核的小苹果；一根大香蕉和一根小香蕉；11-14颗草莓；11颗樱桃番茄', '100.0', '满满一碗米饭接近溢出', '200.0', '4颗全手长的油菜或三分之二碟芹菜茎', '50.0', '超市买到的鸡胸肉的五分之二大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '70.0', '四分之三碗米饭或一个较大的馒头', '170.0', '满满一碗绿叶菜接近溢出', '50.0', '从指根到腕关节部分手掌大小的带鱼段的五分之四大小即可；四只河虾；两只基围虾和三个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2000, '70', '一个较大的馒头；两片较大或三片较小的全麦吐司', '60.0', '半碗油菜或菠菜等绿叶菜；三分之一碗的芹菜茎', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '250.0', '两个半的去核小苹果或一个半的去核普通大小苹果；两根大香蕉；14-17颗草莓；14颗樱桃番茄', '100.0', '满满一碗米饭接近溢出', '200.0', '4颗全手长的油菜或三分之二碟芹菜茎', '50.0', '超市买到的鸡胸肉的五分之二大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '70.0', '四分之三碗米饭或一个较大的馒头', '170.0', '满满一碗绿叶菜接近溢出', '50.0', '从指根到腕关节部分手掌大小的带鱼段的五分之四大小即可；四只河虾；两只基围虾和三个虾仁', '15.0', '对应豆浆300毫升左右，一瓶鲜豆浆的量；或豆腐脑6汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2100, '70', '一个较大的馒头；两片较大或三片较小的全麦吐司', '60.0', '半碗油菜或菠菜等绿叶菜；三分之一碗的芹菜茎', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '250.0', '两个半的去核小苹果或一个半的去核普通大小苹果；两根大香蕉；14-17颗草莓；14颗樱桃番茄', '110.0', '一碗+四分之一碗米饭', '220.0', '一碗半绿叶菜', '60.0', '超市买到的鸡胸肉的二分之一大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '70.0', '四分之三碗米饭或一个较大的馒头', '170.0', '满满一碗绿叶菜接近溢出', '65.0', '从指根到腕关节部分手掌大小的带鱼段；五只河虾；六只基围虾；六个虾仁', '20.0', '对应豆浆400毫升左右，两小瓶或两袋鲜豆浆的量；或豆腐脑8汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2200, '70', '一个较大的馒头；两片较大或三片较小的全麦吐司', '60.0', '半碗油菜或菠菜等绿叶菜；三分之一碗的芹菜茎', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '250.0', '两个半的去核小苹果或一个半的去核普通大小苹果；两根大香蕉；14-17颗草莓；14颗樱桃番茄', '120.0', '一碗+三分之一碗米饭', '220.0', '一碗半绿叶菜', '75.0', '超市买到的鸡胸肉的五分之三大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '85.0', '半碗蒸红薯或两个较小的馒头', '170.0', '满满一碗绿叶菜接近溢出', '75.0', '从指根到腕关节部分手掌大小的带鱼段和一个虾仁；六只河虾；八只基围虾；七个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2300, '70', '一个较大的馒头；两片较大或三片较小的全麦吐司', '60.0', '半碗油菜或菠菜等绿叶菜；三分之一碗的芹菜茎', '50.0', '半个体积较小的去核苹果；3-5个樱桃番茄；3-4颗草莓；半根香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '270.0', '两个半的去核小苹果或一个半的去核普通大小苹果；两根大香蕉；17-19颗草莓；15颗樱桃番茄', '130.0', '一碗+五分之二碗米饭', '240.0', '一碗+三分之二碗绿叶菜', '75.0', '超市买到的鸡胸肉的五分之三大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '85.0', '半碗蒸红薯或两个较小的馒头', '180.0', '9颗手中指长度的小油菜或6片大白菜', '75.0', '从指根到腕关节部分手掌大小的带鱼段和一个虾仁；六只河虾；八只基围虾；七个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2400, '80', '两个较小的馒头；三片普通大小的全麦吐司', '70.0', '三分之二碗的油菜或菠菜等绿叶菜；半碗的芹菜茎', '70.0', '半个普通大小的去核苹果；4-7个樱桃番茄；4-5颗草莓；半根大型的香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '280.0', '两个去核的小苹果和半个去核的普通大小苹果；两根大香蕉；19-20颗草莓；16颗樱桃番茄', '130.0', '一碗+五分之二碗米饭', '250.0', '一碗+三分之二碗绿叶菜', '75.0', '超市买到的鸡胸肉的五分之三大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '90.0', '半碗蒸红薯；一个普通大小和一个稍小的馒头', '180.0', '9颗手中指长度的小油菜或6片大白菜', '75.0', '从指根到腕关节部分手掌大小的带鱼段和一个虾仁；六只河虾；八只基围虾；七个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2500, '85', '两个较小的馒头；三片普通大小的全麦吐司', '70.0', '三分之二碗的油菜或菠菜等绿叶菜；半碗的芹菜茎', '70.0', '半个普通大小的去核苹果；4-7个樱桃番茄；4-5颗草莓；半根大型的香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '280.0', '两个去核的小苹果和半个去核的普通大小苹果；两根大香蕉；19-20颗草莓；16颗樱桃番茄', '140.0', '一碗半米饭', '250.0', '一碗+三分之二碗绿叶菜', '75.0', '超市买到的鸡胸肉的五分之三大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '100.0', '三分之二碗蒸土豆；两个普通大小的馒头', '180.0', '9颗手中指长度的小油菜或6片大白菜', '75.0', '从指根到腕关节部分手掌大小的带鱼段和一个虾仁；六只河虾；八只基围虾；七个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2600, '90', '一个普通大小和一个稍小的馒头；三片较大的全麦吐司', '70.0', '三分之二碗的油菜或菠菜等绿叶菜；半碗的芹菜茎', '70.0', '半个普通大小的去核苹果；4-7个樱桃番茄；4-5颗草莓；半根大型的香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '280.0', '两个去核的小苹果和半个去核的普通大小苹果；两根大香蕉；19-20颗草莓；16颗樱桃番茄', '150.0', '一碗半米饭', '250.0', '一碗+三分之二碗绿叶菜', '75.0', '超市买到的鸡胸肉的五分之三大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '110.0', '三分之二碗蒸红薯；一个稍大些和一个普通大小的馒头', '180.0', '9颗手中指长度的小油菜或6片大白菜', '75.0', '从指根到腕关节部分手掌大小的带鱼段和一个虾仁；六只河虾；八只基围虾；七个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2700, '90', '一个普通大小和一个稍小的馒头；三片较大的全麦吐司', '70.0', '三分之二碗的油菜或菠菜等绿叶菜；半碗的芹菜茎', '70.0', '半个普通大小的去核苹果；4-7个樱桃番茄；4-5颗草莓；半根大型的香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '300.0', '两个去核的小苹果和半个去核的普通大小的苹果；两根小香蕉和半根大香蕉；20-23颗草莓；17颗樱桃番茄', '160.0', '一碗+四分之三碗米饭', '250.0', '一碗+三分之二碗绿叶菜', '85.0', '超市买到的鸡胸肉的三分之二大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '110.0', '三分之二碗蒸红薯；一个稍大些和一个普通大小的馒头', '180.0', '9颗手中指长度的小油菜或6片大白菜', '90.0', '从指根到腕关节部分手掌大小的带鱼段和两个虾仁；七只河虾；十只基围虾；九个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2800, '90', '一个普通大小和一个稍小的馒头；三片较大的全麦吐司', '70.0', '三分之二碗的油菜或菠菜等绿叶菜；半碗的芹菜茎', '80.0', '半个普通大小的去核苹果；5-8个樱桃番茄；5-6颗草莓；一根小型的香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '320.0', '两个普通大小的苹果；两根大香蕉和一根小香蕉或三根半小香蕉；23-24颗草莓；18颗樱桃番茄', '160.0', '一碗+四分之三碗米饭', '250.0', '一碗+三分之二碗绿叶菜', '100.0', '超市买到的鸡胸肉的五分之四大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '125.0', '四分之三碗蒸红薯；两个稍大些的馒头', '180.0', '9颗手中指长度的小油菜或6片大白菜', '100.0', '从指根到腕关节部分手掌大小的带鱼段和三个虾仁；八只河虾；十一只基围虾；十个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (2900, '100', '两个普通大小的馒头；四片普通大小的全麦吐司', '80.0', '四分之三碗的油菜或菠菜等绿叶菜；三分之二碗的芹菜茎', '80.0', '半个普通大小的去核苹果；5-8个樱桃番茄；5-6颗草莓；一根小型的香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '320.0', '两个普通大小的苹果；两根大香蕉和一根小香蕉或三根半小香蕉；23-24颗草莓；18颗樱桃番茄', '160.0', '一碗+四分之三碗米饭', '270.0', '一碗+五分之四碗绿叶菜', '100.0', '超市买到的鸡胸肉的五分之四大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '125.0', '四分之三碗蒸红薯；两个稍大些的馒头', '200.0', '4颗全手长的油菜或三分之二碟芹菜茎', '115.0', '从指根到腕关节部分手掌大小的带鱼段和五个虾仁；九只河虾；十三只基围虾；十一个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');
INSERT INTO `meal_times` VALUES (3000, '100', '两个普通大小的馒头；四片普通大小的全麦吐司', '80.0', '四分之三碗的油菜或菠菜等绿叶菜；三分之二碗的芹菜茎', '80.0', '半个普通大小的去核苹果；5-8个樱桃番茄；5-6颗草莓；一根小型的香蕉', '50.0', '一个普通大小的鸡蛋', '300.0', '两杯半左右带包装酸奶或牛奶', '320.0', '两个普通大小的苹果；两根大香蕉和一根小香蕉或三根半小香蕉；23-24颗草莓；18颗樱桃番茄', '170.0', '一碗+五分之四碗米饭', '300.0', '两碗绿叶菜', '100.0', '超市买到的鸡胸肉的五分之四大小即可', '15.0', '一+二分之一汤勺', '0.0', '无', '10.0', '10粒去壳杏仁；2个核桃仁；5粒松子仁；3粒腰果；一碟南瓜子仁', '130.0', '一碗蒸土豆；一碗蒸红薯；两个较大的馒头', '220.0', '一碗半绿叶菜', '125.0', '两块从指根到腕关节部分手掌大小的带鱼段；十只河虾；十四只基围虾；十二个虾仁', '25.0', '对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块', '10.0', '一汤勺');

-- ----------------------------
-- Table structure for past_medical_history
-- ----------------------------
DROP TABLE IF EXISTS `past_medical_history`;
CREATE TABLE `past_medical_history`  (
  `guardian_phone` bigint(20) NOT NULL,
  `macrosomia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `acalcerosis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `anemia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bleeding_gums` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `canker_sore` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `diabetes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drink` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enamel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `furfur` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `geographic_tongue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hair_baldness` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hair_caducous` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hair_dry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hair_embrittlement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hair_few` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hair_pressure_alopecia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hair_thin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hairchange_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hypertension` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hypovitaminosisa` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hypovitaminosisd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keratohelcosis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keratomalacia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keratosis_pilaris` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `low_birth_weight` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `normal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `odontiasis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `opsigenes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `peeling` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `polyembryony` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `premature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `smoke` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vegetarian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xerophthalmia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zinc_deficiency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inspect_order` int(11) NOT NULL,
  `allergic_history` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of past_medical_history
-- ----------------------------
INSERT INTO `past_medical_history` VALUES (13657842222, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `past_medical_history` VALUES (17888776677, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL);

-- ----------------------------
-- Table structure for sports_survey
-- ----------------------------
DROP TABLE IF EXISTS `sports_survey`;
CREATE TABLE `sports_survey`  (
  `guardian_phone` bigint(20) NOT NULL,
  `sport_status` int(11) NULL DEFAULT NULL,
  `inspect_order` int(11) NOT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sports_survey
-- ----------------------------
INSERT INTO `sports_survey` VALUES (13657842222, 2, 1);
INSERT INTO `sports_survey` VALUES (17511111111, 1, 1);

-- ----------------------------
-- Table structure for system_img_upload
-- ----------------------------
DROP TABLE IF EXISTS `system_img_upload`;
CREATE TABLE `system_img_upload`  (
  `guardian_phone` bigint(20) NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inspect_order` int(11) NOT NULL,
  PRIMARY KEY (`guardian_phone`, `inspect_order`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_img_upload
-- ----------------------------
INSERT INTO `system_img_upload` VALUES (13657842222, 'http://192.168.0.1:8082/7.gif', 1);
INSERT INTO `system_img_upload` VALUES (13657842223, 'http://192.168.0.1:8080/4.gif', 1);
INSERT INTO `system_img_upload` VALUES (13657842224, 'http://192.168.0.1:8080/4.gif', 1);
INSERT INTO `system_img_upload` VALUES (17511111111, 'http://192.168.1.114:8082/17511111111_Bmi.png', 1);
INSERT INTO `system_img_upload` VALUES (17610256822, 'http://192.168.1.114:8082/17610256822_Bmi.png', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
