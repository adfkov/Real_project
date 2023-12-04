package com.example.demo.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.view.BO.ViewBO;

@RestController
@RequestMapping("/view")
public class ViewRestController {
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private ViewBO viewBO;
	
	@PostMapping("/view-post")
	public Map<String, Object> viewPost(
			@RequestParam("postUserId") int postUserId,
			@RequestParam("postId") int postId,
			@RequestParam("userId") int userId) {
		Map<String ,Object> result = new HashMap<>();
		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId); 
		
		viewBO.addViewByUserIdPostId(postUserId, postId, userId);
		int viewCount = viewBO.getViewByUserIdPostId(postUserId, postId);
		recipeView.setView(viewCount);
		
		result.put("code",200);
		return result;
	}
	
	
	// 조회수 업데이트
			
}
