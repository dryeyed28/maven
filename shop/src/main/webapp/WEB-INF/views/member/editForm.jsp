<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editForm.jsp</title>
</head>
<body>

<h3>내 정보 수정</h3>
<form action="${pageContext.request.contextPath }/member/edit.do"
method="post">
id:<input type="text" name="id" value="${m.id }" readonly><br>
pwd:<input type="password" name="pwd" value="${m.pwd }"><br>
name:<input type="text" name="name" value="${m.name }"><br>
tel:<input type="text" name="tel" value="${m.tel }"><br>
address:<input type="text" name="address" value="${m.address }"><br>
type:
<c:choose>
	<c:when test="${m.type==1 }">구매자</c:when>
	<c:when test="${ }"
</form>

</body>
</html>