package com.cha104g2.goodluck.rentapp.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rentAppDAOImpl implements rentAppDAO{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Answer721";

	private static final String INSERT_STMT = 
			"INSERT INTO rentApp (lddNo,empNo,rentNo,rentAppCou,rentAppAr,rentAppRo,rentAppAdd,rentAppOwn,rentAppFloor,rentAppSize,rentAppSt) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT rentAppNo,lddNo,empNo,rentNo,rentAppCou,rentAppAr,rentAppRo,rentAppAdd,rentAppOwn,rentAppFloor,rentAppSize,rentAppSt FROM rentApp order by rentAppNo";
		private static final String GET_ONE_STMT = 
			"SELECT rentAppNo,lddNo,empNo,rentNo,rentAppCou,rentAppAr,rentAppRo,rentAppAdd,rentAppOwn,rentAppFloor,rentAppSize,rentAppSt FROM rentApp where rentAppNo = ?";
		private static final String UPDATE = 
			"UPDATE rentApp set lddNo=?, empNo=?, rentNo=?, rentAppCou=?, rentAppAr=?, rentAppRo=?, rentAppAdd=?, rentAppOwn=?, rentAppFloor=?, rentAppSize=?, rentAppSt=? where rentAppNo = ?";
		
	@Override
	public void insert(rentApp rent) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, rent.getLddNo());
			pstmt.setInt(2, rent.getEmpNo());
			pstmt.setInt(3, rent.getRentNo());
			pstmt.setString(4, rent.getRentAppCou());
			pstmt.setString(5, rent.getRentAppAr());
			pstmt.setString(6, rent.getRentAppRo());
			pstmt.setString(7, rent.getRentAppAdd());
			pstmt.setBytes(8, rent.getRentAppOwn());
			pstmt.setInt(9, rent.getRentAppFloor());
			pstmt.setDouble(10, rent.getRentAppSize());
			pstmt.setInt(11, rent.getRentAppSt());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void update(rentApp rent) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, rent.getLddNo());
			pstmt.setInt(2, rent.getEmpNo());
			pstmt.setInt(3, rent.getRentNo());
			pstmt.setString(4, rent.getRentAppCou());
			pstmt.setString(5, rent.getRentAppAr());
			pstmt.setString(6, rent.getRentAppRo());
			pstmt.setString(7, rent.getRentAppAdd());
			pstmt.setBytes(8, rent.getRentAppOwn());
			pstmt.setInt(9, rent.getRentAppFloor());
			pstmt.setDouble(10, rent.getRentAppSize());
			pstmt.setInt(11, rent.getRentAppSt());
			pstmt.setInt(12, rent.getRentAppNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void delete(Integer rentno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public rentApp findByPrimaryKey(Integer rentno) {
		// TODO Auto-generated method stub
		rentApp rent = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, rentno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				rent = new rentApp();

				rent.setRentAppNo(rs.getInt("rentAppNo"));
				rent.setLddNo(rs.getInt("lddNo"));
				rent.setEmpNo(rs.getInt("empNo"));
				rent.setRentNo(rs.getInt("rentNo"));
				rent.setRentAppCou(rs.getString("rentAppCou"));
				rent.setRentAppAr(rs.getString("rentAppAr"));
				rent.setRentAppRo(rs.getString("rentAppRo"));
				rent.setRentAppAdd(rs.getString("rentAppAdd"));
				rent.setRentAppOwn(rs.getBytes("rentAppOwn"));
				rent.setRentAppFloor(rs.getInt("rentAppFloor"));
				rent.setRentAppSize(rs.getDouble("rentAppSize"));
				rent.setRentAppSt(rs.getByte("rentAppSta"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
		return rent;
	}

	@Override
	public List<rentApp> getAll() {
		// TODO Auto-generated method stub
		List<rentApp> list = new ArrayList<rentApp>();
		rentApp rent = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rent = new rentApp();

				rent.setRentAppNo(rs.getInt("rentAppNo"));
				rent.setLddNo(rs.getInt("lddNo"));
				rent.setEmpNo(rs.getInt("empNo"));
				rent.setRentNo(rs.getInt("rentNo"));
				rent.setRentAppCou(rs.getString("rentAppCou"));
				rent.setRentAppAr(rs.getString("rentAppAr"));
				rent.setRentAppRo(rs.getString("rentAppRo"));
				rent.setRentAppAdd(rs.getString("rentAppAdd"));
				rent.setRentAppOwn(rs.getBytes("rentAppOwn"));
				rent.setRentAppFloor(rs.getInt("rentAppFloor"));
				rent.setRentAppSize(rs.getDouble("rentAppSize"));
				rent.setRentAppSt(rs.getByte("rentAppSt"));
				list.add(rent); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		rentAppDAOImpl dao=new rentAppDAOImpl();
		
		// �s�W		
		rentApp testrent=new rentApp();
		testrent.setLddNo(2);
		testrent.setEmpNo(2);
		testrent.setRentNo(2);
		testrent.setRentAppCou("�򶩥�");
		testrent.setRentAppAr("���R��");
		testrent.setRentAppRo("�n����");
		testrent.setRentAppAdd("3��2��");
		testrent.setRentAppOwn(getPictureByteArray("C:\\Pictures\\natalie_portman_2.jpg"));
		testrent.setRentAppFloor(2);
		testrent.setRentAppSize(6.5);
		testrent.setRentAppSt((byte) 1);
		dao.insert(testrent);
		
		// �ק�
//		rentApp testrent=new rentApp();
//		testrent.setRentAppNo(1);
//		testrent.setLddNo(3);
//		testrent.setEmpNo(3);
//		testrent.setRentNo(3);
//		testrent.setRentAppCou("�x�_��");
//		testrent.setRentAppAr("�j�w��");
//		testrent.setRentAppRo("���s��");
//		testrent.setRentAppAdd("6��6��");
//		testrent.setRentAppOwn(getPictureByteArray("C:\\Pictures\\natalie_portman_3.jpg"));
//		testrent.setRentAppFloor(3);
//		testrent.setRentAppSize(999.5);
//		dao.update(testrent);
		
		// �d��
//		rentApp testrent=dao.findByPrimaryKey(1);
//		System.out.print(testrent.getRentAppNo() + ",");
//		System.out.print(testrent.getLddNo() + ",");
//		System.out.print(testrent.getEmpNo() + ",");
//		System.out.print(testrent.getRentNo() + ",");
//		System.out.print(testrent.getRentAppCou() + ",");
//		System.out.print(testrent.getRentAppAr() + ",");
//		System.out.print(testrent.getRentAppRo() + ",");
//		System.out.print(testrent.getRentAppAdd() + ",");
//		System.out.print(testrent.getRentAppFloor() + ",");
//		System.out.print(testrent.getRentAppSize() + ",");
//		System.out.print(testrent.getRentAppSt());
//		System.out.println("---------------------");
//		readPicture(testrent.getRentAppOwn(),testrent.getRentAppNo());
		
		// �d��
//			List<rentApp> list = dao.getAll();
//			for (rentApp aRentapply : list) {
//				System.out.print(aRentapply.getRentAppNo() + ",");
//				System.out.print(aRentapply.getLddNo() + ",");
//				System.out.print(aRentapply.getEmpNo() + ",");
//				System.out.print(aRentapply.getRentNo() + ",");
//				System.out.print(aRentapply.getRentAppCou() + ",");
//				System.out.print(aRentapply.getRentAppAr() + ",");
//				System.out.print(aRentapply.getRentAppRo() + ",");
//				System.out.print(aRentapply.getRentAppAdd() + ",");
//				System.out.print(aRentapply.getRentAppOwn() + ",");
//				System.out.print(aRentapply.getRentAppFloor() + ",");
//				System.out.print(aRentapply.getRentAppSize() + ",");
//				System.out.print(aRentapply.getRentAppSt()+ ",");
//				
////				System.out.print(readPicture(aRentapply.getRentAppOwn(),aRentapply.getRentAppNo()));
//				System.out.println();
//
//			}
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
	
	public static String readPicture(byte[] bytes, int index) throws IOException {
		String outputdir="C:\\Out\\out"+index+".jpg";
		FileOutputStream fos = new FileOutputStream(outputdir);
		fos.write(bytes);
		fos.flush();
		fos.close();
		return outputdir;
	}

}
