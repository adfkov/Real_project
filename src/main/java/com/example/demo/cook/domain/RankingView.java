package com.example.demo.cook.domain;

import javax.persistence.Column;

import com.example.demo.like.domain.FollowerList;

import lombok.Data;

@Data
public class RankingView {
	/*	
	 	프로필 사진
		유저 닉네임
		등급
		관심분야
		올린 글 수
		총 조회 수
		총 추천 수
		총 팔로워
*/
	private String profileImageUrl;
	private String userNickName;
	private String grade;
	private String interest;
	//
	@Column(columnDefinition = "integer default 0", nullable = false)
	private int postCount_sum;
	@Column(columnDefinition = "integer default 0", nullable = false)
	private int viewCount_sum;
	@Column(columnDefinition = "integer default 0", nullable = false)
	private int postLikeCount_sum;
	
	private FollowerList followerList;
	public void setFollowerList(FollowerList followerList2) {
		this.followerList = followerList2;
		
	}
	
}
