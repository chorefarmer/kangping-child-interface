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

 Date: 05/07/2019 18:00:39
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
  `kcal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `practicalf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staple_foodf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staple_foodg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vegetablesf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vegetablesg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fruitsf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fruitsg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `livestockf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `livestockg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `aquatic_productf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `aquatic_productg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eggf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eggg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `milkf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `milkg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `beanf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `beang` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nutf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nutg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oilf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oilg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
