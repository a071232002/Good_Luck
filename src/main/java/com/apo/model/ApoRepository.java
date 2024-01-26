package com.apo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ldd.model.Ldd;
import com.mem.model.Mem;

public interface ApoRepository extends JpaRepository<Apo, Integer>{
	
	@Transactional
	@Query("FROM Apo apo WHERE apo.rent.ldd.lddNo = :lddNo ORDER BY apo.apoCreate DESC")
	public List<Apo> findByLddNo(Integer lddNo);
	
	@Transactional
	public List<Apo> findByMemOrderByApoCreateDesc(Mem mem);
	
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
