package ${PACKAGE};

<#list PACKAGES as p>
<#if p.desc??>/** ${p.desc} */</#if>
import ${p.importPackage};
</#list>

import java.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;

@Service
public class ${CLASSNAME} implements ${SERVICE_CLASSNAME},${CONTANT_CLASSNAME}{
    private static final Logger LOG = Logger.getLogger( ${CLASSNAME}.class);
    @Autowired
    private ${DAO_CLASSNAME} dao;
    @Autowired
    private SnowFlakeKeyGen idGen;
    @Autowired
    private CacheService cacheService;
    /**
     * 创建一个对象
     * @param vo 对象
     * @return
     */
@Override
@Transactional
    public ${VO_CLASSNAME} create(${VO_CLASSNAME} vo) throws Exception
    {
       return null;
    }
    /**
     * 逻辑删除一个对象
     * @param id 主键id
     * @return
     */
public void delete(${PK_ID_TYPE} id)
{
}
    /**
     * 更新排序
     * @param id 主键id
     * @param orderNumber
     * @return
     */
public  ${MODEL_CLASSNAME} updateOrderNumber(${PK_ID_TYPE} id, Integer orderNumber)
{
return null;
}
    /**
     * 更新状态
     * @param id 主键id
     * @param status 状态
     * @return
     */
public  ${MODEL_CLASSNAME} updateStatus(${PK_ID_TYPE} id, String status)
{
return null;
}
    /**
     * 更新对象模型
     * @param vo 对象
     * @return
     */
public   ${MODEL_CLASSNAME} updateObject(${MODEL_CLASSNAME} vo)
{
return null;
}

    /**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     */
public  PageDTO<${MODEL_CLASSNAME}> seachPage(${VO_CLASSNAME} vo, PageRequest pageRequest)
{
return null;
}
    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return
     */
public   ${MODEL_CLASSNAME} findOne(${PK_ID_TYPE} id)
{
return null;
}

    /**
     * 查询数据列表
     * @param vo
     * @return
     */
public    List<${MODEL_CLASSNAME}> queryAll(${VO_CLASSNAME} vo)
{
return null;
}
}
