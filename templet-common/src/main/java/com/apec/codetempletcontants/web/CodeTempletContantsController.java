package com.apec.codetempletcontants.web;

import java.util.*;

import com.apec.codetempletcontants.dto.CodeTempletContantsDTO;
import com.apec.codetempletcontants.model.CodeTempletContants;
import com.apec.codetempletcontants.vo.CodeTempletContantsVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.framework.common.Constants;
import com.apec.framework.common.PageDTO;
import com.apec.framework.common.ResultData;
import com.apec.framework.common.util.SpringUtil;


import com.apec.codetempletcontants.service.CodeTempletContantsService;

/**
 * 类 编 号：BL_PU6030202_1000_controller
 * 类 名 称：TempCfgContantsController
 * 内容摘要：业务模型BaseController类
 * @author roothomes
 * @date 2017-10-30
 */

@RestController
//@RequestMapping("/tempCfgContants")
@RequestMapping("/codetempletcontants")
public class CodeTempletContantsController extends CodeTempleContantMyBaseController  {
	@Autowired
    CodeTempletContantsService service;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CodeTempletContantsController.class);
	
	/**
	 * 分页查询模型列表
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/selectListByPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<PageDTO<CodeTempletContantsDTO>> seachList(@RequestBody String json) {
		LOG.debug("selectListByPage:{}",json);
		ResultData<PageDTO<CodeTempletContantsDTO>> resultData = new ResultData<PageDTO<CodeTempletContantsDTO>>();
		try {
			CodeTempletContantsVo vo = getFormJSON(json, CodeTempletContantsVo.class);
			PageRequest pageRequest = genPageRequest(vo);
			PageDTO<CodeTempletContantsDTO> data = service.seachPageDto(vo, pageRequest);
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
	public ResultData<CodeTempletContants> selectById(@RequestBody String json) {
		ResultData<CodeTempletContants> resultData = new ResultData<CodeTempletContants>();
		LOG.debug("selectById:{}",json);
		try {
			CodeTempletContants dto = getFormJSON(json, CodeTempletContants.class);
			CodeTempletContants reObj = service.findOne(dto.getId());
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
	public ResultData<CodeTempletContantsVo> insert(@RequestBody String json) {
		ResultData<CodeTempletContantsVo> resultData = new ResultData<CodeTempletContantsVo>();
		LOG.debug("insert:{}",json);
		try {
			CodeTempletContantsVo vo = getFormJSON(json, CodeTempletContantsVo.class);
			String userId = getUserId(json);
            vo.setCreateBy(userId);
            vo.setCreateDate(new Date());
            CodeTempletContantsVo data = service.create(vo);
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
	public ResultData<CodeTempletContants> updateById(@RequestBody String json) {
		ResultData<CodeTempletContants> resultData = new ResultData<CodeTempletContants>();
		LOG.debug("updateById:{}",json);
		try {
			CodeTempletContants vo = getFormJSON(json, CodeTempletContants.class);
			String userId = getUserId(json);
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			CodeTempletContants data = service.updateObject(vo);
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
	public ResultData<CodeTempletContantsVo> delete(@RequestBody String json) {
		ResultData<CodeTempletContantsVo> resultData = new ResultData<CodeTempletContantsVo>();
		LOG.debug("delete:{}",json);
		try {
			CodeTempletContantsVo vo = getFormJSON(json, CodeTempletContantsVo.class);
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
	public ResultData<List<CodeTempletContants>> selectList(@RequestBody String json) {
		LOG.debug("selectList:{}",json);
		ResultData<List<CodeTempletContants>> resultData = new ResultData<List<CodeTempletContants>>();
		try {
			CodeTempletContantsVo vo = getFormJSON(json, CodeTempletContantsVo.class);
			List<CodeTempletContants> data = service.queryAll(vo);
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
	public ResultData<CodeTempletContants> updateStatus(@RequestBody String json) {
		LOG.debug("updateStatus:{}",json);
		ResultData<CodeTempletContants> resultData = new ResultData<CodeTempletContants>();
		try {
			CodeTempletContantsVo vo = getFormJSON(json, CodeTempletContantsVo.class);
			CodeTempletContants data = service.updateStatus(vo.getId(),vo.getStatus());
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
	public ResultData<CodeTempletContants> updateOrderNumber(@RequestBody String json) {
		LOG.debug("updateOrderNumber:{}",json);
		ResultData<CodeTempletContants> resultData = new ResultData<CodeTempletContants>();
		try {
			CodeTempletContants entity = getFormJSON(json, CodeTempletContants.class);
			CodeTempletContants data = service.updateOrderNumber(entity.getId(),entity.getOrderNumber());
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
	public ResultData<CodeTempletContants> flushCacheJob(@RequestBody String json) {
		LOG.debug("flushCacheJob:{}",json);
		ResultData<CodeTempletContants> resultData = new ResultData<CodeTempletContants>();
		try {
			CodeTempletContants entity = getFormJSON(json, CodeTempletContants.class);
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
