package ${PACKAGE};

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


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
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
@Import(value = {SpringCloudConfig.class})
public class ${CLASSNAME} extends BaseApplication{

    public static void main(String[] args) 
    {
    	System.out.println("${CLASSNAME} start!");
        new SpringApplicationBuilder(${CLASSNAME}.class).web(true).run(args);
    }
}
