package com.apec.codetempletcontants.model;


/** JPA列注解 */
import javax.persistence.Column;
/** JPA实体注解 */
import javax.persistence.Entity;
/** JPA表注解 */
import javax.persistence.Table;
/** hibernate动态更新 */
import org.hibernate.annotations.DynamicUpdate;
/** hibernate自动生成 */
import org.hibernate.annotations.GenericGenerator;
/** 平台常量类 */
import com.apec.framework.common.Constants;
/** JSON转换类 */
import com.apec.framework.common.util.JsonUtil;
import java.lang.String;
/** 模型的基础继承类 */
import com.apec.framework.jpa.model.BaseModel;


/** JPA实体注解 */
@Entity
/** hibernate动态更新 */
@DynamicUpdate
/** hibernate自动生成 */
@GenericGenerator(name = Constants.SYSTEM_GENERATOR, strategy = Constants.ASSIGNED)
/** JPA表注解 */
@Table(name = "code_templet_contants", catalog = "cncsen")

/**
 * 类 编 号：BL_PU6030202_1000_model
 * 类 名 称：CodeTempletContants
 * 内容摘要：业务模型Pojo类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class CodeTempletContants extends BaseModel<String>
{
    private static final long serialVersionUID = 1L;


    /** 常量值 */
    @Column(name = "variable_val")
    private String variableVal;

    public void setVariableVal(String variableVal) {
    this.variableVal = variableVal;
    }

    public String getVariableVal() {
    return variableVal;
    }

    /** 常量名称 */
    @Column(name = "variable_name")
    private String variableName;

    public void setVariableName(String variableName) {
    this.variableName = variableName;
    }

    public String getVariableName() {
    return variableName;
    }

    /** 常量数据类型 */
    @Column(name = "variable_type")
    private String variableType;

    public void setVariableType(String variableType) {
    this.variableType = variableType;
    }

    public String getVariableType() {
    return variableType;
    }

    /** 常量描述 */
    @Column(name = "variable_desc")
    private String variableDesc;

    public void setVariableDesc(String variableDesc) {
    this.variableDesc = variableDesc;
    }

    public String getVariableDesc() {
    return variableDesc;
    }

    /** 代码模板id */
    @Column(name = "templet_id")
    private String templetId;

    public void setTempletId(String templetId) {
    this.templetId = templetId;
    }

    public String getTempletId() {
    return templetId;
    }


@Column(name = "ORDER_NUMBER")
private Integer orderNumber;

@Column(name = "CITY_ID")
private Integer cityId;

@Column(name = "PLANTFORM_ID")
private String plantformId;

@Column(name = "OECD_NO")
private String oecdNo;

@Column(name = "REMARKS")
private String remarks;



public Integer getOrderNumber() {
return orderNumber;
}

public void setOrderNumber(Integer orderNumber) {
this.orderNumber = orderNumber;
}

public Integer getCityId() {
return cityId;
}

public void setCityId(Integer cityId) {
this.cityId = cityId;
}

public String getPlantformId() {
return plantformId;
}

public void setPlantformId(String plantformId) {
this.plantformId = plantformId;
}

public String getOecdNo() {
return oecdNo;
}

public void setOecdNo(String oecdNo) {
this.oecdNo = oecdNo;
}

public String getRemarks() {
return remarks;
}

public void setRemarks(String remarks) {
this.remarks = remarks;
}
    @Override
    public String toString() {
    	return JsonUtil.toJSONString(this);
    }
}
