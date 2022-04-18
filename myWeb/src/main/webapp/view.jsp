<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 웹 사이트</title>
<script type="text/javascript">
	window.onload = function() {
		var recStatus = document.getElementById('recStatus');
		var recUp = document.getElementById('recUp');
		var recDown = document.getElementById('recDown');
		
		if( recStatus.value == 0 ) {
			recUp.style='background-color: rgb(235, 235, 235)';
			recDown.style='background-color: rgb(235, 235, 235)';
		}else if( recStatus.value == 1 ){
			recUp.style='background-color: lightblue';
			recDown.style='background-color: rgb(235, 235, 235)';
			recDown.disabled = false;
		}else if( recStatus.value == 2 ){
			recUp.style='background-color: rgb(235, 235, 235)';
			recDown.style='background-color: lightblue';
			recUp.disabled = false;
		}
	}
</script>
<script type="text/javascript">
function emptypwd() {
	if( document.frmCom.commentpwd.value.length == 0 ) {
		alert('비밀번호는 필수입니다.');
		return false;
	}
	
	if( document.frmCom.content.value.length == 0 ) {
		alert('댓글 내용은 비워둘 수 없습니다.');
		return false;
	}
	return true;
}

function pwdCheck(comnum) {
	document.frmComDel.comnum.value = comnum;
}

function pwdCheckUser(comnum) {
	document.frmComDelUser.comnum.value = comnum;
}

</script>
<style type="text/css">
table {
	width: 100%;
	border-top: 1px solid #dddddd;
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid #dddddd;
}

