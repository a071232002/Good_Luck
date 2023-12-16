package com.mem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemDaoImplements implements MemDao {

// private static DataSource ds = null;
// static {
//  try {
//   Context ctx = new InitialContext();
//   ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
//  } catch (NamingException e) {
//   e.printStackTrace();
//  }
// }
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Cuttle00";

	private static final String TableName = "member";
// private static final String TableColumn = "member";

// private static final String INSERT_STMT = "INSERT INTO member (memMail, memPsw, memName, memSex, memPhone, memAdd, memID, memReg, memStatus, lastLoginTime, memPic) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_STMT = "INSERT INTO " + TableName
			+ " (memMail, memPsw, memName, memSex, memPhone, memAdd, memID, memReg, memStatus, lastLoginTime, memPic) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE" + TableName
			+ "SET memMail =?, memPsw =?, memName =?, memSex =?, memPhone =?, memAdd =?, memID =?, memReg =?, memStatus =?, lastLoginTime =?, memPic =?"
			+ "WHERE memNo =?";

	@Override
	public void insert(MemVo memvo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//   Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//   con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memvo.getMemMail());
			pstmt.setString(2, memvo.getMemPsw());
			pstmt.setString(3, memvo.getMemName());
			pstmt.setInt(4, memvo.getMemSex());
			pstmt.setString(5, memvo.getMemPhone());
			pstmt.setString(6, memvo.getMemAdd());
			pstmt.setString(7, memvo.getMemID());
			pstmt.setDate(8, memvo.getMemReg());
			pstmt.setInt(9, memvo.getMemStatus());
			pstmt.setDate(10, memvo.getlastLoginTime());
			pstmt.setBytes(11, memvo.getMemPic());

			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("與資料庫互動時發生未知問題" + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(MemVo memvo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memvo.getMemMail());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("沒有找到JDBC DRIVER" + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("SQL指令異常" + se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(MemVo memvo) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemVo findByPrmaryKey(Integer memvo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		MemDaoImplements dao = new MemDaoImplements();
		MemVo memVo = new MemVo();

//		addEventTest(dao, memVo);
		updateEventTest(dao, memVo);
	}

//	Main方法測試事件
	public static void addEventTest(MemDaoImplements dao, MemVo memVo) {

//		新增

		memVo.setMemMail("123232ef"); // NOT NULL , UNIQUE (45)
		memVo.setMemPsw("p232123"); // 密碼 NOT NULL (12)
		memVo.setMemName("John Doe"); // 姓名 NOT NULL (12)
		memVo.setMemSex(0); // 性別，這裡假設 0 代表男性
		memVo.setMemPhone("1232323"); // 手機號碼 NOT NULL , UNIQUE (10)
		memVo.setMemAdd("1f3 Main St, City"); // 聯絡地址 NOT NULL (45)
		memVo.setMemID("A122456713"); // 身分證號碼 NOT NULL , UNIQUE (10)
		memVo.setMemReg(new java.sql.Date(System.currentTimeMillis())); // 註冊日期，假設為當前時間 NOT NULL
		memVo.setMemStatus(1); // 帳號狀態，這裡假設 1 代表正常
		// 日期時間屬性的設置
		memVo.setlastLoginTime(java.sql.Date.valueOf("2005-01-01")); // 最後上線時間
		// 大頭照的設置
//  byte[] memPicData = // 你的大頭照資料，例如從文件讀取或其他方式獲取
		memVo.setMemPic(null);
		dao.insert(memVo);
		System.out.println(memVo.getMemName() + " 資料新增完成");
	}

	public static void updateEventTest(MemDaoImplements dao, MemVo memVo) {
		memVo.setMemName("貓咪");
		memVo.setMemNo(22);
	}
}
