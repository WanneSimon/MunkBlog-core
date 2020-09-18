
create database MunkBlog default character set utf8;

use MunkBlog;



SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '博文内容',
  `group_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '归类',
  `editor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编辑器版本 (默认quill3+)',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '最后编辑时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `blog_create_time`(`create_time`) USING BTREE COMMENT '创建时间',
  INDEX `blog_valid_title`(`valid`, `title`) USING BTREE COMMENT '标题索引',
  INDEX `blog_valid_group`(`valid`, `group_type`, `title`) USING BTREE COMMENT '归类标题'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博文' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_quotation
-- ----------------------------
DROP TABLE IF EXISTS `blog_quotation`;
CREATE TABLE `blog_quotation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) DEFAULT NULL COMMENT '博文id',
  `name` varchar(125) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '引用名',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '引用连接',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bq_blogId_name`(`blog_id`, `name`) USING BTREE COMMENT '生效博文引用名'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博文引用' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书名',
  `description` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '介绍',
  `editor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编辑器版本 (默认quill3+)',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `book_createTime`(`create_time`) USING BTREE COMMENT '创建时间',
  INDEX `book_valid_name`(`valid`, `name`) USING BTREE COMMENT '书名'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '书' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bookmark
-- ----------------------------
DROP TABLE IF EXISTS `bookmark`;
CREATE TABLE `bookmark`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书签名',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '简短描述',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书签连接',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bm_createTime`(`create_time`) USING BTREE COMMENT '创建时间',
  INDEX `bm_valid_name`(`valid`, `name`) USING BTREE COMMENT '书签名'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '书签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bookmark_folder
-- ----------------------------
DROP TABLE IF EXISTS `bookmark_folder`;
CREATE TABLE `bookmark_folder`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父书签文件夹',
  `child_id` int(11) DEFAULT NULL COMMENT '字书签文件夹',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bm_parentId`(`parent_id`) USING BTREE COMMENT '书签父文件夹索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '书签父子关系文件夹' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comic_words
-- ----------------------------
DROP TABLE IF EXISTS `comic_words`;
CREATE TABLE `comic_words`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '语录内容',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '语录来源作者',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cw_createTime`(`create_time`) USING BTREE COMMENT '创建时间',
  INDEX `cw_valid_author`(`valid`, `author`) USING BTREE COMMENT '语录作者'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '语录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for daily_log
-- ----------------------------
DROP TABLE IF EXISTS `daily_log`;
CREATE TABLE `daily_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '日志内容',
  `editor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编辑器版本 (默认quill3+)',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime(0) DEFAULT NULL COMMENT '最后更新日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dl_createTime_valid`(`create_time`, `valid`) USING BTREE COMMENT '创建时间',
  INDEX `dl_valid`(`valid`) USING BTREE COMMENT '生效'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for efile
-- ----------------------------
DROP TABLE IF EXISTS `efile`;
CREATE TABLE `efile`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件名，虚拟名',
  `base` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所处目录(\'/\'开头绝对路径, 否则就是 相对项目的目录)',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件名（磁盘上的名字，文件名+\'-\'+\'id\'）',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属对象的类型, 博文-Blog, 日志-DailyLog, 书架-Books, 游戏-Games',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `efile_name`(`name`) USING BTREE COMMENT '文件名索引',
  INDEX `efile_createTime`(`create_time`) USING BTREE COMMENT '创建时间',
  INDEX `efile_valid_base`(`valid`, `base`) USING BTREE COMMENT '文件根路径目录索引',
  INDEX `efile_valid_group`(`valid`, `type`) USING BTREE COMMENT '文件所属组别'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '存放所有的文件信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '游戏名',
  `description` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '描述',
  `editor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编辑器版本 (默认quill3+)',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `game_createTime`(`create_time`) USING BTREE COMMENT '创建时间',
  INDEX `game_valid_name`(`valid`, `name`) USING BTREE COMMENT '游戏名'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for image_file
-- ----------------------------
DROP TABLE IF EXISTS `image_file`;
CREATE TABLE `image_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `object_id` int(11) DEFAULT NULL COMMENT '对象的id',
  `file_id` int(11) DEFAULT NULL COMMENT '文件 (efile) id',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属对象的类型, 博文-Blog, 日志-DailyLog, 书架-Books, 游戏-Games',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `if_valid_objectId`(`valid`, `object_id`) USING BTREE COMMENT '对象id',
  INDEX `if_valid_type_objectId`(`valid`, `type`, `object_id`) USING BTREE COMMENT '对象类型对象id'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '各种对象关联的图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for munk_tag
-- ----------------------------
DROP TABLE IF EXISTS `munk_tag`;
CREATE TABLE `munk_tag`  (
  `id` int(11) NOT NULL,
  `tag_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签名',
  `object_id` int(11) DEFAULT NULL COMMENT '对象id',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属对象的类型, 博文-Blog, 日志-DailyLog, 书架-Books, 游戏-Games',
  `valid` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '0-失效, 1-生效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mt_valid_tagName`(`valid`, `tag_name`) USING BTREE COMMENT '标签名',
  INDEX `mt_valid_type_objectId`(`valid`, `type`, `object_id`) USING BTREE COMMENT '对象类型对象id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '各种对象的标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型, 01-博主, 02-访问用户',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_username`(`username`) USING BTREE COMMENT '用户名唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表（不实现评论和留言，但是保留）' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
