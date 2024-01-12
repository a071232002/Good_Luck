package com.mem.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemServiceImpl implements MemService {

	@Autowired
	private MemRepository memRepository;

	// 註冊會員
	@Override
	public Mem register(Mem mem) {
		
		String getMD5 = hashPassword(mem.getMemPsw()); //密碼進行加密
		mem.setMemPsw(getMD5);
		mem.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now()));
		mem.setMemReg(Date.valueOf(LocalDate.now()));
		mem.setMemStatus(Byte.valueOf("0")); //0為信箱未驗證狀態
		Mem newData = memRepository.save(mem);
		return newData;
	}

	// 會員登入
	@Override
	public Mem login(String memMail, String memPsw) {
		
		Mem getMem = memRepository.findByMemMail(memMail);
		
		getMem = (hashPassword(memPsw).equals(getMem.getMemPsw())) ? getMem : null; //核對密碼
		return getMem;
	}

	// 編輯會員
	@Override
	public Mem edit(Mem newData) {
		System.out.println("get memNo" + newData.getMemNo());
		String getMD5 = hashPassword(newData.getMemPsw()); //密碼進行加密
		newData.setMemPsw(getMD5);
		newData.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now())); // 更新最後登入時間
		return memRepository.save(newData);
	}

	// 會員編號查詢
	@Override
	public Mem findByNo(Integer memNo) {
		return memRepository.findById(memNo).orElse(null);
	}

	// 查詢全部會員
	@Override
	public List<Mem> findAll() {
		return memRepository.findAll();
	}

	// 信箱驗證
	@Override
	public boolean verifyMail(String mail) {
		String verifyID = genAuthCode();
//		Jedis jedis = new Jedis("localhost", 6379);
		try {
			// 設定使用SSL連線至 Gmail smtp Server
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			final String myGmail = "we23rt45600@gmail.com";
			final String myGmail_password = "nizxuqukthtrxbxb";
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myGmail, myGmail_password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myGmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));

			// 設定信中的主旨
			message.setSubject("租你好運感謝您的註冊！");
			// 設定信中的內容
			message.setText("驗證碼為：" + verifyID);

			Transport.send(message);
			System.out.println("傳送成功!");
			return true;
		} catch (MessagingException e) {
			System.out.println("傳送失敗!");
			e.printStackTrace();
		}
		return false;
	}

	// 密碼加密
	//參考網站https://jax-work-archive.blogspot.com/2015/02/java.html
	@Override
	public String hashPassword(String memPsw) {
		
		memPsw = "Good " + memPsw + " Luck"; //簡易密碼加鹽

		// 根據 MD5 演算法生成 MessageDigest 物件
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		byte[] srcBytes = memPsw.getBytes();
		// 使用 srcBytes 更新摘要
		md5.update(srcBytes);
		// 完成哈希計算，得到 result
		byte[] resultBytes = md5.digest();
		return new String(resultBytes);
	}

	// 忘記密碼
	@Override
	public String forgetPsw(String memMail) {
		// 發送隨機密碼簡訊
		return null;
	}

	// 停權會員
	@Override
	public void banMem(Integer memNo) {
		
		//先判斷員工的權限
		
		Mem data = memRepository.findById(memNo).orElse(null);
		// 其他停權動作
		data.setMemStatus(Byte.valueOf("2")); // 2為停權狀態
		edit(data);
	}
	
	//取得隨機亂數
	private String genAuthCode() {
		// A~Z   unicode 65~90
		// a~z   unicode 97~122
		String randomStr = "";
		for(int i = 1; i <= 8; i++) {
			int getChose = (int)(Math.random()*3);
			switch (getChose) {
				case 0:
					int getNumber = getRandom(0, 9);
					randomStr += String.valueOf(getNumber);
					break;
				case 1:
					char getEnUp = (char)getRandom(65, 90);
					randomStr += String.valueOf(getEnUp);
					break;
				case 2:
					char getEnDown = (char)getRandom(97, 122);
					randomStr += String.valueOf(getEnDown);
					break;
			}
		}
		return randomStr;
	}
	
	private int getRandom(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}

}
