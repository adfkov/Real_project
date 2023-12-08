package com.example.demo.postLike;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.example.demo.view.BO.ViewBO;

@RequestMapping("/post-like")
@RestController
public class PostLikeRestController {
	@Autowired
	private PostLikeBO postLikeBO;
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private ViewBO viewBO;
	
	@PostMapping("/like/{postUserId}/{postId}")
	public Map<String, Object> postLikeByPostId(
			@PathVariable int postUserId,
			@PathVariable int postId,
			HttpSession session
		) {
		Map<String, Object> result = new HashMap<>();
		

		Integer serverUserId = (Integer) session.getAttribute("userId");
		if(serverUserId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 안 됐습니다.");
			
			return result;
		}
		// DB INSERT
		
		postLikeBO.tellLikeToggle(postUserId, postId, serverUserId);
		
		
		viewBO.minusViewByUserIdPostId(postUserId, postId, serverUserId);
		
		result.put("code", 200);
		
		
		return result;
		
	}
	
	@DeleteMapping("/like/{postUserId}/{postId}")
	public Map<String, Object> deletePostLikeByPostId(
			@PathVariable int postUserId,
			@PathVariable int postId,
			HttpSession session
		) {
		Map<String, Object> result = new HashMap<>();
		

		Integer serverUserId = (Integer) session.getAttribute("userId");
		if(serverUserId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 안 됐습니다.");
			
			return result;
		}
		// DB INSERT
		
		postLikeBO.tellLikeToggle(postUserId, postId, serverUserId);
		
		
		viewBO.minusViewByUserIdPostId(postUserId, postId, serverUserId);
		
		result.put("code", 200);
		
		
		return result;
		
	}
}
	
	
//	@DeleteMapping("/like-cancel")
//	public Map<String, Object> likeCancel(
//				@RequestParam("postUserId") int postUserId,
//			@RequestParam("postId") int postId,
//			@RequestParam("userId") int userId
//			) {
//		Map<String, Object> result = new HashMap<>();
//		postLikeBO.deleteLikeByUserIdPostId(postUserId, postId, userId);
//		
//		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId);
//		recipeView.setIfPostLike(false);
//		viewBO.minusViewByUserIdPostId(postUserId, postId, userId);
//		
//		int userPostLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(userId, postId);
//		recipeView.setPostLikeCount(userPostLikeCount);
//		
//		result.put("recipeView", recipeView);
//		result.put("code", 200);
//		return result;
////	}
//}
