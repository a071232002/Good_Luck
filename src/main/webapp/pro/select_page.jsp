<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Pro: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Pro: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Pro: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllPro.jsp'>查詢 </a>   所有商品   <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="pro.do" >
        <b>輸入商品編號 (如1-9):</b>
        <input type="text" name="proNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="proSvc" scope="page" class="com.product.model.ProService" />
   
  <li>
     <FORM METHOD="post" ACTION="pro.do" >
       <b>選擇商品編號:</b>
       <select size="1" name="proNo">
         <c:forEach var="proVO" items="${proSvc.all}" > 
          <option value="${proVO.proNo}">${proVO.proNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="pro.do" >
       <b>選擇商品名:</b>
       <select size="1" name="proNo">
        <c:forEach var="proVO" items="${proSvc.all}" > 
          <option value="${proVO.proNo}">${proVO.proName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>商品新增</h3>

<ul>
  <li><a href='addPro.jsp'>新增</a>一個商品</li>
</ul>

</body>
</html>