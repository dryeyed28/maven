<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main.jsp</title>
</head>
<body>

${sessionScope.id }님 로그인 상태
<a href="${pageContext.request.contextPath }/member/editForm.do">내정보수정</a>
<a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a>
<a href="${pageContext.request.contextPath }/member/out.do">탈퇴</a>
<c:set var="url">/seller/allList.do</c:set>
<c:if test="${not empty url2 }">
	<c:set var="url" value="${url2 }"/>
</c:if>
<c:if test="${sessionScope.type==1 }">
	<c:set var="path" value="${url1 }"/>
</c:if>
<c:if test=${sessionScope.type==2 }">
	<c:set var="path"
	value="/seller/myList.do"/>
</c:if>
<c:if test="${sessionScope.type==3 }">
	<c:set var="path"
	value="/member/adminPage.do"/>
</c:if>
<c:import url="${path }"></c:import>

</body>
</html>