package ${PACKAGE};


<#list PACKAGES as p>
    <#if p.desc??>
/** ${p.desc} */
    </#if>
${p.importPackage}
</#list>

import com.apec.framework.common.enumtype.EnableFlag;
import com.apec.framework.dto.BaseDTO;

public class ${CLASSNAME} extends BaseDTO
{
private static final long serialVersionUID = 1L;


<#list ATTRIBUTE as a>
    <#if a.desc??>
    /** ${a.desc} */
    </#if>
    private ${a.type} ${a.javaCode};
    /** ${a.desc} */
    public void set${a.javaCode?substring(0)}(${a.type} ${a.javaCode}) {
        this.${a.javaCode} = ${a.javaCode};
    }
    /** ${a.desc} */
    public ${a.type} get${a.javaCode?substring(0)}() {
        return ${a.javaCode};
    }

</#list>



}
