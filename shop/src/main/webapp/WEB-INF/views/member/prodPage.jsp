<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>prodPage.jsp</title>
</head>
<body>

<h3>판매자</h3>

<h4>내가 등록한 상품</h4>
<c:if test="${empty list }">
 등록된 상품이 없다.
 </c:if>
 <a href="${pageContext.request.contextPath }/seller/form.do">
 상품 등록 페이지로 이동</a><br>
 <c:if test="${not empty list }">
 <table border="1" cellspacing="0">
 <tr><th>num</th><th>name</th><th>설명</th><th>수량</th><th>가격</th>
 <th>대분류</th><th>중분류</th><th>소분류</th></tr>
 <c:forEach var="p" items="${list }">
 <tr>
 <td>${p.num }</td>
 <td><a href="${pageContext.request.contextPath }
 /seller/itemView.do?num=${p.num}&type=1">${p.name }</a></td>
 <td>${p.info }</td><td>${p.quantity }</td>
 <td>${p.price }</td><td>${p.category1_id }</td>
 <td>$Pp.category2_id</td><td>${p.category3_id }</td>
 </tr>
 </c:forEach>
 </table>
 </c:if>
</body>
</html>