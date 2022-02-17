<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>



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
		alert("수정저장 버튼")

		$("#form").submit();

	});
	
	$(document).on('click', '#btnDelete', function() {
		alert("수정삭제 버튼")
		
		
        $("#form").attr("action","${path}/board/deleteboard");
		$("#form").submit();

	});
</script>



</head>

<body>

	<article>

		<div class="container" role="main">

			<h2>board Content</h2>
         <form role="form" id="form" method="post" action="${path}/board/postboardModify">
                


			<div class="bg-white rounded shadow-sm">

				<div class="board_title">	
				 
				    <input type="hidden" name="bid" value="${boardContent.bid}"> 	
					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요" value="${boardContent.title}">
				
				</div>

				<div class="board_info_box">

					<span class="board_author"><c:out
							value="${boardContent.reg_id}" />,</span><span class="board_date"><c:out
							value="${boardContent.reg_dt}" /></span>

				</div>

				<input type="text" class="form-control" name="content" id="content" placeholder="제목을 입력해 주세요" value="${boardContent.content}">

				<div class="board_tag">
					TAG :
					<c:out value="${boardContent.tag}" />
				</div>

			</div>



			<div style="margin-top: 20px">

				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정저장</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>

			</div>
			
			</form>

		</div>



	</article>

</body>

</html>




