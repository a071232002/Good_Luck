package com.lddapp.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.LddRepository;

@Service("lddAppService")
public class LddAppServiceImpl implements LddAppService{

	@Autowired
	LddAppRepository repository;

	@Autowired
	private SessionFactory sessionFactory;

	public void addLddApp(LddApp lddApp) {
		repository.save(lddApp);
	}

	public void upDateLddApp(LddApp lddApp) {
		repository.save(lddApp);
	}

	public LddApp getOneLddApp(Integer lddAppNo) {
		Optional<LddApp> optional = repository.findById(lddAppNo);
		return optional.orElse(null);
	}

	public List<LddApp> getAll() {
		return repository.findAll();
	}

}
