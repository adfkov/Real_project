package com.example.demo.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.post.BO.PostBO;
import com.example.demo.post.entity.PostEntity;

@Service
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostBO postBO;	
	
	@GetMapping("/go-to-page")
	public String goToPage(Model model) {
		model.addAttribute("viewName", "recipe/postPage");
		return "template/easycook";
	}
	
	@GetMapping("/post-update/{postId}")
	public String postUpdate(Model model
			, @PathVariable("postId") int postId
			,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		PostEntity post = postBO.getPostpageByUserIdAndPostId(userId, postId);
		
		model.addAttribute("postId" , postId);
		model.addAttribute("post", post);
		model.addAttribute("viewName", "recipe/postUpdate");
		return "template/easycook";
	}
	
	}
		

