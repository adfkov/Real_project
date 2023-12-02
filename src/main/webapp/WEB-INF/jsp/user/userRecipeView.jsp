<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrap d-flex w-100">
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
	<ul class="cont-list">
		<c:forEach items="${recipeViewList}" var="recipe">
		<li>
		<a href="/cook/go-to-post/${recipe.user.id}/${recipe.post.id}" id="postLink" data-user-id="${recipe.user.id}"
		data-post-id="${recipe.post.id}">
			<img src="${recipe.post.mainImageUrl}" width=200px height=130px>
	
		<div class="caption">
				<h4>${recipe.post.subject}</h4>
				<p class="jq_elips">${recipe.user.nickName}</p>
			</div>
		
				</a>
		</li>
		</c:forEach>
	</ul>
	
	
</div> <!-- brand_cont -->
	<c:if test="${!empty userId}">
	<div class="user-info-area">
	팔로잉: <span id="follwers"></span>
	</div>
	</c:if>
</div> <!--  container -->
<script>
	$(document).ready(function() {
	
			let userId = $('#postLink').data('user-id');
			let postId = $('#postLink').data('post-id');
		$('#postLink').on('click', function() {
			alert(typeof userId);
			$.ajax({
				
				url:"/cook/go-to-post/"+ userId + postId
				,data:{"userId": userId}
				, sucess:function(data){
					if(data.code == 200) {
					location.href="/user/sign-in-view"
					}
				}
				, error : function(request, status, error) {
					alert("보내기 실패");
				}
			});
		}); <!-- postLink 끝-->
		
		
		$.ajax({
			type:"POST"
			, url: "/like/get-follower-count"
			, data : {"userId": userId}
			, success: function(data) {
				alert("팔로워 수 가져오기 성공");
				$('#follwers').text(data.followerCount);
			}
			, error : function(request, status, error) {
				alert("팔로워 수 가져오기 실패");
			}
		});
	});
</script>