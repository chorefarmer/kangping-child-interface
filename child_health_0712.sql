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

 Date: 12/07/2019 17:48:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for allergies_and_intolerances
-- ----------------------------
DROP TABLE IF EXISTS `allergies_and_intolerances`;
CREATE TABLE `allergies_and_intolerances`  (
  `guardian_phone` bigint(20) NOT NULL,
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
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `score` double NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of body_composition_test
-- ----------------------------
INSERT INTO `body_composition_test` VALUES (13657842222, 26.6, NULL, NULL, 14, 38.7, 158, NULL, 1205.9, 35.9, 7.6, 2.76, 21, 30.5, 0.76, 52.7, 21.1, 71.2);
INSERT INTO `body_composition_test` VALUES (17511111111, 23.9, NULL, NULL, 12.6, 40.1, 160, NULL, 1236.2, 37.2, 7.9, 2.87, 21.7, 17.2, 0.76, 52.7, 20.6, 72.2);
INSERT INTO `body_composition_test` VALUES (17610256822, 29.4, NULL, NULL, 15.5, 37.2, 155, NULL, 1173.5, 34.5, 7.3, 2.66, 20, 29.3, 0.78, 52.7, 21.9, 70.5);

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
  `poultry_meat` int(11) NULL DEFAULT NULL,
  `ate_and_played` bit(1) NULL DEFAULT NULL,
  `egg` int(11) NULL DEFAULT NULL,
  `fruits` int(11) NULL DEFAULT NULL,
  `irregular_diet` bit(1) NULL DEFAULT NULL,
  `marine_products` int(11) NULL DEFAULT NULL,
  `milk` int(11) NULL DEFAULT NULL,
  `nut` int(11) NULL DEFAULT NULL,
  `prefersfry` bit(1) NULL DEFAULT NULL,
  `prefers_sodas` bit(1) NULL DEFAULT NULL,
  `prefers_sweet` bit(1) NULL DEFAULT NULL,
  `staple_food` int(11) NULL DEFAULT NULL,
  `vegetables` int(11) NULL DEFAULT NULL,
  `without_breakfast` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `hospotial_phone` bigint(20) NOT NULL,
  `contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hospital_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `office_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`hospotial_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `guardian_phone` bigint(20) NOT NULL,
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
  `weight` double NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (13657842222, '2008-07-04 16:00:00', NULL, NULL, '', 158, 'test2', NULL, '', 1, '2019-07-02 17:28:05', '2019-07-05 11:35:02', 40);
INSERT INTO `information` VALUES (17511111111, '2008-05-05 16:00:00', NULL, NULL, '', 160, 'test1', NULL, '', 0, '2019-07-02 17:24:40', '2019-07-05 11:30:31', 40);
INSERT INTO `information` VALUES (17610256822, '2005-04-05 16:00:00', NULL, NULL, '', 155, 'test', NULL, '', 0, '2019-07-02 17:20:43', '2019-07-05 11:30:34', 40);

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
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for meal_times
-- ----------------------------
DROP TABLE IF EXISTS `meal_times`;
CREATE TABLE `meal_times`  (
  `kcal` bigint(20) NOT NULL,
  `breakfast_cereal_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐谷类食物量',
  `breakfast_vegetables_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐蔬菜食物量',
  `examples_of_breakfast_cereals` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐谷类参考举例',
  `examples_of_breakfast_vegetables` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐蔬菜参考举例',
  `breakfast_eggs_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐蛋类食物量',
  `breakfast_fruits_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐水果食物量',
  `breakfast_milk_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐乳制品食物量',
  `dinner_cereal_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐谷类食物量',
  `dinner_fisheries_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐水产类食物量',
  `dinner_oil_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐烹调油类食物量',
  `dinner_soybean_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐大豆食物量',
  `dinner_vegetables_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐蔬菜食物量',
  `examples_of_breakfast_eggs` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐蛋类参考举例',
  `examples_of_breakfast_fruits` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐水果参考举例',
  `examples_of_breakfast_milk` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐乳制品参考举例',
  `examples_of_dinner_cereals` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐谷类参考举例',
  `examples_of_dinner_fisheries` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐水产类参考举例',
  `examples_of_dinner_oil` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐烹调油参考举例',
  `examples_of_dinner_soybean` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐大豆参考举例',
  `examples_of_dinner_vegetables` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐蔬菜参考举例',
  `examples_of_lunch_cereals` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐谷类参考举例',
  `examples_of_lunch_meat` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐禽畜肉类参考举例',
  `examples_of_lunch_oil` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐烹调油参考举例',
  `examples_of_lunch_vegetables` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐蔬菜参考举例',
  `examples_of_snacks_fruits` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加餐水果参考举例',
  `examples_of_snacks_nut` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加餐坚果参考举例',
  `lunch_cereal_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐谷类食物量',
  `lunch_meat_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐禽畜肉类食物量',
  `lunch_oil_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐烹调油类食物量',
  `lunch_vegetables_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐蔬菜食物量',
  `snacks_fruits_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加餐水果食物量',
  `snacks_nut_quantity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加餐坚果食物量',
  PRIMARY KEY (`kcal`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meal_times
-- ----------------------------
INSERT INTO `meal_times` VALUES (1000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1200, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1300, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1400, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1500, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1600, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1700, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1800, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (1900, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2200, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2300, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2400, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2500, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2600, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2700, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2800, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (2900, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `meal_times` VALUES (3000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sports_survey
-- ----------------------------
DROP TABLE IF EXISTS `sports_survey`;
CREATE TABLE `sports_survey`  (
  `guardian_phone` bigint(20) NOT NULL,
  `sport_status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sports_survey
-- ----------------------------
INSERT INTO `sports_survey` VALUES (13657842222, 2);

-- ----------------------------
-- Table structure for system_img_upload
-- ----------------------------
DROP TABLE IF EXISTS `system_img_upload`;
CREATE TABLE `system_img_upload`  (
  `guardian_phone` bigint(20) NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`guardian_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_img_upload
-- ----------------------------
INSERT INTO `system_img_upload` VALUES (13657842222, 'http://192.168.1.114:8082/13657842222_Bmi.png');
INSERT INTO `system_img_upload` VALUES (17511111111, 'http://192.168.1.114:8082/17511111111_Bmi.png');
INSERT INTO `system_img_upload` VALUES (17610256822, 'http://192.168.1.114:8082/17610256822_Bmi.png');

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
