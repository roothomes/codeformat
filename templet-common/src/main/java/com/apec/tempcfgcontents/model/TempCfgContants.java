package com.apec.tempcfgcontents.model;


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
@Table(name = "temp_cfg_contants", catalog = "cncsen")

/**
 * 类 编 号：BL_PU10000_12_model
 * 类 名 称：TempCfgContants
 * 内容摘要：业务模型Pojo类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class TempCfgContants extends BaseModel<String>
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

    /** 常量描述 */
    @Column(name = "CONTANT_DESC")
    private String contantDesc;

    public void setContantDesc(String contantDesc) {
    this.contantDesc = contantDesc;
    }

    public String getContantDesc() {
    return contantDesc;
    }

    /** 常量JAVA类型 */
    @Column(name = "CONTANT_JAVA_TYPE")
    private String contantJavaType;

    public void setContantJavaType(String contantJavaType) {
    this.contantJavaType = contantJavaType;
    }

    public String getContantJavaType() {
    return contantJavaType;
    }

    /** 常量JAVA编码 */
    @Column(name = "CONTANT_JAVA_CODE")
    private String contantJavaCode;

    public void setContantJavaCode(String contantJavaCode) {
    this.contantJavaCode = contantJavaCode;
    }

    public String getContantJavaCode() {
    return contantJavaCode;
    }

    /** 常量是否可以为空 */
    @Column(name = "CONTANT_VAL_CAN_NULL")
    private String contantCanNull;

    public void setContantCanNull(String contantCanNull) {
    this.contantCanNull = contantCanNull;
    }

    public String getContantCanNull() {
    return contantCanNull;
    }

    /** 常量值 */
    @Column(name = "CONTANT_VAL")
    private String contantVal;

    public void setContantVal(String contantVal) {
    this.contantVal = contantVal;
    }

    public String getContantVal() {
    return contantVal;
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
