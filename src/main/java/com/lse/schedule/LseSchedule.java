package com.lse.schedule;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lse.model.Lse;
import com.lse.model.LseService;
import com.rent.model.Rent;
import com.rent.model.RentService;
import com.ws.model.MsgWS;

@Component
public class LseSchedule {

	@Autowired
	LseService lseSvc;
	
	@Autowired
	RentService rentSvc;
	
    @PostConstruct
    public void initialize() {
    	executeUpdateLseStatus();
    }
	
	
//    @Scheduled(cron = "0 0 0 * * ?")
	@Scheduled(cron = "0 0/1 * * * *") //每分鐘測試
    public void scheduledUpdateLseStatus() {
        executeUpdateLseStatus();
    }

    private void executeUpdateLseStatus() {
        System.out.println("合約排程器 -> 檢視合約到期日");

        LocalDate date = LocalDate.now();
        Date endDay = Date.valueOf(date);

        List<Lse> lseList = lseSvc.getListInContract();

        for (Lse alse : lseList) {
            if (alse.getLseEnd() != null && endDay.after(alse.getLseEnd())) {
                alse.setLseStatus(Byte.valueOf("6"));
                alse.setLseRenew(Byte.valueOf("1"));
                lseSvc.updateLse(alse);

                Rent rent = alse.getRent();
                rent.setRentSt(Byte.valueOf("3"));
                rentSvc.updateRent(rent);
                MsgWS.sendMessageToBoth(alse, rent.getLdd().getMem().getMemNo());
                System.out.println("合約編號:" + alse.getLseNo() + "到期囉!");
            }
        }
    }
}
