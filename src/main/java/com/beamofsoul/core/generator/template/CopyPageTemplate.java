package com.beamofsoul.core.generator.template;

import com.beamofsoul.core.generator.util.StringUtils;

public abstract class CopyPageTemplate extends HyperTextMarkupLanguageTemplate {
	
	public static String getCopyPageClassName(String entityName) {
		return "admin" + StringUtils.formatHumpToUnderline(entityName) + "_copy";
	}
}
