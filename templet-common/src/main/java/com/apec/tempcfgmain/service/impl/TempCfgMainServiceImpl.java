package com.apec.tempcfgmain.service.impl;

/** 模型类 */
import com.apec.tempcfgmain.model.TempCfgMain;
/** 模型DTO类 */
import com.apec.tempcfgmain.dto.TempCfgMainDTO;
/** 模型Vo类 */
import com.apec.tempcfgmain.vo.TempCfgMainVo;
/** 模型常量类 */
import com.apec.tempcfgmain.constants.TempCfgMainContant;
/** 模型常用方法类 */
import com.apec.tempcfgmain.util.TempCfgMainUtil;
/** 模型服务接口类 */
import com.apec.tempcfgmain.service.TempCfgMainService;
/** 模型DAO类 */
import com.apec.tempcfgmain.dao.TempCfgMainDAO;
/** 模型DAO类 */
import com.apec.tempcfgmain.model.QTempCfgMain;
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
 * 类 名 称：TempCfgMainServiceImpl
 * 内容摘要：业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */

@Service
public class TempCfgMainServiceImpl implements TempCfgMainService,TempCfgMainContant{
    private static final Logger LOG =  LoggerFactory.getLogger( TempCfgMainServiceImpl.class);
    @Autowired
    private TempCfgMainDAO dao;
    @Autowired
    private SnowFlakeKeyGen idGen;
    @Autowired
    private CacheService cacheService;

	
    @Override
    @Transactional
    public TempCfgMainVo create(TempCfgMainVo vo) throws Exception
    {
        if (Strings.isNullOrEmpty(vo.getGroupId())) {
            vo.setGroupId(DEFAULT_VAL_GROUPID);
        }
        if (Strings.isNullOrEmpty(vo.getArtifactId())) {
            vo.setArtifactId(DEFAULT_VAL_ARTIFACTID);
        }
        if (Strings.isNullOrEmpty(vo.getModelClassName())) {
            vo.setModelClassName(DEFAULT_VAL_MODEL_CLASSNAME);
        }
        if (Strings.isNullOrEmpty(vo.getModelClassDesc())) {
            vo.setModelClassDesc(DEFAULT_VAL_MODEL_CLASSNAME_DESC);
        }
        if (Strings.isNullOrEmpty(vo.getModelClassSerialNo())) {
            vo.setModelClassSerialNo(DEFAULT_VAL_MODEL_CLASS_SERIALNO);
        }
        if (Strings.isNullOrEmpty(vo.getCreateAuthor())) {
            vo.setCreateAuthor(DEFAULT_VAL_CREAT_AUTHOR);
        }
        if (Strings.isNullOrEmpty(vo.getCreateDateTime())) {
            vo.setCreateDateTime(DEFAULT_VAL_CREAT_DATE);
        }
        if (Strings.isNullOrEmpty(vo.getDatabaseName())) {
            vo.setDatabaseName(DEFAULT_VAL_DATABASE_NAME);
        }
        if (Strings.isNullOrEmpty(vo.getTableName())) {
            vo.setTableName(DEFAULT_VAL_TABLE_NAME);
        }
        if (Strings.isNullOrEmpty(vo.getOpenCache())) {
            vo.setOpenCache(DEFAULT_VAL_OPEN_CACHE_NO);
        }
        if (Strings.isNullOrEmpty(vo.getOpenMQ())) {
            vo.setOpenMQ(DEFAULT_VAL_OPEN_MQ_NO);
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
        TempCfgMain entity = new TempCfgMain();
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
        TempCfgMain entity = dao.findOne(id);
        entity.setEnableFlag(EnableFlag.N);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
    }

    @Override
    public  TempCfgMain updateOrderNumber(String id, Integer orderNumber)
    {
        TempCfgMain entity = dao.findOne(id);
        entity.setOrderNumber(orderNumber);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public  TempCfgMain updateStatus(String id, String status)
    {
        TempCfgMain entity = dao.findOne(id);
        entity.setStatus(status);
        dao.saveAndFlush(entity);
        flushCacheJob(entity);
        return entity;
    }

    @Override
    public TempCfgMain updateObject(TempCfgMain vo) {
        TempCfgMain entity = dao.findOne(vo.getId());
        if(null == entity){
			LOG.error("查询数据为空,id={}",vo.getId());
			return null;
        }
		//模块属性设置
        if (!Strings.isNullOrEmpty(vo.getGroupId())) {
			entity.setGroupId(vo.getGroupId());
        }
        if (!Strings.isNullOrEmpty(vo.getArtifactId())) {
			entity.setArtifactId(vo.getArtifactId());
        }
        if (!Strings.isNullOrEmpty(vo.getModelClassName())) {
			entity.setModelClassName(vo.getModelClassName());
        }
        if (!Strings.isNullOrEmpty(vo.getModelClassDesc())) {
			entity.setModelClassDesc(vo.getModelClassDesc());
        }
        if (!Strings.isNullOrEmpty(vo.getModelClassSerialNo())) {
			entity.setModelClassSerialNo(vo.getModelClassSerialNo());
        }
        if (!Strings.isNullOrEmpty(vo.getCreateAuthor())) {
			entity.setCreateAuthor(vo.getCreateAuthor());
        }
        if (!Strings.isNullOrEmpty(vo.getCreateDateTime())) {
			entity.setCreateDateTime(vo.getCreateDateTime());
        }
        if (!Strings.isNullOrEmpty(vo.getDatabaseName())) {
			entity.setDatabaseName(vo.getDatabaseName());
        }
        if (!Strings.isNullOrEmpty(vo.getTableName())) {
			entity.setTableName(vo.getTableName());
        }
        if (!Strings.isNullOrEmpty(vo.getOpenCache())) {
			entity.setOpenCache(vo.getOpenCache());
        }
        if (!Strings.isNullOrEmpty(vo.getOpenMQ())) {
			entity.setOpenMQ(vo.getOpenMQ());
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
    public TempCfgMain findOne(String id)
    {
        TempCfgMain entity = dao.findOne(id);
        return entity;
    }
	

    @Override
    public PageDTO<TempCfgMainDTO> seachPageDto(TempCfgMainVo vo, PageRequest pageRequest)
    {
		Page<TempCfgMain> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgMainDTO> pageDto = new PageDTO<TempCfgMainDTO>();
		List<TempCfgMainDTO> list = new ArrayList<TempCfgMainDTO>();
		for (TempCfgMain tem : page) {
			TempCfgMainDTO dto = new TempCfgMainDTO();
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
    public PageDTO<TempCfgMain> seachPageModel(TempCfgMainVo vo, PageRequest pageRequest)
	{
		Page<TempCfgMain> page = dao.findAll(getInputCondition(vo), pageRequest);
		PageDTO<TempCfgMain> pageDto = new PageDTO<TempCfgMain>();		
		pageDto.setNumber(page.getNumber());
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setRows(page.getContent());
		return pageDto;
	}

	@Override
    public List<TempCfgMain> queryAll(TempCfgMainVo vo)
    {
		TempCfgMain entity = new TempCfgMain();
		BeanUtil.copyProperties(vo, entity);
		return queryAllModel(entity);
    }
	
	public List<TempCfgMain> queryAllModel(TempCfgMain entity) {
		Iterable<TempCfgMain> iterable = dao.findAll(getInputConditionModel(entity));
		Iterator<TempCfgMain> iterator = iterable.iterator();
		List<TempCfgMain> list = new ArrayList<TempCfgMain>();
		while (iterator.hasNext()) {
			TempCfgMain img = iterator.next();
			list.add(img);
		}
		return list;
	}
	
   @Override
    public void flushCacheJob(TempCfgMain entity){
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
    private String getCacheKey(TempCfgMain entity) {
        return CACHE_PREFIX + "TempCfgMain_List";
    }

    /**
     * 刷新类型的数据到数据库 （修改状态就需要刷新）
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    private void flushCache(TempCfgMain entity) {
        List<BooleanExpression> predicates = new ArrayList<>();
        predicates.add(QTempCfgMain.tempCfgMain.enableFlag.eq(EnableFlag.Y));
        predicates.add(QTempCfgMain.tempCfgMain.status.eq(STATUS_VALID));

        Predicate predicate = BooleanExpression.allOf(predicates.toArray(new BooleanExpression[predicates.size()]));
        Sort sort = new Sort(Sort.Direction.ASC, "orderNumber");
        Iterable<TempCfgMain> page = dao.findAll(predicate, sort);
        List<TempCfgMain> list = new ArrayList<TempCfgMain>();
            page.forEach(one -> {
                list.add(one);
            });
        cacheService.add(getCacheKey(entity), TempCfgMainUtil.toJson(list));
        LOG.debug("刷新数据到缓存：" + getCacheKey(entity) + " \n" + TempCfgMainUtil.toJson(list));
    }
	
    /**
     * 获取基础模型的JPA查询列表表达式
     * @param entity 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    private List<BooleanExpression> getBooleanExpressionList4Base(TempCfgMain entity) {
        List<BooleanExpression> list = new ArrayList<BooleanExpression>();
        if (null != entity.getId()) {
            list.add(QTempCfgMain.tempCfgMain.id.eq(entity.getId()));
        }
        if (null == entity.getEnableFlag()) {
            list.add(QTempCfgMain.tempCfgMain.enableFlag.eq(EnableFlag.Y));
        } else {
            list.add(QTempCfgMain.tempCfgMain.enableFlag.eq(entity.getEnableFlag()));
        }

        if (null != entity.getCityId()) {
            list.add(QTempCfgMain.tempCfgMain.cityId.eq(entity.getCityId()));
        }
        if (!Strings.isNullOrEmpty(entity.getStatus())) {
            list.add(QTempCfgMain.tempCfgMain.status.eq(entity.getStatus()));
        }

        if (null != entity.getCreateDate()) {
            list.add(QTempCfgMain.tempCfgMain.createDate.eq(entity.getCreateDate()));
        }
        if (null != entity.getLastUpdateDate()) {
            list.add(QTempCfgMain.tempCfgMain.lastUpdateDate.eq(entity.getLastUpdateDate()));
        }
        if (!Strings.isNullOrEmpty(entity.getCreateBy())) {
            list.add(QTempCfgMain.tempCfgMain.createBy.eq(entity.getCreateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getLastUpdateBy())) {
            list.add(QTempCfgMain.tempCfgMain.lastUpdateBy.eq(entity.getLastUpdateBy()));
        }
        if (!Strings.isNullOrEmpty(entity.getPlantformId())) {
            list.add(QTempCfgMain.tempCfgMain.plantformId.eq(entity.getPlantformId()));
        }
        if (!Strings.isNullOrEmpty(entity.getOecdNo())) {
            list.add(QTempCfgMain.tempCfgMain.oecdNo.eq(entity.getOecdNo()));
        }
        if (null != entity.getOrderNumber()) {
            list.add(QTempCfgMain.tempCfgMain.orderNumber.eq(entity.getOrderNumber()));
        }
        if (!Strings.isNullOrEmpty(entity.getRemarks())) {
            list.add(QTempCfgMain.tempCfgMain.remarks.eq(entity.getRemarks()));
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
	private List<BooleanExpression> getBooleanExpressionList4Model(TempCfgMain entity) {
		List<BooleanExpression> list = getBooleanExpressionList4Base(entity);
		
		if (!Strings.isNullOrEmpty(entity.getGroupId())) {
			list.add(QTempCfgMain.tempCfgMain.groupId.like("%" + entity.getGroupId() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getArtifactId())) {
			list.add(QTempCfgMain.tempCfgMain.artifactId.like("%" + entity.getArtifactId() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getModelClassName())) {
			list.add(QTempCfgMain.tempCfgMain.modelClassName.like("%" + entity.getModelClassName() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getModelClassDesc())) {
			list.add(QTempCfgMain.tempCfgMain.modelClassDesc.like("%" + entity.getModelClassDesc() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getModelClassSerialNo())) {
			list.add(QTempCfgMain.tempCfgMain.modelClassSerialNo.like("%" + entity.getModelClassSerialNo() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getCreateAuthor())) {
			list.add(QTempCfgMain.tempCfgMain.createAuthor.like("%" + entity.getCreateAuthor() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getCreateDateTime())) {
			list.add(QTempCfgMain.tempCfgMain.createDateTime.like("%" + entity.getCreateDateTime() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getDatabaseName())) {
			list.add(QTempCfgMain.tempCfgMain.databaseName.like("%" + entity.getDatabaseName() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getTableName())) {
			list.add(QTempCfgMain.tempCfgMain.tableName.like("%" + entity.getTableName() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getOpenCache())) {
			list.add(QTempCfgMain.tempCfgMain.openCache.like("%" + entity.getOpenCache() + "%"));
		}
		if (!Strings.isNullOrEmpty(entity.getOpenMQ())) {
			list.add(QTempCfgMain.tempCfgMain.openMQ.like("%" + entity.getOpenMQ() + "%"));
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
	private Predicate getInputConditionModel(TempCfgMain entity) {
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
	private Predicate getInputCondition(TempCfgMainVo vo) {
		TempCfgMain entity = new TempCfgMain();
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
	private Predicate getInputCondition(TempCfgMainDTO dto) {
		TempCfgMain entity = new TempCfgMain();
		BeanUtil.copyProperties(dto, entity);
		Predicate predicate = getInputConditionModel(entity);
		return predicate;
	}
}
