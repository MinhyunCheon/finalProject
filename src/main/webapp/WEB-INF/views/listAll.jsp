<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"--%>
<%--@ page session="false"--%>

<%@include file="./include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border" align = "right">
					<select id="searchSel">
						<option value="subject">제목</option>
						<option value="content">내용</option>
						<option value="writer">작성자</option>
					</select>
					<input type="text" id="searchTxt" placeholder="검색어 입력">
					<input type="button" id="searchBtn" value="검색">
					<input type="button" id="registBtn" value="글쓰기">
					
				</div>
				
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">SEQ</th>
		<th>SUBJECT</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>

	<tbody id="tbody">
		<c:forEach items="${ list }" var="list">
			<tr>
				<td>${ list.seq }</td>
				<td><a href="read?seq=${ list.seq }
							&subject=${ list.subject }
							&content=${ list.content }
							&writer=${ list.writer }
							&regDate=${ list.regDate }
							&viewCnt=${ list.viewCnt }">
							${ list.subject }</a></td>
				<td>${ list.writer }</td>
				<td>${ list.regDate }</td>
				<td><span class="badge bg-red">${ list.viewCnt }</span></td>
			</tr>
		</c:forEach>
	</tbody>
	


</table>

				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
	$(document).ready(function() {
		$('#registBtn').click(function() {
			location.href = 'registForm';
		});
		
		$('#searchBtn').click(function() {
			$.ajax({
			    type : 'get', // 타입 (get, post, put 등등)
			    url : '/search', // 요청할 서버url
			    async : true, // 비동기화 여부 (default : true)
			    //headers : { // Http header
			    //  "Content-Type" : "application/json",
			    //  "X-HTTP-Method-Override" : "POST"
			    //},
			    //dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
			    data : { // 보낼 데이터 (Object , String, Array)
			    	condition : $('#searchSel').val()
			    	, searchText : $('#searchTxt').val()
			    },
			    success : function(result) { // 결과 성공 콜백함수
			    	$("#tbody").empty();
					trs = ""
					$.each(result , function(idx, obj) {
						trs +="<tr>"
						trs +="<td align=center>"+obj.seq+"</td>"
						trs +="<td><a href='read?seq="+obj.seq+
								"&subject="+obj.subject+
								"&content="+obj.content+
								"&writer="+obj.writer+
								"&regDate="+obj.regDate+
								"&viewCnt="+obj.viewCnt+"'>"
								+obj.subject+"</a></td>"
						trs +="<td align=center>"+obj.writer+"</td>"
						trs +="<td align=center>"+obj.regDate+"</td>"
						trs +="<td align=center>"+obj.viewCnt+"</td>"
						trs +="</tr>"
					})
					$("#tbody").html(trs);
			    },
			    error : function(request, status, error) { // 결과 에러 콜백함수
			        console.log(error)
			    }
			});
		});
	});
</script>

<%@include file="./include/footer.jsp"%>
