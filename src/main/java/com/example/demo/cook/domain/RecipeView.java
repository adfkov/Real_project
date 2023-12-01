package com.example.demo.cook.domain;

import java.util.List;

import com.example.demo.post.entity.PostEntity;
import com.example.demo.user.Entity.UserEntity;

import lombok.Data;

@Data
public class RecipeView {
	private List<PostEntity> postList;
	
	private PostEntity post;
	
	private UserEntity user;
//	
//	private List<CommentView> commentList
	
//	private int likeCount;
	
}
