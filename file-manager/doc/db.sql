/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-14 01:14:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `images_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图像ID',
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `width` int(11) DEFAULT NULL COMMENT '宽',
  `height` int(11) DEFAULT NULL COMMENT '高',
  `url` varchar(500) DEFAULT NULL COMMENT '路径',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态,0:启用，1:禁用',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态,0:未删除，1:删除 ',
  `create_user` int(11) NOT NULL COMMENT '创建者',
  `update_user` int(11) NOT NULL COMMENT '更新者',
  `screate_time` datetime DEFAULT NULL COMMENT '创建时间',
  `supdate_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`images_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COMMENT='图像信息表';

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('63', '4.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/ff985ed1cf884534b31568a7e4fd76e1.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('64', '6.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/d59f5283af214e788a51b7c7f93d7184.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('65', '1.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/539ee610f3a24d2c95d3c0a348d02bd5.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('66', '5.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/179fe430f7d8438b82735f1a89f6a691.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('67', '2.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/62179743dc284d768af22ad79df04f3f.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('68', '3.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/8e3395b77da3448bb1b756f6eab4d1c6.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('69', '8.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/e8bfc72bd0884a618db264519b3b276d.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('70', '9.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/087319aa69154a11bc759cb47a51ef43.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('71', '7.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/865652a334a2489d8eae4e33d0998f2c.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');
INSERT INTO `images` VALUES ('72', '10.jpg', '400', '400', 'http://yun.souyunku.cn/upldata/20170914/6c4ea9eab1074846b4f61f7a0a9a6035.jpg', null, '0', '0', '0', '0', '2017-09-14 00:35:31', '2017-09-14 00:35:31');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统配置ID',
  `config_key` varchar(50) DEFAULT NULL COMMENT 'key',
  `config_value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态,0:启用，1:禁用',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态,0:未删除，1:删除 ',
  `create_user` int(11) NOT NULL COMMENT '创建者',
  `update_user` int(11) NOT NULL COMMENT '更新者',
  `screate_time` datetime DEFAULT NULL COMMENT '创建时间',
  `supdate_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='系统配置表';

