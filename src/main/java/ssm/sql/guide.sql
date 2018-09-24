/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 120.78.213.131:3306
 Source Schema         : guide

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 24/09/2018 22:27:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card`  (
  `card_id` int(11) NOT NULL COMMENT '会员卡的ID',
  `store_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商家名称',
  `store_discount` float NOT NULL COMMENT '折扣力度',
  `starttime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '开始时间',
  `endtime` timestamp(0) NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`card_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES (1, '蜜雪冰城', 8.8, '2018-09-21 15:07:32', '2018-09-28 15:07:39');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论表的自增主键',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的user表主键',
  `scenic_spot_id` int(11) NULL DEFAULT NULL COMMENT '关联的景点表主键',
  `scenic_area_id` int(11) NULL DEFAULT NULL COMMENT '关联的景区表主键',
  `comment_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论的内容',
  `comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评论发布的时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `comment_scenic_area`(`scenic_area_id`) USING BTREE,
  INDEX `comment_scenic_spot`(`scenic_spot_id`) USING BTREE,
  INDEX `comment_user`(`user_email`) USING BTREE,
  CONSTRAINT `comment_scenic_area` FOREIGN KEY (`scenic_area_id`) REFERENCES `scenic_area` (`scenic_area_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_scenic_spot` FOREIGN KEY (`scenic_spot_id`) REFERENCES `scenic_spot` (`scenic_spot_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_user` FOREIGN KEY (`user_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片的自增主键id',
  `scenic_area_id` int(11) NULL DEFAULT NULL COMMENT '若为景点介绍，为null',
  `scenic_spot_id` int(11) NULL DEFAULT NULL COMMENT '若为景区介绍，为null',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片的url相对路径',
  PRIMARY KEY (`picture_id`) USING BTREE,
  INDEX `toScenicSpot`(`scenic_spot_id`) USING BTREE,
  CONSTRAINT `toScenicSpot` FOREIGN KEY (`scenic_spot_id`) REFERENCES `scenic_spot` (`scenic_spot_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES (1, NULL, 28, 'http://maxerwinsmith.qicp.io:49291/picture/boyi.jpg');
INSERT INTO `picture` VALUES (2, NULL, 2, 'http://maxerwinsmith.qicp.io:49291/picture/boyuelu.jpg');
INSERT INTO `picture` VALUES (3, NULL, 54, 'http://maxerwinsmith.qicp.io:49291/picture/cailiaokexueyugongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (4, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/caoxi.jpg');
INSERT INTO `picture` VALUES (5, NULL, 29, 'http://maxerwinsmith.qicp.io:49291/picture/chanqu.jpg');
INSERT INTO `picture` VALUES (6, NULL, 84, 'http://maxerwinsmith.qicp.io:49291/picture/chanyejishuyanjiuyuan.jpg');
INSERT INTO `picture` VALUES (7, NULL, 39, 'http://maxerwinsmith.qicp.io:49291/picture/congcongnaniancanting.jpg');
INSERT INTO `picture` VALUES (8, NULL, 39, 'http://maxerwinsmith.qicp.io:49291/picture/congcongnaniancanting2.jpg');
INSERT INTO `picture` VALUES (9, NULL, 32, 'http://maxerwinsmith.qicp.io:49291/picture/dadaotongqu.jpg');
INSERT INTO `picture` VALUES (10, NULL, 12, 'http://maxerwinsmith.qicp.io:49291/picture/daxueshenghuodongzhongxin.jpg');
INSERT INTO `picture` VALUES (11, NULL, 55, 'http://maxerwinsmith.qicp.io:49291/picture/dianqigongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (12, NULL, 35, 'http://maxerwinsmith.qicp.io:49291/picture/dinglaotounailao.jpg');
INSERT INTO `picture` VALUES (13, NULL, 35, 'http://maxerwinsmith.qicp.io:49291/picture/dinglaotounailao2.jpg');
INSERT INTO `picture` VALUES (14, NULL, 35, 'http://maxerwinsmith.qicp.io:49291/picture/dinglaotounailao3.jpg');
INSERT INTO `picture` VALUES (15, NULL, 35, 'http://maxerwinsmith.qicp.io:49291/picture/dinglaotounailao4.jpg');
INSERT INTO `picture` VALUES (16, NULL, 67, 'http://maxerwinsmith.qicp.io:49291/picture/faxueyuan.jpg');
INSERT INTO `picture` VALUES (17, NULL, 44, 'http://maxerwinsmith.qicp.io:49291/picture/fenghuayuan.jpg');
INSERT INTO `picture` VALUES (18, NULL, 44, 'http://maxerwinsmith.qicp.io:49291/picture/fenghuayuan2.jpg');
INSERT INTO `picture` VALUES (19, NULL, 44, 'http://maxerwinsmith.qicp.io:49291/picture/fenghuayuan3.jpg');
INSERT INTO `picture` VALUES (20, NULL, 33, 'http://maxerwinsmith.qicp.io:49291/picture/fengtaihexiang.jpg');
INSERT INTO `picture` VALUES (21, NULL, 68, 'http://maxerwinsmith.qicp.io:49291/picture/gonggongguanlixueyuan.jpg');
INSERT INTO `picture` VALUES (22, NULL, 80, 'http://maxerwinsmith.qicp.io:49291/picture/gonggongweishengxueyuan.jpg');
INSERT INTO `picture` VALUES (23, NULL, 56, 'http://maxerwinsmith.qicp.io:49291/picture/guanligongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (24, NULL, 31, 'http://maxerwinsmith.qicp.io:49291/picture/guanxingceying.jpg');
INSERT INTO `picture` VALUES (25, NULL, 85, 'http://maxerwinsmith.qicp.io:49291/picture/guojijiaoyuxueyuan.jpg');
INSERT INTO `picture` VALUES (26, NULL, 13, 'http://maxerwinsmith.qicp.io:49291/picture/xingzhenglou.jpg');
INSERT INTO `picture` VALUES (27, NULL, 86, 'http://maxerwinsmith.qicp.io:49291/picture/henanshengziyuanyucailiaochanyexietongchuangxinzhongxin.jpg');
INSERT INTO `picture` VALUES (28, NULL, 14, 'http://maxerwinsmith.qicp.io:49291/picture/hexinjiaoxuequ.jpg');
INSERT INTO `picture` VALUES (29, NULL, 26, 'http://maxerwinsmith.qicp.io:49291/picture/heyuan.jpg');
INSERT INTO `picture` VALUES (30, NULL, 40, 'http://maxerwinsmith.qicp.io:49291/picture/heyuanercanting.jpg');
INSERT INTO `picture` VALUES (31, NULL, 40, 'http://maxerwinsmith.qicp.io:49291/picture/heyuanercanting2.jpg');
INSERT INTO `picture` VALUES (32, NULL, 40, 'http://maxerwinsmith.qicp.io:49291/picture/heyuanercanting3.jpg');
INSERT INTO `picture` VALUES (33, NULL, 50, 'http://maxerwinsmith.qicp.io:49291/picture/heyuansushequ.jpg');
INSERT INTO `picture` VALUES (34, NULL, 41, 'http://maxerwinsmith.qicp.io:49291/picture/heyuanyicanting.jpg');
INSERT INTO `picture` VALUES (35, NULL, 41, 'http://maxerwinsmith.qicp.io:49291/picture/heyuanyicanting2.jpg');
INSERT INTO `picture` VALUES (36, NULL, 41, 'http://maxerwinsmith.qicp.io:49291/picture/heyuanyicanting3.jpg');
INSERT INTO `picture` VALUES (37, NULL, 41, 'http://maxerwinsmith.qicp.io:49291/picture/heyuanyicanting4.jpg');
INSERT INTO `picture` VALUES (38, NULL, 9, 'http://maxerwinsmith.qicp.io:49291/picture/houdetianjian.jpg');
INSERT INTO `picture` VALUES (39, NULL, 57, 'http://maxerwinsmith.qicp.io:49291/picture/huagongyunengyuanxueyuan.jpg');
INSERT INTO `picture` VALUES (40, NULL, 58, 'http://maxerwinsmith.qicp.io:49291/picture/huaxueyufenzigongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (41, NULL, 6, 'http://maxerwinsmith.qicp.io:49291/picture/hubinlu.jpg');
INSERT INTO `picture` VALUES (42, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/huilangge.jpg');
INSERT INTO `picture` VALUES (43, NULL, 81, 'http://maxerwinsmith.qicp.io:49291/picture/hulixueyuan.jpg');
INSERT INTO `picture` VALUES (44, NULL, 60, 'http://maxerwinsmith.qicp.io:49291/picture/jianzhuxueyuan.jpg');
INSERT INTO `picture` VALUES (45, NULL, 69, 'http://maxerwinsmith.qicp.io:49291/picture/jiaoyuxueyuan.jpg');
INSERT INTO `picture` VALUES (46, NULL, 82, 'http://maxerwinsmith.qicp.io:49291/picture/jichuyixueyuan.jpg');
INSERT INTO `picture` VALUES (47, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/jiexingtan.jpg');
INSERT INTO `picture` VALUES (48, NULL, 36, 'http://maxerwinsmith.qicp.io:49291/picture/jingdongbianlidian.jpg');
INSERT INTO `picture` VALUES (49, NULL, 48, 'http://maxerwinsmith.qicp.io:49291/picture/jinggeyuanmeishiba.jpg');
INSERT INTO `picture` VALUES (50, NULL, 59, 'http://maxerwinsmith.qicp.io:49291/picture/jixiegongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (51, NULL, 45, 'http://maxerwinsmith.qicp.io:49291/picture/juyingyuan.jpg');
INSERT INTO `picture` VALUES (52, NULL, 45, 'http://maxerwinsmith.qicp.io:49291/picture/juyingyuan2.jpg');
INSERT INTO `picture` VALUES (53, NULL, 45, 'http://maxerwinsmith.qicp.io:49291/picture/juyingyuan3.jpg');
INSERT INTO `picture` VALUES (54, NULL, 45, 'http://maxerwinsmith.qicp.io:49291/picture/juyingyuan4.jpg');
INSERT INTO `picture` VALUES (55, NULL, 45, 'http://maxerwinsmith.qicp.io:49291/picture/juyingyuan5.jpg');
INSERT INTO `picture` VALUES (56, NULL, 16, 'http://maxerwinsmith.qicp.io:49291/picture/juyuankuaidishoufazhongxin.jpg');
INSERT INTO `picture` VALUES (57, NULL, 51, 'http://maxerwinsmith.qicp.io:49291/picture/juyuansushequ.jpg');
INSERT INTO `picture` VALUES (58, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/lianlangshuichi.jpg');
INSERT INTO `picture` VALUES (59, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/lianlangshuichi2.jpg');
INSERT INTO `picture` VALUES (60, NULL, 70, 'http://maxerwinsmith.qicp.io:49291/picture/lishixueyuan.jpg');
INSERT INTO `picture` VALUES (61, NULL, 71, 'http://maxerwinsmith.qicp.io:49291/picture/liuyuansushequ.jpg');
INSERT INTO `picture` VALUES (62, NULL, 61, 'http://maxerwinsmith.qicp.io:49291/picture/lixueyugongchengkexuexueyuan.jpg');
INSERT INTO `picture` VALUES (63, NULL, 71, 'http://maxerwinsmith.qicp.io:49291/picture/lvyouguanlixueyuan.jpg');
INSERT INTO `picture` VALUES (64, NULL, 72, 'http://maxerwinsmith.qicp.io:49291/picture/makesizhuyixueyuan.jpg');
INSERT INTO `picture` VALUES (65, NULL, 24, 'http://maxerwinsmith.qicp.io:49291/picture/meihu.jpg');
INSERT INTO `picture` VALUES (66, NULL, 24, 'http://maxerwinsmith.qicp.io:49291/picture/meihu2.jpg');
INSERT INTO `picture` VALUES (67, NULL, 24, 'http://maxerwinsmith.qicp.io:49291/picture/meihu3.jpg');
INSERT INTO `picture` VALUES (68, NULL, 73, 'http://maxerwinsmith.qicp.io:49291/picture/meishuxueyuan.jpg');
INSERT INTO `picture` VALUES (69, NULL, 37, 'http://maxerwinsmith.qicp.io:49291/picture/mixuebingcheng.jpg');
INSERT INTO `picture` VALUES (70, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/pubu.jpg');
INSERT INTO `picture` VALUES (71, NULL, 17, 'http://maxerwinsmith.qicp.io:49291/picture/qimingguangchang.jpg');
INSERT INTO `picture` VALUES (72, NULL, 38, 'http://maxerwinsmith.qicp.io:49291/picture/qinchunyuanchaoshi.jpg');
INSERT INTO `picture` VALUES (73, NULL, 46, 'http://maxerwinsmith.qicp.io:49291/picture/qingzhencanting.jpg');
INSERT INTO `picture` VALUES (74, NULL, 43, 'http://maxerwinsmith.qicp.io:49291/picture/qiusuiyuancanting.jpg');
INSERT INTO `picture` VALUES (75, NULL, 74, 'http://maxerwinsmith.qicp.io:49291/picture/shangxueyuan.jpg');
INSERT INTO `picture` VALUES (76, NULL, 62, 'http://maxerwinsmith.qicp.io:49291/picture/shengmingkexuexueyuan.jpg');
INSERT INTO `picture` VALUES (77, NULL, 64, 'http://maxerwinsmith.qicp.io:49291/picture/shuiliyuhuanjingxueyuan.jpg');
INSERT INTO `picture` VALUES (78, NULL, 63, 'http://maxerwinsmith.qicp.io:49291/picture/shuxueyutongjixueyuan.jpg');
INSERT INTO `picture` VALUES (79, NULL, 49, 'http://maxerwinsmith.qicp.io:49291/picture/songyangshifu.jpg');
INSERT INTO `picture` VALUES (80, NULL, 49, 'http://maxerwinsmith.qicp.io:49291/picture/songyuansushequ.jpg');
INSERT INTO `picture` VALUES (81, NULL, 30, 'http://maxerwinsmith.qicp.io:49291/picture/taihezhu.jpg');
INSERT INTO `picture` VALUES (82, NULL, 18, 'http://maxerwinsmith.qicp.io:49291/picture/tiyuguan.jpg');
INSERT INTO `picture` VALUES (83, NULL, 18, 'http://maxerwinsmith.qicp.io:49291/picture/tiyuguan2.jpg');
INSERT INTO `picture` VALUES (84, NULL, 18, 'http://maxerwinsmith.qicp.io:49291/picture/tiyuguan3.jpg');
INSERT INTO `picture` VALUES (85, NULL, 75, 'http://maxerwinsmith.qicp.io:49291/picture/tiyuxueyuan.jpg');
INSERT INTO `picture` VALUES (86, NULL, 47, 'http://maxerwinsmith.qicp.io:49291/picture/tonghechangshifu.jpg');
INSERT INTO `picture` VALUES (87, NULL, 47, 'http://maxerwinsmith.qicp.io:49291/picture/tonghechangshifu2.jpg');
INSERT INTO `picture` VALUES (88, NULL, 47, 'http://maxerwinsmith.qicp.io:49291/picture/tonghechangshifu3.jpg');
INSERT INTO `picture` VALUES (89, NULL, 65, 'http://maxerwinsmith.qicp.io:49291/picture/tumugongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (90, NULL, 19, 'http://maxerwinsmith.qicp.io:49291/picture/tushuguan.jpg');
INSERT INTO `picture` VALUES (91, NULL, 19, 'http://maxerwinsmith.qicp.io:49291/picture/tushuguan2.jpg');
INSERT INTO `picture` VALUES (92, NULL, 76, 'http://maxerwinsmith.qicp.io:49291/picture/waiyuxueyuan.jpg');
INSERT INTO `picture` VALUES (93, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/wangputing.jpg');
INSERT INTO `picture` VALUES (94, NULL, 27, 'http://maxerwinsmith.qicp.io:49291/picture/wending.jpg');
INSERT INTO `picture` VALUES (95, NULL, 77, 'http://maxerwinsmith.qicp.io:49291/picture/wenxueyuan.jpg');
INSERT INTO `picture` VALUES (96, NULL, 66, 'http://maxerwinsmith.qicp.io:49291/picture/wuligongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (97, NULL, 20, 'http://maxerwinsmith.qicp.io:49291/picture/wuxingguangchang.jpg');
INSERT INTO `picture` VALUES (98, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/xingtanhuailin.jpg');
INSERT INTO `picture` VALUES (99, NULL, 13, 'http://maxerwinsmith.qicp.io:49291/picture/xingzhenglou.jpg');
INSERT INTO `picture` VALUES (100, NULL, 78, 'http://maxerwinsmith.qicp.io:49291/picture/xinwenyuchuanboxueyuan.jpg');
INSERT INTO `picture` VALUES (101, NULL, 87, 'http://maxerwinsmith.qicp.io:49291/picture/xinxigongchengxueyuan.jpg');
INSERT INTO `picture` VALUES (102, NULL, 79, 'http://maxerwinsmith.qicp.io:49291/picture/xinxiguanlixueyuan.jpg');
INSERT INTO `picture` VALUES (103, NULL, 83, 'http://maxerwinsmith.qicp.io:49291/picture/yaoxueyuan.jpg');
INSERT INTO `picture` VALUES (104, NULL, 34, 'http://maxerwinsmith.qicp.io:49291/picture/yinghualin.jpg');
INSERT INTO `picture` VALUES (105, NULL, 25, 'http://maxerwinsmith.qicp.io:49291/picture/yingyuetan.jpg');
INSERT INTO `picture` VALUES (106, NULL, 21, 'http://maxerwinsmith.qicp.io:49291/picture/yuanheguangchang.jpg');
INSERT INTO `picture` VALUES (107, NULL, 42, 'http://maxerwinsmith.qicp.io:49291/picture/zhengweiju.jpg');
INSERT INTO `picture` VALUES (108, NULL, 42, 'http://maxerwinsmith.qicp.io:49291/picture/zhengweiju2.jpg');
INSERT INTO `picture` VALUES (109, NULL, 22, 'http://maxerwinsmith.qicp.io:49291/picture/zhengzhoudaxuexiaoyiyuan.jpg');
INSERT INTO `picture` VALUES (110, NULL, 22, 'http://maxerwinsmith.qicp.io:49291/picture/zhengzhoudaxuexiaoyiyuan2.jpg');
INSERT INTO `picture` VALUES (111, NULL, 23, 'http://maxerwinsmith.qicp.io:49291/picture/zhonglou.jpg');
INSERT INTO `picture` VALUES (112, NULL, 59, 'http://maxerwinsmith.qicp.io:49291/picture/jixiegongchengxueyuan.jpeg');
INSERT INTO `picture` VALUES (113, NULL, 70, 'http://maxerwinsmith.qicp.io:49291/picture/lishixueyuan.jpeg');
INSERT INTO `picture` VALUES (114, NULL, 64, 'http://maxerwinsmith.qicp.io:49291/picture/shuiliyuhuanjingxueyuan.jpeg');
INSERT INTO `picture` VALUES (115, NULL, 63, 'http://maxerwinsmith.qicp.io:49291/picture/shuxueyutongjixueyuan.jpeg');
INSERT INTO `picture` VALUES (116, NULL, 66, 'http://maxerwinsmith.qicp.io:49291/picture/wuligongchengxueyuan.jpeg');
INSERT INTO `picture` VALUES (117, NULL, 78, 'http://maxerwinsmith.qicp.io:49291/picture/xinwenyuchuanboxueyuan.jpeg');
INSERT INTO `picture` VALUES (118, NULL, 15, 'http://maxerwinsmith.qicp.io:49291/picture/hexinjiaoxuequ.jpg');

-- ----------------------------
-- Table structure for scenic_area
-- ----------------------------
DROP TABLE IF EXISTS `scenic_area`;
CREATE TABLE `scenic_area`  (
  `scenic_area_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键，方便插入',
  `scenic_area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '景区名称，如“郑州大学”',
  `scenic_area_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景区的介绍',
  `scenic_area_longitude` float(50, 10) NOT NULL COMMENT '景区的经度',
  `scenic_area_dimension` float(50, 10) NOT NULL COMMENT '景区的纬度',
  `scenic_area_score` float(50, 0) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '景区的总评分',
  PRIMARY KEY (`scenic_area_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_area
-- ----------------------------
INSERT INTO `scenic_area` VALUES (1, '郑州大学', '学校', 113.5297164917, 34.8181953430, 00000000000000000000000000000000000000000000000005);

-- ----------------------------
-- Table structure for scenic_spot
-- ----------------------------
DROP TABLE IF EXISTS `scenic_spot`;
CREATE TABLE `scenic_spot`  (
  `scenic_spot_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '景点ID，自增主键',
  `scenic_spot_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点名称，如“郑州大学图书馆”',
  `scenic_spot_introduce` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点的介绍',
  `scenic_spot_longitude` float(50, 10) NOT NULL COMMENT '景点的经度',
  `scenic_spot_dimension` float(50, 10) NOT NULL COMMENT '景点的纬度',
  `scenic_spot_score` float(6, 0) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '景点的评分',
  `scenic_spot_comment_num` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '景点的评论人数',
  `scenic_spot_starttime` time(0) NULL DEFAULT NULL COMMENT '景点每天的起始开放时间',
  `scenic_spot_endtime` time(0) NULL DEFAULT NULL COMMENT '景点每天的关闭时间',
  `scenic_area_id` int(11) NULL DEFAULT NULL COMMENT '外键，关联scenic_area表的主键',
  `scenic_spot_num` int(10) UNSIGNED ZEROFILL NULL DEFAULT 0000000000 COMMENT '景点热力值',
  PRIMARY KEY (`scenic_spot_id`) USING BTREE,
  UNIQUE INDEX `scenic_spot_id`(`scenic_spot_id`, `scenic_spot_name`) USING BTREE,
  INDEX `scenic_spot_area`(`scenic_area_id`) USING BTREE,
  CONSTRAINT `scenic_spot_area` FOREIGN KEY (`scenic_area_id`) REFERENCES `scenic_area` (`scenic_area_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_spot
-- ----------------------------
INSERT INTO `scenic_spot` VALUES (2, '泊月路', '此二路系南北对应的两条“双向绿色对话走廊”，各自中间为40米宽的绿化带，看上去如同亭亭碧云，静静溪月，动人无限遐思；这两条长廊又是学生户外活动的基地，校园文化展示的舞台；②此二路在功能上为步行路，供人散步、止息，月、云与人构成互相映衬，诗意盎然的情景效果；③“泊”有停靠、安静、聚储等涵义；“亭”有停留、平静、和谐、高洁、耸立等涵义。既照顾到此二路的外观形象、休闲特色，有富于想像和寓意；④二路的中段，南临湖，北依山，湖中映月，山上浮云，既符合位置特点，有互相烘托氛围、构成景观，相得益彰；⑤“泊月”、“亭云”寓意新郑大及其人才将在科学上达到最高境界；⑥“泊月”、“亭云”在语义上轻松、灵动，可以调节整个传统文化系统带来的凝重，符合“一张一弛，文武之道”。', 113.5356674194, 34.8129119873, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (3, '亭云路', '此二路系南北对应的两条“双向绿色对话走廊”，各自中间为40米宽的绿化带，看上去如同亭亭碧云，静静溪月，动人无限遐思；这两条长廊又是学生户外活动的基地，校园文化展示的舞台；②此二路在功能上为步行路，供人散步、止息，月、云与人构成互相映衬，诗意盎然的情景效果；③“泊”有停靠、安静、聚储等涵义；“亭”有停留、平静、和谐、高洁、耸立等涵义。既照顾到此二路的外观形象、休闲特色，有富于想像和寓意；④二路的中段，南临湖，北依山，湖中映月，山上浮云，既符合位置特点，有互相烘托氛围、构成景观，相得益彰；⑤“泊月”、“亭云”寓意新郑大及其人才将在科学上达到最高境界；⑥“泊月”、“亭云”在语义上轻松、灵动，可以调节整个传统文化系统带来的凝重，符合“一张一弛，文武之道”。', 113.5361175537, 34.8213424683, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (4, '春华路', '春华路、秋实路（最南和最北2条对称的东西走向的路）解释：①春华秋实本为一词，指花木生长规律，多用来比喻事业、学业发展规律，同时也含有祝愿和期待；②春为阳秋为阴，南为阳北为阴，这两条路南北对称，用春华秋实命名代表阴阳和谐；③南门纳才，北门输才，春华秋实符合教育规律；④两条路的一端都连接着生活园区，与园区命名和谐呼应；⑤郑州大学要建设一流的高校，培养一流的人才，用春华秋实命名代表郑州大学人才培养和学校建设蒸蒸日上。', 113.5356063843, 34.8103752136, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (5, '秋实路', '春华路、秋实路（最南和最北2条对称的东西走向的路）解释：①春华秋实本为一词，指花木生长规律，多用来比喻事业、学业发展规律，同时也含有祝愿和期待；②春为阳秋为阴，南为阳北为阴，这两条路南北对称，用春华秋实命名代表阴阳和谐；③南门纳才，北门输才，春华秋实符合教育规律；④两条路的一端都连接着生活园区，与园区命名和谐呼应；⑤郑州大学要建设一流的高校，培养一流的人才，用春华秋实命名代表郑州大学人才培养和学校建设蒸蒸日上。', 113.5363006592, 34.8234634399, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (6, '湖滨路', '湖滨路，处于学校中心地带，路西边滨临学校核心景观湖，故名，自然好记；②处于学校中心地带，路西边滨临学校核心景观湖，故名，自然好记；②路东边随弧形核心教学区楼群呈“弯弧”形状的道路。', 113.5347595215, 34.8175354004, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (7, '仁和大道', '①从构图上看，它是厚德大道和天健大道的交汇合一，共同构成“人”字形，“仁”通“人”；②在中国文化里，乾、坤象征“天”、“地”，中间为“人，”共同构成“三才，”“人”具有中心地位，秉天地之气，为天地之心；③“和”既有汇合之义，又有中和、和谐、和气之义，与东侧的医学院旁边相合；④“人”也可理解为“仁”，表示互相爱护、互相理解、互相支持，与东侧的医学院旁边相合；⑤“和”与“活”义通，与医学院和实习医院相合；⑥此路通北门，为出口，含有祝福亲友和睦、勉励事业成功之意；⑦此路与南端综合管理中心遥相呼应，有祝福、勉励新郑大在行政管理方面得天时、地利、人和；⑧此路与天健、厚德为一体，故也称大道。（*说明：整个新校区仅此三条“大道”，其余皆为“路”）。', 113.5360031128, 34.8251724243, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (8, '天健大道', '两条南北主干大道：东边：天健大道西边：厚德大道解释：1、这两条大道为居新校区中心纵轴两侧对称。宽阔、贯通南北，支撑校园整体，条大道两端逐渐向一起靠拢，构成相互呼应，和谐关系。2、天健、厚德，构成中国人文的两个基本要素就是：“阴-阳”，其代表和象征就是：“乾-坤”，二者和谐，意味着合理、健康、吉祥、发展。这两条大道就象征着“乾-坤”。既是“天人合一”的基本主题和构成。有又皆元亨利贞，大吉大利。3、“天健”代表“乾”：《易·乾·象》:”天行健，君子以自强不息。”准确表达了“乾”的涵义：刚强健壮，勤奋向上；4、“厚德”代表“乾”：《易·坤·彖》:”万物资生，乃顺承天。坤厚载物，德合无疆。”《易·乾·象》:”君子以厚德载物。”准确表达了“坤”的涵义：含育万物，兼容并包；5、对郑州大学的师生员工具有勉励和赞誉之意。', 113.5377960205, 34.8176345825, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (9, '厚德大道', '两条南北主干大道：东边：天健大道西边：厚德大道解释：1、这两条大道为居新校区中心纵轴两侧对称。宽阔、贯通南北，支撑校园整体，条大道两端逐渐向一起靠拢，构成相互呼应，和谐关系。2、天健、厚德，构成中国人文的两个基本要素就是：“阴-阳”，其代表和象征就是：“乾-坤”，二者和谐，意味着合理、健康、吉祥、发展。这两条大道就象征着“乾-坤”。既是“天人合一”的基本主题和构成。有又皆元亨利贞，大吉大利。3、“天健”代表“乾”：《易·乾·象》:”天行健，君子以自强不息。”准确表达了“乾”的涵义：刚强健壮，勤奋向上；4、“厚德”代表“乾”：《易·坤·彖》:”万物资生，乃顺承天。坤厚载物，德合无疆。”《易·乾·象》:”君子以厚德载物。”准确表达了“坤”的涵义：含育万物，兼容并包；5、对郑州大学的师生员工具有勉励和赞誉之意。', 113.5339736938, 34.8175735474, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (10, '培英路', '钟灵路、毓秀路（后“钟灵”改为“培英”，与“毓秀”的谐音“育秀”相对应）解释：①钟灵毓秀本为一词，原指美好的自然环境产生优秀的人物，用此命名一指新郑大环境优美，二指为社会培养出了优秀的人才；②钟是聚集，毓是养育、培育，用此命名喻指郑州大学领导和教职员工人才辈出，并得天下之英才而教育之；③在启明广场和图书馆的两侧，还横穿教学区，对应启明广场的寓意和图书馆及教学区的功能；④与春华、秋实呼应。', 113.5364456177, 34.8162498474, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (11, '毓秀路', '钟灵路、毓秀路（后“钟灵”改为“培英”，与“毓秀”的谐音“育秀”相对应）解释：①钟灵毓秀本为一词，原指美好的自然环境产生优秀的人物，用此命名一指新郑大环境优美，二指为社会培养出了优秀的人才；②钟是聚集，毓是养育、培育，用此命名喻指郑州大学领导和教职员工人才辈出，并得天下之英才而教育之；③在启明广场和图书馆的两侧，还横穿教学区，对应启明广场的寓意和图书馆及教学区的功能；④与春华、秋实呼应。', 113.5365371704, 34.8180313110, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (12, '大学生活动中心', '郑州大学行政中心', 113.5316925049, 34.8217735291, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (13, '行政楼', '郑州大学行政楼，即综合管理中心。郑州大学新校区综合管理中心工程建筑类型为一类高层，设计等级为一级，占地面积为10400㎡，建筑面积42000㎡，八层框架，建筑高度29.4m，包括行政楼、会议中心及职工休闲健身和360人办报告厅等各种功能性用房。该项目已于2005年完工投入使用，获得国家优质工程银质奖', 113.5356674194, 34.8111419678, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (14, '教学区南区', '郑州大学核心教学区，设计于2001年5月，2003年10月竣工。坐落于郑州大学中央，依傍秀丽眉湖、紧靠图书馆、理科园、文科园，地理位置优越，彰显了核心教学区的重要地位。郑州大学核心教学楼群是校园内每天最大量师生、最频繁使用的区域，起到了联系起校园各种活动的作用。因此，核心区不单是从地理位置上、更是从形象与功能上成为真正的核心区——大学生活的核心区域。可以想象，每天，数以万计的郑大学子从这里进进出出、学习知识、接受教诲、交流思想、碰撞火花。郑州大学核心教学区，实乃郑大灵魂之所在。曾经荣获：2006年度国家优质工程银质奖；2005年度教育部校园建筑设计二等奖；2005年度教育部勘察设计建筑设计二等奖；2005年河南省勘查设计创新奖一等奖2005年中国机械工业集团科学技术奖三等奖；2005年第九届机械工业优秀工程设计奖二等奖。', 113.5363998413, 34.8156013489, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (15, '教学区北区', '郑州大学核心教学区，设计于2001年5月，2003年10月竣工。坐落于郑州大学中央，依傍秀丽眉湖、紧靠图书馆、理科园、文科园，地理位置优越，彰显了核心教学区的重要地位。郑州大学核心教学楼群是校园内每天最大量师生、最频繁使用的区域，起到了联系起校园各种活动的作用。因此，核心区不单是从地理位置上、更是从形象与功能上成为真正的核心区——大学生活的核心区域。可以想象，每天，数以万计的郑大学子从这里进进出出、学习知识、接受教诲、交流思想、碰撞火花。郑州大学核心教学区，实乃郑大灵魂之所在。曾经荣获：2006年度国家优质工程银质奖；2005年度教育部校园建筑设计二等奖；2005年度教育部勘察设计建筑设计二等奖；2005年河南省勘查设计创新奖一等奖2005年中国机械工业集团科学技术奖三等奖；2005年第九届机械工业优秀工程设计奖二等奖。', 113.5365600586, 34.8188438416, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (16, '菊园快递收发中心', '郑州大学快递中心', 113.5334396362, 34.8205871582, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (17, '启明广场', '用于升国旗，举行重大仪式。', 113.5406417847, 34.8167800903, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (18, '体育馆', '郑州大学有北体育馆、中心体育馆以及南体育馆，占地面积大，可容纳五千至六千人。其中中心体育馆是很多大型活动的场所，比如比赛、演出等。中心体育场又名“本源体育场”。2017年4月13日上午郑州大学举行“本源体育场”名牌揭幕仪式，我校外语学院1976级杰出校友、建业集团董事长胡葆森，众多校领导出席。党委办公室、校长办公室、对外联络办公室（校友总会办公室）、外语学院、体育学院、音乐学院等部门负责同志以及师生代表500余人参加了揭幕仪式。校长刘炯天院士首先致辞，他代表全校师生对胡葆森校友表示感谢，对“本源体育场”名牌揭幕表示祝贺。他指出，胡葆森校友心系母校发展，向母校捐赠1亿元并设立“本源教育发展基金”，助力学校一流大学建设。为感谢胡葆森校友捐资助学的义举，也为了感谢胡葆森校友对河南体育事业发展做出的贡献，学校将主校区中心体育场命名为“本源体育场”。胡葆森校友说，“本源”意思是正本清源、追本溯源，要不忘初心，不忘我们是郑大人。他表示，感谢时代赋予的创业机会，感谢母校给予的知识和“闯荡世界”的本领，祝愿母校越来越强大，祝愿越来越多的郑大校友毕业后为河南省、为国家建设做出更大的贡献。', 113.5323486328, 34.8174133301, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (19, '图书馆', '郑州大学文教象征。', 113.5387191772, 34.8171348572, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (20, '五星广场', NULL, 113.5355911255, 34.8090248108, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (21, '元和广场', '1、元为首、头、中心、首脑之意，而这个广场又处于学校中心，居于突出首要的中心地位，故名；2、整个校区的命名和谐，天象对应，天人对应，阴阳对应，故名；3、和有和平之意。是发展的前提和保障。寓含此意。', 113.5371246338, 34.8171005249, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (22, '郑州大学校医院', '郑州大学医院，是一所综合性二级医院。医院设有内科、外科、急诊科、妇科、耳鼻喉科、眼科、口腔科、皮肤科、中医康复科、保健科等临床科室。医技科室有药剂科、放射科、检验科、B超室、心电图室等。', 113.5385589600, 34.8263397217, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (23, '钟楼', '这里有着郑大的“第一高度”，56米的钟楼象征来自五湖四海郑大人的团结和凝聚。它默然而立，让人对“晨钟暮鼓”有着无限的遐想和期待，而伴着朝阳和晚霞在这里读书的一个个身影也成了郑大校园里最美的风景，是标志性建筑物物之一。每年元旦在广场上举办的迎新年晚会更是每个郑大人的“狂欢节”。在新年零点到来之际，我们登上钟楼，敲响大钟，浑厚而悠远的钟声寄托了每个郑大人对过去一年的深情回味和对美好未来的殷切展望。', 113.5372924805, 34.8172836304, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (24, '博雅湖（眉湖）', '博雅湖(又名“眉湖”)博雅湖，此核心景观湖设计了一系列富有中原特色的人文景观，旨在展现中原文化的博大精深与高雅文明，寄予学子博采众长、雅趣共享。又因其整体外形像眉，故公认为“眉湖”。眉湖是蜿蜒于学校新校区内的一汪清水，如龙之睛，充满灵气。这里堪称郑大最美的景观，从南到北分别由水源广场、亲水栈道、问鼎广场、博弈广场等8个景观区组成，生动地述说着中原文明的璀璨和辉煌，描绘着郑大校园的秀美与内涵。河园中有一船名曰“渡”，暗合教育的本意，即将懵懂之学子“渡”成博学睿智之才。时至今日，郑大这艘船已经“渡”了数万名学子，也必将有越来越多的学子搭乘这艘“渡”船，到达成才的彼岸。', 113.5343551636, 34.8173599243, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (25, '厚山', '“厚山”体现：厚德载物，厚重中原，厚积薄发，笃信仁厚。由于山的位置基本处于学校的最北面、最后面，谐音“后山”。从上而下观此山景，水从山上高处“接星潭”中流出，像瀑布一样沿山石流入“映月潭”，潭水溢满又像瀑布一样流下，汇入“草溪”，山间有“望瀑亭”，山下有“回廊阁”，湖水沿着铺满鹅卵石的河道缓缓向南流，从地下穿过“云亭路”，流入“杏坛槐林”背后的“连廊水池”最终注入“眉湖”。', 113.5360260010, 34.8226013184, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (26, '眉湖九博（河源）', '“河源”此景由涌泉池、浮雕壁和彩陶池底构成，有泉水涌出，取名“河源”，意为大河文化与文明的孕育和起源，浮雕壁和彩陶是仰韶文化的象征。', 113.5347213745, 34.8150863647, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (27, '眉湖九博（问鼎）', '“问鼎”郑州为我国商代遗址，此鼎是郑州张寨出土的商代“乳钉纹铜方鼎”复制品，展现青铜文化，春秋时代“问鼎中原”的观念延续，让人们感受鼎予人的精神震撼。', 113.5348052979, 34.8156394958, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (28, '眉湖九博（博弈）', '“博弈”中国象棋“楚河汉界”源于汉代刘邦、项羽两军对峙两年有余的鸿沟，鸿沟距此地西北15公里处的郑州古荥阳。此象棋残局名曰“达者为先”，鼓励学生勇于取胜。', 113.5347137451, 34.8162155151, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (29, '眉湖九博（禅趣）', '“禅趣”此景点由散落的石雕佛珠和以“渡”命名的舟亭组成，体现郑州少林禅宗文化的澄明、淡泊、超越的意境，教人思量如何渡好人生。', 113.5346527100, 34.8163948059, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (30, '眉湖九博（太和柱，和天烛）', '“太和柱”（“和天烛”）此处位于整个核心景观的中心位置，高耸12米的青铜柱雕塑，飞龙盘绕柱身，顶部造型为蜡烛火苗，体现华夏文明、龙的血脉，生生不息，也寓含教师奉献精神；地面状如涟漪的图形，隐喻中原文化不断向四海传播。', 113.5349044800, 34.8172340393, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (31, '眉湖九博（观星测影）', '“观星测影”此景取材于我国现存最古老的天文台——郑州登封元代天文台，仿石圭、表设置其中，顶部嵌入玻璃雕刻的郑大新校区奠基当天的星象图。取名观星测影，寓意科学探索。', 113.5346603394, 34.8177871704, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (32, '眉湖九博（大道通渠）', '“大道通衢”郑州地处京广和陇海铁路交汇处，此景由铁轨、枕木、压道车嵌砌铺成，体现近现代郑州铁路名城处于四通八达的重要交通枢纽地位。此处也是景观湖自南向北、自北向南水系和反映历史文脉的汇合处。', 113.5349197388, 34.8184509277, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (33, '眉湖九博（凤台荷香）', '“凤台荷香”此景取清代郑州八景之一的“凤台荷香”，遗迹在郑州市凤凰台村。水中种有荷花、芦苇、香蒲等水生植物，岸边一小屋歇息，荷香、书香、茶香弥漫期间，体现自然与人文的和谐。', 113.5348434448, 34.8193893433, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (34, '樱花林', '樱花林“小园新种红樱树，闲绕花枝便当游”，便是描述了樱花盛开的景况。明代于若瀛的诗中提到樱花：“三月雨声细，樱花疑杏花”。樱花花色幽香艳丽，为早春重要的观花树种，常用于园林观赏，以盛开时节花繁艳丽，满树烂漫，如云似霞，极为壮观。可大片栽植造成“花海”景观，可三五成丛点缀于绿地形成锦团，也可孤植，形成“万绿丛中一点红”之画意。', 113.5351867676, 34.8133888245, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (35, '丁老头奶酪（郑大店）', '郑大校园内食堂旁边的小店，团购很划算，环境可以。\r\n【位置】郑大新校区荷园生活区荷园餐厅南侧。招牌挺醒目的。\r\n【环境】店内环境干净整洁。用餐区域略拥挤，用餐高峰期会有等位现象。墙上有五颜六色的留言贴别具校园特色。\r\n【服务】点餐速度快，出餐速度可以接受。待餐食准备完毕后，服务员会叫号，需自行取餐。有外卖服务，由于在学校内，貌似外卖订单还挺多。\r\n【餐食】有各种面食快餐以及乳酪小食。尝试了它家的麻辣爆肚朝鲜面。感觉分量很足，大大的一碗，女生铁定是吃不完的，男生吃了也会很撑。面是细长的面，感觉好像是细米线，爽滑有嚼头。汤汁麻酱味很浓，也够麻辣。配料丰富，有毛肚、血块、豆腐皮、青菜等。整体味道不错。\r\n高新区郑州大学新校区荷园二餐厅中国电信西20米', 113.5304412842, 34.8149185181, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (36, '京东便利店（原校园风超市）', '百万京东便利店，郑州第一家京东线下便利店，也是郑州大学唯一的一家！我们的使命：让大学生轻松购物，快乐生活！让伙伴们人生幸福，开心工作！我们的愿景：打造大学生最贴心的学习、生活、就业平台！\r\n高新技术开发区科学大道100号郑州大学新校区荷园23号楼1楼\r\n13598016173', 113.5358047485, 34.8173217773, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (37, '蜜雪冰城（荷园商业街南侧）', '蜜雪冰城各种饮品种类齐全，价格适中。服务也不错，可以刷校园卡，买单方便。另外，还有照片免费打印机，附近的小伙伴在盛夏来临之际，快来和冰淇淋和冰饮来个浪漫邂逅吧！\r\n营业时间： 周一至周日 07:00-23:00\r\n科学大道100号厚德大道与泊月路交叉口南90米路西\r\n13613841123', 113.5337142944, 34.8138198853, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (38, '沁园春超市', '沁春园超市算是校园最大的超市了，货物齐全，也有各种河南特产。', 113.5339355469, 34.8128242493, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (39, '匆匆那年餐厅', '2017年8月30日，郑州大学荷园一餐厅二楼经过一个暑假的重新装修，拥有了文艺气息“爆棚”的高颜值，华丽变身“别人家的食堂”，餐厅承包方透露，重新装修花费了六百多万元。升级改造后的这处餐厅定名为“匆匆那年”，漆黄透亮的木地板、柔和的暖调灯光，在第一天开业就迎来了众多前来一探究竟的师生。。', 113.5304412842, 34.8149185181, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (40, '荷园二餐厅', '荷园二餐厅', 113.5306625366, 34.8151016235, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (41, '荷园一餐厅', '荷园一餐厅', 113.5306015015, 34.8140106201, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (42, '正味居', '正味居', 113.5306625366, 34.8151016235, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (43, '菊园秋穗园餐厅', '菊园秋穗园餐厅', 113.5314941406, 34.8207283020, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (44, '柳园风华园餐厅', '柳园风华园餐厅', 113.5303955078, 34.8129920959, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (45, '柳园聚英园餐厅', '柳园聚英园餐厅', 113.5306930542, 34.8117408752, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (46, '柳园清真餐厅', '柳园清真餐厅', 113.5306167603, 34.8119544983, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (47, '柳园同和昌食府餐厅', '柳园同和昌食府餐厅', 113.5306854248, 34.8114776611, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (48, '松园竞舸园餐厅', '松园竞舸园餐厅', 113.5318069458, 34.8225593567, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (49, '松园嵩阳食府餐厅', '松园嵩阳食府餐厅', 113.5314407349, 34.8228988647, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (50, '荷园宿舍区', '荷园宿舍区', 113.5303878784, 34.8140144348, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (51, '菊园宿舍区', '菊园宿舍区', 113.5323562622, 34.8205566406, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (52, '柳园宿舍区', '柳园宿舍区', 113.5338668823, 34.8110771179, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (53, '松园宿舍区', '松园宿舍区', 113.5329666138, 34.8225860596, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (54, '材料科学与工程学院', '材料科学与工程学院', 113.5379943848, 34.8144989014, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (55, '电气工程学院', '电气工程学院', 113.5388259888, 34.8107757568, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (56, '管理工程学院', '管理工程学院', 113.5393829346, 34.8145256042, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (57, '化学与能源学院', '化学与能源学院', 113.5403671265, 34.8125686646, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (58, '化学与分子工程学院', '化学与分子工程学院', 113.5392150879, 34.8146171570, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (59, '机械工程学院', '机械工程学院', 113.5403442383, 34.8106918335, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (60, '建筑学院', '建筑学院', 113.5404663086, 34.8117103577, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (61, '力学与工程学院', '力学与工程学院', 113.5378952026, 34.8108329773, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (62, '生命科学学院', '生命科学学院', 113.5386199951, 34.8158607483, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (63, '数学与统计学院', '数学与统计学院', 113.5380630493, 34.8148651123, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (64, '水利与环境学院', '水利与环境学院', 113.5388183594, 34.8133506775, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (65, '土木工程学院', '土木工程学院', 113.5406570435, 34.8112220764, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (66, '物理工程学院', '物理工程学院', 113.5387954712, 34.8149414062, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (67, '法学院（知识产权学院）', '法学院（知识产权学院）', 113.5407257080, 34.8189430237, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (68, '公共管理学院', '公共管理学院', 113.5404663086, 34.8184318542, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (69, '教育学院', '教育学院', 113.5403594971, 34.8192749023, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (70, '历史学院', '历史学院', 113.5384521484, 34.8185729980, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (71, '旅游管理学院', '旅游管理学院', 113.5403366089, 34.8182106018, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (72, '马克思主义学院', '马克思主义学院', 113.5406341553, 34.8192710876, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (73, '美术学院', '美术学院', 113.5389251709, 34.8192558289, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (74, '商学院', '商学院', 113.5395965576, 34.8181571960, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (75, '体育学院（校本部）', '体育学院（校本部）', 113.5324020386, 34.8174018860, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (76, '外语学院', '外语学院', 113.5357513428, 34.8176803589, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (77, '文学院', '文学院', 113.5387573242, 34.8181724548, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (78, '新闻与传播学院', '新闻与传播学院', 113.5387878418, 34.8181648254, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (79, '信息管理学院', '信息管理学院', 113.5401535034, 34.8182258606, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (80, '公共卫生学院', '公共卫生学院', 113.5380325317, 34.8239173889, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (81, '护理学院', '护理学院', 113.5352096558, 34.8061332703, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (82, '基础医学院', '基础医学院', 113.5372619629, 34.8243904114, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (83, '药学院', '药学院', 113.5390930176, 34.8238677979, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (84, '产业技术研究院（大学科技园）', '郑州大学产业技术研究院是郑州大学根据学校向研究型大学转型的需要而成立的集学科建设、科学研究与研究生培养为一体的科研机构。研究院架构在信息工程学院、电气工程学院、智慧城市研究院和软件技术学院之上，以建设优势特色学科为抓手，培养高层次人才为使命，是郑州大学电气信息类学科的科学研究和高层次人才培养的平台。\r\n\r\n研究院共拥有信息与通信工程、软件工程、控制科学与工程三个博士后流动站和一级学科博士学位授权点，通信工程、软件工程、控制科学与工程、电子科学技术、计算机科学与技术和电气工程6个硕士学位授权点以及专业学位授权点。另有一批学科为省级重点建设学科。师资力量雄厚，拥有一支学科结构合理、富有学术活力的教学科研队伍，现有教授64人，其中博士生导师20人，具有博士学位的教师113人，河南省“百人计划”1人。\r\n\r\n研究院打破了原有的院系壁垒，统筹负责原电气工程学院、信息工程学院、软件技术学院和智慧城市研究院等相关学院的学科、科研和研究生培养工作。本着建立更宽广、更交叉和更前沿的大学科平台的原则，采用宽口径人才培养的模式，通过各学科的交叉、 渗透、 互补、综合等实现新的学科增长点，集中优势，外引内联，推动人才培养和学科发展，为培养复合型人才、 建设优势特色学科，提高科研的层次和水平、服务学校转型发展做出贡献。\r\n\r\n0371-67739611', 113.5377273560, 34.8120346069, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (85, '国际教育学院', '郑州大学国际教育学院是郑州大学内设的一所集外国留学生教育、汉语国际教育人才培养、中外合作办学、国际教育文化交流等多项功能于一身的综合性教育管理机构。国际教育学院于2004年初开始筹备，2005年10月经学校批准正式挂牌成立。\r\n\r\n国际教育学院的主要职责和任务是：负责外国留学生、华侨及港澳台学生的招生、涉外手续办理、注册登记、学籍管理、教学管理、日常生活管理；负责汉语国际教育与推广项目的管理与实施；负责对外合作办学项目的实施以及与国际教育相关的其他工作。学院设有院办公室、海外招生办公室、教务管理办公室、学生事务管理办公室、对外合作项目管理办公室、人事劳资管理办公室、华文教育与孔子学院工作办公室、汉语国际教育系、南校区综合管理办公室。\r\n\r\n郑州大学来华留学生教育起步于1984年，是国内较早接受外国留学生和开展对外汉语教学的高校之一，是河南省唯一接受中国政府奖学金来华留学生的高校。国际教育学院负责来华留学生中国政府奖学金项目的管理与实施。\r\n\r\n郑州大学设有国务院侨办华文教育基地和河南省汉语国际推广师资培养基地，并与印度韦洛尔科技大学合作建设一所孔子学院，与美国圣玛丽中学合作建设一所孔子课堂。国际教育学院具体负责华文教育项目、汉语国际推广师资培养项目和孔子学院（课堂）项目的管理与实施。\r\n\r\n国际教育学院积极开展广泛深入的国际交流与合作，着力引进国外大学先进的教学内容、教学办法、课程体系和先进的教学管理模式。学院将不断探索新的国际合作办学模式，加强与国外教育机构双向交流与合作，搭建国际化办学新平台，进一步深化各项国际交流合作项目的开展，争取取得更大的成效。\r\n\r\n0371-67780669 ', 113.5322341919, 34.8127403259, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (86, '河南省资源与材料工业技术研究院（以下简称研究院）', '河南省资源与材料工业技术研究院（以下简称研究院）是郑州大学的直属科研机构。作为河南资源与材料产业协同创新中心的运行载体，研究院的发展目标是：以河南资源与材料产业转型发展的重大需求为导向，以绿色选冶与材料加工为技术主线，致力于突破资源选冶融合开发、绿色冶炼与加工、焦煤资源材料化、高端产品制造等战略性关键技术，形成绿色选冶与材料加工技术和知识体系，构建“资源绿色选冶与材料加工”产业发展以及创新人才培养的新模式，推动产业转型，培养“选-冶-材”复合型人才。\r\n\r\n    作为协同创新机制体制改革的试点单位，研究院主要依托中国航天员中心、河南能化集团、中国铝业郑州有色金属研究院有限公司、中钢集团洛阳耐火材料研究院有限公司、郑州磨料磨具磨削研究所有限公司、中国地质科学院郑州矿产综合利用研究所、中国科学院大连化学物理研究所、中国平煤神马集团、郑州机械研究所等科研院所或大型企业共同开展全日制专业学位研究生培养，以期实现近距离培养、零距离就业。\r\n\r\n0371-67739757 ', 113.5377807617, 34.8127021790, NULL, NULL, NULL, NULL, NULL, 0000000000);
INSERT INTO `scenic_spot` VALUES (87, '信息工程学院', '郑州大学最好的学院', 113.5357437134, 34.8165855408, NULL, NULL, NULL, NULL, NULL, 0000000000);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评分表的自增主键',
  `scenic_area_id` int(11) NULL DEFAULT NULL COMMENT '对景区表的关联',
  `scenic_spot_id` int(11) NULL DEFAULT NULL COMMENT '对景点表的关联',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对用户表的关联',
  `score` float NULL DEFAULT NULL COMMENT '用户的评分',
  PRIMARY KEY (`score_id`) USING BTREE,
  INDEX `score_scenic_area`(`scenic_area_id`) USING BTREE,
  INDEX `score_scenic_spot`(`scenic_spot_id`) USING BTREE,
  INDEX `score_area`(`user_email`) USING BTREE,
  CONSTRAINT `score_area` FOREIGN KEY (`user_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_scenic_area` FOREIGN KEY (`scenic_area_id`) REFERENCES `scenic_area` (`scenic_area_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_scenic_spot` FOREIGN KEY (`scenic_spot_id`) REFERENCES `scenic_spot` (`scenic_spot_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户的邮箱地址，唯一主键',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456789' COMMENT '用户的密码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的昵称',
  `user_picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像的URL相对地址',
  `user_sex` int(11) NULL DEFAULT NULL,
  `user_birthday` date NULL DEFAULT NULL,
  PRIMARY KEY (`user_email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2271366490@qq.com', '123456', '孟磊', '2', 0, '1997-08-20');
INSERT INTO `user` VALUES ('912828340@qq.com', '3', '无名之人', '1', 0, '1997-02-05');
INSERT INTO `user` VALUES ('maxthingsareright@gmail.com', '123456', 'maxthingsareright@gmail.com', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('mengleizzu@163.com', '123456', '张杰', '2', 1, '2018-01-01');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `video_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '视频的自增主键',
  `scenic_area_id` int(11) NULL DEFAULT NULL COMMENT '若为景点介绍，为null',
  `scenic_spot_id` int(11) NULL DEFAULT NULL COMMENT '若为景区介绍，为null',
  `video_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频的相对URI路径',
  PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `use_emailAddress_Name`;
delimiter ;;
CREATE TRIGGER `use_emailAddress_Name` BEFORE INSERT ON `user` FOR EACH ROW SET NEW.user_name = NEW.user_email
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
