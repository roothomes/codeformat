package com.apec.tempcfgredis.constants;



/**
 * 类 编 号：BL_PU10000_10_constants
 * 类 名 称：TempCfgRedisContant
 * 内容摘要：业务模型常量类,包含各种常量信息
 * @author roothomes
 * @date 2017-10-30
 */
public interface TempCfgRedisContant{

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


    /** redis实例类型(单例:singleton;) */
    String DEFAULT_VAL_REDIS_TYPE_SINGLETON = "singleton";
    /** redis实例类型(集群:cluster) */
    String DEFAULT_VAL_REDIS_TYPE_CLUSTER = "cluster";
    /** redis配置Ip地址 */
    String DEFAULT_VAL_REDIS_IP = "127.0.0.1";
    /** redis的端口号6379 */
    String DEFAULT_VAL_REDIS_PORT = "6379";
    /** redis的端口号7000 */
    String DEFAULT_VAL_REDIS_PORT7000 = "7000";
    /** redis的端口号7001 */
    String DEFAULT_VAL_REDIS_PORT7001 = "7001";
    /** redis的端口号7002 */
    String DEFAULT_VAL_REDIS_PORT7002 = "7002";
    /** redis的端口号7003 */
    String DEFAULT_VAL_REDIS_PORT7003 = "7003";
    /** redis的端口号7004 */
    String DEFAULT_VAL_REDIS_PORT7004 = "7004";
    /** redis的端口号7005 */
    String DEFAULT_VAL_REDIS_PORT7005 = "7005";
    /** redis密码 */
    String DEFAULT_VAL_REDIS_PASSWORD = "foobared";
    /** redis的数据默认索引:0 */
    String DEFAULT_VAL_REDIS_INDEX = "0";
    /** redis的数据默认索引:1 */
    String DEFAULT_VAL_REDIS_INDEX1 = "1";
    /** redis的数据默认索引:2 */
    String DEFAULT_VAL_REDIS_INDEX2 = "2";
    /** redis的数据默认索引:3 */
    String DEFAULT_VAL_REDIS_INDEX3 = "3";
    /** redis的数据默认索引:4 */
    String DEFAULT_VAL_REDIS_INDEX4 = "4";
    /** redis的数据默认索引:5 */
    String DEFAULT_VAL_REDIS_INDEX5 = "5";
    /** redis的数据默认索引:6 */
    String DEFAULT_VAL_REDIS_INDEX6 = "6";
    /** redis的数据默认索引:7 */
    String DEFAULT_VAL_REDIS_INDEX7 = "7";
    /** 缓存Key值前缀 */
    String CACHE_PREFIX = "Cache_Model_";

}
