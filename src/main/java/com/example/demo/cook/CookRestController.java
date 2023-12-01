package com.example.demo.cook;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;

@RestController
@RequestMapping("/cook")
public class CookRestController {
	@Autowired
	private RecipeBO recipeBO;
	
//	@PostMapping("/go-to-post/{postId}")
//	public Map<String, Object> returnPostPage(
//			@PathVariable int postId
//			,HttpSession session
//			) {
//
//		Map<String, Object> result = new HashMap<>();
//		Integer userId = (Integer) session.getAttribute("userId");
//		
//		RecipeView recipeView = recipeBO.getRecipeView(userId, postId);
//		
//		result.put("recipeView", recipeView);
//		result.put("code", 200);
//		
//		return result;
	}
	

	
