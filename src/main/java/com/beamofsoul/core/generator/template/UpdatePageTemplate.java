package com.beamofsoul.core.generator.template;

import com.beamofsoul.core.generator.util.StringUtils;

public abstract class UpdatePageTemplate extends JavaServerPagesTemplate {
	
	public static String getUpdatePageClassName(String entityName) {
		return "admin" + StringUtils.formatHumpToUnderline(entityName) + "_update";
	}
}
