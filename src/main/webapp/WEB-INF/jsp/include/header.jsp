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
			 <div data-toggle="toggle" data-placement="top" data-original-title="마이페이지">
			 <a href="#" class="layer2 dropdown" id="myPageViewBtn" data-toggle="dropdown" style="width:44px;">
				<img src="https://recipe1.ezmember.co.kr/img/ico_user.png" id="myPage" alt="마이페이지"> 
				</a>
				
				<ul class="dropdown-menu">
 		   			<a class="dropdown-item" href="/cook/get-user-post">MY홈</a>
                    <a class="dropdown-item" href="/user/go-scrap-page">나의 레시피 노트</a>
                    <a class="dropdown-item" href="/user/profile-modify">회원정보수정</a>
                    <a class="dropdown-item" href="/user/sign-out">로그아웃</a>                           
			 	</ul>
			
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
/* 		$('[data-toggle="dropdown"]').dropdown();
 */		
		$('#writeRecipeBtn').on('click', function() {
				
		});
		
		$('#myPageViewBtn').on('click', function() {
			$('.mem-layer-m').removeClass('d-none');
			
		});
	});
</script>
