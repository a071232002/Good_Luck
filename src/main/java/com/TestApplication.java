package com;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emp.model.Emp;
import com.notice.model.NoticeRepository;
import com.notice.model.NoticeVO;

@SpringBootApplication
public class TestApplication implements CommandLineRunner{
	
	@Autowired
	private NoticeRepository noticeRepository;
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class);
	}
	
	@Override
	public void run(String...args) throws Exception {

		Emp emp = new Emp();                                  //員工
		emp.setEmpNo(1);
		
		List<NoticeVO> noticeDatas = noticeRepository.findAll();
		for(NoticeVO data : noticeDatas) {
			System.out.println(data);
		}
		
//		   ● 新增
//				NoticeVO noticeVO1 = new NoticeVO();
//				noticeVO1.setEmpNo(3);
//				noticeVO1.setNoticeTime(Timestamp.valueOf(LocalDateTime.now()));
//				noticeVO1.setNoticecontent("3");
//				noticeVO1.setNoticeStatus((byte)3);
//				noticeRepository.save(noticeVO1);

				//● 修改
			 NoticeVO noticeVO1 = new NoticeVO();
			 noticeVO1.setNoticeNo(1);
			 noticeVO1.setEmpNo(3);
			 noticeVO1.setNoticeTime(Timestamp.valueOf(LocalDateTime.now()));
			 noticeVO1.setNoticecontent("3");
			 noticeVO1.setNoticeStatus((byte)3);
			 noticeRepository.save(noticeVO1);
				
		    	//● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//		    	Optional<NoticeVO> optional = repository.findById(7001);
//				NoticeVO noticeVO3 = optional.get();
//				System.out.print(noticeVO3.getNoticeNo() + ",");
//				System.out.print(noticeVO3.getEmpNo() + ",");
//				System.out.print(noticeVO3.getNoticeTime() + ",");
//				System.out.print(noticeVO3.getNoticecontent() + ",");
//				System.out.print(noticeVO3.getNoticeStatus() + ",");
		
//				// 注意以下三行的寫法 (優!)
//				System.out.print(noticeVO3.getNoticeVO().getNoticeno() + ",");
//				System.out.print(noticeVO3.getNoticeVO().getEmpno() + ",");
//				System.out.print(noticeVO3.getNoticeVO().getNoticeTime());
//				System.out.print(noticeVO3.getNoticeVO().getNoticeContent());
//				System.out.print(noticeVO3.getNoticeVO().getNoticeStatus());
//				System.out.println("\n---------------------");
   
	}
	
	
	

}
