package com.example.demo.like.domain;

import java.util.List;

import lombok.Data;

@Data
public class FollowerList {
	
	
	private List<Follower> followingUserList;
	
	private int followedUserId;
	
	
}
