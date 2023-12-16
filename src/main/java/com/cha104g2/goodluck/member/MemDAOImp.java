package com.cha104g2.goodluck.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MemDAOImp implements MemDAO{
	
//	private static DataSource ds = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Williamjava0419";
	
	
	
//	static {
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/William");
//		} catch(NamingException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void insert(Mem mem) {
		Connection conn = null;
		
		//�P��Ʈw�s�u
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
//			conn = ds.getConnection();
			PreparedStatement prst = conn.prepareStatement(SQLCommand.INSERT_MEM);
			prst.setString(1, mem.getMemMail());
			prst.setString(2, mem.getMemPsw());
			prst.setString(3, mem.getMemName());
			prst.setByte(4, mem.getMemSex());
			prst.setString(5, mem.getMemPhone());
			prst.setString(6, mem.getMemAdd());
			prst.setString(7, mem.getMemID());
			prst.setDate(8, mem.getMemReg());
			prst.setByte(9, mem.getMemStatus());
			prst.setTimestamp(10, mem.getLastLoginTime());
			prst.setBytes(11, mem.getMemPic());
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("connection end!");
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Mem findByPrimaryKey(Integer memno) {
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		Mem data = new Mem();
		
		//�P��Ʈw�s�u
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			
		try {
//			conn = ds.getConnection();
			prst = conn.prepareStatement(SQLCommand.FIND_BY_MEMNO);
			prst.setInt(1, memno);
			
			rs = prst.executeQuery();
			rs.next();
			data.setMemNo(rs.getInt(1));
			data.setMemMail(rs.getString(2));
			data.setMemPsw(rs.getString(3));
			data.setMemName(rs.getString(4));
			data.setMemSex(rs.getByte(5));
			data.setMemPhone(rs.getString(6));
			data.setMemAdd(rs.getString(7));
			data.setMemID(rs.getString(8));
			data.setMemReg(rs.getDate(9));
			data.setMemStatus(rs.getByte(10));
			data.setLastLoginTime(rs.getTimestamp(11));
			data.setMemPic(rs.getBytes(12));
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				prst.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	@Override
	public List<Mem> findAll(){
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		List<Mem> list = new ArrayList<Mem>();
		
		//�P��Ʈw�s�u
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		try {
//			conn = ds.getConnection();
			prst = conn.prepareStatement(SQLCommand.FIND_ALL);
			rs = prst.executeQuery();
			while(rs.next()) {
				Mem memdata = new Mem();
				memdata.setMemNo(rs.getInt(1));
				memdata.setMemMail(rs.getString(2));
				memdata.setMemPsw(rs.getString(3));
				memdata.setMemName(rs.getString(4));
				memdata.setMemSex(rs.getByte(5));
				memdata.setMemPhone(rs.getString(6));
				memdata.setMemAdd(rs.getString(7));
				memdata.setMemID(rs.getString(8));
				memdata.setMemReg(rs.getDate(9));
				memdata.setMemStatus(rs.getByte(10));
				memdata.setLastLoginTime(rs.getTimestamp(11));
				memdata.setMemPic(rs.getBytes(12));
				list.add(memdata);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				prst.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				conn.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		MemDAOImp mems = new MemDAOImp();
//		Mem data = new Mem("1234467@gmail.com", "mypassword", "William", Byte.valueOf((byte)0), "0911145678", "myaddreess", "C123456789", Date.valueOf("2002-01-01"), Byte.valueOf((byte)1), Timestamp.valueOf(LocalDateTime.now()), mems.picInput("pics/FC_Barcelona.png"));
//		mems.insert(data);   //ok
		
		
		
		List<Mem> datas = mems.findAll();  //ok
		for(Mem da : datas) {
			System.out.println();
			System.out.println(da);			
		}
		
//		Mem oneData = mems.findByPrimaryKey(1);
//		System.out.println(oneData);
//		
//		Timestamp ti = oneData.getLastLoginTime();
//		LocalDateTime ldt = ti.toLocalDateTime();
//		System.out.println(ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		
		System.out.println("end");
	}
	
	//�Ϥ���ƳB�z
	public byte[] picInput(String src) {
		File file = new File(src);
		InputStream is = null;
		byte[] datas = null;
		try {
			is = new FileInputStream(file);			
			datas = is.readAllBytes();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();	
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return datas;
		
	}
}
