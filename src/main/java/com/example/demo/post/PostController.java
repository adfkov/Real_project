package com.example.demo.post;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/post")
public class PostController {
	@GetMapping("/go-to-page")
	public String goToPage(Model model) {
		model.addAttribute("viewName", "recipe/postPage");
		return "template/easycook";
	}
	
	}
		

