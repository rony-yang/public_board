<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원가입</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="resources/css/main.css" />
   	<jsp:include page="/WEB-INF/views/board/sidebar.jsp" /> <!-- 사이드바 -->
   	<link rel="stylesheet" type="text/css" href="resources/css/fonts.css"> <!-- 폰트 -->
   	<style>
	#go_login {
	    font-family: 'TTHakgyoansimUndongjangL';
	}
     </style>
</head>
<body>
<div id="content">
	<div class="inner">
	
	<form method="post">
		<p>
			이름
			<input type='text' name='name'/>
		</p>
		<p>
			아이디
			<input type='text' name='id'/>
		</p>
		<p>
			비밀번호
			<input type='text' name='password'/>
		</p>
		<p>
			비밀번호 확인
			<input type='text' name='password_confirm'/>
		</p>
		<p>
			생년월일
			<input type='text' name='birth'/>
		</p>
		<p>
			주소
			<input type='text' name='address'/>
		</p>
		<p>
			휴대폰번호
			<input type='text' name='tel_number'/>
		</p>
		<p>
			<input type='submit' value="회원가입"/>
			<input type='reset' value="취소" onclick="window.location.reload();"/>
		</p>	
			<br>
		<p id='go_login'>아이디가 이미 있다면?&emsp;
			<input type="button" value="로그인하기" onclick="window.location.href = './login';">
		 </p>
	</form>

	</div>
</div>
</body>
</html>