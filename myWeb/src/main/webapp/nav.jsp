<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script src="js/bootstrap.js"></script>
<script type="text/javascript" src="script/empty.js"></script>
<title>게시판 웹 사이트</title>
<style type="text/css">
	li{
		margin-right: 15px;
		margin-left: 15px;
		text-align: center;
	}
</style>
</head>
<body>
<div class="container" style="text-align: center;">
	<a href="mainServlet?command=main_move"><img src="image/title.png"></a>
	<nav class="navbar navbar-default">
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="mainServlet?command=board_move&pageNumber=1" >자유게시판</a></li>
				<li><a href="#" >질문게시판</a></li>
				<li><a href="#" >갤러리</a></li>
				<li><a href="#" >일정</a></li>
			</ul>
			<c:if test="${userid == null}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">접속하기
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="mainServlet?command=login_move">로그인</a></li>
							<li><a href="mainServlet?command=join_move">회원가입</a></li>
						</ul>
					</li>
				</ul>
			</c:if>
			<c:if test="${userid != null }">
				<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-haspopup="true" aria-expanded="false">접속하기
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li>ID : ${userid }</li>
						<li><a href="mainServlet?command=logout_action">로그아웃</a></li>
						<li><a href="mainServlet?command=modification_move">회원정보수정</a></li>
					</ul>
				</li>
			</ul>	
			</c:if>			
		</div>
	</nav>
</div>
</body>
</html>