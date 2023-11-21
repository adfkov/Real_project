package com.example.demo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.BO.UserBO;
import com.example.demo.user.domain.UserEntity;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	UserBO userBO;
	
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		// db 조회
		
		// 
		Map<String, Object> result = new HashMap<>();
		
//		if(result == null) 
//		{
//			// 중복 아님
//			result.put("isDuplicated", false);
//		} else {
//			result.put("isDuplicated", true);
//		}
		return result;
		
	}
	
	@RequestMapping("/is_duplicated_nickName")
	public Map<String, Object> isDuplicatedNickName(
			@RequestParam("nickName") String nickName) {
		// db 조회
		
		// 리턴
		Map<String, Object> result = new HashMap<>();
		
//		if(result == null) {
//			result.put("isDuplicated", false);
//		} else {
//			result.put("isDuplicated", true);
//		}
		
		return result;
	}
	
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password, 
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("nickName") String nickName,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("interest") String interest) {
		
		// db insert
		UserEntity user = ;
		// map
		
		Map<String, Object> result = new HashMap<>();
		if(id == null) {
			result.put("code", 500);
			result.put("errorMessage", "회원가입 하는데 실패했습니다.");
		} else {
		
			result.put("code", 200);
			result.put("result", "성공");
		}
		return result;
	}
	
	
	
}
