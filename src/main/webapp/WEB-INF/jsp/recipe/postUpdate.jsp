<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="recipeAll" id="recipeAll" class="form-horizontal" method="post" action="/post/update-recipe"> 
<div class="container recipe_regi">
	<div class="regi-title" data-user-id="${userId}" data-post-id="${postId}">
		레시피 수정
	</div>
	
	<div class="cont-box">
		
		<div class="cont-line d-flex align-items-center mt-3">
			<p class="cont_tit4">레시피 제목</p>
			<span class="d-none" id="postId" data-target="#submittBtn">${post.id}</span>
			<input type="text" name="cok-title" id="title" class="form-control" value="${post.subject}" style="width:610px;">
		</div>
		
		<div class="cont-line">
			<p class="cont_tit4">요리 소개</p>
			<textarea name="cok-intro" id="intro" class="form-control step_cont" placeholder="" style="width:610px; height:100px; resize:none;">${post.intro}</textarea>
		</div>
		
		<div class="cont-line">
			<p class="cont_tit4">카테고리</p>
			<select name="cok_sq_category_1" id="cok_sq_category_1" class="form-control category mt-3" value="${post.ingredientId}">
				<option value="">종류별</option>
				<option value="63">밑반찬</option>
				<option value="56">메인반찬</option>
				<option value="54">국/탕</option>
				<option value="55">찌개</option>
				<option value="60">디저트</option>
				<option value="53">면/만두</option>
				<option value="52">밥/죽/떡</option>
				<option value="61">퓨전</option>
				<option value="57">김치/젓갈/장류</option>
				<option value="58">양념/소스/잼</option>
				<option value="65">양식</option>
				<option value="64">샐러드</option>
				<option value="68">스프</option>
				<option value="66">빵</option>
				<option value="69">과자</option>
				<option value="59">차/음료/술</option>
				<option value="62">기타</option>
			</select>
			<select name="cok_sq_category_2" id="cok_sq_category_2" class="form-control category mt-3 ml-2">
				<option value="">재료별</option><option value="70">소고기</option>
				<option value="71">돼지고기</option>
				<option value="72">닭고기</option>
				<option value="23">육류</option>
				<option value="28">채소류</option>
				<option value="24">해물류</option>
				<option value="50">달걀/유제품</option>
				<option value="33">가공식품류</option>
				<option value="47">쌀</option>
				<option value="32">밀가루</option>
				<option value="25">건어물류</option>
				<option value="31">버섯류</option>
				<option value="48">과일류</option>
				<option value="27">콩/견과류</option>
				<option value="26">곡류</option>
				<option value="34">기타</option>
			</select>
		</div>
		
		<div class="cont-line">
			<p class="cont_tit4">요리정보</p>
			<span class="s" style="margin-top:22px;">인원</span>
			<select name="cok_portion" id="cok_portion"  class="form-control" style="width:100px; height: 40px; margin-top:15px; margin-left: 5px;">
				<option value="">인원</option><option value="1">1인분</option>
				<option value="2">2인분</option>
				<option value="3">3인분</option>
				<option value="4">4인분</option>
				<option value="5">5인분</option>
				<option value="6">6인분이상</option>
			</select>
			
			<span class="s" style="margin-top:22px; margin-left: 10px;">난이도</span>
			<select name="cok_degree" id="cok_degree" class="form-control" style="width:100px; height: 40px; margin-top:15px; margin-left: 5px;">
				<option value="">난이도</option><option value="1">아무나</option>
				<option value="2">초급</option>
				<option value="3">중급</option>
				<option value="4">고급</option>
				<option value="5">신의경지</option>
			</select>
			
		</div>
	</div>
	
	<div class="cont-box">
		<div class="cont-line">
			<p class="cont_tit4">요리 메인 이미지</p>
			<div class="file-upload d-flex">
			<%-- file 태그를 숨겨두고 이미지를 클릭하면 file 태그를 클릭한 효과 --%>
			<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg" class="d-none">
				<a href="#" id="fileUploadBtn"><img width="35" src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"></a>
			
			<%-- 업로드된 임시 파일명 노출 --%>
			<div id="fileName" class="ml-2"></div>
			</div>
		</div>
	</div>
	
	<div class="cont-box">
		<div class="cont-line">
			<p class="cont_tit4">재료</p>
			<textarea name="cok-ingredient" id="cok-ingredient" class="form-control step_cont" 
			 style="width:610px; height:100px; resize:none;">${post.ingredient}</textarea>
		</div>
	</div>
	
	<div class="cont-box">
		<div class="cont-line">
			<p class="cont_tit4">요리순서</p>
			<textarea name="cookStepText" id="cookStepText" class="form-control step_cont" 
			placeholder="요리 순서를 적어주세요!"  style="width:610px; height:100px; resize:none;">${post.cookStepText}</textarea>
		</div>
	</div>
	
		<div class="cont-line">
			<p class="cont_tit4">요리 팁</p>
			<textarea name="cok-tip" id="cok-tip" class="form-control step_cont" 
			placeholder="예) 불 조절을 적절하게 하면 육질이 부드러워요"  style="width:610px; height:100px; resize:none;">${post.cookTip}</textarea>
		</div>
	
	
	<div class="regi_btn">
		<button type="submit" class="btn btn-info" id="submittBtn">수정 완료</button>
	</div>
</div>

</form>

<script>
	$(document).ready(function() {
		// 옵션 미리 선택
		
		
		
	/* 	if(
		$('#cok_sq_category_1 option').text() == $('#cok_sq_category_1').attr('value')
		) {
			$(this).
		} */
		
		
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
				
					/* $('#fileName').text(fileName);
					$('#profile').attr('src', $('#file').files[0]); */
				}
			});
	
	
	
	$('#submittBtn').on('click', function(e) {
		e.preventDefault();
		
		let postId = $('.regi-title').data("post-id");
		alert(postId);
		let userId =$('.regi-title').data("user-id");
		
		let subject = $('input[name=cok-title]').val().trim();
		let intro = $('#intro').val();
		
		let foodTypeId = $('#cok_sq_category_1').val().trim();
		let ingredientId = $('#cok_sq_category_2').val().trim();
		
		let portion = $('#cok_portion').val().trim();
		let degree = $('#cok_degree').val().trim();
		
		let mainImageUrl = $('')
		let fileName = $('#file').val();
	
		let ingredient = $('#cok-ingredient').val().trim();
		let cookStepText = $('#cookStepText').val().trim();
		let cookTip = $('#cok-tip').val().trim();
		e.preventDefault();
		if(subject == "") {
			alert("제목을 입력하세요.");
		}
		
		let formData = new FormData();
		formData.append("postId", postId);
		formData.append("userId", userId);
		formData.append("subject",subject);
		formData.append("intro",intro);
		formData.append("foodTypeId",foodTypeId);
		formData.append("ingredientId",ingredientId);
		formData.append("portion",portion);
		formData.append("degree", degree);
		formData.append("file", $('#file')[0].files[0]);
		formData.append("ingredient", ingredient);
		formData.append("cookStepText",cookStepText);
		formData.append("cookTip",cookTip);
		
		
		
	
		
		$.ajax({
			type:"POST"
			, url:"/post/update-recipe"
			, data: formData
			, enctype: "multipart/form-data"
			, processData : false
			, contentType : false
			, success : function(data) {
				if(data.code == 200) {
				alert("레시피가 수정됐습니다.");
				location.href = "/cook/get-user-post";
			} else {
				alert("레시피 저장 실패");
				}
			}	
			, error : function(request, status, error) {
				alert("수정 아예 실패");	
			}
			
			});
		});
	});
	

</script>