package com.beamofsoul.core.generator.template;

public abstract class ControllerTemplate extends JavaTemplate {

	public static final String TEMPLATE_TYPE = "Controller";
	public static final String INJECT_TYPE = "Service";
	
	public static String getControllerClassName(String className) {
		return className + TEMPLATE_TYPE;
	}
}
