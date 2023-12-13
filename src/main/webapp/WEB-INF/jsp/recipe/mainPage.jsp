<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="nav-out d-flex justify-content-center">
<nav class="navo justify-content-center w-50">
	<ul class="nav nav-fill align-items-center list-unstyled w-100 h-100">
	 <li class="nav-item"><a class="nav-a" href="/cook/recommend-recipe">추천 레시피</a></li>
	 <li class="nav-item"><a class="nav-a" href="/cook/category">분류</a></li>
	 <li class="nav-item"><a class="nav-a" href="/cook/user-ranking">회원랭킹</a></li>
	 </ul>
</nav>
	 </div>
<!-- <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
 
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
       <a class="nav-link" href="#">추천 레시피</a>
        <a class="nav-link" href="#">분류</a>
        <a class="nav-link" href="#">회원랭킹</a>
      </div>
    </div>
  </div>
</nav> -->
<div class="modal-overlay d-none" id="modal">
  	<div class="modal-window">
   		<div class="content">
   			<div class="unfollow_q">정말 삭제하시겠어요?</div>
     		<div class="buttonArea d-flex">
     		<button type="button" class="form-control btn btn-danger w-50" id="deleteBtn">글 삭제</button>     		
     		<button type="button" class="form-control btn btn-info w-50" id="cancelBtn">취소</button>
     		</div>
     	</div>
  	</div>
</div>
<!-- 댓글 삭제 -->
<div class="modal-overlay d-none" id="modal">
  	<div class="modal-window">
   		<div class="content">
   			<div class="unfollow_q">정말 삭제하시겠어요?</div>
     		<div class="buttonArea d-flex">
     		<button type="button" class="form-control btn btn-danger w-50" id="deleteBtn">글 삭제</button>     		
     		<button type="button" class="form-control btn btn-info w-50" id="cancelBtn">취소</button>
     		</div>
     	</div>
  	</div>
</div>
	 
<div class="section mt-3">
	<ul class="all-post">
		<c:forEach items="${recipeViewList}" var="recipeView">
			<li class="pod-li">
				<div class="d-flex">
					<a href="/cook/go-to-post/${recipeView.user.id}/${recipeView.post.id}" id="postLink">
					
					<img src="${recipeView.post.mainImageUrl}" width=300px height=200px>
				
					</a>
				<c:if test="${recipeView.user.id eq userId}">	
					<div class="btn-group" style="width:50px; height:30px;">
							<a class="handle-post-btn btn dropdown" data-toggle="dropdown" href="#"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
				  		<path stroke-linecap="round" stroke-linejoin="round" d="M8.25 6.75h12M8.25 12h12m-12 5.25h12M3.75 6.75h.007v.008H3.75V6.75zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zM3.75 12h.007v.008H3.75V12zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zm-.375 5.25h.007v.008H3.75v-.008zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z" />
						</svg>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/post/post-update/${recipeView.post.id}" class="ml-3" style="text-decoration:none"><i class=""></i> 수정</a></li>
								<li><a href="#" class="deleteTab ml-3" data-target="#modal" data-post-id="${recipeView.post.id}" style="text-decoration:none" class="deleteTab"><i class=""></i> 삭제</a></li>
							</ul>
					</div>
				</c:if>
				</div>
				
				<!--  밑. 제목과 작성자 -->
					<div class="subject ml-2">${recipeView.post.subject}</div>
				<div class="caption">
						<a href="/cook/go-to-userView/${recipeView.user.id}">
					<div class="postuser d-flex mt-2">
						<div>
							<img src="${recipeView.user.profileImageUrl}" width="25px" height="25px">
						</div>
						 <div>${recipeView.user.nickName}</div>
					 </div>
					 	</a>
					<div class="view-count mt-2">조회수 ${recipeView.view}</div>
					
				</div>
				
							
			</li>
		</c:forEach>
	
	</ul>

</div>

<script>
$(document).ready(function() {
	

$('.deleteTab').on('click', function(e){
	/*e.preventDefault();*/
	$('#modal').removeClass('d-none');/* 
	$('#modal').addClass('d-flex');/*   */
	let postId = $(this).data("post-id");
	$("#modal").data("post-id", postId); 
	alert(postId);
	
});

$(".handle-post-btn").on("click", function(e) {
	e.preventDefault(); // a 태그 올라가는 현상 방지
	
	let postId = $(this).data("post-id"); // ... 버튼에 넣어둔 글 번호 getting
	//alert(postId);
	
	// 1개인 모달 태그에 재활용. data-post-id를 심어줌
	$("#modal").data("post-id", postId); // 모달 태그에 setting
});

// 모달 안에 있는 삭제하기 클릭 => 진짜 삭제
$("#deleteBtn").on("click", function(e) {
	e.preventDefault();
	
	let postId = $("#modal").data("post-id"); // getting
	alert(postId);
	
	// ajax 글 삭제 요청
	$.ajax({
		type:"DELETE"
		, url:"/post/delete-post"
		, data: {"postId": postId}
		, success: function(data) {
			if(data.code == 200) {
				alert("!!");
				location.reload();
			}
		}
		, error : function(request, status, error) {
			alert("에러");
		}
		
		});
	
	});

});

</script>