package com.rent.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldd.model.Ldd;

public interface RentRepository extends JpaRepository<Rent, Integer>{
	public List<Rent> findByLdd(Ldd ldd);

}
