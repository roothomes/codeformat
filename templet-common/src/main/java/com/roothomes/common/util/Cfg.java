package com.roothomes.common.util;

/**
 * 系统配置类
 * @author roothomes
 */
public class Cfg {

    /**
     * 生成文件的基本目录 
     */
    public String cfgOutputBaseDir = "D:\\git\\codeformat\\templet-common\\output\\";

    /** 项目组织唯一的标识符 */
    public String cfgGroupId="com.apec";
    /** 项目的唯一的标识符 */
    public String cfgArtifactId="notice";
    /** POJO中模型类的名称 */
    public String cfgPojoName = "Notice";
    /** 模型的描述 */
    public String cfgModelDesc = "咨询信息管理(用于公告、咨询等文字类型)";
    /** 创建人 */
    public String cfgCreatAuthor = "roothomes";

    /** 创建时间 */
    public String cfgCreatDate = "2017-10-24";

    /**
     * Java属性名称
     * */
    public String cfgJavaAttributeDesc = "项目类型(1:咨询;2:市场公告)|咨询信息|咨询标题|内容类型(1:图片；2:文字；3:url)|链接URL|是否为热点(1:是热点；0:不是热点； 主要区分推荐列表和全部分页)";
    /**
     * 数据库字段名称
     * */
    public String cfgDBColumnCode = "MSG_TYPE|MSG|TITLE|CONTENT_TYPE|URL|HOTSPOT";
    /**
     * Java属性类型(支持基本数据类型)
     * */
    public String cfgJavaAttributeType = "String|String|String|String|String|String";
    /**
     * Java POJO模型类中属性的名称;
     */
    public String cfgJavaAttributeCode = "msgType|msg|title|contentType|url|hotspot";

    /** 数据库表名称 */
    public String cfgDBTableName="notice";
    /** 数据库名称 */
    public String cfgDBName = "cncsen";

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
}
