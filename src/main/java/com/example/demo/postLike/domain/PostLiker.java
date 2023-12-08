package com.example.demo.postLike.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PostLiker {
	private int postUserId;
	private int postId;
	private int userId;
	private Date createdAt;
}
