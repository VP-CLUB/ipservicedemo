CREATE DATABASE vp_common_config DEFAULT CHARSET=utf8;
USE vp_common_config;
#create user
CREATE user kfman@'localhost' IDENTIFIED BY 'ipservice!';
#grant user
grant all privileges on vp_common_config.* to ipservice@'%' identified by 'ipservice.dev' ;

CREATE TABLE `app_config` (
  `app_info_id` varchar(36) NOT NULL COMMENT '应用系统ID',
  `app_id` bigint(20) NOT NULL COMMENT '应用系统编号(appId)',
  `service_type` int(1) NOT NULL COMMENT '接口类型(0:用户; 1:用户等级; 2:物料; 3:短信; 4;快递; 5:支付)',
  `service_type_name` varchar(50) DEFAULT NULL COMMENT '接口类型名称',
  `service_secret_key` varchar(36) DEFAULT NULL COMMENT '接口服务私钥',
  `call_url` varchar(500) DEFAULT NULL COMMENT '接口访问URL',
  `callback_url` varchar(500) DEFAULT NULL COMMENT '接口回调URL',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`app_info_id`,`service_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应用系统接口服务配置信息'

CREATE TABLE `app_info` (
  `id` varchar(36) NOT NULL COMMENT '应用系统id',
  `app_id` bigint(20) NOT NULL COMMENT '应用系统编号(appId)',
  `parent_app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父应用系统编号',
  `app_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '应用系统名称',
  `app_secret_key` varchar(36) DEFAULT NULL COMMENT '应用系统私钥',
  `create_by` varchar(36) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(36) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记(0:正常; 1:删除; 2:审核)',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应用系统信息'

CREATE TABLE `app_service_type` (
  `id` varchar(36) NOT NULL COMMENT '应用系统接口类型id',
  `service_type` int(4) NOT NULL COMMENT '应用系统接口类型',
  `service_type_name` varchar(50) NOT NULL COMMENT '应用系统接口类型名称',
  `del_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记(0:正常; 1:删除; 2:审核)',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_service_type` (`service_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应用系统接口类型表'

CREATE TABLE `sequences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seqtype` int(11) NOT NULL COMMENT '序列类型1：订单  2：机构',
  `currentno` bigint(20) NOT NULL DEFAULT '0' COMMENT '当前序列号',
  `digit` int(11) NOT NULL COMMENT '位数',
  `number_prefix` int(11) NOT NULL COMMENT '首位数字',
  `countnum` int(11) NOT NULL COMMENT '当前序列计数',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='序列生成表'

USE vp_common_config;
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('1899833e5fbf4dfba27a37e13cb5f932', 100000054, 0, '用户登录授权信息', '', 'http://172.16.46.2:7153/api/1.0/storeserver/store/ValidToken', '', '河北移动验证token');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('1899833e5fbf4dfba27a37e13cb5f932', 100000054, 3, '短信', 'VpClub_hbydwd', 'http://h5.coupon.vpclub.cn:9430/sms/smsUtil/sendSms', 'http://h5.coupon.vpclub.cn:9430/sms/smsUtil/checkSms', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 0, '用户登录授权信息', '1234567891234567', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/LoginPermission', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 2, '物料信息', null, 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/SpeedProductInfo', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 3, null, null, 'http://test.h5.coupon.vpclub.cn:9430/sms/smsUtil/sendSms', 'http://test.h5.coupon.vpclub.cn:9430/sms/smsUtil/checkSms', '和小宝O2O应用短信接口');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 5, null, '6E30847A1E96BF2C', 'http://test.api.supay.vpclub.cn:9310/payment/pay', 'http://test.api.supay.vpclub.cn:9550/couponOrder/order/callback', '和小宝O2O应用系统的支付接口');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 8, '用户地址列表查询', '1234567891234567', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/SearchAddress', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/SearchAddressById', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 9, '用户地址编辑', '1234567891234567', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/AddOrEditUserAddress', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 10, '用户地址删除', '1234567891234567', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/DelUserAddress', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 11, '订单生成', '1234567891234567', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/SpeedCommitOrder', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 13, '登录信息', '1234567891234567', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/login', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 14, '注册和发送验证码信息', '1234567891234567', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/register', 'http://test.hxbapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/sendsms', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9655', 100000034, 7, '快递公司信息', '', 'http://112.74.129.95:8063/api/Express/GainExpressCompanyInfo', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 0, '用户信息', 'bcd4f31bbcd4f31b', 'http://172.16.0.132:8008/api/1.0/SpeedTreasureServer/SpeedTreasure/SpeedLoginPermission', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 2, null, null, 'http://172.16.46.3:7003/api/1.0/ProductServer/Artivities/GainOneActivityProductList', 'http://172.16.46.3:7003/api/1.0/OrderServer/Order/OneActivityCommitOrder', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 3, '短信', 'VpClub_jsdb', 'http://h5.coupon.vpclub.cn:9430/sms/smsUtil/sendSms', 'http://h5.coupon.vpclub.cn:9430/sms/smsUtil/checkSms', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 4, '物流/快递信息', '', 'http://112.74.129.95:8063/api/Express/subscribe', 'http://112.74.129.95:8063/api/Express/QueryExpressInfo', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 5, '支付', '6E30847A1E96BF2C', 'http://172.16.5.31:9310/payment/pay', 'http://172.16.0.155:10180/promotionDraw/order/callback', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 7, '快递公司信息', null, 'http://112.74.129.95:8063/api/Express/GainExpressCompanyInfo', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 8, '用户地址列表查询', null, 'http://172.16.0.155:10180/promotion/address/findAddressList', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 12, '机构物料', null, 'http://172.16.0.156:12140/couponSystem/coupon/testList', '', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 15, '退款', '6E30847A1E96BF2C', 'http://172.16.5.31:9310/payment/refund', '', '退款');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('2f2f4790e8014258960e67257cbb9695', 100000034, 4, '物流/快递信息', '', 'http://112.74.129.95:8063/api/Express/subscribe', 'http://112.74.129.95:8063/api/Express/QueryExpressInfo', '');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('9a83504d443a47ebae8d62caf009155e', 200000018, 5, null, null, 'http://test.api.supay.vpclub.cn/pay', 'http://test.api.supay.vpclub.cn/notify', '新增查询的应用系统支付服务');
INSERT INTO vp_common_config.app_config (app_info_id, app_id, service_type, service_type_name, service_secret_key, call_url, callback_url, remarks) VALUES ('d6605e4daf844f56b333f2d72692fb7a', 100000058, 0, '用户登录授权信息', 'bcd4f31bbcd4f31b', 'http://demogdapi.vpclub.cn/api/1.0/SpeedTreasureServer/SpeedTreasure/SpeedLoginPermission', '', '');

INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('1899833e5fbf4dfba27a37e13cb5f932', 100000054, 0, '河北移动', null, null, '2016-11-04 17:30:59', '1', '2016-11-04 17:30:59', 0, '河北移动');
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('28e663b5d52f424494f3bf8fe280e21d', 100000034, 0, '和小宝O2O应用', '6E30847A1E96BF2C', '1', '2016-07-04 20:54:12', '1', '2016-07-14 16:24:06', 0, '和小宝');
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('2f2f4790e8014258960e61257cbb9695', 200000014, 0, '微品一元购应用', '6E30847A1E96BF2C', '1', '2016-07-11 19:02:22', '1', '2016-07-27 11:30:04', 0, '微品一元购自运营appInfo请勿修改');
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('3ece622173634613b0dd914ddc460c27', 200000051, 0, '新增查询的应用系统主题', null, 'ceshi', '2016-11-02 12:47:17', null, '2016-11-02 12:47:17', 0, null);
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('3f429da418de4998b250a54400814c8e', 20000105, 0, '应用系统主题', null, 'ceshi', '2016-10-25 15:15:01', null, '2016-10-25 15:15:01', 0, null);
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('9a83504d443a47ebae8d62caf009155e', 200000018, 0, '梳理配置信息系统', null, 'ceshi', '2016-07-25 18:22:16', '1', '2016-07-29 14:54:46', 0, '');
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('b6a7dec2c82040519174f1ceda73026a', 200000047, 0, '新增查询的应用系统主题', null, 'ceshi', '2016-10-25 15:15:01', null, '2016-10-25 15:15:01', 0, null);
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('d333f8c979dc4b74ab9f186e75dd5e18', 200000049, 0, '新增查询的应用系统主题', null, 'ceshi', '2016-10-25 15:17:55', null, '2016-10-25 15:17:55', 0, null);
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('d6605e4daf844f56b333f2d72692fb7a', 100000058, 0, '岭南优品', null, null, '2016-08-03 11:01:41', '1', '2016-08-03 11:42:19', 0, '岭南优品');
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('d8c628884cb44508a418ef1f419c57e4', 200000053, 0, '新增查询的应用系统主题', null, 'ceshi', '2016-11-04 11:49:05', null, '2016-11-04 11:49:05', 0, null);
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('ef4ca1dc5c444c6f817a338fa01413da', 20000105, 0, '应用系统主题', null, 'ceshi', '2016-10-25 15:17:55', null, '2016-10-25 15:17:55', 0, null);
INSERT INTO vp_common_config.app_info (id, app_id, parent_app_id, app_name, app_secret_key, create_by, create_date, update_by, update_date, del_flag, remarks) VALUES ('f80b191fcd6846e1acea7e5d11b278c5', 200000055, 0, '新增查询的应用系统主题', null, 'ceshi', '2016-11-04 11:50:01', null, '2016-11-04 11:50:01', 0, null);

INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('450301035829434a897f17dfa4b4ab15', 2, '物料信息', 0, '物料信息');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('4bcb5dba0ad24c6fac968f011f8c136d', 6, '快递查询', 0, '快递查询');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('4dd0d46d7fe443bc98a3b645ee64e608', 11, '订单生成', 0, '订单生成');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('53f31733773345538dfe55c378cfdba8', 9, '用户地址编辑', 0, '用户地址编辑');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('59f138753ff54066a922c56cd35d6a0a', 5, '支付', 0, '支付');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('5b304306715341fcb88239224c599d38', 0, '用户登录授权信息', 0, '用户登录授权信息');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('63e47f2c7f924535b311ee2eee55cdf7', 8, '用户地址列表查询', 0, '用户地址列表查询');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('7ce65f1a29fb476c811bbcfc8ca71b0c', 7, '快递公司信息', 0, '快递公司信息');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('91c132830d384ce9af131f542f2d35fc', 4, '物流/快递信息', 0, '物流/快递信息');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('9deb4f7d4a824667b532680f1905b7ca', 12, '机构物料', 0, '');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('9ec7c960c1a24ada9767268de2a7e1bd', 15, '退款', 0, '退款');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('bbc1019a88884f748678d6f50106c76c', 13, '登录信息', 0, '登录信息');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('be7e93a5d97b4a30ab213e9c89a007eb', 1, '用户等级信息', 0, '用户等级信息');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('c559529cff504d45beb5ff11a33b19e3', 14, '注册和发送验证码信息', 0, '');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('cda85fe069874e91a3eaceb71965cf8f', 10, '用户地址删除', 0, '用户地址删除');
INSERT INTO vp_common_config.app_service_type (id, service_type, service_type_name, del_flag, remarks) VALUES ('d5c1c59f339e45aa84e4753344745a1f', 3, '短信', 0, '短信');

INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (1, 3151, 1000, 1, 2151, '订单序列');
INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (2, 100072, 100000, 1, 72, '机构id');
INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (3, 200000061, 100000000, 2, 61, 'appid');
INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (4, 1016, 1000, 1, 16, ' 签约序列');
INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (5, 2893, 1000, 1, 1893, '订单明细序列');
INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (6, 1021, 1000, 1, 21, '广告id');
INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (7, 3280, 1000, 1, 2280, 'O2O订单序列');
INSERT INTO vp_common_config.sequences (seqtype, currentno, digit, number_prefix, countnum, remark) VALUES (8, 2205, 1000, 1, 1205, 'O2O券码序列');