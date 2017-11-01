package com.apec.cs.vo;

public class TempGenerateParamVo{

    /** 数据库表名称 ="notice_testx"*/
    private String cfgDBTableName;

    /** 项目的唯一的标识符 ="uploadfileX"*/
    private String cfgArtifactId;

    /** POJO中模型类的名称  = "UploadfilesX"*/
    private String cfgPojoName;

    /** 模型的描述  = "咨询信息管理(用于公告、咨询等文字类型)"*/
    private String cfgModelDesc;

    /**
     * Java属性名称
     * = "项目类型(1:咨询;2:市场公告)|咨询信息|咨询标题|内容类型(1:图片；2:文字；3:url)|链接URL|是否为热点(1:是热点；0:不是热点； 主要区分推荐列表和全部分页)"
     */
    private String cfgJavaAttributeDesc;
    /**
     * 数据库字段名称
     *  = "MSG_TYPE|MSG|TITLE|CONTENT_TYPE|URL|HOTSPOT"
     * */
    private String cfgDBColumnCode;
    /**
     * Java属性类型(支持基本数据类型)
     *  = "String|String|String|String|String|String"
     * */
    private String cfgJavaAttributeType;
    /**
     * Java POJO模型类中属性的名称;
     * = "msgType|msg|title|contentType|url|hotspot"
     */
    private String cfgJavaAttributeCode;
    /**
     * 属性新增的是否是否可以为空（0:不可为空；1:可以为空；）
     *  = "1|1|1|1|1|1"
     */
    private String cfgJavaAttributeCanNull;
    /**
     * 设置属性的默认值
     * = "null|null|null|null|null|null"
     */
    private String cfgJavaAttributeDefaultVal;

    public String getCfgDBTableName() {
        return cfgDBTableName;
    }

