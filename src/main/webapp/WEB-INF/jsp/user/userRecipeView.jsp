<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="wrap d-flex w-100">

<!--  새 모달 -->
<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal">
  Launch demo modal
</button> -->

<!-- <!-- Modal -->
<!-- <div class="modal fade" id="" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
   		<div class="modal-content">
     
     	</div>
  	</div>
</div>  -->



<div class="brand_cont col-8">
	<p style="text-align:center"></p>
	<div class="input-group info_search w-50" style="margin: 0 auto;">
		<input type="text" name="qs" class="form-control">
		<span class="input-group-btn">
			<button class="btn btn-default" type="button">
				<img src="https://recipe1.ezmember.co.kr/img/mobile/icon_search4.png">
			</button>
		</span>
	</div>
	
	<!--  글 목록 -->
	<ul class="cont-list" data-server-id="${serverId}">
		<c:forEach items="${recipeViewList}" var="recipe">
		<li class="cont-li">
	<div class="li-group d-flex">
		<a href="/cook/go-to-post/${recipe.user.id}/${recipe.post.id}" class="postLink" id="postLink" data-user-id="${recipe.user.id}"
		data-post-id="${recipe.post.id}">
	
		
			<img src="${recipe.post.mainImageUrl}" width=200px height=130px>
		
		</a>
		
		<!--  -->
				 <c:if test="${userId eq recipe.user.id}">
				 		<div class="btn-group">
							<div class="cdfdf" data-toggle="toggle">
							<a type="button" class="handle-post-btn dropdown ml-3" data-toggle="dropdown">	
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
								  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/></svg> </a>
								<ul class="dropdown-menu">
									<li><a href="#" class="updateTab ml-2" data-target="#modal" data-post-id="${recipe.post.id}"><i><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-android2" viewBox="0 0 16 16">
					 				 <path d="m10.213 1.471.691-1.26c.046-.083.03-.147-.048-.192-.085-.038-.15-.019-.195.058l-.7 1.27A4.832 4.832 0 0 0 8.005.941c-.688 0-1.34.135-1.956.404l-.7-1.27C5.303 0 5.239-.018 5.154.02c-.078.046-.094.11-.049.193l.691 1.259a4.25 4.25 0 0 0-1.673 1.476A3.697 3.697 0 0 0 3.5 5.02h9c0-.75-.208-1.44-.623-2.072a4.266 4.266 0 0 0-1.664-1.476ZM6.22 3.303a.367.367 0 0 1-.267.11.35.35 0 0 1-.263-.11.366.366 0 0 1-.107-.264.37.37 0 0 1 .107-.265.351.351 0 0 1 .263-.11c.103 0 .193.037.267.11a.36.36 0 0 1 .112.265.36.36 0 0 1-.112.264m4.101 0a.351.351 0 0 1-.262.11.366.366 0 0 1-.268-.11.358.358 0 0 1-.112-.264c0-.103.037-.191.112-.265a.367.367 0 0 1 .268-.11c.104 0 .19.037.262.11a.367.367 0 0 1 .107.265c0 .102-.035.19-.107.264M3.5 11.77c0 .294.104.544.311.75.208.204.46.307.76.307h.758l.01 2.182c0 .276.097.51.292.703a.961.961 0 0 0 .7.288.973.973 0 0 0 .71-.288.95.95 0 0 0 .292-.703v-2.182h1.343v2.182c0 .276.097.51.292.703a.972.972 0 0 0 .71.288.973.973 0 0 0 .71-.288.95.95 0 0 0 .292-.703v-2.182h.76c.291 0 .54-.103.749-.308.207-.205.311-.455.311-.75V5.365h-9v6.404Zm10.495-6.587a.983.983 0 0 0-.702.278.91.91 0 0 0-.293.685v4.063c0 .271.098.501.293.69a.97.97 0 0 0 .702.284c.28 0 .517-.095.712-.284a.924.924 0 0 0 .293-.69V6.146a.91.91 0 0 0-.293-.685.995.995 0 0 0-.712-.278m-12.702.283a.985.985 0 0 1 .712-.283c.273 0 .507.094.702.283a.913.913 0 0 1 .293.68v4.063a.932.932 0 0 1-.288.69.97.97 0 0 1-.707.284.986.986 0 0 1-.712-.284.924.924 0 0 1-.293-.69V6.146c0-.264.098-.491.293-.68Z"/>
									</svg></i>수정</a></li>
									<li><a href="#" class="deleteTab ml-2"data-target="#modal" data-post-id="${recipe.post.id}"><i class="icon-trash"></i> 삭제</a></li>
								</ul>
							</div>
						</div>
				 </c:if> 		
			</div>
		<div class="caption_userpage">
				<span>${recipe.post.subject}</span>
				<p class="jq_elips d-flex justify-content-between">
				<a>${recipe.user.nickName}</a>
				<span></span>
				</p>
			</div>
		
		
		</li>
		
		</c:forEach>
	</ul>
	<!-- 모달 -->
	<!-- Modal -->

