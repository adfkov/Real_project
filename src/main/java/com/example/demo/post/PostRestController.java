package com.example.demo.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.post.BO.PostBO;
import com.example.demo.post.entity.PostEntity;

@RestController
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	PostBO postBO;
	// 레시피 쓰기 창에서 레시피 등록
	@PostMapping("/add-recipe")
	public Map<String, Object> addRecipe(
			@RequestParam("userId") int userId
			,@RequestParam("subject") String subject
			,@RequestParam("intro") String intro
			,@RequestParam("foodTypeId") String foodTypeId
			,@RequestParam("ingredientId") String ingredientId
			,@RequestParam("portion") String portion
			,@RequestParam("degree") String degree
			,@RequestParam("file") MultipartFile file
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
				, file
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
	
	@PostMapping("/get-user-post")
	public Map<String, Object> getUserPost(
			HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId == null) {
			return null;
		}
		
		// db select
		List<PostEntity> userPostList = postBO.getUserPost(userId);
		
		if(userPostList == null) {
			result.put("result", "사용자가 존재하지만 올린 글이 없습니다.");
		} else {
			result.put("result", "글 발견!");
			result.put("code", 200);
			result.put("userPostList", userPostList);
		}
		
		return result;
	}
	

	
	
	}
	

