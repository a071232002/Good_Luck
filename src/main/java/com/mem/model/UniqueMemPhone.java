package com.mem.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//自定義會員手機號碼是否已存在
@Constraint(validatedBy = UniqueMemPhoneValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMemPhone {
	String message() default "手機號碼已存在";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
