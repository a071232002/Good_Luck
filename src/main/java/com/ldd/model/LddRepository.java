package com.ldd.model;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mem.model.Mem;

public interface LddRepository extends JpaRepository<Ldd, Integer> {

	@Transactional
	public Ldd findByMem(Mem mem);
}
