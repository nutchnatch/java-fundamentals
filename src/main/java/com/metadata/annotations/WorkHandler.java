package com.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // with this conf, WorkHandler is available to reflection
@Target(ElementType.TYPE)
public @interface WorkHandler {

//    boolean useThreadPool();
//    boolean useThreadPool() default true;  // this annotation will assign this attribute to true, by default
    boolean value() default true; // Must exists one element only - will assign the default value, and it is not needed to put the variable name when configuring the annotation
}
