package com.example.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.user.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	public UserEntity findAllByLoginId(String loginId);
	
	public UserEntity findAllByNickName(String nickName);
	
	public UserEntity findAllByLoginIdAndPassword(String loginId, String password);
}
