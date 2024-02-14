package com.ws.model;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apo.model.Apo;
import com.apo.model.ApoService;
import com.google.gson.Gson;
import com.lse.model.Lse;
import com.lse.model.LseService;
import com.rent.model.Rent;
import com.rent.model.RentService;


@ServerEndpoint("/MsgWS/{userId}")
@Component
public class MsgWS {
	private static Map<Integer, Session> sessionsMap = new ConcurrentHashMap<>();
	private static Gson gson = new Gson();
	
	@Autowired
	static ApoService apoSvc;
	
	@Autowired
	static LseService lseSvc;
	
	@Autowired
	static RentService rentSvc;
	
	@OnOpen
	public static void onOpen(@PathParam("userId") Integer userId, Session userSession) throws IOException {
		/* save the new user in the map */
		sessionsMap.put(userId, userSession);
		
	}

	@OnClose
	public static void onClose(Session userSession, CloseReason reason) {
	    System.out.println("closing websocket");
		Set<Integer> userIds = sessionsMap.keySet();
		for (Integer userId : userIds) {
			if (sessionsMap.get(userId).equals(userSession)) {
				sessionsMap.remove(userId);
				break;
			}
		}
	}
	
	@OnError
	public void onError(Session userSession, Throwable e) {
		System.out.println("Error: " + e.toString());
	}
	
	public static void sendMessageToMem(Apo apo) {
		Session session = sessionsMap.get(apo.getMem().getMemNo());
		MsgDTO msgDTO = new MsgDTO(apo);
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);
		}
	}
	public static void sendMessageToMem(Lse lse) {
//		lse.setLseStatus(Byte.valueOf("0"));
		Session session = sessionsMap.get(lse.getMem().getMemNo());
		MsgDTO msgDTO = new MsgDTO(lse);
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);
		}
	}
	public static void sendMessageToLdd(Apo apo) {
		Rent rent = rentSvc.getOneRent(apo.getRent().getRentNo());
		MsgDTO msgDTO = new MsgDTO(apo);
		Session session = sessionsMap.get(rent.getLdd().getMem().getMemNo());
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);
		}
	}
	public static void sendMessageToLdd(Apo apo, Integer memNo) {
		apo.setApoStatus(Byte.valueOf("0"));
		MsgDTO msgDTO = new MsgDTO(apo);
		Session session = sessionsMap.get(memNo);
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);
		}
	}
	
	public static void sendWantMessageToLdd(Apo apo, Integer memNo) {
		MsgDTO msgDTO = new MsgDTO(apo);
		Session session = sessionsMap.get(memNo);
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);
		}
	}
	
	public static void sendMessageToLdd(Lse lse, Integer memNo) {
		MsgDTO msgDTO = new MsgDTO(lse);
		Session session = sessionsMap.get(memNo);
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);
		}
	}
	
	public static void sendUpdateMessageToLdd(Apo apo, Integer memNo) {
		apo.setApoStatus(Byte.valueOf("9"));
		MsgDTO msgDTO = new MsgDTO(apo);
		Session session = sessionsMap.get(memNo);
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);	
		}
	}
	public static void sendMessageToBoth(Lse lse, Integer memNo) {
		
		MsgDTO msgDTO = new MsgDTO(lse);
		Session session = sessionsMap.get(lse.getMem().getMemNo());
		if(session != null) {
			String apoString = gson.toJson(msgDTO);
			session.getAsyncRemote().sendText(apoString);	
		}
		MsgDTO msgDTOToLdd = new MsgDTO(lse, memNo);
		Session sessionToLdd = sessionsMap.get(memNo);
		if(sessionToLdd != null) {
			String apoString = gson.toJson(msgDTOToLdd);
			sessionToLdd.getAsyncRemote().sendText(apoString);	
		}
	}
	
	
}

