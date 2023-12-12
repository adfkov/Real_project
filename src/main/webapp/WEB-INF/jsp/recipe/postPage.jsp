<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrap">
	<c:if test="${serverUserId ne null}">
		<span class="server_id">${serverUserId}</span>
	</c:if>  
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

<div class="modal-overlay d-none w-100" id="modal-like">
  	<div class="modal-window">
   		<div class="content">
   			
   			<div class="liker_q">추천한 사람들</div>
			   <div class="postLiker_List">
			   	 <c:forEach items="${recipeView.postLikerUser}" var="user">
					   <div class="liker_list">
					   		<div class="liker_left">${user.nickName}</div>
					   </div>
				  </c:forEach> 
			   </div>
     		<div class="buttonArea d-flex">
     		<button type="button" class="form-control btn btn-info w-50" id="cancelLikerBtn">닫기</button> 
     		</div>
     	</div>
  	</div>
</div>
   <!-- 유저 info -->
   <div class="user-info">
		<div class="user-wrap d-flex justify-content-center">
		   <div class="img-tab d-flex justify-content-center">
			    <a class="user_profile_link" href="/cook/go-to-userView/${recipeView.user.id}">
						<img id="user_profile" src="${recipeView.user.profileImageUrl}" alt="${recipeView.post.id}">
				    <span class="user_id d-none">${recipeView.user.id}</span>
					    <div class="nick_and_button d-flex justify-content-center">
						    	<span class="user_nickName">${recipeView.user.nickName}</span>
						</div>
					</a>	
						<c:set var="recipeUserId" value="${recipeView.user.id}"/>		 
							 <c:if test="${recipeUserId ne serverUserId}">
							 	<c:if test="${Following eq false}">
									<button type="button" class="followBtn btn btn-info ml-4 mr-3">팔로우</button>
								</c:if>
								<c:if test="${Following eq true}">
									<button type="button" class="followingBtn btn btn-default ml-4 mr-2">팔로잉</button>
								</c:if>
							</c:if>
				
			</div>
	    <span class="post_id d-none">${recipeView.post.id}</span>
	    </div>

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
   	<c:if test="${filledLiker eq false}">
	   	<a href="javascript:void(0)" class="likeTab btn btn-info" data-user-id="${recipeView.user.id}"
	   	data-post-id="${recipeView.post.id}">
	   		좋아요
	   	</a>
   	</c:if>
   	<c:if test="${filledLiker eq true}">
   	  	<a href="javascript:void(0)" class="likeCancelTab btn btn-danger" data-user-id="${recipeView.user.id}"
	   	data-post-id="${recipeView.post.id}">
	   		좋아요 취소
	   	</a>	
	</c:if>
	<span class="likeCount">${recipeView.postLikeCount}</span>개
	 
   	<a href="javascript:void(0)" class="wholikesPostTab btn btn-warning">
   		추천한 유저
   	</a>
   	
   	<a href="javascript:void(0)" class="wholikesPostTab btn btn-dark">
   		보관함 저장
   	</a>
   	
   	
   <div class="view">
      	<span class="hit">${recipeView.view}</span>
    </div>
   </div>
   
   <div class="reply_commentList">
   		댓글:
   	 <c:forEach items="${recipeView.commentViewList}" var="commentView" varStatus="status">
		   <div class="reply_list d-flex"> <!--  테이블 형식 도전 -->
		   		<div class="comment_id">${commentView.comment.id}</div>
		   		<div class="comment_left">${commentView.comment.commentText}</div>
		   		<div class="comment_right">
			   		<c:if test="${commentView.comment.userId eq serverUserId}">
				   		<a class="delete-comment-icon btn mb-2">
				   			<img src="https://creazilla-store.fra1.digitaloceanspaces.com/emojis/52726/cross-mark-emoji-clipart-md.png" width="10px" height="10px">
				   		</a>
				   	</c:if>
		   			<span class="comment_date"><fmt:formatDate value="${commentView.comment.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
		   		</span>
		   		</div>
		   </div>
	  </c:forEach> 
   
   
	   <div class="ingredient">
			   <div class="ingredient_list">
			   		<div class="ingredient_left">
			   			<hr>
			   			<div id="ingredient_in">재료</div>
			   			
			   			<div class="ingredient_real ml-2">
			   				${recipeView.post.ingredient}
			   			</div>
			   	<!-- : ${recipeView.post.ingredient} -->	
			   		</div>
			   </div>
	   
   </div>
   <!--  댓글 쓰기 -->
	  <div class="input-group d-flex">
	          <div>
	          <textarea id="cmt_tx_content1" name="frm[cmt_tx_content]" class="form-control" placeholder="무엇이 궁금하신가요? 댓글을 남겨주세요." style="height:100px; width: 500px; resize:none;"></textarea>
	          </div>
	          <span class="input-group-btn"><button class="btn btn-default" type="button" id="commentBtn" style="height:100px; width:100px;">등록</button></span>
	  </div>
  </div>
