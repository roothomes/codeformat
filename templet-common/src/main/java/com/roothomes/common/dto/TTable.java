package com.roothomes.common.dto;

import java.util.List;

import lombok.Data;

@Data
public class TTable {

	private String name;
	private String desc;
	private List<TTableColumn> columns;
}