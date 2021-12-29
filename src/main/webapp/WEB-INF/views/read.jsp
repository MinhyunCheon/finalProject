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

	<input type='hidden' id='seq' name='seq' value="${ bbs.seq }">

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
<!-- 20211229 reply form -->
<div class="row">
	<div class="col-md-12">
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>
			<div class="box-body">
				<label for="exampleInputEmail1">Writer</label>
				<input class="form-control" type="text" placeholder="USER ID"    id="rWriter" value="${ user.id }">
				<label for="exampleInputEmail1">Reply Text</label>
				<input class="form-control" type="text" placeholder="REPLY TEXT" id="rContent">
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="button" class="btn btn-primary" id="replyBtn">ADD REPLY</button>
			</div>
		</div>
	
	<!-- The time line -->
	<ul class="timeline">
	  	<!-- timeline time label -->
		<li class="time-label" id="repliesDiv">
		  <span class="bg-green">
		    Replies List <small id='replycntSmall'> [ 000 ] </small>
		  </span>
		</li>
	</ul>
	<!--  -->
	<ul id="rList">
			<c:forEach items="${rList}" var="reply">
				
				<li class="time-label">${ reply.rWriter }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${ reply.rContent }
				</li>
			</c:forEach>
	</ul>
	<!--  -->
		<div class='text-center'>
			<ul id="pagination" class="pagination pagination-sm no-margin ">
			</ul>
		</div>
	</div>
	<!-- /.col -->
</div>
<!-- /.row -->



<script>
	$(document).ready(function(){
		// 20211229, 회원인 경우 relpy id 고정
		if('${user.id}' != '') $('#rWriter').attr('readonly', true);
		
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
		$('#replyBtn').click(function() {
			if($('#rWriter').val() == '') {
				alert('댓글 작성자를 입력해주세요.');
				return;
			}
			
			if($('#rContent').val() == '') {
				alert('댓글 내용을 입력해주세요.');
				return;
			}
			
			
			$.ajax({
			    type : 'post', // 타입 (get, post, put 등등)
			    url : '/replyBbs', // 요청할 서버url
			    async : true, // 비동기화 여부 (default : true)
			    //headers : { // Http header
			    //  "Content-Type" : "application/json",
			    //  "X-HTTP-Method-Override" : "POST"
			    //},
			    //dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
			    data : { // 보낼 데이터 (Object , String, Array)
			    	seq : $('#seq').val()
			    	, rWriter : $('#rWriter').val()
			    	, rContent : $('#rContent').val()
			    },
			    success : function(result) { // 결과 성공 콜백함수
			    	uls = ""
						$.each(result , function(idx, obj) {
							uls +="<li class='time-label'>"+ obj.rWriter + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							uls += obj.rContent
							uls +="</li>"
						})
						$("#rList").html(uls);
			    },
			    error : function(request, status, error) { // 결과 에러 콜백함수
			        console.log(error)
			    }
			});
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
