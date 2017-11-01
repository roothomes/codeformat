package com.apec.tempcfgcontents.service.impl;

/** 模型类 */
import com.apec.tempcfgcontents.model.TempCfgContants;
/** 模型DTO类 */
import com.apec.tempcfgcontents.dto.TempCfgContantsDTO;
/** 模型Vo类 */
import com.apec.tempcfgcontents.vo.TempCfgContantsVo;
/** 模型常量类 */
import com.apec.tempcfgcontents.constants.TempCfgContantsContant;
/** 模型常用方法类 */
import com.apec.tempcfgcontents.util.TempCfgContantsUtil;
/** 模型服务接口类 */
import com.apec.tempcfgcontents.service.TempCfgContantsService;
/** 模型DAO类 */
import com.apec.tempcfgcontents.dao.TempCfgContantsDAO;
/** 模型DAO类 */
import com.apec.tempcfgcontents.model.QTempCfgContants;
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
 * 类 编 号：BL_PU10000_12_serviceimpl
 * 类 名 称：TempCfgContantsServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class TempCfgContantsServiceImpl implements TempCfgContantsService,TempCfgContantsContant{
    private static final Logger LOG =  LoggerFactory.getLogger( TempCfgContantsServiceImpl.class);
    @Autowired
    private TempCfgContantsDAO dao;
    @Autowired
    private SnowFlakeKeyGen idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public TempCfgContantsVo create(TempCfgContantsVo vo) throws Exception
    {
        if (Strings.isNullOrEmpty(vo.getMainId())) {
            vo.setMainId(DEFAULT_VAL_MAIN_ID);
        }
        if (Strings.isNullOrEmpty(vo.getContantDesc())) {
            vo.setContantDesc(DEFAULT_VAL_CONTANT_DESC);
        }
        if (Strings.isNullOrEmpty(vo.getContantJavaType())) {
            vo.setContantJavaType(DEFAULT_VAL_CONTANT_JAVA_TYPE);
        }
        if (Strings.isNullOrEmpty(vo.getContantJavaCode())) {
            vo.setContantJavaCode(DEFAULT_VAL_CONTANT_JAVA_CODE);
        }
        if (Strings.isNullOrEmpty(vo.getContantCanNull())) {
            vo.setContantCanNull(DEFAULT_VAL_CONTANT_VAL_CAN_NULL);
        }
        if (Strings.isNullOrEmpty(vo.getContantVal())) {
            vo.setContantVal(DEFAULT_VAL_CONTANT_VAL);
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
        TempCfgContants entity = new TempCfgContants();
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
        TempCfgContants entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public  TempCfgContants updateOrderNumber(String id, Integer orderNumber)
    {
        TempCfgContants entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public  TempCfgContants updateStatus(String id, String status)
    {
        TempCfgContants entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public TempCfgContants updateObject(TempCfgContants vo) {
        TempCfgContants entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置
        if (!Strings.isNullOrEmpty(vo.getMainId())) {
			entity.setMainId(vo.getMainId());
        }
        if (!Strings.isNullOrEmpty(vo.getContantDesc())) {
			entity.setContantDesc(vo.getContantDesc());
        }
        if (!Strings.isNullOrEmpty(vo.getContantJavaType())) {
			entity.setContantJavaType(vo.getContantJavaType());
        }
        if (!Strings.isNullOrEmpty(vo.getContantJavaCode())) {
			entity.setContantJavaCode(vo.getContantJavaCode());
        }
        if (!Strings.isNullOrEmpty(vo.getContantCanNull())) {
			entity.setContantCanNull(vo.getContantCanNull());
        }
        if (!Strings.isNullOrEmpty(vo.getContantVal())) {
			entity.setContantVal(vo.getContantVal());
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
    public TempCfgContants findOne(String id)
    {
        TempCfgContants entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<TempCfgContantsDTO> seachPageDto(TempCfgContantsVo vo, PageRequest pageRequest)
    {
		Page<TempCfgContants> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgContantsDTO> pageDto = new PageDTO<TempCfgContantsDTO>();
		List<TempCfgContantsDTO> list = new ArrayList<TempCfgContantsDTO>();
		for (TempCfgContants tem : page) {
			TempCfgContantsDTO dto = new TempCfgContantsDTO();
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
    public PageDTO<TempCfgContants> seachPageModel(TempCfgContantsVo vo, PageRequest pageRequest)
	{
		Page<TempCfgContants> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgContants> pageDto = new PageDTO<TempCfgContants>();		
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<TempCfgContants> queryAll(TempCfgContantsVo vo)
    {
		TempCfgContants entity = new TempCfgContants();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<TempCfgContants> queryAllModel(TempCfgContants entity) {
		Iterable<TempCfgContants> iterable = dao.findAll(getInputConditionModel(entity));
		Iterator<TempCfgContants> iterator = iterable.iterator();
		List<TempCfgContants> list = new ArrayList<TempCfgContants>();
		while (iterator.hasNext()) {
			TempCfgContants img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(TempCfgContants entity){
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
    private String getCacheKey(TempCfgContants entity) {
        return CACHE_PREFIX + "TempCfgContants_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(TempCfgContants entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QTempCfgContants.tempCfgContants.enableFlag.eq(EnableFlag.Y));
        predicates.add(QTempCfgContants.tempCfgContants.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<TempCfgContants> page = dao.findAll(predicate, sort);
        List<TempCfgContants> list = new ArrayList<TempCfgContants>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), TempCfgContantsUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + TempCfgContantsUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(TempCfgContants entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QTempCfgContants.tempCfgContants.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QTempCfgContants.tempCfgContants.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QTempCfgContants.tempCfgContants.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QTempCfgContants.tempCfgContants.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QTempCfgContants.tempCfgContants.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QTempCfgContants.tempCfgContants.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QTempCfgContants.tempCfgContants.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QTempCfgContants.tempCfgContants.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QTempCfgContants.tempCfgContants.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QTempCfgContants.tempCfgContants.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QTempCfgContants.tempCfgContants.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QTempCfgContants.tempCfgContants.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QTempCfgContants.tempCfgContants.remarks.eq(entity.getRemarks()));
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
	private List<BooleanExpression> getBooleanExpressionList4Model(TempCfgContants entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
		
		if (!Strings.isNullOrEmpty(entity.getMainId())) {
			list.add(QTempCfgContants.tempCfgContants.mainId.like("%" + entity.getMainId() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getContantDesc())) {
			list.add(QTempCfgContants.tempCfgContants.contantDesc.like("%" + entity.getContantDesc() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getContantJavaType())) {
			list.add(QTempCfgContants.tempCfgContants.contantJavaType.like("%" + entity.getContantJavaType() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getContantJavaCode())) {
			list.add(QTempCfgContants.tempCfgContants.contantJavaCode.like("%" + entity.getContantJavaCode() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getContantCanNull())) {
			list.add(QTempCfgContants.tempCfgContants.contantCanNull.like("%" + entity.getContantCanNull() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getContantVal())) {
			list.add(QTempCfgContants.tempCfgContants.contantVal.like("%" + entity.getContantVal() + "%"));
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
	private Predicate getInputConditionModel(TempCfgContants entity) {
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
	private Predicate getInputCondition(TempCfgContantsVo vo) {
		TempCfgContants entity = new TempCfgContants();
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
	private Predicate getInputCondition(TempCfgContantsDTO dto) {
		TempCfgContants entity = new TempCfgContants();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
