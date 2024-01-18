package com.report.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mem.model.Mem;

@Service("reportService")
public class ReportServiceImpl implements ReportService{
	@Autowired
	ReportRepository repository;

	@Override
	public void addReport(Report report) {
		report.setReportDate(Date.valueOf(LocalDate.now()));
		repository.save(report);
		
	}

	@Override
	public void updateReport(Report report) {
		repository.save(report);
		
	}

	@Override
	public Report getOneReport(Integer reportNo) {
		Optional<Report> optional = repository.findById(reportNo);
		return optional.orElse(null);
	}

	@Override
	public List<Report> getAll() {

		return repository.findAll();
	}
	@Override
	public List<Report> getAllByMem(Mem mem) {
		return repository.findByMem(mem);

	}
	
	


}
