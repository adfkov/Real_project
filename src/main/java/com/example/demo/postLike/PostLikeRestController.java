package com.example.demo.postLike;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.postLike.BO.PostLikeBO;

@RequestMapping("/post-like")
@RestController
public class PostLikeRestController {
	@Autowired
	private PostLikeBO postLikeBO;
	@Autowired
	private RecipeBO recipeBO;
	
	@PostMapping("/like/{postUserId}/{postId}/{userId}")
	public Map<String, Object> postLikeByPostId(
			@PathVariable int postUserId,
			@PathVariable int postId,
			@PathVariable int userId
		) {
		Map<String, Object> result = new HashMap<>();
		// DB INSERT
		postLikeBO.postLikeByUserIdPostId(postUserId, postId, userId);
		
		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId);
		recipeView.setIfPostLike(true);
		
		
		result.put("code", 200);
		result.put("recipeView", recipeView);
		
		return result;
		
	}
	
	@PostMapping("/like/is-like")
	public Map<String, Object> getIfUserLike(
			@RequestParam("postUserId") int postUserId,
			@RequestParam("postId") int postId) {
		Map<String, Object> result = new HashMap<>();
		
		int userPostLike = postLikeBO.getPostLikeCountByUserIdPostId(postUserId, postId);
		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId);
		
		
		if(userPostLike == 1) {
		
			recipeView.setIfPostLike(true);
			
			result.put("code", 200);
			result.put("recipeView", recipeView);
		} else {
			recipeView.setIfPostLike(false);
			result.put("recipeView", recipeView);
		}
		
		return result;
	}
	
	@DeleteMapping("/like-cancel")
	public Map<String, Object> likeCancel(
			@RequestParam("postUserId") int postUserId,
			@RequestParam("postId") int postId,
			@RequestParam("userId") int userId
			) {
		Map<String, Object> result = new HashMap<>();
		postLikeBO.deleteLikeByUserIdPostId(postUserId, postId, userId);
		
		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId);
		recipeView.setIfPostLike(false);
		
		result.put("recipeView", recipeView);
		result.put("code", 200);
		return result;
	}
}