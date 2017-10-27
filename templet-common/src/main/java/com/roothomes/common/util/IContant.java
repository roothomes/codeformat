package com.roothomes.common.util;

/**
 * 常量接口
 * @author roothomes
 */
public interface IContant {
    /**
     * java文件扩展名 .java
     */
    String JAVA_EXTENSION_NAME=".java";

    /**
     * GroupID项目组织唯一的标识符，用于包结构等
     */
    String K_GROUPID="GROUPID";
    /**
     * ArtifactID就是项目的唯一的标识符，用于包结构等
     */
    String K_ARTIFACTID="ARTIFACTID";

    /**
     * 生成文件的包空间
     */
    String K_PACKAGE = "PACKAGE";
    /**
     * 导入的Java文件的包语句列表
     */
    String K_PACKAGES = "PACKAGES";
    /**
     * 属性能够为空
     */
    String K_ATTRIBUTE_CAN_NULL ="ATTRIBUTE_CAN_NULL";
    /**
     * 导入到Java文件中的注解语句列表
     */
    String K_ANNOTATION="ANNOTATION";
    /**
     * 类名称
     */
    String K_CLASSNAME = "CLASSNAME";
    /**
     * 类的描述
     */
    String K_CLASSNAME_DESC="CLASSNAME_DESC";
    /**
     * MODEL 模型类的名称
     */
    String K_MODEL_CLASSNAME="MODEL_CLASSNAME";
    /**
     * VO 模型类的名称
     */
    String K_VO_CLASSNAME="VO_CLASSNAME";
    /**
     * DTO 模型类的名称
     */
    String K_DTO_CLASSNAME="DTO_CLASSNAME";
    /**
     * DAO 模型类的名称
     */
    String K_DAO_CLASSNAME="DAO_CLASSNAME";

    /**
     * SERVICE 模型类的名称
     */
    String K_SERVICE_CLASSNAME="SERVICE_CLASSNAME";

    /**
     * CONTANT 模型类的名称
     */
    String K_CONTANT_CLASSNAME="CONTANT_CLASSNAME";

    /**
     * BASECONTROLLER 模型类的名称
     */
    String K_BASECONTROLLER_CLASSNAME="BASECONTROLLER_CLASSNAME";
    /**
     * CONTROLLER 模型类的名称
     */
    String K_CONTROLLER_CLASSNAME="CONTROLLER_CLASSNAME";

    /**
     * UTIL 模型类的名称
     */
    String K_UTIL_CLASSNAME="UTIL_CLASSNAME";

    /**
     * CONTANT_DESC模型类的名称
     */
    String K_CONTANT_CLASSNAME_DESC="CONTANT_CLASSNAME_DESC";

    /**
     * CONTANT_TYPE模型类的名称
     */
    String K_CONTANT_CLASSNAME_TYPE="CONTANT_CLASSNAME_TYPE";

    /**
     * CONTANT_CODE模型类的名称
     */
    String K_CONTANT_CLASSNAME_CODE="CONTANT_CLASSNAME_CODE";

    /**
     * CONTANT_DEFAULT_VAL模型类的名称
     */
    String K_CONTANT_CLASSNAME_DEFAULT_VAL="CONTANT_CLASSNAME_DEAFULT_VAL";

    /**
     * 模型的主键id的类型
     */
    String K_PK_ID_TYPE="PK_ID_TYPE";

    /**
     * 模型的描述信息
     */
    String K_MODELDESC="MODELDESC";
    /**
     * 创建人
     */
    String K_CREAT_AUTHOR ="CREAT_AUTHOR";
    /**
     * 创建时间
     */
    String K_CREAT_DATE="CREAT_DATE";

    /**
     * 系统分隔符
     */
    String K_SPLIT="\\|";
    /**
     * 导入到Java文件中的属性语句列表
     */
    String K_ATTRIBUTE = "ATTRIBUTE";
    /**
     * serviceImpl里面设置属性的默认值集合Key
     */
    String K_ATTRIBUTE_DEFAULT_VAL = "ATTRIBUTE_DEFAULT_VAL";

    /**
     * 导入到Java文件中的base属性语句列表
     */
    String K_BASE_ATTRIBUTE = "BASE_ATTRIBUTE";

