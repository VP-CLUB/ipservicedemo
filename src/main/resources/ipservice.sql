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