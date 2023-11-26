package com.example.demo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserBO userBO;
	/**
	 * 아이디 중복 검사
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		// db 조회
		UserEntity user = userBO.getDuplicatedLoginId(loginId);
//		String duplicatedId = user.getLoginId();
		// 
		Map<String, Object> result = new HashMap<>();
		
		if(user == null) 
		{
			// 중복 아님
			result.put("isDuplicated", false);
		} else {
			result.put("isDuplicated", true);
		}
		return result;
		
	}
	/**
	 * 닉네임 중복 검사
	 * @param nickName
	 * @return
	 */
	@RequestMapping("/is_duplicated_nickName")
	public Map<String, Object> isDuplicatedNickName(
			@RequestParam("nickName") String nickName) {
		// db 조회
		UserEntity user = userBO.getDuplicatedNickname(nickName);
		//String duplicatedNickName = user.getNickName();
		// 리턴
		Map<String, Object> result = new HashMap<>();
		
		if(user == null) { // 중복 아님
			result.put("isDuplicated", false);
		} else { // 중복
			result.put("isDuplicated", true);
		}
		
		return result;
	}
	/**
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @param nickName
	 * @param profileImageUrl
	 * @param interest
	 * @return
	 */
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password, 
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("nickName") String nickName,
			@RequestParam("grade") String grade,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("birth") String birth,
			@RequestParam("userGender") String userGender,
			@RequestParam("interest") String interest) {
		
		Map<String, Object> result = new HashMap<>();
		// db insert
		Integer id = userBO.addUser(loginId, password, name, email, nickName,grade, profileImageUrl,birth,userGender, interest);
		// map
		
		if(id == null) {
			result.put("code", 500);
			result.put("errorMessage", "회원가입 하는데 실패했습니다.");
		} else {
		
			result.put("code", 200);
			result.put("result", "성공");
		}
		return result;
	}
	
	@PostMapping("/sign-in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			, HttpServletRequest request
			, Model model) {
		Map<String, Object> result = new HashMap<>();
		
		// db insert
		UserEntity user = userBO.getUserEntityByLoginIdPassword(loginId, password);
		
		if(user == null) { // 로그인 실패
			result.put("code", 500);
		} else { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userNickName", user.getNickName());
			session.setAttribute("userLoginId", user.getLoginId());
			
			
			result.put("code", 200);
			result.put("nickName", user.getNickName());
		}
		
		return result;
	}
	

	
	
	
	
}
