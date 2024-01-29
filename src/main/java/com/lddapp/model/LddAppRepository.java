package com.lddapp.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mem.model.Mem;

public interface LddAppRepository extends JpaRepository<LddApp, Integer> {

	@Transactional
	public LddApp findByLddAppPayStatus(Byte LddAppPayStatus);

	@Transactional
	public LddApp findByLddAppStatus(Byte LddAppStatus);
	
	@Transactional
	public List<LddApp> findByMem(Mem mem);
	
}
