package com.notice.dao;

import java.util.List;
import com.notice.model.NoticeVO;


public interface NoticeDao {
List<String> getAllKeepNoticeContent();
	
//	List<Notice> getAllNotices(NoticeQueryParams noticeQueryParams);
	List<NoticeVO> getAllNotices();
		
	NoticeVO getNoticeNoById(Integer noticeNo);
	
//	Integer createNotice(NoticeRequest noticeRequest);
	
//	void updateNotice(Integer NoticeNoId , NoticeRequest noticeRequest);
    
	Integer getAllNoticeIdCount();
	
//	List<Notice> getAllNoticeData();
}
