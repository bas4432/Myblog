<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
$(document).ready(function(){ 
	$("#btnWriteForm").on("click" ,function(){
		self.location = "${path}/board/boardForm"
	})
});

function fn_contentView(bid){
	
	var url = "${path}/board/getboardContent";
	url = url + "?bid="+ bid;
	location.href = url;

}

//이전 버튼 이벤트
function fn_prev(page, range, rangeSize) {
	
	    var page = ((range - 2) * rangeSize) + 1;
        
	    var range = range - 1;

		var url = "${path}/board/getboardList";

		url = url + "?page=" + page;

		url = url + "&range=" + range;

		location.href = url;

}

//페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	
	var url = "${path}/board/getboardList";

	url = url + "?page=" + page;

	url = url + "&range=" + range;

    location.href = url;	
}


//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {
	
	var page = parseInt((range * rangeSize)) + 1;

	var range = parseInt(range) + 1;

	var url = "${path}/board/getboardList";

	url = url + "?page=" + page;

	url = url + "&range=" + range;

	location.href = url;

}

//검색 버튼 이벤트
$(document).on('click', '#btnSearch', function(e){

	e.preventDefault();

	var url = "${path}/board/getboardList";

	url = url + "?searchType=" + $('#searchType').val();

	url = url + "&keyword=" + $('#keyword').val();

	location.href = url;

	console.log(url);

});	

</script>
</head>

<body>

	<h2>게시글 목록</h2>

	<table>
		<colgroup>

			<col style="width: 5%;" />
			<col style="width: auto;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
		</colgroup>

		<thead>

			<tr>
				<th>NO</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>

		</thead>

		<tbody>
            <c:choose>

				<c:when test="${empty boardList }">
					<tr>
						<td colspan="5" align="center">데이터가 없습니다.</td>
					</tr>
    			</c:when>

				<c:when test="${!empty boardList}">
					<c:forEach var="list" items="${boardList}">
						<tr>

							<td><c:out value="${list.bid}" /></td>
							<td><a href="#" onClick="fn_contentView(<c:out value="${list.bid}"/>)"> 
							<c:out value="${list.title}" /></a>
							</td>
							<td><c:out value="${list.title}" /></td>
							<td><c:out value="${list.reg_id}" /></td>
							<td><c:out value="${list.view_cnt}" /></td>
							<td><c:out value="${list.reg_dt}" /></td>

						</tr>
                    </c:forEach>
                 </c:when>
             </c:choose>
         </tbody>
	</table>

	<div>
        <button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
    </div>

	<div id="paginationBox">
		<ul class="pagination">

			<c:if test="${pagination.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
            </c:if>

			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">

				<li class="page-link" href="#" class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
            
            </c:forEach>

			<c:if test="${pagination.next}">

				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a></li>

			</c:if>
         </ul>
     </div>

    <!-- pagination{e} -->

	<!-- search{s} -->

    <div class="form-group row justify-content-center">

		<div class="w100" style="padding-right: 10px">
			<select class="form-control form-control-sm" name="searchType" id="searchType">
				<option value="title">제목</option>
				<option value="content">본문</option>
				<option value="reg_id">작성자</option>
			</select>
	    </div>

	    <div class="w300" style="padding-right: 10px">
		    <input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
        </div>

	    <div>
		    <button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
        </div>
    </div>

	<!-- search{e} -->

</body>

</html>

















