package com.lse.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rent.model.Rent;

public interface LseRepository extends JpaRepository<Lse, Integer>{
	
	
	@Transactional
	public List<Lse> findByMem(Mem Mem);
	
	@Transactional
	public List<Lse> findByRentOrderByLseCreateDesc(Rent rent);
	
	//只找最新一筆
	@Transactional
	public Lse findFirstByRentOrderByLseCreateDesc(Rent rent);
	
	@Transactional
	@Query("FROM Lse lse WHERE lse.rent.ldd = :ldd")
	public List<Lse> findByLdd(Ldd ldd);
}
