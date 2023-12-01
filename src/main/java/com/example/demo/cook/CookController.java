package com.example.demo.cook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.post.BO.PostBO;
import com.example.demo.post.entity.PostEntity;
@Controller
@RequestMapping("/cook")
public class CookController {
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private PostBO postBO;
	// http://localhost:7080/cook/easycook
	@GetMapping("/easycook")
	public String cookLayout(Model model) {
		model.addAttribute("viewName", "recipe/mainPage");
		return "template/easycook";
	}
	
	@GetMapping("/writeRecipe")
	public String writeRecipePage(Model model) {
		model.addAttribute("viewName", "recipe/writeRecipe");
		
		return "template/easycook";
	}
	
	@GetMapping("/get-user-post")
	public String getUserPost(Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(userId);
		
		model.addAttribute("recipeViewList", recipeViewList);
		model.addAttribute("viewName", "/user/userRecipeView");
		
		return "template/easycook";
	}
	
	@GetMapping("/go-to-page/{postId}")
	public String goToPostpage(
			@PathVariable int postId
			,@RequestParam("userId") int userId
			, Model model) {
		Map<String, Object> result = new HashMap<>();

		RecipeView recipeView = recipeBO.getRecipeView(userId, postId);
		model.addAttribute("recipeView", recipeView);
		model.addAttribute("viewName", "recipe/postPage");
		
		result.put("viewName", "recipe/postPage");
		// db select 
//		PostEntity post = postBO.getPostpageByUserIdAndPostId(userId, postId);
//		model.addAttribute("post", post);
//		model.addAttribute("viewName", "recipe/postPage");
//	
		return "template/easycook";
	}
}
