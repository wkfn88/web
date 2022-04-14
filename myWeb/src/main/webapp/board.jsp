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
<jsp:include page="nav.jsp"/>
<div class="container">
	<div>
		<table class="table" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center; width: 8%;">번호</th>
					<th style="background-color: #eeeeee; text-align: center; width: 50%;">제목</th>
					<th style="background-color: #eeeeee; text-align: center; width: 12%;">작성자</th>
					<th style="background-color: #eeeeee; text-align: center; width: 22%;">작성일</th>
					<th style="background-color: #eeeeee; text-align: center; width: 8%;">조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:choose>
						<c:when test="${boardList == null }">
							<tr>
								<td colspan="5">글이 존재하지 않아요. 글을 작성해주세요!</td>
							</tr>
						</c:when>
						<c:otherwise>			
							<c:forEach var="board" items="${boardList }">
								<tr>
									<td><a href="mainServlet?command=view_move&boardid=${board.boardid }"><c:out value="${board.boardid }"/></a></td>
									<td style="width: 50%;"><a href="mainServlet?command=view_move&boardid=${board.boardid }"><c:out value="${board.title} [${board.commentsize }]"/></a></td>
									<td><c:out value="${board.id }"/></td>
									<td><c:out value="${board.boarddate }"/></td>
									<td><c:out value="${board.viewcount }"/></td>
								</tr>
							</c:forEach>			
						</c:otherwise>
					</c:choose>
			</tbody>
		</table>
		<div>
			<table style="width: 100%">
				<tr>
					<td style="text-align: right; width: 36%;">
						<c:if test="${pageNumber != 1 }">
						<a href="mainServlet?command=board_move&pageNumber=${pageNumber - 1 }"><i style="font-size: 18pt;" class="bi bi-chevron-double-left"></i></a>
						</c:if>
					</td>
					<td style="text-align: center; width: 14%; font-family: Serif; font-size: 14pt;">${pageNumber } page of ${pageCount }</td>
					<td style="text-align: left; width: 26%;">
						<c:if test="${next != null}">
						<a href="mainServlet?command=board_move&pageNumber=${next }"><b><i style="font-size: 18pt;" class="bi bi-chevron-double-right"></i></b></a>
						</c:if>
					</td>
					<td style="width: 10%;">
						<a href="mainServlet?command=write_move" class="btn btn-primary pull-right" style="color: white;">글쓰기 <i class="bi bi-vector-pen"></i></a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
</body>
</html>