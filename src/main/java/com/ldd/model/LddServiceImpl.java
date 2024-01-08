package com.ldd.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("lddService")
public class LddServiceImpl implements LddService{
	
	@Autowired
	LddRepository repository;
	
	public void addLdd (Ldd ldd) {
		repository.save(ldd);
	}
	
	public void upDateLdd(Ldd ldd) {
		repository.save(ldd);
	}
	
	public Ldd getOneLddApp(Integer lddNo) {
		Optional<Ldd> optional = repository.findById(lddNo);
		return optional.orElse(null);
	}
	
	public List<Ldd> getAll() {
		return repository.findAll();
	}
}
