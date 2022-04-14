<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 어느기기에서도 맞춤으로 보이는 반응형 웹에 사용되는 기본 메타태그 -->
<meta name="viewport" content="width-device-width", initial-scale="1"> 
<title>게시판 웹 사이트</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="row">
	<form method="post" action="mainServlet">
		<input type="hidden" name="command" value="view_update_event">
		<input type="hidden" name="boardid" value="${board.boardid }">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #eeeeee; text-align: center; font-size: 12pt;"><b>게시판 글수정</b></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50" value="${board.title }"></td>
				</tr>
				<tr>
					<td>
						<textarea class="form-control" placeholder="글 내용" name="content" maxlength="2048" style="height: 350px;">${board.content }</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-primary pull-right" value="수정하기"/>
	</form>
	</div>
</div>
</body>
</html>