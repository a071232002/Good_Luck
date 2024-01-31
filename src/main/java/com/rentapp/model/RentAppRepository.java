package com.rentapp.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldd.model.Ldd;



public interface RentAppRepository extends JpaRepository<RentApp, Integer>{
	public List<RentApp> findByLdd(Ldd ldd);

}
