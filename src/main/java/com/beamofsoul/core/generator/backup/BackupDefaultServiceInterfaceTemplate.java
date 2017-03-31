package com.beamofsoul.core.generator.backup;
//package com.beamofsoul.core.generator.template;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//
///**
// * @ClassName DefaultServiceInterfaceTemplate
// * @Description 默认服务接口模板类
// * @author MingshuJian
// * @Date 2017年3月29日 下午3:01:09
// * @version 1.0.0
// */
//public class BackupDefaultServiceInterfaceTemplate {
//
//	private StringBuffer content = new StringBuffer();
//	private String templateContent = null;
//	public static final String TEMPLATE_TYPE = "Service";
//	private static final String PACKAGE = "package ####PACKAGE####.####TEMPLATETYPE1####";
//	private static final String IMPORT = "import java.util.List;\r\n\r\nimport org.springframework.data.domain.Page;\r\nimport org.springframework.data.domain.Pageable;\r\n\r\nimport ####ENTITYPATH####;\r\nimport com.querydsl.core.types.Predicate;";
//	private static final String TYPE_BEGIN = "public interface ####ENTITY########TEMPLATETYPE0#### {";
//	private static final String METHOD_CREATE = "	####ENTITY#### create(####ENTITY#### ####ENTITYSMALLCAPITAL####);";
//	private static final String METHOD_UPDATE = "	####ENTITY#### update(####ENTITY#### ####ENTITYSMALLCAPITAL####);";
//	private static final String METHOD_DELETE = "	long delete(Long... ids);";
//	private static final String METHOD_FIND_BY_ID = "	####ENTITY#### findById(Long id);";
//	private static final String METHOD_FIND_ALL_0 = "	List<####ENTITY####> findAll();";
//	private static final String METHOD_FIND_ALL_1 = "	Page<####ENTITY####> findAll(Pageable pageable);";
//	private static final String METHOD_FIND_ALL_2 = "	Page<####ENTITY####> findAll(Pageable pageable, Predicate predicate);";
//	private static final String TYPE_END = "}";
//
//	private String packagePath;
//	private String entityPath;
//	private String entityName;
//
//	@SuppressWarnings("unused")
//	private BackupDefaultServiceInterfaceTemplate() {
//	}
//
//	public BackupDefaultServiceInterfaceTemplate(String packagePath, String entityPath, String entityName) throws IOException {
//		this.packagePath = packagePath;
//		this.entityPath = entityPath;
//		this.entityName = entityName;
//
//		File file = new File("static/template/DefaultServiceInterfaceTemplate.bos");
//		System.out.println(file == null ? "file is null" : file.isFile());
//		
//		InputStream in = getClass().getClassLoader().getResourceAsStream("static/template/DefaultServiceInterfaceTemplate.bos");
//		
//		@SuppressWarnings("unused")
//		int read = 0;
//		byte[] buffer = new byte[1024];
//		while ((read = in.read(buffer)) != -1) {
//			content.append(new String(buffer));
//		}
//		in.close();
//		
//		templateContent = content.toString();
//		
////		templateContent = content.append(PACKAGE).append("\r\n\r\n").append(IMPORT).append("\r\n\r\n")
////				.append(TYPE_BEGIN).append("\r\n\r\n").append(METHOD_CREATE).append("\r\n").append(METHOD_UPDATE)
////				.append("\r\n").append(METHOD_DELETE).append("\r\n\r\n").append(METHOD_FIND_BY_ID).append("\r\n\r\n")
////				.append(METHOD_FIND_ALL_0).append("\r\n").append(METHOD_FIND_ALL_1).append("\r\n")
////				.append(METHOD_FIND_ALL_2).append("\r\n").append(TYPE_END).toString();
//	}
//
//	public String getTemplateContent() {
//		templateContent = templateContent.replace("####TEMPLATETYPE0####", TEMPLATE_TYPE);
//		templateContent = templateContent.replace("####TEMPLATETYPE1####", TEMPLATE_TYPE.toLowerCase());
//		templateContent = templateContent.replace("####PACKAGE####", packagePath);
//		templateContent = templateContent.replace("####ENTITYPATH####", entityPath);
//		templateContent = templateContent.replace("####ENTITY####", entityName);
//		templateContent = templateContent.replace("####ENTITYSMALLCAPITAL####", (new StringBuilder()).append(Character.toLowerCase(entityName.charAt(0))).append(entityName.substring(1)).toString());
//		String temp = templateContent.substring(templateContent.lastIndexOf("}") + 1, templateContent.length());
//		System.out.println("#### " + temp);
//		templateContent = templateContent.substring(0, templateContent.lastIndexOf("}") + 1);
//		return templateContent;
//	}
//}
