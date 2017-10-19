package ${model.package.base}.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.apec.framework.common.Constants;
import com.apec.framework.common.enumtype.EnableFlag;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private static final long serialVersionUID = 1L;

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
    
    /**  排序 */
	@Column(name = "ORDER_NUMBER")
    private Integer orderNumber;

	/** 平台id */
	@Column(name = "PLATFORM_ID")
	private String platformId;

	/** 所属组织编号 */
	@Column(name = "OECD_NO")
	private String oecdNo;

	/** 备注 */
	@Column(name = "REMARKS")
	private String remarks;
	
	@Column(name = "CITY_ID")
    private Integer cityId;
	
	/**
	 * 主键
	 * @param id
	 */
    public void setId(PK id)
    {
        this.id = id;
    }
    
    @Override
    public PK getId()
    {
        return id;
    }
    
    /**
     * 状态（1：有效；0：无效）
     * @return
     */
    public String getStatus()
    {
        return status;
    }
    /**
     * 状态（1：有效；0：无效）
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    /**
     * 软删除标志（有效为Y，删除为N）
     * @return
     */
    public EnableFlag getEnableFlag()
    {
        return enableFlag;
    }
    /**
     * 软删除标志（有效为Y，删除为N）
     * @param enableFlag
     */
    public void setEnableFlag(EnableFlag enableFlag)
    {
        this.enableFlag = enableFlag;
    }

    /**
     * 创建人
     * @return
     */
    public String getCreateBy()
    {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy
     */
    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     * @return
     */
    public Date getCreateDate()
    {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate
     */
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    /**
     * 最后修改人
     * @return
     */
    public String getLastUpdateBy()
    {
        return lastUpdateBy;
    }

    /**
     * 最后修改人
     * @param lastUpdateBy
     */
    public void setLastUpdateBy(String lastUpdateBy)
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * 最后修改时间
     * @return
     */
    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    /**
     * 最后修改时间
     * @param lastUpdateDate
     */
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    @JsonIgnore
    public boolean isNew()
    {
        return null == this.id;
    }
    
    /**
     * 排序
     * @return
     */
	public Integer getOrderNumber() {
		return orderNumber;
	}
	/**
	 * 排序
	 * @param orderNumber
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * 平台id
	 * @return
	 */
	public String getPlatformId() {
		return platformId;
	}
	/**
	 * 平台id
	 * @param platformId
	 */
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	/**
	 * 组织编码
	 * @return
	 */
	public String getOecdNo() {
		return oecdNo;
	}
	/**
	 * 组织编码
	 * @param oecdNo
	 */
	public void setOecdNo(String oecdNo) {
		this.oecdNo = oecdNo;
	}
	/**
	 * 备注
	 * @return
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 备注
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 城市编码
	 * @return
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 城市编码
	 * @param cityId
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}
