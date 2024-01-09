package com.apo.model;

import java.util.List;


public interface ApoService {

	public void addApo(Apo apo);

	public void upDateApo(Apo apo);

	public Apo getOneApo(Integer apoNo);

	public List<Apo> getAll();
	
}
