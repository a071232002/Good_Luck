package com.rtn.controller.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RtnDAO implements RtnDao_InterFace {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Cuttle00";

	static String TableName = "return_table";

	private static final String GET_ONE_STMT = "SELECT rtnNo, empNo, orderNo, rtnDate, rtnWhy, refundAmount, rtnStatus "
			+ " FROM " + TableName + " WHERE rtnNo = ?";
//	private static final String GET_ONE_STMT = "SELECT rtnNo, empNo, orderNo, rtnDate, rtnWhy, refundAmount, rtnStatus FROM return_table WHERE rtnNo = ?";

	private static final String INSTER = "INSERT INTO " + TableName
			+ " (empNo, orderNo, rtnDate, rtnWhy, refundAmount, rtnStatus)" + " VALUES " + " (?, ?, ?, ?, ?, ?)";

	@Override
	public RtnVo findByPrimaryKey(Integer rtnNo) {
		RtnVo rtnVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, rtnNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				rtnVo = new RtnVo();
				rtnVo.setRtnNo(rs.getInt("rtnNo"));
				rtnVo.setEmpNo(rs.getInt("empNo"));
				rtnVo.setOrderNo(rs.getInt("orderNo"));
				rtnVo.setRtnDate(rs.getDate("rtnDate"));
				rtnVo.setRtnWhy(rs.getString("rtnWhy"));
				rtnVo.setRefundAmount(rs.getInt("RefundAmount"));
				rtnVo.setRtnStatus(rs.getInt("RtnStatus"));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("找不到資料庫驅動 = = ");
		} catch (SQLException se) {
			throw new RuntimeException("資料庫找不到拉... " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return rtnVo;
	}

	@Override
	public void insert(RtnVo rtnvo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSTER);

//			pstmt.setInt(1, rtnvo.getRtnNo());
			pstmt.setInt(1, rtnvo.getEmpNo());
			pstmt.setInt(2, rtnvo.getorderNo());
			pstmt.setDate(3, rtnvo.getRtnDate());
			pstmt.setString(4, rtnvo.getRtnWhy());
			pstmt.setInt(5, rtnvo.getRefundAmount());
			pstmt.setInt(6, rtnvo.getRtnStatus());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("無法載入資料庫驅動程式" + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤" + se.getMessage());
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
	public void update(RtnVo rtnvo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer rtnNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RtnVo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		RtnDAO dao = new RtnDAO();
		RtnVo rtnVo = new RtnVo();

//		getOnePKEven(dao, rtnVo);
		InsertDataEven(dao, rtnVo);
	}

	public static void getOnePKEven(RtnDAO dao, RtnVo rtnVo) {

		RtnVo rtnVo1 = dao.findByPrimaryKey(2);
		System.out.println("退貨編號: " + rtnVo1.getRtnNo());
		System.out.println("員工編號: " + rtnVo1.getEmpNo());
		System.out.println("訂單編號: " + rtnVo1.getorderNo());
		System.out.println("退貨日期: " + rtnVo1.getRtnDate());
		System.out.println("退貨原因: " + rtnVo1.getRtnWhy());
		System.out.println("退款金額: " + rtnVo1.getRefundAmount());
		System.out.println("退貨狀態: " + rtnVo1.getRtnStatus());

		System.out.println("---------------------");
	}

	public static void InsertDataEven(RtnDAO dao, RtnVo rtnVo) {
		RtnVo rtnVoInsert = new RtnVo();
//		rtnVoInsert.setRtnNo(11);
		rtnVoInsert.setEmpNo(12);
		rtnVoInsert.setOrderNo(13);
		rtnVoInsert.setRtnDate(java.sql.Date.valueOf("2023-12-15"));
		rtnVoInsert.setRtnWhy("15");
		rtnVoInsert.setRefundAmount(1);
		rtnVoInsert.setRtnStatus(0);
		dao.insert(rtnVoInsert);
	}

}
