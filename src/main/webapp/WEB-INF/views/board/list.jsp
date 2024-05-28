<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			#main_title {
			    font-family: 'Cafe24Moyamoya-Regular-v1.0';
			}
			#main_title2 {
				font-family: 'TTHakgyoansimUndongjangL';
			}
	        .form-row {
	            display: flex;
	            align-items: center;
	            justify-content: flex-start;
        	}
        	.form-row form {
        		display: flex;
        		width: 100%;
        	}
        	.form-row input[type="text"] {
        		flex-grow: 1;
        		margin-right: 10px;
        	}
    	    table {
	            width: 100%;
	        }
            .col-1 { width: 10%; }
	        .col-2 { width: 15%; }
	        .col-3 { width: 40%; }
	        .col-4 { width: 25%; }
	        .col-5 { width: 10%; }
		</style>
	</head>
	<body class="is-preload">

		<!-- Content -->
			<div id="content">
				<div class="inner">

					<!-- Post -->
						<article class="box post post-excerpt">
							<header>
								<h2 id="main_title">게시판</h2>
								<p id="main_title2">자유롭게 사용 가능한 게시판입니다.</p>
							</header>

	<div class="form-row">
		<form>
			<input type="text" name="search" value="${listRequestVO.search}" style="width:50%;"/>
			<input type="submit" name="search_button" value="검색" />
		</form>
	</div>
	<c:if test="${not empty listResponseVOList}">
	<br />
		<table>
			<thead>
				<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>입력일</th>
				<th>글 보기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listResponseVO" items="${listResponseVOList}">
					<tr>
						<td class="col-1">${listResponseVO.boardContSeq}</td>
                        <td class="col-2">${listResponseVO.board_id}</td>
                        <td class="col-3">${listResponseVO.title}</td>
                        <td class="col-4">${listResponseVO.insertDtFormat}</td>
                        <td class="col-5"><a href="/read/${listResponseVO.boardContSeq}">상세보기</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty listResponseVOList}">
		<br /><strong>검색 결과가 없습니다.</strong>
	</c:if>
	<br />
	<input type="button" onclick="location.href='/create'" value="글 작성"></input>





						</article>

<!-- 					Pagination
						<div class="pagination">
							<a href="#" class="button previous">Previous Page</a>
							<div class="pages">
								<a href="#" class="active">1</a>
								<a href="#">2</a>
								<a href="#">3</a>
								<a href="#">4</a>
								<span>&hellip;</span>
								<a href="#">20</a>
							</div>
							<a href="#" class="button next">Next Page</a>
						</div>
 -->
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