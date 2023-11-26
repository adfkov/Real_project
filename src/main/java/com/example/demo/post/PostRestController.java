package com.example.demo.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.post.BO.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	PostBO postBO;
	
	@PostMapping("/add-recipe")
	public Map<String, Object> addRecipe(
			@RequestParam("userId") int userId
			,@RequestParam("subject") String subject
			,@RequestParam("intro") String intro
			,@RequestParam("foodTypeId") String foodTypeId
			,@RequestParam("ingredientId") String ingredientId
			,@RequestParam("portion") String portion
			,@RequestParam("degree") String degree
			,@RequestParam("ingredient") String ingredient
			,@RequestParam("cookStepText") String cookStepText
			,@RequestParam("cookTip") String cookTip) {
		
		Map<String, Object> result = new HashMap<>();
		// db insert
		Integer id = postBO.addRecipe(
				userId
				,subject
				,intro
				,foodTypeId
				,ingredientId
				,portion
				,degree
				,ingredient
				,cookStepText
				,cookTip);
		if(id != null) {
			result.put("code", 200);
			result.put("result", "insert 성공");
		} else {
			result.put("code", 500);
		}
		return result;
	}
}
