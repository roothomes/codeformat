package com.roothomes.common.service;

/**
 * @author roothomes
 */
public interface ITempletCont {

	String SERVICE_NAME="Rabbit MQ 测试服务";

	String MQ_HEARTBEAT_NAME ="心跳消息";
	
	String RABBITMQ_LOCK_PREFIX="rabbitmq_lock_";
	
	String CONFIG_SPLIT_CHAR="|";
	
	
	/**
	 * 
	 */
	
	String[] CLASS_MODEL_BASE_IMPORT = new String[]{
			"javax.persistence.Column",
			"javax.persistence.Entity",
			"javax.persistence.Table",
			
			"org.hibernate.annotations.DynamicUpdate",
			"org.hibernate.annotations.GenericGenerator",
			
			"com.apec.framework.common.Constants",
			"com.apec.framework.jpa.model.BaseModel",
	};
	
}
