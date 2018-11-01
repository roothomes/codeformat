package com.apec.codetempletcontants.constants;



/**
 * 类 编 号：BL_PU6030202_1000_constants
 * 类 名 称：CodeTempletContantsContant
 * 内容摘要：业务模型常量类,包含各种常量信息
 * @author roothomes
 * @date 2017-10-30
 */
public interface CodeTempletContantsContant {

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


    /** »º´æKeyÖµÇ°×º */
    String CACHE_PREFIX = "Cache_Model_";

}
