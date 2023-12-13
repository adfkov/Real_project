package com.example.demo.cook.domain;

import java.util.List;

import javax.persistence.Column;

import com.example.demo.comment.domain.CommentView;
import com.example.demo.like.domain.FollowerList;
import com.example.demo.post.entity.PostEntity;
import com.example.demo.postLike.domain.PostLiker;
import com.example.demo.user.Entity.UserEntity;

import lombok.Data;

@Data
public class RecipeView {
//	private List<PostEntity> postList;
	
	private PostEntity post;
	private UserEntity user;
	private int postLikeCount;
	private boolean filledLike;
	@Column(columnDefinition = "integer default 0", nullable = false)
	private int view;
//	private int likeCount;
	private List<PostLiker> postLiker;
	
	private List<UserEntity> postLikerUser;
	private List<CommentView> commentViewList;
	// 스크랩 미정
	private FollowerList followerList;
	public void setFollowerList(FollowerList followerList2) {
		this.followerList = followerList2;
		
	}
	
}
