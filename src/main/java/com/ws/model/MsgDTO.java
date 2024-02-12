package com.ws.model;

import java.io.Serializable;

import com.apo.model.Apo;
import com.lse.model.Lse;

public class MsgDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String msg;
	
	private String link;

	public MsgDTO() {
		super();
	}
	
	public MsgDTO (Apo apo){
		if(apo.getApoWant() == null || apo.getApoWant() == 0 ) {
			switch(apo.getApoStatus()) {
				case 0:
					this.msg = "物件No:" + apo.getRent().getRentNo() + ", 有新的預約。";
					this.link = "/apo/reviewApo";
					break;
				case 9:
					this.msg = "預約No:" + apo.getApoNo() + ", 預約時間變更, 請確認。";
					this.link = "/apo/reviewApo";
					break;
				case 1:
					this.msg = "預約No:" + apo.getApoNo() + ", 預約已被婉拒。";
					this.link = "/apo/listAllApo";
					break;
				case 2:
					this.msg = "預約No:" + apo.getApoNo() + ", 通過審核, 請準時赴約。";
					this.link = "/apo/listAllApo";
					break;
				case 3:
					this.msg = "預約No:" + apo.getApoNo() + ", 看屋完成, 請確認是否要租屋。";
					this.link = "/apo/listAllApo";
					break;
				default:
					break;
			}
		} else {
			switch(apo.getApoWant()) {
				case 2:
					this.msg = "物件No:" + apo.getRent().getRentNo() + ", 有新的租屋意願。";
					this.link = "/apo/reviewApo";
					break;
				default:
					break;
			}
		}
			
	}
	public MsgDTO (Apo apo, Integer memNo){
		
	}
	
	public MsgDTO (Lse lse){
		if (lse.getLseStatus() == null || lse.getLseStatus() == 0) {
			this.msg = "合約No:" + lse.getLseNo() + ", 已建立, 請前往確認。";
			this.link = "/lse/listAllLse";
		} else {			
			switch(lse.getLseStatus()) {
			case 1:
				this.msg = "合約No:" + lse.getLseNo() + ", 房東婉拒。";
				this.link = "/lse/listAllLse";
				break;
			case 2:
				this.msg = "合約No:" + lse.getLseNo() + ", 租客已回傳, 前往查看。";
				this.link = "/lse/reviewLse";
				break;
			case 3:
				this.msg = "合約No:" + lse.getLseNo() + ", 房東已確認, 請繳押金。";
				this.link = "/lse/listAllLse";
				break;
			case 4:
				this.msg = "合約No:" + lse.getLseNo() + ", 租客已匯款, 請確認。";
				this.link = "/lse/reviewLse";
				break;
			case 5:
				this.msg = "合約No:" + lse.getLseNo() + ", 合約簽立完成。";
				this.link = "/lse/listAllLse";
				break;
			case 6:
				this.msg = "合約No:" + lse.getLseNo() + ", 合約已到期。";
				this.link = "/lse/listAllLse";
				break;
			default:
				break;
			}
		}
	}
	
	public MsgDTO (Lse lse, Integer memNo){
		switch(lse.getLseStatus()) {
			case 6:
				this.msg = "合約No:" + lse.getLseNo() + ", 合約已到期, 物件可重新送審。";
				this.link = "/lse/reviewLse";
				break;
			default:
				break;
			}
		}
	
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
