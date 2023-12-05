package com.example.demo.comment.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommentView {
	
	private int postUserId;
	private int postId;
	private int userId;
	private String commentText;
	private Date createdAt;
	private Date updatedAt;
}
