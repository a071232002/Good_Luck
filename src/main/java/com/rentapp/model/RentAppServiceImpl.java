package com.rentapp.model;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Emp;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ldd.model.Ldd;
import com.lddapp.model.LddAppRepository;
import com.rent.model.*;

@Service("rentAppService")
public class RentAppServiceImpl implements RentAppService{
	
	private static final String API_KEY = "AIzaSyBuQxy8IWpLXa4ixgreClBMfk_TuBFfJyI";
	@Autowired
	RentAppRepository rentAppRepository;
	
	@Autowired
	RentRepository rentRepository;

	public void addRentApp(RentApp rentApp) {
		rentAppRepository.save(rentApp);
	}

	public void updateRentApp(RentApp rentApp) {
		rentAppRepository.save(rentApp);
	}


	public RentApp getOneRentApp(Integer rentAppNo) {
		Optional<RentApp> optional = rentAppRepository.findById(rentAppNo);
		return optional.orElse(null);
	}

	public List<RentApp> getAll() {
		return rentAppRepository.findAll();
	}
	
	public RentApp updateRentAppSt(Integer rentAppNo, byte rentAppSt,Emp emp) {

		try {
			//拿rentAppNo找物件改rentAppSt
			RentApp rentApp=getOneRentApp(rentAppNo);
			rentApp.setRentAppSt(rentAppSt);
			rentApp.setEmp(emp);
			rentAppRepository.save(rentApp);//有可能資料錯誤無法寫入
//			System.out.println(rentApp);
			if(rentAppSt==1) {
				if(rentApp.getRent()!=null) {
					
					Rent rent=rentApp.getRent();
					rent.setRentSt((byte)0);
					rent.setLse(null);
					rentRepository.save(rent);
				}else {
					
					Rent rent =new Rent();
					rent.setRentAppCou(rentApp.getRentAppCou());
					rent.setRentAppAr(rentApp.getRentAppAr());
					rent.setRentAppRo(rentApp.getRentAppRo());
					rent.setRentAppAdd(rentApp.getRentAppAdd());
					rent.setRentAppOwn(rentApp.getRentAppOwn());
					rent.setRentAppFloor(rentApp.getRentAppFloor());
					rent.setRentAppSize(rentApp.getRentAppSize());
					rent.setLdd(rentApp.getLdd());
					rent.setRentUpTime(Timestamp.valueOf(LocalDateTime.now()));
					
					try {
						String[] LatAndLng=getLatAndLon(rentApp.getRentAppCou(),rentApp.getRentAppAr(),rentApp.getRentAppRo(),rentApp.getRentAppAdd());
						rent.setRentLat(LatAndLng[0]);
						rent.setRentLon(LatAndLng[1]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rentRepository.save(rent);
//				Rent newRent=rentRepository.save(rent);
//				rentApp.setRent(newRent);
//				rentAppRepository.save(rentApp);
				}
				
			}else {
				Rent rent=rentApp.getRent();
				rent.setRentSt((byte)3);
				rentRepository.save(rent);
			}

			return rentApp;
		} catch (Exception e) {
			System.out.println("Exception");
//			e.printStackTrace();

			return null;
		}
		
		
	}

//	public List<RentApp> getAll(Map<String, String[]> map) {
//		return HibernateUtil_CompositeQuery_RentApp.getAllC(map,sessionFactory.openSession());
//	}
	
	public String[] getLatAndLon(String rentAppCou, String rentAppAr, String rentAppRo, String rentAppAdd) throws Exception {
    	String[] LatAndLng = new String[2];
		String address=rentAppCou+rentAppAr+rentAppRo+rentAppAdd;

        String encodedAddress;
		
			encodedAddress = URLEncoder.encode(address, "UTF-8");
			
			String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedAddress + "&key=" + API_KEY;
			
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
			
			JsonArray results = jsonObject.getAsJsonArray("results");
			if (results.size() > 0) {
				JsonObject location = results.get(0).getAsJsonObject().getAsJsonObject("geometry").getAsJsonObject("location");
				
				String latitude = location.getAsJsonPrimitive("lat").getAsString();
				String longitude = location.getAsJsonPrimitive("lng").getAsString();
				LatAndLng[0]=latitude;
				LatAndLng[1]=longitude;
				
				System.out.println("緯度：" + latitude);
				System.out.println("經度：" + longitude);
			} else {
				System.out.println("找不到該地址的經緯度資訊。");
			}
			
			reader.close();
			conn.disconnect();
			return LatAndLng;
    }

	@Override
	public List<RentApp> getAllByLdd(Ldd ldd) {
		return rentAppRepository.findByLdd(ldd);
	}

}
