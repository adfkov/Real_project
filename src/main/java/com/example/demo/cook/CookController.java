package com.example.demo.cook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.like.BO.LikeBO;
import com.example.demo.like.domain.FollowerList;
import com.example.demo.post.BO.PostBO;
import com.example.demo.postLike.BO.PostLikeBO;
import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;
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
	private LikeBO likeBO;
	@Autowired
	private ViewBO viewBO;
	@Autowired
	private UserBO userBO;

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

		model.addAttribute("userId", userId);
		model.addAttribute("recipeViewList", recipeViewList);
		model.addAttribute("viewName", "user/userRecipeView");

		return "template/easycook";
	}

	// post 눌렀을 때
	@GetMapping("/go-to-post/{userId}/{postId}")
	public String goToPostpage(@PathVariable int userId, 
			@PathVariable int postId, 
			Model model,
			HttpSession session) {

		List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(userId);
		Integer serverUserId = (Integer) session.getAttribute("userId");
		RecipeView postRecipeView = null;
		
		for(RecipeView recipeView : recipeViewList) {
			if(recipeView.getPost().getId() == postId) {
				postRecipeView = recipeView;
			}
		}
		if(serverUserId != null) {
			viewBO.addViewByUserIdPostId(userId, postId, serverUserId);
			int view = viewBO.getViewByUserIdPostId(userId, postId);
			postRecipeView.setView(view);
			
			FollowerList followerList = postRecipeView.getFollowerList();
			List<UserEntity> userList = followerList.getFollowers();
			for(UserEntity user: userList) {
				if(user.getId() == serverUserId) {
					postRecipeView.setFollowing(true);
				}
			}
		}
		
		
		model.addAttribute("recipeView", postRecipeView);
		
		
		model.addAttribute("serverUserId", serverUserId);
		model.addAttribute("viewName", "recipe/postPage");
		return "template/easycook";
	}

	@GetMapping("/go-to-userView/{userId}")
	public String goToUserView(@PathVariable int userId, Model model) {
		List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(userId);
		
		model.addAttribute("recipeViewList", recipeViewList);
		model.addAttribute("viewName", "user/userRecipeView");

		return "template/easycook";
	}

}
