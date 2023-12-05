<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="wrap">    
   <div class="postSubject d-flex justify-content-center" id="postSubject">
   	<img src="${recipeView.post.mainImageUrl}" id="postImg" width="500px" height="500px" data-post-id="${recipeView.post.id}">
   </div>
   <div class="modal-overlay d-none" id="modal">
  	<div class="modal-window">
   		<div class="content">
   			
   			<div class="unfollow_q">정말 팔로우 취소해요?</div>
     		<div class="buttonArea d-flex">
     		<button type="button" class="form-control btn btn-info w-50" id="cancelBtn">팔로우 유지</button>     		
     		<button type="button" class="form-control btn btn-danger w-50" id="unfollowBtn">팔로우 취소</button>
     		</div>
     	</div>
  	</div>
</div>
   <!-- 유저 info -->
   <div class="user-info">
    <a class="user_profile_link" href="/cook/go-to-userView/${recipeView.user.id}">
		<div class="d-flex justify-content-center">
		<img id="user_profile" src="${recipeView.user.profileImageUrl}" alt="${recipeView.post.id}">
	    </div>
	    <div class="nick_and_button d-flex justify-content-center">
	    <span class="user_nickName">${recipeView.user.nickName}</span>
		</div>
	</a>
	<c:set var="recipeUserId" value="${recipeView.user.id}"/>
	
	 <c:if test="${recipeUserId ne serverUserId}">
		<button type="button" class="followBtn btn btn-info ml-3" data-fu-id="${serverUserId}">팔로우</button>
		<button type="button" class="followingBtn btn btn-default ml-3 d-none">팔로잉</button>
	</c:if>
	<%-- <c:if test="${recipeUserId eq serverUserId}">
		<button type="button" class="followBtn btn btn-info ml-3 d-none" data-fu-id="${recipeUserId}">팔로우</button>
		<button type="button" class="followingBtn btn btn-default ml-3 d-none">팔로잉</button>
	</c:if> --%>

	<!-- Modal  id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"-->

   </div>
   <!-- 제목 , info-->
   <div class="recipe-subject">
   	<div class="subject">${recipeView.post.subject}</div>
   </div>
   
   <div class="recipe-intro ml-2">
   	<div class="intro">${recipeView.post.intro}</div>
   </div>
   
   <div class="like-scrap-comment">
   	<a href="javascript:void(0)" class="likeTab btn btn-info d-none" data-user-id="${recipeView.user.id}"
   	data-post-id="${recipeView.post.id}">
   		좋아요
   	</a>
 
   	
	<span class="likeCount">${recipeView.postLikeCount}</span>개
   
   	<a href="javascript:void(0)" class="likeCancelTab btn btn-danger d-none" data-user-id="${recipeView.user.id}"
   	data-post-id="${recipeView.post.id}">
   		좋아요 취소
   	</a>	
   	<a href="javascript:void(0)" class="wholikesPostTab btn btn-warning">
   		추천한 유저
   	</a>
   	
   <div class="view">조회수 : ${recipeView.view}</div>
   </div>
   
  <div class="input-group d-flex">
          <div>
          <textarea id="cmt_tx_content1" name="frm[cmt_tx_content]" class="form-control" placeholder="무엇이 궁금하신가요? 댓글을 남겨주세요." style="height:100px; width: 500px; resize:none;"></textarea>
          </div>
          <span class="input-group-btn"><button class="btn btn-default" type="button" id="commentBtn" style="height:100px; width:100px;">등록</button></span>
  </div>
</div>   

