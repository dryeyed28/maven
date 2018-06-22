<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>joinForm.jsp</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		$("#idCheck").click(function(){
			$.post( "/shop/member/idCheck.do", { id: $("#id").val()})
			.done(function( data ) {
				$("#idResult").text(data);)
			})
		});
	});
	$("#join").click(function(){
		if($("#idResult").text().trim()=="사용가능") {
			$("form").submit();
		} else {
			alert("id 충복체크 먼저");
		}
	});
	});
</script>
</head>
<body>

<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/member/join.do"
method="post">
id: <input type="text" name="id" id="id">
<input type="button" id="idCheck" value="id 중복체크">
 <span id="idResult"></span><br>
 pwd:<input type="password" name="pwd"><br>
 name:<input type="text" name="name"><br>
 tel:<input type="text" name="tel"><br>
 address:<input type="text" name="address"><br>
 type:<input type="radio" name="type" value="1">구매자
 	  <input type="radio" name="type" value="2">판매자
 	  <input type="radio" name="type" value="3">관리자<br>
 <input type="reset" value="취소">
 <input type="button" value="가입" id="join"><br>
</form>

</body>
</html>