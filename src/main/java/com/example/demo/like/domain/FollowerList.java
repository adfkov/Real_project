package com.example.demo.like.domain;

import java.util.List;

import com.example.demo.user.Entity.UserEntity;

import lombok.Data;

@Data
public class FollowerList {
	
	
	private List<UserEntity> followers;
	
	private int followedUserId;
	
	
}
