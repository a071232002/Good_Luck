package com.mem.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueMemPhoneValidator implements ConstraintValidator<UniqueMemPhone, String>{

	@Autowired
	private MemRepository memRepository;
	
	@Override
	public boolean isValid(String memPhone, ConstraintValidatorContext context) {
		return !memRepository.existsByMemPhone(memPhone);
	}

}
