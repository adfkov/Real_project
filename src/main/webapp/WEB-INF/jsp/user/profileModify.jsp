<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="nav-etc d-flex justify-content-center align-items-center">
	<span class="nav-logo text-white font-weight-bold">회원 정보 수정</span>
</div>
	<div class="container-etc">
		<div class="panel-body etc-wrap">
			<p style="line-height: 38px;">
				<strong id="userEmail" class="ml-5">11</strong>
				<button id="btnUpEmail" type="button" class="btn btn-default mr-4">이메일 수정</button>
			</p>
		<div id="updEmail" class="d-none">
	          <div id="emailFrms" class="form-group has-feedback">
	            <input type="text" name="frm[pro_id_email]" class="form-control" id="id_email" placeholder="이메일">
	            <span id="emailStatus" class="glyphicon form-control-feedback" aria-hidden="true"></span>
	            <span id="emailMsg" style="display:none;"></span>
	          </div>
	          <p style="text-align:center"><button id="btnEmail" type="button" onclick="chkEmailSSL()" class="btn btn-primary" style="width:150px">변경</button></p>
	          <p class="help-block">변경 신청하시면 확인메일이 새로운 메일주소로 발송됩니다.<br>메일이 도착하지 않는다면 스팸편지함도 확인해 주세요.</p>
	            <input id="chkMA" type="checkbox" style="height:30px;margin:0 10px 0 20px;"><span style="vertical-align:top;">이벤트, 쇼핑 프로모션 메일 수신 동의 </span>
       </div>
			
			<p style="line-height: 38px;">
				<strong id="userNickName" class="ml-5">젲제</strong>
				<button id="btnUpNickName" type="button" class="btn btn-default mr-4">닉네임 수정</button>
			</p>
		</div>
	</div>
	
	
<script>
	$(document).ready(function() {
		// 페이지 로딩 시 db에서 정보 가져옴
		$.ajax({
			type:"post"
			, url: "/user/get-user-info"
			, data : {}
			, success : function(data) {
				$('#userEmail').text(data.userEmail);
				$('#userNickName').text(data.userNickName);
			}
			, error : function(request, status, error) {
				alert("형편없이 실패");
			}
		});
		
		// 이메일 수정 버튼 클릭 시
		$('#btnUpEmail').on('click', function() {
			if($('#updEmail').hasClass('d-none')) {
			$('#updEmail').removeClass("d-none");
			} else {
				$('#updEmail').addClass("d-none");
						
			}
		});
		
		// 이메일 변경 버튼 클릭 시
		$('#btnEmail').on('click', function() {
			let beforeEmail = $('#userEmail').text();
			let afterEmail = $('#id_email').val().trim();
			alert(afterEmail);
			$.ajax({
				type:"post"
				, url : "/user/update-user-info"
				, data: {"beforeEmail": beforeEmail, "afterEmail": afterEmail}
				, success : function(data) {
					alert("변경 성공!");
				}
				, error : function(request, status, error) {
					alert("형편없이 이메일 변경 실패");
				}
			})
		});
		
	});
</script>