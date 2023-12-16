package com.cha104g2.goodluck.member;

public class SQLCommand {
	static final String INSERT_MEM = 
		"INSERT INTO mem (memMail, memPsw, memName, memSex, memPhone, memAdd, memID, memReg, memStatus, lastLoginTime, memPic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	static final String FIND_ALL =
		"SELECT * FROM mem";
	static final String FIND_BY_MEMNO =
		"SELECT * FROM mem WHERE memNo = ?";
}
