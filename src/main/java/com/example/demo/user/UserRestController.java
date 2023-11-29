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
import org.springframework.web.multipart.MultipartFile;

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
			@RequestParam(value="file" , required = false) MultipartFile file,
			@RequestParam("birth") String birth,
			@RequestParam("userGender") String userGender,
			@RequestParam("interest") String interest) {
		
		Map<String, Object> result = new HashMap<>();
		// db insert
		Integer id = userBO.addUser(loginId, password, name, email, nickName,grade, file,birth,userGender, interest);
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
		
		// db select
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
	
	@PostMapping("/get-user-info")
	public Map<String, Object> getUserInfo(HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		
		int userId = (int) session.getAttribute("userId");
		// db select
		UserEntity user = userBO.getUserEntityById(userId);
		if(user != null) {
			result.put("code", 200);
			result.put("userEmail", user.getEmail());
			result.put("userNickName", user.getNickName());
			result.put("userInterest", user.getInterest());
			return result;
		} else {
			result.put("code", 500);
			return result;
			
		}
		
		
	}
	
	@PostMapping("/update-user-email")
	public Map<String, Object> updateUserInfo(
			@RequestParam("beforeEmail") String beforeEmail
			,@RequestParam("afterEmail") String afterEmail) {
		
		Map<String, Object> result = new HashMap<>();
		
		// db update
		userBO.updateUserEmail(beforeEmail, afterEmail);
		
		
		result.put("code", 200);
		
		return result;
	}
	
	@PostMapping("/update-user-nickName")
	public Map<String, Object> updateUserNickName(
			@RequestParam("beforeNickName") String beforeNickName
			,@RequestParam("afterNickName") String afterNickName) {
		
		Map<String, Object> result = new HashMap<>();
		
		// db update
		userBO.updateUserNickName(beforeNickName,afterNickName);
	
		result.put("code", 200);
		return result;
	}
	
	@PostMapping("/update-user-interest")
	public Map<String, Object> updateUserInterest(
			@RequestParam("beforeInterest") String beforeInterest
			,@RequestParam("afterInterest") String afterInterest) {
		Map<String, Object> result = new HashMap<>();
		
		// db update
		userBO.updateUserInterest(beforeInterest,afterInterest);
	
		result.put("code", 200);
		return result;
	}
	
}
