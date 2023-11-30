package com.example.demo.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.post.BO.PostBO;
import com.example.demo.post.entity.PostEntity;

@Service
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostBO postBO;
	
	@RequestMapping("/{postId}")
	public String goToPostpage(
			@PathVariable int postId
			,@RequestParam("userId") int userId
			, Model model) {
		Map<String, Object> result = new HashMap<>();

		
		// db select 
		PostEntity post = postBO.getPostpage(userId, postId);
		model.addAttribute("post", post);
		model.addAttribute("viewName", "recipe/postPage");
	
		return "";
	}
		
}
