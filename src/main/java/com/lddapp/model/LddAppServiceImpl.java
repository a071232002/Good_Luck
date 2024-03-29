package com.lddapp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.Ldd;
import com.ldd.model.LddRepository;
import com.mem.model.Mem;

@Service("lddAppService")
public class LddAppServiceImpl implements LddAppService {

	private static final Byte PAYMENT = 1;
	private static final Byte REJECT = 1;
	private static final Byte PASS = 2;

	@Autowired
	LddAppRepository repository;
	
	@Autowired
	LddRepository lddRepository;

	@Override
	public void addLddApp(LddApp lddApp) {
		lddApp.setLddAppCreate(Date.valueOf(LocalDate.now()));
		repository.save(lddApp);
	}

	@Override
	public void upDateLddApp(LddApp lddApp) {
		if (lddApp.getLddAppStatus() == PASS) {
			Ldd ldd = new Ldd();
			ldd.setMem(lddApp.getMem());
			lddRepository.save(ldd);
		}
		repository.save(lddApp);
	}

	@Override
	public void pay(LddApp lddApp) {
		lddApp.setLddAppPayStatus(PAYMENT);
		repository.save(lddApp);
	}

	@Override
	public void reject(LddApp lddApp) {
		lddApp.setLddAppStatus(REJECT);
		repository.save(lddApp);
	}

	@Override
	public void approved(LddApp lddApp) {
		lddApp.setLddAppStatus(PASS);
		repository.save(lddApp);
	}
	
	@Override
	public LddApp getOneLddApp(Integer lddAppNo) {
		Optional<LddApp> optional = repository.findById(lddAppNo);
		return optional.orElse(null);
	}

	@Override
	public List<LddApp> getAllByMem(Mem mem) {
		return repository.findByMem(mem);
	}
	
	@Override
	public List<LddApp> getAll() {
		return repository.findAll();
	}



}
