package com.apec.tempcfgredis.service.impl;

/** 模型类 */
import com.apec.tempcfgredis.model.TempCfgRedis;
/** 模型DTO类 */
import com.apec.tempcfgredis.dto.TempCfgRedisDTO;
/** 模型Vo类 */
import com.apec.tempcfgredis.vo.TempCfgRedisVo;
/** 模型常量类 */
import com.apec.tempcfgredis.constants.TempCfgRedisContant;
/** 模型常用方法类 */
import com.apec.tempcfgredis.util.TempCfgRedisUtil;
/** 模型服务接口类 */
import com.apec.tempcfgredis.service.TempCfgRedisService;
/** 模型DAO类 */
import com.apec.tempcfgredis.dao.TempCfgRedisDAO;
/** 模型DAO类 */
import com.apec.tempcfgredis.model.QTempCfgRedis;
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
 * 类 编 号：BL_PU10000_10_serviceimpl
 * 类 名 称：TempCfgRedisServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class TempCfgRedisServiceImpl implements TempCfgRedisService,TempCfgRedisContant{
    private static final Logger LOG =  LoggerFactory.getLogger( TempCfgRedisServiceImpl.class);
    @Autowired
    private TempCfgRedisDAO dao;
    @Autowired
    private SnowFlakeKeyGen idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public TempCfgRedisVo create(TempCfgRedisVo vo) throws Exception
    {
        if (Strings.isNullOrEmpty(vo.getRedisType())) {
            vo.setRedisType(DEFAULT_VAL_REDIS_TYPE_SINGLETON);
        }
        if (Strings.isNullOrEmpty(vo.getRedisIp())) {
            vo.setRedisIp(DEFAULT_VAL_REDIS_IP);
        }
        if (Strings.isNullOrEmpty(vo.getRedisPort())) {
            vo.setRedisPort(DEFAULT_VAL_REDIS_PORT);
        }
        if (Strings.isNullOrEmpty(vo.getRedisPassword())) {
            vo.setRedisPassword(DEFAULT_VAL_REDIS_PASSWORD);
        }
        if (Strings.isNullOrEmpty(vo.getRedisIndex())) {
            vo.setRedisIndex(DEFAULT_VAL_REDIS_INDEX);
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
        TempCfgRedis entity = new TempCfgRedis();
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
        TempCfgRedis entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public  TempCfgRedis updateOrderNumber(String id, Integer orderNumber)
    {
        TempCfgRedis entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public  TempCfgRedis updateStatus(String id, String status)
    {
        TempCfgRedis entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public TempCfgRedis updateObject(TempCfgRedis vo) {
        TempCfgRedis entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置
        if (!Strings.isNullOrEmpty(vo.getRedisType())) {
			entity.setRedisType(vo.getRedisType());
        }
        if (!Strings.isNullOrEmpty(vo.getRedisIp())) {
			entity.setRedisIp(vo.getRedisIp());
        }
        if (!Strings.isNullOrEmpty(vo.getRedisPort())) {
			entity.setRedisPort(vo.getRedisPort());
        }
        if (!Strings.isNullOrEmpty(vo.getRedisPassword())) {
			entity.setRedisPassword(vo.getRedisPassword());
        }
        if (!Strings.isNullOrEmpty(vo.getRedisIndex())) {
			entity.setRedisIndex(vo.getRedisIndex());
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
    public TempCfgRedis findOne(String id)
    {
        TempCfgRedis entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<TempCfgRedisDTO> seachPageDto(TempCfgRedisVo vo, PageRequest pageRequest)
    {
		Page<TempCfgRedis> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgRedisDTO> pageDto = new PageDTO<TempCfgRedisDTO>();
		List<TempCfgRedisDTO> list = new ArrayList<TempCfgRedisDTO>();
		for (TempCfgRedis tem : page) {
			TempCfgRedisDTO dto = new TempCfgRedisDTO();
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
    public PageDTO<TempCfgRedis> seachPageModel(TempCfgRedisVo vo, PageRequest pageRequest)
	{
		Page<TempCfgRedis> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgRedis> pageDto = new PageDTO<TempCfgRedis>();		
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<TempCfgRedis> queryAll(TempCfgRedisVo vo)
    {
		TempCfgRedis entity = new TempCfgRedis();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<TempCfgRedis> queryAllModel(TempCfgRedis entity) {
		Iterable<TempCfgRedis> iterable = dao.findAll(getInputConditionModel(entity));
		Iterator<TempCfgRedis> iterator = iterable.iterator();
		List<TempCfgRedis> list = new ArrayList<TempCfgRedis>();
		while (iterator.hasNext()) {
			TempCfgRedis img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(TempCfgRedis entity){
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
    private String getCacheKey(TempCfgRedis entity) {
        return CACHE_PREFIX + "TempCfgRedis_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(TempCfgRedis entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QTempCfgRedis.tempCfgRedis.enableFlag.eq(EnableFlag.Y));
        predicates.add(QTempCfgRedis.tempCfgRedis.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<TempCfgRedis> page = dao.findAll(predicate, sort);
        List<TempCfgRedis> list = new ArrayList<TempCfgRedis>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), TempCfgRedisUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + TempCfgRedisUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(TempCfgRedis entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QTempCfgRedis.tempCfgRedis.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QTempCfgRedis.tempCfgRedis.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QTempCfgRedis.tempCfgRedis.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QTempCfgRedis.tempCfgRedis.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QTempCfgRedis.tempCfgRedis.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QTempCfgRedis.tempCfgRedis.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QTempCfgRedis.tempCfgRedis.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QTempCfgRedis.tempCfgRedis.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QTempCfgRedis.tempCfgRedis.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QTempCfgRedis.tempCfgRedis.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QTempCfgRedis.tempCfgRedis.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QTempCfgRedis.tempCfgRedis.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QTempCfgRedis.tempCfgRedis.remarks.eq(entity.getRemarks()));
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
	private List<BooleanExpression> getBooleanExpressionList4Model(TempCfgRedis entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
		
		if (!Strings.isNullOrEmpty(entity.getRedisType())) {
			list.add(QTempCfgRedis.tempCfgRedis.redisType.like("%" + entity.getRedisType() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getRedisIp())) {
			list.add(QTempCfgRedis.tempCfgRedis.redisIp.like("%" + entity.getRedisIp() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getRedisPort())) {
			list.add(QTempCfgRedis.tempCfgRedis.redisPort.like("%" + entity.getRedisPort() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getRedisPassword())) {
			list.add(QTempCfgRedis.tempCfgRedis.redisPassword.like("%" + entity.getRedisPassword() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getRedisIndex())) {
			list.add(QTempCfgRedis.tempCfgRedis.redisIndex.like("%" + entity.getRedisIndex() + "%"));
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
	private Predicate getInputConditionModel(TempCfgRedis entity) {
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
	private Predicate getInputCondition(TempCfgRedisVo vo) {
		TempCfgRedis entity = new TempCfgRedis();
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
	private Predicate getInputCondition(TempCfgRedisDTO dto) {
		TempCfgRedis entity = new TempCfgRedis();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
