package com.mem.model.uniqueAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mem.model.MemRepository;

public class UniqueMemMailValidator implements ConstraintValidator<UniqueMemMail, String>{

	@Autowired
	private MemRepository memRepository;
	
	@Override
	public boolean isValid(String memMail, ConstraintValidatorContext context) {
		return !memRepository.existsByMemMail(memMail);
	}

}
