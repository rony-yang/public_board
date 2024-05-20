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
</style>
</head>
<body>
		<!-- Sidebar -->
			<div id="sidebar">

				<!-- Logo -->
					<h1 id="logo"><a href="#">게시판</a></h1>

				<!-- Nav -->
					<nav id="nav">
						<ul>
							<!-- <li class="current"><a href="#">Latest Post</a></li> -->
							<li><a href="#">게시판</a></li>
							<li><a href="#">회원가입</a></li>
							<li><a href="#">로그인</a></li>
						</ul>
					</nav>

				<!-- Search -->
					<section class="box search">
						<form method="post" action="#">
							<input type="text" class="text" name="search" placeholder="Search" />
						</form>
					</section>


<!-- 				Recent Posts
					<section class="box recent-posts">
						<header>
							<h2>Recent Posts</h2>
						</header>
						<ul>
							<li><a href="#">Lorem ipsum dolor</a></li>
							<li><a href="#">Feugiat nisl aliquam</a></li>
							<li><a href="#">Sed dolore magna</a></li>
							<li><a href="#">Malesuada commodo</a></li>
							<li><a href="#">Ipsum metus nullam</a></li>
						</ul>
					</section>

				Recent Comments
					<section class="box recent-comments">
						<header>
							<h2>Recent Comments</h2>
						</header>
						<ul>
							<li>case on <a href="#">Lorem ipsum dolor</a></li>
							<li>molly on <a href="#">Sed dolore magna</a></li>
							<li>case on <a href="#">Sed dolore magna</a></li>
						</ul>
					</section> -->


				<!-- Copyright -->
					<ul id="copyright">
						<li>&copy; Yang.</li>
						<br><li>개인 공부용으로 제작된 
						<br>페이지입니다.</li>
					</ul>

			</div>
</body>
</html>