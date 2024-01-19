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
	//for apoStatus
	private static final Byte WAIT_LDD_CONFIRM = 0;
	private static final Byte REJECT = 1;
	private static final Byte APPROVE_AND_WAIT_COMPLETE = 2;
	private static final Byte COMPLETE = 3;
	private static final Byte CANCEL = 4;
	
	//for apoWant
	private static final Byte WANT_WAIT_MEMBER_CONFIRM = 0;
	private static final Byte WANT_DISAGREE = 1;
	private static final Byte WANT_WAIT_LDD_CHECK = 2;
	private static final Byte WANT_DATE_CHANGE_WAIT_RECONFIRM = 3;
	private static final Byte WANT_AGREE = 4;
	
	
	@Autowired
	ApoRepository repository;

	@Override
	public void addApo(Apo apo) {
		apo.setApoCreate(Date.valueOf(LocalDate.now()));
		repository.save(apo);
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
	
	//for 前端ajax回傳 JPA查詢結果傳入ApoDto物件再回傳至UC 
	//回傳內容 apoStatus為 0:待房東審核 2:房東同意待會員看屋
	//考慮導入Redis需再改寫
	@Override
	public List<ApoDTO> getListWithBookingByRentNo(Integer rentNo) {
		List<Byte> apoStatusList = Arrays.asList(WAIT_LDD_CONFIRM, APPROVE_AND_WAIT_COMPLETE);
		List<Apo> apoList = repository.findByRentNoAndApoStatusIn(rentNo, apoStatusList);
		
		List<ApoDTO> list = apoList.stream().map(aApo -> new ApoDTO(
						aApo.getApoNo(),
						aApo.getApoDate(),
						aApo.getApoTime()))
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
