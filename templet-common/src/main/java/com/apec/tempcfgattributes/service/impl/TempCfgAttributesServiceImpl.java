package com.apec.tempcfgattributes.service.impl;

/** 模型类 */
import com.apec.tempcfgattributes.model.TempCfgAttributes;
/** 模型DTO类 */
import com.apec.tempcfgattributes.dto.TempCfgAttributesDTO;
/** 模型Vo类 */
import com.apec.tempcfgattributes.vo.TempCfgAttributesVo;
/** 模型常量类 */
import com.apec.tempcfgattributes.constants.TempCfgAttributesContant;
/** 模型常用方法类 */
import com.apec.tempcfgattributes.util.TempCfgAttributesUtil;
/** 模型服务接口类 */
import com.apec.tempcfgattributes.service.TempCfgAttributesService;
/** 模型DAO类 */
import com.apec.tempcfgattributes.dao.TempCfgAttributesDAO;
/** 模型DAO类 */
import com.apec.tempcfgattributes.model.QTempCfgAttributes;
/** 缓存类 */
import com.apec.framework.cache.CacheService;
/** 分页模型类 */
import com.apec.framework.common.PageDTO;
/** 逻辑删除的枚举 */
import com.apec.framework.common.enumtype.EnableFlag;
/** Bean的常用方法 */
import com.apec.framework.common.util.BeanUtil;
/** 主键序列 */
import com.apec.util.SnowFlakeKeyGen;

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
 * 类 编 号：BL_PU10000_11_serviceimpl
 * 类 名 称：TempCfgAttributesServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class TempCfgAttributesServiceImpl implements TempCfgAttributesService,TempCfgAttributesContant{
    private static final Logger LOG =  LoggerFactory.getLogger( TempCfgAttributesServiceImpl.class);
    @Autowired
    private TempCfgAttributesDAO dao;
    @Autowired
    private SnowFlakeKeyGen idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public TempCfgAttributesVo create(TempCfgAttributesVo vo) throws Exception
    {
        if (Strings.isNullOrEmpty(vo.getMainId())) {
            vo.setMainId(DEFAULT_VAL_MAIN_ID);
        }
        if (Strings.isNullOrEmpty(vo.getAttributeId())) {
            vo.setAttributeId(DEFAULT_VAL_ATTRIBUTE_DESC);
        }
        if (Strings.isNullOrEmpty(vo.getAttributeJavaType())) {
            vo.setAttributeJavaType(DEFAULT_VAL_ATTRIBUTE_JAVA_TYPE);
        }
        if (Strings.isNullOrEmpty(vo.getAttributeColumnName())) {
            vo.setAttributeColumnName(DEFAULT_VAL_ATTRIBUTE_COLUMN_NAME);
        }
        if (Strings.isNullOrEmpty(vo.getAttributeJavaCode())) {
            vo.setAttributeJavaCode(DEFAULT_VAL_ATTRIBUTE_JAVA_CODE);
        }
        if (Strings.isNullOrEmpty(vo.getAttributeCanNull())) {
            vo.setAttributeCanNull(DEFAULT_VAL_ATTRIBUTE_VAL_CAN_NULL);
        }
        if (Strings.isNullOrEmpty(vo.getDefaultVal())) {
            vo.setDefaultVal(DEFAULT_VAL);
        }

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
        TempCfgAttributes entity = new TempCfgAttributes();
        BeanUtil.copyPropertiesIgnoreNullFilds(vo, entity, new String[] {});
        entity.setId(String.valueOf(idGen.nextId()));

        entity.setCreateDate(new Date());
        vo.setId(entity.getId());
        dao.save(entity);
        //flushCacheJob(entity);
        return vo;
    }

    @Override
    public void delete(String id)
    {
        TempCfgAttributes entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public  TempCfgAttributes updateOrderNumber(String id, Integer orderNumber)
    {
        TempCfgAttributes entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public  TempCfgAttributes updateStatus(String id, String status)
    {
        TempCfgAttributes entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public TempCfgAttributes updateObject(TempCfgAttributes vo) {
        TempCfgAttributes entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置
        if (!Strings.isNullOrEmpty(vo.getMainId())) {
			entity.setMainId(vo.getMainId());
        }
        if (!Strings.isNullOrEmpty(vo.getAttributeId())) {
			entity.setAttributeId(vo.getAttributeId());
        }
        if (!Strings.isNullOrEmpty(vo.getAttributeJavaType())) {
			entity.setAttributeJavaType(vo.getAttributeJavaType());
        }
        if (!Strings.isNullOrEmpty(vo.getAttributeColumnName())) {
			entity.setAttributeColumnName(vo.getAttributeColumnName());
        }
        if (!Strings.isNullOrEmpty(vo.getAttributeJavaCode())) {
			entity.setAttributeJavaCode(vo.getAttributeJavaCode());
        }
        if (!Strings.isNullOrEmpty(vo.getAttributeCanNull())) {
			entity.setAttributeCanNull(vo.getAttributeCanNull());
        }
        if (!Strings.isNullOrEmpty(vo.getDefaultVal())) {
			entity.setDefaultVal(vo.getDefaultVal());
        }

		//基础属性设置
        if (!Strings.isNullOrEmpty(vo.getId())) {
			entity.setId(vo.getId());
        }
        if (!Strings.isNullOrEmpty(vo.getStatus())) {
			entity.setStatus(vo.getStatus());
        }
        if (null != vo.getEnableFlag()) {
			entity.setEnableFlag(vo.getEnableFlag());
        }
        
        if (null != vo.getCreateDate()) {
			entity.setCreateDate(vo.getCreateDate());
        }
        
        if (null != vo.getLastUpdateDate()) {
			entity.setLastUpdateDate(vo.getLastUpdateDate());
        }
        
        if (!Strings.isNullOrEmpty(vo.getPlantformId())) {
			entity.setPlantformId(vo.getPlantformId());
        }
        if (!Strings.isNullOrEmpty(vo.getOecdNo())) {
			entity.setOecdNo(vo.getOecdNo());
        }
        if (null != vo.getCityId()) {
			entity.setCityId(vo.getCityId());
        }
        if (null != vo.getOrderNumber()) {
			entity.setOrderNumber(vo.getOrderNumber());
        }
        return entity;
    }
	

	@Override
    public TempCfgAttributes findOne(String id)
    {
        TempCfgAttributes entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<TempCfgAttributesDTO> seachPageDto(TempCfgAttributesVo vo, PageRequest pageRequest)
    {
		Page<TempCfgAttributes> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgAttributesDTO> pageDto = new PageDTO<TempCfgAttributesDTO>();
		List<TempCfgAttributesDTO> list = new ArrayList<TempCfgAttributesDTO>();
		for (TempCfgAttributes tem : page) {
			TempCfgAttributesDTO dto = new TempCfgAttributesDTO();
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
    public PageDTO<TempCfgAttributes> seachPageModel(TempCfgAttributesVo vo, PageRequest pageRequest)
	{
		Page<TempCfgAttributes> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgAttributes> pageDto = new PageDTO<TempCfgAttributes>();		
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<TempCfgAttributes> queryAll(TempCfgAttributesVo vo)
    {
		TempCfgAttributes entity = new TempCfgAttributes();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<TempCfgAttributes> queryAllModel(TempCfgAttributes entity) {
		Iterable<TempCfgAttributes> iterable = dao.findAll(getInputConditionModel(entity));
		Iterator<TempCfgAttributes> iterator = iterable.iterator();
		List<TempCfgAttributes> list = new ArrayList<TempCfgAttributes>();
		while (iterator.hasNext()) {
			TempCfgAttributes img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(TempCfgAttributes entity){
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
    private String getCacheKey(TempCfgAttributes entity) {
        return CACHE_PREFIX + "TempCfgAttributes_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(TempCfgAttributes entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QTempCfgAttributes.tempCfgAttributes.enableFlag.eq(EnableFlag.Y));
        predicates.add(QTempCfgAttributes.tempCfgAttributes.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<TempCfgAttributes> page = dao.findAll(predicate, sort);
        List<TempCfgAttributes> list = new ArrayList<TempCfgAttributes>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), TempCfgAttributesUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + TempCfgAttributesUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(TempCfgAttributes entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QTempCfgAttributes.tempCfgAttributes.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QTempCfgAttributes.tempCfgAttributes.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QTempCfgAttributes.tempCfgAttributes.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QTempCfgAttributes.tempCfgAttributes.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QTempCfgAttributes.tempCfgAttributes.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QTempCfgAttributes.tempCfgAttributes.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QTempCfgAttributes.tempCfgAttributes.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QTempCfgAttributes.tempCfgAttributes.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QTempCfgAttributes.tempCfgAttributes.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QTempCfgAttributes.tempCfgAttributes.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QTempCfgAttributes.tempCfgAttributes.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QTempCfgAttributes.tempCfgAttributes.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QTempCfgAttributes.tempCfgAttributes.remarks.eq(entity.getRemarks()));
        }
        return list;
    }
	
    /**
     * 获取对象模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
	private List<BooleanExpression> getBooleanExpressionList4Model(TempCfgAttributes entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
		
		if (!Strings.isNullOrEmpty(entity.getMainId())) {
			list.add(QTempCfgAttributes.tempCfgAttributes.mainId.like("%" + entity.getMainId() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getAttributeId())) {
			list.add(QTempCfgAttributes.tempCfgAttributes.attributeId.like("%" + entity.getAttributeId() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getAttributeJavaType())) {
			list.add(QTempCfgAttributes.tempCfgAttributes.attributeJavaType.like("%" + entity.getAttributeJavaType() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getAttributeColumnName())) {
			list.add(QTempCfgAttributes.tempCfgAttributes.attributeColumnName.like("%" + entity.getAttributeColumnName() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getAttributeJavaCode())) {
			list.add(QTempCfgAttributes.tempCfgAttributes.attributeJavaCode.like("%" + entity.getAttributeJavaCode() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getAttributeCanNull())) {
			list.add(QTempCfgAttributes.tempCfgAttributes.attributeCanNull.like("%" + entity.getAttributeCanNull() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getDefaultVal())) {
			list.add(QTempCfgAttributes.tempCfgAttributes.defaultVal.like("%" + entity.getDefaultVal() + "%"));
		}

		return list;
	}
	
    /**
     * 获取对象模型的JPA查询断言
     * @param entity 模型对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
	private Predicate getInputConditionModel(TempCfgAttributes entity) {
		List<BooleanExpression> predicates = getBooleanExpressionList4Model(entity);
		return BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
	}
	
    /**
     * 获取Vo对象的JPA查询断言
     * @param vo VO对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
	private Predicate getInputCondition(TempCfgAttributesVo vo) {
		TempCfgAttributes entity = new TempCfgAttributes();
		BeanUtil.copyProperties(vo, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
	
    /**
     * 获取Dto对象的JPA查询断言
     * @param dto DTO对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
	private Predicate getInputCondition(TempCfgAttributesDTO dto) {
		TempCfgAttributes entity = new TempCfgAttributes();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
