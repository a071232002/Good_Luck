package com.rentapp.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lddapp.model.LddAppRepository;

@Service("rentAppService")
public class RentAppServiceImpl implements RentAppService{
	@Autowired
	RentAppRepository repository;

	public void addRentApp(RentApp rentApp) {
		repository.save(rentApp);
	}

	public void updateRentApp(RentApp rentApp) {
		repository.save(rentApp);
	}


	public RentApp getOneRentApp(Integer rentAppNo) {
		Optional<RentApp> optional = repository.findById(rentAppNo);
		return optional.orElse(null);
	}

	public List<RentApp> getAll() {
		return repository.findAll();
	}

//	public List<RentApp> getAll(Map<String, String[]> map) {
//		return HibernateUtil_CompositeQuery_RentApp.getAllC(map,sessionFactory.openSession());
//	}

}
