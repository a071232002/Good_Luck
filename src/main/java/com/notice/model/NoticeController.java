package com.notice.model;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/BackStage/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeservice;
	
	//前往新增頁面
	@GetMapping("/addNotice")
	public String addNotice(ModelMap model) {
		NoticeVO noticeVO = new NoticeVO();
		model.addAttribute("noticeVO", noticeVO);
//		System.out.println("吃飽");
		return "BackStage/Notice/addNotice";

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
		NoticeVO oldData=noticeservice.getOneNotice(Integer.valueOf(noticeNo));
		System.out.println("test "+oldData);
		model.addAttribute("data", oldData);
		return"BackStage/Notice/updateNotice";
	}

	//新增資料
	@PostMapping("noticeadd")
	public String addNotice(@Valid NoticeVO notice,BindingResult result,ModelMap model)throws IOException{   //測add記得開
		
//		0109
//		System.out.println("ffffffffffffff"+notice);
		
		NoticeVO  notice2 = noticeservice.addNotice(notice);  //測add記得開 63 64
		System.out.println("notice2: "+notice2);
		
//		notice.setNoticePic(part.isEmpty() ? null : part.getBytes());
//		result = removeFieldError(notice,result,"noticePic");
		
//		System.out.println(result.getErrorCount());
//		System.out.println(result.getFieldErrorCount());
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return"BackStage/notice/addNotice";
			
		}
		NoticeVO newData = noticeservice.getOneNotice(noticeservice.addNotice(notice).getNoticeNo());
		model.addAttribute("sucessData", newData);
		System.out.println(newData);
//		return"BackStage/notice/listAllNotice";
		return"redirect:/BackStage/notice/listAllNotice";

	}

		//修改資料
		//@MdelAttribute對映th:object"${notice}"和model.addAttribute("notice", notice)
		@PostMapping("noticeupdate")
		public String updateNotice(@RequestParam("data") @Valid NoticeVO noticeVO, BindingResult result, ModelMap model) throws IOException{

//			notice.setNoticePic(part.isEmpty()? null : part.getBytes());
//			result = removeFieldError(notice, result, "noticePic");
			
			System.out.println(result.getErrorCount());
			System.out.println(result.getFieldErrorCount());
			System.out.println("yes");
			if(result.hasErrors()) {
				System.out.println(result.getAllErrors());
				return "BackStage/Notice/updateNotice";
		}
			NoticeVO newData = noticeservice.updateNotice(noticeVO);
			model.addAttribute("successData", newData);
			System.out.println(newData);
			return "BackStage/Notice/listAllNotice";
//			return "redirect:/notice/noticelist";
		}
		//設置查詢全部屬性
		@ModelAttribute("noticeListData")
		protected List<NoticeVO> referenceListData() {
	    	List<NoticeVO> list =noticeservice.getAll();
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
		

