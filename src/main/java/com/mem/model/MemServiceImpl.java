package com.mem.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service("service")
public class MemServiceImpl implements MemService {

	@Autowired
	private MemRepository memRepository;
	
	@Autowired
	private StringRedisTemplate redisTemplate;

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
		if(getMem == null) return getMem;
		getMem = (hashPassword(memPsw).equals(getMem.getMemPsw())) ? getMem : null; //核對密碼
		return getMem;
	}

	// 編輯會員
	@Override
	public Mem edit(Mem newData) {
//		System.out.println("get memNo" + newData.getMemNo());
//		String getMD5 = hashPassword(newData.getMemPsw()); //密碼進行加密
//		newData.setMemPsw(getMD5);
		newData.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now())); // 更新最後登入時間
		return memRepository.save(newData);
	}
	
	//變更會員大頭照
	public void changePic(Mem mem, byte[] memPic) {
		memRepository.updateMemPicById(mem.getMemNo(), memPic);
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
	public boolean verifyMail(String mail, String subject, String text, String verifyID) {
		verifyID = (verifyID == null) ? getAuthCode() : verifyID;
//		String verifyID = genAuthCode();
		try {
			// 設定使用SSL連線至 Gmail smtp Server
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			final String myGmail = "cha104G2GoodLuck@gmail.com";
			final String myGmail_password = "fmoolreuwsxrzdyz";
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myGmail, myGmail_password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myGmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));

			// 設定信中的主旨
			message.setSubject(subject);
			// 設定信中的內容
			message.setText(text + verifyID);

			Transport.send(message);
			System.out.println("傳送成功!");
			
			//設置驗證碼到redis(20秒)
			ValueOperations<String, String> vo = redisTemplate.opsForValue();
			vo.set("templateID" + mail, verifyID);
			redisTemplate.expire("templateID" + mail, 20, TimeUnit.SECONDS);
			System.out.println("yes");
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
	public boolean forgetPsw(String memMail) {
		
		if(memRepository.existsByMemMail(memMail)) {
			String authCode = getAuthCode();
			Mem mem = memRepository.findByMemMail(memMail);
			mem.setMemPsw(hashPassword(authCode));
			edit(mem);
			return verifyMail(memMail, "租你好運發送新密碼！", "你的新密碼為：", authCode);
		}
		// 發送隨機密碼簡訊
		return false;
	}

	// 停權會員
	@Override
	public void banMem(Integer memNo) {
		
		//先判斷員工的權限
		
		Mem data = memRepository.findById(memNo).orElse(null);
		// 其他停權動作
		memRepository.updateMemStatusById(memNo, Byte.valueOf("2"));
//		data.setMemStatus(Byte.valueOf("2")); // 2為停權狀態
//		edit(data);
	}
	
	//變更密碼
	@Override
	public Mem changePsw(Mem mem, String newMemPsw) {
		mem.setMemPsw(newMemPsw);
		return edit(mem);
	}
	
	@Override
	public boolean existMemPhone(String memPhone) {
		return memRepository.existsByMemPhone(memPhone);
	}
	
	@Override
	public boolean existMemID(String memID) {
		return memRepository.existsByMemID(memID);
	}
	
	
	//取得隨機亂數
	private String getAuthCode() {
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
	
	//redis測試
	@Override
	public String redisTest() {
		String redisText = getAuthCode();
		ValueOperations<String, String> vo = redisTemplate.opsForValue();
		vo.set("redisTest", redisText);
		redisTemplate.expire("redisTest", 20, TimeUnit.SECONDS);
		
		System.out.println("20秒前驗證碼 --> " + vo.get("redisTest"));
		try {
			Thread.sleep(20000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("20秒後驗證碼 --> " + vo.get("redisTest"));
		return vo.get("redisTest");
	}

}
