package com.beamofsoul.core.generator.template;

import com.beamofsoul.core.generator.util.StringUtils;

public abstract class AddPageTemplate extends JavaServerPagesTemplate {
	
	public static String getAddPageClassName(String entityName) {
		return "admin" + StringUtils.formatHumpToUnderline(entityName) + "_add";
	}
}
