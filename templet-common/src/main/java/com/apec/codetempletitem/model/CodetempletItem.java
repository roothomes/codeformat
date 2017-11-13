package com.apec.codetempletitem.model;


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
@Table(name = "codetemplet_item", catalog = "cncsen")

/**
 * 类 编 号：BL_PU6030202_1000_model
 * 类 名 称：CodetempletItem
 * 内容摘要：业务模型Pojo类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class CodetempletItem extends BaseModel<String>
{
    private static final long serialVersionUID = 1L;


    /** 代码模板id */
    @Column(name = "templet_id")
    private String templetId;

    public void setTempletId(String templetId) {
    this.templetId = templetId;
    }

    public String getTempletId() {
    return templetId;
    }

    /** java模型属性描述 */
    @Column(name = "cfg_javaattribute_desc")
    private String cfgJavaAttributeDesc;

    public void setCfgJavaAttributeDesc(String cfgJavaAttributeDesc) {
    this.cfgJavaAttributeDesc = cfgJavaAttributeDesc;
    }

    public String getCfgJavaAttributeDesc() {
    return cfgJavaAttributeDesc;
    }

    /** 数据字段名称 */
    @Column(name = "cfg_db_columncode")
    private String cfgDBColumnCode;

    public void setCfgDBColumnCode(String cfgDBColumnCode) {
    this.cfgDBColumnCode = cfgDBColumnCode;
    }

    public String getCfgDBColumnCode() {
    return cfgDBColumnCode;
    }

    /** java模型属性类型 */
    @Column(name = "cfg_javaattribute_type")
    private String cfgJavaAttributeType;

    public void setCfgJavaAttributeType(String cfgJavaAttributeType) {
    this.cfgJavaAttributeType = cfgJavaAttributeType;
    }

    public String getCfgJavaAttributeType() {
    return cfgJavaAttributeType;
    }

    /** java模型属性编码 */
    @Column(name = "cfg_javaattribute_code")
    private String cfgJavaAttributeCode;

    public void setCfgJavaAttributeCode(String cfgJavaAttributeCode) {
    this.cfgJavaAttributeCode = cfgJavaAttributeCode;
    }

    public String getCfgJavaAttributeCode() {
    return cfgJavaAttributeCode;
    }

    /** java模型属性是否可为空 */
    @Column(name = "cfg_javaattribute_cannull")
    private String cfgJavaAttributeCanNull;

    public void setCfgJavaAttributeCanNull(String cfgJavaAttributeCanNull) {
    this.cfgJavaAttributeCanNull = cfgJavaAttributeCanNull;
    }

    public String getCfgJavaAttributeCanNull() {
    return cfgJavaAttributeCanNull;
    }

    /** java模型属性默认值 */
    @Column(name = "cfg_javaattribute_default_val")
    private String cfgJavaAttributeDefaultVal;

    public void setCfgJavaAttributeDefaultVal(String cfgJavaAttributeDefaultVal) {
    this.cfgJavaAttributeDefaultVal = cfgJavaAttributeDefaultVal;
    }

    public String getCfgJavaAttributeDefaultVal() {
    return cfgJavaAttributeDefaultVal;
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
