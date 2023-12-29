package com.tag.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.product.model.*;

public class TagDAO implements TagDAO_interface {
	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestG2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO TAG (tagName) VALUES (?)";
	private static final String GET_ALL_STMT = "SELECT tagNo, tagName FROM TAG ORDER BY tagNo";
	private static final String GET_ONE_STMT = "SELECT tagNo, tagName FROM TAG WHERE tagNo = ?";

	private static final String GET_Pros_ByTagNo_STMT = "SELECT proNo, proName, proMean, proPrice, proQty, proImg, proCreateTime, proStatus, tagNo, empNo FROM PRODUCT WHERE proNo = ?";

	private static final String DELETE_PRO = "DELETE FROM product where tagNo = ?";
	private static final String DELETE_TAG = "DELETE FROM tag where tagNo = ?";
	private static final String UPDATE = "UPDATE TAG SET tagName=? WHERE tagNo = ?";

	@Override
	public void insert(TagVO tagVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			// 新增
			pstmt.setString(1, tagVO.getTagName()); // Set tag name
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
	public void update(TagVO tagVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, tagVO.getTagName()); // Set tag name
			pstmt.setInt(2, tagVO.getTagNo()); // Set tag number
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer tagNo) {

		int updateCount_PROs = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);
			// 先刪除商品

			pstmt = con.prepareStatement(DELETE_PRO);
			pstmt.setInt(1, tagNo);
			updateCount_PROs = pstmt.executeUpdate();

			// 再刪除類別
			pstmt = con.prepareStatement(DELETE_TAG);
			pstmt.setInt(1, tagNo);
			pstmt.executeUpdate();

			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("刪除商品類別" + tagNo + "時,共有商品" + updateCount_PROs + "樣同時被刪除");

		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public TagVO findByPrimaryKey(Integer tagNo) {
		TagVO tagVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, tagNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tagVO = new TagVO();
				tagVO.setTagNo(rs.getInt("tagNo"));
				tagVO.setTagName(rs.getString("tagName"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return tagVO;
	}

	@Override
	public List<TagVO> getAll() {
		List<TagVO> list = new ArrayList<>();
		TagVO tagVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tagVO = new TagVO();
				tagVO.setTagNo(rs.getInt("tagNo"));
				tagVO.setTagName(rs.getString("tagName"));
				list.add(tagVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	@Override
	public Set<ProVO> getProsByTagNo(Integer tagNo) {
		Set<ProVO> set = new LinkedHashSet<ProVO>();
		ProVO proVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_Pros_ByTagNo_STMT);
			pstmt.setInt(1, tagNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				proVO = new ProVO();
				proVO.setProNo(rs.getInt("proNo"));
				proVO.setProName(rs.getString("proName"));
				proVO.setProMean(rs.getString("ProMean"));
				proVO.setProPrice(rs.getInt("ProPrice"));
				proVO.setProQty(rs.getInt("proQty"));
				proVO.setProImg(rs.getBytes("proImg"));
				proVO.setProCreateTime(rs.getTimestamp("proCreateTime").toLocalDateTime());
				proVO.setProStatus(rs.getInt("proStatus"));
				proVO.setTagNo(rs.getInt("tagNo"));
				proVO.setEmpNo(rs.getInt("empNo"));
				set.add(proVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return set;
	}

}

