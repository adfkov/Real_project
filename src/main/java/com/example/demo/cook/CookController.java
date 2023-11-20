package com.example.demo.cook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/cook")
public class CookController {
	// http://localhost:7080/cook/easycook
	@GetMapping("/easycook")
	public String cookLayout() {
		return "template/easycook";
	}
	
	
}
