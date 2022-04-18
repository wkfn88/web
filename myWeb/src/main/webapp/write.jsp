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

<script type="text/javascript">
function boardCheck() {
	if(document.frm.title.value.length == 0 ) {
		alert("제목을 작성해주세요.");
		return false;
	}
	if(document.frm.id.value.length == 0 ) {
		alert("닉네임을 작성해주세요.");
		return false;
	}
	if(document.frm.boardpwd.value.length == 0 ) {
		alert("비밀번호를 작성해주세요.");
		return false;
	}
	if(document.frm.content.value.length == 0 ) {
		alert("내용을 작성해주세요.");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<form method="post" action="mainServlet" name="frm">
		<input type="hidden" name="command" value="write_event">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3" style="background-color: #eeeeee; text-align: center; font-size: 12pt;"><b>게시판 글쓰기</b></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:choose>
						<c:when test="${userid != null }">
							<td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50"></td>
						</c:when>
						<c:otherwise>
							<td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50"></td>
							<td style="width: 20%"><input type="text" class="form-control" placeholder="닉네임" name="id" maxlength="20"></td>
							<td style="width: 20%"><input type="password" class="form-control" placeholder="비밀번호" name="boardpwd" maxlength="20"></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</tbody>
		</table>
		<textarea id="content" name="content"></textarea>
		<input type="submit" class="btn btn-primary pull-right" value="게시글 등록" onclick="return boardCheck()"/>
	</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			//여기 아래 부분
			$('#content').summernote({
				height : 400, // 에디터 높이
				minHeight : null, // 최소 높이
				maxHeight : null, // 최대 높이
				focus : true, // 에디터 로딩후 포커스를 맞출지 여부
				lang : "ko-KR", // 한글 설정
				placeholder : '최대 2000자까지 쓸 수 있습니다', //placeholder 설정
				toolbar: [
					  ['style', ['style']],
					  ['font', ['bold', 'underline', 'clear']],
					  ['fontname', ['fontname']],
					  ['color', ['color']],
					  ['para', ['ul', 'ol', 'paragraph']],
					  ['table', ['table']],
					  ['insert', ['link', 'picture', 'video']]
					]
			});

		});
	</script>
</body>
</html>