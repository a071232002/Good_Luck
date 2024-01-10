package com.apo.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.Ldd;
import com.rent.model.Rent;

@Service
public class ApoServiceImpl implements ApoService {

	@Autowired
	ApoRepository repository;

	@Override
	public void addApo(Apo apo) {
		repository.save(apo);
	}

	@Override
	public void upDateApo(Apo apo) {
		repository.save(apo);
	}

	@Override
	public Apo getOneApo(Integer apoNo) {
		Optional<Apo> optional = repository.findById(apoNo);
		return optional.orElse(null);
	}

	@Override
	public List<Apo> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Apo> getListByLdd(Integer lddNo) {
		return repository.findByLddNo(lddNo);
	}

}
