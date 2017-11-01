package com.apec.cs.vo;

/**
 * 可以省略的参数（省略后使用默认值）
 * @author roothomes
 * @date 2017-11-1
 */
public class TempGenerateParamBaseVo {

    /**
     * 模板文件的基础路径
     * =".\\templet-common\\src\\main\\resources\\ftl\\"
     */
    private String cfgTempletBaseDir;

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

    public String getCfgTempletBaseDir() {
        return cfgTempletBaseDir;
    }

    public void setCfgTempletBaseDir(String cfgTempletBaseDir) {
        this.cfgTempletBaseDir = cfgTempletBaseDir;
    }

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
