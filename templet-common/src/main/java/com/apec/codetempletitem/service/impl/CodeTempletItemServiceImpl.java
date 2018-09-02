package com.apec.codetempletitem.service.impl;

/** 模型类 */

import com.apec.codetempletitem.constants.CodeTempletItemContant;
import com.apec.codetempletitem.dao.CodeTempletItemDAO;
import com.apec.codetempletitem.dto.CodeTempletItemDTO;
import com.apec.codetempletitem.model.CodeTempletItem;
import com.apec.codetempletitem.model.QCodeTempletItem;
import com.apec.codetempletitem.service.CodeTempletItemService;
import com.apec.codetempletitem.util.CodeTempletItemUtil;
import com.apec.codetempletitem.util.KeyGenCodeTempletItem;
import com.apec.codetempletitem.vo.CodeTempletItemVo;
import com.apec.framework.cache.CacheService;
import com.apec.framework.common.PageDTO;
import com.apec.framework.common.enumtype.EnableFlag;
import com.apec.framework.common.util.BeanUtil;
import com.google.common.base.Strings;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 模型DTO类  模型Vo类  模型常量类  模型常用方法类  模型服务接口类  模型DAO类  模型DAO类  缓存类  分页模型类  逻辑删除的枚举  Bean的常用方法  主键序列
 */
/** 模型Vo类 */
/** 模型常量类 */
/** 模型常用方法类 */
/** 模型服务接口类 */
/** 模型DAO类 */
/** 模型DAO类 */
/** 缓存类 */
/** 分页模型类 */
/** 逻辑删除的枚举 */
/** Bean的常用方法 */
/** 主键序列 */

/**
 * 类 编 号：BL_PU6030202_1000_serviceimpl
 * 类 名 称：CodetempletItemServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class CodeTempletItemServiceImpl implements CodeTempletItemService,CodeTempletItemContant {
    private static final Logger LOG =  LoggerFactory.getLogger( CodeTempletItemServiceImpl.class);
    @Autowired
    private CodeTempletItemDAO dao;
    @Autowired
    private KeyGenCodeTempletItem idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public CodeTempletItemVo create(CodeTempletItemVo vo) throws Exception
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
        CodeTempletItem entity = new CodeTempletItem();
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
        CodeTempletItem entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public CodeTempletItem updateOrderNumber(String id, Integer orderNumber)
    {
        CodeTempletItem entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public CodeTempletItem updateStatus(String id, String status)
    {
        CodeTempletItem entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public CodeTempletItem updateObject(CodeTempletItem vo) {
        CodeTempletItem entity = dao.findOne(vo.getId());
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
    public CodeTempletItem findOne(String id)
    {
        CodeTempletItem entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<CodeTempletItemDTO> seachPageDto(CodeTempletItemVo vo, PageRequest pageRequest)
    {
		Page<CodeTempletItem> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<CodeTempletItemDTO> pageDto = new PageDTO<CodeTempletItemDTO>();
		List<CodeTempletItemDTO> list = new ArrayList<CodeTempletItemDTO>();
		for (CodeTempletItem tem : page) {
			CodeTempletItemDTO dto = new CodeTempletItemDTO();
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
    public PageDTO<CodeTempletItem> seachPageModel(CodeTempletItemVo vo, PageRequest pageRequest)
	{
		Page<CodeTempletItem> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<CodeTempletItem> pageDto = new PageDTO<CodeTempletItem>();
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<CodeTempletItem> queryAll(CodeTempletItemVo vo)
    {
		CodeTempletItem entity = new CodeTempletItem();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<CodeTempletItem> queryAllModel(CodeTempletItem entity) {
        Sort sort3 = new Sort(Sort.Direction.DESC, "createDate");
		Iterable<CodeTempletItem> iterable = dao.findAll(getInputConditionModel(entity),sort3);
		Iterator<CodeTempletItem> iterator = iterable.iterator();
		List<CodeTempletItem> list = new ArrayList<CodeTempletItem>();
		while (iterator.hasNext()) {
			CodeTempletItem img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(CodeTempletItem entity){
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
    private String getCacheKey(CodeTempletItem entity) {
        return CACHE_PREFIX + "CodetempletItem_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(CodeTempletItem entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QCodeTempletItem.codeTempletItem.enableFlag.eq(EnableFlag.Y));
        predicates.add(QCodeTempletItem.codeTempletItem.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<CodeTempletItem> page = dao.findAll(predicate, sort);
        List<CodeTempletItem> list = new ArrayList<CodeTempletItem>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), CodeTempletItemUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + CodeTempletItemUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(CodeTempletItem entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QCodeTempletItem.codeTempletItem.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QCodeTempletItem.codeTempletItem.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QCodeTempletItem.codeTempletItem.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QCodeTempletItem.codeTempletItem.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QCodeTempletItem.codeTempletItem.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QCodeTempletItem.codeTempletItem.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QCodeTempletItem.codeTempletItem.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QCodeTempletItem.codeTempletItem.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QCodeTempletItem.codeTempletItem.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QCodeTempletItem.codeTempletItem.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QCodeTempletItem.codeTempletItem.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QCodeTempletItem.codeTempletItem.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QCodeTempletItem.codeTempletItem.remarks.eq(entity.getRemarks()));
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
	private List<BooleanExpression> getBooleanExpressionList4Model(CodeTempletItem entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
        if (!Strings.isNullOrEmpty(entity.getTempletId())) {
            list.add(QCodeTempletItem.codeTempletItem.templetId.eq(entity.getTempletId()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeDesc())) {
            list.add(QCodeTempletItem.codeTempletItem.cfgJavaAttributeDesc.eq(entity.getCfgJavaAttributeDesc()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeType())) {
            list.add(QCodeTempletItem.codeTempletItem.cfgJavaAttributeType.eq(entity.getCfgJavaAttributeType()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeCode())) {
            list.add(QCodeTempletItem.codeTempletItem.cfgJavaAttributeCode.eq(entity.getCfgJavaAttributeCode()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeCanNull())) {
            list.add(QCodeTempletItem.codeTempletItem.cfgJavaAttributeCanNull.eq(entity.getCfgJavaAttributeCanNull()));
        }
        if (!Strings.isNullOrEmpty(entity.getCfgJavaAttributeDefaultVal())) {
            list.add(QCodeTempletItem.codeTempletItem.cfgJavaAttributeDefaultVal.eq(entity.getCfgJavaAttributeDefaultVal()));
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
	private Predicate getInputConditionModel(CodeTempletItem entity) {
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
	private Predicate getInputCondition(CodeTempletItemVo vo) {
		CodeTempletItem entity = new CodeTempletItem();
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
	private Predicate getInputCondition(CodeTempletItemDTO dto) {
		CodeTempletItem entity = new CodeTempletItem();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
