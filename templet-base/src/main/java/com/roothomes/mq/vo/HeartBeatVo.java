package com.roothomes.mq.vo;

import lombok.Data;

@Data
public class HeartBeatVo {
	
	/** 用户在系统的唯一id */
	private String userId;
	/** 用户在ERP里面的席位号 */
	private String erpCode;
	/** 用户手机号码 */
	private String userPhone;
	/** 用户在ERP里面的会员名称 */
	private String userName;
	/** 用户类型：（1 企业 ；2 个人）*/
	private String userType;
	/** 功能类型：（1：刷新库存） */
	private String functionType;
	/** 发送时候的系统时间 */
	private Long sendTime;

}