package com.report.model;

import java.util.List;

import com.mem.model.Mem;



public interface ReportService {
	public void addReport(Report report); 

	public void updateReport(Report report); 

	public Report getOneReport(Integer reportNo);
	
	public List<Report> getAll();
	
	public List<Report> getAllByMem(Mem mem);

}
