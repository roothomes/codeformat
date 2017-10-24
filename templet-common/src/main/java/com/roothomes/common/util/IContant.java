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
     * 导入到Java文件中的注解语句列表
     */
    String K_ANNOTATION="ANNOTATION";
    /**
     * 类名称
     */
    String K_CLASSNAME = "CLASSNAME";
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
    String K_CREATE_AUTHOR="CREATE_AUTHOR";
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
     * 数据库的表名称
     */
    String K_DBTABLENAME = "DBTABLENAME";
    /**
     * 数据库名称
     */
    String K_DBNAME="DBNAME";

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
    String V_TEMPLET_FILE_Contant="temp_contant.ftlh";

    /**
     * 模板文件的基础路径
     */
    String V_TEMPLET_BASEDIR = ".\\templet-common\\src\\main\\resources\\ftl\\";


    /**
     * 模型类中基础属性的名称;
     */
    public String baseJavaAttributeCode = "id|status|enableFlag|createDate|createBy|lastUpdateBy|lastUpdateDate|plantformId|oecdNo|cityId|orderNumber|remarks";
    /**
     * 数据库表基础字段名称
     * */
    public String baseDBColumnCode = "ID|STATUS|ENABLE_FLAG|CREATE_DATE|CREATE_BY|LAST_UPDATE_BY|LAST_UPDATE_DATE|PLANTFORM_ID|OECD_NO|CITY_ID|ORDER_NUMBER|REMARKS";
    /**
     * Java基础属性名称
     * */
    public String baseJavaAttributeDesc = "主键id|状态|逻辑删除|创建时间|创建人|最后修改人|最后修改时间|平台编号|组织编码|城市id|排序|备注";
    /**
     * Java基础属性类型(支持基本数据类型)
     * */
    public String baseJavaAttributeType = "String|String|EnableFlag|Date|String|String|Date|String|String|Integer|Integer|String";
}
