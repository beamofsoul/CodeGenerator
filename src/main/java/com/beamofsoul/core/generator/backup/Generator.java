package com.beamofsoul.core.generator.backup;
//package com.beamofsoul.core.generator;
//
//import java.util.EnumSet;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//import javax.lang.model.element.Modifier;
//
///**
// * @ClassName Generator
// * @Description 代码生成操作类
// * @author MingshuJian
// * @Date 2017年3月28日 下午3:23:55
// * @version 1.0.0
// */
//public class Generator {
//
//	private StringBuffer content = new StringBuffer();
//	public static final String PACKAGE = "package";
//	public static final String IMPORT = "import";
//	public static final String BLANK = " ";
//	public static final String NEXT_LINE = "\r\n";
//	public static final String EMPTY_LINE = "\r\n\r\n";
//	public static final String TAB = "	";
//	public static final String LEFT_BRACE = "{";
//	public static final String RIGHT_BRACE = "}";
//	public static final String LEFT_PARENTHESES = "(";
//	public static final String RIGHT_PARENTHESES = ")";
//	public static final String SEMICOLON = ";";
//	public static final String COMMA = ",";
//	
//	private static final String IMPORT_AREA = "#### IMPORTS ####";
//	
//	private Type currentType;
//	
//	private Set<String> imports = new LinkedHashSet<>();
//	
//	public static Generator builder() {
//		return new Generator();
//	}
//	
//	public Generator emitPackage(String packageContent) {
//		this.content.append(PACKAGE).append(BLANK).append(packageContent).append(SEMICOLON).append(NEXT_LINE);
//		this.content.append(NEXT_LINE).append(IMPORT_AREA);
//		return this;
//	}
//	
//	public Generator emitEmptyLine() {
//		this.content.append(NEXT_LINE);
//		return this;
//	}
//	
//	public Generator beginType(String className, Type classType, Modifier... modifiers) {
//		this.currentType = classType;
//		
//		for (Modifier modifier : modifiers) {
//			this.content.append(modifier.toString()).append(BLANK);
//		}
//		this.content.append(classType).append(BLANK).append(className).append(BLANK).append(LEFT_BRACE).append(EMPTY_LINE);
//		return this;
//	}
//	
//	public Generator endType() {
//		this.content.append(RIGHT_BRACE);
//		return this;
//	}
//	
//	public Generator beginMethod(EnumSet<Modifier> modifiers, String returnType, String methodName, String... args) {
//		this.content.append(TAB);
//		if (modifiers != null) {
//			for (Modifier modifier : modifiers) {
//				this.content.append(modifier).append(BLANK);
//			}
//		}
//		this.content.append(returnType).append(BLANK).append(methodName).append(LEFT_PARENTHESES);
//		for (int i = 0; i < args.length; i++) {
//			this.content.append(args[i]);
//			if (i + 1 < args.length) 
//				this.content.append(COMMA);
//		}
//		
//		this.content.append(RIGHT_PARENTHESES);
//		if (currentType.equals(Type.INTERFACE)) {
//			this.content.append(SEMICOLON);
//		} else {
//			this.content.append(BLANK).append(LEFT_BRACE);
//		}
//		return this;
//	}
//	
//	public Generator endMethod() {
//		if (currentType.equals(Type.INTERFACE)) {
//			this.content.append(NEXT_LINE);
//		} else {
//			this.content.append(RIGHT_BRACE).append(NEXT_LINE);
//		}
//		return this;
//	}
//	
//	public void importClass(String... classPath) {
//		for (String path : classPath) {
//			imports.add(IMPORT + BLANK + path + SEMICOLON);
//		}
//	}
//
//	public String build() {
//		StringBuffer importsStr = new StringBuffer();
//		for (String importStr : imports) {
//			importsStr.append(importStr).append(NEXT_LINE);
//		}
//		return content.toString().replaceAll(IMPORT_AREA, importsStr.toString());
//	}
//	
//	public static enum Type {
//		CLASS,INTERFACE;
//		public String toString() {
//	        return name().toLowerCase(java.util.Locale.US);
//	    }
//	}
//
//}
