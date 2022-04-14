<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 웹 사이트</title>
<style type="text/css">
</style>
</head>
<body>
<c:choose>
	<c:when test="${commentResult == 'fail'}">
		<script>
			alert('비밀번호가 틀립니다.');
			history.back();
		</script>
	</c:when>
	<c:when test="${boardResult == 'success'}">
		<script>
			alert('게시물이 삭제되었습니다.');
			location.href='mainServlet?command=board_move&pageNumber=1';
		</script>
	</c:when>
	<c:when test="${boardResult == 'fail'}">
		<script>
			alert('비밀번호가 틀립니다.');
			history.back();
		</script>
	</c:when>
	<c:when test="${updateResult == 'fail'}">
		<script>
			alert('비밀번호가 틀립니다.');
			history.back();
		</script>
	</c:when>
	<c:when test="${modResult == 'success'}">
		<script>
			alert('회원정보 수정을 성공했습니다.');
			location.href='mainServlet?command=main_move';
		</script>
	</c:when>
	<c:when test="${modResult == 'fail'}">
		<script>
			alert('회원정보 수정에 실패했습니다.');
			location.href='mainServlet?command=main_move';
		</script>
	</c:when>
</c:choose>
</body>
</html>