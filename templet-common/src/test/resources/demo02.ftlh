package ${GROUPID}.${ARTIFACTID}.model;


<#list PACKAGE as p>
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
public class ${CLASSNAME} extends BaseModel<String>
{
    private static final long serialVersionUID = 1L;


<#list ATTRIBUTE as a>
    <#if a.desc??>
    /** ${a.desc} */
    </#if>
    @Column(name = "${a.dbCode}")
    private ${a.type} ${a.javaCode};

    public void set${a.javaCode?substring(0)}(${a.type} ${a.javaCode}) {
        this.${a.javaCode} = ${a.javaCode};
    }

    public ${a.type} get${a.javaCode?substring(0)}() {
        return ${a.javaCode};
    }

</#list>



}
