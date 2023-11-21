package com.example.demo.user.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.Entity.UserEntity;
import com.example.demo.user.repository.UserRepository;

@Service
public class UserBO {
	@Autowired
	UserRepository userRepository;
	
	public Integer addUser(String loginId,String password,String name,String email,
			String nickName,String profileImageUrl,String interest) {
		UserEntity userEntity = userRepository.save(
				UserEntity.builder()
				.loginId(loginId)
				.password(password)
				.name(name)
				.email(email)
				.nickName(nickName)
				.profileImageUrl(profileImageUrl)
				.interest(interest)
				.build());
		return userEntity == null? null : userEntity.getId();
	}
}
