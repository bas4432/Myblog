<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>board</title>

<script>
	$(document).on('click', '#btnList', function() {

		location.href = "${path}/board/getboardList";

	});

	$(document).on('click', '#btnUpdate', function() {

		$("#form").submit();

	});
</script>
</head>

<body>
	<article>

		<div class="container" role="main">
         
            <h2>board Content</h2>         
            
			<div class="bg-white rounded shadow-sm">

				<div class="board_title">
					<c:out value="${boardContent.title}" />
				</div>

				<div class="board_info_box">

					<span class="board_author"><c:out value="${boardContent.reg_id}" />,</span>
					<span class="board_date"><c:out value="${boardContent.reg_dt}" /></span>

				</div>

				<div class="board_content">${boardContent.content}</div>

				<div class="board_tag">
					TAG : <c:out value="${boardContent.tag}" />
				</div>

			</div>

            <div style="margin-top: 20px">

				<form role="form" id="form" action="${path}/board/getboardModify">
					<input type="hidden" name="bid" value="${boardContent.bid}">
				</form>

				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
				<!-- <button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button> -->
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
            </div>
		
		</div>
    </article>

</body>
</html>




