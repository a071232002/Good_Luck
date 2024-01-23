package com.rent.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.Ldd;

@Service("rentService")
public class RentServiceImpl implements RentService{
	@Autowired
	RentRepository repository;

	public void addRent(Rent rent) {
		repository.save(rent);
	}

	public void updateRent(Rent rent) {
		repository.save(rent);
	}


	public Rent getOneRent(Integer rentNo) {
		Optional<Rent> optional = repository.findById(rentNo);
		return optional.orElse(null);
	}

	public List<Rent> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Rent> getAllByLdd(Ldd ldd) {
		// TODO Auto-generated method stub
		return repository.findByLdd(ldd);
	}


}
