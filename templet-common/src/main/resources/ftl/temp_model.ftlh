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
    @Override
    public String toString() {
    	return JsonUtil.toJSONString(this);
    }
}
