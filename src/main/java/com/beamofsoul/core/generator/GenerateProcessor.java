package com.beamofsoul.core.generator;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes({"com.beamofsoul.core.generator.Generate"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenerateProcessor extends AbstractProcessor {
	
	private Messager messager;
	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		messager = processingEnv.getMessager();
	}
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement currentAnnotation : annotations) {
			if (currentAnnotation.getQualifiedName().toString().equals(Generate.class.getName())) {
				// 存放被注解标注类的容器
				GenerateAnnotatedContainer container = null;
				for (Element elementAnnotated : roundEnv.getElementsAnnotatedWith(Generate.class)) {
					// 注解必须标注在类上
					if (elementAnnotated.getKind() != ElementKind.CLASS) {
						error(elementAnnotated, "Only classes can be annotated with @%s", Generate.class.getSimpleName());
						return true;
					}
					TypeElement typeElementAnnotated = (TypeElement) elementAnnotated;
					try {
						GenerateAnnotatedElement annotatedElement = new GenerateAnnotatedElement(typeElementAnnotated);
						// 被标注的类必须是以public作为标识，且不能是抽象类
						if (!isValidClass(annotatedElement)) {
							return true;
						}
						// 将封装好的被注解的类信息放入到容器中
						if (annotatedElement.isAvailable()) {
							if (container == null) {
								container = new GenerateAnnotatedContainer(annotatedElement);
							} else {
								container.add(annotatedElement);
							}
						}
					} catch (IllegalArgumentException  e) {
						error(typeElementAnnotated, e.getMessage());
						return true;
					}
				}
				
				// 通过容器生成Java源文件
				try {
					container.generateCode();
				} catch (IOException e) {
					error(null, e.getMessage());
				}
			}
		}
		return false;
	}
	
	private boolean isValidClass(GenerateAnnotatedElement annotatedClass) {
		TypeElement classElement = annotatedClass.getTypeElement();
		if (!classElement.getModifiers().contains(Modifier.PUBLIC)) {
			error(classElement, "The class %s is not public.", classElement.getQualifiedName().toString());
			return false;
		}
		if (classElement.getModifiers().contains(Modifier.ABSTRACT)) {
			error(classElement, "The class %s is abstract. You can't annotate abstract classes with @%", classElement.getQualifiedName().toString(), Generate.class.getSimpleName());
			return false;
		}
		return true;
	}

	private void error(Element e, String msg, Object... args) {
		messager.printMessage(Kind.ERROR, String.format(msg, args), e);
	}

}