#cusbt {
	width: 110px;
	height: 32px;
}
</style>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<table class="table">
			<tbody>
				<tr>
					<td colspan="2" style="border: none;"><b
						style="font-size: 12pt"><c:out value="${board.title }"/></b></td>
				</tr>
				<tr>
					<td colspan="2" style="border-top: none;"><c:out value="${board.id }"/>
						&nbsp;|&nbsp; <c:out value="${board.boarddate }"/></td>
					<td style="border-top: none; text-align: right">조회수
						<c:out value="${board.viewcount }"/></td>
				</tr>
			</tbody>
		</table>
		
		<!-- 게시글 본문 구간 -->					
		<br><c:out value="${board.content}" escapeXml="false"/><br><br><br>
		
		<div style="text-align: center;">
			<input type="hidden" id="recStatus" value="${status }">
			<button type="button" id="recUp" class="btn" onclick="location.href='mainServlet?command=rec_event&status=1&boardid=${board.boardid}&id=${userid }';"><i class="bi bi-hand-thumbs-up" style="font-size: 20pt;">${statusUpCount }</i></button> &nbsp;
			<button type="button" id="recDown" class="btn" onclick="location.href='mainServlet?command=rec_event&status=2&boardid=${board.boardid}&id=${userid }';"><i class="bi bi-hand-thumbs-down" style="font-size: 20pt;">${statusDownCount }</i></button>
		</div>
		
		<br>
		<!-- 댓글구간 -->
		<table class="table" style="background-color: #FAFAFA;">
			<c:if test="${comment != null }">
				<c:forEach var="com" items="${comment }">
					<tr>
						<c:if test="${com.id == null }">
							<td style="width: 20%;">익명 사용자</td>
						</c:if>
						<c:if test="${com.id != null }">
							<td style="width: 20%;"><c:out value="${com.id }"></c:out></td>
						</c:if>
						<td style="width: 50%;"><c:out value="${com.content }"/></td>
						<td style="width: 30%; text-align: right;">${com.comdate }<c:choose>
								<c:when test="${userid != null }">
									<c:if test="${userid == com.id }">
										<a data-toggle="modal" data-target="#userModal" onclick="pwdCheckUser('${com.comnum}')">&nbsp;삭제</a>
									</c:if>
									<c:if test="${com.id == null }">
										<a data-toggle="modal" data-target="#myModal"
											onclick="pwdCheck('${com.comnum}')">&nbsp;삭제</a>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${com.id == null }">
										<a data-toggle="modal" data-target="#myModal" onclick="pwdCheck('${com.comnum}')">&nbsp;삭제</a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${comment == null }">
				<tr>
					<td>댓글이 없어요. 댓글을 작성해주세요!</td>
				</tr>
			</c:if>
		</table>
		
		<!-- 댓글 작성구간 -->
		<form method="post" action="mainServlet" name="frmCom">
			<input type="hidden" name="command" value="view_event_action">
			<input type="hidden" name="boardid" value="${board.boardid }">
			<table class="table"
				style="text-align: center; border: 1px solid #dddddd; border-collapse: collapse;">
				<tr>
					<c:choose>
						<c:when test="${userid != null }">
							<td><textarea name="content" class="form-control"
									placeholder="댓글을 입력해주세요." cols="140" maxlength="180"></textarea></td>
							<td><input type="submit" class="btn btn-primary"
								value="댓글작성" style="height: 50px;"></td>
						</c:when>
						<c:otherwise>
							<tr>
								<td rowspan="2"><textarea name="content"
										class="form-control" placeholder="댓글을 입력해주세요." cols="140"
										rows="3"></textarea></td>
								<td style="border-bottom: none;"><input type="password"
									name="commentpwd" class="form-control" placeholder="비밀번호"
									style="width: 110px; height: 30px;" maxlength="15"></td>
							</tr>
							<tr>
								<td style="border-top: none; padding-top: 0px; color: white;"><input
									type="submit" class="btn btn-primary" value="댓글작성" id="cusbt" maxlength="180"
									onclick="return emptypwd()"></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
		</form>

		
		<!--  게시판 삭제 수정 구간  -->
		<c:if test="${board.boardstatus == 1}">
			<c:if test="${userid != null}">
				<c:if test="${userid == board.id }">
					<a href="mainServlet?command=board_move&pageNumber=1" class="btn btn-primary" style="color: white;">목록</a>
					<a class="btn btn-primary" data-toggle="modal" data-target="#updateModal" style="color: white;">수정</a>
					<a class="btn btn-primary" data-toggle="modal" data-target="#boardModal" style="color: white;">삭제</a>
				</c:if>	
				<c:if test="${userid != board.id }">
					<a href="mainServlet?command=board_move&pageNumber=1" class="btn btn-primary" style="color: white;">목록</a>
				</c:if>
			</c:if>
			<c:if test="${userid == null}">
				<a href="mainServlet?command=board_move&pageNumber=1" class="btn btn-primary" style="color: white;">목록</a>
			</c:if>
		</c:if>
		
		<c:if test="${board.boardstatus == 0}">
			<a href="mainServlet?command=board_move&pageNumber=1" class="btn btn-primary" style="color: white;">목록</a>
			<a class="btn btn-primary" data-toggle="modal" data-target="#updateModal" style="color: white;">수정</a>
			<a class="btn btn-primary" data-toggle="modal" data-target="#boardModal" style="color: white;">삭제</a>
		</c:if>

	</div>
	<br>
	<br>

	<!--  댓글 삭제 모달 비회원   -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">댓글 삭제</h4>
				</div>
				<form method="post" action="mainServlet" name="frmComDel">
					<input type="hidden" name="boardid" value="${board.boardid }"> 
					<input type="hidden" name="comnum">
					<input type="hidden" name="command" value="comment_delete">
					<input type="hidden" name="rnum" value=" ">
					<div class="modal-body">
						<input type="password" class="form-control" name="deleteKey"
							placeholder="비밀번호 입력">
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="확인">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!--  댓글 삭제 모달 회원   -->
	<div class="modal fade" id="userModal" tabindex="-1" role="dialog"
		aria-labelledby="userModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">댓글 삭제 확인</h4>
				</div>
				<form method="post" action="mainServlet" name="frmComDelUser">
					<input type="hidden" name="boardid" value="${board.boardid }"> 
					<input type="hidden" name="comnum">
					<input type="hidden" name="command" value="comment_delete">
					<input type="hidden" name="rnum" value=" ">
					<div class="modal-body">
						<h5>댓글을 삭제합니까?</h5>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="확인">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 게시판 글 삭제, 수정 모달 -->
	<div class="modal fade" id="boardModal" tabindex="-1" role="dialog"
		aria-labelledby="boardModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<c:choose>
						<c:when test="${userid != null }">
							<h4 class="modal-title" id="myModalLabel">게시물 삭제 확인</h4>
						</c:when>
						<c:otherwise>
							<h4 class="modal-title" id="myModalLabel">게시물 비밀번호 확인</h4>
						</c:otherwise>
					</c:choose>
				</div>
				<form method="post" action="mainServlet" name="frmBoardDel">
					<input type="hidden" name="boardid" value="${board.boardid }"> 
					<input type="hidden" name="command" value="view_delete">
					<input type="hidden" name="rnum" value=" ">
					<div class="modal-body">
						<c:choose>
						<c:when test="${userid != null }">
							<h5 class="modal-title" id="myModalLabel">게시물을 삭제합니까?</h5>
						</c:when>
						<c:otherwise>
							<input type="password" class="form-control" name="deleteKey"
								placeholder="비밀번호 입력">
						</c:otherwise>
					</c:choose>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="확인">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!--  게시물 수정 모달  -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="updateModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<c:choose>
						<c:when test="${userid != null }">
							<h4 class="modal-title" id="myModalLabel">수정 확인</h4>
						</c:when>
						<c:otherwise>
							<h4 class="modal-title" id="myModalLabel">수정 비밀번호 확인</h4>
						</c:otherwise>
					</c:choose>
				</div>
				<form method="post" action="mainServlet" name="frmUpdate">
					<input type="hidden" name="boardid" value="${board.boardid }"> 
					<input type="hidden" name="command" value="view_update">
					<input type="hidden" name="rnum" value=" ">
					<div class="modal-body">
					<c:choose>
						<c:when test="${userid != null }">
							<h5 class="modal-title" id="myModalLabel">수정화면으로 이동합니까?</h5>
						</c:when>
						<c:otherwise>
							<input type="password" class="form-control" name="deleteKey"
								placeholder="비밀번호 입력">
						</c:otherwise>
					</c:choose>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="확인">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>