package com.apec.tempcfgmain.model;


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
@Table(name = "temp_cfg_main", catalog = "cncsen")

/**
 * 类 编 号：BL_PU10000_10_model
 * 类 名 称：TempCfgMain
 * 内容摘要：业务模型Pojo类,里面包含业务模型的属性，以及该属性的get set方法
 * @author roothomes
 * @date 2017-10-30
 */
public class TempCfgMain extends BaseModel<String>
{
    private static final long serialVersionUID = 1L;


    /** 组织标示符 */
    @Column(name = "GROUPID")
    private String groupId;

    public void setGroupId(String groupId) {
    this.groupId = groupId;
    }

    public String getGroupId() {
    return groupId;
    }

    /** 业务标示符 */
    @Column(name = "ARTIFACTID")
    private String artifactId;

    public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
    }

    public String getArtifactId() {
    return artifactId;
    }

    /** 模型PoJo的类 */
    @Column(name = "MODEL_CLASSNAME")
    private String modelClassName;

    public void setModelClassName(String modelClassName) {
    this.modelClassName = modelClassName;
    }

    public String getModelClassName() {
    return modelClassName;
    }

    /** 模型描述 */
    @Column(name = "MODEL_CLASSNAME_DESC")
    private String modelClassDesc;

    public void setModelClassDesc(String modelClassDesc) {
    this.modelClassDesc = modelClassDesc;
    }

    public String getModelClassDesc() {
    return modelClassDesc;
    }

    /** 模型对象序列号 */
    @Column(name = "MODEL_CLASS_SERIALNO")
    private String modelClassSerialNo;

    public void setModelClassSerialNo(String modelClassSerialNo) {
    this.modelClassSerialNo = modelClassSerialNo;
    }

    public String getModelClassSerialNo() {
    return modelClassSerialNo;
    }

    /** 创建作者 */
    @Column(name = "CREAT_AUTHOR")
    private String createAuthor;

    public void setCreateAuthor(String createAuthor) {
    this.createAuthor = createAuthor;
    }

    public String getCreateAuthor() {
    return createAuthor;
    }

    /** 创建时间 */
    @Column(name = "CREAT_DATETIME")
    private String createDateTime;

    public void setCreateDateTime(String createDateTime) {
    this.createDateTime = createDateTime;
    }

    public String getCreateDateTime() {
    return createDateTime;
    }

    /** 模型对应表所在数据库 */
    @Column(name = "DATABASE_NAME")
    private String databaseName;

    public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
    }

    public String getDatabaseName() {
    return databaseName;
    }

    /** 模型对应表 */
    @Column(name = "TABLE_NAME")
    private String tableName;

    public void setTableName(String tableName) {
    this.tableName = tableName;
    }

    public String getTableName() {
    return tableName;
    }

    /** 是否启用缓存 */
    @Column(name = "OPEN_CACHE")
    private String openCache;

    public void setOpenCache(String openCache) {
    this.openCache = openCache;
    }

    public String getOpenCache() {
    return openCache;
    }

    /** 是否启用消息 */
    @Column(name = "OPEN_MQ")
    private String openMQ;

    public void setOpenMQ(String openMQ) {
    this.openMQ = openMQ;
    }

    public String getOpenMQ() {
    return openMQ;
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
