package com.fun.model;

import java.util.List;

public interface FunService {
	
	public List<Fun> getAll();
	
	public Fun findByFunNo(Integer funNo);
}
