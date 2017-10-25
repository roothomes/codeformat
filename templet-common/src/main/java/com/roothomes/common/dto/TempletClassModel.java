package com.roothomes.common.dto;

import java.util.List;

import lombok.Data;
/**
 * 表名称
 * @author roothomes
 */
@Data
public class TempletClassModel {
	/** 类编码名称 */
	private String name;
	/** 类名称说明 */
	private String desc;
	/** 属性列表 */
	private List<TempletClassAttribute> attributes;
}
