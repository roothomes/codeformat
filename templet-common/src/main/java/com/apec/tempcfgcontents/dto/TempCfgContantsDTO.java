package com.apec.tempcfgcontents.dto;


/** 继承的基础分页类 */
import com.apec.framework.dto.BaseDTO;
/** JSON转换类 */
import com.apec.framework.common.util.JsonUtil;

import java.lang.String;

import com.apec.framework.common.enumtype.EnableFlag;

import java.util.Date;

import java.lang.Integer;


/**
 * 类 编 号：BL_PU10000_12_dto
 * 类 名 称：TempCfgContantsDTO
 * 内容摘要：业务模型Dto类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class TempCfgContantsDTO extends BaseDTO
{
    private static final long serialVersionUID = 1L;

    /** 主表Id */
    private String mainId;
    /** 常量描述 */
    private String contantDesc;
    /** 常量JAVA类型 */
    private String contantJavaType;
    /** 常量JAVA编码 */
    private String contantJavaCode;
    /** 常量是否可以为空 */
    private String contantCanNull;
    /** 常量值 */
    private String contantVal;
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
    /** 常量描述 */
    public void setContantDesc(String contantDesc) {
        this.contantDesc = contantDesc;
    }
    /** 常量描述 */
    public String getContantDesc() {
       return contantDesc;
    }
    /** 常量JAVA类型 */
    public void setContantJavaType(String contantJavaType) {
        this.contantJavaType = contantJavaType;
    }
    /** 常量JAVA类型 */
    public String getContantJavaType() {
       return contantJavaType;
    }
    /** 常量JAVA编码 */
    public void setContantJavaCode(String contantJavaCode) {
        this.contantJavaCode = contantJavaCode;
    }
    /** 常量JAVA编码 */
    public String getContantJavaCode() {
       return contantJavaCode;
    }
    /** 常量是否可以为空 */
    public void setContantCanNull(String contantCanNull) {
        this.contantCanNull = contantCanNull;
    }
    /** 常量是否可以为空 */
    public String getContantCanNull() {
       return contantCanNull;
    }
    /** 常量值 */
    public void setContantVal(String contantVal) {
        this.contantVal = contantVal;
    }
    /** 常量值 */
    public String getContantVal() {
       return contantVal;
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
