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
@RequestMapping("/facade${MODEL_CLASSNAME?uncap_first}")
public class ${CLASSNAME}  extends BaseController  {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	${FACADE_SERVICE_CLASSNAME} service;

	/**
	 * hello
	 * @param json JSON请求参数
	 * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<PageDTO<${DTO_CLASSNAME}>> hello(@RequestBody String json) {
		LOG.debug("hello:{}",json);
		ResultData<PageDTO<${DTO_CLASSNAME}>> resultData = new ResultData<PageDTO<${DTO_CLASSNAME}>>();
		try {
			${VO_CLASSNAME} vo = getFormJSON(json, ${VO_CLASSNAME}.class);
			String userId = super.getUserNo(getPageJSON(json,${VO_CLASSNAME}.class));
			PageRequest pageRequest = genPageRequest(vo);
			service.facadeHello(userId);
			resultData.setSucceed(true);
			return resultData;
		} catch (ApecRuntimeException e) {
			LOG.error("hello", e);
			return super.getResultData(false, null, e.getErrorCode(), e.getArgs());
		}
	}

}
