package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.notice.model.Notice;
import com.notice.model.NoticeRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com")
public class TestApplication implements CommandLineRunner{
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Notice> noticeDatas = noticeRepository.findAll();
		
		for(Notice data : noticeDatas) {
			System.out.println(data);
		}
	}

}
