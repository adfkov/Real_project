package com.example.demo.like.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Follower {
	
	private int followingUserId;
	private int followedUserId;
	private Date createdAt;
	
}
