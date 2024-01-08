package com.mem.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueMemMailValidator implements ConstraintValidator<UniqueMemMail, String>{

	@Autowired
	private MemRepository memRepository;
	
	@Override
	public boolean isValid(String memMail, ConstraintValidatorContext context) {
		return !memRepository.existsByMemMail(memMail);
	}

}
