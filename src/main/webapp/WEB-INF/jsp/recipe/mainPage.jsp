<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="nav-out d-flex justify-content-center">
<nav class="navo justify-content-center w-50">
	<ul class="nav nav-fill align-items-center list-unstyled w-100 h-100">
	 <li class="nav-item"><a class="nav-a" href="#">추천 레시피</a></li>
	 <li class="nav-item"><a class="nav-a" href="#">분류</a></li>
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
	 
<div class="section mt-3">
	<ul class="all-post">
		<c:forEach items="${recipeViewList}" var="recipeView">
			<li>
				<div class="d-flex">
					<a href="/cook/go-to-post/${recipeView.user.id}/${recipeView.post.id}" id="postLink">
					
					<img src="${recipeView.post.mainImageUrl}" width=200px height=130px>
				
					</a>
				<c:if test="${recipeView.user.id eq userId}">	
					<div class="btn-group" style="width:50px; height:30px;">
							<a class="btn" data-toggle="dropdown" href="#"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
				  		<path stroke-linecap="round" stroke-linejoin="round" d="M8.25 6.75h12M8.25 12h12m-12 5.25h12M3.75 6.75h.007v.008H3.75V6.75zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zM3.75 12h.007v.008H3.75V12zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zm-.375 5.25h.007v.008H3.75v-.008zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z" />
						</svg>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/post/post-update/${recipeView.post.id}" class="ml-3" style="text-decoration:none"><i class=""></i> 수정</a></li>
								<li><a href="#" class="ml-3" style="text-decoration:none" class=""><i class=""></i> 삭제</a></li>
							</ul>
					</div>
				</c:if>
				</div>
				
				<!--  밑. 제목과 작성자 -->
				<div class="caption">
					<div class="subject ml-2">${recipeView.post.subject}</div>
					<div class="postuser mb-2">작성자 ${recipeView.user.nickName}</div>
				</div>
				
							
			</li>
		</c:forEach>
	
	</ul>

</div>