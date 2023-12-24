package com.Rtn.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.Rtn.dao.RtnDAO;
import com.Rtn.dao.RtnDAOImpl;
import com.Rtn.model.Rtn;



// 搭配 JSP / Thymeleaf 後端渲染畫面，將交易動作至於 view filter
public class RtnServiceImpl implements RtnService {
	// 一個 service 實體對應一個 dao 實體
	private RtnDAO dao;
	
	public RtnServiceImpl() {
		dao = new RtnDAOImpl();
	}
	
	

	@Override
	public List<Rtn> getAllEmps(int currentPage) {
		return dao.getAll(currentPage);
	}

	@Override
	public List<Rtn> getEmpsByCompositeQuery(Map<String, String[]> map) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();
		
		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0]; // getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
			if (value == null || value.isEmpty()) {
				continue;
			}
			query.put(key, value);
		}
		
		System.out.println(query);
		
		return dao.getByCompositeQuery(query);
	}

	@Override
	public int getPageTotal() {
		long total = dao.getTotal();
		// 計算Emp數量每頁3筆的話總共有幾頁
		int pageQty = (int)(total % 5 == 0 ? (total / 5) : (total / 5 + 1));
		return pageQty;
	}



	@Override
	public Rtn addEmp(Rtn emp) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Rtn updateEmp(Rtn emp) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteEmp(Integer empno) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Rtn getEmpByEmpno(Integer empno) {
		// TODO Auto-generated method stub
		return null;
	}

}
