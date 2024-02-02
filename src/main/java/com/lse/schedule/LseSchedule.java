package com.lse.schedule;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lse.model.Lse;
import com.lse.model.LseService;

@Component
public class LseSchedule {

	@Autowired
	LseService lseSvc;
	

//	@Scheduled(cron = "0 0/1 * * * *") //每分鐘測試
	@Scheduled(cron = "0 0 0 * * *")
	public void updateLseStatus() {

		LocalDate date = LocalDate.now().plusDays(1);
		Date endDay = Date.valueOf(date);
		System.out.println("hi 我是排程器, 現在是00:00 開始執行");
		List<Lse> lseList = lseSvc.getListInContract();
		
		for (Lse alse : lseList) {
			System.out.println("執行foreach");
			if (alse.getLseEnd() != null && alse.getLseEnd().before(endDay)) {
//				alse.setLseStatus(Byte.valueOf("5"));
//				alse.setRenew(Byte.valueOf("1"));
//				lseSvc.updateLse(alse);
				System.out.println("合約編號:" + alse.getLseNo() + "到期囉!");
			}
		}
	}
}
