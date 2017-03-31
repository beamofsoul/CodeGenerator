package com.beamofsoul.core.generator.template;

import com.beamofsoul.core.generator.util.StringUtils;

public abstract class BusinessJavaScriptTemplate extends JavaScriptTemplate {
	
	public static String getBusinessJavaScriptClassName(String entityName) {
		return StringUtils.formatHumpToDash(entityName).substring(1) + "-biz";
	}
}
