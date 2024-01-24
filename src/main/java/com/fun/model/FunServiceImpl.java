package com.fun.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunServiceImpl implements FunService{

	@Autowired
	private FunRepository funRepository;
	
	@Override
	public List<Fun> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fun findByFunNo(Integer funNo) {
		Optional<Fun> op = funRepository.findById(funNo);
		return op.orElse(null);
	}

}
