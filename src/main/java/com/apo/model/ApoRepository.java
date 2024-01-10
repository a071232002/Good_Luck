package com.apo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApoRepository extends JpaRepository<Apo, Integer>{
	
	@Transactional
	@Query("SELECT apo FROM Apo apo WHERE apo.rent.ldd.lddNo = :lddNo")
	public List<Apo> findByLddNo(Integer lddNo);
	
}
