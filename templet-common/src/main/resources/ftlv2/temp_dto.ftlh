package ${PACKAGE};


<#list PACKAGES as p>
<#if p.desc??>/** ${p.desc} */</#if>
import ${p.importPackage};
</#list>

/**
 * 类 编 号：${CLASS_SERIALNO}
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */
<#list ANNOTATION as a>
    <#if a.desc??>
    /** ${a.desc} */
    </#if>
${a.name}
</#list>
public class ${CLASSNAME} extends BaseDTO
{
    private static final long serialVersionUID = 1L;

<#-- 属性列表 -->
<#list ATTRIBUTE as a>
    private ${a.type} ${a.javaCode};
</#list>

    private String Id;
    private Integer version;
    private String remark;
    private String status;
    private EnableFlag enableFlag;
    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    private String lastUpdateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateDate;

    private String plantformId;
    private String oecdNo;
    private Integer cityId;
    private Integer orderNumber;
    private String remarks;

    @Override
    public String toString() {
    	return JsonUtils.toJSONString(this);
    }
}
