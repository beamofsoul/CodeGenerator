package com.beamofsoul.core.generator.template;

import java.io.IOException;

/**
 * @ClassName DefaultRepositoryInterfaceTemplate
 * @Description 默认持久化接口模板类
 * @author MingshuJian
 * @Date 2017年3月29日 下午3:01:09
 * @version 1.0.0
 */
public class DefaultRepositoryInterfaceTemplate extends RepositoryTemplate {

	public DefaultRepositoryInterfaceTemplate(String packagePath, String entityPath, String entityName) throws IOException {
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
		templateContent = templateContent.replace("####PACKAGE####", packagePath);
		templateContent = templateContent.replace("####ENTITYPATH####", entityPath);
		templateContent = templateContent.replace("####ENTITY####", entityName);
		return templateContent;
	}
}
