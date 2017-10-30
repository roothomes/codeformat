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

/**
 * 类 编 号：${CLASS_SERIALNO}
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */

@Service
public class ${CLASSNAME} implements ${SERVICE_CLASSNAME},${CONTANT_CLASSNAME}{
    private static final Logger LOG =  LoggerFactory.getLogger( ${CLASSNAME}.class);
    @Autowired
    private ${DAO_CLASSNAME} dao;
    @Autowired
    private SnowFlakeKeyGen idGen;
    @Autowired
    private CacheService cacheService;

	
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

    @Override
    public void delete(${PK_ID_TYPE} id)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public  ${MODEL_CLASSNAME} updateOrderNumber(${PK_ID_TYPE} id, Integer orderNumber)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public  ${MODEL_CLASSNAME} updateStatus(${PK_ID_TYPE} id, String status)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public ${MODEL_CLASSNAME} updateObject(${MODEL_CLASSNAME} vo) {
        ${MODEL_CLASSNAME} entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置
<#list ATTRIBUTE_CAN_NULL as x>
    <#if x=='0'>
        <#if ATTRIBUTE[x_index].type =='String'>
        if (!Strings.isNullOrEmpty(vo.get${ATTRIBUTE[x_index].javaCode?cap_first}())) {
			entity.set${ATTRIBUTE[x_index].javaCode?cap_first}(vo.get${ATTRIBUTE[x_index].javaCode?cap_first}());
        }
        <#elseif ATTRIBUTE[x_index].type =='Integer'>
        if (null != vo.get${ATTRIBUTE[x_index].javaCode?cap_first}()) {
			entity.set${ATTRIBUTE[x_index].javaCode?cap_first}(vo.get${ATTRIBUTE[x_index].javaCode?cap_first}());
        }
        <#else>
        if (null != vo.get${ATTRIBUTE[x_index].javaCode?cap_first}()) {
			entity.set${ATTRIBUTE[x_index].javaCode?cap_first}(vo.get${ATTRIBUTE[x_index].javaCode?cap_first}());
        }
        
        </#if>
    </#if>
</#list>

		//基础属性设置
<#list BASE_ATTRIBUTE_CAN_NULL as x>
    <#if x=='0'>
        <#if BASE_ATTRIBUTE[x_index].type =='String'>
        if (!Strings.isNullOrEmpty(vo.get${BASE_ATTRIBUTE[x_index].javaCode?cap_first}())) {
			entity.set${BASE_ATTRIBUTE[x_index].javaCode?cap_first}(vo.get${BASE_ATTRIBUTE[x_index].javaCode?cap_first}());
        }
        <#elseif BASE_ATTRIBUTE[x_index].type =='Integer'>
        if (null != vo.get${BASE_ATTRIBUTE[x_index].javaCode?cap_first}()) {
			entity.set${BASE_ATTRIBUTE[x_index].javaCode?cap_first}(vo.get${BASE_ATTRIBUTE[x_index].javaCode?cap_first}());
        }
        <#else>
        if (null != vo.get${BASE_ATTRIBUTE[x_index].javaCode?cap_first}()) {
			entity.set${BASE_ATTRIBUTE[x_index].javaCode?cap_first}(vo.get${BASE_ATTRIBUTE[x_index].javaCode?cap_first}());
        }
        
        </#if>
    </#if>
</#list>
        return entity;
    }
	

