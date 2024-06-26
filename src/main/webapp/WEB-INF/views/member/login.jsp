<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>로그인</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="resources/css/main.css" />
   	<jsp:include page="/WEB-INF/views/board/sidebar.jsp" /> <!-- 사이드바 -->
   	<link rel="stylesheet" type="text/css" href="resources/css/fonts.css"> <!-- 폰트 -->
   	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   	<style>
 	#go_register {
	    font-family: 'TTHakgyoansimUndongjangL';
	}
	.pStyle {
        display: flex;
        align-items: center;
        margin-bottom: 4%;
	}
	.textStyle {
		width: 40%;
	}
    .inputStyle {
    	width: 60%;
     }
    #content {
        display: flex;
        justify-content: center;
        align-items: center;
    }
     </style>
</head>
<body>
<div id="content">
	<div class="inner">
	
    <%-- 아이디, 비밀번호 확인 창 
    <% if (request.getParameter("error") != null) { %>
        <script>
            alert("아이디 또는 비밀번호가 잘못되었습니다.");
        </script>
    <% } %> --%>
    
    <c:if test="${not empty error}">
	    <script>
	        alert("${error}");
	    </script>
	</c:if>
	
	<form method="post" action="/login">

		<p class='pStyle'>
			<span class="textStyle">아이디</span>
			<input type='text' name='login_id' class='inputStyle'  value="${login_id != null ? login_id : ''}" autofocus/>
		</p>
		<p class='pStyle'>
			<span class="textStyle">비밀번호</span>
			<input type='password' name='login_password' class='inputStyle'/>
		</p>

		<p style='margin-top: 10%; text-align: center;'>
			<input type='submit' value="로그인"/>
			<input type='reset' value="취소" onclick="window.location.reload();"/>
		</p>	
			<br>
		<p id='go_register' style='text-align: center;'>아이디가 없다면?&emsp;
			<input type="button" value="회원가입하기" onclick="window.location.href = './register';">
		 </p>
	</form>

	</div>
</div>
</body>
</html>