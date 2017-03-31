package com.beamofsoul.core.generator.template;

import java.io.IOException;

/**
 * @ClassName DefaultCopyPageTemplate
 * @Description 默认复制页面模板类
 * @author MingshuJian
 * @Date 2017年3月29日 下午3:01:09
 * @version 1.0.0
 */
public class DefaultCopyPageTemplate extends CopyPageTemplate {
	
	public DefaultCopyPageTemplate(String entityName) throws IOException {
		super.entityName = entityName;
		super.templateName = this.getClass().getSimpleName();
		super.templateContent = getTemplateContent();
	}
	
	@Override
	public String getGeneratedContent() {
		templateContent = templateContent.replace("####ENTITY####", entityName);
		return templateContent;
	}
}
