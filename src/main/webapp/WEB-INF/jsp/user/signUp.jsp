<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="main d-flex justify-content-center">
	<div class="sign-up-box">
		<h1 class="m-4 font-weight-bold">회원가입</h1>
		<form id="signUpForm" method="post" action="/user/sign-up">
			
			<%-- 인풋 옆에 중복확인 버튼을 옆에 붙이기 위해 div 만들고 d-flex --%>
			<div class="ml-3 mt-3">
			<span class="sign-up-subject mr-4">ID</span>
				<div class="d-flex w-100">
				<input type="text" id="loginId" name="loginId" class="form-control col-6" placeholder="ID를 입력해주세요">
				<button type="button" id="loginIdCheckBtn" class="btn btn-success ml-2">중복확인</button>
				</div>
			</div>

			<%-- 아이디 체크 결과 --%>
			<div class="ml-3 mb-3">
				<div id="idCheckLength" class="small text-danger d-none">ID를 4자 이상 입력해주세요.</div>
				<div id="idCheckDuplicated" class="small text-danger d-none">이미 사용중인 ID입니다.</div>
				<div id="idCheckOk" class="small text-success d-none">사용 가능한 ID 입니다.</div>
			</div>

			
			<div class="m-3">
			<span class="sign-up-subject">password</span>
				<input type="password" name="password" id="password" class="form-control col-6" placeholder="비밀번호를 입력하세요">
			</div>

			
			<div class="m-3">
			<span class="sign-up-subject">비밀번호 확인</span>
				<input type="password" name="confirmPassword" id="confirmPassword" class="form-control col-6" placeholder="비밀번호를 입력하세요">
			</div>

			<span class="sign-up-subject">이름</span>
			<div class="m-3">
				<input type="text" name="name" id="name" class="form-control col-6" placeholder="이름을 입력하세요">
			</div>

			
			<span class="sign-up-subject">이메일</span>
			<div class="m-3">
				<input type="text" name="email" id="email" class="form-control col-6" placeholder="이메일을 입력하세요">
			</div>
			
			<div class="nickname">
				<span class="sign-up-subject">닉네임</span>
				<div class="m-3 d-flex">
					<input type="text" id="nickName" name="nickName" class="form-control col-6" placeholder="닉네임을 입력하세요">
					<button type="button" id="nickNameCheckBtn" class="btn btn-success ml-2">중복확인</button>
				</div>
			</div>
			<!--  닉네임 체크  -->
			<div class="ml-3 mb-3">
				<div id="nickNameCheckLength" class="small text-danger d-none">닉네임을 2글자 이상 입력해주세요.</div>
				<div id="nickNameCheckDuplicated" class="small text-danger d-none">이미 사용중인 닉네임입니다.</div>
				<div id="nickNameCheckOk" class="small text-success d-none">사용 가능한 닉네임 입니다.</div>
			</div>
		
			<!--  회원 등급 -->
			<span class="sign-up-subject">회원 등급</span>
			<div class="grade ml-3 mb-3">
				<input type="text" name="grade" id="grade" class="form-control" placeholder="새싹" readonly>
			</div>
			
			<!--  프로필 이미지 -->
			<span class="sign-up-subject">프로필 이미지</span>
			<div class="ml-3 mb-3" id="profileImage">
				<!--< img src="#" alt="profile" id="profile" width="200" height="200"> -->
			</div>
			
			<div class="file-upload d-flex">
			<%-- file 태그를 숨겨두고 이미지를 클릭하면 file 태그를 클릭한 효과 --%>
			<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg" class="d-none" onchange="setThumbnail(event);">
				<a href="#" id="fileUploadBtn"><img width="35" src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"></a>
			
			<%-- 업로드된 임시 파일명 노출 --%>
			<div id="fileName" class="ml-2"></div>
			</div>
			
		<!--  생년월일 -->
			<span class="sign-up-subject">생년월일</span>
			<div class="ml-3 mb-3">
				<input type="text" name="birth" id="birth" class="form-control col-6" placeholder="생일">
			</div> 

			<!--  성별 -->
		<span class="sign-up-subject">성별</span>
			<div class="ml-3 mb-3">
				<select name="userGender" id="userGender" class="form-control col-3">
					<option value="male">남성</option>
					<option value="female">여성</option>
				</select>
			</div>
			
			<!--  관심 요리 분야 -->
			<label for="interest">관심 요리 분야</label>
			<select name="interest" id="interest" class="form-control ml-3 mb-3">
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

			<br>
			<div class="d-flex justify-content-center ml-3 mb-3">
				<button type="submit" id="signUpBtn" class="btn btn-info">가입하기</button>
			</div>
		</form>
		</div>
