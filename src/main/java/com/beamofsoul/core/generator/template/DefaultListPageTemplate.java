package com.beamofsoul.core.generator.template;

import java.io.IOException;

import com.beamofsoul.core.generator.util.StringUtils;

/**
 * @ClassName DefaultListPageTemplate
 * @Description 默认列表页面模板类
 * @author MingshuJian
 * @Date 2017年3月29日 下午3:01:09
 * @version 1.0.0
 */
public class DefaultListPageTemplate extends ListPageTemplate {
	
	public DefaultListPageTemplate(String entityName) throws IOException {
		super.entityName = entityName;
		super.templateName = this.getClass().getSimpleName();
		super.templateContent = getTemplateContent();
	}
	
	@Override
	public String getGeneratedContent() {
		templateContent = templateContent.replace("####ENTITY####", entityName);
		
		String entitySmallCapital = (new StringBuilder()).append(Character.toLowerCase(entityName.charAt(0))).append(entityName.substring(1)).toString();
		templateContent = templateContent.replace("####ENTITYSMALLCAPITAL####", entitySmallCapital);
		templateContent = templateContent.replace("####ENTITYSMALLCAPITALUNDERLINE####", StringUtils.formatHumpToUnderline(entitySmallCapital));
		templateContent = templateContent.replace("####ENTITYSMALLCAPITALDASH####", StringUtils.formatHumpToDash(entitySmallCapital));
		return templateContent;
	}
}
