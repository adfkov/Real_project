package com.example.demo.cook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.post.BO.PostBO;
import com.example.demo.postLike.BO.PostLikeBO;
import com.example.demo.view.BO.ViewBO;
@Controller
@RequestMapping("/cook")
public class CookController {
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private PostBO postBO;
	@Autowired
	private PostLikeBO postLikeBO;
	@Autowired
	private ViewBO viewBO;
	
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
		model.addAttribute("viewName", "user/userRecipeView");
		
		return "template/easycook";
	}
	
	// post 눌렀을 때
	@GetMapping("/go-to-post/{userId}/{postId}")
	public String goToPostpage(
			@PathVariable int userId
			,@PathVariable int postId
			, Model model
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Integer serverUserId = (Integer)session.getAttribute("userId");
		
		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(userId,postId);
		// 글 좋아요
		int postLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(userId, postId);
		recipeView.setPostLikeCount(postLikeCount);
		// 유저가 좋아요를 눌렀는 지 여부
		boolean ifPostLike = postLikeBO.getIfPostLikeByUserIdPostId(userId, postId);
		recipeView.setIfPostLike(ifPostLike);
		
		// 조회수 업데이트
		viewBO.addViewByUserIdPostId(userId, postId, serverUserId);
		
		model.addAttribute("serverUserId", serverUserId);
		model.addAttribute("recipeView" , recipeView);
		model.addAttribute("viewName", "recipe/postPage");
		return "template/easycook";
	}
	
	@GetMapping("/go-to-userView/{userId}")
	public String goToUserView(
			@PathVariable int userId
			,Model model) {
		List<RecipeView> recipeView = recipeBO.generateRecipeViewList(userId);
		model.addAttribute("recipeViewList", recipeView);
		model.addAttribute("viewName", "user/userRecipeView");
		
		return "template/easycook";
	}
	
}

