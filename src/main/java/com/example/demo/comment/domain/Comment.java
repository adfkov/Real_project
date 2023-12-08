package com.example.demo.comment.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENRT
	private int id;
	private int postUserId;
	private int postId;
	private int userId;
	private String commentText;
	private Date createdAt;
	private Date updatedAt;
}
