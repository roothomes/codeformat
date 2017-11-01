package com.apec.tempcfgmain.constants;



/**
 * 类 编 号：BL_PU10000_10_constants
 * 类 名 称：TempCfgMainContant
 * 内容摘要：业务模型常量类,包含各种常量信息
 * @author roothomes
 * @date 2017-10-30
 */
public interface TempCfgMainContant{

    /**
     * 默认平台ID
     */
    String DEFAULT_PLANTFORM_ID = "cncsen";
    /**
     * 默认组织编码
     */
    String DEFAULT_OECD_NO = "cncsen";
    /**
     * 默认城市ID
     */
    Integer DEFAULT_CITY_ID = 100;
    /**
     * 默认排序
     */
    Integer DEFAULT_ORDER_NUMBER = 0;
    /**
     * 每页最大条数
     */
	Integer MAX_NUMBER_ONE_PAGE = 100;
	/**
     * 每页最大条数
     */
	Integer DEFAULT_NUMBER_ONE_PAGE = 100;
    /**
     * 失效
     */
    String STATUS_INVALID = "0";

    /**
     * 有效
     */
    String STATUS_VALID = "1";


    /** 组织标示符 */
    String DEFAULT_VAL_GROUPID = "com.apec";
    /** 业务标示符 */
    String DEFAULT_VAL_ARTIFACTID = "default";
    /** 模型PoJo的类 */
    String DEFAULT_VAL_MODEL_CLASSNAME = "DefaultClass";
    /** 模型描述 */
    String DEFAULT_VAL_MODEL_CLASSNAME_DESC = "默认描述";
    /** 模型对象序列号 */
    String DEFAULT_VAL_MODEL_CLASS_SERIALNO = "defaultSerialNo";
    /** 创建作者 */
    String DEFAULT_VAL_CREAT_AUTHOR = "roothomes";
    /** 创建时间 */
    String DEFAULT_VAL_CREAT_DATE = "2017-10-31";
    /** 模型对应表所在数据库 */
    String DEFAULT_VAL_DATABASE_NAME = "tempservice";
    /** 模型对应表 */
    String DEFAULT_VAL_TABLE_NAME = "defaulttable";
    /** 不启用缓存 */
    String DEFAULT_VAL_OPEN_CACHE_NO = "no";
    /** 启用缓存 */
    String DEFAULT_VAL_OPEN_CACHE_YES = "yes";
    /** 不启用消息 */
    String DEFAULT_VAL_OPEN_MQ_NO = "no";
    /** 启用消息 */
    String DEFAULT_VAL_OPEN_MQ_YES = "yes";
    /** 缓存Key值前缀 */
    String CACHE_PREFIX = "Cache_Model_";

}
