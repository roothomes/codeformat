package com.apec.codetempletcontants.service.impl;

/** 模型类 */

import com.apec.codetempletcontants.constants.CodeTempletContantsContant;
import com.apec.codetempletcontants.dao.CodeTempletContantsDAO;
import com.apec.codetempletcontants.dto.CodeTempletContantsDTO;
import com.apec.codetempletcontants.model.CodeTempletContants;
import com.apec.codetempletcontants.model.QCodeTempletContants;
import com.apec.codetempletcontants.service.CodeTempletContantsService;
import com.apec.codetempletcontants.util.CodeTempletContantsUtil;
import com.apec.codetempletcontants.util.KeyGenCodeTempletContants;
import com.apec.codetempletcontants.vo.CodeTempletContantsVo;
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
 * 类 名 称：TempCfgContantsServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class CodeTempletContantsServiceImpl implements CodeTempletContantsService,CodeTempletContantsContant {
    private static final Logger LOG =  LoggerFactory.getLogger( CodeTempletContantsServiceImpl.class);
    @Autowired
    private CodeTempletContantsDAO dao;
    @Autowired
    private KeyGenCodeTempletContants idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public CodeTempletContantsVo create(CodeTempletContantsVo vo) throws Exception
    {
        if (Strings.isNullOrEmpty(vo.getVariableVal())) {
            vo.setVariableVal(null);
        }
        if (Strings.isNullOrEmpty(vo.getVariableName())) {
            vo.setVariableName(null);
        }
        if (Strings.isNullOrEmpty(vo.getVariableType())) {
            vo.setVariableType(null);
        }
        if (Strings.isNullOrEmpty(vo.getVariableDesc())) {
            vo.setVariableDesc(null);
        }
        if (Strings.isNullOrEmpty(vo.getTempletId())) {
            vo.setTempletId(null);
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
        CodeTempletContants entity = new CodeTempletContants();
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
        CodeTempletContants entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public CodeTempletContants updateOrderNumber(String id, Integer orderNumber)
    {
        CodeTempletContants entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public CodeTempletContants updateStatus(String id, String status)
    {
        CodeTempletContants entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public CodeTempletContants updateObject(CodeTempletContants vo) {
        CodeTempletContants entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置
        if (!Strings.isNullOrEmpty(vo.getVariableVal())) {
			entity.setVariableVal(vo.getVariableVal());
        }
        if (!Strings.isNullOrEmpty(vo.getVariableName())) {
			entity.setVariableName(vo.getVariableName());
        }
        if (!Strings.isNullOrEmpty(vo.getVariableType())) {
			entity.setVariableType(vo.getVariableType());
        }
        if (!Strings.isNullOrEmpty(vo.getVariableDesc())) {
			entity.setVariableDesc(vo.getVariableDesc());
        }
        if (!Strings.isNullOrEmpty(vo.getTempletId())) {
			entity.setTempletId(vo.getTempletId());
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
    public CodeTempletContants findOne(String id)
    {
        CodeTempletContants entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<CodeTempletContantsDTO> seachPageDto(CodeTempletContantsVo vo, PageRequest pageRequest)
    {
		Page<CodeTempletContants> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<CodeTempletContantsDTO> pageDto = new PageDTO<CodeTempletContantsDTO>();
		List<CodeTempletContantsDTO> list = new ArrayList<CodeTempletContantsDTO>();
		for (CodeTempletContants tem : page) {
			CodeTempletContantsDTO dto = new CodeTempletContantsDTO();
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
    public PageDTO<CodeTempletContants> seachPageModel(CodeTempletContantsVo vo, PageRequest pageRequest)
	{
		Page<CodeTempletContants> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<CodeTempletContants> pageDto = new PageDTO<CodeTempletContants>();
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<CodeTempletContants> queryAll(CodeTempletContantsVo vo)
    {
		CodeTempletContants entity = new CodeTempletContants();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<CodeTempletContants> queryAllModel(CodeTempletContants entity) {
		Iterable<CodeTempletContants> iterable = dao.findAll(getInputConditionModel(entity));
		Iterator<CodeTempletContants> iterator = iterable.iterator();
		List<CodeTempletContants> list = new ArrayList<CodeTempletContants>();
		while (iterator.hasNext()) {
			CodeTempletContants img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(CodeTempletContants entity){
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
    private String getCacheKey(CodeTempletContants entity) {
        return CACHE_PREFIX + "TempCfgContants_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(CodeTempletContants entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QCodeTempletContants.codeTempletContants.enableFlag.eq(EnableFlag.Y));
        predicates.add(QCodeTempletContants.codeTempletContants.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<CodeTempletContants> page = dao.findAll(predicate, sort);
        List<CodeTempletContants> list = new ArrayList<CodeTempletContants>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), CodeTempletContantsUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + CodeTempletContantsUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(CodeTempletContants entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QCodeTempletContants.codeTempletContants.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QCodeTempletContants.codeTempletContants.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QCodeTempletContants.codeTempletContants.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QCodeTempletContants.codeTempletContants.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QCodeTempletContants.codeTempletContants.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QCodeTempletContants.codeTempletContants.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QCodeTempletContants.codeTempletContants.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QCodeTempletContants.codeTempletContants.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QCodeTempletContants.codeTempletContants.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QCodeTempletContants.codeTempletContants.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QCodeTempletContants.codeTempletContants.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QCodeTempletContants.codeTempletContants.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QCodeTempletContants.codeTempletContants.remarks.eq(entity.getRemarks()));
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
	private List<BooleanExpression> getBooleanExpressionList4Model(CodeTempletContants entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
		

		if (!Strings.isNullOrEmpty(entity.getVariableVal())) {
			list.add(QCodeTempletContants.codeTempletContants.variableVal.like("%" + entity.getVariableVal() + "%"));
		}


		if (!Strings.isNullOrEmpty(entity.getVariableName())) {
			list.add(QCodeTempletContants.codeTempletContants.variableName.like("%" + entity.getVariableName() + "%"));
		}


		if (!Strings.isNullOrEmpty(entity.getVariableType())) {
			list.add(QCodeTempletContants.codeTempletContants.variableType.like("%" + entity.getVariableType() + "%"));
		}


		if (!Strings.isNullOrEmpty(entity.getVariableDesc())) {
			list.add(QCodeTempletContants.codeTempletContants.variableDesc.like("%" + entity.getVariableDesc() + "%"));
		}


		if (!Strings.isNullOrEmpty(entity.getTempletId())) {
			list.add(QCodeTempletContants.codeTempletContants.templetId.like("%" + entity.getTempletId() + "%"));
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
	private Predicate getInputConditionModel(CodeTempletContants entity) {
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
	private Predicate getInputCondition(CodeTempletContantsVo vo) {
		CodeTempletContants entity = new CodeTempletContants();
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
	private Predicate getInputCondition(CodeTempletContantsDTO dto) {
		CodeTempletContants entity = new CodeTempletContants();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
