package com.example.demo.user.BO;

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
			String nickName,String grade,String profileImageUrl,
			String birth,String userGender,String interest) {
		UserEntity userEntity = userRepository.save(
				UserEntity.builder()
				.loginId(loginId)
				.password(password)
				.name(name)
				.email(email)
				.nickName(nickName)
				.grade(grade)
				.profileImageUrl(profileImageUrl)	
				.birth(birth)
				.userGender(userGender)
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
	
	public UserEntity getUserEntityById(int id) {
		return userRepository.findAllById(id);
	}
	
	public UserEntity getUserEntityByEmail(String beforeEmail) {
		return userRepository.findAllByEmail(beforeEmail);

	}
	
	public void updateUserEmail(String beforeEmail, String afterEmail) {
		UserEntity user = userRepository.findAllByEmail(beforeEmail);
		user.setEmail(afterEmail);
		userRepository.save(user);
		
	}
	public void updateUserNickName(String beforeNickName,String afterNickName) {
		UserEntity user = userRepository.findAllByNickName(beforeNickName);
		user.setNickName(afterNickName);
		userRepository.save(user);	
		}
	public void updateUserInterest(String beforeInterest, String afterInterest) {
		UserEntity user = userRepository.findAllByInterest(beforeInterest);
		user.setInterest(afterInterest);
		userRepository.save(user);	
	}
}