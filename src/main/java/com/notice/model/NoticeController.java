package com.notice.model;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notice.service.NoticeService;

@Controller
@RequestMapping("/BackStage/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	// 前往新增頁面
	@GetMapping("/addNotice")
	public String addNotice(Model model) {
	    model.addAttribute("noticeVO", new NoticeVO());
	    return "BackStage/notice/addNotice";
	}
	// 處理新增資料
	@PostMapping("/getaddNotice")
	public String getaddNotice(@Valid NoticeVO notice, BindingResult result, ModelMap model) throws IOException {
	   
//		if (notice.getNoticeContent() == null || notice.getNoticeContent().isEmpty()) {
//	        model.addAttribute("empty", "請輸入新增公告的內容");
//	    }
		System.out.println(notice.getNoticeContent());
	    if (result.hasErrors()) {
	        return "BackStage/notice/addNotice";
	    }

	    noticeService.addNotice(notice);
	    return "redirect:/BackStage/notice/listAllNotice";
	}

	
	//全部公告json到前端
	@GetMapping("/getAllNotices")
	public ResponseEntity<List<NoticeVO>> addNoticeGetAll(){
		NoticeVO noticeVO = new NoticeVO();
		List<NoticeVO>notices =  noticeService.getAll();
		return  ResponseEntity.status(HttpStatus.OK).body(notices);
	}
	
	//前往查詢頁面
	@GetMapping("/listAllNotice")
	public String showList(ModelMap mpdel) {
		return"BackStage/Notice/listAllNotice";
	}
	
	//前往修改頁面
	@PostMapping("updateNotice")
	public String updateData(ModelMap model,@ModelAttribute("noticeNo") String noticeNo) {
		System.out.println(noticeNo);
		NoticeVO oldData=noticeService.getOneNotice(Integer.valueOf(noticeNo));
		System.out.println("test "+oldData);
		model.addAttribute("data", oldData);
		return"BackStage/Notice/updateNotice";
	}

	

		//修改資料
		//@MdelAttribute對映th:object"${notice}"和model.addAttribute("notice", notice)
		@PostMapping("noticeupdate")
		public String updateNotice(@ModelAttribute("data") @Valid NoticeVO noticeVO, BindingResult result, ModelMap model) throws IOException{
			System.out.println(noticeVO);
//			notice.setNoticePic(part.isEmpty()? null : part.getBytes());
//			result = removeFieldError(notice, result, "noticePic");
			
			System.out.println(result.getErrorCount());
			System.out.println(result.getFieldErrorCount());
			System.out.println("yes");
			if(result.hasErrors()) {
				System.out.println(result.getAllErrors());
				return "BackStage/Notice/updateNotice";
		}
			NoticeVO newData = noticeService.updateNotice(noticeVO);
			model.addAttribute("successData", newData);
			System.out.println(newData);
			return "BackStage/Notice/listAllNotice";
//			return "redirect:/notice/noticelist";
		}
		//設置查詢全部屬性
		@ModelAttribute("noticeListData")
		protected List<NoticeVO> referenceListData() {
	    	List<NoticeVO> list =noticeService.getAll();
			return list;
		}	
		
		// 去除BindingResult中某個欄位的FieldError紀錄
		public BindingResult removeFieldError(NoticeVO notice, BindingResult result, String removedFieldname) {
			List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
					.filter(fieldname -> !fieldname.getField().equals(removedFieldname))
					.collect(Collectors.toList());
			result = new BeanPropertyBindingResult(notice, "noticeVO");
			for (FieldError fieldError : errorsListToKeep) {
				result.addError(fieldError);
			}
			return result;
		}
}
