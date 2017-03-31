package com.beamofsoul.core.generator.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Template {

	String templateName;
	String templateContent;
	String packagePath;
	String entityPath;
	String entityName;
	
	public abstract String getTemplateFileExtension();
	
	String getTemplateContent() throws IOException {
		StringBuffer content = new StringBuffer();
		String separator = System.getProperty("line.separator");
		InputStream in = getClass().getClassLoader().getResourceAsStream("static/template/" + getTemplateFileExtension() + "/" + templateName + ".tlt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		for (String data = bufferedReader.readLine(); data != null; data = bufferedReader.readLine())
			content.append(data + separator);
		in.close();
		return content.toString();
	}
	
	public abstract String getGeneratedContent();
}