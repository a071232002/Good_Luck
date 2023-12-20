package com.product.model;

import java.util.*;

public interface ProDAO_interface {
          public void insert(ProVO proVO);
          public void update(ProVO proVO);
          public void delete(Integer proNo);
          public ProVO findByPrimaryKey(Integer proNo);
          public List<ProVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
