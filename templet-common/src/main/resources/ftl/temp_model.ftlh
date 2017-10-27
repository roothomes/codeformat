package ${PACKAGE};


<#list PACKAGES as p>
    <#if p.desc??>
/** ${p.desc} */
    </#if>
${p.importPackage}
</#list>


<#list ANNOTATION as a>
    <#if a.desc??>
/** ${a.desc} */
    </#if>
${a.name}
</#list>

/**
 * 类 编 号：
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */
public class ${CLASSNAME} extends BaseModel<${PK_ID_TYPE}>
{
    private static final long serialVersionUID = 1L;


<#list ATTRIBUTE as a>
    <#if a.desc??>
    /** ${a.desc} */
    </#if>
    @Column(name = "${a.dbCode}")
    private ${a.type} ${a.javaCode};

    public void set${a.javaCode?cap_first}(${a.type} ${a.javaCode}) {
    this.${a.javaCode} = ${a.javaCode};
    }

    public ${a.type} get${a.javaCode?cap_first}() {
    return ${a.javaCode};
    }

</#list>

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
