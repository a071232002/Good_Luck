package com.lse.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rent.model.Rent;


@Service
public class LseServiceImpl implements LseService{
	
	@Autowired
	LseRepository repository; 
	
	@Override
	public void addLse(Lse lse) {
		lse.setLseCreate(Date.valueOf(LocalDate.now()));
		repository.save(lse);
	}

	@Override
	public void updateLse(Lse lse) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public Lse getNewOneByRent(Rent rent) {
		return repository.findFirstByRentOrderByLseCreateDesc(rent);
	}

	@Override
	public List<Lse> getListByMem(Mem mem) {
		return repository.findByMem(mem);
	}

	@Override
	public List<Lse> getListByLdd(Ldd ldd) {
		return repository.findByLdd(ldd) ;
	}

	@Override
	public List<Lse> getListByRent(Rent rent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
