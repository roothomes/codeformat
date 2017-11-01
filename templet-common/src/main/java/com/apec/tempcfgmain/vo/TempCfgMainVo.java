package com.apec.tempcfgmain.vo;


/** 继承的基础分页类 */
import com.apec.framework.dto.BaseDTO;
/** JSON转换类 */
import com.apec.framework.common.util.JsonUtil;

import java.lang.String;

import com.apec.framework.common.enumtype.EnableFlag;

import java.util.Date;

import java.lang.Integer;


/**
 * 类 编 号：BL_PU10000_10_vo
 * 类 名 称：TempCfgMainVo
 * 内容摘要：业务模型Vo类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class TempCfgMainVo extends BaseDTO
{
    private static final long serialVersionUID = 1L;

    /** 组织标示符 */
    private String groupId;
    /** 业务标示符 */
    private String artifactId;
    /** 模型PoJo的类 */
    private String modelClassName;
    /** 模型描述 */
    private String modelClassDesc;
    /** 模型对象序列号 */
    private String modelClassSerialNo;
    /** 创建作者 */
    private String createAuthor;
    /** 创建时间 */
    private String createDateTime;
    /** 模型对应表所在数据库 */
    private String databaseName;
    /** 模型对应表 */
    private String tableName;
    /** 是否启用缓存 */
    private String openCache;
    /** 是否启用消息 */
    private String openMQ;
    /** 主键id */
    private String id;
    /** 状态 */
    private String status;
    /** 逻辑删除 */
    private EnableFlag enableFlag = EnableFlag.Y;
    /** 创建时间 */
    private Date createDate;
    /** 创建人 */
    private String createBy;
    /** 最后修改人 */
    private String lastUpdateBy;
    /** 最后修改时间 */
    private Date lastUpdateDate;
    /** 平台编号 */
    private String plantformId;
    /** 组织编码 */
    private String oecdNo;
    /** 城市id */
    private Integer cityId;
    /** 排序 */
    private Integer orderNumber;
    /** 备注 */
    private String remarks;

    /** 组织标示符 */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    /** 组织标示符 */
    public String getGroupId() {
       return groupId;
    }
    /** 业务标示符 */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }
    /** 业务标示符 */
    public String getArtifactId() {
       return artifactId;
    }
    /** 模型PoJo的类 */
    public void setModelClassName(String modelClassName) {
        this.modelClassName = modelClassName;
    }
    /** 模型PoJo的类 */
    public String getModelClassName() {
       return modelClassName;
    }
    /** 模型描述 */
    public void setModelClassDesc(String modelClassDesc) {
        this.modelClassDesc = modelClassDesc;
    }
    /** 模型描述 */
    public String getModelClassDesc() {
       return modelClassDesc;
    }
    /** 模型对象序列号 */
    public void setModelClassSerialNo(String modelClassSerialNo) {
        this.modelClassSerialNo = modelClassSerialNo;
    }
    /** 模型对象序列号 */
    public String getModelClassSerialNo() {
       return modelClassSerialNo;
    }
    /** 创建作者 */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }
    /** 创建作者 */
    public String getCreateAuthor() {
       return createAuthor;
    }
    /** 创建时间 */
    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }
    /** 创建时间 */
    public String getCreateDateTime() {
       return createDateTime;
    }
    /** 模型对应表所在数据库 */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    /** 模型对应表所在数据库 */
    public String getDatabaseName() {
       return databaseName;
    }
    /** 模型对应表 */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    /** 模型对应表 */
    public String getTableName() {
       return tableName;
    }
    /** 是否启用缓存 */
    public void setOpenCache(String openCache) {
        this.openCache = openCache;
    }
    /** 是否启用缓存 */
    public String getOpenCache() {
       return openCache;
    }
    /** 是否启用消息 */
    public void setOpenMQ(String openMQ) {
        this.openMQ = openMQ;
    }
    /** 是否启用消息 */
    public String getOpenMQ() {
       return openMQ;
    }
    /** 主键id */
    public void setId(String id) {
        this.id = id;
    }
    /** 主键id */
    public String getId() {
       return id;
    }
    /** 状态 */
    public void setStatus(String status) {
        this.status = status;
    }
    /** 状态 */
    public String getStatus() {
       return status;
    }
    /** 逻辑删除 */
    public void setEnableFlag(EnableFlag enableFlag) {
        this.enableFlag = enableFlag;
    }
    /** 逻辑删除 */
    public EnableFlag getEnableFlag() {
       return enableFlag;
    }
    /** 创建时间 */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /** 创建时间 */
    public Date getCreateDate() {
       return createDate;
    }
    /** 创建人 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    /** 创建人 */
    public String getCreateBy() {
       return createBy;
    }
    /** 最后修改人 */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    /** 最后修改人 */
    public String getLastUpdateBy() {
       return lastUpdateBy;
    }
    /** 最后修改时间 */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    /** 最后修改时间 */
    public Date getLastUpdateDate() {
       return lastUpdateDate;
    }
    /** 平台编号 */
    public void setPlantformId(String plantformId) {
        this.plantformId = plantformId;
    }
    /** 平台编号 */
    public String getPlantformId() {
       return plantformId;
    }
    /** 组织编码 */
    public void setOecdNo(String oecdNo) {
        this.oecdNo = oecdNo;
    }
    /** 组织编码 */
    public String getOecdNo() {
       return oecdNo;
    }
    /** 城市id */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    /** 城市id */
    public Integer getCityId() {
       return cityId;
    }
    /** 排序 */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    /** 排序 */
    public Integer getOrderNumber() {
       return orderNumber;
    }
    /** 备注 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    /** 备注 */
    public String getRemarks() {
       return remarks;
    }

    @Override
    public String toString() {
    	return JsonUtil.toJSONString(this);
    }
}
