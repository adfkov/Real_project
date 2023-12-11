<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container"> 
	<p class="rank-info">
		<img src="https://image.dongascience.com/Photo/2023/04/16806753035307.jpg" class="w-100" height="100px">
	</p>
   
	<table class="table text-center">
		<tr>
			<th>닉네임</th>
			<th>등급</th>
			<th>관심 분야</th>
			<th>업로드 레시피 수</th>
			<th>총 조회수</th>
			<th>총 추천수</th>
			<th>팔로워 수</th>
		</tr>
		<c:forEach items="${rankingViewList}" var="rankingView">
			<tr><!-- 첫번째 줄 시작 -->
			    <td>${rankingView.userNickName}</td>
			    <td>첫번째 칸</td>
			    <td>첫번째 칸</td>
			    <td>첫번째 칸</td>
			</tr><!-- 첫번째 줄 끝 -->
		</c:forEach>
    </table>
</div>