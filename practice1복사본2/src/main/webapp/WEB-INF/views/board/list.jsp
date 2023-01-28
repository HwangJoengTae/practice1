<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<h1>목록페이지입니다.</h1>

	<div class="table_wrap">
		<a href="/board/enroll">게시판 등록</a>
		<table>
			<tr>
				<th class="bno_width">번호</th>
				<th class="title_width">제목</th>
				<th class="writer_width">작성자</th>
				<th class="regdate_width">작성일</th>
				<th class="updatedate_width">수정일</th>
			</tr>

			<c:forEach items="${list}" var="list">
				<tr>
					<td><c:out value="${list.bno}" /></td>
					<td> <a class="move" href='/board/get?bno=<c:out value="${list.bno}"/>'>
                        <c:out value="${list.title}"/>
                    </a>
                    </td>
					<td><c:out value="${list.writer}" /></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.regdate}" /></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.updateDate}" /></td>
				</tr>
			</c:forEach>


		</table>
	</div>
	<script>
		$(document).ready(function() {

			let result = '<c:out value="${result}"/>';

			checkAlert(result);

			function checkAlert(result) {

				if (result === '') {
					reutrn;
				}

				if (result === "enrol success") {
					alert("등록이 완료되었습니다.");
				}

			}

		});
	</script>
</body>
</html>