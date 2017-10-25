package ${PACKAGE};


import com.apec.framework.common.Constants;
import com.apec.framework.common.enumtype.EnableFlag;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * 类 编 号：BL_PU6030202_BaseModel
 * 类 名 称：BaseModel
 * 内容摘要：框架基本实体类,所有的实体需集成该类
 * 完成日期：2016-07-14
 * 编码作者：
 */
@MappedSuperclass
@EntityListeners(
{AuditingEntityListener.class})
public class BaseModel<PK extends Serializable> implements Persistable<PK>
{

    private static final long serialVersionUID = -2477722490039509121L;

    @Id
    @GeneratedValue(generator = Constants.SYSTEM_GENERATOR)
    @Column(name = "ID")
    private PK id;

    @Column(name = "STATUS")
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(name = "ENABLE_FLAG")
    private EnableFlag enableFlag = EnableFlag.Y;

    @Column(name = "CREATE_BY", updatable = false)
    private String createBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    @Column(name = "CREATE_DATE", updatable = false)
    private Date createDate;

    @Column(name = "LAST_UPDATE_BY")
    private String lastUpdateBy;

    @Column(name = "LAST_UPDATE_DATE")
    @LastModifiedDate
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;

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

    public void setId(PK id)
    {
        this.id = id;
    }

    @Override
    public PK getId()
    {
        return id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public EnableFlag getEnableFlag()
    {
        return enableFlag;
    }

    public void setEnableFlag(EnableFlag enableFlag)
    {
        this.enableFlag = enableFlag;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public String getLastUpdateBy()
    {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy)
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }


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
    @JsonIgnore
    public boolean isNew()
    {
        return null == this.id;
    }

}
