CREATE TABLE `temp_cfg_redis` (
  `ID` varchar(19) NOT NULL COMMENT 'ID主键',
  `REDIS_TYPE` varchar(100) DEFAULT NULL COMMENT '缓存类型',
  `REDIS_IP` varchar(2) DEFAULT NULL COMMENT 'IP地址',
  `REDIS_PORT` varchar(800) DEFAULT NULL COMMENT '端口',
  `REDIS_PASSWORD` varchar(3) DEFAULT NULL COMMENT '口令',
  `REDIS_INDEX` varchar(1024) DEFAULT NULL COMMENT '索引',
  `ORDER_NUMBER` int(2) DEFAULT '0' COMMENT '排序',
  `CITY_ID` int(19) DEFAULT '100' COMMENT '城市代码',
  `PLANTFORM_ID` varchar(32) DEFAULT 'cncsen' COMMENT '平台id',
  `OECD_NO` varchar(32) DEFAULT 'cncsen' COMMENT '所属组织编号',
  `STATUS` int(2) DEFAULT '1' COMMENT '状态（1：有用；0：无用）',
  `ENABLE_FLAG` varchar(1) DEFAULT 'Y' COMMENT '软删除标志（有效为Y，删除为N）',
  `CREATE_BY` varchar(16) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(16) DEFAULT NULL COMMENT '最后操作人',
  `LAST_UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARKS` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板生成记录之Redis配置信息';

