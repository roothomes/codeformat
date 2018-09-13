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
public class ${CLASSNAME} extends BaseApplication{

    public static void main(String[] args) 
    {
    	System.out.println("${CLASSNAME} start!");
        new SpringApplicationBuilder(${CLASSNAME}.class).web(true).run(args);
    }
}
