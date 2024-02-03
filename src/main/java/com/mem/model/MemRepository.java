package com.mem.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

//Spring Boot版本
public interface MemRepository extends JpaRepository<Mem, Integer>{

	//JpaRepository方法findByMemMail會以屬性memMail為設置條件搜尋
	@Transactional
	public Mem findByMemMail(String memMail);
	
	@Transactional
	public boolean existsByMemMail(String memMail);
	
	@Transactional
	public boolean existsByMemPhone(String memPhone);
	
	@Transactional
	public boolean existsByMemID(String memID);
	
	@Transactional
	@Modifying
	@Query("UPDATE Mem mem SET mem.memPic = :memPic WHERE mem.memNo = :memNo")
	public void updateMemPicById(@Param("memNo")Integer memNo, @Param("memPic")byte[] memPic);
	
	@Transactional
	@Modifying
	@Query("UPDATE Mem mem SET mem.memStatus = :memStatus WHERE mem.memNo = :memNo")
	public void updateMemStatusById(@Param("memNo")Integer memNo, @Param("memStatus")Byte memStatus);
}