    /**
     * 导入到Java文件中的base属性是否可以为空列表
     */
    String K_BASE_ATTRIBUTE_CAN_NULL = "BASE_ATTRIBUTE_CAN_NULL";

    /**
     * 数据库的表名称
     */
    String K_DBTABLENAME = "DBTABLENAME";
    /**
     * 数据库名称
     */
    String K_DBNAME="DBNAME";

    /**
     * java 类的basemodel的模板文件名称
     */
    String V_TEMPLET_FILE_BASEMODEL="temp_basemodel.ftlh";

    /**
     * java 类的model的模板文件名称
     */
    String V_TEMPLET_FILE_MODEL="temp_model.ftlh";

    /**
     * java 类的DTO的模板文件名称
     */
    String V_TEMPLET_FILE_DTO="temp_dto.ftlh";

    /**
     * java 类的vo的模板文件名称
     */
    String V_TEMPLET_FILE_VO="temp_vo.ftlh";
    /**
     * java 类的dao的模板文件名称
     */
    String V_TEMPLET_FILE_DAO="temp_dao.ftlh";
    /**
     * java 类的service的模板文件名称
     */
    String V_TEMPLET_FILE_SERVICE="temp_service.ftlh";
    /**
     * java 类的serviceImpl的模板文件名称
     */
    String V_TEMPLET_FILE_SERVICEIMPL="temp_serviceimpl.ftlh";
    /**
     * java 类的util的模板文件名称
     */
    String V_TEMPLET_FILE_UTIL="temp_util.ftlh";

    /**
     * java 类的contant的模板文件名称
     */
    String V_TEMPLET_FILE_CONTANT ="temp_contant.ftlh";

    /**
     * java 类的application的模板文件名称
     */
    String V_TEMPLET_FILE_APPLICATION ="temp_application.ftlh";

    /**
     * java 类的keygen的模板文件名称
     */
    String V_TEMPLET_FILE_KEYGEN ="temp_keygen.ftlh";
    /**
     * java 类的controller的模板文件名称
     */
    String V_TEMPLET_FILE_CONTROLLER="temp_controller.ftlh";
    /**
     * java 类的basecontroller的模板文件名称
     */
    String V_TEMPLET_FILE_BASECONTROLLER="temp_basecontroller.ftlh";

    /**
     * 模板文件的基础路径
     */
    String V_TEMPLET_BASEDIR = ".\\templet-common\\src\\main\\resources\\ftl\\";


    /**
     * 模型类中基础属性的名称;(12个属性)
     */
    public String BASE_JAVA_ATTRIBUTE_CODE = "id|status|enableFlag|createDate|createBy|lastUpdateBy|lastUpdateDate|plantformId|oecdNo|cityId|orderNumber|remarks";
    /**
     * 数据库表基础字段名称;(12个属性)
     * */
    public String BASE_DB_COLUMN_CODE = "ID|STATUS|ENABLE_FLAG|CREATE_DATE|CREATE_BY|LAST_UPDATE_BY|LAST_UPDATE_DATE|PLANTFORM_ID|OECD_NO|CITY_ID|ORDER_NUMBER|REMARKS";
    /**
     * Java基础属性名称;(12个属性)
     * */
    public String BASE_JAVA_ATTRIBUTE_DESC = "主键id|状态|逻辑删除|创建时间|创建人|最后修改人|最后修改时间|平台编号|组织编码|城市id|排序|备注";
    /**
     * Java基础属性类型(支持基本数据类型);(12个属性)
     * */
    public String BASE_JAVA_ATTRIBUTE_TYPE = "String|String|EnableFlag|Date|String|String|Date|String|String|Integer|Integer|String";
    /**
     * Java基础属性是否可以为空（0:不可为空；1:可以为空；）;(12个属性)
     */
    public String BASE_JAVA_ATTRIBUTE_CAN_NULL = "0|0|0|0|1|1|0|0|0|0|0|1";

    /**
     * 每页最大的条数
     */
    Integer MAX_NUMBER_ONE_PAGE = 100;
    /**
     * 每页默认的条数
     */
    Integer DEFAULT_NUMBER_ONE_PAGE =20;


}
