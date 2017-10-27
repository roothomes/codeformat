package ${PACKAGE};



/**
 * 类 编 号：
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */
public interface ${CLASSNAME}{

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
     * 失效
     */
    String STATUS_INVALID = "0";

    /**
     * 有效
     */
    String STATUS_VALID = "1";


<#list CONTANT_CLASSNAME_TYPE as x>
    /** ${CONTANT_CLASSNAME_DESC[x_index]} */
    ${CONTANT_CLASSNAME_TYPE[x_index]} ${CONTANT_CLASSNAME_CODE[x_index]} = <#if CONTANT_CLASSNAME_TYPE[x_index] == 'String'>"${CONTANT_CLASSNAME_DEAFULT_VAL[x_index]}"<#else>${CONTANT_CLASSNAME_DEAFULT_VAL[x_index]}</#if>;
</#list>

}
