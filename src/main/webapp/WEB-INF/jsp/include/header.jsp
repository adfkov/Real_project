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
			<a id="btnTopWrite" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" data-original-title="레시피등록"><img src="https://recipe1.ezmember.co.kr/img/ico_user.png" alt="레시피등록">
			</a>
			<div class="write_layer" style="left: -230px; display:block;">
			<!--  레시피 작성하기 -->
			 <a href="/cook/writeRecipe" class="layer2">
			 	<img src="https://recipe1.ezmember.co.kr/img/tmn_write.png">
			 	<span>글 작성하기</span>
			 </a>
			</div>
		</li>
	</ul>
	
	<div class="login-info d-flex align-items-center mr-5">
		<c:if test="${userId ne null}">
		<span class="text-danger">${userNickName}님 안녕하세요</span>
		<a href="/user/sign-out" class="ml-2 text-danger font-weight-bold">로그아웃</a>
		</c:if>
	</div>
</div>

<script>
	$(document).ready(function() { 
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<!-- 
<ul class="gnb_right">
                                        
                <li>
<a id="btnTopWrite" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="" data-original-title="레시피등록"><img src="https://recipe1.ezmember.co.kr/img/tmn_write.png"></a>
<div class="write_layer document_common_layer" style="left: -230px; display: none;">
        <a href="https://www.10000recipe.com/inbox/insert.html" class="w_layer2"><img src="https://recipe1.ezmember.co.kr/img/btn_write1.gif"><span>직접 등록하기</span></a><a id="btnBlogForm" href="javascript:void(0)" class="w_layer3" data-toggle="modal" data-target="#divModalBlogForm"><img src="https://recipe1.ezmember.co.kr/img/btn_write2.gif"><span>블로그 가져오기</span></a>
    </div>
</li>
<li style="margin-left:50px;" class="st2">
    <a href="https://shop.10000recipe.com" target="_blank" data-toggle="tooltip" title="" data-original-title="만개스토어"><img src="https://recipe1.ezmember.co.kr/img/tmn_store2.png"></a>
</li> -->