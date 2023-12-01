<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header d-flex justify-content-center align-items-center">
	<div class="logo  mr-5">
		<a href="/cook/easycook"><img src="/static/img/Easycook-logo.png" alt="logo" width=200 height=150></a>
	</div>
	
	<div class="search d-flex mr-5">
		<input type="text" class="searchText form-control mt-3" width=500>
		<a href="" class="btn"><img src="/static/img/searchButton.jpg" alt="searchButton" width=50 height=50></a>
	</div>
	
	
	<ul class="profile d-flex ml-5 mt-5">
		<!-- 프로필 사진 구현되면 이미지 작게 띄워야 함 -->
		<li>
			<c:if test="${userId eq null}"> 
			 <a href="/user/sign-in-view" class="layer2" id="userViewBtn" data-toggle="tooltip" data-placement="top" data-original-title="로그인/회원가입">
			<img src="https://recipe1.ezmember.co.kr/img/ico_user.png" id="myPage" alt="로그인/회원가입">
			 </a>
			 </c:if>
			 
			 <c:if test="${userId ne null}"> 
			 <a href="/user/profile-modify" class="layer2" id="myPageViewBtn" data-toggle="tooltip" data-placement="top" data-original-title="마이페이지">
			<img src="https://recipe1.ezmember.co.kr/img/ico_user.png" id="myPage" alt="마이페이지"> </a>
			 
			 <div class="mem-layer">
			 	<p class="mem-layer-slit"></p>
			 	<p class="mem-layer-m d-none">
 		   			<a href="/user/go-my-home">MY홈</a>
                    <a href="/user/go-scrap">스크랩한 레시피</a>
                    <a href="https://www.10000recipe.com/profile/note.html">레시피 노트</a>
                    <a href="https://www.10000recipe.com/profile/alim.html">알림</a>
                    <a href="https://www.10000recipe.com/profile/message.html">메시지</a>
                    <a href="https://www.10000recipe.com/profile/qna.html">문의내역</a>
					<a href="https://shop.10000recipe.com/mypage/order_list.php" target="_blank">주문조회</a>
					<a href="https://shop.10000recipe.com/ezhld/login_dummy.php?q_path=https%3A%2F%2Fshop.10000recipe.com%2Forder%2Fcart.php" target="_blank">장바구니</a>
                    <a href="/user/profile-modify">회원정보수정</a>
                    <a href="javascript:doLogout()">로그아웃</a>                           
			 	</p>
			 </div>
			 </c:if>
		</li>	 
		<li>
			<div class="write_layer" style="left: -230px; display:block;">
			<!--  레시피 작성하기 -->
			  <a href="/cook/writeRecipe" class="layer2" id="writeRecipeBtn" data-toggle="tooltip" data-placement="top" data-original-title="레시피등록">
			 	<img src="https://recipe1.ezmember.co.kr/img/tmn_write.png">
			 </a>
			 
			</div>
		</li>
	</ul>
	
	<div class="login-info d-flex align-items-center ml-5">
		<c:if test="${userId ne null}">
		<span class="text-danger">${userNickName}님 안녕하세요</span>
		<a href="/user/sign-out" class="ml-2 font-weight-bold btn btn-info">로그아웃</a>
		</c:if>
	</div>
</div>

<script>
	$(document).ready(function() { 
		$('[data-toggle="tooltip"]').tooltip();
		
		$('#writeRecipeBtn').on('click', function() {
				
		});
		
		$('#myPageViewBtn').on('click', function() {
			$('.mem-layer-m').removeClass('d-none');
			
		});
	});
</script>
