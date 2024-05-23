<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
	Striped by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>자유로운 게시판</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="resources/css/main.css" />
    	<jsp:include page="/WEB-INF/views/board/sidebar.jsp" /> <!-- 사이드바 -->
    	<link rel="stylesheet" type="text/css" href="resources/css/fonts.css"> <!-- 폰트 -->
    	<style>
        .form-row {
            display: flex;
            align-items: center;
        }
        .form-row p {
            width: 15%;
            margin-bottom: 0;
        }
        .input1 {
            margin-right: 10%;
        }
    	</style>
	</head>
	<body class="is-preload">

		<!-- Content -->
			<div id="content">
				<div class="inner">

				<form method="post">
					<div class="form-row">
	            		<p>번호</p>
						<input class="input1" type="text" value="${nextSeqBoard}" style="width: 10%;" readonly >
			            <p>작성일</p>
			            <input class="input2" type="text" name="input_date" value="${serverTime}" readonly >
					</div>
					<br>
					<p>
						제목
						<input type='text' name='title'/>
					</p>
					<p>
						본문
					</p>
					<p>
						<!-- 10줄까지는 스크롤 없이 보여주기 -->
						<textarea rows="10" name="content_body" style='width:100%'></textarea>
					</p>
					<p>
						<input type='submit' value="글 작성"/>
						<input type='reset' value="취소" onclick="window.location.reload();"/>
						<input type="button" value="목록 돌아가기" onclick="window.location.href = '/';">
					</p>
				</form>


				</div>
			</div>



		<!-- Scripts -->
			<script src="resources/js/jquery.min.js"></script>
			<script src="resources/js/browser.min.js"></script>
			<script src="resources/js/breakpoints.min.js"></script>
			<script src="resources/js/util.js"></script>
			<script src="resources/js/main.js"></script>

	</body>
</html>