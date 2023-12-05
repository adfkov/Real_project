package com.example.demo.comment.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.comment.mapper.CommentMapper;

@Service
public class CommentBO {
	@Autowired
	private CommentMapper commentMapper;
	
	public void addCommentByPostUserIdPostId(int postUserId, int postId, int userId, String commentText) {
		commentMapper.insertCommentByPostUserIdPostId(postUserId, postId, userId, commentText);
	}

}