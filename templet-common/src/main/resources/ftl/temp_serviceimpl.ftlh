package ${PACKAGE};

<#list PACKAGES as p>
<#if p.desc??>/** ${p.desc} */</#if>
import ${p.importPackage};
</#list>

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ${CLASSNAME} implements ${SERVICE_CLASSNAME},${CONTANT_CLASSNAME}{
    private static final Logger LOG =  LoggerFactory.getLogger( ${CLASSNAME}.class);
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
    <#list ATTRIBUTE_CAN_NULL as x>
    <#-- ${ATTRIBUTE[x_index].javaCode} -->
    <#if x=='0'>
        <#if ATTRIBUTE[x_index].type =='String'>
        if (Strings.isNullOrEmpty(vo.get${ATTRIBUTE[x_index].javaCode?cap_first}())) {
            vo.set${ATTRIBUTE[x_index].javaCode?cap_first}(${ATTRIBUTE_DEFAULT_VAL[x_index]});
        }
        <#elseif ATTRIBUTE[x_index].type =='Integer'>

        </#if>
    </#if>
    </#list>

        //基础字段默认值
        if (null == vo.getCityId()) {
            vo.setCityId(DEFAULT_CITY_ID);
        }
        if (Strings.isNullOrEmpty(vo.getStatus())) {
            vo.setStatus(STATUS_INVALID);
        }
        if (Strings.isNullOrEmpty(vo.getPlantformId())) {
            vo.setPlantformId(DEFAULT_PLANTFORM_ID);
        }
        if (Strings.isNullOrEmpty(vo.getOecdNo())) {
            vo.setOecdNo(DEFAULT_OECD_NO);
        }
        if (null == vo.getEnableFlag()) {
            vo.setEnableFlag(EnableFlag.Y);
        }
        if (null == vo.getCreateDate()) {
            vo.setCreateDate(new Date());
        }

        //属性拷贝保存到数据库刷新缓存
        ${MODEL_CLASSNAME} entity = new ${MODEL_CLASSNAME}();
        BeanUtil.copyPropertiesIgnoreNullFilds(vo, entity, new String[] {});
        <#if PK_ID_TYPE == 'String'>
        entity.setId(String.valueOf(idGen.nextId()));
        <#elseif PK_ID_TYPE == 'Long'>
        entity.setId(idGen.nextId());
        </#if>

        entity.setCreateDate(new Date());
        vo.setId(entity.getId());
        dao.save(entity);
        //flushCacheJob(entity);
        return vo;
    }
    /**
     * 逻辑删除一个对象
     * @param id 主键id
     * @return
     */
    @Override
    public void delete(${PK_ID_TYPE} id)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }
    /**
     * 更新排序
     * @param id 主键id
     * @param orderNumber
     * @return
     */
    @Override
    public  ${MODEL_CLASSNAME} updateOrderNumber(${PK_ID_TYPE} id, Integer orderNumber)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }
    /**
     * 更新状态
     * @param id 主键id
     * @param status 状态
     * @return
     */
    @Override
    public  ${MODEL_CLASSNAME} updateStatus(${PK_ID_TYPE} id, String status)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }
    /**
     * 更新对象模型
     * @param vo 对象
     * @return
     */
    @Override
    public Notice updateObject(Notice vo) {
        ${MODEL_CLASSNAME} entity = dao.findOne(vo.getId());
        if(null == entity){
        LOG.error("查询数据为空,id={}",vo.getId());
        return null;
        }
<#list ATTRIBUTE_CAN_NULL as x>
    <#if x=='0'>
        <#if ATTRIBUTE[x_index].type =='String'>
        if (!Strings.isNullOrEmpty(vo.get${ATTRIBUTE[x_index].javaCode?cap_first}())) {
        entity.set${ATTRIBUTE[x_index].javaCode?cap_first}(vo.get${ATTRIBUTE[x_index].javaCode?cap_first}());
        }
        <#elseif ATTRIBUTE[x_index].type =='Integer'>

        </#if>
    </#if>
</#list>
        return entity;
    }
	
    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return
     */
    public ${MODEL_CLASSNAME} findOne(${PK_ID_TYPE} id)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        return entity;
    }
	
    /**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     */
    @Override
    public PageDTO<${MODEL_CLASSNAME}> seachPage(${VO_CLASSNAME} vo, PageRequest pageRequest)
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

    private void flushCacheJob(${MODEL_CLASSNAME} entity){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                flushCache(entity);
            }
        };
        r.run();
    }
    private String getCacheKey(${MODEL_CLASSNAME} entity) {
        return CACHE_PREFIX + "${MODEL_CLASSNAME}_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     *
     * @param itemType
     */
    private void flushCache(${MODEL_CLASSNAME} entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.enableFlag.eq(EnableFlag.Y));
        predicates.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<${MODEL_CLASSNAME}> page = dao.findAll(predicate, sort);
        List<${MODEL_CLASSNAME}> list = new ArrayList<${MODEL_CLASSNAME}>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), ${UTIL_CLASSNAME}.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + ${UTIL_CLASSNAME}.toJson(list));
    }
}
