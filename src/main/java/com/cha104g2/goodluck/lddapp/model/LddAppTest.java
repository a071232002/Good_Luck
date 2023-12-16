package com.cha104g2.goodluck.lddapp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class LddAppTest {

	public static void main(String[] args) {

		LddAppDAO dao = new LddAppDAOImpl();
		LddApp lddApp = new LddApp();

		for (int i = 1; i <= 100; i++) {
			lddApp.setMemNo((int) (Math.random() * 10) + 1);
			lddApp.setLddAppCreate(
					Date.valueOf(LocalDate.of(2023, (int) (Math.random() * 12) + 1, (int) (Math.random() * 28) + 1)));
			lddApp.setLddAppIDPic(null);

			dao.insert(lddApp);
		}

		List<LddApp> list = dao.getAll();

		for (int i = 1; i <= 100; i++) {
			lddApp = dao.findByPrimaryKey((int) (Math.random() * list.size()) + 1);
			
			lddApp.setEmpNo(1);
			lddApp.setLddAppPayStatus(1);
			lddApp.setLddAppStatus(1);

			dao.update(lddApp);
		}
		System.out.println(lddApp);
		System.out.println(
				"------------------------------------------------------------------------------------------------------");
		
		list = dao.getAll();
		for (LddApp aLddApp : list) {
			System.out.println(aLddApp);
		}
	}

}