	@Override
    public ${MODEL_CLASSNAME} findOne(${PK_ID_TYPE} id)
    {
        ${MODEL_CLASSNAME} entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<${DTO_CLASSNAME}> seachPageDto(${VO_CLASSNAME} vo, PageRequest pageRequest)
    {
		Page<${MODEL_CLASSNAME}> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<${DTO_CLASSNAME}> pageDto = new PageDTO<${DTO_CLASSNAME}>();
		List<${DTO_CLASSNAME}> list = new ArrayList<${DTO_CLASSNAME}>();
		for (${MODEL_CLASSNAME} tem : page) {
			${DTO_CLASSNAME} dto = new ${DTO_CLASSNAME}();
			BeanUtil.copyPropertiesIgnoreNullFilds(tem, dto);
			list.add(dto);
		}
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(list);
		return pageDto;
    }

	@Override
    public PageDTO<${MODEL_CLASSNAME}> seachPageModel(${VO_CLASSNAME} vo, PageRequest pageRequest)
	{
		Page<${MODEL_CLASSNAME}> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<${MODEL_CLASSNAME}> pageDto = new PageDTO<${MODEL_CLASSNAME}>();		
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<${MODEL_CLASSNAME}> queryAll(${VO_CLASSNAME} vo)
    {
		${MODEL_CLASSNAME} entity = new ${MODEL_CLASSNAME}();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<${MODEL_CLASSNAME}> queryAllModel(${MODEL_CLASSNAME} entity) {
		Iterable<${MODEL_CLASSNAME}> iterable = dao.findAll(getInputConditionModel(entity));
		Iterator<${MODEL_CLASSNAME}> iterator = iterable.iterator();
		List<${MODEL_CLASSNAME}> list = new ArrayList<${MODEL_CLASSNAME}>();
		while (iterator.hasNext()) {
			${MODEL_CLASSNAME} img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(${MODEL_CLASSNAME} entity){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                flushCache(entity);
            }
        };
        r.run();
    }
	
    /**
     * 获取对象的缓存Key
     * @param entity 对象
     * @return
     */
    private String getCacheKey(${MODEL_CLASSNAME} entity) {
        return CACHE_PREFIX + "${MODEL_CLASSNAME}_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
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
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(${MODEL_CLASSNAME} entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.remarks.eq(entity.getRemarks()));
        }
        return list;
    }
	
    /**
     * 获取对象模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
	private List<BooleanExpression> getBooleanExpressionList4Model(${MODEL_CLASSNAME} entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
		
<#list ATTRIBUTE_CAN_NULL as x>
<#if x=='0'>
	<#if ATTRIBUTE[x_index].type =='String'>
		if (!Strings.isNullOrEmpty(entity.get${ATTRIBUTE[x_index].javaCode?cap_first}())) {
			list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.${ATTRIBUTE[x_index].javaCode?uncap_first}.like("%" + entity.get${ATTRIBUTE[x_index].javaCode?cap_first}() + "%"));
		}
	<#elseif ATTRIBUTE[x_index].type =='Integer'>
		if (null != entity.get${ATTRIBUTE[x_index].javaCode?cap_first}()) {
			list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.${ATTRIBUTE[x_index].javaCode?uncap_first}.eq(entity.get${ATTRIBUTE[x_index].javaCode?cap_first}()));
		}
	<#else>
		if (null != entity.get${ATTRIBUTE[x_index].javaCode?cap_first}()) {
			list.add(Q${MODEL_CLASSNAME}.${MODEL_CLASSNAME?uncap_first}.${ATTRIBUTE[x_index].javaCode?uncap_first}.eq(entity.get${ATTRIBUTE[x_index].javaCode?cap_first}()));
		}
	</#if>
</#if>
</#list>

		return list;
	}
	
    /**
     * 获取对象模型的JPA查询断言
     * @param entity 模型对象
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
	private Predicate getInputConditionModel(${MODEL_CLASSNAME} entity) {
		List<BooleanExpression> predicates = getBooleanExpressionList4Model(entity);
		return BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
	}
	
    /**
     * 获取Vo对象的JPA查询断言
     * @param vo VO对象
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
	private Predicate getInputCondition(${VO_CLASSNAME} vo) {
		${MODEL_CLASSNAME} entity = new ${MODEL_CLASSNAME}();
		BeanUtil.copyProperties(vo, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
	
    /**
     * 获取Dto对象的JPA查询断言
     * @param dto DTO对象
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
	private Predicate getInputCondition(${DTO_CLASSNAME} dto) {
		${MODEL_CLASSNAME} entity = new ${MODEL_CLASSNAME}();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
