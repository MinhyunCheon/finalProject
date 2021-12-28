<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" method="post" id="regist" action="regist">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Subject</label> 
			<input type="text" id="subject"
				name='subject' class="form-control" placeholder="Enter Subject">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" id="content" name="content" rows="3"
				placeholder="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> 
			<input type="text"
				name="writer" class="form-control" readonly value="${ user.id }">
		</div>
	</div>
	<!-- /.box-body -->

	<div class="box-footer" align="right">
		<button type="button" id="registBtn" class="btn btn-primary">등록</button>
	</div>
</form>

<script>
	$(document).ready(function() {
		$('#registBtn').click(function() {
			//$('#regist').find('input[type="text"]').each(function(idx, obj) {
			//	alert(obj.value);
			//});
			if($('#subject').val() == '') {
				alert("제목을 입력하세요.");
				return;
			}
			
			if($('#content').val() == '') {
				alert("내용을 입력하세요.");
				return;
			}
			
			$('#regist').submit();
		});
	});
</script>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="./include/footer.jsp"%>
