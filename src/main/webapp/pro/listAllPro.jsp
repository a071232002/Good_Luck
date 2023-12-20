<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>



<%
    ProService proSvc = new ProService();
    List<ProVO> list = proSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有商品資料 - listAllpro.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有商品資料 - listAllPro.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
    <th>商品編號</th>
    <th>商品名稱</th>
    <th>商品說明</th>
    <th>價格</th>
    <th>數量</th>
    <th>圖片</th>
    <th>建立時間</th>
    <th>狀態</th>
    <th>標籤編號</th>
    <th>員工編號</th>
    <th>修改</th>
    <th>刪除</th>
</tr>
<%@ include file="page1.file" %> 
<c:forEach var="proVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
    
    <tr>
        <td>${proVO.proNo}</td>
        <td>${proVO.proName}</td>
        <td>${proVO.proMean}</td>
        <td>${proVO.proPrice}</td>
        <td>${proVO.proQty}</td>
        
        
<td><img src="data:image/jpeg;base64,${proVO.proImgBase64}" alt="Product Image"   style="max-width: 200px; max-height: 200px;">
        
        
        <td>${proVO.proCreateTime}</td>
        <td>${proVO.proStatus}</td>
        <td>${proVO.tagNo}</td>
        <td>${proVO.empNo}</td>
        <td>
          <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pro/pro.do" style="margin-bottom: 0px;">
             <input type="submit" value="修改">
             <input type="hidden" name="proNo"  value="${proVO.proNo}">
             <input type="hidden" name="action" value="getOne_For_Update"></FORM>
        </td>
        <td>
          <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pro/pro.do" style="margin-bottom: 0px;">
             <input type="submit" value="刪除">
             <input type="hidden" name="proNo"  value="${proVO.proNo}">
             <input type="hidden" name="action" value="delete"></FORM>
        </td>
    </tr>
</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>