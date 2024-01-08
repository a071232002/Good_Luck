package com.lddapp.model;

import java.util.List;

public interface LddAppService {

	public void addLddApp(LddApp lddApp);

	public void upDateLddApp(LddApp lddApp);

	public LddApp getOneLddApp(Integer lddAppNo);

	public List<LddApp> getAll();

}
