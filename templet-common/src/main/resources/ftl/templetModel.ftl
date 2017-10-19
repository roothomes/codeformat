package ${model.package.base}.model;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.apec.framework.common.Constants;
import com.apec.framework.jpa.model.BaseModel;

@Entity
@Table(name = "upload_files")
@DynamicUpdate
@GenericGenerator(name = Constants.SYSTEM_GENERATOR, strategy = Constants.ASSIGNED)
public class UploadFiles extends BaseModel<String> {
	
	private static final long serialVersionUID = -907165640717713872L;

	/** 客户席位号 */
	@Column(name = "erp_no")
    private String erpNo;
	
	/** 客户id */
	@Column(name = "user_id")
    private String userId;
	
	/** 结算单日期 */
	@Column(name = "business_date")
    private Date businessDate;
	
	/** 类型(业务类型) */
	@Column(name = "business_type")
    private String businessType;
	
	/** 业务id */
	@Column(name = "business_id")
    private String businessId;
	
	/** 上级文件id */
	@Column(name = "upfile_id")
	private String upfileId;
	
	/** 文件类型(pdf,png) */
	@Column(name = "file_type")
    private String fileType;

	/** 文件路径id */
	@Column(name = "file_path_id")
    private String filePathId;
	/** 文件上传路径 */
	@Column(name = "file_path")
    private String filePath;
	/** 文件来源(upload、switch_pdf2png) */
	@Column(name = "f_source")
    private String fSource;
	/** 结算单金额 */
	@Column(name = "amount")
    private BigDecimal amount;
	/** 客户编号 */
	@Column(name = "customerId")
	private String customerId;
	
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

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getUpfileId() {
		return upfileId;
	}

	public void setUpfileId(String upfileId) {
		this.upfileId = upfileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePathId() {
		return filePathId;
	}

	public void setFilePathId(String filePathId) {
		this.filePathId = filePathId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getfSource() {
		return fSource;
	}

	public void setfSource(String fSource) {
		this.fSource = fSource;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getErpNo() {
		return erpNo;
	}

	public void setErpNo(String erpNo) {
		this.erpNo = erpNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
}
