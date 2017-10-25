package ${PACKAGE};


<#list PACKAGES as p>
<#if p.desc??>/** ${p.desc} */</#if>
${p.importPackage}
</#list>

/**
 * <#if MODELDESC??> ${MODELDESC}</#if>
 * @author <#if CREATE_AUTHOR??> ${CREATE_AUTHOR}</#if>
 * @version V1.0
 * @date <#if CREAT_DATE??> ${CREAT_DATE}</#if>
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


}
