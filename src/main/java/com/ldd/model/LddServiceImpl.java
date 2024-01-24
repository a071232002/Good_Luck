package com.ldd.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mem.model.Mem;

@Service("lddService")
public class LddServiceImpl implements LddService {

	private static final Byte ACTIVATE = 0;
	private static final Byte FREEZE = 1;

	@Autowired
	LddRepository repository;

	@Override
	public void addLdd(Ldd ldd) {
		repository.save(ldd);
	}

	@Override
	public void upDateLdd(Ldd ldd) {
		repository.save(ldd);
	}

	@Override
	public void accountActivation(Ldd ldd) {
		ldd.setLddStatus(ACTIVATE);
		repository.save(ldd);
	}

	@Override
	public void accountFreeze(Ldd ldd) {
		ldd.setLddStatus(FREEZE);
		repository.save(ldd);
	}

	@Override
	public Ldd getOneByMem(Mem mem) {
		return repository.findByMem(mem);
	}

	@Override
	public Ldd getOneLdd(Integer lddNo) {
		Optional<Ldd> optional = repository.findById(lddNo);
		return optional.orElse(null);
	}

	@Override
	public List<Ldd> getAll() {
		return repository.findAll();
	}

}
