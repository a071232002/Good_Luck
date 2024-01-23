package com.rent.model;


import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class mapTest {
    private static final String API_KEY = "AIzaSyBuQxy8IWpLXa4ixgreClBMfk_TuBFfJyI";
    
    public String[] getLatAndLng(String rentAppCou, String rentAppAr, String rentAppRo, String rentAppAdd) throws Exception {
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
    
    public static void main(String[] args) throws Exception  {
    	mapTest maptest=new mapTest();
//    	基隆市仁愛區港西街5號
		String[] LatAndLng=maptest.getLatAndLng("基隆市","仁愛區","港西街","5號");
		for (String element : LatAndLng) {
            System.out.println(element);
        }
       
    }
}
