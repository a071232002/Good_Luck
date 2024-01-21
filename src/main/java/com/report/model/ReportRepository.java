package com.report.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mem.model.Mem;


public interface ReportRepository extends JpaRepository<Report, Integer>{
	
	public List<Report> findByMem(Mem mem);

}
