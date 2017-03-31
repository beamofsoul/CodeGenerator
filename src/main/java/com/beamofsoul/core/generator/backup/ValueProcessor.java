package com.beamofsoul.core.generator.backup;
//package com.beamofsoul.core.generator;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Set;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.Messager;
//import javax.annotation.processing.ProcessingEnvironment;
//import javax.annotation.processing.RoundEnvironment;
//import javax.annotation.processing.SupportedAnnotationTypes;
//import javax.annotation.processing.SupportedSourceVersion;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.ElementKind;
//import javax.lang.model.element.TypeElement;
//import javax.lang.model.element.VariableElement;
//import javax.lang.model.util.ElementFilter;
//import javax.lang.model.util.Elements;
//import javax.tools.Diagnostic.Kind;
//
//@SupportedAnnotationTypes({"com.beamofsoul.core.generator.Value"})
//@SupportedSourceVersion(SourceVersion.RELEASE_8)
//public class ValueProcessor extends AbstractProcessor {
//	
////	AnnotationMirror 表示一个注释。
////	AnnotationValue 表示注释类型元素的值。
////	AnnotationValueVisitor<R,P> 注释类型元素值的 visitor，使用 visitor 设计模式的变体。
////	Element 表示一个程序元素，比如包、类或者方法。
////	ElementVisitor<R,P> 程序元素的 visitor，使用 visitor 设计模式的样式。
////	ExecutableElement 表示某个类或接口的方法、构造方法或初始化程序（静态或实例），包括注释类型元素。
////	Name 字符的不可变序列。
////	PackageElement 表示一个包程序元素。
////	TypeElement 表示一个类或接口程序元素。
////	TypeParameterElement 表示一般类、接口、方法或构造方法元素的形式类型参数。
////	VariableElement 表示一个字段、enum 常量、方法或构造方法参数、局部变量或异常参数。
//	
////	ElementKind 元素的 kind。
////	Modifier 表示程序元素（如类、方法或字段）上的修饰符。
////	NestingKind 某一类型元素的嵌套种类 (nesting kind)。
//	
////	UnknownAnnotationValueException 指示遇到一个未知种类的注释值。
////	UnknownElementException 指示遇到一个未知种类的元素。
//	
//	private Elements elementUtils;
////	private Types typeUtils;
//	private Messager messager;
////	private Filer filer;
////	private SourceVersion sourceVersion;
//	
//	@Override
//	public synchronized void init(ProcessingEnvironment processingEnv) {
//		super.init(processingEnv);
//		elementUtils = processingEnv.getElementUtils();
////		typeUtils = processingEnv.getTypeUtils();
//		messager = processingEnv.getMessager();
////		filer = processingEnv.getFiler();
////		sourceVersion = processingEnv.getSourceVersion();
//	}
//	
//	@Override
//	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//		
//		for (TypeElement currentAnnotation : annotations) {
//			if (currentAnnotation.getQualifiedName().toString().equals(Value.class.getName())) {
//				StringBuffer content = new StringBuffer();
//				for (Element element : roundEnv.getElementsAnnotatedWith(Value.class)) {
//					if (element.getKind() != ElementKind.FIELD) {
//						error(element, "Only fileds can be annotated with @%s", Value.class.getSimpleName());
//						return true; // Exit processing;
//					}
//					
//					VariableElement ve = (VariableElement) element;
//					TypeElement te = (TypeElement) ve.getEnclosingElement();
//					
//					content.append("属性名称: " + ve.getSimpleName().toString() + "\r\n");
//					content.append("属性类型: " + ve.asType().toString() + "\r\n");
//					content.append("所在类型: " + te.getSimpleName().toString() + "\r\n");
//					content.append("完整路径: " + te.getQualifiedName().toString() + "\r\n");
//					content.append("包装路径: " + te.getEnclosingElement().toString() + "\r\n");
//					content.append("\r\n");
//					
//					List<VariableElement> fieldsIn = ElementFilter.fieldsIn(elementUtils.getAllMembers(te));
//					for (VariableElement variableElement : fieldsIn) {
//						content.append("类型属性: " + variableElement.getSimpleName().toString() + " - " + "属性类型: " + variableElement.asType().toString() + "\r\n");
//					}
//				}
//
//				Path path = Paths.get("E:/a.txt");
//				try (BufferedWriter writer = Files.newBufferedWriter(path)) {
//					writer.write(content.toString());
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return false;
//	}
//	
//	private void error(Element e, String msg, Object... args) {
//		messager.printMessage(Kind.ERROR, String.format(msg, args), e);
//	}
//
//}
