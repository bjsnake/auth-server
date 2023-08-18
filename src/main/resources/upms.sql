/*
 Navicat Premium Data Transfer

 Source Server         : local-3306-123456
 Source Server Type    : MySQL
 Source Server Version : 50743
 Source Host           : localhost:3306
 Source Schema         : upms

 Target Server Type    : MySQL
 Target Server Version : 50743
 File Encoding         : 65001

 Date: 18/08/2023 17:19:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenant_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID(会员/员工)',
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `default_tenant` smallint(3) DEFAULT NULL COMMENT '是否默认租户',
  `status` smallint(3) DEFAULT '0' COMMENT '是否锁定(0-否，1-是)',
  `person_id` varchar(32) DEFAULT NULL,
  `app_id` varchar(32) DEFAULT NULL COMMENT '微信appId',
  `open_id` varchar(32) DEFAULT NULL COMMENT '第三方登录授权openId',
  `channel` smallint(3) DEFAULT NULL COMMENT '账号渠道（1:员工，2：会员）',
  `login_way` smallint(3) DEFAULT NULL COMMENT '登录方式（1:PC,2:微信小程序，3:公众号，4：APP）',
  `supper_admin` smallint(3) DEFAULT '1' COMMENT '是否租户超级管理员(1-是,0-否)',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='账号';

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES (2, '9999', '1', '18516908635', '$2a$10$brEGgCtmhWYaGwAhKILI5eGb1g95oAtQcfY9wm4YBE83kbApKEpqm', 1, 0, '1', NULL, NULL, 1, 1, 1, '2023-08-18 14:52:47', '2023-08-18 14:53:27', '2023-08-18 14:52:51');
COMMIT;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT,
  `emp_id` varchar(32) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `name` varchar(32) DEFAULT NULL COMMENT '员工姓名',
  `gender` smallint(3) DEFAULT NULL COMMENT '性别',
  `person_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='员工';

-- ----------------------------
-- Records of emp
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for emp_org
-- ----------------------------
DROP TABLE IF EXISTS `emp_org`;
CREATE TABLE `emp_org` (
  `id` bigint(20) NOT NULL,
  `emp_id` varchar(32) DEFAULT NULL,
  `org_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工组织关系表';

-- ----------------------------
-- Records of emp_org
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `emp_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='员工角色';

-- ----------------------------
-- Records of emp_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` varchar(32) NOT NULL DEFAULT '' COMMENT '会员Id',
  `phone` varchar(32) NOT NULL DEFAULT '' COMMENT '手机号',
  `avatar` varchar(128) DEFAULT '' COMMENT '头像',
  `nickname` varchar(32) DEFAULT '' COMMENT '昵称',
  `gender` smallint(3) DEFAULT '3' COMMENT '性别(1:男,2,女,3保密)',
  `type` varchar(3) DEFAULT NULL COMMENT '会员类型',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='会员表';

-- ----------------------------
-- Records of member
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` varchar(32) NOT NULL COMMENT '菜单/按钮ID',
  `parent_id` varchar(32) NOT NULL COMMENT '上级菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
  `path` varchar(255) DEFAULT NULL COMMENT '对应路由path',
  `component` varchar(255) DEFAULT NULL COMMENT '对应路由组件component',
  `perms` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `type` smallint(3) NOT NULL COMMENT '类型 0菜单 1按钮,2目录',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_parent_id` (`parent_id`) USING BTREE,
  KEY `menu_menu_id` (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=263 DEFAULT CHARSET=utf8mb4 COMMENT='菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (195, '1', '0', '系统管理', '/system', 'Layout', NULL, 'el-icon-set-up', 0, 1, '2021-07-03 14:05:13', '2021-07-03 14:05:13', '9999');
INSERT INTO `menu` VALUES (196, '2', '0', '系统监控', '/monitor', 'Layout', NULL, 'el-icon-data-line', 0, 2, '2021-07-03 14:05:15', '2021-07-03 14:05:15', '9999');
INSERT INTO `menu` VALUES (197, '3', '1', '用户管理', '/system/user', 'febs/system/user/Index', 'user:view', '', 0, 1, '2021-07-03 14:05:17', '2021-07-03 14:05:17', '9999');
INSERT INTO `menu` VALUES (198, '4', '1', '角色管理', '/system/role', 'febs/system/role/Index', 'role:view', '', 0, 2, '2021-07-03 14:05:18', '2021-07-03 14:05:18', '9999');
INSERT INTO `menu` VALUES (199, '5', '1', '菜单管理', '/system/menu', 'febs/system/menu/Index', 'menu:view', '', 0, 3, '2021-07-03 14:05:20', '2021-07-03 14:05:20', '9999');
INSERT INTO `menu` VALUES (200, '6', '1', '部门管理', '/system/dept', 'febs/system/dept/Index', 'dept:view', '', 0, 4, '2021-07-03 14:05:22', '2021-07-03 14:05:22', '9999');
INSERT INTO `menu` VALUES (201, '10', '2', '系统日志', '/monitor/systemlog', 'febs/monitor/systemlog/Index', 'log:view', '', 0, 2, '2021-07-03 14:05:24', '2021-07-03 14:05:24', '9999');
INSERT INTO `menu` VALUES (202, '11', '3', '新增用户', '', '', 'user:add', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (203, '12', '3', '修改用户', '', '', 'user:update', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (204, '13', '3', '删除用户', '', '', 'user:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (205, '14', '4', '新增角色', '', '', 'role:add', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (206, '15', '4', '修改角色', '', '', 'role:update', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (207, '16', '4', '删除角色', '', '', 'role:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (208, '17', '5', '新增菜单', '', '', 'menu:add', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (209, '18', '5', '修改菜单', '', '', 'menu:update', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (210, '19', '5', '删除菜单', '', '', 'menu:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (211, '20', '6', '新增部门', '', '', 'dept:add', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (212, '21', '6', '修改部门', '', '', 'dept:update', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (213, '22', '6', '删除部门', '', '', 'dept:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (214, '24', '10', '删除日志', '', '', 'log:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (215, '130', '3', '导出Excel', NULL, NULL, 'user:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (216, '131', '4', '导出Excel', NULL, NULL, 'role:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (217, '132', '5', '导出Excel', NULL, NULL, 'menu:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (218, '133', '6', '导出Excel', NULL, NULL, 'dept:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (219, '135', '3', '密码重置', NULL, NULL, 'user:reset', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (220, '136', '10', '导出Excel', NULL, NULL, 'log:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (221, '150', '2', '登录日志', '/monitor/loginlog', 'febs/monitor/loginlog/Index', 'monitor:loginlog', '', 0, 3, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (222, '151', '150', '删除日志', NULL, NULL, 'loginlog:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (223, '152', '150', '导出Excel', NULL, NULL, 'loginlog:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (224, '154', '0', '其他模块', '/others', 'Layout', '', 'el-icon-shopping-bag-1', 0, 6, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (225, '155', '154', '导入导出', '/others/eximport', 'febs/others/eximport/Index', 'others:eximport', '', 0, 1, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (226, '156', '0', '代码生成', '/gen', 'Layout', '', 'el-icon-printer', 0, 4, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (227, '157', '156', '基础配置', '/gen/config', 'febs/gen/config/Index', 'gen:config', '', 0, 1, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (228, '158', '156', '生成代码', '/gen/generate', 'febs/gen/generate/Index', 'gen:generate', '', 0, 2, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (229, '159', '157', '修改配置', NULL, NULL, 'gen:config:update', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (230, '160', '158', '打包生成', NULL, NULL, 'gen:generate:gen', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (231, '163', '1', '客户端管理', '/client', 'febs/system/client/Index', 'client:view', '', 0, 5, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (232, '164', '163', '新增', NULL, NULL, 'client:add', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (233, '165', '163', '修改', NULL, NULL, 'client:update', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (234, '166', '163', '删除', NULL, NULL, 'client:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (235, '167', '163', '解密', NULL, NULL, 'client:decrypt', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (236, '168', '0', '静态组件', '/components', 'Layout', '', 'el-icon-present', 0, 7, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (237, '169', '168', '二级菜单', '/two', 'demos/two/Index', '', '', 0, 1, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (238, '170', '169', '三级菜单', '/three', 'demos/two/three/Index', '', '', 0, 1, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (239, '171', '168', 'MarkDown', '/components/markdown', 'demos/markdown', '', '', 0, 2, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (240, '172', '168', '富文本编辑器', '/components/tinymce', 'demos/tinymce', '', '', 0, 3, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (241, '173', '0', '网关管理', '/route', 'Layout', '', 'el-icon-odometer', 0, 3, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (242, '174', '173', '网关用户', '/route/user', 'febs/route/routeuser/Index', '', '', 0, 1, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (243, '175', '173', '网关日志', '/route/log', 'febs/route/routelog/Index', '', '', 0, 2, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (244, '176', '173', '限流规则', '/route/ratelimitrule', 'febs/route/ratelimitrule/Index', '', '', 0, 3, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (245, '177', '173', '限流日志', '/route/ratelimitlog', 'febs/route/ratelimitlog/Index', '', '', 0, 4, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (246, '178', '173', '黑名单管理', '/route/blacklist', 'febs/route/blacklist/Index', '', '', 0, 5, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (247, '179', '173', '黑名单日志', '/route/blocklog', 'febs/route/blocklog/Index', '', '', 0, 6, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (248, '180', '2', '监控面板', '/monitor/dashboard', 'febs/monitor/dashboard/Index', 'monitor:dashboard', '', 0, 1, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (249, '181', '154', '个人博客', '/others/blog', 'febs/others/blog/Index', '', '', 0, 2, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (250, '182', '154', '数据权限', '/others/datapermission', 'febs/others/datapermission/Index', 'others:datapermission', '', 0, 3, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (251, '183', '0', '任务调度', '/job', 'Layout', '', 'el-icon-alarm-clock', 0, 5, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (252, '184', '183', '任务列表', '/job/list', 'febs/job/job/Index', 'job:view', '', 0, 1, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (253, '185', '183', '调度日志', '/job/log', 'febs/job/log/Index', 'job:log:view', '', 0, 2, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (254, '186', '184', '新增任务', NULL, NULL, 'job:add', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (255, '187', '184', '修改任务', NULL, NULL, 'job:update', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (256, '188', '184', '删除任务', NULL, NULL, 'job:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (257, '189', '184', '暂停任务', NULL, NULL, 'job:pause', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (258, '190', '184', '恢复任务', NULL, NULL, 'job:resume', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (259, '191', '184', '立即执行一次', NULL, NULL, 'job:run', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (260, '192', '184', '导出Excel', NULL, NULL, 'job:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (261, '193', '185', '删除', NULL, NULL, 'job:log:delete', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
INSERT INTO `menu` VALUES (262, '194', '185', '导出', NULL, NULL, 'job:log:export', NULL, 1, NULL, '2021-07-03 14:06:11', '2021-07-03 14:06:11', '9999');
COMMIT;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `client_secret` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `scope` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `authorized_grant_types` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `web_server_redirect_uri` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `access_token_validity` int(11) NOT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 DEFAULT NULL,
  `autoapprove` tinyint(4) DEFAULT NULL,
  `origin_secret` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci COMMENT='客户端配置表';

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('rock_cloud', ' ', '$2a$10$OJLS0KhCkj74z58CH6ObEeKTObuE2AWF7YyKvplBAwSKJ04OfVEaG', 'all', 'password,refresh_token', NULL, NULL, 86400, 8640000, NULL, 0, '123456');
COMMIT;

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `org_id` varchar(32) DEFAULT NULL,
  `parent_id` varchar(20) NOT NULL COMMENT '上级部门ID',
  `org_id_path` varchar(2000) NOT NULL COMMENT '组织树路径',
  `org_name` varchar(100) NOT NULL COMMENT '部门名称',
  `order_num` int(20) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `type` smallint(3) DEFAULT NULL COMMENT '组织类型(0-租户,1-组织)',
  `tenant_id` varchar(32) DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_org_name` (`org_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='组织机构';

-- ----------------------------
-- Records of org
-- ----------------------------
BEGIN;
INSERT INTO `org` VALUES (7, '1', '0', '1', '北京众信互联科技有限公司', 1, '2021-07-03 13:56:09', '2021-07-03 13:48:58', 0, '9999');
INSERT INTO `org` VALUES (8, '2', '1', '1|2', '总办', 2, '2021-07-03 13:49:46', '2021-07-03 13:49:48', 1, '9999');
INSERT INTO `org` VALUES (9, '3', '1', '1|3', '财务部', 3, '2021-07-03 13:50:18', '2021-07-03 13:50:20', 1, '9999');
INSERT INTO `org` VALUES (10, '4', '1', '1|4', '人力资源部', 4, '2021-07-03 13:50:47', '2021-07-03 13:50:49', 1, '9999');
INSERT INTO `org` VALUES (11, '5', '1', '1|5', '研发部', 5, '2021-07-03 13:51:26', '2021-07-03 13:51:29', 1, '9999');
INSERT INTO `org` VALUES (12, '6', '5', '1|5|6', 'SAAS产品平台中心', 1, '2021-07-03 13:52:33', '2021-07-03 13:52:36', 1, '9999');
INSERT INTO `org` VALUES (13, '7', '5', '1|5|7', '定制化交付中心', 2, '2021-07-03 13:53:33', '2021-07-03 13:53:35', 1, '9999');
INSERT INTO `org` VALUES (14, '8', '5', '1|5|8', '质量交付交付中心', 3, '2021-07-03 13:54:20', '2021-07-03 13:54:23', 1, '9999');
INSERT INTO `org` VALUES (15, '9', '5', '1|5|9', 'AIOT研发中心', 4, '2021-07-03 13:57:01', '2021-07-03 13:55:07', 1, '9999');
INSERT INTO `org` VALUES (16, '10', '1', '1|10', '营销部', 1, '2021-07-03 13:57:04', '2021-07-03 13:56:53', 1, '9999');
COMMIT;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `person_id` varchar(32) DEFAULT NULL COMMENT '自然人ID',
  `mobile` varchar(13) DEFAULT NULL COMMENT '联系电话',
  `gender` smallint(3) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `tenant_id` varchar(32) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='自然人';

-- ----------------------------
-- Records of person
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `role_name` varchar(10) NOT NULL COMMENT '角色名称',
  `role_code` varchar(10) NOT NULL COMMENT '角色编码',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` varchar(32) NOT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='角色';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(32) NOT NULL,
  `menu_id` varchar(32) NOT NULL,
  `tenant_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_menu_id` (`menu_id`) USING BTREE,
  KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联关系';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for wx_app_config
-- ----------------------------
DROP TABLE IF EXISTS `wx_app_config`;
CREATE TABLE `wx_app_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenant_id` varchar(32) DEFAULT NULL COMMENT '租户',
  `channel` varchar(3) DEFAULT NULL COMMENT '渠道',
  `app_id` varchar(255) DEFAULT NULL,
  `app_secret` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of wx_app_config
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
