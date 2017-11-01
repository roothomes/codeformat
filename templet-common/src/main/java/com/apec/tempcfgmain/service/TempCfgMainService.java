package com.apec.tempcfgmain.service;


import com.apec.tempcfgmain.model.TempCfgMain;

import com.apec.tempcfgmain.dto.TempCfgMainDTO;

import com.apec.tempcfgmain.vo.TempCfgMainVo;

import com.apec.framework.common.PageDTO;

import java.util.*;
import org.springframework.data.domain.PageRequest;

/**
 * 类 编 号：BL_PU10000_10_service
 * 类 名 称：TempCfgMainService
 * 内容摘要：业务模型Service接口类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */
public interface TempCfgMainService {
    /**
     * 创建一个对象
     * @param vo 对象
     * @return
	 * @throws Exception
     * @author roothomes
     * @date 2017-10-30
     */
    TempCfgMainVo create(TempCfgMainVo vo) throws Exception;
	
    /**
     * 逻辑删除一个对象
     * @param id 主键id
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    void delete(String id);
	
    /**
     * 更新排序
     * @param id 主键id
     * @param orderNumber
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    TempCfgMain updateOrderNumber(String id, Integer orderNumber);
	
    /**
     * 更新状态
     * @param id 主键id
     * @param status 状态
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    TempCfgMain updateStatus(String id, String status);
	
    /**
     * 更新对象模型
     * @param vo 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    TempCfgMain updateObject(TempCfgMain vo);

    /**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    PageDTO<TempCfgMainDTO> seachPageDto(TempCfgMainVo vo, PageRequest pageRequest);
	
	/**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    PageDTO<TempCfgMain> seachPageModel(TempCfgMainVo vo, PageRequest pageRequest);
	
    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    TempCfgMain findOne(String id);

    /**
     * 查询数据列表
     * @param vo
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    List<TempCfgMain> queryAll(TempCfgMainVo vo);
	
	/**
     * 后台任务刷新对象模型所有数据
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    void flushCacheJob(TempCfgMain entity);
}
