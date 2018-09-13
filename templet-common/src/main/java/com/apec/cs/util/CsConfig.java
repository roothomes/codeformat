package com.apec.cs.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CsConfig {

    /**
     * 模板文件的基础路径
     * =".\\templet-common\\src\\main\\resources\\ftl\\"
     */
    @Value("${cfgTempletBaseDir}")
    private String cfgTempletBaseDir;

    /**
     * 生成文件的基本目录
     *  = "D:\\svn\\trade\\App_cncsen\\Src\\"
     */
    @Value("${cfgOutputBaseDir}")
    private String cfgOutputBaseDir;

    /**
     * 模型依赖的父工程的项目组织唯一的标识符
     * ="com.apec"
     */
    @Value("${cfgParentPomGroupId}")
    private String cfgParentPomGroupId;
    /**
     * 模型依赖的父工程的项目的唯一的标识符
     * ="framework-parent"
     */
    @Value("${cfgParentPomArtifactId}")
    private String cfgParentPomArtifactId;
    /**
     * 模型依赖的父工程的项目的版本号
     * ="1.0.1-RELEASE"
     */
    @Value("${cfgParentPomVersion}")
    private String cfgParentPomVersion;
    /**
     * 模型依赖的父工程的项目路径
     * ="../APEC_CJ001_Framework/pom.xml"
     */
    @Value("${cfgParentPomRelativePath}")
    private String cfgParentPomRelativePath;

    /**
     * 项目组织唯一的标识符
     * ="com.apec"
     *  */
    @Value("${cfgGroupId}")
    private String cfgGroupId;

    /** 版本号 = "1.0-RELEASE"*/
    @Value("${cfgVersion}")
    private String cfgVersion;

    /**
     * 模型对象序列号
     * = "BL_PU6030202_1000"
     */
    @Value("${cfgSerialNo}")
    private String cfgSerialNo;

    //** 创建人  = "roothomes"*/
    @Value("${cfgCreatAuthor}")
    private String cfgCreatAuthor;

    /** 创建时间  = "2017-10-30"*/
    @Value("${cfgCreatDate}")
    private String cfgCreatDate;


    /**
     * 模型的主键类型
     *  ="String"
     */
    @Value("${cfgJavaPkIdType}")
    private String cfgJavaPkIdType;

    /** 数据库名称  = "cncsen"*/
    @Value("${cfgDBName}")
    private String cfgDBName;
    /**
     * 资源文件数据库链接配置项
     *  = "jdbc:mysql://192.168.7.28:3306/cncsen?useUnicode=true&characterEncoding=utf8&useSSL=false&useLocalSessionState=true"
     */
    @Value("${cfgDevJdbcUrl}")
    private String cfgDevJdbcUrl;
    /**
     * 资源文件数据库链接配置项
     *= "root"
     */
    @Value("${cfgDevJdbcUserName}")
    private String cfgDevJdbcUserName;
    /**
     * 资源文件数据库链接配置项
     * = "123456"
     */
    @Value("${cfgDevJdbcUserPwd}")
    private String cfgDevJdbcUserPwd;
    /**
     * 资源文件注册中心配置项
     * = "192.168.7.203"
     */
    @Value("${cfgDevEurekaIp}")
    private String cfgDevEurekaIp;
    /**
     * 资源文件注册中心配置项
     * = "1111"
     */
    @Value("${cfgDevEurekaPort}")
    private String cfgDevEurekaPort;
    /**
     * 资源文件注册中心配置项
     * ="192.168.7.203:1111"
     */
    @Value("${cfgDevEurekaInstanceHostname}")
    private String cfgDevEurekaInstanceHostname;

    /** 资源文件  服务器端口  = "30050"*/
    @Value("${cfgServerPort}")
    private String cfgServerPort = "30050";
    /**
     * 资源文件 服务workId配置项
     * ="11"
     */
    @Value("${cfgWorkerId}")
    private String cfgWorkerId="11";
    /**
     * /**
     * 资源文件 服务注册域 配置项
     * ="http://${eureka.instance.hostname}/eureka/"
     */
    @Value("${cfgEurekaClientServiceUrlDefaultZone}")
    private String cfgEurekaClientServiceUrlDefaultZone="http://${eureka.instance.hostname}/eureka/";
    /**
     * 资源文件 服务注册实例Id
     * = "${spring.cloud.client.ipAddress}:${server.port}"
     */
    @Value("${cfgEurekaInstanceInstanceId}")
    private String cfgEurekaInstanceInstanceId = "${spring.cloud.client.ipAddress}:${server.port}";


    /****************  常量设置 start  ***********************/
    /**
     * 配置常量接口里面的常量的描述信息
     * ="缓存Key值前缀"
     */
    @Value("${cfgJavaContantDesc}")
    private String cfgJavaContantDesc;
    /**
     * 配置常量接口里面常量的类型
     *  ="String"
     */
    @Value("${cfgJavaContantType}")
    private String cfgJavaContantType;
    /**
     * 配置常量接口里面常量的名称
     *  ="CACHE_PREFIX"
     */
    @Value("${cfgJavaContantCode}")
    private String cfgJavaContantCode;
    /**
     * 配置常量接口里面常量的默认值
     * ="Cache_Model_"
     */
    @Value("${cfgJavaContantDefaultVal}")
    private String cfgJavaContantDefaultVal ;

    /**
     * 配置常量接口里面常量的默认值
     * ="/home/nginxShare/apec/service"
     */
    @Value("${zipDir}")
    private String zipDir;
    /**
     * 配置常量接口里面常量的默认值
     * ="http://192.168.7.203/apec/service/"
     */
    @Value("${httpZipBasePath}")
    private String httpZipBasePath;
    @Value("${cfgJavaFrameworkVersion}")
    private String cfgJavaFrameworkVersion;

    public String getCfgOutputBaseDir() {
        return cfgOutputBaseDir;
    }

    public String getCfgParentPomGroupId() {
        return cfgParentPomGroupId;
    }

    public String getCfgParentPomArtifactId() {
        return cfgParentPomArtifactId;
    }

    public String getCfgParentPomVersion() {
        return cfgParentPomVersion;
    }

    public String getCfgParentPomRelativePath() {
        return cfgParentPomRelativePath;
    }

    public String getCfgGroupId() {
        return cfgGroupId;
    }

    public String getCfgVersion() {
        return cfgVersion;
    }

    public String getCfgSerialNo() {
        return cfgSerialNo;
    }

    public String getCfgCreatAuthor() {
        return cfgCreatAuthor;
    }

    public String getCfgCreatDate() {
        return cfgCreatDate;
    }

    public String getCfgJavaPkIdType() {
        return cfgJavaPkIdType;
    }

    public String getCfgDBName() {
        return cfgDBName;
    }

    public String getCfgDevJdbcUrl() {
        return cfgDevJdbcUrl;
    }

    public String getCfgDevJdbcUserName() {
        return cfgDevJdbcUserName;
    }

    public String getCfgDevJdbcUserPwd() {
        return cfgDevJdbcUserPwd;
    }

    public String getCfgDevEurekaIp() {
        return cfgDevEurekaIp;
    }

    public String getCfgDevEurekaPort() {
        return cfgDevEurekaPort;
    }

    public String getCfgDevEurekaInstanceHostname() {
        return cfgDevEurekaInstanceHostname;
    }

    public String getCfgServerPort() {
        return cfgServerPort;
    }

    public String getCfgWorkerId() {
        return cfgWorkerId;
    }

    public String getCfgEurekaClientServiceUrlDefaultZone() {
        return cfgEurekaClientServiceUrlDefaultZone;
    }

    public String getCfgEurekaInstanceInstanceId() {
        return cfgEurekaInstanceInstanceId;
    }

    public String getCfgJavaContantDesc() {
        return cfgJavaContantDesc;
    }

    public String getCfgJavaContantType() {
        return cfgJavaContantType;
    }

    public String getCfgJavaContantCode() {
        return cfgJavaContantCode;
    }

    public String getCfgJavaContantDefaultVal() {
        return cfgJavaContantDefaultVal;
    }

    public void setCfgOutputBaseDir(String cfgOutputBaseDir) {
        this.cfgOutputBaseDir = cfgOutputBaseDir;
    }

    public void setCfgParentPomGroupId(String cfgParentPomGroupId) {
        this.cfgParentPomGroupId = cfgParentPomGroupId;
    }

    public void setCfgParentPomArtifactId(String cfgParentPomArtifactId) {
        this.cfgParentPomArtifactId = cfgParentPomArtifactId;
    }

    public void setCfgParentPomVersion(String cfgParentPomVersion) {
        this.cfgParentPomVersion = cfgParentPomVersion;
    }

    public void setCfgParentPomRelativePath(String cfgParentPomRelativePath) {
        this.cfgParentPomRelativePath = cfgParentPomRelativePath;
    }

    public void setCfgGroupId(String cfgGroupId) {
        this.cfgGroupId = cfgGroupId;
    }

    public void setCfgVersion(String cfgVersion) {
        this.cfgVersion = cfgVersion;
    }

    public void setCfgSerialNo(String cfgSerialNo) {
        this.cfgSerialNo = cfgSerialNo;
    }

    public void setCfgCreatAuthor(String cfgCreatAuthor) {
        this.cfgCreatAuthor = cfgCreatAuthor;
    }

    public void setCfgCreatDate(String cfgCreatDate) {
        this.cfgCreatDate = cfgCreatDate;
    }

    public void setCfgJavaPkIdType(String cfgJavaPkIdType) {
        this.cfgJavaPkIdType = cfgJavaPkIdType;
    }

    public void setCfgDBName(String cfgDBName) {
        this.cfgDBName = cfgDBName;
    }

    public void setCfgDevJdbcUrl(String cfgDevJdbcUrl) {
        this.cfgDevJdbcUrl = cfgDevJdbcUrl;
    }

    public void setCfgDevJdbcUserName(String cfgDevJdbcUserName) {
        this.cfgDevJdbcUserName = cfgDevJdbcUserName;
    }

    public void setCfgDevJdbcUserPwd(String cfgDevJdbcUserPwd) {
        this.cfgDevJdbcUserPwd = cfgDevJdbcUserPwd;
    }

    public void setCfgDevEurekaIp(String cfgDevEurekaIp) {
        this.cfgDevEurekaIp = cfgDevEurekaIp;
    }

    public void setCfgDevEurekaPort(String cfgDevEurekaPort) {
        this.cfgDevEurekaPort = cfgDevEurekaPort;
    }

    public void setCfgDevEurekaInstanceHostname(String cfgDevEurekaInstanceHostname) {
        this.cfgDevEurekaInstanceHostname = cfgDevEurekaInstanceHostname;
    }

    public void setCfgServerPort(String cfgServerPort) {
        this.cfgServerPort = cfgServerPort;
    }

    public void setCfgWorkerId(String cfgWorkerId) {
        this.cfgWorkerId = cfgWorkerId;
    }

    public void setCfgEurekaClientServiceUrlDefaultZone(String cfgEurekaClientServiceUrlDefaultZone) {
        this.cfgEurekaClientServiceUrlDefaultZone = cfgEurekaClientServiceUrlDefaultZone;
    }

    public void setCfgEurekaInstanceInstanceId(String cfgEurekaInstanceInstanceId) {
        this.cfgEurekaInstanceInstanceId = cfgEurekaInstanceInstanceId;
    }

    public void setCfgJavaContantDesc(String cfgJavaContantDesc) {
        this.cfgJavaContantDesc = cfgJavaContantDesc;
    }

    public void setCfgJavaContantType(String cfgJavaContantType) {
        this.cfgJavaContantType = cfgJavaContantType;
    }

    public void setCfgJavaContantCode(String cfgJavaContantCode) {
        this.cfgJavaContantCode = cfgJavaContantCode;
    }

    public void setCfgJavaContantDefaultVal(String cfgJavaContantDefaultVal) {
        this.cfgJavaContantDefaultVal = cfgJavaContantDefaultVal;
    }

    public String getCfgTempletBaseDir() {
        return cfgTempletBaseDir;
    }

    public void setCfgTempletBaseDir(String cfgTempletBaseDir) {
        this.cfgTempletBaseDir = cfgTempletBaseDir;
    }

    public String getZipDir() {
        return zipDir;
    }

    public void setZipDir(String zipDir) {
        this.zipDir = zipDir;
    }

    public String getHttpZipBasePath() {
        return httpZipBasePath;
    }

    public void setHttpZipBasePath(String httpZipBasePath) {
        this.httpZipBasePath = httpZipBasePath;
    }

    public String getCfgJavaFrameworkVersion() {
        return cfgJavaFrameworkVersion;
    }

    public void setCfgJavaFrameworkVersion(String cfgJavaFrameworkVersion) {
        this.cfgJavaFrameworkVersion = cfgJavaFrameworkVersion;
    }
}
