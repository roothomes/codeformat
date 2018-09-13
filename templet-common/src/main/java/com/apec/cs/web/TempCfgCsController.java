package com.apec.cs.web;

import com.apec.codetempletcontants.model.CodeTempletContants;
import com.apec.codetempletcontants.service.CodeTempletContantsService;
import com.apec.codetempletcontants.vo.CodeTempletContantsVo;
import com.apec.codetempletitem.model.CodeTempletItem;
import com.apec.codetempletitem.vo.CodeTempletItemVo;
import com.apec.codetemplet.dto.CodetempletDTO;
import com.apec.codetemplet.model.Codetemplet;
import com.apec.codetemplet.service.CodetempletService;
import com.apec.codetemplet.util.KeyGenCodetemplet;
import com.apec.codetemplet.vo.CodetempletVo;
import com.apec.codetempletitem.service.CodeTempletItemService;
import com.apec.cs.constants.CsConstants;
import com.apec.cs.util.CsConfig;
import com.apec.cs.vo.TempGenerateParamVo;
import com.apec.cs.vo.TempGenerateRsVo;
import com.apec.framework.common.Constants;
import com.apec.framework.common.ResultData;
import com.apec.framework.common.constants.ErrorCodeConsts;
import com.apec.framework.common.exception.ApecRuntimeException;
import com.apec.framework.common.util.BeanUtil;
import com.apec.framework.common.util.JsonUtil;
import com.google.common.base.Strings;
import com.roothomes.common.util.BuildUtil;
import com.roothomes.common.util.Cfg;
import com.roothomes.common.util.IContant;
import com.roothomes.common.util.ZipCompress;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Autowired
	CodetempletService codetempletService;
	@Autowired
	CodeTempletItemService codetempletItemService;
	@Autowired
	CodeTempletContantsService codeTempletContantsService;
	@Autowired
	private KeyGenCodetemplet idGen;

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
		try {
			TempGenerateParamVo vo = getFormJSON(json, TempGenerateParamVo.class);
			LOG.info("TempGenerateParamVo:{}",JsonUtil.toJSONString(vo));
			Cfg param = initCfg(vo);
			resultData = generateFile(param,vo);
			if(resultData.isSucceed()){
				//不是从数据库配置里面拉取的配置，需要把临时的模型对象存到数据库。
				saveDataToDB(param,resultData);
			}
		} catch (Exception e) {
			LOG.error("generateFile ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(e.getMessage());
		}
		return resultData;
	}

	/**
	 * 从配置的模型对象，生成服务文件
	 * @param json JSON请求参数
	 * @return
	 * @author roothomes
	 * @date 2018-09-01
	 */
	@RequestMapping(value = "/generateFileFromCfgModel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResultData<TempGenerateRsVo> generateFileFromCfgModel(@RequestBody String json) {
		ResultData<TempGenerateRsVo> resultData = new ResultData<TempGenerateRsVo>();
		LOG.debug("generateFile:{}",json);
		try {
			CodetempletDTO code = getFormJSON(json, CodetempletDTO.class);
			if(null == code || Strings.isNullOrEmpty(code.getId())){
				throw new ApecRuntimeException(ErrorCodeConsts.COMMON_MISSING_PARAMS);
			}
			Codetemplet codetemplet = codetempletService.findOne(code.getId());
			if(null == codetemplet){
				throw new ApecRuntimeException(ErrorCodeConsts.ERROR_QUERY_DATA_NOT_EXIST_BY_ID);
			}
			LOG.info("codetemplet:{}",JsonUtil.toJSONString(codetemplet));
			CodeTempletItemVo queryItemVo = new CodeTempletItemVo();
			queryItemVo.setTempletId(codetemplet.getId());
			List<CodeTempletItem> listItem = codetempletItemService.queryAll(queryItemVo);
			CodeTempletContantsVo codeTempletContantsVo = new CodeTempletContantsVo();
			codeTempletContantsVo.setTempletId(codetemplet.getId());
			List<CodeTempletContants> listContants = codeTempletContantsService.queryAll(codeTempletContantsVo);

			//需要从数据库拉取配置的信息，填充到模型里面进行设置
			TempGenerateParamVo vo =  swtichDB2ParamVo(codetemplet,listItem,listContants);
			LOG.info("TempGenerateParamVo:{}",JsonUtil.toJSONString(vo));
			Cfg param = initCfg(vo);
			if(StringUtils.isBlank(param.getCfgJavaFrameworkVersion())){
				param.setCfgJavaFrameworkVersion(IContant.CFG_JAVA_FRAMEWORK_VERSION_V1);
			}
			resultData = generateFile(param,vo);

		} catch (Exception e) {
			LOG.error("generateFile ", e);
			resultData.setSucceed(false);
			resultData.setErrorCode(Constants.SYS_ERROR);
			resultData.setErrorMsg(e.getMessage());
		}
		return resultData;
	}

	/**
	 * 把数据库里面配置的信息转换为生成文件需要的对象
	 * @param codetemplet
	 * @param listItem
	 * @return
	 */
	private TempGenerateParamVo swtichDB2ParamVo(Codetemplet codetemplet,List<CodeTempletItem> listItem,List<CodeTempletContants> listContants)
	throws ApecRuntimeException
	{
		TempGenerateParamVo vo = new TempGenerateParamVo();
		vo.setCfgDBTableName(codetemplet.getCfgDbTableName());
		vo.setCfgArtifactId(codetemplet.getCfgArtifactId());
		vo.setCfgPojoName(codetemplet.getCfgPojoName());
		vo.setCfgModelDesc(codetemplet.getCfgModeDesc());

		StringBuilder cfgJavaAttributeDesc = new StringBuilder();
		StringBuilder cfgDBColumnCode = new StringBuilder();
		StringBuilder cfgJavaAttributeType = new StringBuilder();
		StringBuilder cfgJavaAttributeCode = new StringBuilder();
		StringBuilder cfgJavaAttributeCanNull = new StringBuilder();
		StringBuilder cfgJavaAttributeDefaultVal = new StringBuilder();
		Map<String,String> itemMap = new HashMap<>();
		for(int i=0;i<listItem.size();i++){
			CodeTempletItem one = listItem.get(i);
			if(itemMap.containsKey(one.getCfgJavaAttributeCode().toUpperCase())){
				throw new ApecRuntimeException(CsConstants.ERROR_CODE_ITEM_SAME_VARIABLE);
			}else{
				itemMap.put(one.getCfgJavaAttributeCode().toUpperCase(),one.getCfgJavaAttributeCode().toUpperCase());
			}
			if((i+1) == listItem.size()){
				cfgJavaAttributeDesc.append(one.getCfgJavaAttributeDesc());
				cfgDBColumnCode.append(one.getCfgDBColumnCode());
				cfgJavaAttributeType.append(one.getCfgJavaAttributeType());
				cfgJavaAttributeCode.append(one.getCfgJavaAttributeCode());
				cfgJavaAttributeCanNull.append(one.getCfgJavaAttributeCanNull());
				cfgJavaAttributeDefaultVal.append(one.getCfgJavaAttributeDefaultVal());
			}else{
				cfgJavaAttributeDesc.append(one.getCfgJavaAttributeDesc()).append("|");
				cfgDBColumnCode.append(one.getCfgDBColumnCode()).append("|");
				cfgJavaAttributeType.append(one.getCfgJavaAttributeType()).append("|");
				cfgJavaAttributeCode.append(one.getCfgJavaAttributeCode()).append("|");
				cfgJavaAttributeCanNull.append(one.getCfgJavaAttributeCanNull()).append("|");
				cfgJavaAttributeDefaultVal.append(one.getCfgJavaAttributeDefaultVal()).append("|");
			}
		}
		vo.setCfgJavaAttributeDesc(cfgJavaAttributeDesc.toString()) ;
		vo.setCfgDBColumnCode(cfgDBColumnCode.toString());
		vo.setCfgJavaAttributeType(cfgJavaAttributeType.toString());
		vo.setCfgJavaAttributeCode(cfgJavaAttributeCode.toString());
		vo.setCfgJavaAttributeCanNull(cfgJavaAttributeCanNull.toString());
		vo.setCfgJavaAttributeDefaultVal(cfgJavaAttributeDefaultVal.toString());

		if(null != listContants && !listContants.isEmpty()){
			Map<String,String> contantsMap = new HashMap<>();
			StringBuilder cfgJavaContantDesc = new StringBuilder();
			StringBuilder cfgJavaContantCode = new StringBuilder();
			StringBuilder cfgJavaContantType = new StringBuilder();
			StringBuilder cfgJavaContantDefaultVal = new StringBuilder();

			for(int i=0;i<listContants.size();i++){
				CodeTempletContants one = listContants.get(i);
				if(contantsMap.containsKey(one.getVariableName().toUpperCase())){
					throw new ApecRuntimeException(CsConstants.ERROR_CONTANTS_SAME_VARIABLE);
				}else{
					contantsMap.put(one.getVariableName().toUpperCase(),one.getVariableName().toUpperCase());
				}
				if((i+1) == listContants.size()){
					cfgJavaContantDesc.append(one.getVariableDesc());
					cfgJavaContantCode.append(one.getVariableName().toUpperCase());
					cfgJavaContantType.append(one.getVariableType());
					cfgJavaContantDefaultVal.append(one.getVariableVal());
				}else{
					cfgJavaContantDesc.append(one.getVariableDesc()).append("|");
					cfgJavaContantCode.append(one.getVariableName().toUpperCase()).append("|");
					cfgJavaContantType.append(one.getVariableType()).append("|");
					cfgJavaContantDefaultVal.append(one.getVariableVal()).append("|");
				}
			}
			vo.setCfgJavaContantDesc(cfgJavaContantDesc.toString()); ;
			vo.setCfgJavaContantCode(cfgJavaContantCode.toString());
			vo.setCfgJavaContantType(cfgJavaContantType.toString());
			vo.setCfgJavaContantDefaultVal(cfgJavaContantDefaultVal.toString());
		}


		return vo;
	}

	private ResultData<TempGenerateRsVo> generateFile(Cfg param ,TempGenerateParamVo vo) throws Exception{
		ResultData<TempGenerateRsVo> resultData = new ResultData<TempGenerateRsVo>();
		LOG.debug("generateFile:{}",JsonUtil.toJSONString(vo));
		TempGenerateRsVo data = new TempGenerateRsVo();
		String rt = DateFormatUtils.format(new Date(),UTC_FORMAT);
		data.setRequestTime(rt);
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

		String zipPath = null;
		if(csConfig.getZipDir().endsWith(File.separator)){
			zipPath = csConfig.getZipDir() + param.getCfgArtifactId() + dirTime + ".zip";
		}else{
			zipPath = csConfig.getZipDir() + File.separator + param.getCfgArtifactId() + dirTime + ".zip";
		}
		ZipCompress zipCom = new ZipCompress(zipPath,outputPath);
		zipCom.zip();

		rt = DateFormatUtils.format(new Date(),UTC_FORMAT);
		data.setFilesIp("192.168.7.203");
		data.setFilesPath(param.getCfgOutputBaseDir());
		data.setResponseTime(rt);
		String httpZipPath = null;
		if(csConfig.getHttpZipBasePath().endsWith(File.separator)){
			httpZipPath = csConfig.getHttpZipBasePath() + param.getCfgArtifactId() + dirTime + ".zip";
		}else{
			httpZipPath = csConfig.getHttpZipBasePath() + File.separator + param.getCfgArtifactId() + dirTime + ".zip";
		}
		data.setHttpZip(httpZipPath);
		resultData.setData(data);
		resultData.setErrorCode(CsConstants.BUSINESS_CODE_OK);
		resultData.setErrorMsg(CsConstants.BUSINESS_CODE_OK_DESC);

		return resultData;
	}


	public void saveDataToDB(Cfg param,ResultData<TempGenerateRsVo> resultData) {

		try {
			CodetempletVo codetempletVo = new CodetempletVo();
			codetempletVo.setCfgArtifactId(param.getCfgArtifactId());
			codetempletVo.setCfgDbTableName(param.getCfgDBTableName());
			codetempletVo.setCfgModeDesc(param.getCfgModelDesc());
			codetempletVo.setCfgPojoName(param.getCfgPojoName());
			codetempletVo.setId(String.valueOf(idGen.nextId()));
			codetempletVo.setStatus("1");
			codetempletVo.setRemarks(resultData.getData().getHttpZip());

			codetempletService.create(codetempletVo);

			String[]  codeS = param.getCfgJavaAttributeCode().split(IContant.K_SPLIT);
			String[]  typeS = param.getCfgJavaAttributeType().split(IContant.K_SPLIT);
			String[]  valS = param.getCfgJavaAttributeDefaultVal().split(IContant.K_SPLIT);
			String[]  descS = param.getCfgJavaAttributeDesc().split(IContant.K_SPLIT);
			String[]  nullS = param.getCfgJavaAttributeCanNull().split(IContant.K_SPLIT);
			String[]  dbS = param.getCfgDBColumnCode().split(IContant.K_SPLIT);
			CodeTempletItemVo itemVo = new CodeTempletItemVo();
			for(int i=0;i<codeS.length;i++){
				itemVo = new CodeTempletItemVo();
				itemVo.setTempletId(codetempletVo.getId());
				itemVo.setCfgDBColumnCode(codeS[i]);
				itemVo.setCfgJavaAttributeCanNull(nullS[i]);
				itemVo.setCfgJavaAttributeCode(codeS[i]);
				itemVo.setCfgJavaAttributeDefaultVal(valS[i]);
				itemVo.setCfgJavaAttributeDesc(descS[i]);
				itemVo.setCfgJavaAttributeType(typeS[i]);
				codetempletItemService.create(itemVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


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
		boolean empty = (!codeEmpty || !typeEmpty || !valEmpty || !descEmpty);
		if(empty){
			int codeSize = vo.getCfgJavaContantCode().split(IContant.K_SPLIT).length;
			int typeSize = vo.getCfgJavaContantType().split(IContant.K_SPLIT).length;
			int valSize = vo.getCfgJavaContantDefaultVal().split(IContant.K_SPLIT).length;
			int descSize = vo.getCfgJavaContantDesc().split(IContant.K_SPLIT).length;
			if((codeSize != typeSize)
					|| (codeSize != valSize)
					|| (codeSize != descSize) ){
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
