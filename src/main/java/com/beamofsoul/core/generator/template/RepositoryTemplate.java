package com.beamofsoul.core.generator.template;

public abstract class RepositoryTemplate extends JavaTemplate {

	public static final String TEMPLATE_TYPE = "Repository";
	public static final String TEMPLATE_STATUS = "Impl";
	
	public static String getRepositoryInterfaceClassName(String className) {
		return className + TEMPLATE_TYPE;
	}
	
	public static String getRepositoryImplementClassName(String className) {
		return className + TEMPLATE_TYPE + TEMPLATE_TYPE;
	}
}
