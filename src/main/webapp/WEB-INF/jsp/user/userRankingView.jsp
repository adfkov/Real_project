<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container"> 
	<p class="rank-info">
		<img src="https://image.dongascience.com/Photo/2023/04/16806753035307.jpg" class="w-100" height="100px">
	</p>
   	
   	<p class="align-buttons">
   		<button type="view_align_button">조회순</button>
   		<button type="postLike_align_button">추천순</button>
   		<button type="follower_align_button">팔로워순</button>
   	</p>
	<table class="table text-center">
		<tr>
			<th>순위</th>
			<th>닉네임</th>
			<th>등급</th>
			<th>관심 분야</th>
			<th>업로드 레시피 수</th>
			<th>총 조회수</th>
			<th>총 추천수</th>
			<th>팔로워 수</th>
		</tr>
		<c:forEach items="${rankingViewList}" var="rankingView" varStatus="status">
			<tr><!-- 첫번째 줄 시작 -->
				<td>${status.count}</td>
			    <td class="d-flex">
			    <a class="a" href="/cook/go-to-userView/${rankingView.userId}">
			    <img id="profileImage" src="${rankingView.profileImageUrl}" width="20px" height="20px">
			    <span class="nickName ml-1">${rankingView.userNickName}</span>
			    </a>
			    </td>
			    <td>${rankingView.grade}</td>
			    <td>${rankingView.interest}</td>
			    <td>${rankingView.postCount_sum}</td>
			    <td>${rankingView.viewCount_sum}</td>
			    <td>${rankingView.postLikeCount_sum}</td>
			    <td>${rankingView.followerCount}</td>
			</tr><!-- 첫번째 줄 끝 -->
		</c:forEach>
    </table>
</div>