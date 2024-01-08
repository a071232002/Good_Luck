package com.mem.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueMemIDValidator implements ConstraintValidator<UniqueMemID, String>{

	@Autowired
	private MemRepository memRepository;
	
	@Override
	public boolean isValid(String memID, ConstraintValidatorContext context) {
		return !memRepository.existsByMemID(memID);
	}

}
