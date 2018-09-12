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
public class ${CLASSNAME} extends BaseDTO
{
    private static final long serialVersionUID = 1L;

<#-- 属性列表 -->
<#list ATTRIBUTE as a>
    <#if a.desc??>/** ${a.desc} */</#if>
    <#if a.type == "EnableFlag">
    private ${a.type} ${a.javaCode} = EnableFlag.Y;
    <#else>
    private ${a.type} ${a.javaCode};
    </#if>
</#list>

<#-- 属性的get set方法 -->
<#list ATTRIBUTE as a>
    <#if a.desc??>/** ${a.desc} */</#if>
    public void set${a.javaCode?cap_first}(${a.type} ${a.javaCode}) {
        this.${a.javaCode} = ${a.javaCode};
    }
    <#if a.desc??>/** ${a.desc} */</#if>
    public ${a.type} get${a.javaCode?cap_first}() {
       return ${a.javaCode};
    }
</#list>

    @Override
    public String toString() {
    	return JsonUtil.toJSONString(this);
    }
}
