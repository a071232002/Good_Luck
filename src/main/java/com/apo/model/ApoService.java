package com.apo.model;

import java.util.List;

import com.ldd.model.Ldd;
import com.rent.model.Rent;

public interface ApoService {

	public void addApo(Apo apo);

	public void upDateApo(Apo apo);

	public List<Apo> getListByLdd(Integer lddNo);

	public Apo getOneApo(Integer apoNo);

	public List<Apo> getAll();

}
