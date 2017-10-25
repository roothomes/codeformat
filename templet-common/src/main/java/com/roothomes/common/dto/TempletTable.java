package com.roothomes.common.dto;

import java.util.List;

import lombok.Data;

/**
 * @author roothomes
 */
@Data
public class TempletTable {

	private String name;
	private String desc;
	private List<TempletTableColumn> columns;
}
