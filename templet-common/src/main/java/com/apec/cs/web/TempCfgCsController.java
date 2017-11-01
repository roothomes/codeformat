package com.apec.cs.web;

import com.apec.cs.util.CsConfig;
import com.apec.cs.vo.TempGenerateParamVo;
import com.apec.cs.vo.TempGenerateRsVo;
import com.apec.framework.common.Constants;
import com.apec.framework.common.ResultData;
import com.apec.framework.common.util.BeanUtil;
import com.apec.framework.common.util.JsonUtil;
import com.google.common.base.Strings;
import com.roothomes.common.util.BuildUtil;
import com.roothomes.common.util.Cfg;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 类 编 号：
 * 类 名 称：TempCfgCsController
 * 内容摘要：业务模型TempCfgCsController类
 * @author roothomes
 * @date 2017-10-30
 */

@RestController
@RequestMapping("/tempCfgCs")
public class TempCfgCsController extends MyBaseController {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(TempCfgCsController.class);
	@Autowired
	CsConfig csConfig;

	/****************  常量设置 end  ***********************/

	public static final String UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	/**
	 * 添加一条模型对象
	 * @param json JSON请求参数
	 * @return
     * @author roothomes
     * @date 2017-10-30
	 */
	@RequestMapping(value = "/generateFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<TempGenerateRsVo> generateFile(@RequestBody String json) {
		ResultData<TempGenerateRsVo> resultData = new ResultData<TempGenerateRsVo>();
		LOG.debug("generateFile:{}",json);
		TempGenerateRsVo data = new TempGenerateRsVo();
		try {
			String rt = DateFormatUtils.format(new Date(),UTC_FORMAT);
			data.setRequestTime(rt);
			TempGenerateParamVo vo = getFormJSON(json, TempGenerateParamVo.class);
			BuildUtil.buildAll(initCfg(vo));
			resultData.setSucceed(true);
			rt = DateFormatUtils.format(new Date(),UTC_FORMAT);
			data.setResponseTime(rt);
			resultData.setData(data);
		} catch (Exception e) {
			LOG.error("generateFile ", e);
			String rt = DateFormatUtils.format(new Date(),UTC_FORMAT);
			data.setResponseTime(rt);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(e.getMessage());
		}


		return resultData;
	}

	public Cfg initCfg(TempGenerateParamVo model ) throws InvocationTargetException {
		Cfg param = new Cfg();
		// 获取实体类的所有属性，返回Field数组
		Field[] field = model.getClass().getDeclaredFields();
		try {
			// 遍历所有属性
			for (int j = 0; j < field.length; j++) {
				// 获取属性的名字
				String name = field[j].getName();
				// 将属性的首字符大写，方便构造get，set方法
				name = name.substring(0, 1).toUpperCase() + name.substring(1);
				// 获取属性的类型
				String type = field[j].getGenericType().toString();
				// 如果type是类类型，则前面包含"class "，后面跟类名
				if (type.equals("class java.lang.String")) {
					Method m = model.getClass().getMethod("get" + name);
					// 调用getter方法获取属性值
					String value = (String) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set"+name,String.class);
						Method mCsConfig = csConfig.getClass().getMethod("get" + name);
						String csValue = (String)mCsConfig.invoke(csConfig);
						m.invoke(model, csValue.trim());
					}
				}
				if (type.equals("class java.lang.Integer")) {
					Method m = model.getClass().getMethod("get" + name);
					Integer value = (Integer) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set"+name,Integer.class);
						Method mCsConfig = csConfig.getClass().getMethod("get" + name);
						Integer csValue = (Integer)mCsConfig.invoke(csConfig);
						m.invoke(model, 0);
					}
				}
				if (type.equals("class java.lang.Boolean")) {
					Method m = model.getClass().getMethod("get" + name);
					Boolean value = (Boolean) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set"+name,Boolean.class);
						m.invoke(model, false);
					}
				}
				if (type.equals("class java.util.Date")) {
					Method m = model.getClass().getMethod("get" + name);
					Date value = (Date) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set"+name,Date.class);
						m.invoke(model, new Date());
					}
				}
				// 如果有需要,可以仿照上面继续进行扩充,再增加对其它类型的判断
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		LOG.info("model data:{}",JsonUtil.toJSONString(model));
		BeanUtil.copyProperties(model,param);
		LOG.info("param data:{}",JsonUtil.toJSONString(param));
		return param;
	}

























}
