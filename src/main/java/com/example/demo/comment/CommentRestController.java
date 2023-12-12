package com.example.demo.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comment.BO.CommentBO;
import com.example.demo.cook.BO.RecipeBO;
import com.example.demo.user.BO.UserBO;
import com.example.demo.view.BO.ViewBO;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
	@Autowired
	private CommentBO commentBO;
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private UserBO userBO;
	@Autowired
	private ViewBO viewBO;
	
	@PostMapping("/add-comment")
	public Map<String, Object> addComment(
			@RequestParam("postUserId") int postUserId
			,@RequestParam("postId") int postId
			,@RequestParam("userId") int userId
			,@RequestParam("commentText") String commentText) {
		Map<String, Object> result = new HashMap<>();
		
		
		commentBO.addCommentByPostUserIdPostId(postUserId, postId, userId, commentText);
		viewBO.minusViewByUserIdPostId(postUserId, postId, userId);
		result.put("code", 200);
		
		return result;
	}
	
//	@PostMapping("/get-comment")
//	public Map<String, Object> getComment(
//			@RequestParam("postUserId") int postUserId
//			,@RequestParam("postId") int postId
//			,@RequestParam("userId") int userId) {
//		Map<String, Object> result = new HashMap<>();
//		
//		List<Comment> commentList =  commentBO.getCommentListByPostUserIdPostId(postUserId, postId);
//		List<CommentView> commentViewList = new ArrayList<>();
//		if(commentList == null) {
//			result.put("code", 200);
//			return result;
//		}
//		RecipeView recipeView = recipeBO.getRecipeViewByUserIdAndPostId(postUserId, postId);
//		
//		
//		for(Comment comment : commentList) {
//			CommentView commentView = new CommentView();
//			UserEntity user = userBO.getUserEntityById(comment.getUserId());
//			commentView.setComment(comment);
//			commentView.setUser(user);
//		}
//		recipeView.setCommentViewList(commentViewList);
//		
//		result.put("code", 200);
//		result.put("recipeView", recipeView);
//		return result;
//	}
	
	@DeleteMapping("/delete-comment")
	public Map<String, Object> deleteComment(
			@RequestParam("postUserId") int postUserId,
			@RequestParam("postId") int postId,
			@RequestParam("userId") int userId,
			@RequestParam("commentId") int commentId) {
		Map<String, Object> result = new HashMap<>();
		commentBO.deleteCommentByIdsAndCommentText(postUserId, postId, userId, commentId);
		viewBO.minusViewByUserIdPostId(postUserId, postId, userId);

		
		
		result.put("code", 200);
		return result;
	}
}
