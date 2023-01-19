package com.hellow.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //method 위에만 가능
@Retention(RetentionPolicy.RUNTIME) //서버가 실행중일때
public @interface CheckAuth {
	
}
