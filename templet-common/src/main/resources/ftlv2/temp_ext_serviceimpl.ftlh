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
public class ${CLASSNAME} implements ${EXT_SERVICE_CLASSNAME},${CONTANT_CLASSNAME}
{
     private final Logger LOG =  LoggerFactory.getLogger( getClass());

     @Autowired
     private ${SERVICE_CLASSNAME} service;

     @Autowired
     private CacheService cacheService;

     @Override
     @Transactional
     public void extHello(String userId) throws ApecRuntimeException
     {

     }
}
