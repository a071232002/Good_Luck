package com.lddapp.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.LddRepository;

@Service("lddAppService")
public class LddAppService {

	@Autowired
	LddAppRepository lddAppRepository;

	@Autowired
	private SessionFactory sessionFactory;

	public void addLddApp(LddApp lddApp) {
		lddAppRepository.save(lddApp);
	}

	public void upDateLddApp(LddApp lddApp) {
		lddAppRepository.save(lddApp);
	}

	public LddApp getOneLddApp(Integer lddAppNo) {
		Optional<LddApp> optional = lddAppRepository.findById(lddAppNo);
		return optional.orElse(null);
	}

	public List<LddApp> getAll() {
		return lddAppRepository.findAll();
	}

}
