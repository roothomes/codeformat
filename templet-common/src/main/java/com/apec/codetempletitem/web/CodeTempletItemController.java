package com.apec.codetempletitem.web;

import com.apec.codetempletitem.dto.CodeTempletItemDTO;
import com.apec.codetempletitem.model.CodeTempletItem;
import com.apec.codetempletitem.service.CodeTempletItemService;
import com.apec.codetempletitem.vo.CodeTempletItemVo;
import com.apec.framework.common.Constants;
import com.apec.framework.common.PageDTO;
import com.apec.framework.common.ResultData;
import com.apec.framework.common.util.SpringUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 类 编 号：BL_PU6030202_1000_controller
 * 类 名 称：TempCfgContantsController
 * 内容摘要：业务模型BaseController类
 * @author roothomes
 * @date 2017-10-30
 */

@RestController
@RequestMapping("/codetempletitem")
public class CodeTempletItemController extends CodeTempleItemMyBaseController {
	@Autowired
	CodeTempletItemService service;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CodeTempletItemController.class);
	
	/**
	 * 分页查询模型列表
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/selectListByPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<PageDTO<CodeTempletItemDTO>> seachList(@RequestBody String json) {
		LOG.debug("selectListByPage:{}",json);
		ResultData<PageDTO<CodeTempletItemDTO>> resultData = new ResultData<PageDTO<CodeTempletItemDTO>>();
		try {
			CodeTempletItemVo vo = getFormJSON(json, CodeTempletItemVo.class);
			PageRequest pageRequest = genPageRequest(vo);
			PageDTO<CodeTempletItemDTO> data = service.seachPageDto(vo, pageRequest);
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
	public ResultData<CodeTempletItem> selectById(@RequestBody String json) {
		ResultData<CodeTempletItem> resultData = new ResultData<CodeTempletItem>();
		LOG.debug("selectById:{}",json);
		try {
			CodeTempletItem dto = getFormJSON(json, CodeTempletItem.class);
			CodeTempletItem reObj = service.findOne(dto.getId());
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
	public ResultData<CodeTempletItemVo> insert(@RequestBody String json) {
		ResultData<CodeTempletItemVo> resultData = new ResultData<CodeTempletItemVo>();
		LOG.debug("insert:{}",json);
		try {
			CodeTempletItemVo vo = getFormJSON(json, CodeTempletItemVo.class);
			String userId = getUserId(json);
            vo.setCreateBy(userId);
            vo.setCreateDate(new Date());
            CodeTempletItemVo data = service.create(vo);
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
	public ResultData<CodeTempletItem> updateById(@RequestBody String json) {
		ResultData<CodeTempletItem> resultData = new ResultData<CodeTempletItem>();
		LOG.debug("updateById:{}",json);
		try {
			CodeTempletItem vo = getFormJSON(json, CodeTempletItem.class);
			String userId = getUserId(json);
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			CodeTempletItem data = service.updateObject(vo);
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
	public ResultData<CodeTempletItemVo> delete(@RequestBody String json) {
		ResultData<CodeTempletItemVo> resultData = new ResultData<CodeTempletItemVo>();
		LOG.debug("delete:{}",json);
		try {
			CodeTempletItemVo vo = getFormJSON(json, CodeTempletItemVo.class);
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
	public ResultData<List<CodeTempletItem>> selectList(@RequestBody String json) {
		LOG.debug("selectList:{}",json);
		ResultData<List<CodeTempletItem>> resultData = new ResultData<List<CodeTempletItem>>();
		try {
			CodeTempletItemVo vo = getFormJSON(json, CodeTempletItemVo.class);
			List<CodeTempletItem> data = service.queryAll(vo);
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
	public ResultData<CodeTempletItem> updateStatus(@RequestBody String json) {
		LOG.debug("updateStatus:{}",json);
		ResultData<CodeTempletItem> resultData = new ResultData<CodeTempletItem>();
		try {
			CodeTempletItemVo vo = getFormJSON(json, CodeTempletItemVo.class);
			CodeTempletItem data = service.updateStatus(vo.getId(),vo.getStatus());
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
	public ResultData<CodeTempletItem> updateOrderNumber(@RequestBody String json) {
		LOG.debug("updateOrderNumber:{}",json);
		ResultData<CodeTempletItem> resultData = new ResultData<CodeTempletItem>();
		try {
			CodeTempletItem entity = getFormJSON(json, CodeTempletItem.class);
			CodeTempletItem data = service.updateOrderNumber(entity.getId(),entity.getOrderNumber());
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
	public ResultData<CodeTempletItem> flushCacheJob(@RequestBody String json) {
		LOG.debug("flushCacheJob:{}",json);
		ResultData<CodeTempletItem> resultData = new ResultData<CodeTempletItem>();
		try {
			CodeTempletItem entity = getFormJSON(json, CodeTempletItem.class);
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
