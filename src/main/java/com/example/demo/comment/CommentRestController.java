package com.example.demo.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comment.BO.CommentBO;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
	@Autowired
	private CommentBO commentBO;
	
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
	
}
