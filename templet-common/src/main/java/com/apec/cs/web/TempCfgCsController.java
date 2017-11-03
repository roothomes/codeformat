package com.apec.cs.web;

import com.apec.cs.constants.CsConstants;
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
import com.roothomes.common.util.IContant;
import com.roothomes.common.util.ZipCompress;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
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
	public static final String DIR_FORMAT = "yyyyMMddHHmmssSSS";

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
			LOG.info("TempGenerateParamVo:{}",JsonUtil.toJSONString(vo));

			Cfg param = initCfg(vo);
			checkContantCfg(vo);
			checkAttributeCfg(vo);

			//设置dir的名称
			String outputPath = param.getCfgOutputBaseDir();
			String dirTime = DateFormatUtils.format(new Date(),DIR_FORMAT);
			if(param.getCfgOutputBaseDir().endsWith(File.separator)){
				outputPath = param.getCfgOutputBaseDir() + param.getCfgArtifactId() + dirTime;
			}else{
				outputPath = param.getCfgOutputBaseDir() + File.separator + param.getCfgArtifactId() + dirTime;
			}

			param.setCfgOutputBaseDir(outputPath);
			BuildUtil.buildAll(param);
			resultData.setSucceed(true);

//			String zipPath = null;
//			if(csConfig.getZipDir().endsWith(File.separator)){
//				zipPath = csConfig.getZipDir() + param.getCfgArtifactId() + dirTime + ".zip";
//			}else{
//				zipPath = csConfig.getZipDir() + File.separator + param.getCfgArtifactId() + dirTime + ".zip";
//			}
//			ZipCompress zipCom = new ZipCompress(zipPath,outputPath);
//			zipCom.zip();

			rt = DateFormatUtils.format(new Date(),UTC_FORMAT);
			data.setFilesIp("192.168.7.203");
			data.setFilesPath(param.getCfgOutputBaseDir());
			data.setResponseTime(rt);
//			String httpZipPath = null;
//			if(csConfig.getHttpZipBasePath().endsWith(File.separator)){
//				httpZipPath = csConfig.getHttpZipBasePath() + param.getCfgArtifactId() + dirTime + ".zip";
//			}else{
//				httpZipPath = csConfig.getHttpZipBasePath() + File.separator + param.getCfgArtifactId() + dirTime + ".zip";
//			}
//			data.setHttpZip(httpZipPath);
			resultData.setData(data);
			resultData.setErrorCode(CsConstants.BUSINESS_CODE_OK);
			resultData.setErrorMsg(CsConstants.BUSINESS_CODE_OK_DESC);
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

	/**
	 * 检查模型属性的配置信息是否合法。
	 * @param vo
	 * @throws Exception
	 */
	public void checkAttributeCfg(TempGenerateParamVo vo) throws Exception {
		boolean codeEmpty = Strings.isNullOrEmpty(vo.getCfgJavaAttributeCode());
		boolean typeEmpty = Strings.isNullOrEmpty(vo.getCfgJavaAttributeType());
		boolean valEmpty = Strings.isNullOrEmpty(vo.getCfgJavaAttributeDefaultVal());
		boolean descEmpty = Strings.isNullOrEmpty(vo.getCfgJavaAttributeDesc());
		boolean nullEmpty = Strings.isNullOrEmpty(vo.getCfgJavaAttributeCanNull());
		boolean dbEmpty = Strings.isNullOrEmpty(vo.getCfgDBColumnCode());

		boolean empty = (codeEmpty || typeEmpty || valEmpty || descEmpty || nullEmpty);
		if(empty){
			int codeSize = vo.getCfgJavaAttributeCode().split(IContant.K_SPLIT).length;
			int typeSize = vo.getCfgJavaAttributeType().split(IContant.K_SPLIT).length;
			int valSize = vo.getCfgJavaAttributeDefaultVal().split(IContant.K_SPLIT).length;
			int descSize = vo.getCfgJavaAttributeDesc().split(IContant.K_SPLIT).length;
			int nullSize = vo.getCfgJavaAttributeCanNull().split(IContant.K_SPLIT).length;
			int dbSize = vo.getCfgDBColumnCode().split(IContant.K_SPLIT).length;
			if((codeSize != typeSize)
					|| (codeSize == valSize)
					|| (codeSize == descSize)
					|| (codeSize == nullSize)
					|| (codeSize == dbSize) ){
				throw new Exception("参数:cfgJavaAttributeDesc,cfgDBColumnCode,cfgJavaAttributeType,cfgJavaAttributeCode,cfgJavaAttributeCanNull,cfgJavaAttributeDefaultVal 的分割数量必须相等");
			}
		}
	}

	/**
	 * 检查常量的配置信息是否合法。
	 * @param vo
	 * @throws Exception
	 */
	public void checkContantCfg(TempGenerateParamVo vo) throws Exception {
		boolean codeEmpty = Strings.isNullOrEmpty(vo.getCfgJavaContantCode());
		boolean typeEmpty = Strings.isNullOrEmpty(vo.getCfgJavaContantType());
		boolean valEmpty = Strings.isNullOrEmpty(vo.getCfgJavaContantDefaultVal());
		boolean descEmpty = Strings.isNullOrEmpty(vo.getCfgJavaContantDesc());
		boolean empty = (codeEmpty || typeEmpty || valEmpty || descEmpty);
		if(empty){
			int codeSize = vo.getCfgJavaContantCode().split(IContant.K_SPLIT).length;
			int typeSize = vo.getCfgJavaContantType().split(IContant.K_SPLIT).length;
			int valSize = vo.getCfgJavaContantDefaultVal().split(IContant.K_SPLIT).length;
			int descSize = vo.getCfgJavaContantDesc().split(IContant.K_SPLIT).length;
			if((codeSize != typeSize)
					|| (codeSize == valSize)
					|| (codeSize == descSize) ){
				throw new Exception("参数:cfgJavaContantDesc,cfgJavaContantType,cfgJavaContantCode,cfgJavaContantDefaultVal 的分割数量必须相等");
			}
		}
	}

	public Cfg initCfg(TempGenerateParamVo model ) throws InvocationTargetException {
		LOG.info("csConfig:{}",JsonUtil.toJSONString(csConfig));
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
