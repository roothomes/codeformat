package com.roothomes.common.util;

/**
 * 系统配置类
 * @author roothomes
 */
public class Cfg {

    /**
     * 生成文件的基本目录
     */
    public static String cfgOutputBaseDir = "D:\\git\\codeformat\\templet-common\\output";

    /** 项目组织唯一的标识符 */
    public static String cfgGroupId="com.apec";
    /** 项目的唯一的标识符 */
    public static String cfgArtifactId="notice";
    /** POJO中模型类的名称 */
    public static String cfgPojoName = "Notice";
    /**
     * Java POJO模型类中属性的名称;
     */
    public static String cfgJavaAttributeCode = "name,key,val";
    /**
     * 数据库字段名称
     * */
    public static String cfgDBCode = "t_x_01,t_x_02,t_x_03";
    /**
     * Java属性名称
     * */
    public static String cfgJavaAttributeDesc = "属性1名称,属性2名称,属性3名称";
    /**
     * Java属性类型(支持基本数据类型)
     * */
    public static String cfgJavaAttributeType = "String,Integer,Double";
    /** 数据库表名称 */
    public static String cfgDBTableName="notice";
    /** 数据库名称 */
    public static String cfgDBName = "cncsen";

    /**
     * 是否初始化目录列表
     */
    private static boolean isInitDir = false;

    public static String getCfgOutputBaseDir() {
        return cfgOutputBaseDir;
    }

    public static void setCfgOutputBaseDir(String cfgOutputBaseDir) {
        Cfg.cfgOutputBaseDir = cfgOutputBaseDir;
    }

    public static String getCfgGroupId() {
        return cfgGroupId;
    }

    public static void setCfgGroupId(String cfgGroupId) {
        Cfg.cfgGroupId = cfgGroupId;
    }

    public static String getCfgArtifactId() {
        return cfgArtifactId;
    }

    public static void setCfgArtifactId(String cfgArtifactId) {
        Cfg.cfgArtifactId = cfgArtifactId;
    }

    public static String getCfgPojoName() {
        return cfgPojoName;
    }

    public static void setCfgPojoName(String cfgPojoName) {
        Cfg.cfgPojoName = cfgPojoName;
    }

    public static String getCfgJavaAttributeCode() {
        return cfgJavaAttributeCode;
    }

    public static void setCfgJavaAttributeCode(String cfgJavaAttributeCode) {
        Cfg.cfgJavaAttributeCode = cfgJavaAttributeCode;
    }

    public static String getCfgDBCode() {
        return cfgDBCode;
    }

    public static void setCfgDBCode(String cfgDBCode) {
        Cfg.cfgDBCode = cfgDBCode;
    }

    public static String getCfgJavaAttributeDesc() {
        return cfgJavaAttributeDesc;
    }

    public static void setCfgJavaAttributeDesc(String cfgJavaAttributeDesc) {
        Cfg.cfgJavaAttributeDesc = cfgJavaAttributeDesc;
    }

    public static String getCfgJavaAttributeType() {
        return cfgJavaAttributeType;
    }

    public static void setCfgJavaAttributeType(String cfgJavaAttributeType) {
        Cfg.cfgJavaAttributeType = cfgJavaAttributeType;
    }

    public static String getCfgDBTableName() {
        return cfgDBTableName;
    }

    public static void setCfgDBTableName(String cfgDBTableName) {
        Cfg.cfgDBTableName = cfgDBTableName;
    }

    public static String getCfgDBName() {
        return cfgDBName;
    }

    public static void setCfgDBName(String cfgDBName) {
        Cfg.cfgDBName = cfgDBName;
    }

    public static void setIsInitDir(boolean isInitDir) {
        Cfg.isInitDir = isInitDir;
    }

    public static boolean isIsInitDir() {
        return isInitDir;
    }
}
