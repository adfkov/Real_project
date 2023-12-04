package com.example.demo.cook;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.postLike.BO.PostLikeBO;

@RestController
@RequestMapping("/cook")
public class CookRestController {
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private PostLikeBO postLikeBO;
	
	@PostMapping("/post-like/{postId}")
	public Map<String, Object> returnPostPage(
			@PathVariable int postId
			,HttpSession session
			) {

		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		
		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(userId, postId);
		
		result.put("recipeView", recipeView);
		result.put("code", 200);
				
		return result;
		}
	
//	@PostMapping("/get-likeCount")
//	public Map<String, Object> getLikeCount(
//			@RequestParam("postUserId") int postUserId
//			, @RequestParam("postId") int postId) {
//		Map<String, Object> result = new HashMap<>();
//		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId);
//		int postLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(postUserId, postId);
//		recipeView.setPostLikeCount(postLikeCount);
//		
//		result.put("recipeView", recipeView);
//		
//		return result;
//	}
//	
	
	
	}

	
