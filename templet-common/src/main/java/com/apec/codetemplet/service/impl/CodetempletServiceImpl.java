package com.apec.codetemplet.service.impl;

/** 模型类 */
import com.apec.codetemplet.model.Codetemplet;
/** 模型DTO类 */
import com.apec.codetemplet.dto.CodetempletDTO;
/** 模型Vo类 */
import com.apec.codetemplet.vo.CodetempletVo;
/** 模型常量类 */
import com.apec.codetemplet.constants.CodetempletContant;
/** 模型常用方法类 */
import com.apec.codetemplet.util.CodetempletUtil;
/** 模型服务接口类 */
import com.apec.codetemplet.service.CodetempletService;
/** 模型DAO类 */
import com.apec.codetemplet.dao.CodetempletDAO;
/** 模型DAO类 */
import com.apec.codetemplet.model.QCodetemplet;
/** 缓存类 */
import com.apec.framework.cache.CacheService;
/** 分页模型类 */
import com.apec.framework.common.PageDTO;
/** 逻辑删除的枚举 */
import com.apec.framework.common.enumtype.EnableFlag;
/** Bean的常用方法 */
import com.apec.framework.common.util.BeanUtil;
/** 主键序列 */
import com.apec.codetemplet.util.KeyGenCodetemplet;

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
 * 类 编 号：BL_PU6030202_1000_serviceimpl
 * 类 名 称：CodetempletServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class CodetempletServiceImpl implements CodetempletService,CodetempletContant{
    private static final Logger LOG =  LoggerFactory.getLogger( CodetempletServiceImpl.class);
    @Autowired
    private CodetempletDAO dao;
    @Autowired
    private KeyGenCodetemplet idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public CodetempletVo create(CodetempletVo vo) throws Exception
    {

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
        Codetemplet entity = new Codetemplet();
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
        Codetemplet entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public  Codetemplet updateOrderNumber(String id, Integer orderNumber)
    {
        Codetemplet entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public  Codetemplet updateStatus(String id, String status)
    {
        Codetemplet entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public Codetemplet updateObject(Codetemplet vo) {
        Codetemplet entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置

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
        
        if (null != vo.getCreateBy()) {
			entity.setCreateBy(vo.getCreateBy());
        }
        
        if (null != vo.getLastUpdateBy()) {
			entity.setLastUpdateBy(vo.getLastUpdateBy());
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
        if (null != vo.getRemarks()) {
			entity.setRemarks(vo.getRemarks());
        }
        
        dao.saveAndFlush(entity);
        return entity;
    }
	

	@Override
    public Codetemplet findOne(String id)
    {
        Codetemplet entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<CodetempletDTO> seachPageDto(CodetempletVo vo, PageRequest pageRequest)
    {
		Page<Codetemplet> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<CodetempletDTO> pageDto = new PageDTO<CodetempletDTO>();
		List<CodetempletDTO> list = new ArrayList<CodetempletDTO>();
		for (Codetemplet tem : page) {
			CodetempletDTO dto = new CodetempletDTO();
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
    public PageDTO<Codetemplet> seachPageModel(CodetempletVo vo, PageRequest pageRequest)
	{
		Page<Codetemplet> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<Codetemplet> pageDto = new PageDTO<Codetemplet>();		
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<Codetemplet> queryAll(CodetempletVo vo)
    {
		Codetemplet entity = new Codetemplet();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<Codetemplet> queryAllModel(Codetemplet entity) {
		Iterable<Codetemplet> iterable = dao.findAll(getInputConditionModel(entity));
		Iterator<Codetemplet> iterator = iterable.iterator();
		List<Codetemplet> list = new ArrayList<Codetemplet>();
		while (iterator.hasNext()) {
			Codetemplet img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(Codetemplet entity){
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
    private String getCacheKey(Codetemplet entity) {
        return CACHE_PREFIX + "Codetemplet_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(Codetemplet entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QCodetemplet.codetemplet.enableFlag.eq(EnableFlag.Y));
        predicates.add(QCodetemplet.codetemplet.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<Codetemplet> page = dao.findAll(predicate, sort);
        List<Codetemplet> list = new ArrayList<Codetemplet>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), CodetempletUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + CodetempletUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(Codetemplet entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QCodetemplet.codetemplet.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QCodetemplet.codetemplet.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QCodetemplet.codetemplet.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QCodetemplet.codetemplet.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QCodetemplet.codetemplet.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QCodetemplet.codetemplet.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QCodetemplet.codetemplet.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QCodetemplet.codetemplet.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QCodetemplet.codetemplet.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QCodetemplet.codetemplet.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QCodetemplet.codetemplet.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QCodetemplet.codetemplet.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QCodetemplet.codetemplet.remarks.eq(entity.getRemarks()));
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
	private List<BooleanExpression> getBooleanExpressionList4Model(Codetemplet entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
		

		return list;
	}
	
    /**
     * 获取对象模型的JPA查询断言
     * @param entity 模型对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
	private Predicate getInputConditionModel(Codetemplet entity) {
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
	private Predicate getInputCondition(CodetempletVo vo) {
		Codetemplet entity = new Codetemplet();
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
	private Predicate getInputCondition(CodetempletDTO dto) {
		Codetemplet entity = new Codetemplet();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