<!-- Modal -->

	
</div> <!-- brand_cont -->
	
<div class="myhome_main" style="margin-bottom:20px;">
    <div class="myhome_main_t" style="background:url(https://m.outback.co.kr/upload/product/20230712/20230712192117981110.jpg) left top no-repeat; background-size:cover;"></div>
    <div class="myhome_main_info">
        <div class="info_pic">
            <a href="javascript:void(0);" onclick="$('#vProfileImageModal').modal('show')"><img src="https://recipe1.ezmember.co.kr/cache/rpf/2021/12/20/d861aa30336766e1d23358b5d875baae1.jpg"></a>
            <a href="javascript:void(0);" class="info_set" onclick="$('#vProfileImageModal').modal('show')"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_camera2.png" alt="사진변경"
            data-toggle="tooltip" data-placement="right" data-original-title="프로필 사진 변경"></a>
        </div>
        <p class="info_name"><b>${user.nickName}</b>
                <span class="glyphicon glyphicon-pencil"></span><a href="javascript:void(0);"></a>
                </p>

        <div class="info_follow2">
                        <a href="javascript:void(0);">총조회<b>${rankingView.viewCount_sum}</b></a><span>·</span>
            <a href="javascript:void(0);" onclick="viewFriendList('follower')">팔로워<b>${rankingView.followerCount}</b></a><span>·</span><a href="javascript:void(0);">팔로잉<b>1</b></a>
        </div>
        
        <button class="userViewFolloweBtn btn-info form-control w-50">팔로우</button>
        
    </div>
</div>
</div> <!--  container -->
<script>


	$(document).ready(function() {
			
		
				$('.deleteTab').on('click', function(e){
					/*e.preventDefault();*/
					$('#modal').removeClass('d-none');/* 
					$('#modal').addClass('d-flex');/*   */
					let postId = $(this).data("post-id");
					$("#modal").data("post-id", postId); 
					
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
			
				
				$('#cancelBtn').on('click', function(){
					$('#modal').addClass('d-none'); 

				});
				
				// 모달 시작
				
				
				// 수정 누르기
				$(".updateTab").on('click', function(e){
					e.preventDefault();
					
					let postId = $(this).data("post-id");
					$("#modal").data("post-id", postId); 
					alert(postId);
					
					/* $.ajax({
						type:"GET"
						, url:"/post/post-update/" + postId
						, success : function(data) {
							location.href=url;	
						}
						, error : function(request, status, error) {
							alert("에러");
						}
					}); */
					
					location.href="/post/post-update/" + postId;
					
				});
				
				
			
			
			// cook controller
		
	
		
		$('.userViewFolloweBtn').on('click', function() {
			let userId = $('#postLink').data('user-id');
			let postId = $('#postLink').data('post-id');
			let serverUserId = $('#postLink').data('server-id'); 
			let followedUserId = $('#postLink').data('user-id');
			let followingUserId = $('.cont-list').data('server-id'); 
			alert(followingUserId);
			
			$.ajax({
				type:"POST"
				, url:"/like/userView-follow"
				, data: {"followingUserId":followingUserId ,"followedUserId":followedUserId}
				, success : function(data) {
					if(data.code == 200) {
					alert("!!@#@#");
						}
					}
				, error : function(request, status, error) {
					alert("에러!!!");
				}
			});
		});
	});
</script>