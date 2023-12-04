package com.example.demo.cook.domain;

import java.util.List;

import javax.persistence.Column;

import com.example.demo.post.entity.PostEntity;
import com.example.demo.user.Entity.UserEntity;

import lombok.Data;

@Data
public class RecipeView {
//	private List<PostEntity> postList;
	
	private PostEntity post;
	
	private UserEntity user;
	
	private int postLikeCount;
	
	private boolean ifPostLike;
	
	@Column(columnDefinition = "integer default 0", nullable = false)
	private int view;
//	private List<CommentView> commentList
	
//	private int likeCount;
	
	private List<UserEntity> postLiker;
}
