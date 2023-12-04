package com.example.demo.postLike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.postLike.BO.PostLikeBO;

//@Service
//public class PostLikeController {
//	@Autowired
//	private RecipeBO recipeBO;
//	@Autowired
//	private PostLikeBO postLikeBO;
//	
//	@GetMapping("/")
//	
//	
//	int postLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(userId, postId);
//	recipeView.setPostLikeCount(postLikeCount);
//	
//	// 글 좋아요
//	int postLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(userId, postId);
//	recipeView.setPostLikeCount(postLikeCount);
//	// 유저가 좋아요를 눌렀는 지 여부
//	boolean ifPostLike = postLikeBO.getIfPostLikeByUserIdPostId(userId, postId);
//	recipeView.setIfPostLike(ifPostLike);
//}
