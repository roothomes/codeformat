package com.apec.codetempletitem.service;


import com.apec.codetempletitem.dto.CodeTempletItemDTO;
import com.apec.codetempletitem.model.CodeTempletItem;

import com.apec.codetempletitem.vo.CodeTempletItemVo;

import com.apec.framework.common.PageDTO;

import java.util.*;
import org.springframework.data.domain.PageRequest;

/**
 * 类 编 号：BL_PU6030202_1000_service
 * 类 名 称：CodeTempletItemService
 * 内容摘要：业务模型Service接口类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义
 * @author roothomes
 * @date 2017-10-30
 */
public interface CodeTempletItemService {
    /**
     * 创建一个对象
     * @param vo 对象
     * @return
	 * @throws Exception
     * @author roothomes
     * @date 2017-10-30
     */
    CodeTempletItemVo create(CodeTempletItemVo vo) throws Exception;
	
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
    CodeTempletItem updateOrderNumber(String id, Integer orderNumber);
	
    /**
     * 更新状态
     * @param id 主键id
     * @param status 状态
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    CodeTempletItem updateStatus(String id, String status);
	
    /**
     * 更新对象模型
     * @param vo 对象
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    CodeTempletItem updateObject(CodeTempletItem vo);

    /**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    PageDTO<CodeTempletItemDTO> seachPageDto(CodeTempletItemVo vo, PageRequest pageRequest);
	
	/**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    PageDTO<CodeTempletItem> seachPageModel(CodeTempletItemVo vo, PageRequest pageRequest);
	
    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    CodeTempletItem findOne(String id);

    /**
     * 查询数据列表
     * @param vo
     * @return
     * @author roothomes
     * @date 2017-10-30
     */
    List<CodeTempletItem> queryAll(CodeTempletItemVo vo);
	
	/**
     * 后台任务刷新对象模型所有数据
     * @param entity
     * @author roothomes
     * @date 2017-10-30
     */
    void flushCacheJob(CodeTempletItem entity);
}
