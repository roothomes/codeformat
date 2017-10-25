package com.roothomes.common.util;

/**
 * 系统配置类
 * @author roothomes
 */
public class Cfg {

    /**
     * 生成文件的基本目录 
     */
    private String cfgOutputBaseDir = "D:\\git\\codeformat\\templet-common\\output\\";

    /** 项目组织唯一的标识符 */
    private String cfgGroupId="com.apec";
    /** 项目的唯一的标识符 */
    private String cfgArtifactId="notice";
    /** POJO中模型类的名称 */
    private String cfgPojoName = "Notice";
    /** 模型的描述 */
    private String cfgModelDesc = "咨询信息管理(用于公告、咨询等文字类型)";
    /** 创建人 */
    private String cfgCreatAuthor = "roothomes";

    /** 创建时间 */
    private String cfgCreatDate = "2017-10-24";

    /**
     * Java属性名称
     * */
    private String cfgJavaAttributeDesc = "项目类型(1:咨询;2:市场公告)|咨询信息|咨询标题|内容类型(1:图片；2:文字；3:url)|链接URL|是否为热点(1:是热点；0:不是热点； 主要区分推荐列表和全部分页)";
    /**
     * 数据库字段名称
     * */
    private String cfgDBColumnCode = "MSG_TYPE|MSG|TITLE|CONTENT_TYPE|URL|HOTSPOT";
    /**
     * Java属性类型(支持基本数据类型)
     * */
    private String cfgJavaAttributeType = "String|String|String|String|String|String";
    /**
     * Java POJO模型类中属性的名称;
     */
    private String cfgJavaAttributeCode = "msgType|msg|title|contentType|url|hotspot";
    /**
     * 属性新增的是否是否可以为空（0:不可为空；1:可以为空；）
     */
    private String cfgJavaAttributeCanNull = "0|0|0|0|1|0";
    /**
     * 设置属性的默认值
     */
    private String cfgJavaAttributeDefaultVal = "DEFAULT_VAL_MSG_TYPE_NOTICE|DEFAULT_VAL_MSG|DEFAULT_VAL_TITLE|DEFAULT_VAL_CONTENT_TYPE_MSG|DEFAULT_VAL_URL|DEFAULT_VAL_HOTSPOT_NO";
    /****************  常量设置 start  ***********************/
    /**
     * 配置常量接口里面的常量的描述信息
     */
    private String cfgJavaContantDesc="项目类型-咨询|项目类型-公告|信息内容|标题|信息内容类型-信息|信息内容类型-链接|信息链接|热点-是|热点-否|缓存Key值";
    /**
     * 配置常量接口里面常量的类型
     */
    private String cfgJavaContantType =
                "String|" + "String|" +
                "String|" +
                "String|" +
                "String|" + "String|" +
                "String|" +
                "String|" + "String|" +
                "String";
    /**
     * 配置常量接口里面常量的名称
     */
    private String cfgJavaContantCode =
                    "DEFAULT_VAL_MSG_TYPE_NOTICE|" + "DEFAULT_VAL_MSG_TYPE_ADVICE|" +
                    "DEFAULT_VAL_MSG|" +
                    "DEFAULT_VAL_TITLE|" +
                    "DEFAULT_VAL_CONTENT_TYPE_MSG|" + "DEFAULT_VAL_CONTENT_TYPE_URL|" +
                    "DEFAULT_VAL_URL|" +
                    "DEFAULT_VAL_HOTSPOT_YES|" + "DEFAULT_VAL_HOTSPOT_NO|" +
                    "CACHE_PREFIX";
    /**
     * 配置常量接口里面常量的默认值
     */
    private String cfgJavaContantDefaultVal =
                    "1|" + "2|" +
                    "默认信息|" +
                    "默认标题|" +
                    "msg|" + "url|" +
                    "#|" +
                    "1|" + "0|Cache_Model_";

    /****************  常量设置 end  ***********************/



    /**
     * 模型的主键类型
     */
    private String cfgJavaPkIdType ="String";

    /** 数据库表名称 */
    private String cfgDBTableName="notice";
    /** 数据库名称 */
    private String cfgDBName = "cncsen";

    /**
     * 是否初始化目录列表
     */
    private boolean isInitDir = false;

    public String getCfgOutputBaseDir() {
        return cfgOutputBaseDir;
    }

    public void setCfgOutputBaseDir(String cfgOutputBaseDir) {
        this.cfgOutputBaseDir = cfgOutputBaseDir;
    }

    public String getCfgGroupId() {
        return cfgGroupId;
    }

    public void setCfgGroupId(String cfgGroupId) {
        this.cfgGroupId = cfgGroupId;
    }

