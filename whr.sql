/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : whr

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2020-04-27 21:10:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(11) NOT NULL COMMENT '部门',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '技术部');
INSERT INTO `department` VALUES ('2', '运维部');
INSERT INTO `department` VALUES ('3', '财务部');
INSERT INTO `department` VALUES ('4', '市场部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(11) NOT NULL COMMENT '姓名',
  `job_number` bigint(11) NOT NULL COMMENT '工号',
  `sex` int(1) NOT NULL COMMENT '性别1:男,2:女',
  `birthday` date default NULL COMMENT '出生日期',
  `identity` varchar(18) default NULL COMMENT '身份证号码',
  `is_married` int(1) default '0' COMMENT '婚姻状况(0：未婚，1：已婚)',
  `nation_id` int(4) default '0' COMMENT '民族',
  `hometown` varchar(11) default NULL COMMENT '籍贯',
  `political_id` int(4) default '0' COMMENT '政治面貌',
  `email` varchar(11) default NULL,
  `phone` varchar(11) NOT NULL,
  `address` varchar(30) default NULL,
  `department_id` int(4) NOT NULL default '0' COMMENT '所属部门',
  `position_id` int(4) NOT NULL default '0' COMMENT '职位',
  `job_title` int(4) NOT NULL default '0' COMMENT '职称',
  `employment_form` int(1) NOT NULL default '0' COMMENT '聘用形式(1：劳动合同；2：劳务合同）',
  `entry_date` date default NULL COMMENT '入职日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张三', '1001', '1', '2020-01-01', '330333188919283726', '0', '1', '江苏盐城', '1', '123@qq.com', '17721528140', '江苏省南京市江宁区', '1', '1', '1', '1', '2020-04-27');
INSERT INTO `employee` VALUES ('2', '李四', '1002', '1', '2020-04-16', '32098119991919229', '0', '1', '江苏盐城', '1', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', '2020-04-15');
INSERT INTO `employee` VALUES ('3', '王五', '1003', '1', null, '32098119991919229', '0', '1', '江苏徐州', '1', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);
INSERT INTO `employee` VALUES ('4', '王五', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '2', '1244@qq.com', '18852078909', '江苏省南京市', '1', '2', '1', '1', null);
INSERT INTO `employee` VALUES ('5', '赵六', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '2', '1244@qq.com', '18852078909', '江苏省南京市', '1', '2', '1', '1', null);
INSERT INTO `employee` VALUES ('6', '王五', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '3', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);
INSERT INTO `employee` VALUES ('10', '王五', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '3', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);
INSERT INTO `employee` VALUES ('13', '张三', '1001', '1', '2020-01-01', '330333188919283726', '0', '1', '江苏盐城', '1', '123@qq.com', '17721528140', '江苏省南京市江宁区', '1', '1', '1', '1', '2020-04-27');
INSERT INTO `employee` VALUES ('14', '李四', '1002', '1', '2020-04-16', '32098119991919229', '0', '1', '江苏盐城', '1', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', '2020-04-15');
INSERT INTO `employee` VALUES ('15', '王五', '1003', '1', null, '32098119991919229', '0', '1', '江苏徐州', '1', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);
INSERT INTO `employee` VALUES ('16', '王五', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '2', '1244@qq.com', '18852078909', '江苏省南京市', '1', '2', '1', '1', null);
INSERT INTO `employee` VALUES ('17', '赵六', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '2', '1244@qq.com', '18852078909', '江苏省南京市', '1', '2', '1', '1', null);
INSERT INTO `employee` VALUES ('18', '王五', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '1', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);
INSERT INTO `employee` VALUES ('19', '王五', '1004', '1', null, '32098119991919229', '0', '2', '江苏盐城', '3', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);
INSERT INTO `employee` VALUES ('20', '王五', '1004', '1', null, '32098119991919229', '0', '2', '江苏盐城', '1', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);
INSERT INTO `employee` VALUES ('21', '王五', '1004', '1', null, '32098119991919229', '0', '1', '江苏盐城', '1', '1244@qq.com', '18852078909', '江苏省南京市', '1', '1', '1', '1', null);

-- ----------------------------
-- Table structure for job_title
-- ----------------------------
DROP TABLE IF EXISTS `job_title`;
CREATE TABLE `job_title` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(11) NOT NULL COMMENT '职称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_title
-- ----------------------------
INSERT INTO `job_title` VALUES ('1', '实习生');
INSERT INTO `job_title` VALUES ('2', '初级开发工程师');
INSERT INTO `job_title` VALUES ('3', '中级开发工程师');
INSERT INTO `job_title` VALUES ('4', '高级开发工程师');

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(11) NOT NULL COMMENT '民族',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nation
-- ----------------------------
INSERT INTO `nation` VALUES ('1', '汉族');
INSERT INTO `nation` VALUES ('2', '苗族');
INSERT INTO `nation` VALUES ('3', '水族');

-- ----------------------------
-- Table structure for political
-- ----------------------------
DROP TABLE IF EXISTS `political`;
CREATE TABLE `political` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of political
-- ----------------------------
INSERT INTO `political` VALUES ('1', '群众');
INSERT INTO `political` VALUES ('2', '共青团员');
INSERT INTO `political` VALUES ('3', '党员');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(11) NOT NULL COMMENT '职位',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', '研发工程师');
INSERT INTO `position` VALUES ('2', '运维工程师');
INSERT INTO `position` VALUES ('3', '技术总监');
