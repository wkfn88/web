<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.member.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	//특수문자 입력 방지
	function characterCheck(obj) {
		var regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
		//허용할 특수문자는 여기서 삭제
		//띄어쓰기도 특수문자 처리
		if (regExp.test(obj.value)) {
			alert("특수문자는 입력하실수 없습니다.");
			obj.value = obj.value.substring(0, obj.value.length - 1); // 입력한 특수문자 한자리 지움
		}
	}

	function idSearch() {
		if (document.frm1.id.value.length == 0) {
			alert('아이디를 입력해주세요.');
			return false;
		}
	}

	function check() {
		if (document.frm1.id.value.length == 0) {
			alert('아이디를 입력해주세요.');
			return false;
		}

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
			<h3 style="text-align: center;">회원가입</h3>
			<form method="post" action="mainServlet" name="frm1">
				<input type="hidden" name="command" value="search_id">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="id"
						maxlength="20" onkeydown="characterCheck(this)">
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary form-control"
						value="아이디 중복체크" onclick="return idSearch()">
				</div>
			</form>
			<form method="post" action="mainServlet" name="frm2">
				<input type="hidden" name="command" value="join_event">
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호"
						name="pwd" maxlength="20" />
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름"
						name="name" maxlength="20" onkeydown="characterCheck(this)"/>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이메일"
						name="email" maxlength="20" />
				</div>
				<input type="submit" class="btn btn-primary form-control"
					value="회원가입" onclick="return check()" />
			</form>
		</div>
	</div>
</body>
</html>