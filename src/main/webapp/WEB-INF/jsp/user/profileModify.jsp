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
			
			<div id="upNick" class="d-none" style="margin-top:20px;">
				<div class="d-flex justify-content-between">
					<div id="nickFrms" class="form-group has-feedback">
						 <input type="text" class="form-control" id="user_nm" placeholder="닉네임">
						 	
					</div>
					<p style="text-align:center;">
						<button type="button" class="btn btn-primary" id="nmChangeBtn" style="width:150px;">변경</button>
					</p>
				</div>
			</div>
			
			<p style="line-height: 38px;">
				<strong id="userInterest" class="ml-5">게살버거</strong>
				<button id="btnInterest" type="button" class="btn btn-default mr-4">관심분야 수정</button>
			</p>
			
			<div id="upInterest" class="d-none" style="margin-top:20px;">
				<div class="d-flex justify-content-between">
				<div id="interestFrms" class="form-group has-feedback">
					<select name="interest" id="user_interest" class="w-100 form-control">
						<option value="select">관심 요리 분야(선택)</option>
						<option value="main">메인반찬</option>
						<option value="soup">국/탕/찌개</option>
						<option value="dessert">디저트</option>
						<option value="noodle">면/만두</option>
						<option value="rice">밥/죽/떡</option>
						<option value="sauce">양념/소스/잼</option>
						<option value="west">양식</option>
						<option value="salad">샐러드</option>
						<option value="bread">스프/빵</option>
						<option value="tea">차/음료/술</option>
						<option value="others">기타</option>
					</select>	
			
				</div>	
				<p style="text-align:center;">
						<button type="button" class="btn btn-primary" id="interestChangeBtn" style="width:150px;">변경</button>
				</p>
				</div>
				
			</div>
			
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
				$('#userInterest').text(data.userInterest);
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
				, url : "/user/update-user-email"
				, data: {"beforeEmail": beforeEmail, "afterEmail": afterEmail}
				, success : function(data) {
					alert("변경 성공!");
				}
				, error : function(request, status, error) {
					alert("형편없이 이메일 변경 실패");
				}
			});
		});
		
		// 닉네임 수정 버튼 클릭 시
		$('#btnUpNickName').on('click', function() {
			if($('#upNick').hasClass('d-none')) { // 안 보일 때
				$('#upNick').removeClass('d-none');
			} else {
				$('#upNick').addClass('d-none');
			}
		});
		
		// 닉네임 변경 버튼 클릭 시
		$('#nmChangeBtn').on('click', function() {
	
			let beforeNickName = $('#userNickName').text();
			let afterNickName = $('#user_nm').val().trim();
			$.ajax({
				type:"post"
				, url : "/user/update-user-nickName"
				, data: {"beforeNickName":beforeNickName, "afterNickName":afterNickName}
				, success : function(data) {
					alert("닉네임 변경 성공!");
				}
				, error : function(request, status, error) {
					alert("형편없이 닉네임 변경 실패");
				}
			});
		});
		
		// 관심 분야 수정 버튼 클릭 시
		 $('#btnInterest').on('click', function() {
			 if($('#upInterest').hasClass('d-none')) {
				 $('#upInterest').removeClass('d-none'); 
			 } else {
				 $('#upInterest').addClass('d-none');
			 }
		 });
		
		// 관심 분야 변경 버튼 클릭 시
		$('#interestChangeBtn').on('click', function() {
			let beforeInterest = $('#userInterest').text();
			let afterInterest = $('#user_interest option:selected').text();
			
			$.ajax({
				type:"post"
				, url : "/user/update-user-interest"
				, data: {"beforeInterest":beforeInterest, "afterInterest":afterInterest}
				, success : function(data) {
					alert("관심분야 변경 성공!");
					location.reload();
				}
				, error : function(request, status, error) {
					alert("형편없이 관심분야 변경 실패");
				}
			});
		});
	});
</script>