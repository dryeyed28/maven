<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>

<h3>로그인</h3>
<form action="${pageContext.request.contextPath }/member/login.do"
method="post">
id:<input type="text" name="id"><br>
pwd:<input type="password" name="pwd"><br>
<input type="submit" value="로그인">
<a href="${pageContext.request.contextPath }/member/form.do">
회원가입
</a>
<br>
</form>

</body>
</html>