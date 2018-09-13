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
public interface ${CLASSNAME} {
    /**
     * 示例接口
     * @param userId 用户编号
     * @return
	 * @throws ApecRuntimeException
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    void facadeHello(String userId) throws ApecRuntimeException;
}
