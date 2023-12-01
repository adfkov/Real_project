<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="wrap">    
   <div class="postSubject d-flex justify-content-center">
   	<img src="${recipeView.post.mainImageUrl}" width="500px" height="500px">
   </div>
   <!-- 유저 info -->
   <div class="user-info">
    <a class="user_profile_link" href="/cook/go-to-userView/${recipeView.user.id}">
		<div class="d-flex justify-content-center">
		<img id="user_profile" src="${recipeView.user.profileImageUrl}" alt="user_profile">
	    </div>
	    <div class="nick_and_button d-flex justify-content-center">
	    <span class="user_nickName">${recipeView.user.nickName}</span>
		<button type="button" class="followBtn btn btn-info ml-3">팔로우</button>
		</div>
	</a>
   </div>
   <!-- 제목 , info-->
   <div class="recipe-subject">
   	<div class="subject">${recipeView.post.subject}</div>
   </div>
   
   <div class="recipe-intro ml-2">
   	<div class="intro">${recipeView.post.intro}</div>
   </div>
</div>   
