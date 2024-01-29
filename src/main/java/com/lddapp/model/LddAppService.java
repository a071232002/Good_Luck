package com.lddapp.model;

import java.util.List;

import com.mem.model.Mem;

public interface LddAppService {

	public void addLddApp(LddApp lddApp);

	public void upDateLddApp(LddApp lddApp);

	public void pay(LddApp lddApp);

	public void notApproved(LddApp lddApp);

	public void approved(LddApp lddApp);

	public LddApp getOneLddApp(Integer lddAppNo);
	
	public List<LddApp> getAllByMem(Mem mem);
	
	public List<LddApp> getAll();

}
