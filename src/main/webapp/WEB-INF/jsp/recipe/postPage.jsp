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

<!--  댓글모달 -->
<div class="modal-overlay d-none" id="modal" name="comment">
  	<div class="modal-window">
   		<div class="content">
   			<textarea class="modify-comment-area form-control mb-3" style="height:200px;"></textarea>
     		<div class="buttonArea d-flex">
     		<button type="button" class="form-control btn btn-info w-50" id="updateCommentBtn">댓글 수정하기</button>     		
     		<button type="button" class="form-control btn btn-danger w-50" id=cancelUpdateBtn>취소</button>
     		</div>
     	</div>
  	</div>
</div>

   <!-- 유저 info -->
   <div class="user-info">
		<div class="user-wrap d-flex justify-content-center">
		   <div class="img-tab justify-content-center">
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
	   	<a href="javascript:void(0)" class="likeTab btn btn-default" data-user-id="${recipeView.user.id}"
	   	data-post-id="${recipeView.post.id}">
	   		<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="red" class="bi bi-heart" viewBox="0 0 16 16">
 			 <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
			</svg>
	   	</a>
   	</c:if>
   	<c:if test="${filledLiker eq true}">
   	  	<a href="javascript:void(0)" class="likeCancelTab btn btn-danger" data-user-id="${recipeView.user.id}"
	   	data-post-id="${recipeView.post.id}">
	   		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
  				<path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
			</svg> 
	   	</a>	
	</c:if>
	<span class="likeCount">${recipeView.postLikeCount}</span>개
	 
   	<a href="javascript:void(0)" class="wholikesPostTab btn btn-warning">
   		추천한 유저
   	</a>
   	
   	<a href="javascript:void(0)" class="addBookTab btn btn-dark" data-toggle="tooltip" data-placement="top" data-original-title="레시피 노트 저장">
   		<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-journal-plus" viewBox="0 0 16 16">
		  <path fill-rule="evenodd" d="M8 5.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V10a.5.5 0 0 1-1 0V8.5H6a.5.5 0 0 1 0-1h1.5V6a.5.5 0 0 1 .5-.5z"/>
		  <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
		  <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/>
		</svg>
   	</a>
   	
   	<a href="#" class="ml-3"title="댓글 보기">
   		<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chat-dots" viewBox="0 0 16 16">
		  <path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
		  <path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"/>
		</svg>
   	
   	</a>
   	
   	
   <div class="view">
      	<span class="hit">${recipeView.view}</span>
    </div>
   </div>
   
   <div class="reply_commentList">
   					   			<div id="ingredient_in">댓글</div>
		<table class="table comment-table text-center">
		<tr>
			<th>No.</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성 일자</th>
			<th></th>
		</tr>
   	 <c:forEach items="${recipeView.commentViewList}" var="commentView" varStatus="status">
		   <div class="reply_list d-flex"> <!--  테이블 형식 도전 -->
			   	<tr>
			   		<td><div class="comment_id">${commentView.comment.id}</div></td>
			   		<td><div class="comment_user">${commentView.user.nickName}</div></td>
			   		<td><div class="comment_left">${commentView.comment.commentText}</div></td>
			   		<td>
				   		<div class="comment_right">
				   			<span class="comment_date"><fmt:formatDate value="${commentView.comment.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
				   		</span>
				   		
				   		</div>
			   		</td>
			   		<td class="d-flex">
			   			<c:if test="${commentView.comment.userId eq serverUserId}">
					   		<a class="update-comment-icon btn" data-target="div[name=comment]" data-comment-id="${commentView.comment.id}">
					   			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eyedropper" viewBox="0 0 16 16">
								  <path d="M13.354.646a1.207 1.207 0 0 0-1.708 0L8.5 3.793l-.646-.647a.5.5 0 1 0-.708.708L8.293 5l-7.147 7.146A.5.5 0 0 0 1 12.5v1.793l-.854.853a.5.5 0 1 0 .708.707L1.707 15H3.5a.5.5 0 0 0 .354-.146L11 7.707l1.146 1.147a.5.5 0 0 0 .708-.708l-.647-.646 3.147-3.146a1.207 1.207 0 0 0 0-1.708l-2-2zM2 12.707l7-7L10.293 7l-7 7H2v-1.293z"/>
								</svg>
					   		</a>
					   		<a class="delete-comment-icon btn" data-toggle="tooltip" data-placement="top" data-original-title="댓글 삭제">
					   			<img src="https://creazilla-store.fra1.digitaloceanspaces.com/emojis/52726/cross-mark-emoji-clipart-md.png" width="10px" height="10px">
					   		</a>
					   	</c:if>
					</td>
			   	</tr>
			   	</div>
	  </c:forEach> 
</table>
 
   <!-- 재료 -->
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
  	 
  	 <!--  -->
  	 
  	 
   <!--  댓글 쓰기 -->
	  <div class="input-group d-flex">
	          <div class="col-10">
	          	<textarea id="cmt_tx_content1" name="frm[cmt_tx_content]" class="form-control" placeholder="무엇이 궁금하신가요? 댓글을 남겨주세요." style="height:100px; resize:none;"></textarea>
	          </div>
	        <div>
	         <button class="input-group-btn btn btn-secondaryf" type="button" id="commentBtn" style="height:100px; width:100px;">등록</button>
	  		</div>
	  </div>
  </div>
</div>   

<script>

	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		
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
		
		// 댓글 수정
		$('.update-comment-icon').on('click', function() {
			$('div[name=comment]').removeClass('d-none');
			let commentId_2 = $(this).data('comment-id');
			alert(commentId_2);
			$('div[name=comment]').data('comment-id', commentId_2);
			let commentText = $(this).parent().prev().text();
			let commentId = $(this).parent().prev().prev().text(); // 됐다!!
			
			$.ajax({
				type:"PUT"
				, url: "/comment/update-comment"
				, data : {"postUserId": postUserId, "postId": postId, "userId": userId, "commentId": commentId, "commentText":commentText}
				, success : function(data) {
					alert("댓글 지우기 성공");
					location.reload();
					}
			 	}); 
		});
		
		$("#updateCommentBtn").on('click', function() {
			let commentId = $(this).data('comment-id');
			alert(commentId);
			$("div[name=comment]").data("post-id", postId);
		});
		
	});
</script>
