package com.roothomes.common.dto;

import lombok.Data;

/**
 * 属性描述
 * @author roothomes
 */
@Data
public class TClassAttribute {
	/** 类属性编码名称 */
	private String attributeCode;
	/** 类属性说明 */
	private String attributeDesc;
	/** 类属性类型 */
	private String attributeType;
}
