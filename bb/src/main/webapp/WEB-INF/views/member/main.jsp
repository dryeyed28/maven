<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main.jsp</title>
</head>
<body>

${sessionScope.id }님 로그인 상태
<a hef="${pageContext.request.contextPath }/member/editForm.do">내정보수정</a>
<a hef="${pageContext.request.contextPath }/member/logout.do">로그아웃</a>
<a hef="${pageContext.request.contextPath }/member/out.do">탈퇴</a><br>
<a hef="${pageContext.request.contextPath }/img/list.do">이미지 게시판</a><br>
<a hef="${pageContext.request.contextPath }/down/list.do">자료실</a><br>
<a hef="${pageContext.request.contextPath }/board/list.do">게시판</a>

</body>
</html>