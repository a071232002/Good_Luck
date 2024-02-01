// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
package com.notice.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO,Integer>{

//		@Transactional
//     @Modifying
//		@Query("From NoticeVO notice WHERE notice.noticeNo=?1",nativeQuery = true)
//		public void deleteByNoticeNo(Integer noticeNo);
	
}
