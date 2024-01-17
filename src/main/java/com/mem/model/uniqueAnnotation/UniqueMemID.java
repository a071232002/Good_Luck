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

//自定義會員身分證是否已存在
@Constraint(validatedBy = UniqueMemID.UniqueMemIDValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMemID {
	
	String message() default "會員身分證號碼已存在";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	class UniqueMemIDValidator implements ConstraintValidator<UniqueMemID, String>{

		@Autowired
		private MemRepository memRepository;
		
		@Override
		public boolean isValid(String memID, ConstraintValidatorContext context) {
			return !memRepository.existsByMemID(memID);
		}

	}
}
