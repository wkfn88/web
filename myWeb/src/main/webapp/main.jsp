<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 웹 사이트</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="jumbotron">
		<h1>웹사이트 소개</h1>
		<p>게시판 테스트용으로 제작된 JSP 웹 사이트 입니다.</p>
		<a href="mainServlet?command=board_move&pageNumber=1" class="btn btn-primary btn-pull" role="button" style="color: white;">글쓰러 가기</a>
	</div>
</div>
</body>
</html>