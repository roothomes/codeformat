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
@Service
public class ${CLASSNAME} implements ${FACADE_SERVICE_CLASSNAME},${CONTANT_CLASSNAME}
{
     private final Logger LOG =  LoggerFactory.getLogger( getClass());

     @Autowired
     private ${SERVICE_CLASSNAME} service;

     @Override
     public void facadeHello(String userId) throws ApecRuntimeException
     {

     }
}
