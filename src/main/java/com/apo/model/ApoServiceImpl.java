package com.apo.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mem.model.Mem;

@Service
public class ApoServiceImpl implements ApoService {
	
	private static final Byte WAIT_LDD_CONFIRM = 0;
	private static final Byte lDD_REJECT = 1;
	private static final Byte WAIT_APO_COMPLETE = 2;
	private static final Byte FINISH = 3;
	private static final Byte CANCEL = 4;
	
	
	@Autowired
	ApoRepository repository;

	@Override
	public void addApo(Apo apo) {
		apo.setApoCreate(Date.valueOf(LocalDate.now()));
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
	public List<Apo> getApoByMem(Mem mem) {
		return repository.findByMem(mem);
	}
	
	@Override
	public List<Apo> getListByLdd(Integer lddNo) {
		return repository.findByLddNo(lddNo);
	}
	
	@Override
	public List<ApoDTO> getListByRentNoWithBooking(Integer rentNo) {
		List<Byte> apoStatusList = Arrays.asList(WAIT_APO_COMPLETE, FINISH);
		List<Apo> apoList = repository.findByRentNoAndApoStatusIn(rentNo, apoStatusList);
		List<ApoDTO> list = apoList.stream().map(apo -> new ApoDTO(
	                    apo.getApoNo(),
	                    apo.getApoDate(),
	                    apo.getApoTime()))
						.collect(Collectors.toList());
		
		return list;
		
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
