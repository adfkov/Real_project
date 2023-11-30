package com.example.demo.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // 이 어노테이션이 동작하는 타이밍( ex) 컴파일 전까지, 수행이 될 때)
public @interface TimeTrace {
	
}