    public void setCfgDBTableName(String cfgDBTableName) {
        this.cfgDBTableName = cfgDBTableName;
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

    public String getCfgModelDesc() {
        return cfgModelDesc;
    }

    public void setCfgModelDesc(String cfgModelDesc) {
        this.cfgModelDesc = cfgModelDesc;
    }

    public String getCfgJavaAttributeDesc() {
        return cfgJavaAttributeDesc;
    }

    public void setCfgJavaAttributeDesc(String cfgJavaAttributeDesc) {
        this.cfgJavaAttributeDesc = cfgJavaAttributeDesc;
    }

    public String getCfgDBColumnCode() {
        return cfgDBColumnCode;
    }

    public void setCfgDBColumnCode(String cfgDBColumnCode) {
        this.cfgDBColumnCode = cfgDBColumnCode;
    }

    public String getCfgJavaAttributeType() {
        return cfgJavaAttributeType;
    }

    public void setCfgJavaAttributeType(String cfgJavaAttributeType) {
        this.cfgJavaAttributeType = cfgJavaAttributeType;
    }

    public String getCfgJavaAttributeCode() {
        return cfgJavaAttributeCode;
    }

    public void setCfgJavaAttributeCode(String cfgJavaAttributeCode) {
        this.cfgJavaAttributeCode = cfgJavaAttributeCode;
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



    /**
     * 生成文件的基本目录
     *  = "D:\\svn\\trade\\App_cncsen\\Src\\"
     */
    private String cfgOutputBaseDir;

    /**
     * 模型依赖的父工程的项目组织唯一的标识符
     * ="com.apec"
     */
    private String cfgParentPomGroupId;
    /**
     * 模型依赖的父工程的项目的唯一的标识符
     * ="framework-parent"
     */
    private String cfgParentPomArtifactId;
    /**
     * 模型依赖的父工程的项目的版本号
     * ="1.0.1-RELEASE"
     */
    private String cfgParentPomVersion;
    /**
     * 模型依赖的父工程的项目路径
     * ="../APEC_CJ001_Framework/pom.xml"
     */
    private String cfgParentPomRelativePath;

    /**
     * 项目组织唯一的标识符
     * ="com.apec"
     *  */
    private String cfgGroupId;


    /** 版本号 = "1.0-RELEASE"*/
    private String cfgVersion ;

    /**
     * 模型对象序列号
     * = "BL_PU6030202_1000"
     */
    private String cfgSerialNo;

    /** 创建人  = "roothomes"*/
    private String cfgCreatAuthor;

    /** 创建时间  = "2017-10-30"*/
    private String cfgCreatDate;

    /****************  常量设置 start  ***********************/
    /**
     * 配置常量接口里面的常量的描述信息
     * ="缓存Key值前缀"
     */
    private String cfgJavaContantDesc;
    /**
     * 配置常量接口里面常量的类型
     *  = "String"
     */
    private String cfgJavaContantType;
    /**
     * 配置常量接口里面常量的名称
     * = "CACHE_PREFIX"
     */
    private String cfgJavaContantCode;
    /**
     * 配置常量接口里面常量的默认值
     * = "Cache_Model_"
     */
    private String cfgJavaContantDefaultVal;

    /****************  常量设置 end  ***********************/



    /**
     * 模型的主键类型
     *  ="String"
     */
    private String cfgJavaPkIdType;

    /** 数据库名称  = "cncsen"*/
    private String cfgDBName;

    /**
     * 资源文件数据库链接配置项
     *  = "jdbc:mysql://192.168.7.28:3306/cncsen?useUnicode=true&characterEncoding=utf8&useSSL=false&useLocalSessionState=true"
     */
    private String cfgDevJdbcUrl;
    /**
     * 资源文件数据库链接配置项
     *= "root"
     */
    private String cfgDevJdbcUserName ;
    /**
     * 资源文件数据库链接配置项
     * = "123456"
     */
    private String cfgDevJdbcUserPwd;
    /**
     * 资源文件注册中心配置项
     * = "192.168.7.203"
     */
    private String cfgDevEurekaIp;
    /**
     * 资源文件注册中心配置项
     * = "1111"
     */
    private String cfgDevEurekaPort;
    /**
     * 资源文件注册中心配置项
     * ="192.168.7.203:1111"
     */
    private String cfgDevEurekaInstanceHostname;

    /** 资源文件  服务器端口  = "30050"*/
    private String cfgServerPort;
    /**
     * 资源文件 服务workId配置项
     * ="11"
     */
    private String cfgWorkerId;
    /**
     * 资源文件 服务注册域 配置项
     * ="http://${eureka.instance.hostname}/eureka/"
     */
    private String cfgEurekaClientServiceUrlDefaultZone;
    /**
     * 资源文件 服务注册实例Id
     * = "${spring.cloud.client.ipAddress}:${server.port}"
     */
    private String cfgEurekaInstanceInstanceId ;


    public String getCfgOutputBaseDir() {
        return cfgOutputBaseDir;
    }

    public void setCfgOutputBaseDir(String cfgOutputBaseDir) {
        this.cfgOutputBaseDir = cfgOutputBaseDir;
    }

    public String getCfgParentPomGroupId() {
        return cfgParentPomGroupId;
    }

    public void setCfgParentPomGroupId(String cfgParentPomGroupId) {
        this.cfgParentPomGroupId = cfgParentPomGroupId;
    }

    public String getCfgParentPomArtifactId() {
        return cfgParentPomArtifactId;
    }

    public void setCfgParentPomArtifactId(String cfgParentPomArtifactId) {
        this.cfgParentPomArtifactId = cfgParentPomArtifactId;
    }

    public String getCfgParentPomVersion() {
        return cfgParentPomVersion;
    }

    public void setCfgParentPomVersion(String cfgParentPomVersion) {
        this.cfgParentPomVersion = cfgParentPomVersion;
    }

    public String getCfgParentPomRelativePath() {
        return cfgParentPomRelativePath;
    }

    public void setCfgParentPomRelativePath(String cfgParentPomRelativePath) {
        this.cfgParentPomRelativePath = cfgParentPomRelativePath;
    }

    public String getCfgGroupId() {
        return cfgGroupId;
    }

    public void setCfgGroupId(String cfgGroupId) {
        this.cfgGroupId = cfgGroupId;
    }

    public String getCfgVersion() {
        return cfgVersion;
    }

    public void setCfgVersion(String cfgVersion) {
        this.cfgVersion = cfgVersion;
    }

    public String getCfgSerialNo() {
        return cfgSerialNo;
    }

    public void setCfgSerialNo(String cfgSerialNo) {
        this.cfgSerialNo = cfgSerialNo;
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

    public String getCfgJavaPkIdType() {
        return cfgJavaPkIdType;
    }

    public void setCfgJavaPkIdType(String cfgJavaPkIdType) {
        this.cfgJavaPkIdType = cfgJavaPkIdType;
    }

    public String getCfgDBName() {
        return cfgDBName;
    }

    public void setCfgDBName(String cfgDBName) {
        this.cfgDBName = cfgDBName;
    }

    public String getCfgDevJdbcUrl() {
        return cfgDevJdbcUrl;
    }

    public void setCfgDevJdbcUrl(String cfgDevJdbcUrl) {
        this.cfgDevJdbcUrl = cfgDevJdbcUrl;
    }

    public String getCfgDevJdbcUserName() {
        return cfgDevJdbcUserName;
    }

    public void setCfgDevJdbcUserName(String cfgDevJdbcUserName) {
        this.cfgDevJdbcUserName = cfgDevJdbcUserName;
    }

    public String getCfgDevJdbcUserPwd() {
        return cfgDevJdbcUserPwd;
    }

    public void setCfgDevJdbcUserPwd(String cfgDevJdbcUserPwd) {
        this.cfgDevJdbcUserPwd = cfgDevJdbcUserPwd;
    }

    public String getCfgDevEurekaIp() {
        return cfgDevEurekaIp;
    }

    public void setCfgDevEurekaIp(String cfgDevEurekaIp) {
        this.cfgDevEurekaIp = cfgDevEurekaIp;
    }

    public String getCfgDevEurekaPort() {
        return cfgDevEurekaPort;
    }

    public void setCfgDevEurekaPort(String cfgDevEurekaPort) {
        this.cfgDevEurekaPort = cfgDevEurekaPort;
    }

    public String getCfgDevEurekaInstanceHostname() {
        return cfgDevEurekaInstanceHostname;
    }

    public void setCfgDevEurekaInstanceHostname(String cfgDevEurekaInstanceHostname) {
        this.cfgDevEurekaInstanceHostname = cfgDevEurekaInstanceHostname;
    }

    public String getCfgServerPort() {
        return cfgServerPort;
    }

    public void setCfgServerPort(String cfgServerPort) {
        this.cfgServerPort = cfgServerPort;
    }

    public String getCfgWorkerId() {
        return cfgWorkerId;
    }

    public void setCfgWorkerId(String cfgWorkerId) {
        this.cfgWorkerId = cfgWorkerId;
    }

    public String getCfgEurekaClientServiceUrlDefaultZone() {
        return cfgEurekaClientServiceUrlDefaultZone;
    }

    public void setCfgEurekaClientServiceUrlDefaultZone(String cfgEurekaClientServiceUrlDefaultZone) {
        this.cfgEurekaClientServiceUrlDefaultZone = cfgEurekaClientServiceUrlDefaultZone;
    }

    public String getCfgEurekaInstanceInstanceId() {
        return cfgEurekaInstanceInstanceId;
    }

    public void setCfgEurekaInstanceInstanceId(String cfgEurekaInstanceInstanceId) {
        this.cfgEurekaInstanceInstanceId = cfgEurekaInstanceInstanceId;
    }
}
