package com.beamofsoul.core.generator.template;

import com.beamofsoul.core.generator.util.StringUtils;

public abstract class ListPageTemplate extends JavaServerPagesTemplate {
	
	public static String getListPageClassName(String entityName) {
		return "admin" + StringUtils.formatHumpToUnderline(entityName) + "_list";
	}
}