</div>   

<script>

	$(document).ready(function() {
		let userId = $('.server_id').text();/* 
		let postUserId = $('.likeCancelTab').data('user-id');	
		let postId = $('.likeCancelTab').data('post-id'); */
		 // 팔로우, 팔로잉 버튼 띄우기
		let followedUserId = $('.user_profile_link').attr('href').split("/").pop();
	
		let followingUserId = $('.server_id').text();
		let postUserId = $('.user_id').text(); // 글을 쓴 유저
		let postId = $('.post_id').text(); // 글의 아이디
		
		

		// 팔로잉 버튼을 눌렀을 때
		$('.followingBtn').on('click', function(e){
			/*e.preventDefault();*/
			$('#modal').removeClass('d-none');/* 
			$('#modal').addClass('d-flex');/*   */
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
				,data:{"followingUserId":followingUserId,"followedUserId": postUserId, "postId": postId}
				,success: function(data){
					if(data.code == 200) {
						/* 	alert("!!!"); */
						location.reload();
					}
				}
				,error:function(request,status,error){
					alert("팔로우 실패");
				}
			});
		}); <!-- 팔로우 끝-->
		
		$('#cancelBtn').on('click', function() {
			$('#modal').addClass('d-none');
			
		});
		
		// 좋아요를 눌렀을 때
		$('.likeTab').on('click', function() {
			let serverUserId = $('.server_id').text();
			if(serverUserId == "") {
				alert("로그인 하세요.");
				location.href="/user/sign-in-view";
			}
			
			$.ajax({
				type:"POST"
				, url: "/post-like/like/" + postUserId + "/" + postId
				, data: {}
				, success : function(data) {
					if(data.code== 200) {
						location.reload();
						alert(data.recipeView.postLikeCount);
					}
				}
				, error : function(data) {
					alert("좋아요 실패");
				}
			});
		}); <!-- 좋아요 끝 -->
		
		// 좋아요 취소를 눌렀을 때
		$('.likeCancelTab').on('click', function() {
				let userId = $('.server_id').text();
				let postUserId = $('.likeCancelTab').data('user-id');
				let postId = $('.likeCancelTab').data('post-id');
			$.ajax({
				type: "DELETE"
				, url: "/post-like/like/" + postUserId + "/" + postId
				, data: {"postUserId": postUserId, "postId": postId, "userId": userId}
				, success: function(data) {
					location.reload();
				}
				, error : function(request, status, error) {
					alert("좋아요 취소 실패");
				}
			});
		}); <!-- 좋아요 취소 끝 -->
		
		// 추천한 사람들 띄우기
		$('.wholikesPostTab').on('click', function(){
			$('#modal-like').removeClass('d-none');
			
		});
		
		//
		$('#cancelLikerBtn').on('click', function(){
			$('#modal-like').addClass('d-none');
		});
		// 댓글
		$('.input-group-btn').on('click', function(){/* 
			let userId = $('.server_id').data('fu-id');
			let postUserId = $('.likeTab').data('user-id');
			let postId = $('.likeTab').data('post-id');
			let comment = $('#cmt_tx_content1').val(); */
			let comment = $('#cmt_tx_content1').val(); 
			$.ajax({
				type:"POST"
				, url: "/comment/add-comment"
				, data: {"postUserId": postUserId, "postId": postId, "userId": userId, "commentText": comment}
				, success: function(data) {
					location.reload();
				}
				, error : function(request, status, error) {
					alert("댓글 달기 실패");
				}
			});
			
			
		}); 
		<!-- 댓글 달기 -->
		$('.delete-comment-icon').on('click', function() {
			let commentText = $(this).parent().prev().text();
			let commentId = $(this).parent().prev().prev().text(); // 됐다!!
			alert(commentId);
			 	$.ajax({
				type:"DELETE"
				, url: "/comment/delete-comment"
				, data : {"postUserId": postUserId, "postId": postId, "userId": userId, "commentId": commentId}
				, success : function(data) {
					alert("댓글 지우기 성공");
					location.reload();
					}
			 	}); 
		});
		
	});
</script>
