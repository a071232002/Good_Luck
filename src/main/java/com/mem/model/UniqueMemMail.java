package com.mem.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//自定義會員信箱是否已存在
@Constraint(validatedBy = UniqueMemMailValidator.class)
@Target(ElementType.FIELD) //可設置在屬性上
@Retention(RetentionPolicy.RUNTIME) 
public @interface UniqueMemMail {
	String message() default "信箱已被使用！";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
