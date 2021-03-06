package com.beamofsoul.core.generator.template;

import java.io.IOException;

/**
 * @ClassName DefaultBusinessJavaScriptTemplate
 * @Description 默认业务JS模板类
 * @author MingshuJian
 * @Date 2017年3月29日 下午3:01:09
 * @version 1.0.0
 */
public class DefaultBusinessJavaScriptTemplate extends BusinessJavaScriptTemplate {
	
	public DefaultBusinessJavaScriptTemplate(String entityName) throws IOException {
		super.entityName = entityName;
		super.templateName = this.getClass().getSimpleName();
		super.templateContent = getTemplateContent();
	}
	
	@Override
	public String getGeneratedContent() {
		templateContent = templateContent.replace("####ENTITYSMALLCAPITAL####", (new StringBuilder()).append(Character.toLowerCase(entityName.charAt(0))).append(entityName.substring(1)).toString());
		return templateContent;
	}
}
