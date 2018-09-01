package com.apec.codetempletitem.service.impl;

/** 模型类 */
import com.apec.codetempletitem.model.CodetempletItem;
/** 模型DTO类 */
import com.apec.codetempletitem.dto.CodetempletItemDTO;
/** 模型Vo类 */
import com.apec.codetempletitem.vo.CodetempletItemVo;
/** 模型常量类 */
import com.apec.codetempletitem.constants.CodetempletItemContant;
/** 模型常用方法类 */
import com.apec.codetempletitem.util.CodetempletItemUtil;
/** 模型服务接口类 */
import com.apec.codetempletitem.service.CodetempletItemService;
/** 模型DAO类 */
import com.apec.codetempletitem.dao.CodetempletItemDAO;
/** 模型DAO类 */
import com.apec.codetempletitem.model.QCodetempletItem;
/** 缓存类 */
import com.apec.framework.cache.CacheService;
/** 分页模型类 */
import com.apec.framework.common.PageDTO;
/** 逻辑删除的枚举 */
import com.apec.framework.common.enumtype.EnableFlag;
/** Bean的常用方法 */
import com.apec.framework.common.util.BeanUtil;
/** 主键序列 */
import com.apec.codetempletitem.util.KeyGenCodetempletItem;

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
 * 类 名 称：CodetempletItemServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class CodetempletItemServiceImpl implements CodetempletItemService,CodetempletItemContant{
    private static final Logger LOG =  LoggerFactory.getLogger( CodetempletItemServiceImpl.class);
    @Autowired
    private CodetempletItemDAO dao;
    @Autowired
    private KeyGenCodetempletItem idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public CodetempletItemVo create(CodetempletItemVo vo) throws Exception
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
        CodetempletItem entity = new CodetempletItem();
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
        CodetempletItem entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public  CodetempletItem updateOrderNumber(String id, Integer orderNumber)
    {
        CodetempletItem entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public  CodetempletItem updateStatus(String id, String status)
    {
        CodetempletItem entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public CodetempletItem updateObject(CodetempletItem vo) {
        CodetempletItem entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置
        if (!Strings.isNullOrEmpty(vo.getCfgDBColumnCode())) {
            entity.setCfgDBColumnCode(vo.getCfgDBColumnCode());
        }
        if (!Strings.isNullOrEmpty(vo.getCfgJavaAttributeCanNull())) {
            entity.setCfgJavaAttributeCanNull(vo.getCfgJavaAttributeCanNull());
        }
        if (!Strings.isNullOrEmpty(vo.getCfgJavaAttributeCode())) {
            entity.setCfgJavaAttributeCode(vo.getCfgJavaAttributeCode());
        }
        if (!Strings.isNullOrEmpty(vo.getCfgJavaAttributeDefaultVal())) {
            entity.setCfgJavaAttributeDefaultVal(vo.getCfgJavaAttributeDefaultVal());
        }
        if (!Strings.isNullOrEmpty(vo.getCfgJavaAttributeDesc())) {
            entity.setCfgJavaAttributeDesc(vo.getCfgJavaAttributeDesc());
        }
        if (!Strings.isNullOrEmpty(vo.getCfgJavaAttributeType())) {
            entity.setCfgJavaAttributeType(vo.getCfgJavaAttributeType());
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
    public CodetempletItem findOne(String id)
    {
        CodetempletItem entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<CodetempletItemDTO> seachPageDto(CodetempletItemVo vo, PageRequest pageRequest)
    {
		Page<CodetempletItem> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<CodetempletItemDTO> pageDto = new PageDTO<CodetempletItemDTO>();
		List<CodetempletItemDTO> list = new ArrayList<CodetempletItemDTO>();
		for (CodetempletItem tem : page) {
			CodetempletItemDTO dto = new CodetempletItemDTO();
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
    public PageDTO<CodetempletItem> seachPageModel(CodetempletItemVo vo, PageRequest pageRequest)
	{
		Page<CodetempletItem> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<CodetempletItem> pageDto = new PageDTO<CodetempletItem>();		
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<CodetempletItem> queryAll(CodetempletItemVo vo)
    {
		CodetempletItem entity = new CodetempletItem();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<CodetempletItem> queryAllModel(CodetempletItem entity) {
        Sort sort3 = new Sort(Sort.Direction.DESC, "createDate");
		Iterable<CodetempletItem> iterable = dao.findAll(getInputConditionModel(entity),sort3);
		Iterator<CodetempletItem> iterator = iterable.iterator();
		List<CodetempletItem> list = new ArrayList<CodetempletItem>();
		while (iterator.hasNext()) {
			CodetempletItem img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(CodetempletItem entity){
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
    private String getCacheKey(CodetempletItem entity) {
        return CACHE_PREFIX + "CodetempletItem_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(CodetempletItem entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QCodetempletItem.codetempletItem.enableFlag.eq(EnableFlag.Y));
        predicates.add(QCodetempletItem.codetempletItem.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<CodetempletItem> page = dao.findAll(predicate, sort);
        List<CodetempletItem> list = new ArrayList<CodetempletItem>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), CodetempletItemUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + CodetempletItemUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(CodetempletItem entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QCodetempletItem.codetempletItem.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QCodetempletItem.codetempletItem.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QCodetempletItem.codetempletItem.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QCodetempletItem.codetempletItem.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QCodetempletItem.codetempletItem.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QCodetempletItem.codetempletItem.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QCodetempletItem.codetempletItem.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QCodetempletItem.codetempletItem.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QCodetempletItem.codetempletItem.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QCodetempletItem.codetempletItem.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QCodetempletItem.codetempletItem.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QCodetempletItem.codetempletItem.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QCodetempletItem.codetempletItem.remarks.eq(entity.getRemarks()));
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
	private List<BooleanExpression> getBooleanExpressionList4Model(CodetempletItem entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
        if (!Strings.isNullOrEmpty(entity.getTempletId())) {
            list.add(QCodetempletItem.codetempletItem.templetId.eq(entity.getTempletId()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeDesc())) {
            list.add(QCodetempletItem.codetempletItem.cfgJavaAttributeDesc.eq(entity.getCfgJavaAttributeDesc()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeType())) {
            list.add(QCodetempletItem.codetempletItem.cfgJavaAttributeType.eq(entity.getCfgJavaAttributeType()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeCode())) {
            list.add(QCodetempletItem.codetempletItem.cfgJavaAttributeCode.eq(entity.getCfgJavaAttributeCode()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeCanNull())) {
            list.add(QCodetempletItem.codetempletItem.cfgJavaAttributeCanNull.eq(entity.getCfgJavaAttributeCanNull()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeDefaultVal())) {
            list.add(QCodetempletItem.codetempletItem.cfgJavaAttributeDefaultVal.eq(entity.getCfgJavaAttributeDefaultVal()));
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
	private Predicate getInputConditionModel(CodetempletItem entity) {
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
	private Predicate getInputCondition(CodetempletItemVo vo) {
		CodetempletItem entity = new CodetempletItem();
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
	private Predicate getInputCondition(CodetempletItemDTO dto) {
		CodetempletItem entity = new CodetempletItem();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
