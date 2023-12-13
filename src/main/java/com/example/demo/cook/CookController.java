package com.example.demo.cook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.cook.BO.RankingBO;
import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RankingView;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.like.domain.FollowerList;
import com.example.demo.postLike.domain.PostLiker;
import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;
import com.example.demo.view.BO.ViewBO;

@Controller
@RequestMapping("/cook")
public class CookController {
	@Autowired
	private RankingBO rankingBO;
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private ViewBO viewBO;
	@Autowired
	private UserBO userBO;
	

	// http://localhost:7080/cook/easycook
	@GetMapping("/easycook")
	public String cookLayout(Model model) {
		List<RecipeView> recipeViewList = recipeBO.generateRecipeViewListAll(null);
		
		model.addAttribute("recipeViewList", recipeViewList);
		model.addAttribute("viewName", "recipe/mainPage");
		return "template/easycook";
	}

	@GetMapping("/writeRecipe")
	public String writeRecipePage(Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId == null) {
			model.addAttribute("viewName", "user/signIn");
		} else {
			model.addAttribute("viewName", "recipe/writeRecipe");
		}
		return "template/easycook";
	}
 
	@GetMapping("/get-user-post") // 마이 페이지
	public String getUserPost(Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId == null) {
			model.addAttribute("viewName", "user/signIn");
		} else {
		
		List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(userId);
		UserEntity user = userBO.getUserEntityById(userId);
		
		List<RankingView> rankingViewList = rankingBO.getRankingView();
		for(RankingView rankingView : rankingViewList) {
			if(rankingView.getUserId() == userId) {
				model.addAttribute("rankingView" ,rankingView);
				break;
			}
		}
		
		model.addAttribute("user", user);
		model.addAttribute("userId", userId);
		model.addAttribute("recipeViewList", recipeViewList);
		model.addAttribute("viewName", "user/userRecipeView");
		}
		return "template/easycook";
	}

	// post 눌렀을 때 cook/go-to-userView/{userId
	@GetMapping("/go-to-post/{userId}/{postId}")
	public String goToPostpage(@PathVariable int userId, 
			@PathVariable int postId, 
			Model model,
			HttpSession session) {
		boolean filledLiker = false;
		boolean Following = false;

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
					Following = true;
				}
			}
			
			List<PostLiker> postLiker = postRecipeView.getPostLiker();
			for(PostLiker liker : postLiker) {
				if(liker.getUserId() == serverUserId) {
					filledLiker = true;
				}
			}
		} else {
			viewBO.addViewByUserIdPostId(userId, postId, serverUserId);
			int view = viewBO.getViewByUserIdPostId(userId, postId);
			postRecipeView.setView(view);
		}
		
		
		model.addAttribute("recipeView", postRecipeView);
		
		model.addAttribute("filledLiker", filledLiker);
		model.addAttribute("Following", Following);
		model.addAttribute("serverUserId", serverUserId);
		model.addAttribute("viewName", "recipe/postPage");
		return "template/easycook";
	}

	@GetMapping("/go-to-userView/{userId}")
	public String goToUserView(@PathVariable int userId, Model model, HttpSession session) {
		List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(userId);
		UserEntity user = userBO.getUserEntityById(userId);
		Integer serverId = (Integer) session.getAttribute("userId");
		
		List<RankingView> rankingViewList = rankingBO.getRankingView();
		for(RankingView rankingView : rankingViewList) {
			if(rankingView.getUserId() == userId) {
				model.addAttribute("rankingView" ,rankingView);
				break;
			}
		}
		
		model.addAttribute("user", user);
		model.addAttribute("userId", userId);

		model.addAttribute("serverId", serverId);
		model.addAttribute("recipeViewList", recipeViewList);
		
		model.addAttribute("recipeViewList", recipeViewList);
		model.addAttribute("viewName", "user/userRecipeView");

		return "template/easycook";
	}
	
	// 랭킹 진입
	@GetMapping("/user-ranking")
	public String userRankingView(Model model) {
	
		List<RankingView> rankingViewList = rankingBO.getRankingView();
		model.addAttribute("rankingViewList",rankingViewList);
		
		model.addAttribute("viewName", "user/userRankingView");
		return "template/easycook";
	}
	
	@GetMapping("/user-ranking/{alignId}")
	public String userRankingViewBySort(@PathVariable int alignId,Model model) {
		List<RankingView> rankingViewList = rankingBO.getRankingViewByAlignId(alignId);
		model.addAttribute("rankingViewList_s", rankingViewList);
		model.addAttribute("viewName", "user/userRankingViewSort");
		return "template/easycook";
		
	
	}
	
	
	// 추천 레시피
	@GetMapping("/recommend-recipe")
	public String recommendRecipe(Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId != null) {
			UserEntity user = userBO.getUserEntityById(userId);
			List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(userId);
			for(RecipeView rv : recipeViewList) {
				if(rv.getPost().getFoodTypeId() == user.getInterest()) {
					recipeViewList.add(rv); // 취향 같으면 표시
				}
				
				
			}
			
		}
		
		model.addAttribute("viewName", "");
		return "template/easycook";
	}
	
	@GetMapping("/category")
	public String recipeCategory(Model model) {
		
		model.addAttribute("viewName", "recipe/category");
		return "template/easycook";
	}

}
