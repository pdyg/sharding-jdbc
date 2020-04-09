#mysql   需要新建两个数据库，pdy_0   pdy_1进行数据处理
CREATE TABLE `t_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `pid` varchar(64) NOT NULL DEFAULT '0' COMMENT '父id',
  `type` int(11) DEFAULT NULL COMMENT '1国家2省3市4县区',
  `lit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user0` (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `city_id` int(12) DEFAULT NULL COMMENT '城市',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user1` (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `city_id` int(12) DEFAULT NULL COMMENT '城市',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_merchantid` (
  `id` bigint(20) NOT NULL,
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `type` int(3) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_order_pay0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单支付表ID',
  `merchantId` bigint(20) NOT NULL COMMENT '商家id',
  `orderId` bigint(20) NOT NULL COMMENT '订单ID',
  `payType` int(3) NOT NULL DEFAULT '0' COMMENT '支付类型(0:现金支付、1:储值支付、2:积分抵现、3:银行卡支付、4:积分支付5:其他支付、6微信支付、7电子券支付)',
  `amount` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '支付金额',
  `credits` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '支付积分',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=454954451686391809 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单支付表';

CREATE TABLE `t_order_pay1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单支付表ID',
  `merchantId` bigint(20) NOT NULL COMMENT '商家id',
  `orderId` bigint(20) NOT NULL COMMENT '订单ID',
  `payType` int(3) NOT NULL DEFAULT '0' COMMENT '支付类型(0:现金支付、1:储值支付、2:积分抵现、3:银行卡支付、4:积分支付5:其他支付、6微信支付、7电子券支付)',
  `amount` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '支付金额',
  `credits` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '支付积分',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=454954451254378497 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单支付表';

CREATE TABLE `t_order0` (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `orderType` int(3) NOT NULL DEFAULT '0' COMMENT '类型',
  `merchantId` bigint(20) DEFAULT NULL COMMENT '商家Id',
  `orderAmount` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_order1` (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `orderType` int(3) NOT NULL DEFAULT '0' COMMENT '类型',
  `merchantId` bigint(20) DEFAULT NULL COMMENT '商家Id',
  `orderAmount` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

