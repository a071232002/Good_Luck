package com.lse.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apo.model.Apo;
import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rent.model.Rent;


@Service
public class LseServiceImpl implements LseService{
	
	private static final Byte IN_CONTRACT = 5;
	
	@Autowired
	LseRepository repository; 
	
	@Override
	public void addLse(Lse lse) {
		lse.setLseCreate(Date.valueOf(LocalDate.now()));
		repository.save(lse);
	}

	@Override
	public void updateLse(Lse lse) {
		repository.save(lse);
	}
	
	@Override
	public Lse getOneByLseNo(Integer lseNo) {
		Optional<Lse> optional = repository.findById(lseNo);
		return optional.orElse(null);
	}
	
	//for 物件管理找到最新的合約
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
	public List<Lse> getListInContract() {
		return repository.findByLseStatus(IN_CONTRACT);
	}

	
}
