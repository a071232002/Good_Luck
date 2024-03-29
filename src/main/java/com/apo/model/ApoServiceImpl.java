package com.apo.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rent.model.Rent;


@Service
public class ApoServiceImpl implements ApoService {
	//for apoStatus
	private static final Byte WAIT_LDD_CONFIRM = 0;
	private static final Byte REJECT = 1;
	private static final Byte APPROVE_AND_WAIT_COMPLETE = 2;
	private static final Byte COMPLETE = 3;
	private static final Byte CANCEL = 4;
	
	//for apoWant
	private static final Byte WANT_WAIT_MEMBER_CONFIRM = 0;
	private static final Byte WANT_REJECT = 1;
	private static final Byte WANT_WAIT_LDD_CONFIRM = 2;
	private static final Byte WANT_DATE_CHANGE_WAIT_RECONFIRM = 3;
	private static final Byte WANT_AGREE = 4;
	private static final Byte WANT_CANCEL = 5;

	
	@Autowired
	ApoRepository repository;
	
	@Override
	public Apo addApo(Apo apo) {
		apo.setApoCreate(Date.valueOf(LocalDate.now()));
		return repository.save(apo);
	}

	@Override
	public void upDateApo(Apo apo) {
		apo.setApoStatus(WAIT_LDD_CONFIRM);
		repository.save(apo);
	}
	
	@Override
	public void cancelApo(Apo apo) {
		apo.setApoStatus(CANCEL);
		repository.save(apo);
	}

	@Override
	public void rejectApo(Apo apo) {
		apo.setApoStatus(REJECT);
		repository.save(apo);
	}

	@Override
	public void approveApo(Apo apo) {
		apo.setApoStatus(APPROVE_AND_WAIT_COMPLETE);
		repository.save(apo);
	}

	@Override
	public void completeApo(Apo apo) {
		apo.setApoStatus(COMPLETE);
		repository.save(apo);
	}
	
	@Override
	public void want(Apo apo) {
		apo.setApoWant(WANT_WAIT_LDD_CONFIRM);
		repository.save(apo);
	}
	
	@Override
	public void updateWantDate(Apo apo) {
		apo.setApoWant(WANT_WAIT_LDD_CONFIRM);
		repository.save(apo);
	}
	
	@Override
	public void cancelWant(Apo apo) {
		apo.setApoWant(WANT_CANCEL);
		apo.setApoWantDate(null);
		repository.save(apo);
	}
	
	@Override
	public void rejectWant(Apo apo) {
		apo.setApoWant(WANT_REJECT);
		apo.setApoWantDate(null);
		repository.save(apo);
	}
	
	@Override
	public void approveWant(Integer apoNo) {
		Optional<Apo> optional = repository.findById(apoNo);
		Apo apo = optional.get();
		apo.setApoWant(WANT_AGREE);
		repository.save(apo);
	}
	
	@Override
	public void rejectOtherApoByRent(Rent rent) {
		List<Apo> list1 = repository.findByRent(rent);
        List<Apo> apoStatusList = list1.stream()
        							  .filter(apo -> (apo.getApoStatus() == 0 || apo.getApoStatus() == 2))
        							  .collect(Collectors.toList());
        
        for(Apo aApo : apoStatusList) {
        	aApo.setApoStatus(REJECT);
        	repository.save(aApo);
        }
        
        List<Apo> list2 = repository.findByRent(rent);
        List<Apo> apoWantList = list2.stream()
        		  					.filter(apo -> (apo.getApoStatus() == 3) &&(apo.getApoWant() == 0 || apo.getApoWant() == 2))
        		  					.collect(Collectors.toList());
        
        for(Apo aApo : apoWantList) {
        	aApo.setApoWant(WANT_REJECT);
        	repository.save(aApo);
        }
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
	public List<Apo> getApoListByMem(Mem mem) {
		return repository.findByMemOrderByApoCreateDesc(mem);
	}
	
	@Override
	public List<Apo> getApoListByLdd(Integer lddNo) {
		return repository.findByLddNo(lddNo);
	}
	
	@Override
	public List<Apo> getApoListByLdd(Ldd ldd) {
		
		return repository.findByLdd(ldd);
	}
	

	
	@Override
	public List<ApoDTO> getListWithBookingByLdd(Ldd ldd) {
		List<ApoDTO> list = null;
		
			List<Byte> apoStatusList = Arrays.asList(WAIT_LDD_CONFIRM, APPROVE_AND_WAIT_COMPLETE);
			List<Apo> apoList = repository.findByLddAndApoStatusIn(ldd, apoStatusList);
			list = apoList.stream().map(aApo -> new ApoDTO(
										aApo.getApoNo(),
										aApo.getApoDate(),
										aApo.getApoTime()))
											.collect(Collectors.toList());
			

		return list;
	}
	
	@Override
	public List<ApoDTO> getListWithApproveByLdd(Ldd ldd) {
		List<ApoDTO> list = null;

			List<Byte> apoStatusList = Arrays.asList(APPROVE_AND_WAIT_COMPLETE, COMPLETE);
			List<Apo> apoList = repository.findByLddAndApoStatusIn(ldd, apoStatusList);
			list = apoList.stream().map(aApo -> new ApoDTO(
										aApo.getApoNo(),
										aApo.getRent().getRentNo(),
										aApo.getRent().getRentAppCou() + " " + 
										aApo.getRent().getRentAppAr() + " " + 
										aApo.getRent().getRentAppRo() + " " + 
										aApo.getRent().getRentAppAdd(),
										aApo.getMem().getMemName(),
										aApo.getMem().getMemPhone(),
										aApo.getApoDate(),
										aApo.getApoTime(),
										aApo.getApoStatus()))
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

	@Override
	public Boolean isExist(Ldd ldd, Date apoDate, Byte apoTime) {
		Boolean test = false;
		List<Apo>  apoList = repository.findByLddAndApoDateAndApoTime(ldd, apoDate, apoTime);
		System.out.println(apoList);
		if (apoList.isEmpty()) {
			return test;
		} else {
			List<Apo>  list = apoList.stream()
									 .filter(apo -> apo.getApoStatus() == 0 || apo.getApoStatus() == 2)
									 .collect(Collectors.toList());		 
			if (!list.isEmpty()) {
				test = true;
			}
		}
		return test;
	}

	

}