    public String getCfgArtifactId() {
        return cfgArtifactId;
    }

    public void setCfgArtifactId(String cfgArtifactId) {
        this.cfgArtifactId = cfgArtifactId;
    }

    public String getCfgPojoName() {
        return cfgPojoName;
    }

    public void setCfgPojoName(String cfgPojoName) {
        this.cfgPojoName = cfgPojoName;
    }

    public String getCfgJavaAttributeCode() {
        return cfgJavaAttributeCode;
    }

    public void setCfgJavaAttributeCode(String cfgJavaAttributeCode) {
        this.cfgJavaAttributeCode = cfgJavaAttributeCode;
    }

    public String getCfgDBColumnCode() {
        return cfgDBColumnCode;
    }

    public void setCfgDBColumnCode(String cfgDBColumnCode) {
        this.cfgDBColumnCode = cfgDBColumnCode;
    }

    public String getCfgJavaAttributeDesc() {
        return cfgJavaAttributeDesc;
    }

    public void setCfgJavaAttributeDesc(String cfgJavaAttributeDesc) {
        this.cfgJavaAttributeDesc = cfgJavaAttributeDesc;
    }

    public String getCfgJavaAttributeType() {
        return cfgJavaAttributeType;
    }

    public void setCfgJavaAttributeType(String cfgJavaAttributeType) {
        this.cfgJavaAttributeType = cfgJavaAttributeType;
    }

    public String getCfgDBTableName() {
        return cfgDBTableName;
    }

    public void setCfgDBTableName(String cfgDBTableName) {
        this.cfgDBTableName = cfgDBTableName;
    }

    public String getCfgDBName() {
        return cfgDBName;
    }

    public void setCfgDBName(String cfgDBName) {
        this.cfgDBName = cfgDBName;
    }

    public void setIsInitDir(boolean isInitDir) {
        this.isInitDir = isInitDir;
    }

    public boolean isIsInitDir() {
        return isInitDir;
    }

    public String getCfgModelDesc() {
        return cfgModelDesc;
    }

    public void setCfgModelDesc(String cfgModelDesc) {
        this.cfgModelDesc = cfgModelDesc;
    }

    public boolean isInitDir() {
        return isInitDir;
    }

    public void setInitDir(boolean initDir) {
        isInitDir = initDir;
    }

    public String getCfgCreatAuthor() {
        return cfgCreatAuthor;
    }

    public void setCfgCreatAuthor(String cfgCreatAuthor) {
        this.cfgCreatAuthor = cfgCreatAuthor;
    }

    public String getCfgCreatDate() {
        return cfgCreatDate;
    }

    public void setCfgCreatDate(String cfgCreatDate) {
        this.cfgCreatDate = cfgCreatDate;
    }


    public String getCfgJavaPkIdType() {
        return cfgJavaPkIdType;
    }

    public void setCfgJavaPkIdType(String cfgJavaPkIdType) {
        this.cfgJavaPkIdType = cfgJavaPkIdType;
    }

    public String getCfgJavaAttributeCanNull() {
        return cfgJavaAttributeCanNull;
    }

    public void setCfgJavaAttributeCanNull(String cfgJavaAttributeCanNull) {
        this.cfgJavaAttributeCanNull = cfgJavaAttributeCanNull;
    }

    public String getCfgJavaAttributeDefaultVal() {
        return cfgJavaAttributeDefaultVal;
    }

    public void setCfgJavaAttributeDefaultVal(String cfgJavaAttributeDefaultVal) {
        this.cfgJavaAttributeDefaultVal = cfgJavaAttributeDefaultVal;
    }

    public String getCfgJavaContantDesc() {
        return cfgJavaContantDesc;
    }

    public void setCfgJavaContantDesc(String cfgJavaContantDesc) {
        this.cfgJavaContantDesc = cfgJavaContantDesc;
    }

    public String getCfgJavaContantType() {
        return cfgJavaContantType;
    }

    public void setCfgJavaContantType(String cfgJavaContantType) {
        this.cfgJavaContantType = cfgJavaContantType;
    }

    public String getCfgJavaContantCode() {
        return cfgJavaContantCode;
    }

    public void setCfgJavaContantCode(String cfgJavaContantCode) {
        this.cfgJavaContantCode = cfgJavaContantCode;
    }

    public String getCfgJavaContantDefaultVal() {
        return cfgJavaContantDefaultVal;
    }

    public void setCfgJavaContantDefaultVal(String cfgJavaContantDefaultVal) {
        this.cfgJavaContantDefaultVal = cfgJavaContantDefaultVal;
    }
}
