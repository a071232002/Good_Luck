package com.ldd.model;

import java.util.List;

import com.mem.model.Mem;

public interface LddService {

	public void addLdd(Ldd ldd);

	public void upDateLdd(Ldd ldd);

	public void accountActivation(Ldd ldd);

	public void accountFreeze(Ldd ldd);

	public Ldd getOneLdd(Integer lddNo);

	public Ldd getOneByMem(Mem mem);

	public List<Ldd> getAll();

}
