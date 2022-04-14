<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 웹 사이트</title>
</head>
<body>
<c:if test="${userid != null}">
	<script>
	alert('이미 로그인 되어 있습니다.');
	location.href='main.jsp';
	</script>
</c:if>
<c:if test="${loginError != null }">
	<script>
	alert("${loginError}");
	</script>
</c:if>
<jsp:include page="nav.jsp"/>
<div class="container" style="width: 500px;">
	<div class="jumbotron" style="padding-top: 20px;">
		<form method="post" action="mainServlet" name="frm">
			<input type="hidden" name="command" value="login_event_action">
			<h3 style="text-align: center;">로그인</h3>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="아이디" name="userid" maxlength="20"/>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="비밀번호" name="userpw" maxlength="20"/>
			</div>	
			<input type="submit" class="btn btn-primary form-control" value="로그인" onclick="return idCheck()">
		</form>
	</div>

</div>
</body>
</html>