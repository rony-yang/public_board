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
	.pStyle {
        display: flex;
        align-items: center;
        margin-bottom: 4%;
	}
	.textStyle {
		align-items: center;
	    flex: 0 0 20%; /* 처음에 20%를 차지 */
	}
    .inputStyle {
    	flex: 1
     }
    .buttonStyle {
        margin-left: 4%;
        
    }
     </style>
</head>
<body>
<div id="content">
	<div class="inner">
	
	<form method="post" id='registerForm' action='/register'>
		<p class='pStyle'>
			<span class="textStyle">이름</span>
			<input type='text' name='name' class='inputStyle' autofocus/>
		</p>
		<p class='pStyle'>
			<span class="textStyle">아이디</span>
			<input type='text' name='id' class='inputStyle'/>
			<input type='button' value="중복확인" class='buttonStyle' onclick='checkDuplicate();'/>
		</p>
		<p class='pStyle'>
			<span class="textStyle">비밀번호</span>
			<input type='password' name='password' class='inputStyle'/>
		</p>
		<p class='pStyle'>
			<span class="textStyle">비밀번호 확인</span>
			<input type='password' name='password_confirm' class='inputStyle'/>
		</p>		
		<p class='pStyle'>
			<span class="textStyle">생년월일</span>
			<input type='text' name='birth' class='inputStyle'/>
		</p>		
		<p class='pStyle'>
			<span class="textStyle">주소</span>
			<input type='text' name='address' class='inputStyle'/>
		</p>		
		<p class='pStyle'>
			<span class="textStyle">휴대폰번호</span>
			<input type='text' name='tel_number' class='inputStyle'/>
		</p>		
		<p style='margin-top: 10%; text-align: center;'>
			<input type='submit' value="회원가입" onclick='goRegister();'/>
			<input type='reset' value="취소" onclick="window.location.reload();"/>
		</p>	
			<br>
		<p id='go_login' style='text-align: center;'>아이디가 이미 있다면?&emsp;
			<input type="button" value="로그인하기" onclick="window.location.href = './login';">
		 </p>
	</form>

	</div>
</div>


<script>
// 아이디 중복확인
function checkDuplicate() {
    document.getElementById('registerForm').action = "/checkDuplicate";
    document.getElementById('registerForm').submit();
}
    
// 회원가입
function goRegister() {
    document.getElementById('registerForm').action = "/register";
    document.getElementById('registerForm').submit();
}
</script>


</body>
</html>