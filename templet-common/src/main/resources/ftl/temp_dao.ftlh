package ${PACKAGE};

<#list PACKAGES as p>
<#if p.desc??>/** ${p.desc} */</#if>
${p.importPackage}
</#list>

import com.apec.framework.jpa.dao.BaseDAO;


/**
 * 类 编 号：${CLASS_SERIALNO}
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */
public interface ${CLASSNAME} extends BaseDAO<${MODEL_CLASSNAME}, ${PK_ID_TYPE}> {

}
