package com.example.demo.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comment.BO.CommentBO;
import com.example.demo.comment.domain.CommentView;
import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.cook.domain.RecipeView;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
	@Autowired
	private CommentBO commentBO;
	@Autowired
	private RecipeBO recipeBO;
	
	@PostMapping("/add-comment")
	public Map<String, Object> addComment(
			@RequestParam("postUserId") int postUserId
			,@RequestParam("postId") int postId
			,@RequestParam("userId") int userId
			,@RequestParam("commentText") String commentText) {
		Map<String, Object> result = new HashMap<>();
		
		
		commentBO.addCommentByPostUserIdPostId(postUserId, postId, userId, commentText);
		result.put("code", 200);
		
		return result;
	}
	
	@PostMapping("/get-comment")
	public Map<String, Object> getComment(
			@RequestParam("postUserId") int postUserId
			,@RequestParam("postId") int postId) {
		Map<String, Object> result = new HashMap<>();
		
		List<CommentView> commentViewList =  commentBO.getCommentListByPostUserIdPostId(postUserId, postId);
		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId);
		recipeView.setCommentList(commentViewList);
		
		result.put("code", 200);
		return result;
	}
	
	
}
