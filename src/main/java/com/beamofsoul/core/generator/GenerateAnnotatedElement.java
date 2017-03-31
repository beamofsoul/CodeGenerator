package com.beamofsoul.core.generator;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

public class GenerateAnnotatedElement {

	private PackageElement packageElement;
	private TypeElement typeElement;
	private String qulifiedName;
	private String simpleTypeName;
	private String packagePath;
	
	private boolean available;
	private boolean includeFrontend;
	private boolean includeBackend;
	private String output;
	
	public GenerateAnnotatedElement(TypeElement typeElement) {
		this.typeElement = typeElement;
		packageElement = (PackageElement) typeElement.getEnclosingElement(); 
		qulifiedName = typeElement.getQualifiedName().toString();
		simpleTypeName = typeElement.getSimpleName().toString();
		packagePath = packageElement.toString();
		
		Generate annotation = typeElement.getAnnotation(Generate.class);
		available = annotation.available();
		includeFrontend = annotation.includeFrontend();
		includeBackend = annotation.includeBackend();
		output = annotation.output();
	}
	
	public TypeElement getTypeElement() {
		return this.typeElement;
	}
	
	public PackageElement getPackageElement() {
		return this.packageElement;
	}

	public String getQulifiedName() {
		return qulifiedName;
	}

	public String getSimpleTypeName() {
		return simpleTypeName;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public boolean isIncludeFrontend() {
		return includeFrontend;
	}
	
	public boolean isIncludeBackend() {
		return includeBackend;
	}
	
	public String getOutput() {
		return output;
	}
}
