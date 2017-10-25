package com.roothomes.common.dto;

import lombok.Data;

/**
 * @author roothomes
 */
@Data
public class TempletTableColumn {

	private String name;
	private String type;
	private String length;
	private String decimalPoint;
	private String isNull;
	private String isPK;
	private String defaultValue;
	private String desc;
}
