package com.roothomes.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.apec.framework.common.StringUtil;
import com.roothomes.common.dto.TClassAttribute;
import com.roothomes.common.dto.TClassModel;
import com.roothomes.common.service.ITempletConfigService;
import com.roothomes.common.service.ITempletCont;

@Service
public class TempletConfigServiceImpl implements ITempletConfigService ,ITempletCont{
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger( TempletConfigServiceImpl.class );
	/*
class.model.name=HelloTable|你好
class.model.attribute.code=id|name|value
class.model.attribute.desc=主键id自动生成|名称|名称的值
class.model.attribute.type=String|String|String
	 */
	@Value("${model.package.base}")
	private String modelPackageBase;
	@Value("${model.class}")
	private String modelClass;
	@Value("${model.class.attribute.code}")
	private String modelClassAttributeCode;
	@Value("${model.class.attribute.desc}")
	private String modelClassAttributeDesc;
	@Value("${model.class.attribute.type}")
	private String modelClassAttributeType;
	
	
	/**
	 * 数据库表名称
	 */
	@Value("${table.name}")
	private String tableName;
	/**
	 * 数据库表的列名称
	 */
	@Value("${table.column.name}")
	private String tableColumnName;
	
	
	/**
	 * 初始化模型对象
	 */
	private TClassModel initModelClass() throws Exception{
		checkCfgTClassModel();
		TClassModel model = new TClassModel();
		String[] cla = modelClass.split(CONFIG_SPLIT_CHAR);
		model.setName(cla[0]);
		model.setDesc(cla[1]);
		String[] codeS = modelClassAttributeCode.split(CONFIG_SPLIT_CHAR);
		String[] descS = modelClassAttributeDesc.split(CONFIG_SPLIT_CHAR);
		String[] typeS = modelClassAttributeType.split(CONFIG_SPLIT_CHAR);
		List<TClassAttribute> attributes = new ArrayList<>(codeS.length);
		for(int i=0;i<codeS.length;i++){
			TClassAttribute one = new TClassAttribute();
			one.setAttributeCode(codeS[i]);
			one.setAttributeType(typeS[i]);
			one.setAttributeDesc(descS[i]);
			attributes.add(one);
		}
		model.setAttributes(attributes);
		return model;
	}
	
	/**
	 * 检查配置文件的格式是否合法
	 * @return
	 * @throws Exception
	 */
	private boolean checkCfgTClassModel()throws Exception{
		String msg = "";
		String errorTempletAttribute_lost = "配置属性缺失。";
		String errorTempletAttribute_format = "配置属性格式错误。";
		String configKey = "model.class";

		configKey = "model.package.base";
		if(StringUtil.isEmpty(modelPackageBase)){
			msg = configKey + errorTempletAttribute_lost;
			LOG.error(msg);
			throw new Exception(msg);
		}
		
		configKey = "model.class";
		if(StringUtil.isEmpty(modelClass)){
			msg = configKey + errorTempletAttribute_lost;
			LOG.error(msg);
			throw new Exception(msg);
		}else{
			if(modelClass.split("|").length != 2){
				msg = configKey + errorTempletAttribute_format;
				LOG.error(msg);
				throw new Exception(msg);
			}
		}

		configKey = "model.class.attribute.code";
		if(StringUtil.isEmpty(modelClassAttributeCode)){
			msg = configKey + " is null.";
			LOG.error(msg);
			throw new Exception(msg);
		}else{
			if(modelClassAttributeCode.split("|").length > 1){
				msg = configKey + errorTempletAttribute_format;
				LOG.error(msg);
				throw new Exception(msg);
			}
		}
		
		
		configKey = "model.class.attribute.desc";
		if(StringUtil.isEmpty(modelClassAttributeDesc)){
			msg = configKey + " is null.";
			LOG.error(msg);
			throw new Exception(msg);
		}else{
			if(modelClassAttributeDesc.split("|").length > 1){
				msg = configKey + errorTempletAttribute_format;
				LOG.error(msg);
				throw new Exception(msg);
			}
		}
		
		configKey = "model.class.attribute.type";
		if(StringUtil.isEmpty(modelClassAttributeType)){
			msg =configKey +  " is null.";
			LOG.error(msg);
			throw new Exception(msg);
		}else{
			if(modelClassAttributeType.split("|").length > 1){
				msg = configKey + errorTempletAttribute_format;
				LOG.error(msg);
				throw new Exception(msg);
			}
		}
		
		if(modelClassAttributeCode.split("|").length != modelClassAttributeType.split("|").length){
			msg = "code与type的数量不匹配";
			LOG.error(msg);
			throw new Exception(msg);
		}
		return true;
	}
	
	private boolean checkCfgTTable()throws Exception{
		String msg = "";
		String errorTempletAttribute_lost = "配置属性缺失。";
		String errorTempletAttribute_format = "配置属性格式错误。";
		String configKey = "table.name";

		configKey = "table.name";
		if(StringUtil.isEmpty(tableName)){
			msg = configKey + errorTempletAttribute_lost;
			LOG.error(msg);
			throw new Exception(msg);
		}
		configKey = "table.column.name";
		if(StringUtil.isEmpty(tableColumnName)){
			msg = configKey + errorTempletAttribute_lost;
			LOG.error(msg);
			throw new Exception(msg);
		}
		
		return true;
	}
	

}
