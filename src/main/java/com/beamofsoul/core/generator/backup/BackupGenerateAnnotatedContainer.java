package com.beamofsoul.core.generator.backup;
//package com.beamofsoul.core.generator;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.lang.model.element.Modifier;
//
//import com.beamofsoul.core.generator.Generator.Type;
//import com.beamofsoul.core.generator.template.DefaultServiceImplementTemplate;
//import com.beamofsoul.core.generator.template.DefaultServiceInterfaceTemplate;
//import com.beamofsoul.core.generator.template.Template;
//
//public class GenerateAnnotatedContainer {
//
//	private Set<GenerateAnnotatedElement> container = new LinkedHashSet<>();
//	private Generator builder;
//	
//	public GenerateAnnotatedContainer() {
//		
//	}
//	
//	public GenerateAnnotatedContainer(GenerateAnnotatedElement annotatedClass) {
//		add(annotatedClass);
//	}
//	
//	public void add(GenerateAnnotatedElement annotatedClass) {
//		container.add(annotatedClass);
//	}
//	
//	public void generateCode() throws IOException {
//		for (GenerateAnnotatedElement element : container) {
//			String packagePath = element.getPackagePath();
//			String className = element.getSimpleTypeName() + DefaultServiceInterfaceTemplate.TEMPLATE_TYPE;
//			String packagePath4Service = packagePath.substring(0,packagePath.lastIndexOf("."));
//			String elementName = element.getSimpleTypeName();
//			String elementPath = element.getQulifiedName();
//			
//			generateCode0(className, new DefaultServiceInterfaceTemplate(packagePath4Service, elementPath, elementName));
//			
//			className += DefaultServiceImplementTemplate.TEMPLATE_STATUS;
//			write(className, new DefaultServiceImplementTemplate(packagePath4Service, elementPath, elementName).getTemplateContent());
//			
//			//generatedService(element);
//			//generatedServiceImpl(element);
//		}
//		
//		
////		EnumSet.of(Modifier.PUBLIC)
//		
////		JavaFileObject jfo = filer.createSourceFile(qualifiedClassName + "Service");
////		Writer writer = jfo.openWriter();
////		JavaWriter jw = new JavaWriter(writer);
////		
////		jw.beginType(generateClassName, "class", EnumSet.of(Modifier.PUBLIC));
////		jw.emitEmptyLine();
////		jw.beginMethod(qualifiedClassName, "create", EnumSet.of(Modifier.PUBLIC), "String", "id");
////		jw.beginControlFlow("if (id == null)");
////		jw.emitStatement("throw new IllegalArgumentException(\"id is null!\")");
////		jw.endControlFlow();
////		
////		for (GenerateAnnotatedClass item : itemsMap) {
////			jw.beginControlFlow("if (\"%s\".equals(id))", item.isAvailable());
////			jw.emitStatement("return new %s()", item.getTypeElement()
////					.getQualifiedName().toString());
////			jw.endControlFlow();
////			jw.emitEmptyLine();
////		}
////		jw.emitStatement("throw new IllegalArgumentException(\"Unknown id = \" + id)");
////		jw.endMethod();
////
////		jw.endType();
////		
////		jw.close();
//	}
//	
//	public void generateCode0(String className, Template template) throws IOException {
//		Path path = Paths.get("e:/" + className + ".java");
//		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {  
//		    writer.write(template.getGeneratedContent());  
//		}
//	}
//
//	@SuppressWarnings("unused")
//	private void generatedService(GenerateAnnotatedElement element) throws IOException {
//		builder = Generator.builder();
//		String className = generatePackageContent(element, "Service", "service");
//		
//		builder.beginType(className, Type.INTERFACE, Modifier.PUBLIC);
//		
//		String simpleTypeName = element.getSimpleTypeName();
//		String singleCurrentTypeArgument = simpleTypeName + " " + simpleTypeName.toLowerCase();
//		
//		builder.beginMethod(null, simpleTypeName, "create", singleCurrentTypeArgument);
//		builder.importClass(element.getQulifiedName().toString());
//		builder.endMethod();
//		
//		builder.beginMethod(null, simpleTypeName, "update", singleCurrentTypeArgument);
//		builder.endMethod();
//		
//		builder.beginMethod(null, Long.class.getSimpleName().toLowerCase(), "delete", Long.class.getSimpleName() + "..." + " ids");
//		builder.endMethod();
//		
//		builder.emitEmptyLine();
//		
//		builder.beginMethod(null, simpleTypeName, "findById", Long.class.getSimpleName() + " id");
//		builder.endMethod();
//		
//		builder.emitEmptyLine();
//		
//		builder.importClass(List.class.getName(),"org.springframework.data.domain.Page","org.springframework.data.domain.Pageable","com.querydsl.core.types.Predicate");
//		String findAllMethodName = "findAll";
//		String pageableCurrentTypeReturnType = "Page<" + simpleTypeName + ">";
//		
//		builder.beginMethod(null, "List<" + simpleTypeName + ">", findAllMethodName, new String[]{});
//		builder.endMethod();
//		
//		builder.beginMethod(null, pageableCurrentTypeReturnType, findAllMethodName, "Pageable pageable");
//		builder.endMethod();
//		
//		builder.beginMethod(null, pageableCurrentTypeReturnType, findAllMethodName, "Pageable pageable, Predicate predicate");
//		builder.endMethod();
//		
//		builder.endType();
//		
//		write(className);
//	}
//
//	@SuppressWarnings("unused")
//	private void generatedServiceImpl(GenerateAnnotatedElement element) throws IOException {
//		builder = Generator.builder();
//		String className = generatePackageContent(element, "ServiceImpl", "service.impl");
//		
//		builder.beginType(className, Type.CLASS, Modifier.PUBLIC);
//		
//		builder.beginMethod(null, element.getSimpleTypeName(), "create", element.getSimpleTypeName() + " " + element.getSimpleTypeName().toLowerCase());
//		builder.importClass(element.getQulifiedName().toString());
//		builder.endMethod();
//		
//		builder.beginMethod(null, element.getSimpleTypeName(), "update", element.getSimpleTypeName() + " " + element.getSimpleTypeName().toLowerCase());
//		builder.endMethod();
//		
//		builder.beginMethod(null, Long.class.getSimpleName().toLowerCase(), "delete", Long.class.getSimpleName() + "..." + " ids");
//		builder.endMethod();
//		
//		builder.emitEmptyLine();
//		
//		builder.beginMethod(null, element.getSimpleTypeName(), "findById", Long.class.getSimpleName() + " id");
//		builder.endMethod();
//		
//		builder.emitEmptyLine();
//		
//		builder.importClass(List.class.getName(),"org.springframework.data.domain.Page","org.springframework.data.domain.Pageable","com.querydsl.core.types.Predicate");
//		builder.beginMethod(null, "List<" + element.getSimpleTypeName() + ">", "findAll", new String[]{});
//		builder.endMethod();
//		
//		builder.beginMethod(null, "Page<" + element.getSimpleTypeName() + ">", "findAll", "Pageable pageable");
//		builder.endMethod();
//		
//		builder.beginMethod(null, "Page<" + element.getSimpleTypeName() + ">", "findAll", "Pageable pageable, Predicate predicate");
//		builder.endMethod();
//		
//		builder.endType();
//		
//		write(className);
//	}
//
//	private String generatePackageContent(GenerateAnnotatedElement element, String endOfClassName, String endOfPackagePath) {
//		String className = element.getSimpleTypeName() + endOfClassName;
//		if (!element.getPackageElement().isUnnamed()) {
//			String pkg = element.getPackageElement().getQualifiedName().toString();
//			builder.emitPackage(pkg.substring(0,pkg.lastIndexOf(".") + 1) + endOfPackagePath);
//			builder.emitEmptyLine();
//		} else {
//			builder.emitPackage("");
//		}
//		return className;
//	}
//	
//	private void write(String className) throws IOException {
//		Path path = Paths.get("e:/" + className + ".java");
//		try (BufferedWriter writer = Files.newBufferedWriter(path)) {  
//		    writer.write(builder.build());  
//		}
//	}
//	
//	private void write(String className, String content) throws IOException {
//		Path path = Paths.get("e:/" + className + ".java");
//		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {  
//		    writer.write(content);  
//		}
//	}
//	
//	@SuppressWarnings("unused")
//	private void write(String classPath, String className, String content) throws IOException {
//		Path path = Paths.get(classPath + className + ".java");
//		try (BufferedWriter writer = Files.newBufferedWriter(path)) {  
//		    writer.write(content);  
//		}
//	}
//}