</div>

<script>
	$(document).ready(function() {
		
	
	/* 	$( "#datepicker" ).datepicker();
	 */	   
		$('#fileUploadBtn').on('click', function(e) {
			e.preventDefault();
			$('#file').click();
		});
	 	
	
	 
	 	$('#file').on('change', function(e) {
	 		// 확장자
	 		let ext = fileName.split(".").pop().toLowerCase();
	 		
	 		if(ext != 'jpg' && ext != 'gif'&& ext != 'png'&& ext != 'jpeg') {
	 			alert("이미지 파일만 올려주세요!");
	 			$('#file').val("");
	 			$('#fileName').text("");
	 			return;
	 		} else {
	 			setThumbnail(event);
	 			/* $('#fileName').text(fileName);
	 			$('#profile').attr('src', $('#file').files[0]); */
	 		}
	 	});
	 
		$('#loginId').mousedown(function()  {
			
		
			let loginId = $('#loginId').val().trim();
			
			if(loginId.length < 4) {
				$('#idCheckLength').removeClass('d-none');
			} else {
				$('#idCheckLength').addClass('d-none');

			}
			if(loginId.length == 0) {
				$('#idCheckLength').addClass('d-none');
			}
			
		});
		
		
	
		
		$('#loginIdCheckBtn').on('click', function() {
			let loginId = $('#loginId').val().trim();
			$('#idCheckLength').addClass('d-none');
			$('#idCheckDuplicated').addClass('d-none');
			$('#idCheckOk').addClass('d-none');
			
			
			if(loginId.length < 4) {
				$('#idCheckLength').removeClass('d-none');
				return;
			} 
				
			if(!loginId) {
				alert("아이디를 입력하세요.");
				return;
			}
			
			$.ajax({ // get, post
				url:"/user/is_duplicated_id"
				, data:{"loginId":loginId}
				, success: function(data) {
					if(data.isDuplicated) { // false
						$('#idCheckDuplicated').removeClass('d-none');
					} else { // 중복 아님
						$('#idCheckOk').removeClass('d-none');
					}
				}
				, error : function(request, status, error) {
					alert("중복확인에 실패했습니다.");
				}
			})
		}); // 로그인 아이디 버튼 끝
		
		$('#nickName').mousedown(function()  {
			
			let nickName = $('#nickName').val().trim();
			
			if(nickName.length < 2) {
				$('#nickNameCheckLength').removeClass('d-none');
			} else {
				$('#nickNameCheckLength').addClass('d-none');

			}
			if(nickName.length == 0) {
				$('#nickNameCheckLength').addClass('d-none');
			}
			
		}); // 닉네임 마우스다운 끝
		 
		$('#nickNameCheckBtn').on('click', function() {
			alert("dd0");
			let nickName = $('#nickName').val().trim();
			
			$('#nickNameCheckLength').addClass('d-none');
			$('#nickNameCheckDuplicated').addClass('d-none');
			$('#nickNameCheckOk').addClass('d-none');
			
			if(nickName.length < 2) {
				$('#nickNameCheckLength').removeClass('d-none');
				return;
			}
			if(!nickName) {
				alert("닉네임을 입력하세요.");
				return;
			}
			
			$.ajax({
				url:"/user/is_duplicated_nickName"
					, data:{"nickName":nickName}
					, success: function(data) {
						if(data.isDuplicated) { // false
							$('#nickNameCheckDuplicated').removeClass('d-none');
						} else {
							$('#nickNameCheckOk').removeClass('d-none');
						}
					}
					, error : function(request, status, error) {
						alert("중복확인에 실패했습니다.");
					}
				})
			}) // nickName 버튼 끝
			
		
		// 회원가입 submit
		// signUpform 이 submit 일어날때
		$('#signUpForm').on('submit', function(e) {
			// action 쪽으로 넘어가는 현상: form 기능 중단
			e.preventDefault(); // submit 기능 막음
			
			// validation
			let loginId = $('#loginId').val().trim();
			let password = $('#password').val(); // password는 space가 다 보임
			let confirmPassword = $('#confirmPassword').val();
			let name = $('#name').val().trim();
			let email = $('#email').val().trim();
			let grade = $('#grade').attr('placeholder');/* 
			let profileImageUrl = $("#profileImageUrl").val().trim(); */
			let birth = $('#birth').val().trim();
			let userGender = $('#userGender').val().trim();
			let nickName = $('#nickName').val().trim();
			let interest = $('#interest option:selected').text();
			
			/* "loginId", loginId, "password",password ,"name",name ,"email",email ,"grade",grade ,
			"fileName", fileName,"birth",birth ,"userGender", userGender, 
			"nickName", nickName,"interest",interest */
			let fileName = $('#file').val();
		
	
	
			
			//$("#셀렉트박스ID option:selected").val();
			//alert(typeof profileImageUrl);
			
			if(loginId == '') {
				alert("아이디");
				return false;
			}
			if(!password) {
				alert("비밀번호를 입력하세요.");
				return false;
			} else if(!confirmPassword) {
				alert("비밀번호 확인란을 입력하세요.");
				return false;
			} else if(password != confirmPassword) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}

			if(!name) {
				alert("이름을 입력하세요.");
				return false;
			}
			if(!email) {
				alert("이메일을 입력하세요.");
				return false;
			}	
			if(!nickName) {
				alert("닉네임을 입력하세요.");
				return false;
			}
			
			// 중복확인 후 사용 가능한 지 확인 => 초록색 내용의 d-none 이 제거되어야 한다. d-none이 있을 때 얼럿
			if($('#idCheckOk').hasClass('d-none')) {
				alert("아이디 중복확인을 다시 해주세요.");
				return false;
			} else if($('#nickNameCheckOk').hasClass('d-none')) {
				alert("닉네임 중복확인을 다시 해주세요.");
				return false;
			}
			
			let formData = new FormData();
			formData.append("loginId", loginId);
			formData.append("password",password );
			formData.append("name",name);
			formData.append("email",email);
			formData.append("grade",grade);
			formData.append("file", $('#file')[0].files[0]);
			formData.append("birth",birth);
			formData.append("userGender", userGender);
			formData.append("nickName", nickName);
			formData.append("interest",interest);
			// 서버로 보내는 방법 2가지
			// 1) submit을 자바스크립트로 동작 시킴
			//$(this)[0].submit(); // 화면 이동이 반드시 된다. ( jsp, redirect)
			
		// form 태그
			// 2) AJAX - 응답값이 JSON
			
		
			$.ajax({
				type:"POST"
				,url:"/user/sign-up"
				,data: formData
				, enctype: "multipart/form-data"
				, processData : false
				, contentType : false
				,success : function(data) {
					alert(data);
					if(data.code == 200) {
						alert("가입을 환영합니다. 로그인을 해주세요.");
						location.href = "/user/sign-in-view"; // 화면 넘기기
					} else {
						// 로직 실패
						alert(data.errorMessage);
					}
				}
				, error: function(request, status, error) {
					alert("회원가입 실패");
				}
			
				}); // ajax 끝
			
			}); // signupform 끝
			
			
	});
		
		

	
</script>
