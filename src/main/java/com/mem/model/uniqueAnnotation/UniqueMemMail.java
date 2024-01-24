package com.mem.model.uniqueAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;

import com.mem.model.MemRepository;

//自定義會員信箱是否已存在
@Constraint(validatedBy = UniqueMemMail.UniqueMemMailValidator.class)
@Target(ElementType.FIELD) //可設置在屬性上
@Retention(RetentionPolicy.RUNTIME) 
public @interface UniqueMemMail {
	String message() default "信箱已被使用！";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
	
	class UniqueMemMailValidator implements ConstraintValidator<UniqueMemMail, String>{

		@Autowired
		private MemRepository memRepository;
		
		@Override
		public boolean isValid(String memMail, ConstraintValidatorContext context) {
			return !memRepository.existsByMemMail(memMail);
		}

	}
}
