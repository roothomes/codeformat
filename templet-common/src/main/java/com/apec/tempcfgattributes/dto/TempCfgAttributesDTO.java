package com.apec.tempcfgattributes.dto;


/** 继承的基础分页类 */
import com.apec.framework.dto.BaseDTO;
/** JSON转换类 */
import com.apec.framework.common.util.JsonUtil;

import java.lang.String;

import com.apec.framework.common.enumtype.EnableFlag;

import java.util.Date;

import java.lang.Integer;


/**
 * 类 编 号：BL_PU10000_11_dto
 * 类 名 称：TempCfgAttributesDTO
 * 内容摘要：业务模型Dto类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class TempCfgAttributesDTO extends BaseDTO
{
    private static final long serialVersionUID = 1L;

    /** 主表Id */
    private String mainId;
    /** 属性描述 */
    private String attributeId;
    /** 属性JAVA类型 */
    private String attributeJavaType;
    /** 属性数据库字段名称 */
    private String attributeColumnName;
    /** 属性JAVA编码 */
    private String attributeJavaCode;
    /** 属性是否可以为空 */
    private String attributeCanNull;
    /** 属性默认值 */
    private String defaultVal;
    /** 主键id */
    private String id;
    /** 状态 */
    private String status;
    /** 逻辑删除 */
    private EnableFlag enableFlag;
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

    /** 主表Id */
    public void setMainId(String mainId) {
        this.mainId = mainId;
    }
    /** 主表Id */
    public String getMainId() {
       return mainId;
    }
    /** 属性描述 */
    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }
    /** 属性描述 */
    public String getAttributeId() {
       return attributeId;
    }
    /** 属性JAVA类型 */
    public void setAttributeJavaType(String attributeJavaType) {
        this.attributeJavaType = attributeJavaType;
    }
    /** 属性JAVA类型 */
    public String getAttributeJavaType() {
       return attributeJavaType;
    }
    /** 属性数据库字段名称 */
    public void setAttributeColumnName(String attributeColumnName) {
        this.attributeColumnName = attributeColumnName;
    }
    /** 属性数据库字段名称 */
    public String getAttributeColumnName() {
       return attributeColumnName;
    }
    /** 属性JAVA编码 */
    public void setAttributeJavaCode(String attributeJavaCode) {
        this.attributeJavaCode = attributeJavaCode;
    }
    /** 属性JAVA编码 */
    public String getAttributeJavaCode() {
       return attributeJavaCode;
    }
    /** 属性是否可以为空 */
    public void setAttributeCanNull(String attributeCanNull) {
        this.attributeCanNull = attributeCanNull;
    }
    /** 属性是否可以为空 */
    public String getAttributeCanNull() {
       return attributeCanNull;
    }
    /** 属性默认值 */
    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }
    /** 属性默认值 */
    public String getDefaultVal() {
       return defaultVal;
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
