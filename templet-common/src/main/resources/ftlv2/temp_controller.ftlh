package ${PACKAGE};

import java.util.*;

<#list PACKAGES as p>
import ${p.importPackage};
</#list>
/**
 * 类 编 号：${CLASS_SERIALNO}
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */

@RestController
@RequestMapping("/${MODEL_CLASSNAME?uncap_first}")
public class ${CLASSNAME}  extends BaseController  {
	@Autowired
	${SERVICE_CLASSNAME} service;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(${CONTROLLER_CLASSNAME}.class);
	
	/**
	 * 分页查询模型列表
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/selectListByPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<PageDTO<${DTO_CLASSNAME}>> seachList(@RequestBody String json) {
		LOG.debug("selectListByPage:{}",json);
		ResultData<PageDTO<${DTO_CLASSNAME}>> resultData = new ResultData<PageDTO<${DTO_CLASSNAME}>>();
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
			PageRequest pageRequest = genPageRequest(vo);
			PageDTO<${DTO_CLASSNAME}> data = service.seachPageDto(vo, pageRequest,userId);
			resultData.setSucceed(true);
			resultData.setData(data);
			return resultData;
		} catch (ApecRuntimeException e) {
			LOG.error("selectListByPage", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
	}
	
	/**
	 * 根据主键id查询模型
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/selectById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${MODEL_CLASSNAME}> selectById(@RequestBody String json) {
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		LOG.debug("selectById:{}",json);
		try {
			${MODEL_CLASSNAME} dto = getFormJSON(json, ${MODEL_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
			${MODEL_CLASSNAME} reObj = service.findOne(dto.getId(),userId);
			resultData.setSucceed(true);
			resultData.setData(reObj);
		} catch (ApecRuntimeException e) {
			LOG.error("selectById", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
		return resultData;
	}
	
	/**
	 * 添加一条模型对象
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${VO_CLASSNAME}> insert(@RequestBody String json) {
		ResultData<${VO_CLASSNAME}> resultData = new ResultData<${VO_CLASSNAME}>();
		LOG.debug("insert:{}",json);
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
            vo.setCreateBy(userId);
            vo.setCreateDate(new Date());
            ${VO_CLASSNAME} data = service.create(vo,userId);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (ApecRuntimeException e) {
			LOG.error("insert ", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
		return resultData;
	}
	
		
	/**
	 * 根据主键id更新模型
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/updateById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${MODEL_CLASSNAME}> updateById(@RequestBody String json) {
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		LOG.debug("updateById:{}",json);
		try {
			${MODEL_CLASSNAME} vo = getFormJSON(json, ${MODEL_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			${MODEL_CLASSNAME} data = service.updateObject(vo,userId);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (ApecRuntimeException e) {
			LOG.error("updateById", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
		return resultData;
	}
	
	/**
	 * 根据主键id逻辑删除模型
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${VO_CLASSNAME}> delete(@RequestBody String json) {
		ResultData<${VO_CLASSNAME}> resultData = new ResultData<${VO_CLASSNAME}>();
		LOG.debug("delete:{}",json);
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
            vo.setLastUpdateBy(userId);
            vo.setLastUpdateDate(new Date());
			service.delete(vo.getId(),userId);
			resultData.setSucceed(true);
		} catch (ApecRuntimeException e) {
			LOG.error("delete ", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
		return resultData;
	}
	
	/**
	 * 根据条件模型集合
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/selectList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<List<${MODEL_CLASSNAME}>> selectList(@RequestBody String json) {
		LOG.debug("selectList:{}",json);
		ResultData<List<${MODEL_CLASSNAME}>> resultData = new ResultData<List<${MODEL_CLASSNAME}>>();
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
			List<${MODEL_CLASSNAME}> data = service.queryAll(vo,userId);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (ApecRuntimeException e) {
			LOG.error("selectList ", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
		return resultData;
	}
	
	/**
	 * 根据主键id更新模型状态
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${MODEL_CLASSNAME}> updateStatus(@RequestBody String json) {
		LOG.debug("updateStatus:{}",json);
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
			${MODEL_CLASSNAME} data = service.updateStatus(vo.getId(),vo.getStatus(),userId);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (ApecRuntimeException e) {
			LOG.error("updateStatus ", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
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
	public ResultData<${MODEL_CLASSNAME}> updateOrderNumber(@RequestBody String json) {
		LOG.debug("updateOrderNumber:{}",json);
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		try {
			${MODEL_CLASSNAME} entity = getFormJSON(json, ${MODEL_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
			${MODEL_CLASSNAME} data = service.updateOrderNumber(entity.getId(),entity.getOrderNumber(),userId);
			resultData.setSucceed(true);
			resultData.setData(data);
		} catch (ApecRuntimeException e) {
			LOG.error("updateOrderNumber ", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
		return resultData;
	}
	
	/**
	 * 刷新数据缓存
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/flushCacheJob", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<${MODEL_CLASSNAME}> flushCacheJob(@RequestBody String json) {
		LOG.debug("flushCacheJob:{}",json);
		ResultData<${MODEL_CLASSNAME}> resultData = new ResultData<${MODEL_CLASSNAME}>();
		try {
			${MODEL_CLASSNAME} entity = getFormJSON(json, ${MODEL_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
			service.flushCacheJob(entity,userId);
			resultData.setSucceed(true);
			resultData.setData(entity);
		} catch (ApecRuntimeException e) {
			LOG.error("flushCacheJob ", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
		return resultData;
	}
}
