package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	@ResponseBody
	@GetMapping("/1")
	public String test() {
		return "고생길 시작이야!";
	}
	
	@GetMapping("/2")
	public String test1() {
		return "test/test";
	}
	
	

}

