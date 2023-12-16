package com.cha104g2.goodluck.lddapp.model;

import java.util.*;

public interface LddAppDAO {
	 public void insert(LddApp lddApp);
     public void update(LddApp lddApp);
     public LddApp findByPrimaryKey(Integer lddAppNo);
     public List<LddApp> getAll();
}
