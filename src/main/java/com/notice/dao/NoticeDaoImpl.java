//package com.notice.dao;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Component;
//
//import com.notice.model.NoticeVO;
//import com.notice.rowMapper.NoticeRowMapper;
//
//@Component
//public class NoticeDaoImpl implements NoticeDao {
//
//	@Autowired
//	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//	@Override
//	public List<NoticeVO> getAllNotices () {
//		String sql = "SELECT noticeNo, empNo, noticeTime, noticeContent, noticeStatus" + "FROM notice WHERE 1=1";
//		Map<String, Object> map = new HashMap<>();
//		
//		sql = addFilteringSQL(sql, map);
//		
//		System.out.println("addFilteringSQL: " + (sql));
//		
//		List<NoticeVO> NoticeList = namedParameterJdbcTemplate.query(sql, map, new NoticeRowMapper());
//
//		return NoticeList;
//	}
//
//	private String addFilteringSQL(String sql, Map<String, Object> map) {
//		return null;
//	}
//
//	@Override
//	public List<String> getAllKeepNoticeContent() {
//		return null;
//	}
//	@Override
//	public NoticeVO getNoticeNoById(Integer noticeNo) {
//		return null;
//	}
//
////	@Override
////	public Integer getAllNoticeIdCount() {
////		return null;
////	}
//
////	@Override
////	public List<Notice> getAllNoticeData1() {
////		return null;
////	}
//
//////	Notice選單value注入功能
////	@Override
////	public List<String> getAllKeepNoticeContent() {
////		String sql = "SELECT DISTINCT noticeContent FROM noticeContent";
////
////		return namedParameterJdbcTemplate.queryForList(sql, new HashMap<>(), String.class);
////	}
////
////	@Override
////	public Notice getNoticeNoById (Integer noticeNo) {
////		String sql = "SELECT noticeNo, empNo, noticeTime, noticeContent, noticeStatus"
////				+ " FROM notice WHERE noticeNo =:noticeNo";
//////		String sql = "SELECT noticeNo, empNo, noticeTime, noticeContent, noticeStatus "
//////				+ "FROM notice WHERE noticeNo =notcieNo";
////
////		Map<String, Object> map = new HashMap<>();
////		map.put("noticeNo", noticeNo);
////
////		List<Notice> NoticeList = namedParameterJdbcTemplate.query(sql, map, new NoticeRowMapper());
////		if (NoticeList.size() > 0) {
////			return NoticeList.get(0);
////		} else {
////			return null;
////		}
////	}
////
//	
//	public Integer createNotice(NoticeVO notice) {
//		String sql = "INSERT INTO NOTICE (  noticeNo , empNo , noticeTime , noticeContent , noticeStatus)"
//				+ "VALUE( :noticeNo , :empNo , :noticeTime , :noticeContent ,:noticeStatus )";
//		Map<String, Object> map = new HashMap<>();
//		map.put("noticeNo", notice.getNoticeNo());
//		map.put("empNo", notice.getEmpNo());
//		map.put("noticeTime", notice.getNoticeTime());
//		map.put("noticeContent", notice.getNoticecontent());
//		map.put("noticeStatus", notice.getNoticeStatus());
//		
//		Date now = new Date();
//		map.put("noticeTime", now);
//
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//
//		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
//
//		int NoticeNoId = keyHolder.getKey().intValue();
//
//		return NoticeNoId;
//	}
//
////	public void updateNotice(Integer NoticeNoId, notice notice, Object noticeNo, Object put) {
////		String sql = "UPDATE notice SET  noticeNo = :noticeNo , empNo = :empNo ,  noticeTime = :noticeTime ,noticeContent = :noticeContent ,noticeStatus = :noticeStatus "
////				+ "WHERE noticeNo = :noticeNo";
////
////		Map<String, Object> map = new HashMap<>();
////
////		map.put("noticeNo", noticeNo);
////		map.put("empNo", notice.getEmpNo());
////		map.put("noticeTime", notice.getNoticeTime());
////		map.put("noticeContent", notice.getNoticeContent());
////		map.put("noticeStatus", notice.getNoticeStatus());
////
////		namedParameterJdbcTemplate.update(sql, map);
////	}
//
//	@Override
//	public Integer getAllNoticeIdCount() {
//		String sql = "SELECT COUNT(*) FROM NOTICE;";
//		return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Integer.class);
//	}
//
////	public List<Notice> getAllNoticeData() {
////		String sql = "SELECT COUNT(*) FROM NOTICE;";
////		return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Integer.class);
////	}
//
//	public List<NoticeVO> getAllNotice() {
//		String sql = "SELECT noticeNo , empNo, noticeTime, noticeContent, noticeStatus FROM  notice;";
//		System.out.println(sql);
//		Map<String, Object> map = new HashMap<>();
//
//		List<NoticeVO> NoticeList = namedParameterJdbcTemplate.query(sql, map, new NoticeRowMapper());
//
//		if (NoticeList.size() > 0) {
//			return NoticeList;
//		} else {
//			return null;
//		}
//
////	public String addFilteringSQL(String sql, Map<String, Object> map) {
////	    if (noticeQueryParams.getNoticeCateGory() != null) {
////	        System.out.println("noticeQueryParams.getNoticeCateGory(): " + noticeQueryParams.getNoticeCateGory());
////	        System.out.println("getNoticeCateGory: " + (noticeQueryParams.getNoticeCateGory() != null));
////
////	        sql += " AND notice = :notice";
////
////	        System.out.println("getNoticeCateGory sql: " + sql);
////
////	        map.put("notice", noticeQueryParams.getNoticeCateGory().name());
////	    }
//
//
//
////		if (noticeQueryParams.getSearch() != null) {
////			
////			System.out.println("noticeContent: " + (noticeQueryParams.getSearch() != null));
////			
////			sql += " AND noticeContent = :noticeContent";
////			
////			System.out.println("noticeContent sql: " + sql);
////			
////			map.put("search", "%" + noticeQueryParams.getNoticeStatus() + "%");
////		}
//	}
//}
