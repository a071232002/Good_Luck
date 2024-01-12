package com.apo.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mem.model.Mem;

@Service
public class ApoServiceImpl implements ApoService {

	@Autowired
	ApoRepository repository;

	@Override
	public void addApo(Apo apo) {
		apo.setApoCreate(Timestamp.valueOf(LocalDateTime.now()));
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

	@Override
	public List<Apo> getApoByMem(Mem mem) {
		return repository.findByMem(mem);
	}

	@Override
	public List<Apo> getApoByApoStatus(List<Byte> apoStatusList) {
		return repository.findByApoStatusIn(apoStatusList);
	}

	@Override
	public List<Apo> getApoByMemAndApoStatus(Mem mem, List<Byte> apoStatusList) {
		return repository.findByMemAndApoStatusIn(mem, apoStatusList);
	}

}
