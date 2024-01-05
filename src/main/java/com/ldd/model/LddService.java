package com.ldd.model;

import java.util.List;

public interface LddService {
		
		public void addLdd (Ldd ldd) ;
		
		public void upDateLdd(Ldd ldd) ;
		
		public Ldd getOneLddApp(Integer lddNo);
		
		public List<Ldd> getAll();

}
