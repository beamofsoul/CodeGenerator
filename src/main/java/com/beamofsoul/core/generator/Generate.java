package com.beamofsoul.core.generator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Inherited
@Documented
public @interface Generate {

	boolean available() default true;
	boolean includeFrontend() default true;
	boolean includeBackend() default true;
	String output() default "d:/";
}