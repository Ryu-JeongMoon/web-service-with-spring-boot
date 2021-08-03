package org.example.webservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}

/**
 * Target 은 annotation 이 위치할 수 있는 곳을 의미
 * Retention RUNTIME 은 컴파일 이후에도 참조할 수 있음을 의미
 */