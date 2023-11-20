package com.example.demo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
	//@Autowired
	// UserBO userBO;
	
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		// db 조회
		
		//
		Map<String, Object> result = new HashMap<>();
		
		if(user == null) {
			// 중복 아님
			result.put("isDuplicated", false);
		} else {
			result.put("isDuplicated", true);
		}
		return result;
		
	}
	
	
}
