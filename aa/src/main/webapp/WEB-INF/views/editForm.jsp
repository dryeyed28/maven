<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/edit.do" method="post">
<input type="text" name="name" value="${m.name }" 
readonly><br>
<input type="text" name="tel" value="${m.tel }" 
><br>
<input type="text" name="address" value="${m.address }" 
><br>
<input type="submit" value="수정">
</form>
</body>
</html>