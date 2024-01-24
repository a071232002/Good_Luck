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

//自定義會員手機號碼是否已存在
@Constraint(validatedBy = UniqueMemPhone.UniqueMemPhoneValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMemPhone {
	String message() default "手機號碼已存在";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	class UniqueMemPhoneValidator implements ConstraintValidator<UniqueMemPhone, String>{

		@Autowired
		private MemRepository memRepository;
		
		@Override
		public boolean isValid(String memPhone, ConstraintValidatorContext context) {
			return !memRepository.existsByMemPhone(memPhone);
		}

	}
}
