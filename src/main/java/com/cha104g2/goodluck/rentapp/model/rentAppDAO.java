package com.cha104g2.goodluck.rentapp.model;

import java.util.List;

public interface rentAppDAO {

	public void insert(rentApp rent);
	public void update(rentApp rent);
	public void delete(Integer rentno);
	public rentApp findByPrimaryKey(Integer rentno);
	public List<rentApp> getAll();
	//�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
	//public List<EmpVO> getAll(Map<String, String[]> map); 
}
