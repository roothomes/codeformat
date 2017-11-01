package com.apec.tempcfgredis.model;


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
@Table(name = "temp_cfg_redis", catalog = "cncsen")

/**
 * 类 编 号：BL_PU10000_10_model
 * 类 名 称：TempCfgRedis
 * 内容摘要：业务模型Pojo类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class TempCfgRedis extends BaseModel<String>
{
    private static final long serialVersionUID = 1L;


    /** 缓存类型 */
    @Column(name = "REDIS_TYPE")
    private String redisType;

    public void setRedisType(String redisType) {
    this.redisType = redisType;
    }

    public String getRedisType() {
    return redisType;
    }

    /** IP地址 */
    @Column(name = "REDIS_IP")
    private String redisIp;

    public void setRedisIp(String redisIp) {
    this.redisIp = redisIp;
    }

    public String getRedisIp() {
    return redisIp;
    }

    /** 端口 */
    @Column(name = "REDIS_PORT")
    private String redisPort;

    public void setRedisPort(String redisPort) {
    this.redisPort = redisPort;
    }

    public String getRedisPort() {
    return redisPort;
    }

    /** 口令 */
    @Column(name = "REDIS_PASSWORD")
    private String redisPassword;

    public void setRedisPassword(String redisPassword) {
    this.redisPassword = redisPassword;
    }

    public String getRedisPassword() {
    return redisPassword;
    }

    /** 索引 */
    @Column(name = "REDIS_INDEX")
    private String redisIndex;

    public void setRedisIndex(String redisIndex) {
    this.redisIndex = redisIndex;
    }

    public String getRedisIndex() {
    return redisIndex;
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
