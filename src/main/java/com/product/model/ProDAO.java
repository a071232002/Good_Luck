//package com.product.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//import org.springframework.stereotype.Component;
//
//@Component
//
//public class ProDAO implements ProDAO_interface {
//
//	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
//	private static DataSource ds = null;
//	static {
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestG2");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static final String INSERT_STMT = "INSERT INTO PRODUCT (proName, proMean, proPrice, proQty, proImg, proCreateTime, proStatus, tagNo, empNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	private static final String GET_ALL_STMT = "SELECT proNo, proName, proMean, proPrice, proQty, proImg, proCreateTime, proStatus, tagNo, empNo FROM PRODUCT ORDER BY proNo";
//	private static final String GET_ONE_STMT = "SELECT proNo, proName, proMean, proPrice, proQty, proImg, proCreateTime, proStatus, tagNo, empNo FROM PRODUCT WHERE proNo = ?";
//	private static final String DELETE = "DELETE FROM PRODUCT WHERE proNo = ?";
//	private static final String UPDATE = "UPDATE PRODUCT SET proName=?, proMean=?, proPrice=?, proQty=?, proImg=?, proCreateTime=?, proStatus=?, tagNo=?, empNo=? WHERE proNo = ?";
//
//	@Override
//	public void insert(ProVO proVO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setString(1, proVO.getProName());
//			pstmt.setString(2, proVO.getProMean());
//			pstmt.setInt(3, proVO.getProPrice());
//			pstmt.setInt(4, proVO.getProQty());
//			pstmt.setBytes(5, proVO.getProImg());
//			pstmt.setTimestamp(6, Timestamp.valueOf(proVO.getProCreateTime()));
//			pstmt.setInt(7, proVO.getProStatus());
//			pstmt.setInt(8, proVO.getTagNo());
//			pstmt.setInt(9, proVO.getEmpNo());
//
//			pstmt.executeUpdate();
//
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void update(ProVO proVO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);
//
//			pstmt.setString(1, proVO.getProName());
//			pstmt.setString(2, proVO.getProMean());
//			pstmt.setInt(3, proVO.getProPrice());
//			pstmt.setInt(4, proVO.getProQty());
//			pstmt.setBytes(5, proVO.getProImg());
//			pstmt.setTimestamp(6, Timestamp.valueOf(proVO.getProCreateTime()));
//			pstmt.setInt(7, proVO.getProStatus());
//			pstmt.setInt(8, proVO.getTagNo());
//			pstmt.setInt(9, proVO.getEmpNo());
//			pstmt.setInt(10, proVO.getProNo());
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void delete(Integer proNo) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setInt(1, proNo);
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public ProVO findByPrimaryKey(Integer proNo) {
//
//		ProVO proVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_ONE_STMT);
//
//			pstmt.setInt(1, proNo);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				// proVo 也稱為 Domain objects
//				proVO = new ProVO();
//                proVO.setProNo(rs.getInt("proNo"));
//                proVO.setProName(rs.getString("proName"));
//                proVO.setProMean(rs.getString("ProMean"));
//                proVO.setProPrice(rs.getInt("ProPrice"));
//                proVO.setProQty(rs.getInt("proQty"));
//                proVO.setProImg(rs.getBytes("proImg"));
//                proVO.setProCreateTime(rs.getTimestamp("proCreateTime").toLocalDateTime());
//                proVO.setProStatus(rs.getInt("proStatus"));
//                proVO.setTagNo(rs.getInt("tagNo"));
//                proVO.setEmpNo(rs.getInt("empNo"));
//			}
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return proVO;
//	}
//
//	@Override
//	 public List<ProVO> getAll() {
//        List<ProVO> list = new ArrayList<>();
//		ProVO proVO = null;
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_ALL_STMT);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				
//				proVO = new ProVO();
//                proVO.setProNo(rs.getInt("proNo"));
//                proVO.setProName(rs.getString("proName"));
//                proVO.setProMean(rs.getString("ProMean"));
//                proVO.setProPrice(rs.getInt("ProPrice"));
//                proVO.setProQty(rs.getInt("proQty"));
//                proVO.setProImg(rs.getBytes("proImg"));
//                proVO.setProCreateTime(rs.getTimestamp("proCreateTime").toLocalDateTime());
//                proVO.setProStatus(rs.getInt("proStatus"));
//                proVO.setTagNo(rs.getInt("tagNo"));
//                proVO.setEmpNo(rs.getInt("empNo"));
//                list.add(proVO);
//			}
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return list;
//	}
//}