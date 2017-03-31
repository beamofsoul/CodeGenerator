package com.beamofsoul.core.generator.template;

public abstract class ServiceTemplate extends JavaTemplate {

	public static final String TEMPLATE_TYPE = "Service";
	public static final String TEMPLATE_STATUS = "Impl";
	public static final String INJECT_TYPE = "Repository";
	
	public static String getServiceInterfaceClassName(String className) {
		return className + TEMPLATE_TYPE;
	}
	
	public static String getServiceImplementClassName(String className) {
		return className + TEMPLATE_TYPE + TEMPLATE_STATUS;
	}
}
