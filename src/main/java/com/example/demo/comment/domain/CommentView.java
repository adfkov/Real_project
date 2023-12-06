package com.example.demo.comment.domain;

import java.util.Date;

import com.example.demo.user.Entity.UserEntity;

import lombok.Data;

@Data
public class CommentView {
	
	private Comment comment;
	
	private UserEntity user;

	
	


}
