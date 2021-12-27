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
				<div class="box-header with-border">
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
	});
</script>

<%@include file="./include/footer.jsp"%>
