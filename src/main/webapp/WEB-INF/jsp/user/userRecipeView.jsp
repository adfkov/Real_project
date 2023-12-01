<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
	
	
</div>

<script>
	$(document).ready(function() {
	 	/* $.ajax({
			type:"get"
			, url:"/cook/get-user-post"
			, data: {}
			, success : function(data) {
				alert("!!");
				
				
			}
			, error : function(request, status, error) {
				alert("불러오기 실패");
			}
		}) 
		*/
		$('#postLink').on('click', function() {
			let userId = $('#postLink').data('user-id');
			let postId = $('#postLink').data('post-id');
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
		});
	});
</script>