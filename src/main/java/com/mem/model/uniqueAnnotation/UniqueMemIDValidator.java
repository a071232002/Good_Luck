package com.mem.model.uniqueAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mem.model.MemRepository;

public class UniqueMemIDValidator implements ConstraintValidator<UniqueMemID, String>{

	@Autowired
	private MemRepository memRepository;
	
	@Override
	public boolean isValid(String memID, ConstraintValidatorContext context) {
		return !memRepository.existsByMemID(memID);
	}

}
