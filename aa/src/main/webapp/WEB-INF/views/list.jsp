<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="m" items="${datas }">
name : <a href="${pageContext.request.contextPath }/search.do?name=${m.name }"> 
${m.name }</a>, tel : ${m.tel }, 
address : ${m.address }
<a href="${pageContext.request.contextPath }/del.do?name=${m.name }"> 
delete</a>
<br>
</c:forEach>
</body>
</html>