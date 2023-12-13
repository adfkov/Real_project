package com.example.demo.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.AOP.TimeTrace;

@Controller
@RequestMapping("/user")
public class UserController {
	// http://localhost:7080/user/sign-in-view
	@TimeTrace
	@GetMapping("/sign-in-view")
	public String signInView(Model model) {
		model.addAttribute("viewName", "user/signIn");
		return "template/easycook";
	}
	// http://localhost:7080/user/sign-up-view
	@GetMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "user/signUp");
		return "template/easycook";
	}
	
	// http://localhost:7080/user/profile-modify
	@GetMapping("/profile-modify")
	public String profileModify(Model model) {
		model.addAttribute("viewName", "user/profileModify");
		return "template/easycook";
	}
	
	// 로그아웃
	// http://localhost:7080/user/sign-out
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userNickName");
		session.removeAttribute("userLoginId");
		
		return "redirect:/user/sign-in-view";
	}
	
	// MY 홈 들어가기 
	@RequestMapping("/go-my-home")
	public String goMyHome(Model model) {
		model.addAttribute("viewName", "user/userHome");
		return "template/easycook";
	}
	// 유저 홈
	@RequestMapping("/user-recipe-view")
	public String userRecipeView(Model model) {
		model.addAttribute("viewName", "user/userRecipeView");
		return "template/easycook";
	}
	
	// 회원 랭킹
	
	 //레시피 보관함
	@RequestMapping("/go-scrap-page")
	 public String goScrapPage(Model model) {
		 model.addAttribute("viewName", "user/")
	 }

}


