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
        margin-top: 4%;
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
    .duplicateResult {
	    display: block; 
	    width: 100%; 
	    text-align: center; 
	    color: red;
	    font-weight: bold;
	}
     </style>
</head>
<body>
<div id="content">
	<div class="inner">
	
	<form id="registerForm" method="post" id='registerForm' action='/register' onsubmit="return validateForm()">
		<p class='pStyle'>
			<span class="textStyle">이름</span>
			<input type='text' name='name' class='inputStyle' autofocus/>
		</p>
		<p class='pStyle'>
		    <span class="textStyle">아이디</span>
		    <input type='text' name='id' id='id' class='inputStyle'/>
		    <button type='button' onclick='checkDuplicate();' class='buttonStyle'>중복확인</button>
		</p>
		<p id="duplicateResult" class="duplicateResult"></p>
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
			<input type='date' name='birth' class='inputStyle'/>
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
			<input type='submit' value="회원가입"/>
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
// 아이디 중복확인 : form 중복 사용이 안돼서 ajax 사용
function checkDuplicate() {
    var id = document.getElementById('id').value;
    
    // ajax 요청 생성
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/checkDuplicate', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) { // 성공
                var response = JSON.parse(xhr.responseText);
                var duplicateResultElement = document.getElementById('duplicateResult');
                if (response.isDuplicate) {
                    duplicateResultElement.textContent = '사용 가능한 아이디입니다.';
                } else {
                    duplicateResultElement.textContent = '중복된 아이디입니다.';
                }
            } else { // 실패
                console.error('Error: ' + xhr.status);
            }
        }
    };
    xhr.send('id=' + encodeURIComponent(id));
}

// 아이디 중복확인 했을 때만 회원가입이 성공하도록 
function validateForm() {
    var duplicateResultElement = document.getElementById('duplicateResult');
    if (duplicateResultElement.textContent === '사용 가능한 아이디입니다.') {
        return true; // 폼 제출 허용
    } else {
        alert('아이디 중복확인을 먼저 진행해주세요.');
        return false; // 폼 제출 차단
    }
}
</script>



</body>
</html>