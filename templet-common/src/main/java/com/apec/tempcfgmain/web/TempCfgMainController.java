package com.apec.tempcfgmain.web;

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


import com.apec.tempcfgmain.model.TempCfgMain;
import com.apec.tempcfgmain.dto.TempCfgMainDTO;
import com.apec.tempcfgmain.vo.TempCfgMainVo;
import com.apec.tempcfgmain.constants.TempCfgMainContant;
import com.apec.tempcfgmain.util.TempCfgMainUtil;
import org.springframework.data.domain.PageRequest;
import com.apec.tempcfgmain.service.TempCfgMainService;
import com.apec.framework.common.PageJSON;
import com.apec.framework.common.util.JsonUtil;
import com.apec.framework.dto.BaseDTO;
/**
 * 类 编 号：BL_PU10000_10_controller
 * 类 名 称：TempCfgMainController
 * 内容摘要：业务模型BaseController类
 * @author roothomes
 * @date 2017-10-30
 */

@RestController
@RequestMapping("/tempCfgMain")
public class TempCfgMainController  extends MyBaseController  {
	@Autowired
	TempCfgMainService service;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(TempCfgMainController.class);
	
	/**
	 * 分页查询模型列表
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/selectListByPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<PageDTO<TempCfgMainDTO>> seachList(@RequestBody String json) {
		LOG.debug("selectListByPage:{}",json);
		ResultData<PageDTO<TempCfgMainDTO>> resultData = new ResultData<PageDTO<TempCfgMainDTO>>();
		try {
			TempCfgMainVo vo = getFormJSON(json, TempCfgMainVo.class);
			PageRequest pageRequest = genPageRequest(vo);
			PageDTO<TempCfgMainDTO> data = service.seachPageDto(vo, pageRequest);
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
	public ResultData<TempCfgMain> selectById(@RequestBody String json) {
		ResultData<TempCfgMain> resultData = new ResultData<TempCfgMain>();
		LOG.debug("selectById:{}",json);
		try {
			TempCfgMain dto = getFormJSON(json, TempCfgMain.class);
			TempCfgMain reObj = service.findOne(dto.getId());
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
	public ResultData<TempCfgMainVo> insert(@RequestBody String json) {
		ResultData<TempCfgMainVo> resultData = new ResultData<TempCfgMainVo>();
		LOG.debug("insert:{}",json);
		try {
			TempCfgMainVo vo = getFormJSON(json, TempCfgMainVo.class);
			String userId = getUserId(json);
            vo.setCreateBy(userId);
            vo.setCreateDate(new Date());
            TempCfgMainVo data = service.create(vo);
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
	public ResultData<TempCfgMain> updateById(@RequestBody String json) {
		ResultData<TempCfgMain> resultData = new ResultData<TempCfgMain>();
		LOG.debug("updateById:{}",json);
		try {
			TempCfgMain vo = getFormJSON(json, TempCfgMain.class);
			String userId = getUserId(json);
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			TempCfgMain data = service.updateObject(vo);
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
	public ResultData<TempCfgMainVo> delete(@RequestBody String json) {
		ResultData<TempCfgMainVo> resultData = new ResultData<TempCfgMainVo>();
		LOG.debug("delete:{}",json);
		try {
			TempCfgMainVo vo = getFormJSON(json, TempCfgMainVo.class);
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
	public ResultData<List<TempCfgMain>> selectList(@RequestBody String json) {
		LOG.debug("selectList:{}",json);
		ResultData<List<TempCfgMain>> resultData = new ResultData<List<TempCfgMain>>();
		try {
			TempCfgMainVo vo = getFormJSON(json, TempCfgMainVo.class);
			List<TempCfgMain> data = service.queryAll(vo);
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
	public ResultData<TempCfgMain> updateStatus(@RequestBody String json) {
		LOG.debug("updateStatus:{}",json);
		ResultData<TempCfgMain> resultData = new ResultData<TempCfgMain>();
		try {
			TempCfgMainVo vo = getFormJSON(json, TempCfgMainVo.class);
			TempCfgMain data = service.updateStatus(vo.getId(),vo.getStatus());
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
	public ResultData<TempCfgMain> updateOrderNumber(@RequestBody String json) {
		LOG.debug("updateOrderNumber:{}",json);
		ResultData<TempCfgMain> resultData = new ResultData<TempCfgMain>();
		try {
			TempCfgMain entity = getFormJSON(json, TempCfgMain.class);
			TempCfgMain data = service.updateOrderNumber(entity.getId(),entity.getOrderNumber());
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
	public ResultData<TempCfgMain> flushCacheJob(@RequestBody String json) {
		LOG.debug("flushCacheJob:{}",json);
		ResultData<TempCfgMain> resultData = new ResultData<TempCfgMain>();
		try {
			TempCfgMain entity = getFormJSON(json, TempCfgMain.class);
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
