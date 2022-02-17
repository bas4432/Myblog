<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>board</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">





<script>
	$(document).on('click', '#btnSave', function(e) {
		e.preventDefault();
		$("#form").submit();
	});

	$(document).on('click', '#btnList', function(e) {
		e.preventDefault();
		location.href = "${path}/board/getboardList";
	
	});
</script>
</head>

<body>

<article>

		<div class="container" role="main">
           <h2>board Form</h2>

			<form name="form" id="form" role="form" method="post" action="${path}/board/saveBoard">

				<div class="mb-3">
                   <label for="title">제목</label><input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
                </div>

                <div class="mb-3">
                   <label for="reg_id">작성자</label><input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요">
                </div>

                <div class="mb-3">
                    <label for="content">내용</label>
                    <textarea class="form-control" cols="30" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요"></textarea>
                </div>
                
                <div class="mb-3">
                   <label for="tag">TAG</label> <input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
                </div>
            </form>

            <div>		
                 <button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
                 <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
             </div>
         </div>
</article>
</body>
</html>




