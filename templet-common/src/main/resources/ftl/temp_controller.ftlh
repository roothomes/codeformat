package ${PACKAGE};

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


<#list PACKAGES as p>
import ${p.importPackage};
</#list>
/**
 * 类 编 号：
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */

@RestController
@RequestMapping("/${MODEL_CLASSNAME?uncap_first}")
public class ${CLASSNAME}  extends ${BASECONTROLLER_CLASSNAME}  {
	@Autowired
	${SERVICE_CLASSNAME} service;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(${CONTROLLER_CLASSNAME}.class);
	
	/**
	 * 查询列表
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/selectListByPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<PageDTO<${DTO_CLASSNAME}>> seachList(@RequestBody String json) {
		LOG.debug("selectListByPage:{}",json);
		ResultData<PageDTO<${DTO_CLASSNAME}>> resultData = new ResultData<PageDTO<${DTO_CLASSNAME}>>();
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			PageRequest pageRequest = genPageRequest(vo);
			PageDTO<${DTO_CLASSNAME}> data = service.seachPageDto(vo, pageRequest);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("seachList ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 查询最新对象信息
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/selectById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${MODEL_CLASSNAME}> selectById(@RequestBody String json) {
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		LOG.debug("selectById:{}",json);
		try {
			${MODEL_CLASSNAME} dto = getFormJSON(json, ${MODEL_CLASSNAME}.class);
			${MODEL_CLASSNAME} reObj = service.findOne(dto.getId());
			resultData.setSucceed(true);
			resultData.setData(reObj);
		} catch (Exception e) {
			LOG.error("seachList ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	/**
	 * 添加信息
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${VO_CLASSNAME}> insert(@RequestBody String json) {
		ResultData<${VO_CLASSNAME}> resultData = new ResultData<${VO_CLASSNAME}>();
		LOG.debug("insert:{}",json);
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			String userId = getUserId(json);
            vo.setCreateBy(userId);
            vo.setCreateDate(new Date());
            ${VO_CLASSNAME} data = service.create(vo);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("add ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(e.getMessage());
		}
		return resultData;
	}
	
	@RequestMapping(value = "/updateById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${MODEL_CLASSNAME}> updateById(@RequestBody String json) {
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		LOG.debug("updateById:{}",json);
		try {
			${MODEL_CLASSNAME} vo = getFormJSON(json, ${MODEL_CLASSNAME}.class);
			String userId = getUserId(json);
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			${MODEL_CLASSNAME} data = service.updateObject(vo);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("update ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${VO_CLASSNAME}> delete(@RequestBody String json) {
		ResultData<${VO_CLASSNAME}> resultData = new ResultData<${VO_CLASSNAME}>();
		LOG.debug("delete:{}",json);
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
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
	
	
	@RequestMapping(value = "/selectList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<List<${MODEL_CLASSNAME}>> selectList(@RequestBody String json) {
		LOG.debug("selectList:{}",json);
		ResultData<List<${MODEL_CLASSNAME}>> resultData = new ResultData<List<${MODEL_CLASSNAME}>>();
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			List<${MODEL_CLASSNAME}> data = service.queryAll(vo);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("seachAll ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(SpringUtil.getMessage(Constants.SYS_ERROR));
		}
		return resultData;
	}
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${MODEL_CLASSNAME}> updateStatus(@RequestBody String json) {
		LOG.debug("updateStatus:{}",json);
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			${MODEL_CLASSNAME} data = service.updateStatus(vo.getId(),vo.getStatus());
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
	
}
