package com.lddapp.model;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LddAppRepository extends JpaRepository<LddApp, Integer> {

	@Transactional
	public LddApp findByLddAppPayStatus(Byte LddAppPayStatus);

	@Transactional
	public LddApp findByLddAppStatus(Byte LddAppStatus);
	
}
