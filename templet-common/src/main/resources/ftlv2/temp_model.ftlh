package ${PACKAGE};


<#list PACKAGES as p>
    <#if p.desc??>
/** ${p.desc} */
    </#if>
import ${p.importPackage};
</#list>


<#list ANNOTATION as a>
    <#if a.desc??>
/** ${a.desc} */
    </#if>
${a.name}
</#list>

/**
 * 类 编 号：${CLASS_SERIALNO}
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

    @Override
    public String toString() {
        return JsonUtils.toJSONString(this);
    }
}
