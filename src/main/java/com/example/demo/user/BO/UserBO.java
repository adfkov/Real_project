package com.example.demo.user.BO;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.Entity.UserEntity;
import com.example.demo.user.repository.UserRepository;



@Service
public class UserBO {
	@Autowired
	private UserRepository userRepository;
	// 회원가입 정보 db 에 insert
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
	// 로그인 아이디 중복
	public UserEntity getDuplicatedLoginId(String loginId) {
		return userRepository.findAllByLoginId(loginId);
		
	}
	// 닉네임 중복
	public UserEntity getDuplicatedNickname(String nickName) {
		return userRepository.findAllByNickName(nickName);
	}
	
	
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findAllByLoginIdAndPassword(loginId, password);
	}
}