package com.apo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rent.model.Rent;

public interface ApoRepository extends JpaRepository<Apo, Integer>{
	
	@Transactional
	@Query("FROM Apo apo WHERE apo.rent.ldd.lddNo = :lddNo ORDER BY apo.apoCreate DESC")
	public List<Apo> findByLddNo(Integer lddNo);
	
	@Transactional
	@Query("FROM Apo apo WHERE apo.rent.ldd = :ldd ORDER BY apo.apoCreate DESC")
	public List<Apo> findByLdd(Ldd ldd);
	
	@Transactional
	public List<Apo> findByMemOrderByApoCreateDesc(Mem mem);
	
	@Transactional
	public List<Apo> findByRentAndApoStatusInOrApoWantIn(Rent rent,  List<Byte> apoStatusList,  List<Byte> apoWantList);
	
	@Transactional
	public List<Apo> findByRent(Rent rent);
	
	@Transactional
	@Query("FROM Apo apo WHERE apo.rent.rentNo = :rentNo AND apo.apoStatus IN :apoStatusList")
	public List<Apo> findByRentNoAndApoStatusIn(Integer rentNo, List<Byte> apoStatusList);
	
	@Transactional
	@Query("FROM Apo apo WHERE apo.rent.ldd = :ldd AND apo.apoStatus IN :apoStatusList")
	public List<Apo> findByLddAndApoStatusIn(Ldd ldd, List<Byte> apoStatusList);
	
	@Transactional
	public List<Apo> findByApoStatusIn(List<Byte> apoStatusList);
	
	@Transactional
	public List<Apo> findByMemAndApoStatusIn(Mem mem, List<Byte> apoStatusList);
	
}
