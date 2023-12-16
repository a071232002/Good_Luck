package com.cha104g2.goodluck.lddapp.model;

import java.sql.*;
import java.util.*;

public class LddAppDAOImpl implements LddAppDAO {

//	private static DataSource ds = null;
//	static {
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cha104g2");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//	con = ds.getConnection();
	
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO lddApp (memNo,lddAppCreate,lddAppIDPic) VALUES (?, ?, ?)";
	private static final String GET_ALL = "SELECT * FROM  lddApp ORDER BY lddAppNo";
	private static final String FIND_BY_PK = "SELECT * FROM lddApp where lddAppNo = ?";
	private static final String UPDATE = "UPDATE lddApp set memNo=?, empNo=?, lddAppCreate=?, lddAppIDPic=?, lddAppPayStatus=?, lddAppStatus=? where lddAppNo = ?";

	@Override
	public void insert(LddApp lddApp) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, lddApp.getMemNo());
			pstmt.setDate(2, lddApp.getLddAppCreate());
			pstmt.setBytes(3, lddApp.getLddAppIDPic());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResoureces(con, pstmt, null);
		}
	}

	@Override
	public void update(LddApp lddApp) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, lddApp.getMemNo());
			pstmt.setInt(2, lddApp.getEmpNo());
			pstmt.setDate(3, lddApp.getLddAppCreate());
			pstmt.setBytes(4, lddApp.getLddAppIDPic());
			pstmt.setInt(5, lddApp.getLddAppPayStatus());
			pstmt.setInt(6, lddApp.getLddAppStatus());
			pstmt.setInt(7, lddApp.getLddAppNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResoureces(con, pstmt, null);
		}
	}

	@Override
	public LddApp findByPrimaryKey(Integer lddAppNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LddApp lddApp = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);

			pstmt.setInt(1, lddAppNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				lddApp = new LddApp();
				lddApp.setLddAppNo(rs.getInt("lddAppNo"));
				lddApp.setMemNo(rs.getInt("memNo"));
				lddApp.setEmpNo(rs.getInt("empNo"));
				lddApp.setLddAppIDPic(null);
				lddApp.setLddAppCreate(rs.getDate("lddAppCreate"));
				lddApp.setLddAppPayStatus(rs.getInt("lddAppPayStatus"));
				lddApp.setLddAppStatus(rs.getInt("lddAppStatus"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResoureces(con, pstmt, rs);
		}

		return lddApp;
	}

	@Override
	public List<LddApp> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<LddApp> list = new ArrayList<>();
		LddApp lddApp = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				lddApp = new LddApp();
				lddApp.setLddAppNo(rs.getInt("lddAppNo"));
				lddApp.setMemNo(rs.getInt("memNo"));
				lddApp.setEmpNo(rs.getInt("empNo"));
				lddApp.setLddAppCreate(rs.getDate("lddAppCreate"));
				lddApp.setLddAppIDPic(null);
				lddApp.setLddAppPayStatus(rs.getInt("lddAppPayStatus"));
				lddApp.setLddAppStatus(rs.getInt("lddAppStatus"));
				list.add(lddApp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResoureces(con, pstmt, rs);
		}
		return list;
	}

}
