package com.apec.tempcfgattributes.model;


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
@Table(name = "temp_cfg_attributes", catalog = "cncsen")

/**
 * 类 编 号：BL_PU10000_11_model
 * 类 名 称：TempCfgAttributes
 * 内容摘要：业务模型Pojo类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class TempCfgAttributes extends BaseModel<String>
{
    private static final long serialVersionUID = 1L;


    /** 主表Id */
    @Column(name = "MAIN_ID")
    private String mainId;

    public void setMainId(String mainId) {
    this.mainId = mainId;
    }

    public String getMainId() {
    return mainId;
    }

    /** 属性描述 */
    @Column(name = "ATTRIBUTE_DESC")
    private String attributeId;

    public void setAttributeId(String attributeId) {
    this.attributeId = attributeId;
    }

    public String getAttributeId() {
    return attributeId;
    }

    /** 属性JAVA类型 */
    @Column(name = "ATTRIBUTE_JAVA_TYPE")
    private String attributeJavaType;

    public void setAttributeJavaType(String attributeJavaType) {
    this.attributeJavaType = attributeJavaType;
    }

    public String getAttributeJavaType() {
    return attributeJavaType;
    }

    /** 属性数据库字段名称 */
    @Column(name = "ATTRIBUTE_COLUMN_NAME")
    private String attributeColumnName;

    public void setAttributeColumnName(String attributeColumnName) {
    this.attributeColumnName = attributeColumnName;
    }

    public String getAttributeColumnName() {
    return attributeColumnName;
    }

    /** 属性JAVA编码 */
    @Column(name = "ATTRIBUTE_JAVA_CODE")
    private String attributeJavaCode;

    public void setAttributeJavaCode(String attributeJavaCode) {
    this.attributeJavaCode = attributeJavaCode;
    }

    public String getAttributeJavaCode() {
    return attributeJavaCode;
    }

    /** 属性是否可以为空 */
    @Column(name = "ATTRIBUTE_VAL_CAN_NULL")
    private String attributeCanNull;

    public void setAttributeCanNull(String attributeCanNull) {
    this.attributeCanNull = attributeCanNull;
    }

    public String getAttributeCanNull() {
    return attributeCanNull;
    }

    /** 属性默认值 */
    @Column(name = "DEFAULT_VAL")
    private String defaultVal;

    public void setDefaultVal(String defaultVal) {
    this.defaultVal = defaultVal;
    }

    public String getDefaultVal() {
    return defaultVal;
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
