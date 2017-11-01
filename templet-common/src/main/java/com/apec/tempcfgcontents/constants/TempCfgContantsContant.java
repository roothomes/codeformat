package com.apec.tempcfgcontents.constants;



/**
 * 类 编 号：BL_PU10000_12_constants
 * 类 名 称：TempCfgContantsContant
 * 内容摘要：业务模型常量类,包含各种常量信息
 * @author roothomes
 * @date 2017-10-30
 */
public interface TempCfgContantsContant{

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


    /** 主表Id */
    String DEFAULT_VAL_MAIN_ID = "default";
    /** 常量描述 */
    String DEFAULT_VAL_CONTANT_DESC = "default";
    /** 常量JAVA类型 */
    String DEFAULT_VAL_CONTANT_JAVA_TYPE = "default";
    /** 常量JAVA编码 */
    String DEFAULT_VAL_CONTANT_JAVA_CODE = "default";
    /** 常量是否可以为空 */
    String DEFAULT_VAL_CONTANT_VAL_CAN_NULL = "default";
    /** 常量值 */
    String DEFAULT_VAL_CONTANT_VAL = "default";
    /** 缓存前缀 */
    String CACHE_PREFIX = "Cache_Model_";

}
