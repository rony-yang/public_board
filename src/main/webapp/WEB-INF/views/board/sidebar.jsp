<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/fonts.css">
<style>
#logo, #logo a {
    font-family: 'Cafe24Moyamoya-Regular-v1.0';
}
#nav, .box, #copyright {
	font-family: 'HakgyoansimSantteutdotumL';
}
.logout-link {
    text-align: center;
    text-decoration: underline;
	margin-top: -20px;
	display: block;
    width: 100%;
    box-sizing: border-box;
    padding: 5px 0;
}
</style>
    <% if (request.getParameter("duplicate") != null) { %>
    	<script>
        	alert("이미 로그인 되어 있습니다.");
        </script>
    <% } %>
</head>
<body>
		<!-- Sidebar -->
			<div id="sidebar">

				<!-- Logo -->
					<h1 id="logo"><a href="/">게시판</a></h1>

				<!-- Nav -->
					<nav id="nav">
						<ul style="padding-bottom: 150%;">
							<!-- <li class="current"><a href="#">Latest Post</a></li> -->
							<li><a href="/">게시판</a></li>
							<li><a href="/register">회원가입</a></li>
							<li><a href="login">로그인</a></li>
						</ul>
					</nav>


					<%
					// 세션에서 로그인된 사용자 아이디 가져오기
					String loginId = (String) session.getAttribute("loginId");
					%>
			
					<% if (loginId != null && !loginId.isEmpty()) { %>
						<p style="text-align: center;"><%= loginId %> 님 로그인 중입니다.</p>
						<a href="/logout" class="logout-link">로그아웃</a>
					<% } else { %>
						<p style="text-align: center;">로그인 정보가 없습니다.</p>
					<% } %>

				<!-- Copyright -->
					<ul id="copyright">
						<li>&copy; Yang.</li>
						<br><li>개인 공부용으로 제작된 
						<br>페이지입니다.</li>
					</ul>

			</div>
</body>
</html>