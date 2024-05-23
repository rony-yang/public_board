<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!--
	Striped by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>글 세부 내용 읽기</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/css/main.css" />
    	<jsp:include page="/WEB-INF/views/board/sidebar.jsp" /> <!-- 사이드바 -->
    	<link rel="stylesheet" type="text/css" href="/resources/css/fonts.css"> <!-- 폰트 -->
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
						<input class="input1" type="text" value="${boardContent.SEQ_BOARD}" style="width: 10%;" readonly >
			            <p>작성일</p>
						<input class="input2" type="text" name="input_date" value="<fmt:formatDate value='${boardContent.BOARD_DATE}' pattern='yyyy년 MM월 dd일 EEEE' />" readonly>
					</div>
					<br />
						<div class="form-row">
	            		<p>작성자 아이디</p>
						<input type="text" value="${boardContent.BOARD_ID}" readonly >
					</div>
					<br>
					<p>
						제목
						<input type='text' name='title' value="${boardContent.TITLE}"/>
					</p>
					<p>
						본문
					</p>
					<p>
						<textarea rows="10" name="content_body" style='width:100%'>${boardContent.CONTENTS}</textarea>
					</p>
					<p>
						<input type='submit' value="수정하기"/>
						<input type="button" value="목록 돌아가기" onclick="window.location.href = '/';">
					</p>
					<div>
					</div>
				</form>
				<form method="post" action="/delete">
					<input type="hidden" name = "_method" value = "delete"/>
					<input type="hidden" name = "boardContSeq" value = "${boardContent.SEQ_BOARD}"/>
					<input type="submit" name="delete_button" value="삭제" style="background-color: #c94663;" />
				</form>

				</div>
			</div>



		<!-- Scripts -->
			<script src="/resources/js/jquery.min.js"></script>
			<script src="/resources/js/browser.min.js"></script>
			<script src="/resources/js/breakpoints.min.js"></script>
			<script src="/resources/js/util.js"></script>
			<script src="/resources/js/main.js"></script>


	</body>
</html>