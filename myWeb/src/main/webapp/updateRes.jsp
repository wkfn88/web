<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.member.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		if (document.frm2.pwd.value.length == 0) {
			alert('비밀번호를 입력해주세요.');
			return false;
		}

		if (document.frm2.name.value.length == 0) {
			alert('이름을 입력해주세요.');
			return false;
		}

		if (document.frm2.email.value.length == 0) {
			alert('이메일을 입력해주세요.');
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container" style="width: 500px">
		<div class="jumbotron" style="padding-top: 20px">
			<h3 style="text-align: center;">회원정보 수정</h3>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="아이디" name="id"
					maxlength="20" value="${member.id }" readonly>
			</div>
			<form method="post" action="mainServlet" name="frm2">
				<input type="hidden" name="command" value="modification_event">
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호"
						name="pwd" maxlength="20" value="${member.pwd }"/>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름"
						name="name" maxlength="20" value="${member.name }"/>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이메일"
						name="email" maxlength="20" value="${member.email }"/>
				</div>
				<input type="submit" class="btn btn-primary form-control"
					value="정보수정" onclick="return check()" />
			</form>
		</div>
	</div>
</body>
</html>