package com.beamofsoul.core.generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

import com.beamofsoul.core.generator.template.AddPageTemplate;
import com.beamofsoul.core.generator.template.BusinessJavaScriptTemplate;
import com.beamofsoul.core.generator.template.ControllerTemplate;
import com.beamofsoul.core.generator.template.CopyPageTemplate;
import com.beamofsoul.core.generator.template.DefaultAddPageTemplate;
import com.beamofsoul.core.generator.template.DefaultBusinessJavaScriptTemplate;
import com.beamofsoul.core.generator.template.DefaultControllerTemplate;
import com.beamofsoul.core.generator.template.DefaultCopyPageTemplate;
import com.beamofsoul.core.generator.template.DefaultListPageTemplate;
import com.beamofsoul.core.generator.template.DefaultRepositoryInterfaceTemplate;
import com.beamofsoul.core.generator.template.DefaultServiceImplementTemplate;
import com.beamofsoul.core.generator.template.DefaultServiceInterfaceTemplate;
import com.beamofsoul.core.generator.template.DefaultUpdatePageTemplate;
import com.beamofsoul.core.generator.template.ListPageTemplate;
import com.beamofsoul.core.generator.template.RepositoryTemplate;
import com.beamofsoul.core.generator.template.ServiceTemplate;
import com.beamofsoul.core.generator.template.Template;
import com.beamofsoul.core.generator.template.UpdatePageTemplate;

public class GenerateAnnotatedContainer {

	private Set<GenerateAnnotatedElement> container;
	
	public GenerateAnnotatedContainer() {
		container = new LinkedHashSet<>();
	}
	
	public GenerateAnnotatedContainer(GenerateAnnotatedElement annotatedClass) {
		container = new LinkedHashSet<>();
		add(annotatedClass);
	}
	
	public void add(GenerateAnnotatedElement annotatedClass) {
		container.add(annotatedClass);
	}
	
	public void generateCode() throws IOException {
		String elementPackagePath,className,packagePath,elementName,elementPath;
		for (GenerateAnnotatedElement element : container) {
			elementPackagePath = element.getPackagePath();
			className = element.getSimpleTypeName();
			packagePath = elementPackagePath.substring(0,elementPackagePath.lastIndexOf("."));
			elementName = element.getSimpleTypeName();
			elementPath = element.getQulifiedName();
			
			if (element.isIncludeBackend()) {
				generateCode0(element.getOutput(), ServiceTemplate.getServiceInterfaceClassName(className), new DefaultServiceInterfaceTemplate(packagePath, elementPath, elementName));
				generateCode0(element.getOutput(), ServiceTemplate.getServiceImplementClassName(className), new DefaultServiceImplementTemplate(packagePath, elementPath, elementName));
				generateCode0(element.getOutput(), RepositoryTemplate.getRepositoryInterfaceClassName(className), new DefaultRepositoryInterfaceTemplate(packagePath, elementPath, elementName));
				generateCode0(element.getOutput(), ControllerTemplate.getControllerClassName(className), new DefaultControllerTemplate(packagePath, elementPath, elementName));
			}
			
			if (element.isIncludeFrontend()) {
				generateCode0(element.getOutput(), ListPageTemplate.getListPageClassName(elementName), new DefaultListPageTemplate(elementName));
				generateCode0(element.getOutput(), AddPageTemplate.getAddPageClassName(elementName), new DefaultAddPageTemplate(elementName));
				generateCode0(element.getOutput(), CopyPageTemplate.getCopyPageClassName(elementName), new DefaultCopyPageTemplate(elementName));
				generateCode0(element.getOutput(), UpdatePageTemplate.getUpdatePageClassName(elementName), new DefaultUpdatePageTemplate(elementName));
				generateCode0(element.getOutput(), BusinessJavaScriptTemplate.getBusinessJavaScriptClassName(elementName), new DefaultBusinessJavaScriptTemplate(elementName));
			}
		}
	}
	
	private void generateCode0(String outputDirectory, String className, Template template) throws IOException {
		if (outputDirectory == null || outputDirectory.trim().length() == 0) {
			generateCode0(className, template);
		} else {
			Path path = Paths.get(outputDirectory + className + "." + template.getTemplateFileExtension());
			generateCode0(path, template.getGeneratedContent());
		}
	}
	
	private void generateCode0(String className, Template template) throws IOException {
		Path path = Paths.get("b:/" + className + "." + template.getTemplateFileExtension());
		generateCode0(path, template.getGeneratedContent());
	}
	
	private void generateCode0(Path path, String content) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {  
		    writer.write(content);  
		}
	}
}