<script>

	$(document).ready(function() {
		
		 // 팔로우, 팔로잉 버튼 띄우기
		let followedUserId = $('.user_profile_link').attr('href').split("/").pop();
		let followingUserId = $('.followBtn').data('fu-id');
		let postUserId = $('.likeTab').data('user-id'); // 글을 쓴 유저
		let postId = $('.likeTab').data('post-id'); // 글의 아이디
		alert(followingUserId);
	 	 $.ajax({
			type:"POST"
			, url: "/post-like/like/is-like"
			, data: {"postUserId": postUserId, "postId": postId, "userId": followingUserId}
			, success : function(data) {
				if(data.recipeView.ifPostLike == false) {
					$('.likeTab').removeClass('d-none');
				} else {
					$('.likeCancelTab').removeClass('d-none');	
				}
			}
			, error : function(request, status, error) {
				alert("좋아요 여부 실패");
			}
		});  
		// 좋아요 개수
	 	 $.ajax({
				type:"POST"
				, url: "/post-like/get-likeCount"
				, data: {"postUserId": postUserId, "postId": postId}
				, success : function(data) {
					$('.likeCount').text(data.recipeView.postLikeCount);
				}
				, error : function(request, status, error) {
					alert("좋아요 개수 실패");
				}
			});   
		<!------------------- 구분선 ------------------->
		$.ajax({
			type:"POST"
			, url:"/like/is-following"
			, data:{"followingUserId":followingUserId, "followedUserId":followedUserId}
			, success: function(data) {
				if(data.isFollowing) {
					$('.followBtn').addClass('d-none');
					$('.followingBtn').removeClass('d-none');
				}
			}
			, error : function(request, status, error) {
				alert("팔로우 여부 확인 실패");
			}
		});
		
		// 팔로잉 버튼을 눌렀을 때
		$('.followingBtn').on('click', function(e){
			/*e.preventDefault();*/
			$('#modal').removeClass('d-none');/* 
			$('#modal').addClass('d-flex');/*   */
			$('#modal').style.display = "flex";
		});
		
		// 팔로우 취소를 눌렀을 때
		$('#unfollowBtn').on('click', function() {
			$.ajax({
				type:"DELETE"
				, url:"/like/unfollow"
				, data : {"followingUserId":followingUserId, "followedUserId":followedUserId, "postId": postId}
				, success : function(data) {
					location.reload();
				}
				, error : function(request, status, error) {
					alert("팔로우 취소 실패");
				}
			});
		});
		
	/* 	// 글 삭제(... 더보기 버튼 클릭) => 모달 띄우기 => 모달에 글번호 세팅
		$(".more-btn").on("click", function(e) {
			e.preventDefault(); // a 태그 올라가는 현상 방지
			
			let postId = $(this).data("post-id"); // ... 버튼에 넣어둔 글 번호 getting
			//alert(postId);
			
			// 1개인 모달 태그에 재활용. data-post-id를 심어줌
			$("#modal").data("post-id", postId); // 모달 태그에 setting
		});
		
		// 모달 안에 있는 삭제하기 클릭 => 진짜 삭제
		$("#modal #deletePostLink").on("click", function(e) {
			e.preventDefault();
			
			let postId = $("#modal").data("post-id"); // getting
			//alert(postId);
			
			// ajax 글 삭제 요청
			
		}); */
		

		
		// 팔로우를 클릭했을 때
		$('.followBtn').on('click', function() {
			

		 	if(followingUserId == "") {
				alert("팔로우는 로그인해야 할 수 있습니다!");
				return false;
			} 
		
			$.ajax({
				type:"POST"
				,url:"/like/follow-user"
				,data:{"followingUserId":followingUserId,"followedUserId": followedUserId , "postId": postId}
				,success: function(data){
					if(data.code == 200) {
					location.reload();
					}
				}
				,error:function(request,status,error, data){
					alert("팔로우 실패");
				}
			});
		}); <!-- 팔로우 끝-->
		
		// 좋아요를 눌렀을 때
		$('.likeTab').on('click', function() {
			let userId = $('.followBtn').data('fu-id')
			let postUserId = $('.likeTab').data('user-id');
			let postId = $('.likeTab').data('post-id');
			$.ajax({
				type:"POST"
				, url: "/post-like/like/" + postUserId + "/" + postId + "/" + followingUserId
				, data: {}
				, success : function(data) {
					if(data.code== 200) {
						location.reload();
					}
				}
				, error : function(data) {
					alert("좋아요 실패");
				}
			});
		}); <!-- 좋아요 끝 -->
		
		// 좋아요 취소를 눌렀을 때
		$('.likeCancelTab').on('click', function() {
				let userId = $('.followBtn').data('fu-id')
				let postUserId = $('.likeCancelTab').data('user-id');
				let postId = $('.likeCancelTab').data('post-id');
			$.ajax({
				type: "DELETE"
				, url: "/post-like/like-cancel"
				, data: {"postUserId": postUserId, "postId": postId, "userId": userId}
				, success: function(data) {
					location.reload();
				}
				, error : function(request, status, error) {
					alert("좋아요 취소 실패");
				}
			});
		}); <!-- 좋아요 취소 끝 -->
		
		$('.wholikesPostTab').on('click', function(){
			$.ajax({
				type:"POST"
				, url: "/cook"
			});
			
		});
		
		// 댓글
		$('.input-group-btn').on('click', function(){
			let userId = $('.followBtn').data('fu-id')
			let postUserId = $('.likeTab').data('user-id');
			let postId = $('.likeTab').data('post-id');
			let comment = $('#cmt_tx_content1').val();
			$.ajax({
				type:"POST"
				, url: "/comment/add-comment"
				, data: {"postUserId": postUserId, "postId": postId, "userId": userId, "commentText": comment}
				, success: function(data) {
					alert("댓글 달기 성공");
				}
				, error : function(request, status, error) {
					alert("댓글 달기 실패");
				}
			});
			
		});
		
	});
</script>
