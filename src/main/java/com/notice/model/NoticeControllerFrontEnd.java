
package com.notice.model;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.protocol.x.Notice;
import com.notice.service.NoticeService;
import com.rtn.model.Rtn;

@Controller
@RequestMapping("/notice")
public class NoticeControllerFrontEnd {
	
	
	@Autowired
	private NoticeService noticeservice;
//全部公告json到前端
	@GetMapping("/getAllNotices")
	public ResponseEntity<List<NoticeVO>> addNoticeGetAll(){
		NoticeVO noticeVO = new NoticeVO();
		List<NoticeVO>notices =  noticeservice.getAll();
		return  ResponseEntity.status(HttpStatus.OK).body(notices);
	}
}