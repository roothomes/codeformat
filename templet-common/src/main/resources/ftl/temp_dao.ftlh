package ${PACKAGE};

<#list PACKAGES as p>
<#if p.desc??>/** ${p.desc} */</#if>
${p.importPackage}
</#list>

import com.apec.framework.jpa.dao.BaseDAO;

public interface ${CLASSNAME} extends BaseDAO<${MODEL_CLASSNAME}, ${PK_ID_TYPE}> {

}
