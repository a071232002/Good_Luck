package com.product.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.product.model.*;

@MultipartConfig
public class ProServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("proNo");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入商品編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pro/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer proNo = null;
			try {
				proNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("商品編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pro/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ProService proSvc = new ProService();
			ProVO proVO = proSvc.getOneProduct(proNo);
			if (proVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pro/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("proVO", proVO); // 資料庫取出的empVO物件,存入req
			String url = "/pro/listOnePro.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOnePro.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllPro.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer proNo = Integer.valueOf(req.getParameter("proNo"));

			/*************************** 2.開始查詢資料 ****************************************/
			ProService proSvc = new ProService();
			ProVO proVO = proSvc.getOneProduct(proNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("proVO", proVO); // 資料庫取出的proVO物件,存入req
			String url = "/pro/update_pro_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_pro_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_pro_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Part part = req.getPart("proImg");
	        InputStream inputStream = part.getInputStream();
	        byte[] proImg = inputStream.readAllBytes();
	        
	        
			//接收update JSP上傳圖片File============================================================================
			
			
			
			
			Integer proNo = Integer.valueOf(req.getParameter("proNo").trim());

String proName = req.getParameter("proName");
String proNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (proName == null || proName.trim().length() == 0) {
				errorMsgs.add("商品名稱: 請勿空白");
			} else if (!proName.trim().matches(proNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String proMean = req.getParameter("proMean");
			if (proMean == null || proMean.trim().length() == 0) {
				errorMsgs.add("商品描述: 請勿空白");
			}

			int proPrice = 0; // 默認值
			try {
proPrice = Integer.parseInt(req.getParameter("proPrice").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("商品價格請填數字.");
			}

			int proQty = 0; // 默認值
			try {
proQty = Integer.parseInt(req.getParameter("proQty").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("商品數量請填數字.");
			}

			// 假設 proCreateTime 是單獨處理的，以字符串形式表示為 "yyyy-MM-dd HH:mm:ss"
			String proCreateTimeString = req.getParameter("proCreateTime");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime proCreateTime = LocalDateTime.parse(proCreateTimeString, formatter);

			int proStatus = 0; // 默認值
			try {
proStatus = Integer.parseInt(req.getParameter("proStatus").trim());

				// 限制只能是 0 或 1
				if (proStatus != 0 && proStatus != 1) {
					errorMsgs.add("商品狀態只能是 0 或 1.");
				}
			} catch (NumberFormatException e) {
				errorMsgs.add("商品狀態請填數字.");
			}

			int tagNo = 0; // 默認值
			try {
tagNo = Integer.parseInt(req.getParameter("tagNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("標籤編號請填數字.");
			}

			int empNo = 0; // 默認值
			try {
empNo = Integer.parseInt(req.getParameter("empNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("員工編號請填數字.");
			}


			ProVO proVO = new ProVO();

			proVO.setProNo(proNo);
			proVO.setProName(proName);
			proVO.setProMean(proMean);
			proVO.setProPrice(proPrice);
			proVO.setProQty(proQty);
			proVO.setProImg(proImg); // 暫定空值
			proVO.setProCreateTime(proCreateTime);
			proVO.setProStatus(proStatus);
			proVO.setTagNo(tagNo);
			proVO.setEmpNo(empNo);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
req.setAttribute("proVO", proVO); // 含有輸入格式錯誤的proVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/pro/update_pro_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ProService proSvc = new ProService();
			proVO = proSvc.updateProduct(proNo, proName, proMean, proPrice, proQty, proImg, proCreateTime, proStatus,
					tagNo, empNo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("proVO", proVO); // 資料庫update成功後,正確的的proVO物件,存入req
			String url = "/pro/listOnePro.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOnePro.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addPro.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Part part = req.getPart("proImg");
	        InputStream inputStream = part.getInputStream();
	        byte[] proImg = inputStream.readAllBytes();
	        
	        
			//接收JSP上傳圖片File============================================================================
			
			
String proName = req.getParameter("proName");
String proNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (proName == null || proName.trim().length() == 0) {
				errorMsgs.add("商品名稱: 請勿空白");
			} else if (!proName.trim().matches(proNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String proMean = req.getParameter("proMean");
			if (proMean == null || proMean.trim().length() == 0) {
				errorMsgs.add("商品描述: 請勿空白");
			}

			int proPrice = 0; // 默認值
			try {
proPrice = Integer.parseInt(req.getParameter("proPrice").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("商品價格請填數字.");
			}

			int proQty = 0; // 默認值
			try {
proQty = Integer.parseInt(req.getParameter("proQty").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("商品數量請填數字.");
			}

			// 假設 proCreateTime 是單獨處理的，以字符串形式表示為 "yyyy-MM-dd HH:mm:ss"
			String proCreateTimeString = req.getParameter("proCreateTime");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime proCreateTime = LocalDateTime.parse(proCreateTimeString, formatter);

			int proStatus = 0; // 默認值
			try {
proStatus = Integer.parseInt(req.getParameter("proStatus").trim());

				// 限制只能是 0 或 1
				if (proStatus != 0 && proStatus != 1) {
					errorMsgs.add("商品狀態只能是 0 或 1.");
				}
			} catch (NumberFormatException e) {
				errorMsgs.add("商品狀態請填數字.");
			}

			int tagNo = 0; // 默認值
			try {
tagNo = Integer.parseInt(req.getParameter("tagNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("標籤編號請填數字.");
			}

			int empNo = 0; // 默認值
			try {
empNo = Integer.parseInt(req.getParameter("empNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("員工編號請填數字.");
			}

			
			


			ProVO proVO = new ProVO();

			proVO.setProName(proName);
			proVO.setProMean(proMean);
			proVO.setProPrice(proPrice);
			proVO.setProQty(proQty);
			proVO.setProImg(proImg); // 暫定空值  或是連接上面proImg  
			proVO.setProCreateTime(proCreateTime);
			proVO.setProStatus(proStatus);
			proVO.setTagNo(tagNo);
			proVO.setEmpNo(empNo);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
req.setAttribute("proVO", proVO); // 含有輸入格式錯誤的proVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/pro/addPro.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始新增資料 ***************************************/
			
			ProService proSvc = new ProService();
			proVO = proSvc.addProduct(proName, proMean, proPrice, proQty, proImg, proCreateTime, proStatus,
					tagNo, empNo);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/pro/listAllPro.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPro.jsp
			successView.forward(req, res);
		}

if ("delete".equals(action)) { // 來自listAllPro.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer proNo = Integer.valueOf(req.getParameter("proNo"));

			/*************************** 2.開始刪除資料 ***************************************/
			ProService proSvc = new ProService();
			proSvc.deleteProduct(proNo);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/pro/listAllPro.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
