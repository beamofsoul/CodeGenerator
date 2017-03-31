package com.beamofsoul.core.generator.template;

import java.io.IOException;

/**
 * @ClassName DefaultControllerTemplate
 * @Description 默认控制器模板类
 * @author MingshuJian
 * @Date 2017年3月29日 下午3:01:09
 * @version 1.0.0
 */
public class DefaultControllerTemplate extends ControllerTemplate {
	
	public DefaultControllerTemplate(String packagePath, String entityPath, String entityName) throws IOException {
		super.packagePath = packagePath;
		super.entityPath = entityPath;
		super.entityName = entityName;
		super.templateName = this.getClass().getSimpleName();
		super.templateContent = getTemplateContent();
	}
	
	@Override
	public String getGeneratedContent() {
		templateContent = templateContent.replace("####TEMPLATETYPE0####", TEMPLATE_TYPE);
		templateContent = templateContent.replace("####TEMPLATETYPE1####", TEMPLATE_TYPE.toLowerCase());
		templateContent = templateContent.replace("####INJECTTYPE0####", INJECT_TYPE);
		templateContent = templateContent.replace("####INJECTTYPE1####", INJECT_TYPE.toLowerCase());
		templateContent = templateContent.replace("####PACKAGE####", packagePath);
		templateContent = templateContent.replace("####ENTITYPATH####", entityPath);
		templateContent = templateContent.replace("####ENTITY####", entityName);
		templateContent = templateContent.replace("####ENTITYSMALLCAPITAL####", (new StringBuilder()).append(Character.toLowerCase(entityName.charAt(0))).append(entityName.substring(1)).toString());
		return templateContent;
	}
}
