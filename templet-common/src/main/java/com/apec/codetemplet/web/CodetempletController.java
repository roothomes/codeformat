package com.apec.codetemplet.web;

import java.util.*;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.framework.common.Constants;
import com.apec.framework.common.PageDTO;
import com.apec.framework.common.PageJSON;
import com.apec.framework.common.ResultData;
import com.apec.framework.common.exception.BusinessException;
import com.apec.framework.common.util.JsonUtil;
import com.apec.framework.common.util.SpringUtil;
import com.google.common.base.Strings;
import com.apec.project.common.constants.JSConstants;


import com.apec.codetemplet.model.Codetemplet;
import com.apec.codetemplet.dto.CodetempletDTO;
import com.apec.codetemplet.vo.CodetempletVo;
import com.apec.codetemplet.constants.CodetempletContant;
import com.apec.codetemplet.util.CodetempletUtil;
import org.springframework.data.domain.PageRequest;
import com.apec.codetemplet.service.CodetempletService;
import com.apec.framework.common.PageJSON;
import com.apec.framework.common.util.JsonUtil;
import com.apec.framework.dto.BaseDTO;
/**
 * 类 编 号：BL_PU6030202_1000_controller
 * 类 名 称：CodetempletController
 * 内容摘要：业务模型BaseController类
 * @author roothomes
 * @date 2017-10-30
 */

@RestController
@RequestMapping("/codetemplet")
public class CodetempletController  extends MyBaseController  {
	@Autowired
	CodetempletService service;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CodetempletController.class);
	
	/**
	 * 分页查询模型列表
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/selectListByPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<PageDTO<CodetempletDTO>> seachList(@RequestBody String json) {
		LOG.debug("selectListByPage:{}",json);
		ResultData<PageDTO<CodetempletDTO>> resultData = new ResultData<PageDTO<CodetempletDTO>>();
		try {
			CodetempletVo vo = getFormJSON(json, CodetempletVo.class);
			PageRequest pageRequest = genPageRequest(vo);
			PageDTO<CodetempletDTO> data = service.seachPageDto(vo, pageRequest);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("selectListByPage", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 根据主键id查询模型
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/selectById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<Codetemplet> selectById(@RequestBody String json) {
		ResultData<Codetemplet> resultData = new ResultData<Codetemplet>();
		LOG.debug("selectById:{}",json);
		try {
			Codetemplet dto = getFormJSON(json, Codetemplet.class);
			Codetemplet reObj = service.findOne(dto.getId());
			resultData.setSucceed(true);
			resultData.setData(reObj);
		} catch (Exception e) {
			LOG.error("selectById", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 添加一条模型对象
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<CodetempletVo> insert(@RequestBody String json) {
		ResultData<CodetempletVo> resultData = new ResultData<CodetempletVo>();
		LOG.debug("insert:{}",json);
		try {
			CodetempletVo vo = getFormJSON(json, CodetempletVo.class);
			String userId = getUserId(json);
            vo.setCreateBy(userId);
            vo.setCreateDate(new Date());
            CodetempletVo data = service.create(vo);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("insert ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(e.getMessage());
		}
		return resultData;
	}
	
		
	/**
	 * 根据主键id更新模型
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/updateById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<Codetemplet> updateById(@RequestBody String json) {
		ResultData<Codetemplet> resultData = new ResultData<Codetemplet>();
		LOG.debug("updateById:{}",json);
		try {
			Codetemplet vo = getFormJSON(json, Codetemplet.class);
			String userId = getUserId(json);
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			Codetemplet data = service.updateObject(vo);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("updateById", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 根据主键id逻辑删除模型
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<CodetempletVo> delete(@RequestBody String json) {
		ResultData<CodetempletVo> resultData = new ResultData<CodetempletVo>();
		LOG.debug("delete:{}",json);
		try {
			CodetempletVo vo = getFormJSON(json, CodetempletVo.class);
			String userId = getUserId(json);
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			service.delete(vo.getId());
			resultData.setSucceed(true);
		} catch (Exception e) {
			LOG.error("delete ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 根据条件模型集合
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/selectList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<List<Codetemplet>> selectList(@RequestBody String json) {
		LOG.debug("selectList:{}",json);
		ResultData<List<Codetemplet>> resultData = new ResultData<List<Codetemplet>>();
		try {
			CodetempletVo vo = getFormJSON(json, CodetempletVo.class);
			List<Codetemplet> data = service.queryAll(vo);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("selectList ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 根据主键id更新模型状态
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<Codetemplet> updateStatus(@RequestBody String json) {
		LOG.debug("updateStatus:{}",json);
		ResultData<Codetemplet> resultData = new ResultData<Codetemplet>();
		try {
			CodetempletVo vo = getFormJSON(json, CodetempletVo.class);
			Codetemplet data = service.updateStatus(vo.getId(),vo.getStatus());
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("updateStatus ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 根据主键id更新模型排序值
	 * @param json JSON请求参数
	 * @return
	 * @author roothomes
	 * @date 2017-10-30
	 */
	@RequestMapping(value = "/updateOrderNumber", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<Codetemplet> updateOrderNumber(@RequestBody String json) {
		LOG.debug("updateOrderNumber:{}",json);
		ResultData<Codetemplet> resultData = new ResultData<Codetemplet>();
		try {
			Codetemplet entity = getFormJSON(json, Codetemplet.class);
			Codetemplet data = service.updateOrderNumber(entity.getId(),entity.getOrderNumber());
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("updateOrderNumber ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 刷新数据缓存
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/flushCacheJob", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<Codetemplet> flushCacheJob(@RequestBody String json) {
		LOG.debug("flushCacheJob:{}",json);
		ResultData<Codetemplet> resultData = new ResultData<Codetemplet>();
		try {
			Codetemplet entity = getFormJSON(json, Codetemplet.class);
			service.flushCacheJob(entity);
			resultData.setSucceed(true);
			resultData.setData(entity);
		} catch (Exception e) {
			LOG.error("flushCacheJob ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
}
