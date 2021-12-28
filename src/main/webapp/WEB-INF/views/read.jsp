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
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

	<input type='hidden' name='seq' value="${ bbs.seq }">

	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Subject</label> <input type="text"
				name='subject' class="form-control" value="${ bbs.subject }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content" rows="3"
				readonly="readonly">${ bbs.content }</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> <input type="text"
				name="writer" class="form-control" value="${ bbs.writer }"
				readonly="readonly">
		</div>
	</div>


<!-- /.box-body -->

<div class="box-footer" align="right">
	<button type="button" id="modifyFormBtn" class="btn btn-warning">수정</button>
	<button type="button" id="deleteBtn" class="btn btn-danger">삭제</button>
	<button type="button" id="listAllBtn" class="btn btn-primary">목록</button>
</div>


<script>
	$(document).ready(function(){
		$('#listAllBtn').click(function() {
			location.href = 'listAll';
		});
		
		$('#deleteBtn').click(function() {
			if(authValidation() && confirm('해당 글을 삭제합니다.')) location.href = 'deleteBbs?seq=' + ${ bbs.seq } + '&writer=' + '${ bbs.writer }';
		});
		
		$('#modifyFormBtn').click(function() {
			if(authValidation()) {
				location.href = 'modifyForm?seq=' + ${bbs.seq}
								+ '&subject=' + '${bbs.subject}'
								+ '&content=' + '${bbs.content}'
								+ '&writer=' + '${bbs.writer}';
			}
		});
		
		function authValidation() {
			if('${bbs.writer}' != '${user.id}') {
				alert('권한이 없습니다.');
				if('${user.id}'.length == 0)location.href = 'sign-in';
				return false;
			}
			
			return true;
		}
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
